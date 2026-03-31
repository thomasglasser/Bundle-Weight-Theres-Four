package dev.thomasglasser.bundlefour;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;

public class BundleFourFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DefaultItemComponentEvents.MODIFY.register(context -> context.modify(item -> BundleFour.hasQuarterBundleWeight(item, item.components()), ((builder, _) -> BundleFour.setQuarterBundleWeight(builder::set))));
    }
}
