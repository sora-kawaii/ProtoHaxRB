/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move.flys;

import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/move/flys/Jetpack;", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "()V", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Jetpack
extends FlyMode {
    public Jetpack() {
        super("Jetpack");
    }

    @Override
    public void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((GameEvent)object).getSession().getThePlayer();
        double d = (double)(((Entity)object).getRotationYawHead() + (float)90) * (Math.PI / 180);
        double d2 = (double)((Entity)object).getRotationPitch() * (-Math.PI / 180);
        ((EntityPlayerSP)object).setMotion(Math.cos(d) * Math.cos(d2) * ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue(), Math.sin(d2) * ((Number)new Fly().getVerticalSpeedValue().get()).doubleValue(), Math.sin(d) * Math.cos(d2) * ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue());
    }
}

