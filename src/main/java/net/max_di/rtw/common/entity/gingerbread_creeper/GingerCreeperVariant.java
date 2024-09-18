package net.max_di.rtw.common.entity.gingerbread_creeper;

import java.util.Arrays;
import java.util.Comparator;

public enum GingerCreeperVariant {
    ANGRY(0),
    BOBIK(1),//WHATS THIS
    SAD(2),
    SILLY(3)
    ;

    private static final GingerCreeperVariant[ ] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt( GingerCreeperVariant::getId)).toArray(GingerCreeperVariant[]::new);

    private final int id;
    GingerCreeperVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static GingerCreeperVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
