package net.max_di.rtw.common.entity.gingerbread;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;


public class GingerBreadEntity extends Animal {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(GingerBreadEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(GingerBreadEntity.class, EntityDataSerializers.INT);



    public GingerBreadEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public int getExperienceReward() {
        return 0;
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState runAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.getDeltaMovement().lengthSqr() > 0.02) {
            if (this.isPanicking()) {
                this.runAnimationState.start(this.tickCount);
                this.walkAnimationState.stop();
                this.idleAnimationState.stop();
            } else {
                this.walkAnimationState.start(this.tickCount);
                this.runAnimationState.stop();
                this.idleAnimationState.stop();
            }
        } else {
            this.idleAnimationState.start(this.tickCount);
            this.walkAnimationState.stop();
            this.runAnimationState.stop();
        }
    }

    private boolean isPanicking() {
        return this.goalSelector.getRunningGoals().anyMatch(goal -> goal.getGoal() instanceof PanicGoal);
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
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new FollowPlayerGoal(this, 1.1D, 4.0F));
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
                    BlockPos pos = new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ());
                    double offsetX = random.nextGaussian() * 0.02D;
                    double offsetY = random.nextGaussian() * 0.02D;
                    double offsetZ = random.nextGaussian() * 0.02D;
                    for (int i = 0; i < 20; i++) {
                        serverlevel.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 1, offsetX, offsetY, offsetZ, 0.1);
                    }
                    serverlevel.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

            }
            else {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
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

    }

    private int getTypeVariant(){
        return this.entityData.get(VARIANT);
    }

    public GingerVariant getVariant(){
        return GingerVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(GingerVariant variant){
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putInt("Variant", this.getTypeVariant());
        pTag.putInt("Command", this.getCommand());

    }

    @Override
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        this.entityData.set(VARIANT, pTag.getInt("Variant"));
        this.entityData.set(COMMAND, pTag.getInt("Command"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pType,
                                        @Nullable SpawnGroupData pData, @Nullable CompoundTag pTag) {

        GingerVariant variant = Util.getRandom(GingerVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pType, pData, pTag);
    }
}