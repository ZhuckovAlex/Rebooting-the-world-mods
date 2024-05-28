package net.max_di.rebooting_world.common.entity.gingerbread.client;

import net.max_di.rebooting_world.common.entity.gingerbread.custom.GingerBreadEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GingerBreadModel extends GeoModel<GingerBreadEntity> {
    @Override
    public ResourceLocation getAnimationResource(GingerBreadEntity entity) {
        return new ResourceLocation("rebooting_world", "animations/ginger_bread.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(GingerBreadEntity entity) {
        return new ResourceLocation("rebooting_world", "geo/ginger_bread.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GingerBreadEntity entity) {
        return new ResourceLocation("rebooting_world", "textures/entity/ginger_bread.png");
    }

}
