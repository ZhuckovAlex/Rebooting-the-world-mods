package net.max_di.rtw.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output, GatherDataEvent event) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)), event.getLookupProvider());
    }
}
