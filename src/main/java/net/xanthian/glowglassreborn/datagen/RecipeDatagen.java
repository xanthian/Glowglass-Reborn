package net.xanthian.glowglassreborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.GlowGlassEnum;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class RecipeDatagen  extends FabricRecipeProvider {
    public RecipeDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
            Item dyeItem = glassTypes.getdyeItem();
            String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);

            offerStainedGlowGlassRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass")),
                    Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass")), dyeItem);

            offerStainedGlowGlassPaneRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, glassName + "_stained_glowglass_pane")),
                    Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,glassName + "_stained_glowglass")));

            offerStainedGlowGlassPaneFromGlowGlassPaneRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "glowglass_pane")),
                    Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,glassName + "_stained_glowglass_pane")), dyeItem);

        }

        VanillaRecipeProvider.offerSmelting(exporter, List.of(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowsand"))),
                RecipeCategory.DECORATIONS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass")),0.1F,
                200, " ");

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowsand")))
                .input('g', Items.GLOWSTONE_DUST).input('S', Items.SAND)
                .pattern(" g ").pattern("gSg").pattern(" g ")
                .criterion("has_glowstone_dust", VanillaRecipeProvider.conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion("has_sand", VanillaRecipeProvider.conditionsFromItem(Items.SAND))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass_pane")), 16)
                .input('#', Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass")))
                .pattern("###").pattern("###")
                .criterion("has_glowglass", VanillaRecipeProvider.conditionsFromItem(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID,"glowglass"))))
                .offerTo(exporter);

    }

    public static void offerStainedGlowGlassRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible glowGlass, ItemConvertible glass, ItemConvertible dye) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, glowGlass, 8)
                .input('G', glass)
                .input('D', dye)
                .pattern("GGG").pattern("GDG").pattern("GGG")
                .criterion(FabricRecipeProvider.hasItem(dye), FabricRecipeProvider.conditionsFromItem(dye))
                .criterion(FabricRecipeProvider.hasItem(glass), FabricRecipeProvider.conditionsFromItem(glass))
                .offerTo(exporter);
        }
    public static void offerStainedGlowGlassPaneRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible pane, ItemConvertible glowGlass) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, pane, 16)
                .input('#', glowGlass)
                .pattern("###").pattern("###")
                .criterion(FabricRecipeProvider.hasItem(glowGlass), FabricRecipeProvider.conditionsFromItem(glowGlass))
                .offerTo(exporter);
    }
    public static void offerStainedGlowGlassPaneFromGlowGlassPaneRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible pane, ItemConvertible stainedPane, ItemConvertible dye) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, stainedPane, 8)
                .input('G', pane)
                .input('D', dye)
                .pattern("GGG").pattern("GDG").pattern("GGG")
                .criterion(FabricRecipeProvider.hasItem(dye), FabricRecipeProvider.conditionsFromItem(dye))
                .criterion(FabricRecipeProvider.hasItem(pane), FabricRecipeProvider.conditionsFromItem(pane))
                .offerTo(exporter, RecipeProvider.getItemPath(stainedPane)  + "_from_" + RecipeProvider.getItemPath(pane));
    }
}