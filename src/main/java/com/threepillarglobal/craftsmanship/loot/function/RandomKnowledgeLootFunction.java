package com.threepillarglobal.craftsmanship.loot.function;

import com.google.gson.*;
import com.threepillarglobal.craftsmanship.item.KnowledgeBookItem;
import com.threepillarglobal.craftsmanship.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomKnowledgeLootFunction extends ConditionalLootFunction {
    private final List<StatusEffectInstance> effects;

    public RandomKnowledgeLootFunction(LootCondition[] conditions) {
        super(conditions);

        this.effects = new ArrayList<>();

        var speed = new StatusEffectInstance(StatusEffects.SPEED, 1000000, 0, false, false, true);
        speed.setPermanent(true);
        this.effects.add(speed);

        var health = new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1000000, 0, false, false, true);
        health.setPermanent(true);
        this.effects.add(health);

        var haste = new StatusEffectInstance(StatusEffects.HASTE, 1000000, 0, false, false, true);
        haste.setPermanent(true);
        this.effects.add(haste);

        var resistance = new StatusEffectInstance(StatusEffects.RESISTANCE, 1000000, 0, false, false, true);
        resistance.setPermanent(true);
        this.effects.add(resistance);

        var luck = new StatusEffectInstance(StatusEffects.LUCK, 1000000, 0, false, false, true);
        luck.setPermanent(true);
        this.effects.add(luck);
    }

    @Override
    public LootFunctionType getType() {
        return ModLootFunctionTypes.RANDOM_KNOWLEDGE;
    }

    @Override
    public ItemStack process(ItemStack stack, LootContext context) {
        Random random = context.getRandom();
        StatusEffectInstance effect = this.effects.get(random.nextInt(this.effects.size()));

        return addEffectToStack(stack, effect);
    }

    private static ItemStack addEffectToStack(ItemStack stack, StatusEffectInstance effect) {
        if (stack.isOf(ModItems.KNOWLEDGE_BOOK)) {
            return KnowledgeBookItem.createStack(effect);
        }

        return stack;
    }

    public static class Builder extends  ConditionalLootFunction.Builder<com.threepillarglobal.craftsmanship.loot.function.RandomKnowledgeLootFunction.Builder> {
        @Override
        protected com.threepillarglobal.craftsmanship.loot.function.RandomKnowledgeLootFunction.Builder getThisBuilder() { return this; }

        @Override
        public LootFunction build() { return new RandomKnowledgeLootFunction(this.getConditions()); }
    }

    public static class Serializer extends ConditionalLootFunction.Serializer<RandomKnowledgeLootFunction> {
        @Override
        public void toJson(JsonObject object, RandomKnowledgeLootFunction lootFunction, JsonSerializationContext serializationContext) {
            super.toJson(object, lootFunction, serializationContext);

            if (!lootFunction.effects.isEmpty()) {
                var array = new JsonArray();

                for (var effect : lootFunction.effects) {
                    var id = Registry.STATUS_EFFECT.getId((effect.getEffectType()));

                    if (id == null) {
                        throw new IllegalArgumentException("Don't know how to serialize knowledge effect");
                    }

                    array.add(new JsonPrimitive(id.toString()));
                }

                object.add("effects", array);
            }
        }

        @Override
        public RandomKnowledgeLootFunction fromJson(JsonObject object, JsonDeserializationContext deserializationContext, LootCondition[] lootConditions) {
            return new RandomKnowledgeLootFunction(lootConditions);
        }
    }
}
