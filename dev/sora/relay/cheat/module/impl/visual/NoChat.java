/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/NoChat;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "objectValue", "Ldev/sora/relay/cheat/value/ListValue;", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NoChat
extends CheatModule {
    private final ListValue objectValue;

    public NoChat() {
        super("NoChat", false, false, 6, null);
        String string2 = "All Chat";
        String string3 = "HYT Horn";
        this.objectValue = new ListValue("Object", new String[]{string2, string3}, string2);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (bedrockPacket instanceof TextPacket) {
            String string2 = (String)this.objectValue.get();
            if (Intrinsics.areEqual((Object)string2, (Object)"All Chat")) {
                eventPacketInbound.cancel();
            } else if (Intrinsics.areEqual((Object)string2, (Object)"HYT Horn") && (((TextPacket)bedrockPacket).getType() == TextPacket.Type.POPUP || ((TextPacket)bedrockPacket).getType() == TextPacket.Type.CHAT)) {
                eventPacketInbound.cancel();
            }
        }
    }
}

