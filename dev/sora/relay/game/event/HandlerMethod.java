/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.event;

import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Handler;
import dev.sora.relay.game.event.Listener;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2={"Ldev/sora/relay/game/event/HandlerMethod;", "Ldev/sora/relay/game/event/Handler;", "method", "Ljava/lang/reflect/Method;", "listener", "Ldev/sora/relay/game/event/Listener;", "(Ljava/lang/reflect/Method;Ldev/sora/relay/game/event/Listener;)V", "target", "Ljava/lang/Class;", "Ldev/sora/relay/game/event/GameEvent;", "getTarget", "()Ljava/lang/Class;", "invoke", "", "event", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HandlerMethod
implements Handler {
    private final Listener listener;
    private final Method method;
    private final Class<? extends GameEvent> target;

    public HandlerMethod(Method genericDeclaration, Listener listener) {
        Intrinsics.checkNotNullParameter((Object)genericDeclaration, (String)"method");
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        this.method = genericDeclaration;
        this.listener = listener;
        if (!genericDeclaration.isAccessible()) {
            genericDeclaration.setAccessible(true);
        }
        genericDeclaration = genericDeclaration.getParameterTypes()[0];
        Intrinsics.checkNotNull((Object)genericDeclaration, (String)"null cannot be cast to non-null type java.lang.Class<out dev.sora.relay.game.event.GameEvent>");
        this.target = genericDeclaration;
    }

    @Override
    public Class<? extends GameEvent> getTarget() {
        return this.target;
    }

    @Override
    public void invoke(GameEvent gameEvent) {
        Intrinsics.checkNotNullParameter((Object)gameEvent, (String)"event");
        if (this.listener.listen()) {
            try {
                this.method.invoke(this.listener, gameEvent);
            }
            catch (Throwable throwable) {
                new Exception("An error occurred while handling the event: ", throwable).printStackTrace();
            }
        }
    }
}

