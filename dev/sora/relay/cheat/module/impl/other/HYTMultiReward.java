/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.ModalFormRequestPacket;
import com.nukkitx.protocol.bedrock.packet.ModalFormResponsePacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ldev/sora/relay/cheat/module/impl/other/HYTMultiReward;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "attackPacket", "Lcom/nukkitx/protocol/bedrock/packet/InventoryTransactionPacket;", "isOpenModalForm", "", "packetCountsValue", "Ldev/sora/relay/cheat/value/IntValue;", "packetFormIdList", "", "", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HYTMultiReward
extends CheatModule {
    private InventoryTransactionPacket attackPacket;
    private boolean isOpenModalForm;
    private final IntValue packetCountsValue = new IntValue("Packets", 200, 1, 1000);
    private final List<Integer> packetFormIdList = new ArrayList();

    public HYTMultiReward() {
        super("MultiReward", false, false, 6, null);
        this.attackPacket = new InventoryTransactionPacket();
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (bedrockPacket instanceof ModalFormRequestPacket) {
            if (!this.isOpenModalForm) {
                this.isOpenModalForm = true;
                int n = ((Number)this.packetCountsValue.get()).intValue();
                for (int i = 0; i < n; ++i) {
                    eventPacketInbound.getSession().getNetSession().outboundPacket(this.attackPacket);
                }
            } else {
                this.packetFormIdList.add(((ModalFormRequestPacket)bedrockPacket).getFormId());
                eventPacketInbound.cancel();
            }
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketOutbound)object).getPacket();
        if (bedrockPacket instanceof InventoryTransactionPacket) {
            if (((InventoryTransactionPacket)bedrockPacket).getTransactionType() == TransactionType.ITEM_USE_ON_ENTITY && ((InventoryTransactionPacket)bedrockPacket).getActionType() == 1) {
                this.attackPacket = (InventoryTransactionPacket)bedrockPacket;
            }
        } else if (bedrockPacket instanceof ModalFormResponsePacket && this.isOpenModalForm) {
            Iterator<Integer> iterator = this.packetFormIdList.iterator();
            while (iterator.hasNext()) {
                int n = ((Number)iterator.next()).intValue();
                object = this.getSession().getNetSession();
                ModalFormResponsePacket modalFormResponsePacket = new ModalFormResponsePacket();
                modalFormResponsePacket.setFormId(n);
                modalFormResponsePacket.setFormData(((ModalFormResponsePacket)bedrockPacket).getFormData());
                ((RakNetRelaySession)object).outboundPacket(modalFormResponsePacket);
            }
            this.packetFormIdList.clear();
            this.isOpenModalForm = false;
        }
    }
}

