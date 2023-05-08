/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.RemoveEntityPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.utils.TimerUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0015H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/cheat/module/impl/action/AutoL;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "attackList", "", "", "", "delayValue", "Ldev/sora/relay/cheat/value/FloatValue;", "mentionValue", "Ldev/sora/relay/cheat/value/BoolValue;", "messageValue", "Ldev/sora/relay/cheat/value/ListValue;", "timer", "Ldev/sora/relay/utils/TimerUtil;", "onDisable", "", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AutoL
extends CheatModule {
    private final Map<Long, String> attackList;
    private final FloatValue delayValue;
    private final BoolValue mentionValue;
    private final ListValue messageValue;
    private final TimerUtil timer;

    public AutoL() {
        super("AutoL", false, false, 6, null);
        String string = "Loser,you are killed by ProtoHaxRB.";
        String string2 = "\u5931\u8d25\u8005\uff0c\u4f60\u88abProtoHaxRB\u79fb\u51fa\u4e86\u6e38\u620f\u3002";
        String string3 = "Loser,you need to buy ProtoHaxRB in bilibili-SRYuYing369";
        String string4 = "Message";
        String string5 = "Loser,You are killed by ProtoHaxRB.";
        this.messageValue = new ListValue(string4, new String[]{string, string2, string3}, string5);
        this.delayValue = new FloatValue("Delay", 500.0f, 0.0f, 3000.0f);
        this.mentionValue = new BoolValue("Mention", true);
        this.attackList = new LinkedHashMap();
        this.timer = new TimerUtil();
    }

    @Override
    public void onDisable() {
        this.attackList.clear();
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        block6: {
            BedrockPacket bedrockPacket;
            block7: {
                Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
                bedrockPacket = eventPacketInbound.getPacket();
                if (!this.timer.isDelayComplete(((Number)this.delayValue.get()).floatValue())) break block6;
                if (!(bedrockPacket instanceof RemoveEntityPacket)) break block7;
                for (Map.Entry<Long, String> entry : this.attackList.entrySet()) {
                    if (((RemoveEntityPacket)bedrockPacket).getUniqueEntityId() != ((Number)entry.getKey()).longValue()) continue;
                    if (((Boolean)this.mentionValue.get()).booleanValue()) {
                        eventPacketInbound.getSession().getThePlayer().say('@' + entry.getValue() + ' ' + (String)this.messageValue.get());
                    } else {
                        eventPacketInbound.getSession().getThePlayer().say((String)this.messageValue.get());
                    }
                    this.attackList.remove(entry.getKey(), entry.getValue());
                    this.timer.reset();
                }
                break block6;
            }
            if (!(bedrockPacket instanceof EntityEventPacket) || ((EntityEventPacket)bedrockPacket).getType() != EntityEventType.DEATH) break block6;
            for (Map.Entry<Long, String> entry : this.attackList.entrySet()) {
                if (((EntityEventPacket)bedrockPacket).getRuntimeEntityId() != ((Number)entry.getKey()).longValue()) continue;
                if (((Boolean)this.mentionValue.get()).booleanValue()) {
                    eventPacketInbound.getSession().getThePlayer().say('@' + entry.getValue() + ' ' + (String)this.messageValue.get());
                } else {
                    eventPacketInbound.getSession().getThePlayer().say((String)this.messageValue.get());
                }
                this.attackList.remove(entry.getKey(), entry.getValue());
                this.timer.reset();
            }
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"event");
            object = ((EventPacketOutbound)object).getPacket();
            if (object instanceof InventoryTransactionPacket && ((InventoryTransactionPacket)object).getTransactionType() == TransactionType.ITEM_USE_ON_ENTITY && ((InventoryTransactionPacket)object).getActionType() == 1) {
                Object object2 = ((Iterable)this.getSession().getTheWorld().getEntityMap().values()).iterator();
                while (object2.hasNext()) {
                    Object t = object2.next();
                    boolean bl = ((Entity)t).getRuntimeId() == ((InventoryTransactionPacket)object).getRuntimeEntityId();
                    if (!bl) continue;
                    object2 = (Entity)t;
                    if (object2 instanceof EntityPlayer) {
                        this.attackList.put(((InventoryTransactionPacket)object).getRuntimeEntityId(), ((EntityPlayer)object2).getUsername());
                    }
                    break block3;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
    }
}

