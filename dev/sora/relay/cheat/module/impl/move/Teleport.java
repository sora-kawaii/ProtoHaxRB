/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/cheat/module/impl/move/Teleport;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "distanceValue", "Ldev/sora/relay/cheat/value/FloatValue;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "tpHighValue", "Ldev/sora/relay/cheat/value/IntValue;", "onEnable", "", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Teleport
extends CheatModule {
    private final FloatValue distanceValue;
    private final ListValue modeValue;
    private final IntValue tpHighValue;

    public Teleport() {
        super("Teleport", false, false, 6, null);
        String string2 = "Teleport";
        String string3 = "ClickTP";
        this.modeValue = new ListValue("Mode", new String[]{string2, string3}, string2);
        this.distanceValue = new FloatValue("Distance", 20.0f, 0.0f, 50.0f);
        this.tpHighValue = new IntValue("YHigh", 0, 0, 400);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Teleport")) {
            double d = this.getSession().getThePlayer().getDirection();
            Vector3f vector3f = Vector3f.from(this.getSession().getThePlayer().getPosX() + -Math.sin(d) * ((Number)this.distanceValue.get()).doubleValue(), this.getSession().getThePlayer().getPosY() + ((Number)this.tpHighValue.get()).doubleValue(), this.getSession().getThePlayer().getPosZ() + Math.cos(d) * ((Number)this.distanceValue.get()).doubleValue());
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from(\n                se\u2026alue.get())\n            )");
            EntityPlayerSP.teleportTo$default(this.getSession().getThePlayer(), vector3f, false, 2, null);
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        Object object = eventPacketOutbound.getPacket();
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"ClickTP") && object instanceof InventoryTransactionPacket && ((InventoryTransactionPacket)object).getTransactionType() == TransactionType.ITEM_USE && ((InventoryTransactionPacket)object).getActionType() == 0) {
            object = Vector3f.from((double)((InventoryTransactionPacket)object).getBlockPosition().getX() + 0.5, 2.62 + (double)((InventoryTransactionPacket)object).getBlockPosition().getY(), (double)((InventoryTransactionPacket)object).getBlockPosition().getZ() + 0.5);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(\n                  \u2026) + 0.5\n                )");
            EntityPlayerSP.teleportTo$default(eventPacketOutbound.getSession().getThePlayer(), (Vector3f)object, false, 2, null);
        }
    }
}

