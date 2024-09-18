package net.max_di.rtw.common.entity.gingerbread_man;

import java.util.Arrays;
import java.util.Comparator;

public enum GingerVariant {
    HAPPY(0),
    SIGMA(1),
    MOSKA(2),
    LYBA(3),
    SAD(4),
    DUMB(5),
    LEMON(6)
    ;

    private static final GingerVariant[ ] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt( GingerVariant::getId)).toArray(GingerVariant[]::new);

    private final int id;
    GingerVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static GingerVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
