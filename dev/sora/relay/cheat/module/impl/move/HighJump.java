/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.protocol.bedrock.packet.MobEffectPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/sora/relay/cheat/module/impl/move/HighJump;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "amplifierValue", "Ldev/sora/relay/cheat/value/IntValue;", "onDisable", "", "onTick", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HighJump
extends CheatModule {
    private final IntValue amplifierValue = new IntValue("levels", 5, 1, 128);

    public HighJump() {
        super("HighJump", false, false, 6, null);
    }

    @Override
    public void onDisable() {
        if (!this.getSession().getNetSessionInitialized()) {
            return;
        }
        RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
        MobEffectPacket mobEffectPacket = new MobEffectPacket();
        mobEffectPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
        mobEffectPacket.setEvent(MobEffectPacket.Event.REMOVE);
        mobEffectPacket.setEffectId(8);
        rakNetRelaySession.inboundPacket(mobEffectPacket);
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (eventTick.getSession().getTickExists() % (long)20 != 0L) {
            return;
        }
        RakNetRelaySession rakNetRelaySession = eventTick.getSession().getNetSession();
        MobEffectPacket mobEffectPacket = new MobEffectPacket();
        mobEffectPacket.setEvent(MobEffectPacket.Event.ADD);
        mobEffectPacket.setRuntimeEntityId(eventTick.getSession().getThePlayer().getRuntimeId());
        mobEffectPacket.setEffectId(8);
        mobEffectPacket.setAmplifier(((Number)this.amplifierValue.get()).intValue() - 1);
        mobEffectPacket.setParticles(false);
        mobEffectPacket.setDuration(420);
        rakNetRelaySession.inboundPacket(mobEffectPacket);
    }
}

