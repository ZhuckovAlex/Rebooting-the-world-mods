package net.max_di.rebooting_world.common.gui;

import net.max_di.rebooting_world.RTW;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RTW.MOD_ID);

    public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL_MENU = MENU_TYPE.register("sawmill", ()-> new MenuType<SawmillMenu>(SawmillMenu::new, FeatureFlags.DEFAULT_FLAGS));
}