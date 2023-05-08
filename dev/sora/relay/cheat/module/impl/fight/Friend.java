/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\n\u0010\u000b\u001a\u00020\f*\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/Friend;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "friendList", "", "", "onDisable", "", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "isFriend", "", "Ldev/sora/relay/game/entity/EntityPlayer;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Friend
extends CheatModule {
    public static final Friend INSTANCE = new Friend();
    private static final Set<Long> friendList = new LinkedHashSet();

    private Friend() {
        super("Friend", false, false, 6, null);
    }

    public final boolean isFriend(EntityPlayer entityPlayer) {
        Intrinsics.checkNotNullParameter((Object)entityPlayer, (String)"<this>");
        return friendList.contains(entityPlayer.getRuntimeId());
    }

    @Override
    public void onDisable() {
        friendList.clear();
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound set) {
        Entity entity;
        Intrinsics.checkNotNullParameter((Object)set, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketOutbound)((Object)set)).getPacket();
        if (bedrockPacket instanceof InventoryTransactionPacket && ((InventoryTransactionPacket)bedrockPacket).getTransactionType() == TransactionType.ITEM_USE_ON_ENTITY && ((InventoryTransactionPacket)bedrockPacket).getActionType() == 0 && (entity = this.getSession().getTheWorld().getEntityMap().get(((InventoryTransactionPacket)bedrockPacket).getRuntimeEntityId())) instanceof EntityPlayer) {
            set = friendList;
            if (set.contains(((InventoryTransactionPacket)bedrockPacket).getRuntimeEntityId())) {
                set.remove(((InventoryTransactionPacket)bedrockPacket).getRuntimeEntityId());
                this.chat("Remove Friend:" + ((EntityPlayer)entity).getUsername());
            } else {
                set.add(((InventoryTransactionPacket)bedrockPacket).getRuntimeEntityId());
                this.chat("Add Friend:" + ((EntityPlayer)entity).getUsername());
            }
        }
    }
}

