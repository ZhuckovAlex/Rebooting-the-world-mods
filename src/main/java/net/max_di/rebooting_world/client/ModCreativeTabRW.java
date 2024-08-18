package net.max_di.rebooting_world.client;

import net.max_di.rebooting_world.RebootingWorld;
import net.max_di.rebooting_world.common.blocks.ModBlocksRW;
import net.max_di.rebooting_world.common.items.ModItemsRW;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabRW {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RebootingWorld.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REBOOT_WORLD_TAB = CREATIVE_MODE_TABS.register("reboot_world_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItemsRW.REPAIR_TEMPLATE.get()))
                    .title(Component.translatable("rebooting_world.reboot_world_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BLOCK.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get());
                        pOutput.accept(ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get());
                        pOutput.accept(ModBlocksRW.SAWMILL.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_BRICK.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_BRICK.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_HEART.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_MAN.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_ROUND.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_FORM_PINE.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_HEART.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_HEART.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_MAN.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_MAN.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_MAN.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_ROUND.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_ROUND.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_PINE.get());
                        pOutput.accept(ModItemsRW.RAW_GINGERBREAD_PINE.get());
                        pOutput.accept(ModItemsRW.GLAZED_GINGERBREAD_PINE.get());
                        pOutput.accept(ModItemsRW.GINGERBREAD_DOUGH.get());
                        pOutput.accept(ModItemsRW.REPAIR_TEMPLATE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
