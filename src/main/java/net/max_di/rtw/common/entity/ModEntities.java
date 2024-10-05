package net.max_di.rtw.common.entity;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadEntity;
import net.max_di.rtw.common.entity.gingerbread_creeper.GingerBreadCreeperEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, RTW.MOD_ID);
    public static final Supplier<EntityType<GingerBreadEntity>> GINGERBREAD_MAN_ENTITY =
            ENTITY_TYPES.register("gingerbread_man",
                    () -> EntityType.Builder.of(GingerBreadEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_man").toString()));

    public static final Supplier<EntityType<GingerBreadCreeperEntity>> GINGERBREAD_CREEPER_ENTITY =
            ENTITY_TYPES.register("gingerbread_creeper",
                    () -> EntityType.Builder.of(GingerBreadCreeperEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_creeper").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}