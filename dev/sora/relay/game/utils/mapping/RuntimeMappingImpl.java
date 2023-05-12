/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.mapping;

import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u00a2\u0006\u0002\u0010\u0007B/\b\u0016\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/game/utils/mapping/RuntimeMappingImpl;", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "data", "", "Lkotlin/Pair;", "", "", "(Ljava/util/List;)V", "runtimeToGameMap", "", "gameToRuntimeMap", "(Ljava/util/Map;Ljava/util/Map;)V", "game", "runtime", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RuntimeMappingImpl
implements RuntimeMapping {
    private final Map<String, Integer> gameToRuntimeMap;
    private final Map<Integer, String> runtimeToGameMap;

    public RuntimeMappingImpl(List<Pair<String, Integer>> object2) {
        Intrinsics.checkNotNullParameter(object2, (String)"data");
        Map map = new LinkedHashMap();
        Map map2 = new LinkedHashMap();
        for (Object object2 : (Iterable)object2) {
            map2.put(((Pair)object2).getFirst(), ((Pair)object2).getSecond());
            map.put(((Pair)object2).getSecond(), ((Pair)object2).getFirst());
        }
        this.runtimeToGameMap = map;
        this.gameToRuntimeMap = map2;
    }

    public RuntimeMappingImpl(Map<Integer, String> map, Map<String, Integer> map2) {
        Intrinsics.checkNotNullParameter(map, (String)"runtimeToGameMap");
        Intrinsics.checkNotNullParameter(map2, (String)"gameToRuntimeMap");
        this.runtimeToGameMap = map;
        this.gameToRuntimeMap = map2;
    }

    @Override
    public String game(int n) {
        String string2;
        String string3 = string2 = this.runtimeToGameMap.get(n);
        if (string2 == null) {
            string3 = "minecraft:unknown";
        }
        return string3;
    }

    @Override
    public int runtime(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"game");
        object = this.gameToRuntimeMap.get(object);
        int n = object != null ? (Integer)object : 0;
        return n;
    }
}

