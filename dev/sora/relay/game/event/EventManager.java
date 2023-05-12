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
import dev.sora.relay.game.event.HandlerFunction;
import dev.sora.relay.game.event.HandlerMethod;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.Listener;
import dev.sora.relay.utils.LoggerKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J2\u0010\f\u001a\u00020\n\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\n0\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015R(\u0010\u0003\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/game/event/EventManager;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Ldev/sora/relay/game/event/GameEvent;", "", "Ldev/sora/relay/game/event/Handler;", "emit", "", "event", "registerFunction", "T", "target", "func", "Lkotlin/Function1;", "registerHandler", "handler", "registerListener", "listener", "Ldev/sora/relay/game/event/Listener;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EventManager {
    private final Map<Class<? extends GameEvent>, List<Handler>> handlers = new LinkedHashMap();

    public final void emit(GameEvent gameEvent) {
        String string2 = "event";
        Intrinsics.checkNotNullParameter((Object)gameEvent, (String)string2);
        Object object = this.handlers.get(gameEvent.getClass());
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            Handler handler = (Handler)object.next();
            try {
                handler.invoke(gameEvent);
            }
            catch (Throwable throwable) {
                LoggerKt.logError(string2, throwable);
            }
        }
    }

    public final <T extends GameEvent> void registerFunction(Class<T> clazz, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(clazz, (String)"target");
        Intrinsics.checkNotNullParameter(function1, (String)"func");
        this.registerHandler(new HandlerFunction<T>(function1, clazz));
    }

    public final void registerHandler(Handler handler) {
        List list;
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        List list2 = list = this.handlers.get(handler.getTarget());
        if (list == null) {
            list2 = new ArrayList();
            this.handlers.put(handler.getTarget(), list2);
        }
        list2.add((Handler)handler);
    }

    public final void registerListener(Listener listener) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        Method[] methodArray = listener.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue((Object)methodArray, (String)"listener.javaClass.declaredMethods");
        for (Method method : methodArray) {
            if (!method.isAnnotationPresent(Listen.class)) continue;
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"method");
            this.registerHandler(new HandlerMethod(method, listener));
        }
    }
}

