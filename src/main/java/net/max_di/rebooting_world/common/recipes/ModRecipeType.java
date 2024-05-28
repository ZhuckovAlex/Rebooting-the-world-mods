package net.max_di.rebooting_world.common.recipes;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;

public class ModRecipeType<T extends Recipe<?>> implements RecipeType<T> {
    // Define your custom recipe types here
    public static final ModRecipeType<SawmillRecipe> SAWMILL = new ModRecipeType<>("sawmill");

    private final String name;

    private ModRecipeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
