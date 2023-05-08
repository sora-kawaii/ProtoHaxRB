/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/module/impl/move/NoLagBack;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "lagBackCheckValue", "Ldev/sora/relay/cheat/value/BoolValue;", "noSetPosValue", "noSetRotateValue", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NoLagBack
extends CheatModule {
    private final BoolValue lagBackCheckValue = new BoolValue("lagBack Report", false);
    private final BoolValue noSetPosValue;
    private final BoolValue noSetRotateValue = new BoolValue("No SetRotate", true);

    public NoLagBack() {
        super("NoLagBack", false, false, 6, null);
        this.noSetPosValue = new BoolValue("No SetPosition", false);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (bedrockPacket instanceof MovePlayerPacket && ((MovePlayerPacket)bedrockPacket).getRuntimeEntityId() == eventPacketInbound.getSession().getThePlayer().getRuntimeId()) {
            if (((Boolean)this.lagBackCheckValue.get()).booleanValue()) {
                MovePlayerPacket.Mode mode = ((MovePlayerPacket)bedrockPacket).getMode();
                MovePlayerPacket.Mode mode2 = MovePlayerPacket.Mode.TELEPORT;
                String string = "LagBack Position";
                if (mode == mode2) {
                    this.chat(string + ((MovePlayerPacket)bedrockPacket).getPosition() + " Rotation" + ((MovePlayerPacket)bedrockPacket).getRotation());
                } else {
                    this.chat(string + ((MovePlayerPacket)bedrockPacket).getPosition());
                }
            }
            if (((Boolean)this.noSetRotateValue.get()).booleanValue() && ((MovePlayerPacket)bedrockPacket).getMode() == MovePlayerPacket.Mode.TELEPORT) {
                ((MovePlayerPacket)bedrockPacket).setRotation(eventPacketInbound.getSession().getThePlayer().getVec3Rotation());
            }
            if (((Boolean)this.noSetPosValue.get()).booleanValue()) {
                ((MovePlayerPacket)bedrockPacket).setPosition(eventPacketInbound.getSession().getThePlayer().getVec3Position());
            }
        }
    }
}

