/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/other/PacketLoss;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "rateValue", "Ldev/sora/relay/cheat/value/FloatValue;", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class PacketLoss
extends CheatModule {
    private final FloatValue rateValue = new FloatValue("Rate", 1.0f, 0.0f, 1.0f);

    public PacketLoss() {
        super("PacketLoss", false, false, 6, null);
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        if (Math.random() <= (double)((Number)this.rateValue.get()).floatValue()) {
            eventPacketOutbound.cancel();
        }
    }
}

