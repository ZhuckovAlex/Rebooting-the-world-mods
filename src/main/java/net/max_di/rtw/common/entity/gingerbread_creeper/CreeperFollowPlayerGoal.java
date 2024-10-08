package net.max_di.rtw.common.entity.gingerbread_creeper;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class CreeperFollowPlayerGoal extends Goal {
    private final GingerBreadCreeperEntity entity;
    private Player targetPlayer;
    private final double speedModifier;
    private final float stopDistance;

    public CreeperFollowPlayerGoal(GingerBreadCreeperEntity entity, double speedModifier, float stopDistance) {
        this.entity = entity;
        this.speedModifier = speedModifier;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!this.entity.isFollowingPlayer()) {
            return false;
        }
        Player closestPlayer = this.entity.level().getNearestPlayer(this.entity, 10);
        if (closestPlayer == null) {
            return false;
        }
        this.targetPlayer = closestPlayer;
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        boolean canContinue = this.entity.isFollowingPlayer() && this.targetPlayer != null && this.targetPlayer.isAlive() && this.entity.distanceToSqr(this.targetPlayer) > this.stopDistance * this.stopDistance;
        return canContinue;
    }

    @Override
    public void start() {
        this.entity.getNavigation().moveTo(this.targetPlayer, this.speedModifier);
    }

    @Override
    public void stop() {
        this.targetPlayer = null;
        this.entity.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (this.entity.distanceToSqr(this.targetPlayer) > this.stopDistance * this.stopDistance) {
            this.entity.getNavigation().moveTo(this.targetPlayer, this.speedModifier);
        } else {
            this.entity.getNavigation().stop();
        }
    }
}