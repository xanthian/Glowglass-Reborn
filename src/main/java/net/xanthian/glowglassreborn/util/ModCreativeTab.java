package net.xanthian.glowglassreborn.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.xanthian.glowglassreborn.Initialise;
import net.xanthian.glowglassreborn.block.ModBlocks;

import java.util.Comparator;
import java.util.Objects;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Initialise.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GGR_TAB = CREATIVE_MODE_TABS.register("glowglassreborn",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Glowglass Reborn"))
                    .icon(() -> new ItemStack(ModBlocks.GLOWSAND.get()))
                    .displayItems((context, entries) -> {
                        entries.acceptAll(ForgeRegistries.ITEMS.getKeys()
                                .stream()
                                .filter(identifier -> identifier.getNamespace().equals(Initialise.MOD_ID))
                                .sorted(Comparator.comparing(ResourceLocation::getPath))
                                .map(ForgeRegistries.ITEMS::getValue).filter(Objects::nonNull)
                                .map(ItemStack::new)
                                .filter(input -> !input.isEmpty())
                                .toList());
                    })
                    .build());
}