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
    List<ItemLike> WOOD = List.of(
            Items.OAK_LOG,
            Items.DARK_OAK_LOG,
            Items.BIRCH_LOG,
            Items.SPRUCE_LOG,
            Items.JUNGLE_LOG,
            Items.ACACIA_LOG,
            Items.MANGROVE_LOG,
            Items.CHERRY_LOG);

    List<ItemLike> STRIPPED_WOOD = List.of(
            Items.STRIPPED_OAK_LOG,
            Items.STRIPPED_DARK_OAK_LOG,
            Items.STRIPPED_BIRCH_LOG,
            Items.STRIPPED_SPRUCE_LOG,
            Items.STRIPPED_JUNGLE_LOG,
            Items.STRIPPED_ACACIA_LOG,
            Items.STRIPPED_MANGROVE_LOG,
            Items.STRIPPED_CHERRY_LOG);

    List<ItemLike> PLANKS = List.of(
            Items.OAK_PLANKS,
            Items.DARK_OAK_PLANKS,
            Items.BIRCH_PLANKS,
            Items.SPRUCE_PLANKS,
            Items.JUNGLE_PLANKS,
            Items.ACACIA_PLANKS,
            Items.MANGROVE_PLANKS,
            Items.CHERRY_PLANKS);

    List<ItemLike> STAIRS = List.of(
            Items.OAK_STAIRS,
            Items.DARK_OAK_STAIRS,
            Items.BIRCH_STAIRS,
            Items.SPRUCE_STAIRS,
            Items.JUNGLE_STAIRS,
            Items.ACACIA_STAIRS,
            Items.MANGROVE_STAIRS,
            Items.CHERRY_STAIRS);

    List<ItemLike> SLABS = List.of(
            Items.OAK_SLAB,
            Items.DARK_OAK_SLAB,
            Items.BIRCH_SLAB,
            Items.SPRUCE_SLAB,
            Items.JUNGLE_SLAB,
            Items.ACACIA_SLAB,
            Items.MANGROVE_SLAB,
            Items.CHERRY_SLAB);



    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        for (int i = 0; i < WOOD.size(); i++) {
            sawmilling(consumer, RecipeCategory.MISC, WOOD.get(i), STRIPPED_WOOD.get(i), 1);
        }
        for (int i = 0; i < PLANKS.size(); i++) {
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), STAIRS.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), SLABS.get(i), 2);
        }

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
