package net.xanthian.glowglassreborn.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.custom.*;

import java.util.Locale;

public class ModBlocks {

    public static void registerGlassTypes() {
        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);
            DyeColor glassColor = glassTypes.getdyeColor();
            register(glassName + "_stained_glowglass", new StainedGlowGlassBlock(glassColor));
            register(glassName + "_stained_glowglass_pane", new StainedGlowGlassPaneBlock(glassColor));
        }
        register("glowglass", new GlowGlassBlock());
        register("glowsand", new GlowSandBlock());
        register("glowglass_pane", new GlowGlassPaneBlock());
    }

    private static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Initialise.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Initialise.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }
}