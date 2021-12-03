package com.threepillarglobal.craftsmanship.block;

import com.threepillarglobal.craftsmanship.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(Block block) {
        super(block, new FabricItemSettings().group(ModItemGroup.BLOCKS));
    }
}
