package net.max_di.rebooting_world.common.events;

import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.entity.ModModelLayers;
import net.max_di.rebooting_world.common.entity.gingerbread.GingerBreadModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = RTW.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GINGER_BREAD, GingerBreadModel::createBodyLayer);
    }


}