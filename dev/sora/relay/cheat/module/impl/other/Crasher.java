/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.packet.AnimatePacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/other/Crasher;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Crasher
extends CheatModule {
    private final ListValue modeValue;

    public Crasher() {
        super("Crasher", false, false, 6, null);
        String string = "Critical hit";
        this.modeValue = new ListValue("Mode", new String[]{string}, string);
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (Intrinsics.areEqual((Object)((String)this.modeValue.get()), (Object)"Critical hit")) {
            AnimatePacket animatePacket = new AnimatePacket();
            animatePacket.setRuntimeEntityId(eventTick.getSession().getThePlayer().getRuntimeId());
            animatePacket.setAction(AnimatePacket.Action.CRITICAL_HIT);
            for (int i = 0; i < 500; ++i) {
                eventTick.getSession().getNetSession().outboundPacket(animatePacket);
            }
        }
    }
}

