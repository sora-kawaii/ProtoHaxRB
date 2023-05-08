/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other.disablers;

import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/other/disablers/Mineplex;", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "()V", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Mineplex
extends DisablerMode {
    public Mineplex() {
        super("Mineplex");
    }

    @Override
    public void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        RakNetRelaySession rakNetRelaySession = eventTick.getSession().getNetSession();
        MovePlayerPacket movePlayerPacket = new MovePlayerPacket();
        movePlayerPacket.setRuntimeEntityId(eventTick.getSession().getThePlayer().getRuntimeId());
        movePlayerPacket.setPosition(eventTick.getSession().getThePlayer().getVec3Position());
        movePlayerPacket.setRotation(eventTick.getSession().getThePlayer().getVec3Rotation());
        movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
        movePlayerPacket.setOnGround(true);
        rakNetRelaySession.outboundPacket(movePlayerPacket);
    }
}

