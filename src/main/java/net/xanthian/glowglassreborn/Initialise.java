package net.xanthian.glowglassreborn;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.registries.ForgeRegistries;
import net.xanthian.glowglassreborn.block.GlowGlassEnum;
import net.xanthian.glowglassreborn.block.ModBlocks;
import net.xanthian.glowglassreborn.item.ModItems;
import net.xanthian.glowglassreborn.util.ModCreativeTab;

import java.util.Locale;

@Mod(Initialise.MOD_ID)
@Mod.EventBusSubscriber(modid= Initialise.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class Initialise {

    public static final String MOD_ID = "glowglassreborn";

    public Initialise() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModBlocks.registerGlassTypes();
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWGLASS_PANE.get(), RenderType.translucent());
            for (GlowGlassEnum glassTypes : GlowGlassEnum.values()) {
                String glassName = glassTypes.name().toLowerCase(Locale.ENGLISH);
                ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Initialise.MOD_ID, glassName + "_stained_glowglass")), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Initialise.MOD_ID, glassName + "_stained_glowglass_pane")), RenderType.translucent());
            }

        }
    }
}
