package net.max_di.rebooting_world.common.events;

import net.max_di.rebooting_world.RebootingWorld;
import net.max_di.rebooting_world.common.entity.ModEntities;
import net.max_di.rebooting_world.common.entity.gingerbread.custom.GingerBreadEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = RebootingWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntities.GINGER_ENTITY.get(), GingerBreadEntity.setAttributes());
        }

    }
}
