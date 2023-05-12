/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAttributesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/cheat/module/impl/move/Speed;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "hopSpeedValue", "Ldev/sora/relay/cheat/value/FloatValue;", "lowHopHeightValue", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "sped", "", "vanillaSpeedValue", "EventPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onDisable", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Speed
extends CheatModule {
    private final FloatValue hopSpeedValue;
    private final FloatValue lowHopHeightValue;
    private final ListValue modeValue;
    private boolean sped;
    private final FloatValue vanillaSpeedValue;

    public Speed() {
        super("Speed", false, false, 6, null);
        String string2 = "Vanilla";
        String string3 = "Hop";
        this.modeValue = new ListValue("Mode", new String[]{string2, string3}, string3);
        this.vanillaSpeedValue = new FloatValue("Vanilla Speed", 0.3f, 0.1f, 5.0f);
        this.hopSpeedValue = new FloatValue("Hop Speed", 0.5f, 0.3f, 2.0f);
        this.lowHopHeightValue = new FloatValue("Hop Height", 0.2f, 0.1f, 1.0f);
    }

    @Listen
    public final void EventPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (!((GameEvent)object).getSession().getThePlayer().isHorizontallyMove()) {
            return;
        }
        if (new Fly().getState()) {
            return;
        }
        double d = ((GameEvent)object).getSession().getThePlayer().getDirection();
        object = (String)this.modeValue.get();
        if (Intrinsics.areEqual((Object)object, (Object)"Vanilla")) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            UpdateAttributesPacket updateAttributesPacket = new UpdateAttributesPacket();
            updateAttributesPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            object = updateAttributesPacket.getAttributes();
            float f = ((Number)this.vanillaSpeedValue.get()).floatValue();
            object.add(new AttributeData("minecraft:movement", 0.0f, Float.MAX_VALUE, f, 0.1f));
            rakNetRelaySession.inboundPacket(updateAttributesPacket);
        } else if (Intrinsics.areEqual((Object)object, (Object)"Hop")) {
            if (this.getSession().getThePlayer().getOnGround()) {
                this.sped = false;
                if (this.getSession().getMovementMode() == AuthoritativeMovementMode.CLIENT) {
                    object = this.getSession().getNetSession();
                    PlayerActionPacket playerActionPacket = new PlayerActionPacket();
                    playerActionPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                    playerActionPacket.setAction(PlayerActionType.JUMP);
                    ((RakNetRelaySession)object).inboundPacket(playerActionPacket);
                }
                this.getSession().getThePlayer().setMotion(-Math.sin(d) * ((Number)this.hopSpeedValue.get()).doubleValue(), ((Number)this.lowHopHeightValue.get()).floatValue(), Math.cos(d) * ((Number)this.hopSpeedValue.get()).doubleValue());
                this.sped = true;
            } else if (this.getSession().getThePlayer().getMotionY() < 0.1 && this.getSession().getThePlayer().getMotionY() > -0.1) {
                this.sped = false;
            } else if (this.getSession().getThePlayer().getMotionY() < -0.0784 && !this.sped) {
                this.getSession().getThePlayer().setMotion(-Math.sin(d) * ((Number)this.hopSpeedValue.get()).doubleValue(), this.getSession().getThePlayer().getMotionY(), Math.cos(d) * ((Number)this.hopSpeedValue.get()).doubleValue());
                this.sped = true;
            }
        }
    }

    @Override
    public void onDisable() {
        this.sped = false;
        if (!this.getSession().getNetSessionInitialized()) {
            return;
        }
        RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
        UpdateAttributesPacket updateAttributesPacket = new UpdateAttributesPacket();
        updateAttributesPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
        updateAttributesPacket.getAttributes().add(this.getSession().getThePlayer().getAttributes().get("minecraft:movement"));
        rakNetRelaySession.inboundPacket(updateAttributesPacket);
    }
}

