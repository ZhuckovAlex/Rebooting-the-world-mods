package net.max_di.rebooting_world.common.entity.gingerbread;

import net.max_di.rebooting_world.common.entity.gingerbread.GingerBreadEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {
    private final GingerBreadEntity entity;
    private Player targetPlayer;
    private final double speedModifier;
    private final float stopDistance;

    public FollowPlayerGoal(GingerBreadEntity entity, double speedModifier, float stopDistance) {
        this.entity = entity;
        this.speedModifier = speedModifier;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!this.entity.isFollowingPlayer()) {
            System.out.println("FollowPlayerGoal: Entity is not set to follow player.");
            return false;
        }
        Player closestPlayer = this.entity.level().getNearestPlayer(this.entity, 10);
        if (closestPlayer == null) {
            System.out.println("FollowPlayerGoal: No player nearby.");
            return false;
        }
        this.targetPlayer = closestPlayer;
        System.out.println("FollowPlayerGoal: Found player to follow.");
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        boolean canContinue = this.entity.isFollowingPlayer() && this.targetPlayer != null && this.targetPlayer.isAlive() && this.entity.distanceToSqr(this.targetPlayer) > this.stopDistance * this.stopDistance;
        if (!canContinue) {
            System.out.println("FollowPlayerGoal: Stopping follow goal.");
        }
        return canContinue;
    }

    @Override
    public void start() {
        this.entity.getNavigation().moveTo(this.targetPlayer, this.speedModifier);
        System.out.println("FollowPlayerGoal: Starting to follow player.");
    }

    @Override
    public void stop() {
        this.targetPlayer = null;
        this.entity.getNavigation().stop();
        System.out.println("FollowPlayerGoal: Stopped following player.");
    }

    @Override
    public void tick() {
        if (this.entity.distanceToSqr(this.targetPlayer) > this.stopDistance * this.stopDistance) {
            this.entity.getNavigation().moveTo(this.targetPlayer, this.speedModifier);
            System.out.println("FollowPlayerGoal: Moving towards player.");
        } else {
            this.entity.getNavigation().stop();
            System.out.println("FollowPlayerGoal: Close enough to player, stopping.");
        }
    }
}