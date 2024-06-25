package net.max_di.rebooting_world.common.events;

import net.max_di.rebooting_world.RebootingWorld;
import net.max_di.rebooting_world.common.entity.ModEntities;
import net.max_di.rebooting_world.common.entity.gingerbread.GingerBreadEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = RebootingWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GINGER_ENTITY.get(), GingerBreadEntity.createAttributes().build());
    }
}
