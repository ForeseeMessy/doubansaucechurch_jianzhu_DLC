package top.lacrus.doubansaucechurch;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Doubansaucechurch.MODID);

    public static final RegistryObject<EntityType<TrackingFireballEntity>> TRACKING_FIREBALL =
            ENTITIES.register("tracking_fireball",
                    () -> EntityType.Builder.<TrackingFireballEntity>of(TrackingFireballEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("tracking_fireball"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}