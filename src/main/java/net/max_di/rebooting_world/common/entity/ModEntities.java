package net.max_di.rebooting_world.common.entity;

import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.entity.gingerbread.GingerBreadEntity;
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
    public static final RegistryObject<EntityType<GingerBreadEntity>> GINGER_ENTITY =
            ENTITY_TYPES.register("ginger_entity",
                    () -> EntityType.Builder.of(GingerBreadEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(new ResourceLocation(RTW.MOD_ID, "ginger_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}