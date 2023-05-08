/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.command;

import dev.sora.relay.cheat.BasicThing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a2\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Ldev/sora/relay/cheat/command/Command;", "Ldev/sora/relay/cheat/BasicThing;", "alias", "", "", "([Ljava/lang/String;)V", "getAlias", "()[Ljava/lang/String;", "[Ljava/lang/String;", "exec", "", "args", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class Command
extends BasicThing {
    private final String[] alias;

    public Command(String ... object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"alias");
        int n = ((String[])object).length == 0 ? 1 : 0;
        if (n == 0) {
            Collection collection = new ArrayList(((String[])object).length);
            for (String string : object) {
                collection.add(string);
            }
            object = (List)collection;
            object = (Collection)object;
            this.alias = object.toArray(new String[0]);
            return;
        }
        throw new IllegalArgumentException("there must be an name for a command");
    }

    public abstract void exec(String[] var1);

    public final String[] getAlias() {
        return this.alias;
    }
}

