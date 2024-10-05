package net.max_di.rtw.common.utils;

import net.max_di.rtw.RTW;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, RTW.MOD_ID);

    public static final Supplier<SoundEvent> GINGERBREAD_HURT = registerSoundEvent("gingerbread_hurt");

    private static Supplier<SoundEvent> registerSoundEvent(String name){
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, name);
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(id));
    }
}
