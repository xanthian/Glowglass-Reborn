package net.xanthian.glowglassreborn.block.custom;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class StainedGlowGlassPaneBlock extends StainedGlassPaneBlock {
    public StainedGlowGlassPaneBlock(DyeColor color) {
        super(color, Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_50872_) -> {
            return 13;
        }));
    }
}