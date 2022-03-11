package com.threepillarglobal.craftsmanship.entity.model;

import com.google.common.collect.ImmutableList;
import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.entity.BoarEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BoarEntityModel extends QuadrupedEntityModel<BoarEntity> {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(new Identifier(Craftsmanship.MOD_ID, "boar"), "main");

    private final ModelPart root;

    public BoarEntityModel(ModelPart root) {
        super(root, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        return getTexturedModelData(Dilation.NONE);
    }

    public static TexturedModelData getTexturedModelData(Dilation dilation) {
        ModelData modelData = QuadrupedEntityModel.getModelData(6, dilation);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, dilation).uv(16, 16).cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, dilation), ModelTransform.pivot(0.0F, 12.0F, -6.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.root).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }

}
