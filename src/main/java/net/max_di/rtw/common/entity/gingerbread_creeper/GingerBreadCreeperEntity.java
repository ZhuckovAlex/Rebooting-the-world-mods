package net.max_di.rtw.common.entity.gingerbread_creeper;

import net.max_di.rtw.common.effect.ModEffects;
import net.max_di.rtw.common.utils.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;


public class GingerBreadCreeperEntity extends Animal {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(GingerBreadCreeperEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(GingerBreadCreeperEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BLOWING_UP_TIMEOUT =
            SynchedEntityData.defineId(GingerBreadCreeperEntity.class, EntityDataSerializers.INT);


    public GingerBreadCreeperEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public int getExperienceReward() {
        return 0;
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState runAnimationState = new AnimationState();
    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState standUpAnimationState = new AnimationState();
    public final AnimationState blowUpAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int sitAnimationTimeout = 0;
    private int blowingUpAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            if (idleAnimationTimeout <= 0 && getCommand()!= 2) {
                idleAnimationTimeout = 60;
                idleAnimationState.start(this.tickCount);
                sitAnimationTimeout = 0;
            } else if (getCommand()==2){
                if (sitAnimationTimeout <= 0) {
                    sitDownAnimationState.stop();
                    sitAnimationTimeout = 60;
                    sitAnimationState.start(this.tickCount);
                } else {
                    --sitAnimationTimeout;
                }
            } else {
                --idleAnimationTimeout;
            }
        }
        if (getBlowingUpTimeout()>0){
            setBlowingUpTimeout(getBlowingUpTimeout()-1);
            if (level().isClientSide()){
                blowingUpAnimationTimeout--;
                if (blowingUpAnimationTimeout<=0){
                    blowUpAnimationState.start(this.tickCount);
                    blowingUpAnimationTimeout = 10;
                }
            }
            if (getBlowingUpTimeout()<=0){
                if (level() instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1, 0F, 0F, 0F, 0F);
                }
                this.playSound(SoundEvents.GENERIC_EXPLODE);
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level(), this.getX(), this.getY(), this.getZ());
                areaeffectcloud.setRadius(5.0F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(10);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
                areaeffectcloud.addEffect(new MobEffectInstance(ModEffects.EFFECT_RESISTANCE.get(), 100 , 0));
                level().addFreshEntity(areaeffectcloud);
                setBlowingUpTimeout(0);
                if (level().isClientSide()){
                    blowUpAnimationState.stop();
                }
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(Items.DRAGON_EGG), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new CreeperFollowPlayerGoal(this, 1.1D, 4.0F));
        this.goalSelector.addGoal(6, new WaitGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }
    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }
 
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    public int getCommand() {
        return this.entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    public int getBlowingUpTimeout() {
        return this.entityData.get(BLOWING_UP_TIMEOUT);
    }

    public void setBlowingUpTimeout(int timeout) {
        this.entityData.set(BLOWING_UP_TIMEOUT, timeout);
    }

    public boolean isFollowingPlayer() {
        return this.entityData.get(COMMAND) == 1;
    }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            if (player.isShiftKeyDown()){
                remove(RemovalReason.KILLED);
                if (level() instanceof ServerLevel serverlevel) {
                    this.dropAllDeathLoot(damageSources().genericKill());
                    double offsetX = random.nextGaussian() * 0.02D;
                    double offsetY = random.nextGaussian() * 0.02D;
                    double offsetZ = random.nextGaussian() * 0.02D;
                    for (int i = 0; i < 20; i++) {
                        serverlevel.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 1, offsetX, offsetY, offsetZ, 0.1);
                    }
                    this.playSound(SoundEvents.FIRE_EXTINGUISH, 1.0F, 1.0F);
                }

            }
            else if(player.getItemInHand(hand).getItem()==Items.MILK_BUCKET){
                if (getBlowingUpTimeout()<=0) {
                    if (!player.isCreative()){
                        player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                    }
                    this.playSound(SoundEvents.GENERIC_DRINK, 1.0F, 1.0F);
                    this.playSound(SoundEvents.CREEPER_PRIMED,1.0F, 0.5F);
                    this.setBlowingUpTimeout(30);
                }else {
                    return InteractionResult.PASS;
                }
            }
            else{
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                    sitAnimationState.stop();
                    standUpAnimationState.start(this.tickCount);
                    idleAnimationState.start(this.tickCount);
                    this.idleAnimationTimeout = 60;
                }
                if (this.getCommand() == 2){
                    idleAnimationState.stop();
                    sitDownAnimationState.start(this.tickCount);
                    this.sitAnimationTimeout = 18;
                }
                else {
                    sitDownAnimationState.stop();
                }
                player.displayClientMessage(Component.translatable("entity.rtw.all.command_"+this.getCommand(), this.getName()), true);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.mobInteract(player, hand);
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(COMMAND, 0);
        this.entityData.define(BLOWING_UP_TIMEOUT, 0);

    }

    private int getTypeVariant(){
        return this.entityData.get(VARIANT);
    }

    public GingerCreeperVariant getVariant(){
        return GingerCreeperVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(GingerCreeperVariant variant){
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putInt("Variant", this.getTypeVariant());
        pTag.putInt("Command", this.getCommand());
        pTag.putInt("BlowingUpTimeout", getBlowingUpTimeout());

    }

    @Override
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        this.entityData.set(VARIANT, pTag.getInt("Variant"));
        this.entityData.set(COMMAND, pTag.getInt("Command"));
        this.entityData.set(BLOWING_UP_TIMEOUT, pTag.getInt("BlowingUpTimeout"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pType,
                                        @Nullable SpawnGroupData pData, @Nullable CompoundTag pTag) {

        GingerCreeperVariant variant = Util.getRandom(GingerCreeperVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pType, pData, pTag);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.GINGERBREAD_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GINGERBREAD_HURT.get();
    }
}