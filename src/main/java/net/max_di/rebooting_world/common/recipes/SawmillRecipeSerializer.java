package net.max_di.rebooting_world.common.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.Nullable;



@Mod.EventBusSubscriber(modid = "rebooting_world", bus = Mod.EventBusSubscriber.Bus.MOD)
public class SawmillRecipeSerializer implements RecipeSerializer<SawmillRecipe> {

    // Создаем DeferredRegister для RecipeSerializer
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "rebooting_world");

    // Регистрируем сериализатор
    public static final RegistryObject<RecipeSerializer<SawmillRecipe>> SAWMILL_SERIALIZER = SERIALIZERS.register("sawmill", SawmillRecipeSerializer::new);

    @Override
    public SawmillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        // Реализуйте здесь логику десериализации SawmillRecipe из JSON
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, SawmillRecipe recipe) {
        // Реализуйте здесь логику сериализации SawmillRecipe в сеть
    }

    @Override
    public SawmillRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        // Реализуйте здесь логику десериализации SawmillRecipe из сети
        return null;
    }

    public static void register(IEventBus eventBus) {
        // Регистрируем сериализаторы рецептов через IEventBus
        SERIALIZERS.register(eventBus);
    }
}