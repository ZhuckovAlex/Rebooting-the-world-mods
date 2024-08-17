package net.max_di.rebooting_world.common.recipes;

import net.max_di.rebooting_world.common.blocks.ModBlocksRW;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class SawmillRecipe extends SingleItemRecipe {
    public SawmillRecipe(ResourceLocation resourceLocation, String p_44479_, Ingredient ingredient, ItemStack itemStack) {
        super(ModRecipes.SAWMILL_TYPE.get(), ModRecipes.SAWMILL_SERIALIZER.get(), resourceLocation, p_44479_, ingredient, itemStack);
    }

    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocksRW.SAWMILL.get());
    }
    public Ingredient getIngridient(){
        return this.ingredient;
    }

    public ItemStack getResult(){
        return this.result;
    }
}