package dev.thomasglasser.bundlefour;

import dev.thomasglasser.bundleweight.api.BundleWeightDataComponents;
import java.util.function.BiConsumer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.math.Fraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BundleFour {
    public static final String MOD_ID = "bundlefour";
    public static final String MOD_NAME = "Bundle Weight, There's Four!";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier modId(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static boolean hasQuarterBundleWeight(Item item) {
        return !(item instanceof BundleItem || item.components().has(BundleWeightDataComponents.BUNDLE_WEIGHT.get())) && item.getDefaultMaxStackSize() == 1;
    }

    public static void setQuarterBundleWeight(BiConsumer<DataComponentType<Fraction>, Fraction> builder) {
        builder.accept(BundleWeightDataComponents.BUNDLE_WEIGHT.get(), Fraction.ONE_QUARTER);
    }
}
