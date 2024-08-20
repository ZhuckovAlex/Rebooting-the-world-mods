package net.max_di.rtw.common.recipes;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;


public class SawmillRecipeSerializer implements RecipeSerializer<SawmillRecipe> {
    final SawmillRecipeSerializer.SingleItemMaker factory;

    public SawmillRecipeSerializer(SawmillRecipeSerializer.SingleItemMaker factory) {
        this.factory = factory;
    }

    @Override
    public SawmillRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
        String s = GsonHelper.getAsString(jsonObject, "group", "");
        Ingredient ingredient;
        if (GsonHelper.isArrayNode(jsonObject, "ingredient")) {
            ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(jsonObject, "ingredient"), false);
        } else {
            ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(jsonObject, "ingredient"), false);
        }

        String s1 = GsonHelper.getAsString(jsonObject, "result");
        int i = GsonHelper.getAsInt(jsonObject, "count");
        ItemStack itemstack = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(s1)), i);
        return this.factory.create(resourceLocation, s, ingredient, itemstack);
    }

    @Override
    public @Nullable SawmillRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
        String s = friendlyByteBuf.readUtf();
        Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
        ItemStack itemstack = friendlyByteBuf.readItem();
        return this.factory.create(resourceLocation, s, ingredient, itemstack);
    }

    @Override
    public void toNetwork(FriendlyByteBuf friendlyByteBuf, SawmillRecipe recipe) {
        friendlyByteBuf.writeUtf(recipe.getGroup());
        recipe.getIngridient().toNetwork(friendlyByteBuf);
        friendlyByteBuf.writeItem(recipe.getResult());
    }
    interface SingleItemMaker<T extends SawmillRecipe> {
        T create(ResourceLocation p_44455_, String p_44456_, Ingredient p_44457_, ItemStack p_44458_);
    }
}