package net.max_di.rtw.common.events;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadEntity;
import net.max_di.rtw.common.entity.gingerbread_creeper.GingerBreadCreeperEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = RTW.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GINGERBREAD_MAN_ENTITY.get(), GingerBreadEntity.createAttributes().build());
        event.put(ModEntities.GINGERBREAD_CREEPER_ENTITY.get(), GingerBreadCreeperEntity.createAttributes().build());
    }
}