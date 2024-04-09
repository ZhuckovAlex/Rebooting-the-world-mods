package net.max_di.rebooting_world.common;

import net.max_di.rebooting_world.RebootingWorld;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsRW {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RebootingWorld.MOD_ID);

    public static final RegistryObject<Item> GINGERBREAD_FORM_BRICK = ITEMS.register("gingerbread_form_brick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_FORM_ROUND = ITEMS.register("gingerbread_form_round",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_FORM_HEART = ITEMS.register("gingerbread_form_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_FORM_MAN = ITEMS.register("gingerbread_form_man",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_FORM_PINE = ITEMS.register("gingerbread_form_pine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_BRICK = ITEMS.register("gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GINGERBREAD_ROUND = ITEMS.register("gingerbread_round",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GINGERBREAD_HEART = ITEMS.register("gingerbread_heart",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GINGERBREAD_MAN = ITEMS.register("gingerbread_man",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GINGERBREAD_PINE = ITEMS.register("gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GINGERBREAD_DOUGH = ITEMS.register("gingerbread_dough",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_BRICK = ITEMS.register("raw_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_ROUND = ITEMS.register("raw_gingerbread_round",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_HEART = ITEMS.register("raw_gingerbread_heart",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_MAN = ITEMS.register("raw_gingerbread_man",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_PINE = ITEMS.register("raw_gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> RAW_GINGERBREAD_DOUGH = ITEMS.register("raw_gingerbread_dough",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_MAN = ITEMS.register("glazed_gingerbread_man",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_PINE = ITEMS.register("glazed_gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> REPAIR_TEMPLATE = ITEMS.register("repair_template",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
