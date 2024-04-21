package net.davebalda.pacocraft.util;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ORLEGNO_LOGS =
                createTag("orlegno_logs");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(PacoCraft.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> ORLEGNO_LOGS =
                createTag("orlegno_logs");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(PacoCraft.MOD_ID, name));
        }
    }
}
