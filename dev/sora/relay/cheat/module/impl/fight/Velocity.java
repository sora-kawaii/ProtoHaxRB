/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.bedrock.packet.SetEntityMotionPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAttributesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/Velocity;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "horizontalValue", "Ldev/sora/relay/cheat/value/FloatValue;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "resistanceValue", "verticalValue", "onDisable", "", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Velocity
extends CheatModule {
    private final FloatValue horizontalValue;
    private final ListValue modeValue;
    private final FloatValue resistanceValue;
    private final FloatValue verticalValue;

    public Velocity() {
        super("Velocity", false, false, 6, null);
        String string = "Cancel";
        String string2 = "Simple";
        String string3 = "Resistance";
        this.modeValue = new ListValue("Mode", new String[]{string, string2, string3}, string);
        this.horizontalValue = new FloatValue("Horizontal", 0.0f, 0.0f, 1.0f);
        this.verticalValue = new FloatValue("Vertical", 0.0f, 0.0f, 1.0f);
        this.resistanceValue = new FloatValue(string3, 1.0f, 0.0f, 1.0f);
    }

    @Override
    public void onDisable() {
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Resistance")) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            UpdateAttributesPacket updateAttributesPacket = new UpdateAttributesPacket();
            updateAttributesPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            updateAttributesPacket.getAttributes().add(this.getSession().getThePlayer().getAttributes().get("minecraft:knockback_resistance"));
            rakNetRelaySession.inboundPacket(updateAttributesPacket);
        }
    }

    @Override
    public void onEnable() {
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Resistance")) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            UpdateAttributesPacket updateAttributesPacket = new UpdateAttributesPacket();
            updateAttributesPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            List<AttributeData> list = updateAttributesPacket.getAttributes();
            float f = ((Number)this.resistanceValue.get()).floatValue();
            list.add(new AttributeData("minecraft:knockback_resistance", 0.0f, 1.0f, f, 0.0f));
            rakNetRelaySession.inboundPacket(updateAttributesPacket);
        }
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        block3: {
            Iterator iterator;
            block2: {
                block4: {
                    Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
                    iterator = eventPacketInbound.getPacket();
                    if (!(iterator instanceof SetEntityMotionPacket)) break block2;
                    if (((SetEntityMotionPacket)((Object)iterator)).getRuntimeEntityId() != eventPacketInbound.getSession().getThePlayer().getRuntimeId()) break block3;
                    if (!Intrinsics.areEqual(this.modeValue.get(), (Object)"Cancel")) break block4;
                    eventPacketInbound.cancel();
                    break block3;
                }
                if (!Intrinsics.areEqual(this.modeValue.get(), (Object)"Simple")) break block3;
                ((SetEntityMotionPacket)((Object)iterator)).getMotion().mul(((Number)this.horizontalValue.get()).floatValue(), ((Number)this.verticalValue.get()).floatValue(), ((Number)this.horizontalValue.get()).floatValue());
                break block3;
            }
            if (iterator instanceof UpdateAttributesPacket && Intrinsics.areEqual(this.modeValue.get(), (Object)"Resistance") && ((UpdateAttributesPacket)((Object)iterator)).getRuntimeEntityId() == eventPacketInbound.getSession().getThePlayer().getRuntimeId()) {
                iterator = ((UpdateAttributesPacket)((Object)iterator)).getAttributes();
                Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"packet.attributes");
                iterator = ((Iterable)((Object)iterator)).iterator();
                while (iterator.hasNext()) {
                    if (!Intrinsics.areEqual((Object)((AttributeData)iterator.next()).getName(), (Object)"minecraft:knockback_resistance")) continue;
                    eventPacketInbound.cancel();
                }
            }
        }
    }
}

