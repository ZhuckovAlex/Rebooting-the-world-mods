package net.max_di.rebooting_world.common.recipes;

import net.max_di.rebooting_world.common.blocks.ModBlocksRW;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class SawmillRecipe extends SingleItemRecipe {
    public SawmillRecipe(ResourceLocation p_44478_, String p_44479_, Ingredient p_44480_, ItemStack p_44481_) {
        super(ModRecipeType.SAWMILL, ModRecipeSerializer.SAWMILL, p_44478_, p_44479_, p_44480_, p_44481_);
    }

    public boolean matches(Container p_44483_, Level p_44484_) {
        return this.ingredient.test(p_44483_.getItem(0));
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocksRW.SAWMILL.get());
    }
}