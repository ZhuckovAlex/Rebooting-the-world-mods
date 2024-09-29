package net.max_di.rtw.common.entity.gingerbread_man;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.max_di.rtw.RTW;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GingerBreadModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(RTW.MOD_ID, "gingerbread_man"), "main");
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart arm_r;
	private final ModelPart arm_l;
	private final ModelPart leg_l;
	private final ModelPart leg_r;

	public GingerBreadModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("root").getChild("body");
		this.head = body.getChild("head");
		this.arm_r = body.getChild("arm_r");
		this.arm_l = body.getChild("arm_l");
		this.leg_l = root.getChild("root").getChild("leg_l");
		this.leg_r = root.getChild("root").getChild("leg_r");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(1.0F, 28.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -10.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -1.5F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(8, 19).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(-2.0F, -4.0F, -1.0F));

		PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(18, 17).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(2.0F, -4.0F, -1.0F));

		PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(12, 11).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -1.0F));

		PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -10.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);

		this.animateWalk(GingerBreadAnimations.walking, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((GingerBreadEntity) entity).idleAnimationState, GingerBreadAnimations.idle, ageInTicks, 1f);
		this.animate(((GingerBreadEntity) entity).runAnimationState, GingerBreadAnimations.run, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}