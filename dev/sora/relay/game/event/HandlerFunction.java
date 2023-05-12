/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.event;

import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/game/event/HandlerFunction;", "T", "Ldev/sora/relay/game/event/GameEvent;", "Ldev/sora/relay/game/event/Handler;", "func", "Lkotlin/Function1;", "", "target", "Ljava/lang/Class;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Class;)V", "getTarget", "()Ljava/lang/Class;", "invoke", "event", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HandlerFunction<T extends GameEvent>
implements Handler {
    private final Function1<T, Unit> func;
    private final Class<T> target;

    public HandlerFunction(Function1<? super T, Unit> function1, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(function1, (String)"func");
        Intrinsics.checkNotNullParameter(clazz, (String)"target");
        this.func = function1;
        this.target = clazz;
    }

    public Class<T> getTarget() {
        return this.target;
    }

    @Override
    public void invoke(GameEvent gameEvent) {
        Intrinsics.checkNotNullParameter((Object)gameEvent, (String)"event");
        this.func.invoke((Object)gameEvent);
    }
}

