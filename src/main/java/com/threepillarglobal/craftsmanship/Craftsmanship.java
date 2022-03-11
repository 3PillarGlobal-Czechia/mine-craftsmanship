package com.threepillarglobal.craftsmanship;

import com.threepillarglobal.craftsmanship.block.ModBlocks;
import com.threepillarglobal.craftsmanship.entity.ModEntities;
import com.threepillarglobal.craftsmanship.item.ModItems;
import com.threepillarglobal.craftsmanship.loot.function.ModLootFunctionTypes;
import net.fabricmc.api.ModInitializer;

public class Craftsmanship implements ModInitializer {
    public static final String MOD_ID = "craftsmanship";

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModBlocks.registerBlockItems();

        ModItems.registerItems();

        ModEntities.registerAttributes();

        ModLootFunctionTypes.registerLootFunctionTypes();
    }
}
