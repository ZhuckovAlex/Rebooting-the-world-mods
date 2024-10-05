package net.max_di.rtw.common.recipes;

import net.max_di.rtw.RTW;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, RTW.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, RTW.MOD_ID);

    public static final Supplier<RecipeType<SawmillRecipe>> SAWMILL_TYPE = RECIPE_TYPE.register("sawmill", ()-> new RecipeType<>() {
    });

    public static final Supplier<RecipeSerializer<?>> SAWMILL_SERIALIZER = RECIPE_SERIALIZER.register("sawmilling", ()-> new SawmillRecipeSerializer(SawmillRecipe::new));
}
