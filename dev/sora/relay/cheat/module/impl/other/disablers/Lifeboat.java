/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other.disablers;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/other/disablers/Lifeboat;", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "()V", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Lifeboat
extends DisablerMode {
    public Lifeboat() {
        super("Lifeboat");
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketOutbound)object).getPacket();
        if (bedrockPacket instanceof MovePlayerPacket) {
            RakNetRelaySession rakNetRelaySession = ((GameEvent)object).getSession().getNetSession();
            object = (MovePlayerPacket)bedrockPacket;
            ((MovePlayerPacket)object).setPosition(((MovePlayerPacket)object).getPosition().add(0.0f, 0.1f, 0.0f));
            rakNetRelaySession.outboundPacket(bedrockPacket);
        }
    }
}

