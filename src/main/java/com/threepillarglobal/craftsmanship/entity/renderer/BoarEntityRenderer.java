package com.threepillarglobal.craftsmanship.entity.renderer;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.entity.BoarEntity;
import com.threepillarglobal.craftsmanship.entity.model.BoarEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BoarEntityRenderer extends MobEntityRenderer<BoarEntity, BoarEntityModel> {

    public BoarEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BoarEntityModel(context.getPart(BoarEntityModel.MODEL_LAYER)), 1f);
    }

    @Override
    public Identifier getTexture(BoarEntity entity) {
        return new Identifier(Craftsmanship.MOD_ID, "textures/entity/boar/boar.png");
    }
}
