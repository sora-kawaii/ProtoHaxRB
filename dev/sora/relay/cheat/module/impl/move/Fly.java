/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.cheat.module.impl.move.flys.DamageBoost;
import dev.sora.relay.cheat.module.impl.move.flys.FlagTeleport;
import dev.sora.relay.cheat.module.impl.move.flys.HYT;
import dev.sora.relay.cheat.module.impl.move.flys.Jetpack;
import dev.sora.relay.cheat.module.impl.move.flys.Motion;
import dev.sora.relay.cheat.module.impl.move.flys.Vanilla;
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

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0019H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006\u00a8\u0006\u001a"}, d2={"Ldev/sora/relay/cheat/module/impl/move/Fly;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "boostSpeedValue", "Ldev/sora/relay/cheat/value/FloatValue;", "getBoostSpeedValue", "()Ldev/sora/relay/cheat/value/FloatValue;", "horizontalSpeedValue", "getHorizontalSpeedValue", "mode", "", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "verticalSpeedValue", "getVerticalSpeedValue", "onDisable", "", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class Fly
extends CheatModule {
    private final FloatValue boostSpeedValue;
    private final FloatValue horizontalSpeedValue;
    private final List<FlyMode> mode;
    private final ListValue modeValue;
    private final FloatValue verticalSpeedValue;

    public Fly() {
        super("Fly", false, false, 6, null);
        String string2 = "Vanilla";
        String string3 = "HYT";
        String string4 = "Jetpack";
        String string5 = "Motion";
        String string6 = "Damage Boost";
        String string7 = "Flag Teleport";
        String string8 = "Mode";
        String string9 = "HYT";
        this.modeValue = new ListValue(string8, new String[]{string2, string3, string4, string5, string6, string7}, string9);
        this.mode = CollectionsKt.listOf((Object[])new FlyMode[]{new Vanilla(), new Jetpack(), new Motion(), new HYT(), new DamageBoost(), new FlagTeleport()});
        this.boostSpeedValue = new FloatValue("Boost Speed", 100.0f, 10.0f, 100.0f);
        this.horizontalSpeedValue = new FloatValue("Horizontal Speed", 2.0f, 0.1f, 10.0f);
        this.verticalSpeedValue = new FloatValue("Vertical Speed", 1.5f, 0.1f, 10.0f);
    }

    public final FloatValue getBoostSpeedValue() {
        return this.boostSpeedValue;
    }

    public final FloatValue getHorizontalSpeedValue() {
        return this.horizontalSpeedValue;
    }

    public final FloatValue getVerticalSpeedValue() {
        return this.verticalSpeedValue;
    }

    @Override
    public void onDisable() {
        for (FlyMode flyMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)flyMode.getMode(), this.modeValue.get())) continue;
            flyMode.onDisable(this.getSession());
        }
    }

    @Override
    public void onEnable() {
        for (FlyMode flyMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)flyMode.getMode(), this.modeValue.get())) continue;
            flyMode.onEnable(this.getSession());
        }
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        for (FlyMode flyMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)flyMode.getMode(), this.modeValue.get())) continue;
            flyMode.onPacketInbound(eventPacketInbound);
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        for (FlyMode flyMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)flyMode.getMode(), this.modeValue.get())) continue;
            flyMode.onPacketOutbound(eventPacketOutbound);
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        for (FlyMode flyMode : (Iterable)this.mode) {
            if (!Intrinsics.areEqual((Object)flyMode.getMode(), this.modeValue.get())) continue;
            flyMode.onTick(eventTick);
        }
    }
}

