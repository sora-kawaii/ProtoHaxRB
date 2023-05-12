/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other.disablers;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.NetworkStackLatencyPacket;
import dev.sora.relay.cheat.module.impl.other.Disabler;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.utils.TimerUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ldev/sora/relay/cheat/module/impl/other/disablers/StackLatencySpoof;", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "()V", "boundTimer", "Ldev/sora/relay/utils/TimerUtil;", "latencyPacketList", "", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class StackLatencySpoof
extends DisablerMode {
    private final TimerUtil boundTimer;
    private final List<BedrockPacket> latencyPacketList = new ArrayList();

    public StackLatencySpoof() {
        super("StackLatency Spoof");
        this.boundTimer = new TimerUtil();
    }

    @Override
    public void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (bedrockPacket instanceof NetworkStackLatencyPacket) {
            this.latencyPacketList.add(bedrockPacket);
            eventPacketInbound.cancel();
        }
        if (this.boundTimer.isDelayComplete(((Number)new Disabler().getStackLatencyValue().get()).floatValue())) {
            for (BedrockPacket bedrockPacket2 : this.latencyPacketList) {
                eventPacketInbound.getSession().getNetSession().inboundPacket(bedrockPacket2);
            }
            this.boundTimer.reset();
        }
    }
}

