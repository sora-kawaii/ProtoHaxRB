/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.event.impl;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.GameEventCancelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "Ldev/sora/relay/game/event/GameEventCancelable;", "session", "Ldev/sora/relay/game/GameSession;", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "(Ldev/sora/relay/game/GameSession;Lcom/nukkitx/protocol/bedrock/BedrockPacket;)V", "getPacket", "()Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EventPacketOutbound
extends GameEventCancelable {
    private final BedrockPacket packet;

    public EventPacketOutbound(GameSession gameSession, BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        super(gameSession);
        this.packet = bedrockPacket;
    }

    public final BedrockPacket getPacket() {
        return this.packet;
    }
}

