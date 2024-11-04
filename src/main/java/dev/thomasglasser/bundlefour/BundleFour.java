package dev.thomasglasser.bundlefour;

import dev.thomasglasser.bundleweight.api.BundleWeightDataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BundleItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import org.apache.commons.lang3.math.Fraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(BundleFour.MOD_ID)
public class BundleFour {
    public static final String MOD_ID = "bundlefour";
    public static final String MOD_NAME = "Bundle Weight, There's Four!";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public BundleFour(IEventBus modEventBus) {
        modEventBus.addListener(BundleFour::onModifyDefaultComponents);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private static void onModifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        event.modifyMatching(item -> !(item instanceof BundleItem) && item.getDefaultMaxStackSize() == 1, builder -> builder.set(BundleWeightDataComponents.BUNDLE_WEIGHT.get(), Fraction.ONE_QUARTER).build());
    }
}
