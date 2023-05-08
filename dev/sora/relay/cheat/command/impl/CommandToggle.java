/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package dev.sora.relay.cheat.command.impl;

import dev.sora.relay.cheat.command.Command;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.ModuleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/command/impl/CommandToggle;", "Ldev/sora/relay/cheat/command/Command;", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "(Ldev/sora/relay/cheat/module/ModuleManager;)V", "exec", "", "args", "", "", "([Ljava/lang/String;)V", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class CommandToggle
extends Command {
    private final ModuleManager moduleManager;

    public CommandToggle(ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter((Object)moduleManager, (String)"moduleManager");
        super("toggle", "t");
        this.moduleManager = moduleManager;
    }

    @Override
    public void exec(String[] object) {
        StringBuilder stringBuilder2;
        block3: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"args");
            boolean bl = ((String[])object).length == 0;
            if (bl) {
                this.chat("-t <module>");
                return;
            }
            for (StringBuilder stringBuilder2 : (Iterable)this.moduleManager.getModules()) {
                if (!StringsKt.equals((String)((CheatModule)((Object)stringBuilder2)).getName(), (String)object[0], (boolean)true)) continue;
                break block3;
            }
            stringBuilder2 = null;
        }
        CheatModule cheatModule = (CheatModule)((Object)stringBuilder2);
        if (cheatModule == null) {
            this.chat("no such module called " + object[0] + " found");
            return;
        }
        cheatModule.setState(true ^ cheatModule.getState());
        stringBuilder2 = new StringBuilder().append("module ").append(cheatModule.getName()).append(" toggled ");
        object = cheatModule.getState() ? "on" : "off";
        this.chat(stringBuilder2.append((String)object).toString());
    }
}

