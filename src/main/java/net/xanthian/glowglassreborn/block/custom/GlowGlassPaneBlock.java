package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlowGlassPaneBlock extends IronBarsBlock {
    public GlowGlassPaneBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).lightLevel((p_50872_) -> {
            return 15;
        }));
    }
}