package net.max_di.rebooting_world.common.datagen;

import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.items.ModItemsRW;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RTW.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItemsRW.GINGERBREAD_MAN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
