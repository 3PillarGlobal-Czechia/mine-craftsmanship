package com.threepillarglobal.craftsmanship.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBookItem extends BaseItem {
    public KnowledgeBookItem() {
        super(1, Rarity.EPIC);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!(user instanceof PlayerEntity player)) {
            return stack;
        }

        if (player instanceof ServerPlayerEntity serverPlayer) {
            Criteria.CONSUME_ITEM.trigger(serverPlayer, stack);
        }

        var effects = getEffects(stack);

        if (!world.isClient) {
            var playerPos = player.getPos();

            if (!effects.isEmpty()) {
                for (var effect : effects) {
                    player.addStatusEffect(effect);
                }

                player.playSound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundCategory.PLAYERS, 1, 1);
                ((ServerWorld)world).spawnParticles(ParticleTypes.POOF, playerPos.getX(), playerPos.getY() + 1, playerPos.getZ(), 32, 0, 0.5, 0, 0.2);
            }
            else {
                player.playSound(SoundEvents.BLOCK_ANVIL_FALL, SoundCategory.PLAYERS, 1, 1);
                ((ServerWorld)world).spawnParticles(ParticleTypes.POOF, playerPos.getX(), playerPos.getY() + 1, playerPos.getZ(), 32, 0, 0.5, 0, 0.2);
            }
        }

        return stack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack) || !getEffects(stack).isEmpty();
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (!this.isIn(group)) {
            return;
        }

        stacks.add(createStack(new StatusEffectInstance(StatusEffects.SPEED, 1000000, 0, false, false, true)));
        stacks.add(createStack(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1000000, 0, false, false, true)));
        stacks.add(createStack(new StatusEffectInstance(StatusEffects.HASTE, 1000000, 0, false, false, true)));
        stacks.add(createStack(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000000, 0, false, false, true)));
        stacks.add(createStack(new StatusEffectInstance(StatusEffects.LUCK, 1000000, 0, false, false, true)));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        var effects = getEffects(stack);

        if (effects.isEmpty()) {
            return getTranslationKey();
        }

        return getTranslationKey() + "." + effects.get(0).getEffectType().getTranslationKey();
    }

    public static ItemStack createStack(StatusEffectInstance ... effects) {
        var stack = new ItemStack(ModItems.KNOWLEDGE_BOOK);
        var nbt = stack.getOrCreateNbt();
        var nbtList = new NbtList();

        for (var effect : effects) {
            nbtList.add(effect.writeNbt(new NbtCompound()));
        }

        nbt.put("Effects", nbtList);

        return stack;
    }

    public static List<StatusEffectInstance> getEffects(ItemStack stack) {
        var nbt = stack.getOrCreateNbt();
        var result = new ArrayList<StatusEffectInstance>();

        if (nbt.contains("Effects", NbtElement.LIST_TYPE)) {
            var list = nbt.getList("Effects", NbtElement.COMPOUND_TYPE);

            for (var effectNbt : list) {
                result.add(StatusEffectInstance.fromNbt((NbtCompound)effectNbt));
            }
        }

        return result;
    }
}
