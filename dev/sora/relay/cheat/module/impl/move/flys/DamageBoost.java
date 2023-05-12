/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move.flys;

import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/module/impl/move/flys/DamageBoost;", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "()V", "boosted", "", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class DamageBoost
extends FlyMode {
    private boolean boosted;

    public DamageBoost() {
        super("Damage Boost");
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketOutbound)object).getPacket();
        if (object instanceof MovePlayerPacket && !this.boosted) {
            ((MovePlayerPacket)object).setPosition(((MovePlayerPacket)object).getPosition().sub(0.0f, 2.0f, 0.0f));
        }
    }

    @Override
    public void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((GameEvent)object).getSession().getThePlayer();
        int n = ((Entity)object).getHurtTime();
        n = 7 <= n && n < 10 ? 1 : 0;
        if (n != 0) {
            this.boosted = true;
            double d = (double)(((Entity)object).getRotationYawHead() + (float)90) * (Math.PI / 180);
            ((EntityPlayerSP)object).setMotion(Math.cos(d) * ((Number)new Fly().getBoostSpeedValue().get()).doubleValue(), 0.0, Math.sin(d) * ((Number)new Fly().getBoostSpeedValue().get()).doubleValue());
            this.boosted = false;
            new Fly().toggle();
        }
    }
}

