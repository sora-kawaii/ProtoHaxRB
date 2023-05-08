/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.event.impl;

import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.GameEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Ldev/sora/relay/game/event/impl/EventTick;", "Ldev/sora/relay/game/event/GameEvent;", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EventTick
extends GameEvent {
    public EventTick(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        super(gameSession);
    }
}

