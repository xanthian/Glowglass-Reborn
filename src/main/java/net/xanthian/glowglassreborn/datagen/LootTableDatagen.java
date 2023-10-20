package net.xanthian.glowglassreborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.GlowGlassEnum;

import java.util.Locale;

public class LootTableDatagen   extends FabricBlockLootTableProvider {
    public LootTableDatagen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);

            addDropWithSilkTouch(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass_pane")));
            addDropWithSilkTouch(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass")));
        }

        addDrop(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass_pane")), (Block block) -> VanillaBlockLootTableGenerator.dropsWithSilkTouch(block,
                this.applyExplosionDecay(block, ((LeafEntry.Builder<?>) ItemEntry.builder(Items.GLOWSTONE_DUST)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f))))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
                        .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4))))));

        addDrop(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass")), (Block block) -> VanillaBlockLootTableGenerator.dropsWithSilkTouch(block,
                this.applyExplosionDecay(block, ((LeafEntry.Builder<?>) ItemEntry.builder(Items.GLOWSTONE_DUST)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f))))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
                        .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4))))));

        addDrop(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowsand")));

    }
}