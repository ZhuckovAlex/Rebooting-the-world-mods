package net.max_di.rebooting_world.common.blocks;

import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.blocks.custom.SawmillBlock;
import net.max_di.rebooting_world.common.items.ModItemsRW;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocksRW {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RTW.MOD_ID);

    public static final RegistryObject<Block> GINGERBREAD_BLOCK = registerBlock("gingerbread_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryObject<Block> GINGERBREAD_BRICKS = registerBlock("gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryObject<Block> GINGERBREAD_DOUGH_BLOCK = registerBlock("gingerbread_dough_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICKS = registerBlock("glazed_gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryObject<Block> SAWMILL = registerBlock("sawmill",
            () -> new SawmillBlock(BlockBehaviour.Properties.of().strength(3.5F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItemsRW.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
