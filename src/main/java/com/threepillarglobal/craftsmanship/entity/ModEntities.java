package com.threepillarglobal.craftsmanship.entity;


import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.entity.model.BoarEntityModel;
import com.threepillarglobal.craftsmanship.entity.model.ClaymanEntityModel;
import com.threepillarglobal.craftsmanship.entity.renderer.BoarEntityRenderer;
import com.threepillarglobal.craftsmanship.entity.renderer.ClaymanEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<BoarEntity> BOAR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Craftsmanship.MOD_ID, "boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BoarEntity::new).dimensions(EntityDimensions.fixed(2f, 2f)).build());

    public static final EntityType<ClaymanEntity> CLAYMAN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Craftsmanship.MOD_ID, "clayman"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ClaymanEntity::new).dimensions(EntityDimensions.fixed(1F, 1F)).build());

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry
                .register(BOAR, BoarEntity.createMobAttributes()
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5D));

        FabricDefaultAttributeRegistry
                .register(CLAYMAN, ClaymanEntity.createMobAttributes()
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5D));

    }

    public static void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.BOAR, BoarEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CLAYMAN, ClaymanEntityRenderer::new);
    }

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(BoarEntityModel.MODEL_LAYER, BoarEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ClaymanEntityModel.MODEL_LAYER, ClaymanEntityModel::getTexturedModelData);
    }
}
