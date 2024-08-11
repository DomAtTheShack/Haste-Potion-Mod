package com.darwin.hastePotion.item;

import com.darwin.hastePotion.sound.ModSounds;
import com.darwin.hastePotion.world.Haste;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Haste.MODID);


    public static final RegistryObject<Item> DOM_DISK_1 = ITEMS.register("dom_disk_1",
            () -> new RecordItem(6, ModSounds.DOM_DISK_1, new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC), 3920)
            {
                @Override
                public void fillItemCategory(CreativeModeTab tab, net.minecraft.core.NonNullList<ItemStack> items)
                {
                    if (this.allowedIn(tab)) {
                        int index = 0;
                        for (ItemStack item : items) {
                            if (item.getItem() instanceof RecordItem) {
                                index = items.indexOf(item) + 1;
                            }
                        }
                        items.add(index, new ItemStack(this));
                    }
                }
            });
    public static final RegistryObject<Item> DOM_DISK_2 = ITEMS.register("dom_disk_2",
            () -> new RecordItem(6, ModSounds.DOM_DISK_2, new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC), 3920)
            {
                @Override
                public void fillItemCategory(CreativeModeTab tab, net.minecraft.core.NonNullList<ItemStack> items)
                {
                    if (this.allowedIn(tab)) {
                        int index = 0;
                        for (ItemStack item : items) {
                            if (item.getItem() instanceof RecordItem) {
                                index = items.indexOf(item) + 1;
                            }
                        }
                        items.add(index, new ItemStack(this));
                    }
                }
            });
    public static final RegistryObject<Item> DOM_DISK_3 = ITEMS.register("dom_disk_3",
            () -> new RecordItem(6, ModSounds.DOM_DISK_3, new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC), 3920)
            {
                @Override
                public void fillItemCategory(CreativeModeTab tab, net.minecraft.core.NonNullList<ItemStack> items)
                {
                    if (this.allowedIn(tab)) {
                        int index = 0;
                        for (ItemStack item : items) {
                            if (item.getItem() instanceof RecordItem) {
                                index = items.indexOf(item) + 1;
                            }
                        }
                        items.add(index, new ItemStack(this));
                    }
                }
            });
    public static final RegistryObject<Item> DOM_DISK_4 = ITEMS.register("dom_disk_4",
            () -> new RecordItem(6, ModSounds.DOM_DISK_4, new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC), 3920)
            {
                @Override
                public void fillItemCategory(CreativeModeTab tab, net.minecraft.core.NonNullList<ItemStack> items)
                {
                    if (this.allowedIn(tab)) {
                        int index = 0;
                        for (ItemStack item : items) {
                            if (item.getItem() instanceof RecordItem) {
                                index = items.indexOf(item) + 1;
                            }
                        }
                        items.add(index, new ItemStack(this));
                    }
                }
            });
    public static final RegistryObject<Item> DOM_DISK_5 = ITEMS.register("dom_disk_5",
            () -> new RecordItem(6, ModSounds.DOM_DISK_5, new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC), 3920)
            {
                @Override
                public void fillItemCategory(CreativeModeTab tab, net.minecraft.core.NonNullList<ItemStack> items)
                {
                    if (this.allowedIn(tab)) {
                        int index = 0;
                        for (ItemStack item : items) {
                            if (item.getItem() instanceof RecordItem) {
                                index = items.indexOf(item) + 1;
                            }
                        }
                        items.add(index, new ItemStack(this));
                    }
                }
            });

    public static void  register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
