package com.threepillarglobal.craftsmanship.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class BaseItem extends Item {
    public BaseItem(int maxStackSize, Rarity rarity) {
        super(new FabricItemSettings().group(ModItemGroup.ITEMS).maxCount(maxStackSize).rarity(rarity));
    }

    public BaseItem(int maxStackSize) {
        super(new FabricItemSettings().group(ModItemGroup.ITEMS).maxCount(maxStackSize).rarity(Rarity.COMMON));
    }
}
