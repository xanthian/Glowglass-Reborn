package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlowGlassBlock extends GlassBlock {
    public GlowGlassBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS).lightLevel((p_50872_) -> 15));
    }
}