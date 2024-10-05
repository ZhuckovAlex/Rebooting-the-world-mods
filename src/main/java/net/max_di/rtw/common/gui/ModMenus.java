package net.max_di.rtw.common.gui;

import net.max_di.rtw.RTW;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(Registries.MENU, RTW.MOD_ID);

    public static final Supplier<MenuType<SawmillMenu>> SAWMILL_MENU = MENU_TYPE.register("sawmill", ()-> new MenuType<SawmillMenu>(SawmillMenu::new, FeatureFlags.DEFAULT_FLAGS));
}