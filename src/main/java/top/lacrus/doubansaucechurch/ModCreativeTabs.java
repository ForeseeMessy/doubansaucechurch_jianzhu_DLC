package top.lacrus.doubansaucechurch;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Doubansaucechurch.MODID);
    
    public static final RegistryObject<CreativeModeTab> DOUBANSAUCECHURCH_TAB = CREATIVE_MODE_TABS.register("doubansaucechurch_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.doubansaucechurch.doubansaucechurch_tab")) // 标签名称
                    .icon(() -> new ItemStack(ModItems.BISHOP_HELMET.get())) // 标签图标
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BISHOP_HELMET.get());    //2025.9.6新增：主教头盔
                        output.accept(ModItems.BISHOP_CHESTPLATE.get());//2025.9.6新增：主教胸甲
                        output.accept(ModItems.BISHOP_LEGGINGS.get());  //2025.9.6新增：主教裤子
                        output.accept(ModItems.BISHOP_BOOTS.get());     //2025.9.6新增：主教靴子
                        output.accept(ModItems.BISHOP_SWORD.get());     //2025.9.6新增：主教剑
                        output.accept(ModItems.ENDER_SAUCE_INGOT.get()); // 2025.9.7新增：末影蘸酱锭
                        output.accept(ModItems.FAITH_LEAVES.get());      // 2025.9.7新增：信仰树叶
                        output.accept(ModItems.DIVINE_SAPLING.get());    // 2025.9.7新增：神灵树苗
                        output.accept(ModItems.ABYSSAL_CORRUPTED_SAPLING.get());    // 2025.9.7新增：受到深渊侵蚀的神灵树树苗
                        output.accept(ModItems.ABYSSAL_CORRUPTING_LEAVES.get());    // 2025.9.7新增：深渊侵蚀中的神灵树树叶
                        output.accept(ModItems.ABYSSAL_CORRUPTED_LEAVES.get());     // 2025.9.7新增：深渊侵蚀的神灵树树叶
                        output.accept(ModItems.MUSIC_DISC_STREETS_IN_MIST.get());  // 2025.9.10新增：雾中缀连的街道唱片
                        output.accept(ModItems.STAFF_OF_FIRE_AND_THUNDER.get());    // 2025.9.10新增：雷与火之杖
                    })
                    .build()
    );
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

} 