package top.lacrus.doubansaucechurch;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Doubansaucechurch.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TRACKING_FIREBALL.get(),
                (EntityRendererProvider.Context context) ->
                        new TrackingFireballRenderer(context));
    }

    // 简单的火球渲染器
    public static class TrackingFireballRenderer extends EntityRenderer<TrackingFireballEntity> {
        public TrackingFireballRenderer(EntityRendererProvider.Context context) {
            super(context);
        }

        @Override
        public ResourceLocation getTextureLocation(TrackingFireballEntity p_114482_) {
            return null;
        }

        // 添加自定义渲染逻辑(?
        // 暂时使用默认渲染（无模型）
    }
}