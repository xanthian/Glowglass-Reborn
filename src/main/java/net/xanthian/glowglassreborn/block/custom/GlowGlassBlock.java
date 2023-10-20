package net.xanthian.glowglassreborn.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;

public class GlowGlassBlock extends GlassBlock {
    public GlowGlassBlock() {
        super(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(15));
    }
}