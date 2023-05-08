/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEvent2Packet;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ldev/sora/relay/cheat/module/impl/action/AutoFish;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "delayValue", "Ldev/sora/relay/cheat/value/FloatValue;", "fishing", "", "timer", "Ldev/sora/relay/utils/TimerUtil;", "fish", "", "throwHook", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AutoFish
extends CheatModule {
    private final FloatValue delayValue = new FloatValue("Delay", 100.0f, 0.0f, 1000.0f);
    private boolean fishing;
    private final TimerUtil timer = new TimerUtil();

    public AutoFish() {
        super("AutoFish", false, false, 6, null);
    }

    private final void fish(boolean bl) {
        Object object;
        Object object2;
        if (bl) {
            object2 = this.getSession();
            object = new LevelSoundEvent2Packet();
            ((LevelSoundEvent2Packet)object).setSound(SoundEvent.THROW);
            ((LevelSoundEvent2Packet)object).setPosition(this.getSession().getThePlayer().getVec3Position());
            ((LevelSoundEvent2Packet)object).setExtraData(-1);
            ((LevelSoundEvent2Packet)object).setIdentifier("minecraft:player");
            ((LevelSoundEvent2Packet)object).setBabySound(false);
            ((LevelSoundEvent2Packet)object).setRelativeVolumeDisabled(false);
            ((GameSession)object2).sendPacket((BedrockPacket)object);
        }
        EntityPlayerSP.swing$default(this.getSession().getThePlayer(), false, 1, null);
        object2 = this.getSession();
        object = new InventoryTransactionPacket();
        ((InventoryTransactionPacket)object).setTransactionType(TransactionType.ITEM_USE);
        ((InventoryTransactionPacket)object).setActionType(1);
        ((InventoryTransactionPacket)object).setRuntimeEntityId(0L);
        ((InventoryTransactionPacket)object).setBlockPosition(Vector3i.ZERO);
        ((InventoryTransactionPacket)object).setBlockFace(255);
        ((InventoryTransactionPacket)object).setHotbarSlot(this.getSession().getThePlayer().getHeldItemSlot());
        ((InventoryTransactionPacket)object).setItemInHand(this.getSession().getThePlayer().getHeldItemData());
        ((InventoryTransactionPacket)object).setPlayerPosition(this.getSession().getThePlayer().getVec3Position());
        ((InventoryTransactionPacket)object).setClickPosition(Vector3f.ZERO);
        ((GameSession)object2).sendPacket((BedrockPacket)object);
        object = this.getSession();
        object2 = new InventoryTransactionPacket();
        ((InventoryTransactionPacket)object2).setTransactionType(TransactionType.ITEM_RELEASE);
        ((InventoryTransactionPacket)object2).setActionType(0);
        ((InventoryTransactionPacket)object2).setRuntimeEntityId(0L);
        ((InventoryTransactionPacket)object2).setHotbarSlot(this.getSession().getThePlayer().getHeldItemSlot());
        ((InventoryTransactionPacket)object2).setItemInHand(this.getSession().getThePlayer().getHeldItemData());
        ((InventoryTransactionPacket)object2).setHeadPosition(this.getSession().getThePlayer().getVec3Position());
        ((GameSession)object).sendPacket((BedrockPacket)object2);
    }

    @Override
    public void onEnable() {
        this.fishing = false;
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketInbound)object).getPacket();
        if (this.fishing && object instanceof EntityEventPacket && ((EntityEventPacket)object).getType() == EntityEventType.FISH_HOOK_TIME) {
            this.fish(false);
            this.fishing = false;
            this.timer.reset();
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (this.timer.isDelayComplete(((Number)this.delayValue.get()).floatValue()) && !this.fishing && eventTick.getSession().getThePlayer().getHeldItemData().getId() == 392) {
            this.fish(true);
            this.fishing = true;
        }
    }
}

