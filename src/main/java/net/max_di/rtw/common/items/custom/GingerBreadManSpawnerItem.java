package net.max_di.rtw.common.items.custom;

import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.gingerbread_man.GingerVariant;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.max_di.rtw.common.entity.gingerbread_man.GingerBreadEntity;

public class GingerBreadManSpawnerItem extends Item {
    public GingerBreadManSpawnerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack itemStack = context.getItemInHand();
        Direction direction = context.getClickedFace();
        boolean isShiftDown = context.getPlayer()!= null? context.getPlayer().isShiftKeyDown() : false;
        if (!(level instanceof ServerLevel serverLevel) ||!isShiftDown) {
            return InteractionResult.PASS;
        }
        BlockPos spawnPos = pos.relative(direction);
        if (serverLevel.getBlockState(spawnPos).isAir()) {
            GingerBreadEntity entity = ModEntities.GINGERBREAD_MAN_ENTITY.get().create(serverLevel);
            if (entity!= null) {
                GingerVariant variant = Util.getRandom(GingerVariant.values(), level.random);
                entity.setVariant(variant);
                entity.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, context.getRotation(), 0.0F);
                serverLevel.addFreshEntity(entity);
                RandomSource random = serverLevel.getRandom();
                for (int i = 0; i < 20; ++i) {
                    double offsetX = random.nextGaussian() * 0.02D;
                    double offsetY = random.nextGaussian() * 0.02D;
                    double offsetZ = random.nextGaussian() * 0.02D;
                    serverLevel.sendParticles(ParticleTypes.SMOKE, entity.getX(), entity.getY(), entity.getZ(), 1, offsetX, offsetY, offsetZ, 0.1);
                }
                serverLevel.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                itemStack.shrink(1);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }
}