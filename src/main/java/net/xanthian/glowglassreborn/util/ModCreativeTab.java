package net.xanthian.glowglassreborn.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.xanthian.glowglassreborn.Initialise;

import java.util.Comparator;

public class ModCreativeTab {

    public static void registerGroup() {
    }


    public static final ItemGroup GGR = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "glowglass"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("GlowGlass Reborn"))
                    .icon(() -> new ItemStack(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "glowsand"))))
                    .entries((context, entries) -> {
                        entries.addAll(Registries.ITEM.getIds().stream()
                                .filter(identifier -> identifier.getNamespace().equals(Initialise.MOD_ID))
                                .sorted(Comparator.comparing(Identifier::getPath))
                                .map(Registries.ITEM::get)
                                .map(ItemStack::new)
                                .filter(input -> !input.isEmpty())
                                .toList());
                    })
                    .build());
}