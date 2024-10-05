package net.max_di.rtw.common.datagen;

import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.function.Supplier;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_TRAPDOOR.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BLOCK_STAIRS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.SAWMILL.get());
        this.add(ModBlocksRW.GINGERBREAD_DOOR.get(), block -> createDoorTable(ModBlocksRW.GINGERBREAD_DOOR.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get(), block -> createDoorTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get()));
        this.add(ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get()));
        this.add(ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocksRW.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
