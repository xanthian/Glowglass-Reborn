package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class StainedGlowGlassPaneBlock extends StainedGlassPaneBlock {
    public StainedGlowGlassPaneBlock(DyeColor color) {
        super(color, BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS_PANE).lightLevel((p_50872_) -> 13));
    }
}