package com.threepillarglobal.craftsmanship.entity.renderer;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.entity.ClaymanEntity;
import com.threepillarglobal.craftsmanship.entity.model.ClaymanEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ClaymanEntityRenderer extends MobEntityRenderer<ClaymanEntity, ClaymanEntityModel> {
    private static final Identifier TEXTURE = new Identifier(Craftsmanship.MOD_ID, "textures/entity/clayman/clayman.png");
    private static final Identifier ANGRY_TEXTURE = new Identifier(Craftsmanship.MOD_ID, "textures/entity/clayman/clayman_angry.png");

    public ClaymanEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ClaymanEntityModel(context.getPart(ClaymanEntityModel.MODEL_LAYER)), 1F);
    }

    @Override
    public Identifier getTexture(ClaymanEntity entity) {
        return entity.isAttacking() ? ANGRY_TEXTURE : TEXTURE;
    }
}
