package net.xanthian.glowglassreborn.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;

public class GlowSandBlock extends SandBlock {
    public GlowSandBlock() {
        super(14406560, FabricBlockSettings.copyOf(Blocks.SAND).luminance(13));
    }
}