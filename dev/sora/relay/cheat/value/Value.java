/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.value;

import com.google.gson.JsonElement;
import dev.sora.relay.utils.LoggerKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H&J\r\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\tJ*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000eJ\u001d\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\u001fJ\b\u0010!\u001a\u00020\u0015H\u0016J\u0015\u0010\"\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J\n\u0010#\u001a\u0004\u0018\u00010\u0018H&R\u0013\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR*\u0010\u000b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0013\u00a8\u0006$"}, d2={"Ldev/sora/relay/cheat/value/Value;", "T", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "listeners", "", "Lkotlin/Function1;", "Ldev/sora/relay/cheat/value/ValueListener;", "getName", "()Ljava/lang/String;", "getValue", "setValue", "(Ljava/lang/Object;)V", "changeValue", "", "fromJson", "element", "Lcom/google/gson/JsonElement;", "get", "listen", "listener", "onChange", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onChanged", "reset", "set", "toJson", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class Value<T> {
    private final T defaultValue;
    private final List<Function1<T, T>> listeners;
    private final String name;
    private T value;

    public Value(String string2, T t) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        this.name = string2;
        this.value = t;
        this.listeners = new ArrayList();
        this.defaultValue = this.value;
    }

    public void changeValue(T t) {
        this.value = t;
    }

    public abstract void fromJson(JsonElement var1);

    public T get() {
        return this.value;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    public final String getName() {
        return this.name;
    }

    protected final T getValue() {
        return this.value;
    }

    public final Value<T> listen(Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"listener");
        this.listeners.add(function1);
        return this;
    }

    protected void onChange(T t, T t2) {
    }

    protected void onChanged(T t, T t2) {
    }

    public void reset() {
        this.value = this.defaultValue;
    }

    public void set(T t) {
        if (Intrinsics.areEqual(t, this.value)) {
            return;
        }
        T t2 = this.get();
        try {
            this.onChange(t2, t);
            this.changeValue(t);
            this.onChanged(t2, t);
        }
        catch (Exception exception) {
            LoggerKt.logWarn("[ValueSystem (" + this.name + ")]: " + exception.getClass().getName() + " (" + exception.getMessage() + ") [" + t2 + " >> " + t + ']');
        }
    }

    protected final void setValue(T t) {
        this.value = t;
    }

    public abstract JsonElement toJson();
}

