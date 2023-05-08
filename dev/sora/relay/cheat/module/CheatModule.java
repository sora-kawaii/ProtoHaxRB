/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package dev.sora.relay.cheat.module;

import dev.sora.relay.cheat.BasicThing;
import dev.sora.relay.cheat.value.Value;
import dev.sora.relay.game.event.Listener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0012\u001a\r\u0012\u0002\b\u0003\u0018\u00010\u0013\u00a2\u0006\u0002\b\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u0015\u0010\u0016\u001a\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0013\u00a2\u0006\u0002\b\u00140\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2={"Ldev/sora/relay/cheat/module/CheatModule;", "Ldev/sora/relay/cheat/BasicThing;", "Ldev/sora/relay/game/event/Listener;", "name", "", "defaultOn", "", "canToggle", "(Ljava/lang/String;ZZ)V", "getCanToggle", "()Z", "getDefaultOn", "getName", "()Ljava/lang/String;", "state", "getState", "setState", "(Z)V", "getValue", "Ldev/sora/relay/cheat/value/Value;", "Lkotlin/internal/NoInfer;", "valueName", "getValues", "", "listen", "onDisable", "", "onEnable", "toggle", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class CheatModule
extends BasicThing
implements Listener {
    private final boolean canToggle;
    private final boolean defaultOn;
    private final String name;
    private boolean state;

    public CheatModule(String string, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        this.name = string;
        this.defaultOn = bl;
        this.canToggle = bl2;
        this.state = bl;
    }

    public /* synthetic */ CheatModule(String string, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = true;
        }
        this(string, bl, bl2);
    }

    public final boolean getCanToggle() {
        return this.canToggle;
    }

    public final boolean getDefaultOn() {
        return this.defaultOn;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getState() {
        return this.state;
    }

    public final Value<?> getValue(String string) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"valueName");
            for (Object t : (Iterable)this.getValues()) {
                if (!StringsKt.equals((String)((Value)t).getName(), (String)string, (boolean)true)) continue;
                string = t;
                break block1;
            }
            string = null;
        }
        return (Value)((Object)string);
    }

    public final List<Value<?>> getValues() {
        Object object = this.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"javaClass.declaredFields");
        Object[] objectArray = (Object[])object;
        Iterable iterable2 = new ArrayList(objectArray.length);
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            object = (Field)objectArray[i];
            ((Field)object).setAccessible(true);
            iterable2.add(((Field)object).get(this));
        }
        object = (List)iterable2;
        iterable2 = (Iterable)object;
        object = new ArrayList();
        for (Iterable iterable2 : iterable2) {
            if (!(iterable2 instanceof Value)) continue;
            object.add(iterable2);
        }
        object = (List)object;
        return object;
    }

    @Override
    public boolean listen() {
        return this.state;
    }

    public void onDisable() {
        BasicThing.Companion.chat(this.getSession(), ">> " + this.name + " Disabled \u25a1");
    }

    public void onEnable() {
        BasicThing.Companion.chat(this.getSession(), ">> " + this.name + " Enabled \u25a0");
    }

    public final void setState(boolean bl) {
        if (this.state == bl) {
            return;
        }
        if (!this.canToggle) {
            this.onEnable();
            return;
        }
        this.state = bl;
        if (bl) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public void toggle() {
        this.setState(this.state ^ true);
    }
}

