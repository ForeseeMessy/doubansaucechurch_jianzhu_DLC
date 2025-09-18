package top.lacrus.doubansaucechurch;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Doubansaucechurch.MODID);

    public static final RegistryObject<SoundEvent> MUSIC_DISC_STREETS_IN_MIST =
            registerSoundEvent("music_disc_streets_in_mist");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Doubansaucechurch.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    
//    打印所有注册的声音事件
    public static void printSoundEvents() {
        System.out.println("Registered sound events:");
        for (RegistryObject<SoundEvent> soundEvent : SOUND_EVENTS.getEntries()) {
            System.out.println(soundEvent.getId());
        }
    }
}