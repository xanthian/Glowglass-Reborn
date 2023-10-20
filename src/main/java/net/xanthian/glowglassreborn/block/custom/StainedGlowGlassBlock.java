package net.xanthian.glowglassreborn.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Blocks;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class StainedGlowGlassBlock extends StainedGlassBlock {
    public StainedGlowGlassBlock(DyeColor color) {
        super(color, FabricBlockSettings.create().mapColor(color).instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).luminance(13));
    }
}