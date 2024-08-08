package com.darwin.hastePotion.item;

import com.darwin.hastePotion.world.Haste;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.core.Registry.REGISTRY;

public class ModPotions extends Potion {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Haste.MODID);

    public static final RegistryObject<Potion> HASTE_POTION = POTIONS.register("haste_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    public static final RegistryObject<Potion> HASTE_POTION_STRONG = POTIONS.register("haste_potion_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 2)));
    public static final RegistryObject<Potion> HASTE_POTION_LONG = POTIONS.register("haste_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 7200, 0)));
    public static void register(IEventBus eventBus)
    {
        POTIONS.register(eventBus);
    }
}
