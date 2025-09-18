package top.lacrus.doubansaucechurch;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class TrackingFireballEntity extends AbstractHurtingProjectile {
    private int lifespan = 100;
    private LivingEntity target;

    public TrackingFireballEntity(EntityType<? extends AbstractHurtingProjectile> type, Level level) {
        super(type, level);
    }

    public TrackingFireballEntity(Level level, LivingEntity owner) {
        super(ModEntities.TRACKING_FIREBALL.get(), owner,
                owner.getLookAngle().x, owner.getLookAngle().y, owner.getLookAngle().z, level);
    }

    @Override
    public void tick() {
        super.tick();

        // 减少寿命
        if (--this.lifespan <= 0) {
            this.discard();
            return;
        }

        // 寻找目标
        if (this.target == null || !this.target.isAlive()) {
            AABB area = this.getBoundingBox().inflate(10.0D);
            List<Monster> monsters = this.level().getEntitiesOfClass(Monster.class, area);

            if (!monsters.isEmpty()) {
                this.target = monsters.get(this.level().random.nextInt(monsters.size()));
            }
        }

        // 追踪目标
        if (this.target != null) {
            Vec3 targetPos = this.target.position().add(0, this.target.getBbHeight() / 2, 0);
            Vec3 currentPos = this.position();
            Vec3 direction = targetPos.subtract(currentPos).normalize();

            // 调整飞行方向
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(direction.scale(0.1)));
        }

        // 粒子效果
        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.FLAME,
                    this.getX(), this.getY(), this.getZ(),
                    0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide) {
            // 爆炸效果
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F,
                    Level.ExplosionInteraction.NONE);

            // 播放音效
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.0F);

            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!this.level().isClientSide) {
            // 对击中的实体造成伤害
            result.getEntity().hurt(this.damageSources().magic(), 8.0F);

            // 如果是生物，设置着火
            if (result.getEntity() instanceof LivingEntity) {
                result.getEntity().setSecondsOnFire(5);
            }
        }
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }
}