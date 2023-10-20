package net.xanthian.glowglassreborn.block;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;

public enum GlowGlassEnum {

    WHITE(16383998, DyeColor.WHITE, Items.WHITE_DYE),
    LIGHT_GRAY(10329495, DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE),
    GRAY(4673362, DyeColor.GRAY, Items.GRAY_DYE),
    BLACK(1908001, DyeColor.BLACK, Items.BLACK_DYE),
    BROWN(8606770, DyeColor.BROWN, Items.BROWN_DYE),
    RED(11546150, DyeColor.RED, Items.RED_DYE),
    ORANGE(16351261, DyeColor.ORANGE, Items.ORANGE_DYE),
    YELLOW(16701501, DyeColor.YELLOW, Items.YELLOW_DYE),
    LIME(8439583, DyeColor.LIME, Items.LIME_DYE),
    GREEN(6192150, DyeColor.GREEN, Items.GREEN_DYE),
    CYAN(1481884, DyeColor.CYAN, Items.CYAN_DYE),
    LIGHT_BLUE(3847130, DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE),
    BLUE(3949738, DyeColor.BLUE, Items.BLUE_DYE),
    PURPLE(8991416, DyeColor.PURPLE, Items.PURPLE_DYE),
    MAGENTA(13061821, DyeColor.MAGENTA, Items.MAGENTA_DYE),
    PINK(15961002, DyeColor.PINK, Items.PINK_DYE);

    private final Integer color;
    private final DyeColor dyeColor;
    private final Item dyeItem;

    GlowGlassEnum(Integer color, DyeColor dyeColor, Item dyeItem){
        this.color = color;
        this.dyeColor = dyeColor;
        this.dyeItem = dyeItem;
    }

    public Integer getColor() {
        return color;
    }
    public DyeColor getdyeColor() {
        return dyeColor;
    }
    public Item getdyeItem() {
        return dyeItem;
    }
}
