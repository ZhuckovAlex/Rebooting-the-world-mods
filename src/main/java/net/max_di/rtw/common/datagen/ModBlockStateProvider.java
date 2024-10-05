package net.max_di.rtw.common.datagen;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RTW.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK);
        blockWithItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK);
        blockWithItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS);
        blockWithItem(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS);
        simpleDoorBlock(ModBlocksRW.GINGERBREAD_DOOR);
        simpleDoorBlock(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR);
        simpleTrapdoorBlock(ModBlocksRW.GINGERBREAD_TRAPDOOR);
        simpleTrapdoorBlock(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR);
        stairsBlock(((StairBlock) ModBlocksRW.GINGERBREAD_BLOCK_STAIRS.get()), blockTexture(ModBlocksRW.GINGERBREAD_BLOCK.get()));
        stairsBlock(((StairBlock) ModBlocksRW.GINGERBREAD_BRICKS_STAIRS.get()), blockTexture(ModBlocksRW.GINGERBREAD_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS.get()), blockTexture(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get()));
        stairsBlock(((StairBlock) ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get()), blockTexture(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get()), blockTexture(ModBlocksRW.GINGERBREAD_BLOCK.get()), blockTexture(ModBlocksRW.GINGERBREAD_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get()), blockTexture(ModBlocksRW.GINGERBREAD_BRICKS.get()), blockTexture(ModBlocksRW.GINGERBREAD_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get()), blockTexture(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get()), blockTexture(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get()), blockTexture(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()), blockTexture(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get()), blockTexture(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get()));
        blockItem(ModBlocksRW.GINGERBREAD_BLOCK_STAIRS);
        blockItem(ModBlocksRW.GINGERBREAD_BRICKS_STAIRS);
        blockItem(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS);
        blockItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS);
        blockItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS);
        blockItem(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS);
        blockItem(ModBlocksRW.GINGERBREAD_BLOCK_SLAB);
        blockItem(ModBlocksRW.GINGERBREAD_BRICKS_SLAB);
        blockItem(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB);
        blockItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB);
        blockItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB);
        blockItem(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB);
        trapdoorBlockItem(ModBlocksRW.GINGERBREAD_TRAPDOOR);
        trapdoorBlockItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR);
    }

    private void blockWithItem(Supplier<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void simpleDoorBlock(Supplier<DoorBlock> doorBlock){
        doorBlockWithRenderType(doorBlock.get(),modLoc("block/"+ BuiltInRegistries.BLOCK.getKey(doorBlock.get()).getPath()+"_bottom"),
                modLoc("block/"+BuiltInRegistries.BLOCK.getKey(doorBlock.get()).getPath()+"_top"), "cutout");
    }
    private void simpleTrapdoorBlock(Supplier<TrapDoorBlock> trapdoor){
        trapdoorBlockWithRenderType(trapdoor.get(),modLoc("block/"+BuiltInRegistries.BLOCK.getKey(trapdoor.get()).getPath()),
                true,"cutout");
    }
    private void blockItem(Supplier<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("rtw:block/" + BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath()));
    }
    private void trapdoorBlockItem(Supplier<TrapDoorBlock> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("rtw:block/" + BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath()+"_bottom"));
    }
}
