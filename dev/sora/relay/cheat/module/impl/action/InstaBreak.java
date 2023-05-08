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
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.MobEffectPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.GameEventCancelable;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/cheat/module/impl/action/InstaBreak;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "amplifierValue", "Ldev/sora/relay/cheat/value/IntValue;", "forceValue", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "breakBlock", "", "session", "Ldev/sora/relay/game/GameSession;", "blockPos", "Lcom/nukkitx/math/vector/Vector3i;", "blockFace", "", "onDisable", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class InstaBreak
extends CheatModule {
    private final IntValue amplifierValue;
    private final IntValue forceValue;
    private final ListValue modeValue;

    public InstaBreak() {
        super("InstaBreak", false, false, 6, null);
        String string = "Effect";
        String string2 = "ClickBreak";
        this.modeValue = new ListValue("Mode", new String[]{string, string2}, string2);
        this.amplifierValue = new IntValue("levels", 5, 1, 128);
        this.forceValue = new IntValue("Force", 30, 10, 200);
    }

    private final void breakBlock(GameSession gameSession, Vector3i vector3i, int n) {
        BedrockPacket bedrockPacket = new PlayerActionPacket();
        ((PlayerActionPacket)bedrockPacket).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
        ((PlayerActionPacket)bedrockPacket).setAction(PlayerActionType.START_BREAK);
        ((PlayerActionPacket)bedrockPacket).setBlockPosition(vector3i);
        ((PlayerActionPacket)bedrockPacket).setFace(n);
        gameSession.sendPacket(bedrockPacket);
        bedrockPacket = new PlayerActionPacket();
        ((PlayerActionPacket)bedrockPacket).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
        ((PlayerActionPacket)bedrockPacket).setAction(PlayerActionType.CONTINUE_BREAK);
        ((PlayerActionPacket)bedrockPacket).setBlockPosition(vector3i);
        ((PlayerActionPacket)bedrockPacket).setFace(n);
        int n2 = ((Number)this.forceValue.get()).intValue();
        for (int i = 0; i < n2; ++i) {
            gameSession.sendPacket(bedrockPacket);
        }
        bedrockPacket = new PlayerActionPacket();
        ((PlayerActionPacket)bedrockPacket).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
        ((PlayerActionPacket)bedrockPacket).setAction(PlayerActionType.STOP_BREAK);
        ((PlayerActionPacket)bedrockPacket).setBlockPosition(vector3i);
        ((PlayerActionPacket)bedrockPacket).setFace(n);
        gameSession.sendPacket(bedrockPacket);
        bedrockPacket = new InventoryTransactionPacket();
        ((InventoryTransactionPacket)bedrockPacket).setTransactionType(TransactionType.ITEM_USE);
        ((InventoryTransactionPacket)bedrockPacket).setActionType(2);
        ((InventoryTransactionPacket)bedrockPacket).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
        ((InventoryTransactionPacket)bedrockPacket).setBlockPosition(vector3i);
        ((InventoryTransactionPacket)bedrockPacket).setBlockFace(n);
        ((InventoryTransactionPacket)bedrockPacket).setHotbarSlot(gameSession.getThePlayer().getHeldItemSlot());
        ((InventoryTransactionPacket)bedrockPacket).setItemInHand(ItemData.AIR);
        ((InventoryTransactionPacket)bedrockPacket).setPlayerPosition(gameSession.getThePlayer().getVec3Position());
        ((InventoryTransactionPacket)bedrockPacket).setClickPosition(Vector3f.ZERO);
        gameSession.sendPacket(bedrockPacket);
    }

    static /* synthetic */ void breakBlock$default(InstaBreak instaBreak, GameSession gameSession, Vector3i vector3i, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 1;
        }
        instaBreak.breakBlock(gameSession, vector3i, n);
    }

    @Override
    public void onDisable() {
        if (!this.getSession().getNetSessionInitialized()) {
            return;
        }
        RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
        MobEffectPacket mobEffectPacket = new MobEffectPacket();
        mobEffectPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
        mobEffectPacket.setEvent(MobEffectPacket.Event.REMOVE);
        mobEffectPacket.setEffectId(3);
        rakNetRelaySession.inboundPacket(mobEffectPacket);
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketOutbound)object).getPacket();
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"ClickBreak") && bedrockPacket instanceof InventoryTransactionPacket && ((InventoryTransactionPacket)bedrockPacket).getTransactionType() == TransactionType.ITEM_USE && ((InventoryTransactionPacket)bedrockPacket).getActionType() == 0 && !Intrinsics.areEqual((Object)((InventoryTransactionPacket)bedrockPacket).getBlockPosition(), (Object)Vector3i.ZERO)) {
            ((GameEventCancelable)object).cancel();
            GameSession gameSession = ((GameEvent)object).getSession();
            object = ((InventoryTransactionPacket)bedrockPacket).getBlockPosition();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.blockPosition");
            this.breakBlock(gameSession, (Vector3i)object, ((InventoryTransactionPacket)bedrockPacket).getBlockFace());
        }
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"Effect")) {
            if (eventTick.getSession().getTickExists() % (long)20 != 0L) {
                return;
            }
            RakNetRelaySession rakNetRelaySession = eventTick.getSession().getNetSession();
            MobEffectPacket mobEffectPacket = new MobEffectPacket();
            mobEffectPacket.setEvent(MobEffectPacket.Event.ADD);
            mobEffectPacket.setRuntimeEntityId(eventTick.getSession().getThePlayer().getRuntimeId());
            mobEffectPacket.setEffectId(3);
            mobEffectPacket.setAmplifier(((Number)this.amplifierValue.get()).intValue() - 1);
            mobEffectPacket.setParticles(false);
            mobEffectPacket.setDuration(420);
            rakNetRelaySession.inboundPacket(mobEffectPacket);
        }
    }
}

