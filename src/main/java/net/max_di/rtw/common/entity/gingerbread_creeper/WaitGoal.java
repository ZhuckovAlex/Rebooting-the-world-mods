package net.max_di.rtw.common.entity.gingerbread_creeper;

import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class WaitGoal extends Goal {
    private final GingerBreadCreeperEntity entity;

    public WaitGoal(GingerBreadCreeperEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE));
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