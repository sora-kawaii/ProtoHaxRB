/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MobEffectPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/AntiBlind;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "nightVisionValue", "Ldev/sora/relay/cheat/value/BoolValue;", "removeBadEffectsValue", "onDisable", "", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AntiBlind
extends CheatModule {
    private final BoolValue nightVisionValue = new BoolValue("NightVision", true);
    private final BoolValue removeBadEffectsValue = new BoolValue("RemoveBadEffects", true);

    public AntiBlind() {
        super("AntiBlind", false, false, 6, null);
    }

    @Override
    public void onDisable() {
        if (((Boolean)this.nightVisionValue.get()).booleanValue() && this.getSession().getNetSessionInitialized()) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            MobEffectPacket mobEffectPacket = new MobEffectPacket();
            mobEffectPacket.setEvent(MobEffectPacket.Event.REMOVE);
            mobEffectPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            mobEffectPacket.setEffectId(16);
            rakNetRelaySession.inboundPacket(mobEffectPacket);
        }
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (((Boolean)this.removeBadEffectsValue.get()).booleanValue() && bedrockPacket instanceof MobEffectPacket && (((MobEffectPacket)bedrockPacket).getEffectId() == 9 || ((MobEffectPacket)bedrockPacket).getEffectId() == 15 || ((MobEffectPacket)bedrockPacket).getEffectId() == 30)) {
            eventPacketInbound.cancel();
        }
    }

    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((Boolean)this.nightVisionValue.get()).booleanValue() && ((GameEvent)object).getSession().getTickExists() % (long)20 == 0L) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            object = new MobEffectPacket();
            ((MobEffectPacket)object).setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            ((MobEffectPacket)object).setEvent(MobEffectPacket.Event.ADD);
            ((MobEffectPacket)object).setEffectId(16);
            ((MobEffectPacket)object).setAmplifier(0);
            ((MobEffectPacket)object).setParticles(false);
            ((MobEffectPacket)object).setDuration(360000);
            rakNetRelaySession.inboundPacket((BedrockPacket)object);
            return;
        }
    }
}

