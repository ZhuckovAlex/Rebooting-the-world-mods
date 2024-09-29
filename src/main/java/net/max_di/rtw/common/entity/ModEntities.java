package net.max_di.rtw.common.entity;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadEntity;
import net.max_di.rtw.common.entity.gingerbread_creeper.GingerBreadCreeperEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RTW.MOD_ID);
    public static final RegistryObject<EntityType<GingerBreadEntity>> GINGERBREAD_MAN_ENTITY =
            ENTITY_TYPES.register("gingerbread_man",
                    () -> EntityType.Builder.of(GingerBreadEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(new ResourceLocation(RTW.MOD_ID, "gingerbread_man").toString()));

    public static final RegistryObject<EntityType<GingerBreadCreeperEntity>> GINGERBREAD_CREEPER_ENTITY =
            ENTITY_TYPES.register("gingerbread_creeper",
                    () -> EntityType.Builder.of(GingerBreadCreeperEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(new ResourceLocation(RTW.MOD_ID, "gingerbread_creeper").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}