package net.max_di.rebooting_world.common.entity;

import net.max_di.rebooting_world.common.entity.gingerbread.GingerBreadModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModModelLayers {
    public static final ModelLayerLocation GINGER_BREAD = new ModelLayerLocation(new ResourceLocation("rebooting_world", "ginger_bread"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GINGER_BREAD, GingerBreadModel::createBodyLayer);
    }
}
