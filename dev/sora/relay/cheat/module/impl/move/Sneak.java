/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/move/Sneak;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "sneaking", "", "onDisable", "", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Sneak
extends CheatModule {
    private boolean sneaking;

    public Sneak() {
        super("Sneak", false, false, 6, null);
    }

    @Override
    public void onDisable() {
        if (this.getSession().getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            PlayerActionPacket playerActionPacket = new PlayerActionPacket();
            playerActionPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            playerActionPacket.setAction(PlayerActionType.STOP_SNEAK);
            playerActionPacket.setBlockPosition(Vector3i.ZERO);
            playerActionPacket.setResultPosition(Vector3i.ZERO);
            playerActionPacket.setFace(0);
            rakNetRelaySession.outboundPacket(playerActionPacket);
        } else {
            this.getSession().getThePlayer().getPendingInputData().add(PlayerAuthInputData.STOP_GLIDING);
        }
    }

    @Override
    public void onEnable() {
        this.sneaking = false;
        if (this.getSession().getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            PlayerActionPacket playerActionPacket = new PlayerActionPacket();
            playerActionPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            playerActionPacket.setAction(PlayerActionType.START_SNEAK);
            playerActionPacket.setBlockPosition(Vector3i.ZERO);
            playerActionPacket.setResultPosition(Vector3i.ZERO);
            playerActionPacket.setFace(0);
            rakNetRelaySession.outboundPacket(playerActionPacket);
        }
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        this.sneaking = false;
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (this.getSession().getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            if (bedrockPacket instanceof PlayerActionPacket && (((PlayerActionPacket)bedrockPacket).getAction() == PlayerActionType.START_SNEAK || ((PlayerActionPacket)bedrockPacket).getAction() == PlayerActionType.STOP_SNEAK)) {
                eventPacketOutbound.cancel();
            }
        } else if (bedrockPacket instanceof PlayerAuthInputPacket) {
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.SNEAKING);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.SNEAK_DOWN);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.WANT_DOWN);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().remove((Object)PlayerAuthInputData.STOP_SNEAKING);
            if (!this.sneaking) {
                ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.START_SNEAKING);
                this.sneaking = true;
            }
        }
    }
}

