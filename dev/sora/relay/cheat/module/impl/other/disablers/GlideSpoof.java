/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other.disablers;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/other/disablers/GlideSpoof;", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "()V", "glideing", "", "onDisable", "", "session", "Ldev/sora/relay/game/GameSession;", "onEnable", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class GlideSpoof
extends DisablerMode {
    private boolean glideing;

    public GlideSpoof() {
        super("GlideSpoof");
    }

    @Override
    public void onDisable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        if (gameSession.getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            PlayerActionPacket playerActionPacket = new PlayerActionPacket();
            playerActionPacket.setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
            playerActionPacket.setAction(PlayerActionType.STOP_GLIDE);
            gameSession.sendPacket(playerActionPacket);
        } else {
            gameSession.getThePlayer().getPendingInputData().add(PlayerAuthInputData.STOP_GLIDING);
        }
        this.glideing = false;
    }

    @Override
    public void onEnable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        if (gameSession.getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            PlayerActionPacket playerActionPacket = new PlayerActionPacket();
            playerActionPacket.setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
            playerActionPacket.setAction(PlayerActionType.START_GLIDE);
            gameSession.sendPacket(playerActionPacket);
            this.glideing = true;
        }
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (bedrockPacket instanceof PlayerActionPacket) {
            if (((PlayerActionPacket)bedrockPacket).getAction() == PlayerActionType.STOP_GLIDE) {
                eventPacketOutbound.cancel();
            }
        } else if (bedrockPacket instanceof PlayerAuthInputPacket && !this.glideing) {
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.NORTH_JUMP);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.JUMP_DOWN);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.JUMPING);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.WANT_UP);
            ((PlayerAuthInputPacket)bedrockPacket).getInputData().add(PlayerAuthInputData.START_GLIDING);
            this.glideing = true;
        }
    }
}

