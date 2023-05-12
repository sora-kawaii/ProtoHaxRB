/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.AnimatePacket;
import com.nukkitx.protocol.bedrock.packet.AvailableCommandsPacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.MobEquipmentPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateBlockPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Ldev/sora/relay/cheat/module/impl/move/Scaffold;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "floatValue", "Ldev/sora/relay/cheat/value/IntValue;", "getFace", "", "yaw", "", "getOffsetX", "index", "getOffsetZ", "onMove", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "onPacketInbound", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Scaffold
extends CheatModule {
    private final IntValue floatValue = new IntValue("Expand", 4, 1, 6);

    public Scaffold() {
        super("Scaffold", false, false, 6, null);
    }

    private final int getFace(float f) {
        int n = f < 45.0f && f > -45.0f ? 3 : (f > 45.0f && f < 135.0f ? 4 : (!(f > 135.0f) && !(f < -135.0f) ? (f > -135.0f && f < -45.0f ? 5 : 1) : 2));
        return n;
    }

    private final int getOffsetX(float f) {
        int n = f > 45.0f && f < 135.0f ? -1 : (f > -135.0f && f < -45.0f ? 1 : 0);
        return n;
    }

    private final int getOffsetX(float f, int n) {
        if (f > 45.0f && f < 135.0f) {
            n = -n;
        } else if (!(f > -135.0f) || !(f < -45.0f)) {
            n = 0;
        }
        return n;
    }

    private final int getOffsetZ(float f) {
        int n = f < 45.0f && f > -45.0f ? -1 : (!(f > 135.0f) && !(f < -135.0f) ? 0 : 1);
        return n;
    }

    private final int getOffsetZ(float f, int n) {
        if (!(f < 45.0f) || !(f > -45.0f)) {
            n = !(f > 135.0f) && !(f < -135.0f) ? 0 : -n;
        }
        return n;
    }

    @Listen
    public final void onMove(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        String cfr_ignored_0 = "Expand: " + ((Number)this.floatValue.get()).intValue();
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketInbound)object).getPacket();
        if (object instanceof AvailableCommandsPacket) {
            return;
        }
        boolean bl = object instanceof MobEquipmentPacket;
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketOutbound)object).getPacket();
        if (object instanceof PlayerAuthInputPacket) {
            int n = 0;
            int n2 = ((Number)this.floatValue.get()).intValue();
            for (int i = 0; i < n2; ++i) {
                ++n;
                Object object2 = this.getSession();
                object = new PlayerActionPacket();
                ((PlayerActionPacket)object).setAction(PlayerActionType.ITEM_USE_ON_START);
                ((PlayerActionPacket)object).setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                ((PlayerActionPacket)object).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX()), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ())));
                ((PlayerActionPacket)object).setResultPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX() + (double)this.getOffsetX(this.getSession().getThePlayer().getRotationYaw(), n)), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ() + (double)this.getOffsetZ(this.getSession().getThePlayer().getRotationYaw(), n))));
                ((PlayerActionPacket)object).setFace(this.getFace(this.getSession().getThePlayer().getRotationYaw()));
                ((GameSession)object2).sendPacket((BedrockPacket)object);
                object = this.getSession();
                object2 = new AnimatePacket();
                ((AnimatePacket)object2).setRowingTime(0.0f);
                ((AnimatePacket)object2).setAction(AnimatePacket.Action.SWING_ARM);
                ((AnimatePacket)object2).setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                ((GameSession)object).sendPacket((BedrockPacket)object2);
                object = this.getSession();
                object2 = new InventoryTransactionPacket();
                ((InventoryTransactionPacket)object2).setLegacyRequestId(0);
                ((InventoryTransactionPacket)object2).setTransactionType(TransactionType.ITEM_USE);
                ((InventoryTransactionPacket)object2).setActionType(0);
                ((InventoryTransactionPacket)object2).setRuntimeEntityId(0L);
                ((InventoryTransactionPacket)object2).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX()), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ())));
                ((InventoryTransactionPacket)object2).setBlockFace(this.getFace(this.getSession().getThePlayer().getRotationYaw()));
                ((InventoryTransactionPacket)object2).setHotbarSlot(this.getSession().getThePlayer().getHeldItemSlot());
                ((InventoryTransactionPacket)object2).setPlayerPosition(this.getSession().getThePlayer().getVec3Position());
                ((InventoryTransactionPacket)object2).setClickPosition(Vector3f.from(0.5f, 0.5f, 0.5f));
                ((InventoryTransactionPacket)object2).setUsingNetIds(false);
                ((InventoryTransactionPacket)object2).setBlockRuntimeId(115);
                ((GameSession)object).sendPacket((BedrockPacket)object2);
                object2 = this.getSession();
                object = new InventoryTransactionPacket();
                ((InventoryTransactionPacket)object).setLegacyRequestId(0);
                ((InventoryTransactionPacket)object).setTransactionType(TransactionType.ITEM_USE);
                ((InventoryTransactionPacket)object).setActionType(1);
                ((InventoryTransactionPacket)object).setRuntimeEntityId(0L);
                ((InventoryTransactionPacket)object).setBlockPosition(Vector3i.from(0, 0, 0));
                ((InventoryTransactionPacket)object).setBlockFace(255);
                ((InventoryTransactionPacket)object).setHotbarSlot(this.getSession().getThePlayer().getHeldItemSlot());
                ((InventoryTransactionPacket)object).setPlayerPosition(this.getSession().getThePlayer().getVec3Position());
                ((InventoryTransactionPacket)object).setClickPosition(Vector3f.from(0.0f, 0.0f, 0.0f));
                ((InventoryTransactionPacket)object).setUsingNetIds(false);
                ((InventoryTransactionPacket)object).setBlockRuntimeId(0);
                ((GameSession)object2).sendPacket((BedrockPacket)object);
                object2 = this.getSession();
                object = new PlayerActionPacket();
                ((PlayerActionPacket)object).setAction(PlayerActionType.ITEM_USE_ON_STOP);
                ((PlayerActionPacket)object).setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                ((PlayerActionPacket)object).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX() + (double)this.getOffsetX(this.getSession().getThePlayer().getRotationYaw(), n)), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ() + (double)this.getOffsetZ(this.getSession().getThePlayer().getRotationYaw(), n))));
                ((PlayerActionPacket)object).setResultPosition(Vector3i.from(0, 0, 0));
                ((GameSession)object2).sendPacket((BedrockPacket)object);
                object = this.getSession();
                object2 = new PlayerActionPacket();
                ((PlayerActionPacket)object2).setAction(PlayerActionType.ITEM_USE_ON_STOP);
                ((PlayerActionPacket)object2).setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                ((PlayerActionPacket)object2).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX() + (double)this.getOffsetX(this.getSession().getThePlayer().getRotationYaw(), n)), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ() + (double)this.getOffsetZ(this.getSession().getThePlayer().getRotationYaw(), n))));
                ((PlayerActionPacket)object2).setResultPosition(Vector3i.from(0, 0, 0));
                ((GameSession)object).sendPacket((BedrockPacket)object2);
                object2 = this.getSession().getNetSession();
                object = new UpdateBlockPacket();
                ((UpdateBlockPacket)object).getFlags().add(UpdateBlockPacket.Flag.NETWORK);
                ((UpdateBlockPacket)object).setDataLayer(0);
                ((UpdateBlockPacket)object).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX() + (double)this.getOffsetX(this.getSession().getThePlayer().getRotationYaw(), n)), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ() + (double)this.getOffsetZ(this.getSession().getThePlayer().getRotationYaw(), n))));
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
                object2 = this.getSession().getNetSession();
                object = new UpdateBlockPacket();
                ((UpdateBlockPacket)object).getFlags().add(UpdateBlockPacket.Flag.NETWORK);
                ((UpdateBlockPacket)object).setDataLayer(0);
                ((UpdateBlockPacket)object).setBlockPosition(Vector3i.from((int)Math.floor(this.getSession().getThePlayer().getPosX() + (double)this.getOffsetX(this.getSession().getThePlayer().getRotationYaw(), n)), (int)Math.floor(this.getSession().getThePlayer().getPosY() - 2.62), (int)Math.floor(this.getSession().getThePlayer().getPosZ() + (double)this.getOffsetZ(this.getSession().getThePlayer().getRotationYaw(), n))));
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
            }
            return;
        }
        boolean bl = object instanceof InventoryTransactionPacket;
    }
}

