/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package dev.sora.relay.game.event;

import dev.sora.relay.game.event.GameEvent;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&R\u001a\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2={"Ldev/sora/relay/game/event/Handler;", "", "target", "Ljava/lang/Class;", "Ldev/sora/relay/game/event/GameEvent;", "getTarget", "()Ljava/lang/Class;", "invoke", "", "event", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public interface Handler {
    public Class<? extends GameEvent> getTarget();

    public void invoke(GameEvent var1);
}

