package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class StainedGlowGlassBlock extends StainedGlassBlock {
    public StainedGlowGlassBlock(DyeColor color) {
        super(color, BlockBehaviour.Properties.of(Material.GLASS, color).strength(0.3F).sound(SoundType.GLASS).noOcclusion()
                .isValidSpawn((p1, p2, p3, p4) -> false).isRedstoneConductor((p1, p2, p3) -> false).isSuffocating((p1, p2, p3) -> false).isViewBlocking((p1, p2, p3) -> false).lightLevel((p_50872_) -> 13));
    }
}