package net.max_di.rtw.client;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.items.ModItemsRW;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabRW {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RTW.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REBOOT_WORLD_TAB = CREATIVE_MODE_TABS.register("rtw_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItemsRW.REPAIR_TEMPLATE.get()))
                    .title(Component.translatable("rtw.rtw_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //GINGERBREAD
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD.get());
                        pOutput.accept(ModItemsRW.RAW_CHOCOLATE_GINGERBREAD.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD.get());
                        pOutput.accept(ModItemsRW.CHOCOLATE_GINGERBREAD.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD.get());
                        pOutput.accept(ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD.get());

                        //BRICK
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_BRICK.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.RAW_CHOCOLATE_GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.CHOCOLATE_GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICK.get());

                        //HEART
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_HEART.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_HEART.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_HEART.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_HEART.get());

                        //MAN
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_MAN.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_MAN.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_MAN.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_MAN.get());

                        //PINE
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_PINE.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_PINE.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_PINE.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_PINE.get());

                        //CREEPER
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_CREEPER.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_CREEPER.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_CREEPER.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_CREEPER.get());

                        //NOTE
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_NOTE.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_NOTE.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_NOTE.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_NOTE.get());

                        //STAR
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_STAR.get());
                        pOutput.accept(ModItemsRW.RAW_CHOCOLATE_GINGERBREAD_STAR.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_STAR.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_STAR.get());

                        //
                        pOutput.accept(ModItemsRW.GINGERBREAD_DOUGH.get());
                        pOutput.accept(ModItemsRW.CHOCOLATE_GINGERBREAD_DOUGH.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BLOCK.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BLOCK_STAIRS.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_DOOR.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_TRAPDOOR.get());
                        pOutput.accept(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_MAN_SPAWN_EGG.get());
                        pOutput.accept(ModBlocksRW.SAWMILL.get());
                        pOutput.accept(ModItemsRW.REPAIR_TEMPLATE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
