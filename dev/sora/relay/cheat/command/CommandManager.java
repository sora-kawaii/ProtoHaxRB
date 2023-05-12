/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.command;

import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.cheat.BasicThing;
import dev.sora.relay.cheat.command.Command;
import dev.sora.relay.cheat.command.impl.CommandModule;
import dev.sora.relay.cheat.command.impl.CommandToggle;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.ModuleManager;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.Listener;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.utils.LoggerKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Ldev/sora/relay/cheat/command/CommandManager;", "Ldev/sora/relay/game/event/Listener;", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "commandMap", "", "", "Ldev/sora/relay/cheat/command/Command;", "getCommandMap", "()Ljava/util/Map;", "exec", "", "msg", "init", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "listen", "", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "registerCommand", "command", "Companion", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class CommandManager
implements Listener {
    public static final Companion Companion = new Companion(null);
    public static final String PREFIX = "-";
    private final Map<String, Command> commandMap;
    private final GameSession session;

    public CommandManager(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.session = gameSession;
        this.commandMap = new LinkedHashMap();
    }

    public final void exec(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"msg");
        object = ((Collection)StringsKt.split$default((CharSequence)((CharSequence)object), (String[])new String[]{" "}, (boolean)false, (int)0, (int)6, null)).toArray(new String[0]);
        Object object2 = this.commandMap;
        String string2 = object[0].toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).toLowerCase(Locale.ROOT)");
        object2 = object2.get(string2);
        if (object2 == null) {
            BasicThing.Companion.chat(this.session, "Command not found");
            return;
        }
        try {
            ((Command)object2).exec((String[])ArraysKt.copyOfRange((Object[])object, (int)1, (int)((String[])object).length));
        }
        catch (Exception exception) {
            object = exception;
            LoggerKt.logError("execute command", (Throwable)object);
            BasicThing.Companion.chat(this.session, "An error occurred while executing the command(" + exception + ')');
        }
    }

    public final Map<String, Command> getCommandMap() {
        return this.commandMap;
    }

    public final void init(ModuleManager object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"moduleManager");
        this.registerCommand(new CommandToggle((ModuleManager)object));
        for (CheatModule cheatModule : (Iterable)((ModuleManager)object).getModules()) {
            if (cheatModule.getValues().isEmpty()) continue;
            this.registerCommand(new CommandModule(cheatModule));
        }
    }

    @Override
    public boolean listen() {
        return true;
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        Object object = eventPacketOutbound.getPacket();
        if (object instanceof TextPacket) {
            String string2 = ((TextPacket)object).getMessage();
            String string3 = "packet.message";
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)string3);
            if (StringsKt.startsWith$default((String)string2, (String)PREFIX, (boolean)false, (int)2, null)) {
                object = ((TextPacket)object).getMessage();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)string3);
                string3 = ((String)object).substring(1);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).substring(startIndex)");
                this.exec(string3);
                eventPacketOutbound.cancel();
            }
        }
    }

    public final void registerCommand(Command command) {
        Intrinsics.checkNotNullParameter((Object)command, (String)"command");
        for (String string2 : command.getAlias()) {
            this.commandMap.put(string2, command);
        }
        command.setSession(this.session);
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Ldev/sora/relay/cheat/command/CommandManager$Companion;", "", "()V", "PREFIX", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

