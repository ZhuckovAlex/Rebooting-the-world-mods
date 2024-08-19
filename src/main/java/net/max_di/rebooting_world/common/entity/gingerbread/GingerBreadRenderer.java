package net.max_di.rebooting_world.common.entity.gingerbread;

import com.mojang.blaze3d.vertex.PoseStack;
import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.entity.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GingerBreadRenderer extends MobRenderer<GingerBreadEntity, GingerBreadModel<GingerBreadEntity>>

    {
    public GingerBreadRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerBreadModel<>(context.bakeLayer(ModModelLayers.GINGER_BREAD)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerBreadEntity pEntity) {
        return new ResourceLocation(RTW.MOD_ID, "textures/entity/ginger_bread/ginger_bread.png");
    }

    @Override
    public void render(GingerBreadEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
            MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}