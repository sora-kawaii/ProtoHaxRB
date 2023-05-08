/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.event;

import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.GameEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/sora/relay/game/event/GameEventCancelable;", "Ldev/sora/relay/game/event/GameEvent;", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "canceled", "", "cancel", "", "isCanceled", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class GameEventCancelable
extends GameEvent {
    private boolean canceled;

    public GameEventCancelable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        super(gameSession);
    }

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCanceled() {
        return this.canceled;
    }
}

