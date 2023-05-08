/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.game.event.GameEventCancelable;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.utils.TimerUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Ldev/sora/relay/cheat/module/impl/other/Blink;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "packetList", "", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "pulseDelayValue", "Ldev/sora/relay/cheat/value/FloatValue;", "pulseTimer", "Ldev/sora/relay/utils/TimerUtil;", "pulseValue", "Ldev/sora/relay/cheat/value/BoolValue;", "onDisable", "", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Blink
extends CheatModule {
    private final List<BedrockPacket> packetList;
    private final FloatValue pulseDelayValue;
    private final TimerUtil pulseTimer;
    private final BoolValue pulseValue = new BoolValue("Pulse", false);

    public Blink() {
        super("Blink", false, false, 6, null);
        this.pulseDelayValue = new FloatValue("Pulse Delay", 500.0f, 500.0f, 5000.0f);
        this.packetList = new ArrayList();
        this.pulseTimer = new TimerUtil();
    }

    @Override
    public void onDisable() {
        for (BedrockPacket bedrockPacket : this.packetList) {
            this.getSession().getNetSession().outboundPacket(bedrockPacket);
        }
        this.packetList.clear();
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        this.packetList.add(((EventPacketOutbound)object).getPacket());
        ((GameEventCancelable)object).cancel();
        if (((Boolean)this.pulseValue.get()).booleanValue() && this.pulseTimer.isDelayComplete(((Number)this.pulseDelayValue.get()).floatValue())) {
            for (BedrockPacket bedrockPacket : this.packetList) {
                this.getSession().getNetSession().outboundPacket(bedrockPacket);
            }
            this.packetList.clear();
            this.pulseTimer.reset();
        }
    }
}

