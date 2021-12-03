package com.threepillarglobal.craftsmanship.item;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import com.threepillarglobal.craftsmanship.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder
            .create(new Identifier(Craftsmanship.MOD_ID, "blocks"))
            .icon(() -> new ItemStack(ModBlocks.THREE_PILLAR_BLOCK))
            .build();

    public static final ItemGroup ITEMS = FabricItemGroupBuilder
            .create(new Identifier(Craftsmanship.MOD_ID, "items"))
            .icon(() -> new ItemStack(ModBlocks.THREE_PILLAR_BLOCK))
            .build();
}
