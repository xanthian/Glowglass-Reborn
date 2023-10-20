package net.xanthian.glowglassreborn.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;

public class GlowGlassPaneBlock extends PaneBlock {
    public GlowGlassPaneBlock() {
        super(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).luminance(15));
    }
}