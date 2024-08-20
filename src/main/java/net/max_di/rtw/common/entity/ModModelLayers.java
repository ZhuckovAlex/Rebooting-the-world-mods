package net.max_di.rtw.common.entity;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.gingerbread.GingerBreadModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModModelLayers {
    public static final ModelLayerLocation GINGER_BREAD = new ModelLayerLocation(new ResourceLocation(RTW.MOD_ID, "ginger_bread"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GINGER_BREAD, GingerBreadModel::createBodyLayer);
    }
}
