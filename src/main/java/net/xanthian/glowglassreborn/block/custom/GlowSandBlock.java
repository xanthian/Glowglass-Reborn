package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlowSandBlock extends SandBlock {
    public GlowSandBlock() {
        super(14406560, BlockBehaviour.Properties.copy(Blocks.SAND).lightLevel((p_50872_) -> 13));
    }
}