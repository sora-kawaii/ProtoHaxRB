/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/module/impl/move/AirJump;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "delayValue", "Ldev/sora/relay/cheat/value/IntValue;", "ticks", "", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AirJump
extends CheatModule {
    private final IntValue delayValue = new IntValue("Delay", 5, 0, 20);
    private int ticks;

    public AirJump() {
        super("AirJump", false, false, 6, null);
    }

    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((GameEvent)object).getSession().getThePlayer();
        ++this.ticks;
        if (((Number)this.delayValue.get()).intValue() <= this.ticks && ((EntityPlayerSP)object).getInputData().contains((Object)PlayerAuthInputData.JUMPING)) {
            EntityPlayerSP.jump$default((EntityPlayerSP)object, 0.0, 1, null);
            this.ticks = 0;
        }
    }
}

