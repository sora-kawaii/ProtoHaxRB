/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/Criticals;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "hight", "", "getHight", "()D", "setHight", "(D)V", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Criticals
extends CheatModule {
    private double hight;
    private final ListValue modeValue;

    public Criticals() {
        super("Criticals", false, false, 6, null);
        String string = "Easecation";
        this.modeValue = new ListValue("Mode", new String[]{string}, string);
        this.hight = 2.5;
    }

    public final double getHight() {
        return this.hight;
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketOutbound)object).getPacket();
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Easecation")) {
            double d;
            this.hight = d = this.hight - 0.1;
            if (d < 1.0) {
                this.hight = 2.5;
            }
            if (object instanceof MovePlayerPacket) {
                ((MovePlayerPacket)object).setPosition(Vector3f.from((double)((MovePlayerPacket)object).getPosition().getX(), (double)((MovePlayerPacket)object).getPosition().getY() + this.hight, (double)((MovePlayerPacket)object).getPosition().getZ()));
            }
        }
    }

    public final void setHight(double d) {
        this.hight = d;
    }
}

