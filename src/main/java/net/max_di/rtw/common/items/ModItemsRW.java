package net.max_di.rtw.common.items;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.effect.ModEffects;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.items.custom.GingerBreadCreeperSpawnerItem;
import net.max_di.rtw.common.items.custom.GingerBreadManSpawnerItem;
import net.max_di.rtw.common.items.custom.RemainingItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsRW {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RTW.MOD_ID);

    //GINGERBREAD
    public static final RegistryObject<Item> GINGERBREAD_FORM = ITEMS.register("gingerbread_form",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD = ITEMS.register("raw_gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> RAW_CHOCOLATE_GINGERBREAD = ITEMS.register("raw_chocolate_gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD = ITEMS.register("gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> CHOCOLATE_GINGERBREAD = ITEMS.register("chocolate_gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD = ITEMS.register("glazed_gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> GLAZED_CHOCOLATE_GINGERBREAD = ITEMS.register("glazed_chocolate_gingerbread",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));


    //GINGERBREAD BRICKS
    public static final RegistryObject<Item> GINGERBREAD_FORM_BRICK = ITEMS.register("gingerbread_form_brick",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD_BRICK = ITEMS.register("raw_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> RAW_CHOCOLATE_GINGERBREAD_BRICK = ITEMS.register("raw_chocolate_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_BRICK = ITEMS.register("gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> CHOCOLATE_GINGERBREAD_BRICK = ITEMS.register("chocolate_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_BRICK = ITEMS.register("glazed_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> GLAZED_CHOCOLATE_GINGERBREAD_BRICK = ITEMS.register("glazed_chocolate_gingerbread_brick",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));



    //GINGERBREAD HEART
    public static final RegistryObject<Item> GINGERBREAD_FORM_HEART = ITEMS.register("gingerbread_form_heart",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD_HEART = ITEMS.register("raw_gingerbread_heart",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_HEART = ITEMS.register("gingerbread_heart",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_HEART = ITEMS.register("glazed_gingerbread_heart",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));



    //GINGERBREAD MAN
    public static final RegistryObject<Item> GINGERBREAD_FORM_MAN = ITEMS.register("gingerbread_form_man",
            () -> new RemainingItem(new Item.Properties().durability(1)));
    public static final RegistryObject<Item> RAW_GINGERBREAD_MAN = ITEMS.register("raw_gingerbread_man",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_MAN = ITEMS.register("gingerbread_man",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_MAN = ITEMS.register("glazed_gingerbread_man",
            () -> new GingerBreadManSpawnerItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));



    //GINGERBREAD PINE
    public static final RegistryObject<Item> GINGERBREAD_FORM_PINE = ITEMS.register("gingerbread_form_pine",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD_PINE = ITEMS.register("raw_gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_PINE = ITEMS.register("gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_PINE = ITEMS.register("glazed_gingerbread_pine",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));



    //GINGERBREAD CREEPER
    public static final RegistryObject<Item> GINGERBREAD_FORM_CREEPER = ITEMS.register("gingerbread_form_creeper",
            () -> new RemainingItem(new Item.Properties().durability(1)));
    public static final RegistryObject<Item> RAW_GINGERBREAD_CREEPER = ITEMS.register("raw_gingerbread_creeper",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_CREEPER = ITEMS.register("gingerbread_creeper",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_CREEPER = ITEMS.register("glazed_gingerbread_creeper",
            () -> new GingerBreadCreeperSpawnerItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F)
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).alwaysEat().build())));


    //GINGERBREAD NOTE
    public static final RegistryObject<Item> GINGERBREAD_FORM_NOTE = ITEMS.register("gingerbread_form_note",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD_NOTE = ITEMS.register("raw_gingerbread_note",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));

    public static final RegistryObject<Item> GINGERBREAD_NOTE = ITEMS.register("gingerbread_note",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_NOTE = ITEMS.register("glazed_gingerbread_note",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));


    //GINGERBREAD STAR
    public static final RegistryObject<Item> GINGERBREAD_FORM_STAR = ITEMS.register("gingerbread_form_star",
            () -> new RemainingItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> RAW_GINGERBREAD_STAR = ITEMS.register("raw_gingerbread_star",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> GINGERBREAD_STAR = ITEMS.register("gingerbread_star",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> GLAZED_GINGERBREAD_STAR = ITEMS.register("glazed_gingerbread_star",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat()
                    .effect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 200, 0, false, true, true), 1F).build())));




    //
    public static final RegistryObject<Item> GINGERBREAD_DOUGH = ITEMS.register("gingerbread_dough",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> CHOCOLATE_GINGERBREAD_DOUGH = ITEMS.register("chocolate_gingerbread_dough",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0, false, true, true), 1F).build())));
    public static final RegistryObject<Item> REPAIR_TEMPLATE = ITEMS.register("repair_template",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_MAN_SPAWN_EGG = ITEMS.register("gingerbread_man_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GINGERBREAD_MAN_ENTITY, 0XFFFFFF,0XFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_CREEPER_SPAWN_EGG = ITEMS.register("gingerbread_creeper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GINGERBREAD_CREEPER_ENTITY, 0XFFFFFF,0XFFFFFF, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
