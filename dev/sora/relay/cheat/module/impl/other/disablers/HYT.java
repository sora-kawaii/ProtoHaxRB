/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other.disablers;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/cheat/module/impl/other/disablers/HYT;", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "()V", "hight", "", "getHight", "()D", "setHight", "(D)V", "onDisable", "", "session", "Ldev/sora/relay/game/GameSession;", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HYT
extends DisablerMode {
    private double hight = 2000.0;

    public HYT() {
        super("HYT");
    }

    public final double getHight() {
        return this.hight;
    }

    @Override
    public void onDisable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        super.onDisable(gameSession);
        this.hight = 2000.0;
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        if (this.hight < 1000.0) {
            this.hight = 2000.0;
        }
        this.hight -= 5.0;
        super.onPacketOutbound(eventPacketOutbound);
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (bedrockPacket instanceof MovePlayerPacket) {
            ((MovePlayerPacket)bedrockPacket).setOnGround(false);
            ((MovePlayerPacket)bedrockPacket).setPosition(Vector3f.from((double)((MovePlayerPacket)bedrockPacket).getPosition().getX(), this.hight, eventPacketOutbound.getSession().getThePlayer().getPosZ()));
        }
    }

    public final void setHight(double d) {
        this.hight = d;
    }
}

