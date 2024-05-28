package net.max_di.rebooting_world.common.gui;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import java.util.function.Supplier;

public class ModMenuType extends MenuType<AbstractContainerMenu> {
    public ModMenuType(MenuSupplier p_267054_, FeatureFlagSet p_266909_) {
        super(p_267054_, p_266909_);
    }

    public static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuSupplier<T> supplier) {
        return new MenuType<>(supplier, FeatureFlagSet.of());
    }

    public static final MenuType<SawmillMenu> SAWMILL = register("sawmill", SawmillMenu::new);
}