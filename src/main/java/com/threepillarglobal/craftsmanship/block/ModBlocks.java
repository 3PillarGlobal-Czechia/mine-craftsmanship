package com.threepillarglobal.craftsmanship.block;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block THREE_PILLAR_BLOCK = new ThreePillarBlock();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, ThreePillarBlock.ID, THREE_PILLAR_BLOCK);
    }

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, ThreePillarBlock.ID, new BaseBlockItem(THREE_PILLAR_BLOCK));
    }
}
