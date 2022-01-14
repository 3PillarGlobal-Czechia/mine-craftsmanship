package com.threepillarglobal.craftsmanship.item;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item KNOWLEDGE_BOOK = new KnowledgeBookItem();

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Craftsmanship.MOD_ID, "knowledge_book"), KNOWLEDGE_BOOK);
    }
}
