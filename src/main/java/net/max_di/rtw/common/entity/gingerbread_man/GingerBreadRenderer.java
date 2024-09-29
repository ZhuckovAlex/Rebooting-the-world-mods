package net.max_di.rtw.common.entity.gingerbread_man;

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

public class GingerBreadRenderer extends MobRenderer<GingerBreadEntity, GingerBreadModel<GingerBreadEntity>> {

    private static final Map<GingerVariant, ResourceLocation> LOCATION_MAP =
            Util.make(Maps.newEnumMap(GingerVariant.class), map
            -> {
                map.put(GingerVariant.DUMB,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/dumb.png"));
                map.put(GingerVariant.HAPPY,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/happy.png"));
                map.put(GingerVariant.LEMON,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/lemon.png"));
                map.put(GingerVariant.LYBA,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/lyba.png"));
                map.put(GingerVariant.MOSKA,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/moska.png"));
                map.put(GingerVariant.SAD,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/sad.png"));
                map.put(GingerVariant.SIGMA,new ResourceLocation(RTW.MOD_ID, "textures/entity/gingerbread_man/sigma.png"));
            });

    public GingerBreadRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerBreadModel<>(context.bakeLayer(ModModelLayers.GINGERBREAD_MAN)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerBreadEntity pEntity) {
        return LOCATION_MAP.get(pEntity.getVariant());
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