package net.xanthian.glowglassreborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.GlowGlassEnum;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class BlockTagDatagen  extends FabricTagProvider.BlockTagProvider {
    public BlockTagDatagen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);

            getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                    .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass")))
                    .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass_pane")));
        }

        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowglass_pane")))
                .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowglass")));

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowsand")));

        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
                .add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowsand")));
    }
}