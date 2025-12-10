package net.legacy.remnants.registry;

import net.legacy.remnants.Remnants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class RemnantsMobEffects {
    public static final Holder<MobEffect> OVERCHARGE = register(
            "overcharge",
            new MobEffect(MobEffectCategory.BENEFICIAL, 13984300)
                    .addAttributeModifier(
                            Attributes.ATTACK_KNOCKBACK, Identifier.withDefaultNamespace("knockback"), 1F, AttributeModifier.Operation.ADD_VALUE
                    )
    );

    public static void init() {
    }

    private static Holder<MobEffect> register(String path, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Remnants.id(path), effect);
    }
}
