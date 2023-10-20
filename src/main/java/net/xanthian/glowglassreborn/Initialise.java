package net.xanthian.glowglassreborn;

import net.fabricmc.api.ModInitializer;

import net.xanthian.glowglassreborn.block.ModBlocks;
import net.xanthian.glowglassreborn.util.ModCreativeTab;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "glowglassreborn";

    @Override
    public void onInitialize() {

        ModBlocks.registerGlassTypes();
        ModCreativeTab.registerGroup();

    }
}