package net.max_di.rtw.common.events;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.ModModelLayers;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadModel;
import net.max_di.rtw.common.entity.gingerbread_creeper.GingerBreadCreeperModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = RTW.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GINGERBREAD_MAN, GingerBreadModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GINGERBREAD_CREEPER, GingerBreadCreeperModel::createBodyLayer);
    }


}