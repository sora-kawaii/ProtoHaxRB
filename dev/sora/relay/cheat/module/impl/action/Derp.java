/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.game.utils.math.MathUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/cheat/module/impl/action/Derp;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "customPitch", "Ldev/sora/relay/cheat/value/FloatValue;", "customYaw", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onlyHead", "Ldev/sora/relay/cheat/value/BoolValue;", "pitch", "", "rotationAngle", "Lcom/nukkitx/math/vector/Vector3f;", "spinSpeed", "yaw", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Derp
extends CheatModule {
    private final FloatValue customPitch;
    private final FloatValue customYaw;
    private final ListValue modeValue;
    private final BoolValue onlyHead;
    private float pitch;
    private Vector3f rotationAngle;
    private final FloatValue spinSpeed;
    private float yaw;

    public Derp() {
        super("Derp", false, false, 6, null);
        String string = "Random";
        String string2 = "Pitch Spin";
        Object object = "Yaw Spin";
        String string3 = "Custom";
        this.modeValue = new ListValue("Mode", new String[]{string, string2, object, string3}, string);
        this.customPitch = new FloatValue("Custom Pitch", 90.0f, -180.0f, 180.0f);
        this.customYaw = new FloatValue("Custom Yaw", 90.0f, -180.0f, 180.0f);
        this.spinSpeed = new FloatValue("Spin Speed", 1.0f, 1.0f, 20.0f);
        this.onlyHead = new BoolValue("Only Head", false);
        object = Vector3f.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ZERO");
        this.rotationAngle = object;
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketOutbound)object).getPacket();
        if (object instanceof MovePlayerPacket) {
            ((MovePlayerPacket)object).setRotation(this.rotationAngle);
        } else if (object instanceof PlayerAuthInputPacket) {
            ((PlayerAuthInputPacket)object).setRotation(this.rotationAngle);
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        EntityPlayerSP entityPlayerSP = eventTick.getSession().getThePlayer();
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Random")) {
            float f = (Boolean)this.onlyHead.get() != false ? entityPlayerSP.getRotationYawHead() : (float)MathUtils.rand(-180.0f, 180.0f);
            object = Vector3f.from((float)MathUtils.rand(-90.0f, 90.0f), (float)MathUtils.rand(-180.0f, 180.0f), f);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(rand(-90f,90f).toFl\u2026,180f).toFloat(),headYaw)");
            this.rotationAngle = object;
        } else if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Pitch Spin")) {
            object = Vector3f.from(this.pitch, entityPlayerSP.getRotationYaw(), entityPlayerSP.getRotationYawHead());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(pitch,thePlayer.rot\u2026hePlayer.rotationYawHead)");
            this.rotationAngle = object;
            float f = this.pitch;
            this.pitch = f < 180.0f ? f + ((Number)this.spinSpeed.get()).floatValue() : -180.0f;
        } else if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Yaw Spin")) {
            float f = (Boolean)this.onlyHead.get() != false ? entityPlayerSP.getRotationYawHead() : this.yaw;
            object = Vector3f.from(80.0f, this.yaw, f);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(80f,yaw,headYaw)");
            this.rotationAngle = object;
            f = this.yaw;
            this.yaw = f < 180.0f ? f + ((Number)this.spinSpeed.get()).floatValue() : -180.0f;
        } else if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Custom")) {
            float f = (Boolean)this.onlyHead.get() != false ? entityPlayerSP.getRotationYawHead() : ((Number)this.customYaw.get()).floatValue();
            object = Vector3f.from(((Number)this.customPitch.get()).floatValue(), ((Number)this.customYaw.get()).floatValue(), f);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(customPitch.get(),customYaw.get(),headYaw)");
            this.rotationAngle = object;
        }
        if (Intrinsics.areEqual((Object)entityPlayerSP.getVec3PrevPosition(), (Object)entityPlayerSP.getVec3Position()) && Intrinsics.areEqual((Object)entityPlayerSP.getVec3PrevRotation(), (Object)entityPlayerSP.getVec3Rotation())) {
            GameSession gameSession = this.getSession();
            object = new MovePlayerPacket();
            ((MovePlayerPacket)object).setRuntimeEntityId(entityPlayerSP.getRuntimeId());
            ((MovePlayerPacket)object).setPosition(entityPlayerSP.getVec3Position());
            ((MovePlayerPacket)object).setRotation(entityPlayerSP.getVec3Rotation());
            ((MovePlayerPacket)object).setMode(MovePlayerPacket.Mode.NORMAL);
            ((MovePlayerPacket)object).setOnGround(entityPlayerSP.getOnGround());
            ((MovePlayerPacket)object).setRidingRuntimeEntityId(0L);
            ((MovePlayerPacket)object).setEntityType(0);
            ((MovePlayerPacket)object).setTick(eventTick.getSession().getTickExists());
            gameSession.sendPacket((BedrockPacket)object);
        }
    }
}

