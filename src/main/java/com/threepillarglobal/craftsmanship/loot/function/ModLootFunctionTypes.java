package com.threepillarglobal.craftsmanship.loot.function;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModLootFunctionTypes {
    public static LootFunctionType RANDOM_KNOWLEDGE = new LootFunctionType(new RandomKnowledgeLootFunction.Serializer());

    public static void registerLootFunctionTypes() {
        Registry.register(Registry.LOOT_FUNCTION_TYPE, new Identifier(Craftsmanship.MOD_ID, "random_knowledge"), RANDOM_KNOWLEDGE);
    }
}
