/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.entity;

import dev.sora.relay.game.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/sora/relay/game/entity/EntityUnknown;", "Ldev/sora/relay/game/entity/Entity;", "runtimeId", "", "type", "", "(JLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EntityUnknown
extends Entity {
    private final String type;

    public EntityUnknown(long l, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"type");
        super(l);
        this.type = string;
    }

    public final String getType() {
        return this.type;
    }
}

