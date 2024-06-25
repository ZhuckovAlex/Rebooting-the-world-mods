package net.max_di.rebooting_world.common.entity.gingerbread;

import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class WaitGoal extends Goal {
    private final GingerBreadEntity entity;

    public WaitGoal(GingerBreadEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.entity.getFollowState() == GingerBreadEntity.FollowState.WAIT;
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
        System.out.println("WaitGoal: Entity is now waiting.");
    }

    @Override
    public void tick() {
        this.entity.getNavigation().stop();
    }
}