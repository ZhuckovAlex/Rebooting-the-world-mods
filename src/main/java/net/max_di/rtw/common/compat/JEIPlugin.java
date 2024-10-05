package net.max_di.rtw.common.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.max_di.rtw.RTW;
import net.max_di.rtw.client.gui.screens.SawmillScreen;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.recipes.ModRecipes;
import net.max_di.rtw.common.recipes.SawmillRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    public static final RecipeType<SawmillRecipe> SAWMILL_TYPE = RecipeType.create(RTW.MOD_ID, "sawmilling", SawmillRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "rtw_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SawmillCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<SawmillRecipe> sawmillRecipes = new ArrayList<>();
        sawmillRecipes.addAll(
            recipeManager.getAllRecipesFor(ModRecipes.SAWMILL_TYPE.get())
                    .stream().map(r-> r.value()).toList());
        registration.addRecipes(SawmillCategory.SAWMILL_TYPE, sawmillRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SawmillScreen.class,7,5,33,8, SawmillCategory.SAWMILL_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocksRW.SAWMILL.get()), SAWMILL_TYPE);
    }
}
