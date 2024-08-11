package com.darwin.hastePotion.sound;

import com.darwin.hastePotion.world.Haste;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Haste.MODID);

    public static final RegistryObject<SoundEvent> DOM_DISK_1 = registerSoundEvents("dom_disk_1");
    public static final RegistryObject<SoundEvent> DOM_DISK_2 = registerSoundEvents("dom_disk_2");
    public static final RegistryObject<SoundEvent> DOM_DISK_3 = registerSoundEvents("dom_disk_3");
    public static final RegistryObject<SoundEvent> DOM_DISK_4 = registerSoundEvents("dom_disk_4");
    public static final RegistryObject<SoundEvent> DOM_DISK_5 = registerSoundEvents("dom_disk_5");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Haste.MODID, name)));
    }
    public static void register(IEventBus iEventBus)
    {
        SOUND_EVENTS.register(iEventBus);
    }
}
