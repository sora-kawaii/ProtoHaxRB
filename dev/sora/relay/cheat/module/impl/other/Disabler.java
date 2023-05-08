/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.other.DisablerMode;
import dev.sora.relay.cheat.module.impl.other.disablers.CPSCancel;
import dev.sora.relay.cheat.module.impl.other.disablers.CubeCraft;
import dev.sora.relay.cheat.module.impl.other.disablers.GlideSpoof;
import dev.sora.relay.cheat.module.impl.other.disablers.HYT;
import dev.sora.relay.cheat.module.impl.other.disablers.Lifeboat;
import dev.sora.relay.cheat.module.impl.other.disablers.Mineplex;
import dev.sora.relay.cheat.module.impl.other.disablers.StackLatencySpoof;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0015H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/cheat/module/impl/other/Disabler;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "mode", "", "Ldev/sora/relay/cheat/module/impl/other/DisablerMode;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "stackLatencyValue", "Ldev/sora/relay/cheat/value/FloatValue;", "getStackLatencyValue", "()Ldev/sora/relay/cheat/value/FloatValue;", "onDisable", "", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Disabler
extends CheatModule {
    private final List<DisablerMode> mode;
    private final ListValue modeValue;
    private final FloatValue stackLatencyValue;

    public Disabler() {
        super("Disabler", false, false, 6, null);
        String string = "CPSCancel";
        String string2 = "Lifeboat";
        String string3 = "Mineplex";
        String string4 = "CubeCraft";
        String string5 = "HYT";
        String string6 = "HYTFly_Old";
        String string7 = "StackLatency Spoof";
        String string8 = "GlideSpoof";
        String string9 = "Mode";
        String string10 = "Lifeboat";
        this.modeValue = new ListValue(string9, new String[]{string, string2, string3, string4, string5, string6, string7, string8}, string10);
        this.mode = CollectionsKt.listOf((Object[])new DisablerMode[]{new CPSCancel(), new Lifeboat(), new Mineplex(), new CubeCraft(), new HYT(), new StackLatencySpoof(), new GlideSpoof()});
        this.stackLatencyValue = new FloatValue("StackLatency", 500.0f, 500.0f, 5000.0f);
    }

    public final FloatValue getStackLatencyValue() {
        return this.stackLatencyValue;
    }

    @Override
    public void onDisable() {
        for (DisablerMode disablerMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)disablerMode.getMode(), this.modeValue.get())) continue;
            disablerMode.onDisable(this.getSession());
        }
    }

    @Override
    public void onEnable() {
        for (DisablerMode disablerMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)disablerMode.getMode(), this.modeValue.get())) continue;
            disablerMode.onEnable(this.getSession());
        }
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        for (DisablerMode disablerMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)disablerMode.getMode(), this.modeValue.get())) continue;
            disablerMode.onPacketInbound(eventPacketInbound);
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        for (DisablerMode disablerMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)disablerMode.getMode(), this.modeValue.get())) continue;
            disablerMode.onPacketOutbound(eventPacketOutbound);
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        for (DisablerMode disablerMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)disablerMode.getMode(), this.modeValue.get())) continue;
            disablerMode.onTick(eventTick);
        }
    }
}

