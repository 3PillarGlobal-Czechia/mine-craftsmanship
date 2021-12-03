package com.threepillarglobal.craftsmanship;

import com.threepillarglobal.craftsmanship.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

public class Craftsmanship implements ModInitializer {
    public static final String MOD_ID = "craftsmanship";

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModBlocks.registerBlockItems();
    }
}
