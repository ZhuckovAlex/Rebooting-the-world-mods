package net.max_di.rebooting_world.common.entity.gingerbread.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.max_di.rebooting_world.RebootingWorld;
import net.max_di.rebooting_world.common.entity.gingerbread.custom.GingerBreadEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GingerBreadRenderer extends GeoEntityRenderer<GingerBreadEntity> {
    public GingerBreadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GingerBreadModel());
        this.shadowRadius = 1f;
    }

    @Override
    public RenderType getRenderType(GingerBreadEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));

    }

    @Override
    public ResourceLocation getTextureLocation(GingerBreadEntity instance) {
        return new ResourceLocation(RebootingWorld.MOD_ID, "textures/entity/ginger_bread.png");
    }



}
