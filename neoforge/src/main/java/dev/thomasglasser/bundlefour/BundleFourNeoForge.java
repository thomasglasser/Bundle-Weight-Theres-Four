package dev.thomasglasser.bundlefour;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@Mod(BundleFour.MOD_ID)
public class BundleFourNeoForge {
    public BundleFourNeoForge(IEventBus modBus) {
        modBus.addListener(BundleFourNeoForge::onModifyDefaultComponents);
    }

    private static void onModifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        event.modifyMatching(BundleFour::hasQuarterBundleWeight, builder -> BundleFour.setQuarterBundleWeight(builder::set));
    }
}
