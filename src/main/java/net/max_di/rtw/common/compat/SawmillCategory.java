package net.max_di.rtw.common.compat;

import mezz.jei.api.constants.ModIds;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.recipes.SawmillRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SawmillCategory implements IRecipeCategory<SawmillRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(RTW.MOD_ID, "sawmilling");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ModIds.JEI_ID, "textures/jei/gui/gui_vanilla.png");

    public static final RecipeType<SawmillRecipe> SAWMILL_TYPE = new RecipeType<>(UID, SawmillRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SawmillCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 220, 82, 34);
        this.icon = helper.createDrawableItemStack(new ItemStack(ModBlocksRW.SAWMILL.get()));
    }

    @Override
    public RecipeType<SawmillRecipe> getRecipeType() {
        return SAWMILL_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.rtw.sawmill");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getWidth() {
        return 82;
    }

    @Override
    public int getHeight() {
        return 34;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SawmillRecipe recipe, IFocusGroup focusGroup) {
            builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addIngredients(recipe.getIngredients().get(0));
            builder.addSlot(RecipeIngredientRole.OUTPUT, 61,  9).addItemStack(recipe.getResult());
    }
}
