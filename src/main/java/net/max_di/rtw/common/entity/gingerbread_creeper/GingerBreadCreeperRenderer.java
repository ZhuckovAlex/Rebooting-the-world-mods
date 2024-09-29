package net.max_di.rtw.common.entity.gingerbread_creeper;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.ModModelLayers;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class GingerBreadCreeperRenderer extends MobRenderer<GingerBreadCreeperEntity, GingerBreadCreeperModel<GingerBreadCreeperEntity>> {

    private static final Map<GingerCreeperVariant, ResourceLocation> LOCATION_MAP =
            Util.make(Maps.newEnumMap(GingerCreeperVariant.class), map
            -> {
                map.put(GingerCreeperVariant.ANGRY,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_creeper/angry.png"));
                map.put(GingerCreeperVariant.BOBIK,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_creeper/bobik.png"));
                map.put(GingerCreeperVariant.SAD,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_creeper/sad.png"));
                map.put(GingerCreeperVariant.SILLY,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_creeper/silly.png"));
            });

    public GingerBreadCreeperRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerBreadCreeperModel<>(context.bakeLayer(ModModelLayers.GINGERBREAD_CREEPER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerBreadCreeperEntity pEntity) {
        return LOCATION_MAP.get(pEntity.getVariant());
    }

    @Override
    public void render(GingerBreadCreeperEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}