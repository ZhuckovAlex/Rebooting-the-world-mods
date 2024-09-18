package net.max_di.rtw.common.entity;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModModelLayers {
    public static final ModelLayerLocation GINGERBREAD_MAN = new ModelLayerLocation(new ResourceLocation(RTW.MOD_ID, "gingerbread_man"), "main");
    public static final ModelLayerLocation GINGERBREAD_CREEPER = new ModelLayerLocation(new ResourceLocation(RTW.MOD_ID, "gingerbread_creeper"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GINGERBREAD_MAN, GingerBreadModel::createBodyLayer);
    }
}
