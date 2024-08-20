package net.max_di.rtw;

import net.max_di.rtw.client.ModCreativeTabRW;
import net.max_di.rtw.client.gui.screens.SawmillScreen;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.gingerbread.GingerBreadRenderer;
import net.max_di.rtw.common.gui.ModMenus;
import net.max_di.rtw.common.items.ModItemsRW;
import net.max_di.rtw.common.recipes.ModRecipes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RTW.MOD_ID)
public class RTW {
    public static final String MOD_ID = "rtw";

    public RTW(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::clientSetup);
        ModEntities.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZER.register(modEventBus);
        ModRecipes.RECIPE_TYPE.register(modEventBus);
        ModMenus.MENU_TYPE.register(modEventBus);
        ModCreativeTabRW.register(modEventBus);
        ModBlocksRW.register(modEventBus);
        ModItemsRW.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        MenuScreens.register(ModMenus.SAWMILL_MENU.get(), SawmillScreen::new);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.GINGER_ENTITY.get(), GingerBreadRenderer::new);

        }
    }
}
