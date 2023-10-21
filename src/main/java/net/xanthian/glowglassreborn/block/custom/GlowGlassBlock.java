package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;

public class GlowGlassBlock extends GlassBlock {
    public GlowGlassBlock() {
        super(Properties.copy(Blocks.GLASS).lightLevel((p_50872_) -> {
            return 15;
        }));
    }
}