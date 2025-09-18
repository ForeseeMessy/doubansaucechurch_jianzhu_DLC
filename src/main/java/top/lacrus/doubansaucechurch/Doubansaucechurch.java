package top.lacrus.doubansaucechurch;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// 导入新添加的类
import top.lacrus.doubansaucechurch.ModSoundEvents;
import top.lacrus.doubansaucechurch.ModEntities;

@Mod(Doubansaucechurch.MODID)
public class Doubansaucechurch {

    public static final String MODID = "doubansaucechurch";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Doubansaucechurch() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        // 注册物品
        ModItems.register(modEventBus);

        // 注册创造模式标签页
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // 注册声音事件
        ModSoundEvents.register(modEventBus);

        // 注册实体 - 这是新添加的注册
        ModEntities.register(modEventBus);

        // 注册配置
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // 通用设置代码放在这里
        // 注册网络数据包
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // 服务器启动时的初始化代码放在这里
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // 客户端代码可以放在这里
            // 注册渲染器、键位绑定
        }
    }
}