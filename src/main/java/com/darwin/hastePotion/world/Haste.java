package com.darwin.hastePotion.world;

import com.darwin.hastePotion.item.ModItems;
import com.darwin.hastePotion.item.ModPotions;
import com.darwin.hastePotion.sound.ModSounds;
import com.darwin.hastePotion.util.BetterBrewingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Haste.MODID)
public class Haste {

    public static final String MODID = "hastepotion";
    private static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    // Create a DeferredRegister to register items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public Haste() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the common setup method
        modEventBus.addListener(this::setup);

        // Register the item
        ITEMS.register(modEventBus);
        ModPotions.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);

        // Register the client setup method
        modEventBus.addListener(this::clientSetup);
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(
                    Potions.STRENGTH,
                    ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "sugar")),
                    ModPotions.HASTE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(
                    ModPotions.HASTE_POTION.get(),
                    ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "redstone")),
                    ModPotions.HASTE_POTION_LONG.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(
                    ModPotions.HASTE_POTION.get(),
                    ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "glowstone_dust")),
                    ModPotions.HASTE_POTION_STRONG.get()));
        });

    }

    private void clientSetup(FMLClientSetupEvent event) {
        // Some client-side setup code
    }
}
