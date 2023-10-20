package net.xanthian.glowglassreborn.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class StainedGlowGlassPaneBlock extends StainedGlassPaneBlock {
    public StainedGlowGlassPaneBlock(DyeColor color) {
        super(color, FabricBlockSettings.create().instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().luminance(13));
    }
}