package net.xanthian.glowglassreborn.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.custom.*;
import net.xanthian.glowglassreborn.item.ModItems;

import java.util.Locale;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Initialise.MOD_ID);


    public static void registerGlassTypes() {
        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);
            DyeColor glassColor = glassTypes.getdyeColor();

            register(glassName + "_stained_glowglass", () -> new StainedGlowGlassBlock(glassColor));
            register(glassName + "_stained_glowglass_pane", () -> new StainedGlowGlassPaneBlock(glassColor));
        }
    }

    public static final RegistryObject<Block> GLOWSAND = register("glowsand", GlowSandBlock::new);
    public static final RegistryObject<Block> GLOWGLASS = register("glowglass", GlowGlassBlock::new);
    public static final RegistryObject<Block> GLOWGLASS_PANE = register("glowglass_pane", GlowGlassPaneBlock::new);


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Initialise.GGR)));
    }
}