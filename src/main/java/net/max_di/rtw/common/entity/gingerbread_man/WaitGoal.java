package net.max_di.rtw.common.entity.gingerbread_man;

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
        return this.entity.getCommand()==2;
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.entity.getNavigation().stop();
    }
}