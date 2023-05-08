/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.MoveEntityAbsolutePacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.game.utils.constants.DeviceKt;
import dev.sora.relay.game.world.WorldClient;
import dev.sora.relay.game.world.WorldwideBlockStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/Test;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "onDisable", "", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Test
extends CheatModule {
    public Test() {
        super("Test", false, false, 6, null);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        this.chat("movementMode " + (Object)((Object)this.getSession().getMovementMode()));
        this.chat("serverAuthBreak " + this.getSession().getServerAuthBreak());
        this.chat("serverAuthInventory " + this.getSession().getServerAuthInventory());
        this.chat("RuntimeId " + this.getSession().getThePlayer().getRuntimeId());
        this.chat("TitleId " + DeviceKt.titleIdToDevice(this.getSession().getTitleId()));
        this.chat("Xuid " + this.getSession().getThePlayer().getXuid());
        this.chat("UserName " + this.getSession().getThePlayer().getUsername());
        String string = this.getSession().getThePlayer().getMetadata().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"session.thePlayer.metadata.toString()");
        this.chat(string);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        eventPacketInbound.getPacket();
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = ((EventPacketOutbound)object).getPacket();
        if (object2 instanceof InventoryTransactionPacket) {
            if (((InventoryTransactionPacket)object2).getTransactionType() == TransactionType.ITEM_USE_ON_ENTITY && ((InventoryTransactionPacket)object2).getActionType() == 1) {
                object = this.getSession().getTheWorld().getEntityMap().get(((InventoryTransactionPacket)object2).getRuntimeEntityId());
                if (object != null) {
                    this.chat("RuntimeEntityId " + ((Entity)object).getRuntimeId());
                    String string = ((Entity)object).getMetadata().toString();
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"entity.metadata.toString()");
                    this.chat(string);
                    this.chat("Identifier " + ((Entity)object).getIdentifier());
                }
            } else if (((InventoryTransactionPacket)object2).getTransactionType() == TransactionType.ITEM_USE && ((InventoryTransactionPacket)object2).getActionType() == 0) {
                WorldClient worldClient = ((GameEvent)object).getSession().getTheWorld();
                Vector3i vector3i = ((InventoryTransactionPacket)object2).getBlockPosition();
                String string = "packet.blockPosition";
                Intrinsics.checkNotNullExpressionValue((Object)vector3i, (String)string);
                this.chat(worldClient.getBlockAt(vector3i));
                object = ((GameEvent)object).getSession().getTheWorld();
                object2 = ((InventoryTransactionPacket)object2).getBlockPosition();
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)string);
                this.chat(String.valueOf(((WorldwideBlockStorage)object).getBlockIdAt((Vector3i)object2)));
            }
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        RakNetRelaySession rakNetRelaySession = eventTick.getSession().getNetSession();
        MoveEntityAbsolutePacket moveEntityAbsolutePacket = new MoveEntityAbsolutePacket();
        moveEntityAbsolutePacket.setRuntimeEntityId(eventTick.getSession().getThePlayer().getRuntimeId());
        moveEntityAbsolutePacket.setRotation(Vector3f.ZERO);
        rakNetRelaySession.inboundPacket(moveEntityAbsolutePacket);
    }
}

