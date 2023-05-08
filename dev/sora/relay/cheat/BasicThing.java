/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.game.GameSession;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/cheat/BasicThing;", "", "()V", "session", "Ldev/sora/relay/game/GameSession;", "getSession", "()Ldev/sora/relay/game/GameSession;", "setSession", "(Ldev/sora/relay/game/GameSession;)V", "chat", "", "msg", "", "Companion", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class BasicThing {
    public static final Companion Companion = new Companion(null);
    public GameSession session;

    protected final void chat(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
        Companion.chat(this.getSession(), string);
    }

    public final GameSession getSession() {
        GameSession gameSession = this.session;
        if (gameSession != null) {
            return gameSession;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"session");
        return null;
    }

    public final void setSession(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"<set-?>");
        this.session = gameSession;
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2={"Ldev/sora/relay/cheat/BasicThing$Companion;", "", "()V", "chat", "", "session", "Ldev/sora/relay/game/GameSession;", "msg", "", "tipChat", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void chat(GameSession object, String string) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"session");
            Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
            if (!((GameSession)object).getNetSessionInitialized()) {
                return;
            }
            RakNetRelaySession rakNetRelaySession = ((GameSession)object).getNetSession();
            object = new TextPacket();
            ((TextPacket)object).setType(TextPacket.Type.RAW);
            ((TextPacket)object).setNeedsTranslation(false);
            ((TextPacket)object).setMessage("\u00a7\u6211[\u00a7bProtoHax\u00a7eRB\u00a7r] " + string);
            string = "";
            ((TextPacket)object).setXuid(string);
            ((TextPacket)object).setSourceName(string);
            rakNetRelaySession.inboundPacket((BedrockPacket)object);
        }

        public final void tipChat(GameSession object, String string) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"session");
            Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
            RakNetRelaySession rakNetRelaySession = ((GameSession)object).getNetSession();
            TextPacket textPacket = new TextPacket();
            textPacket.setType(TextPacket.Type.TIP);
            textPacket.setNeedsTranslation(false);
            object = "";
            textPacket.setSourceName((String)object);
            textPacket.setXuid((String)object);
            textPacket.setMessage(String.valueOf(string));
            rakNetRelaySession.inboundPacket(textPacket);
        }
    }
}

