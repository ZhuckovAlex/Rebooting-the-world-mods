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
    List<ItemLike> LOGS = List.of(
            Items.OAK_LOG,
            Items.DARK_OAK_LOG,
            Items.BIRCH_LOG,
            Items.SPRUCE_LOG,
            Items.JUNGLE_LOG,
            Items.ACACIA_LOG,
            Items.MANGROVE_LOG,
            Items.CHERRY_LOG);

    List<ItemLike> STRIPPED_LOGS = List.of(
            Items.STRIPPED_OAK_LOG,
            Items.STRIPPED_DARK_OAK_LOG,
            Items.STRIPPED_BIRCH_LOG,
            Items.STRIPPED_SPRUCE_LOG,
            Items.STRIPPED_JUNGLE_LOG,
            Items.STRIPPED_ACACIA_LOG,
            Items.STRIPPED_MANGROVE_LOG,
            Items.STRIPPED_CHERRY_LOG);

    List<ItemLike> BOATS = List.of(
            Items.OAK_BOAT,
            Items.DARK_OAK_BOAT,
            Items.BIRCH_BOAT,
            Items.SPRUCE_BOAT,
            Items.JUNGLE_BOAT,
            Items.ACACIA_BOAT,
            Items.MANGROVE_BOAT,
            Items.CHERRY_BOAT,
            Items.BAMBOO_RAFT);

    List<ItemLike> WOOD = List.of(
            Items.OAK_WOOD,
            Items.DARK_OAK_WOOD,
            Items.BIRCH_WOOD,
            Items.SPRUCE_WOOD,
            Items.JUNGLE_WOOD,
            Items.ACACIA_WOOD,
            Items.MANGROVE_WOOD,
            Items.CHERRY_WOOD,
            Items.BAMBOO_BLOCK);

    List<ItemLike> STRIPPED_WOOD = List.of(
            Items.STRIPPED_OAK_WOOD,
            Items.STRIPPED_DARK_OAK_WOOD,
            Items.STRIPPED_BIRCH_WOOD,
            Items.STRIPPED_SPRUCE_WOOD,
            Items.STRIPPED_JUNGLE_WOOD,
            Items.STRIPPED_ACACIA_WOOD,
            Items.STRIPPED_MANGROVE_WOOD,
            Items.STRIPPED_CHERRY_WOOD,
            Items.STRIPPED_BAMBOO_BLOCK);

    List<ItemLike> PLANKS = List.of(
            Items.OAK_PLANKS,
            Items.DARK_OAK_PLANKS,
            Items.BIRCH_PLANKS,
            Items.SPRUCE_PLANKS,
            Items.JUNGLE_PLANKS,
            Items.ACACIA_PLANKS,
            Items.MANGROVE_PLANKS,
            Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS);

    List<ItemLike> STAIRS = List.of(
            Items.OAK_STAIRS,
            Items.DARK_OAK_STAIRS,
            Items.BIRCH_STAIRS,
            Items.SPRUCE_STAIRS,
            Items.JUNGLE_STAIRS,
            Items.ACACIA_STAIRS,
            Items.MANGROVE_STAIRS,
            Items.CHERRY_STAIRS,
            Items.BAMBOO_STAIRS);

    List<ItemLike> SLABS = List.of(
            Items.OAK_SLAB,
            Items.DARK_OAK_SLAB,
            Items.BIRCH_SLAB,
            Items.SPRUCE_SLAB,
            Items.JUNGLE_SLAB,
            Items.ACACIA_SLAB,
            Items.MANGROVE_SLAB,
            Items.CHERRY_SLAB,
            Items.BAMBOO_SLAB);

    List<ItemLike> FENCES = List.of(
            Items.OAK_FENCE,
            Items.DARK_OAK_FENCE,
            Items.BIRCH_FENCE,
            Items.SPRUCE_FENCE,
            Items.JUNGLE_FENCE,
            Items.ACACIA_FENCE,
            Items.MANGROVE_FENCE,
            Items.CHERRY_FENCE,
            Items.BAMBOO_FENCE);

    List<ItemLike> FENCE_GATES = List.of(
            Items.OAK_FENCE_GATE,
            Items.DARK_OAK_FENCE_GATE,
            Items.BIRCH_FENCE_GATE,
            Items.SPRUCE_FENCE_GATE,
            Items.JUNGLE_FENCE_GATE,
            Items.ACACIA_FENCE_GATE,
            Items.MANGROVE_FENCE_GATE,
            Items.CHERRY_FENCE_GATE,
            Items.BAMBOO_FENCE_GATE);


    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        for (int i = 0; i < WOOD.size(); i++) {
            sawmilling(consumer, RecipeCategory.MISC, WOOD.get(i), STRIPPED_WOOD.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, WOOD.get(i), PLANKS.get(i), 4);
            sawmilling(consumer, RecipeCategory.MISC, WOOD.get(i), BOATS.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, STRIPPED_WOOD.get(i), PLANKS.get(i), 4);
            sawmilling(consumer, RecipeCategory.MISC, STRIPPED_WOOD.get(i), BOATS.get(i), 1);
        }
        for (int i = 0; i < LOGS.size(); i++) {
            sawmilling(consumer, RecipeCategory.MISC, LOGS.get(i), STRIPPED_LOGS.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, LOGS.get(i), PLANKS.get(i), 4);
            sawmilling(consumer, RecipeCategory.MISC, LOGS.get(i), BOATS.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, STRIPPED_LOGS.get(i), PLANKS.get(i), 4);
            sawmilling(consumer, RecipeCategory.MISC, STRIPPED_LOGS.get(i), BOATS.get(i), 1);
        }
        for (int i = 0; i < PLANKS.size(); i++) {
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), STAIRS.get(i), 1);
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), SLABS.get(i), 2);
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), FENCES.get(i), 2);
            sawmilling(consumer, RecipeCategory.MISC, PLANKS.get(i), FENCE_GATES.get(i), 1);
        }

    }
    public static void sawmilling(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike ingredient, ItemLike result, int count){
        ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(ingredient), category, result, count).unlockedBy(getHasName(result), has(result)).save(consumer, getConversionRecipeName(result, ingredient) + "_sawmilling");
    }
    public static void sawmilling(Consumer<FinishedRecipe> consumer, RecipeCategory category, List<ItemLike> ingredients, ItemLike result, int count){
        for(ItemLike itemLike : ingredients){
        ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(itemLike), category, result, count).unlockedBy(getHasName(itemLike), has(itemLike)).save(consumer, getConversionRecipeName(result, itemLike) + "_sawmilling");
    }
    }
}
