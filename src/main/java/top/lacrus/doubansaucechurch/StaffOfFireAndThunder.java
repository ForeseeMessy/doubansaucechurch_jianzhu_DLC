package top.lacrus.doubansaucechurch;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Doubansaucechurch.MODID)
public class StaffOfFireAndThunder extends Item {

    private static final String CHARGE_TAG = "charging";
    private static final String CHARGE_TIME_TAG = "chargeTime";

    public StaffOfFireAndThunder(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.isShiftKeyDown()) {
            // 右键点击 - 开始蓄力
            if (!level.isClientSide) {
                setCharging(stack, true);
                setChargeTime(stack, 0);
            }
            return InteractionResultHolder.consume(stack);
        } else {
            // 左键点击 - 发射烈焰弹
            if (!level.isClientSide) {
                shootFireball(player, level);
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            }
            player.getCooldowns().addCooldown(this, 10);
            return InteractionResultHolder.success(stack);
        }
    }

    // 发射自动追踪的烈焰弹
    private void shootFireball(Player player, Level level) {
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

        // 创建自定义的追踪火球实体（需要另外创建）
        TrackingFireballEntity fireball = new TrackingFireballEntity(level, player);
        fireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
        level.addFreshEntity(fireball);
    }

    // 瞬移并产生爆炸
    private void teleportAndExplode(Player player, Level level) {
        // 计算瞬移方向
        Vec3 look = player.getLookAngle();
        Vec3 newPos = player.position().add(look.scale(8.0D));

        // 确保不会瞬移到方块内部
        BlockPos blockPos = new BlockPos((int) newPos.x, (int) newPos.y, (int) newPos.z);
        if (level.isEmptyBlock(blockPos) && level.isEmptyBlock(blockPos.above())) {
            player.teleportTo(newPos.x, newPos.y, newPos.z);

            // 在原点产生爆炸
            level.explode(null, player.getX(), player.getY(), player.getZ(), 2.0F,
                    Level.ExplosionInteraction.NONE);

            // 播放音效
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }

    // 释放大范围落雷
    private void castLightningStorm(Player player, Level level) {
        // 播放音效
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS, 1.0F, 1.0F);

        // 寻找范围内的怪物
        AABB area = new AABB(
                player.getX() - 10, player.getY() - 5, player.getZ() - 10,
                player.getX() + 10, player.getY() + 5, player.getZ() + 10
        );

        List<Monster> monsters = level.getEntitiesOfClass(Monster.class, area);
        Random random = new Random();

        for (Monster monster : monsters) {
            // 对每个怪物造成伤害
            monster.hurt(level.damageSources().magic(), 10.0F);

            // 在怪物位置显示随机粒子效果
            for (int i = 0; i < 10; i++) {
                double x = monster.getX() + (random.nextDouble() - 0.5) * 2.0;
                double y = monster.getY() + random.nextDouble() * 2.0;
                double z = monster.getZ() + (random.nextDouble() - 0.5) * 2.0;

                // 随机选择原版粒子效果
                switch (random.nextInt(10)) {
                    case 0 -> level.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
                    case 1 -> level.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
                    case 2 -> level.addParticle(ParticleTypes.HEART, x, y, z, 0, 0, 0);
                    case 3 -> level.addParticle(ParticleTypes.ENCHANT, x, y, z, 0, 0, 0);
                    case 4 -> level.addParticle(ParticleTypes.PORTAL, x, y, z, 0, 0, 0);
                    case 5 -> level.addParticle(ParticleTypes.CRIT, x, y, z, 0, 0, 0);
                    case 6 -> level.addParticle(ParticleTypes.WITCH, x, y, z, 0, 0, 0);
                    case 7 -> level.addParticle(ParticleTypes.DRAGON_BREATH, x, y, z, 0, 0, 0);
                    case 8 -> level.addParticle(ParticleTypes.END_ROD, x, y, z, 0, 0, 0);
                    case 9 -> level.addParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, 0, 0, 0);
                }
            }
        }

        // 在世界中显示闪电效果
        for (int i = 0; i < 5; i++) {
            double x = player.getX() + (random.nextDouble() - 0.5) * 20.0;
            double z = player.getZ() + (random.nextDouble() - 0.5) * 20.0;
            BlockPos pos = new BlockPos((int) x, (int) player.getY(), (int) z);

            // 寻找地面位置
            while (pos.getY() > 0 && !level.getBlockState(pos).isSolid()) {
                pos = pos.below();
            }

            if (pos.getY() > 0) {
                level.addParticle(ParticleTypes.ELECTRIC_SPARK,
                        x, pos.getY() + 1.0, z, 0, 0, 0);
            }
        }
    }

    // NBT数据操作方法
    private void setCharging(ItemStack stack, boolean charging) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean(CHARGE_TAG, charging);
    }

    private boolean isCharging(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(CHARGE_TAG);
    }

    private void setChargeTime(ItemStack stack, int time) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt(CHARGE_TIME_TAG, time);
    }

    private int getChargeTime(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getInt(CHARGE_TIME_TAG) : 0;
    }

    // 每帧更新蓄力状态
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();

            for (InteractionHand hand : InteractionHand.values()) {
                ItemStack stack = player.getItemInHand(hand);

                if (stack.getItem() instanceof StaffOfFireAndThunder) {
                    StaffOfFireAndThunder staff = (StaffOfFireAndThunder) stack.getItem();

                    if (staff.isCharging(stack)) {
                        int chargeTime = staff.getChargeTime(stack) + 1;
                        staff.setChargeTime(stack, chargeTime);

                        // 显示蓄力粒子效果
                        if (level.isClientSide) {
                            Vec3 pos = player.position().add(0, player.getEyeHeight(), 0);
                            Vec3 look = player.getLookAngle();

                            for (int i = 0; i < 3; i++) {
                                double x = pos.x + (level.random.nextDouble() - 0.5) * 0.5;
                                double y = pos.y + (level.random.nextDouble() - 0.5) * 0.5;
                                double z = pos.z + (level.random.nextDouble() - 0.5) * 0.5;

                                level.addParticle(ParticleTypes.ELECTRIC_SPARK,
                                        x, y, z, look.x * 0.2, look.y * 0.2, look.z * 0.2);
                            }
                        }

                        // 蓄力完成（3秒 = 60 ticks）
                        if (chargeTime >= 60) {
                            staff.setCharging(stack, false);

                            if (!level.isClientSide) {
                                staff.castLightningStorm(player, level);
                                stack.hurtAndBreak(5, player, (p) -> p.broadcastBreakEvent(hand));
                            }

                            player.getCooldowns().addCooldown(staff, 100);
                        }

                        // 如果玩家停止使用物品，取消蓄力
                        if (!player.isUsingItem()) {
                            staff.setCharging(stack, false);

                            // 如果蓄力时间短于完成时间但长于最小时间，执行瞬移
                            if (chargeTime > 5 && chargeTime < 60) {
                                if (!level.isClientSide) {
                                    staff.teleportAndExplode(player, level);
                                    stack.hurtAndBreak(2, player, (p) -> p.broadcastBreakEvent(hand));
                                }
                                player.getCooldowns().addCooldown(staff, 20);
                            }
                        }
                    }
                }
            }
        }
    }
}