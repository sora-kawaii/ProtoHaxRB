/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move.flys;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Ldev/sora/relay/cheat/module/impl/move/flys/FlagTeleport;", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "()V", "needFly", "", "oldPos", "Lcom/nukkitx/math/vector/Vector3f;", "kotlin.jvm.PlatformType", "targetPos", "onDisable", "", "session", "Ldev/sora/relay/game/GameSession;", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class FlagTeleport
extends FlyMode {
    private boolean needFly;
    private Vector3f oldPos = Vector3f.ZERO;
    private Vector3f targetPos = Vector3f.ZERO;

    public FlagTeleport() {
        super("Flag Teleport");
    }

    @Override
    public void onDisable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.targetPos = gameSession.getThePlayer().getVec3Position();
        EntityPlayerSP entityPlayerSP = gameSession.getThePlayer();
        Vector3f vector3f = this.oldPos;
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"oldPos");
        EntityPlayerSP.teleportTo$default(entityPlayerSP, vector3f, false, 2, null);
        new Fly().toggle();
        gameSession.getThePlayer().setMotion(0.0, 20.0, 0.0);
    }

    @Override
    public void onEnable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.oldPos = gameSession.getThePlayer().getVec3Position();
        this.needFly ^= true;
    }

    @Override
    public void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((EventPacketInbound)object).getPacket() instanceof MovePlayerPacket && ((MovePlayerPacket)((EventPacketInbound)object).getPacket()).getRuntimeEntityId() == ((GameEvent)object).getSession().getThePlayer().getRuntimeId()) {
            object = ((GameEvent)object).getSession().getThePlayer();
            Vector3f vector3f = this.targetPos;
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"targetPos");
            EntityPlayerSP.teleportTo$default((EntityPlayerSP)object, vector3f, false, 2, null);
            new Fly().toggle();
        }
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        if (eventPacketOutbound.getPacket() instanceof MovePlayerPacket && this.needFly) {
            eventPacketOutbound.cancel();
        }
    }

    @Override
    public void onTick(EventTick object) {
        double d;
        double d2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((GameEvent)object).getSession().getThePlayer();
        double d3 = ((EntityPlayerSP)object).getInputData().contains((Object)PlayerAuthInputData.JUMPING) ? (double)((Number)new Fly().getVerticalSpeedValue().get()).floatValue() : (((EntityPlayerSP)object).getInputData().contains((Object)PlayerAuthInputData.SNEAKING) ? -((double)((Number)new Fly().getVerticalSpeedValue().get()).floatValue()) : 0.0391998291015625);
        if (((EntityPlayerSP)object).isHorizontallyMove()) {
            d2 = ((EntityPlayerSP)object).getDirection();
            d = -Math.sin(d2);
            double d4 = ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue();
            d2 = Math.cos(d2);
            double d5 = ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue();
            d *= d4;
            d2 *= d5;
        } else {
            d = 0.0;
            d2 = 0.0;
        }
        ((EntityPlayerSP)object).setMotion(d, d3, d2);
    }
}

