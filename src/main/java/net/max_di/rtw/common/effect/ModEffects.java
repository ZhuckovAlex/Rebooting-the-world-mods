package net.max_di.rtw.common.effect;

import net.max_di.rtw.RTW;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(Registries.MOB_EFFECT, RTW.MOD_ID);

    public static final Holder<MobEffect> EFFECT_RESISTANCE = EFFECT.register("effect_resistance", ()-> new EffectResistanceEffect(MobEffectCategory.NEUTRAL, 0xF4E2C4));
}
