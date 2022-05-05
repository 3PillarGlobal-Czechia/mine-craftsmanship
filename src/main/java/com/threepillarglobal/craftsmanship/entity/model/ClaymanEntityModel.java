package com.threepillarglobal.craftsmanship.entity.model;

import com.google.common.collect.ImmutableList;
import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.entity.ClaymanEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ClaymanEntityModel extends AnimalModel<ClaymanEntity> {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(new Identifier(Craftsmanship.MOD_ID, "clayman"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart tail;

    public ClaymanEntityModel(ModelPart root) {
        super();
        this.root = root;
        this.head = root.getChild("head");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
        this.tail = this.head.getChild("tail");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create()
                .uv(0 ,0)
                .cuboid(-8F, 0, -8F, 16F, 16F, 16F), ModelTransform.pivot(0, 0, 0));

        modelPartData.addChild("right_leg", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-2F, 0, -1F, 2F, 16F, 2F), ModelTransform.pivot(-8F, 8F, 0F));

        modelPartData.addChild("left_leg", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(0, 0, -1F, 2F, 16F, 2F), ModelTransform.pivot(8F, 8F, 0F));

        ModelPartData headModelPartData = modelPartData.getChild("head");
        headModelPartData.addChild("right_ear", ModelPartBuilder.create()
                .uv(0, 2)
                .cuboid(6F, -2F, -6F, 2F, 2F, 1F), ModelTransform.NONE);

        headModelPartData.addChild("left_ear", ModelPartBuilder.create()
                .uv(0, 2)
                .cuboid(-8F, -2F, -6F, 2F, 2F, 1F), ModelTransform.NONE);

        headModelPartData.addChild("tail", ModelPartBuilder.create()
                .uv(0, 16)
                .cuboid(-1F, 4F, 0, 2F, 2F, 8F), ModelTransform.pivot(0, 8F, 8F));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.root);
    }

    @Override
    public void setAngles(ClaymanEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.leftLeg.roll = -0.2F;
        this.rightLeg.roll = 0.2F;

        if (entity.getVelocity().lengthSquared() < 0.01D) {
            this.head.pitch = headPitch * 0.01F;
            this.leftLeg.pitch = 0F;
            this.rightLeg.pitch = 0F;
            this.tail.pitch = -0.25F;
        }
        else {
            this.head.pitch = 0.1F * MathHelper.sin(animationProgress * 0.5F + 1F);
            this.leftLeg.pitch = 0.5F * MathHelper.sin(animationProgress * 0.5F + 1F);
            this.rightLeg.pitch = 0.5F * MathHelper.sin(animationProgress * 0.5F + 1F);
            this.tail.pitch = -0.25F * MathHelper.sin(animationProgress * 0.5F + 1F);
        }
    }
}
