package net.xanthian.glowglassreborn;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.xanthian.glowglassreborn.datagen.*;

public class DatagenInitialise  implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockTagDatagen::new);
        pack.addProvider(LanguageDatagen::new);
        pack.addProvider(LootTableDatagen::new);
        pack.addProvider(RecipeDatagen::new);
        pack.addProvider(ModelDatagen::new);

    }
}