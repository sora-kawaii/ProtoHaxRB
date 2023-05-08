/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.mapping;

import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/game/utils/mapping/EmptyRuntimeMapping;", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "fallbackGame", "", "fallbackRuntime", "", "(Ljava/lang/String;I)V", "game", "runtime", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EmptyRuntimeMapping
implements RuntimeMapping {
    private final String fallbackGame;
    private final int fallbackRuntime;

    public EmptyRuntimeMapping() {
        this(null, 0, 3, null);
    }

    public EmptyRuntimeMapping(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"fallbackGame");
        this.fallbackGame = string;
        this.fallbackRuntime = n;
    }

    public /* synthetic */ EmptyRuntimeMapping(String string, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            string = "minecraft:unknown";
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        this(string, n);
    }

    @Override
    public String game(int n) {
        return this.fallbackGame;
    }

    @Override
    public int runtime(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"game");
        return this.fallbackRuntime;
    }
}

