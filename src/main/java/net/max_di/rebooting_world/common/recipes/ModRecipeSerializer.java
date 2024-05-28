package net.max_di.rebooting_world.common.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;

public interface ModRecipeSerializer extends RecipeSerializer<SawmillRecipe> {
    RecipeSerializer<SawmillRecipe> SAWMILL = new SawmillRecipeSerializer();

    // Other custom serializers can be defined similarly
}
