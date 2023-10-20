package net.xanthian.glowglassreborn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.block.GlowGlassEnum;

import java.util.Locale;

public class GlowglassRebornClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);
            BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass")), RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass_pane")), RenderLayer.getTranslucent());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowglass")), RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowglass_pane")), RenderLayer.getTranslucent());

    }
}