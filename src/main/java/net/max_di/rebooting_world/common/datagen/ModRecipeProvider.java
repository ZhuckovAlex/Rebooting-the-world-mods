package net.max_di.rebooting_world.common.datagen;

import net.max_di.rebooting_world.common.utils.ModSingleItemRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    List<ItemLike> SPRUCE = List.of(
            Items.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_WOOD, Items.STRIPPED_SPRUCE_WOOD);

    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        sawmilling(consumer, RecipeCategory.MISC, Items.ACACIA_BOAT, Items.ACACIA_CHEST_BOAT, 2);
        sawmilling(consumer, RecipeCategory.MISC, SPRUCE, Items.ACACIA_CHEST_BOAT, 2);

    }
    public static void sawmilling(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike ingredient, ItemLike result, int count){
        ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(ingredient), category, result, count).unlockedBy(getHasName(result), has(result)).save(consumer, getConversionRecipeName(ingredient, result) + "_sawmilling");
    }
    public static void sawmilling(Consumer<FinishedRecipe> consumer, RecipeCategory category, List<ItemLike> ingredients, ItemLike result, int count){
        for(ItemLike itemLike : ingredients){
        ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(itemLike), category, result, count).unlockedBy(getHasName(itemLike), has(itemLike)).save(consumer, getConversionRecipeName(itemLike, result) + "_sawmilling");
    }
    }
}
