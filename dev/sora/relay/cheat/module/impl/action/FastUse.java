/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/action/FastUse;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class FastUse
extends CheatModule {
    public FastUse() {
        super("FastUse", false, false, 6, null);
    }

    @Listen
    public final void onPacketOutbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = ((EventPacketInbound)object).getPacket();
        EntityPlayerSP entityPlayerSP = ((GameEvent)object).getSession().getThePlayer();
        if (object2 instanceof InventoryTransactionPacket && ((InventoryTransactionPacket)object2).getTransactionType() == TransactionType.ITEM_USE && ((InventoryTransactionPacket)object2).getActionType() == 1) {
            for (int i = 0; i < 7; ++i) {
                object2 = ((GameEvent)object).getSession().getNetSession();
                EntityEventPacket entityEventPacket = new EntityEventPacket();
                entityEventPacket.setRuntimeEntityId(entityPlayerSP.getRuntimeId());
                entityEventPacket.setType(EntityEventType.EATING_ITEM);
                entityEventPacket.setData(0x1020000);
                ((RakNetRelaySession)object2).outboundPacket(entityEventPacket);
            }
            object2 = ((GameEvent)object).getSession().getNetSession();
            object = new InventoryTransactionPacket();
            ((InventoryTransactionPacket)object).setTransactionType(TransactionType.ITEM_USE);
            ((InventoryTransactionPacket)object).setActionType(1);
            ((InventoryTransactionPacket)object).setRuntimeEntityId(0L);
            ((InventoryTransactionPacket)object).setBlockPosition(Vector3i.ZERO);
            ((InventoryTransactionPacket)object).setBlockFace(255);
            ((InventoryTransactionPacket)object).setBlockRuntimeId(0);
            ((InventoryTransactionPacket)object).setHotbarSlot(entityPlayerSP.getHeldItemSlot());
            ((InventoryTransactionPacket)object).setItemInHand(entityPlayerSP.getHeldItemData());
            ((InventoryTransactionPacket)object).setPlayerPosition(entityPlayerSP.getVec3Position());
            ((InventoryTransactionPacket)object).setClickPosition(Vector3f.ZERO);
            ((RakNetRelaySession)object2).outboundPacket((BedrockPacket)object);
        }
    }
}

