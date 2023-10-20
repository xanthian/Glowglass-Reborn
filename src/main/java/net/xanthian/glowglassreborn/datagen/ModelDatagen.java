package net.xanthian.glowglassreborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.Initialise;

public class ModelDatagen extends FabricModelProvider {
    public ModelDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerRotatable(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowsand")));
        blockStateModelGenerator.registerGlassPane(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass_pane")));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
