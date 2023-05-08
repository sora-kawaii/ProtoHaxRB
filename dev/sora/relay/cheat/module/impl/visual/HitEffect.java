/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.LevelEventType;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.AddEntityPacket;
import com.nukkitx.protocol.bedrock.packet.AnimatePacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.LevelEventPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/HitEffect;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "effectValue", "Ldev/sora/relay/cheat/value/ListValue;", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HitEffect
extends CheatModule {
    private final ListValue effectValue;

    public HitEffect() {
        super("HitEffect", false, false, 6, null);
        String string = "Criticals";
        String string2 = "Lightning";
        String string3 = "Blood";
        this.effectValue = new ListValue("Effect", new String[]{string, string2, string3}, string);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object3 = ((EventPacketOutbound)object).getPacket();
        if (!(object3 instanceof InventoryTransactionPacket)) return;
        if (((InventoryTransactionPacket)object3).getTransactionType() != TransactionType.ITEM_USE_ON_ENTITY) return;
        if (((InventoryTransactionPacket)object3).getActionType() != 1) return;
        if (((InventoryTransactionPacket)object3).getRuntimeEntityId() == ((GameEvent)object).getSession().getThePlayer().getRuntimeId()) return;
        switch ((String)this.effectValue.get()) {
            default: {
                return;
            }
            case "Blood": {
                object3 = this.getSession().getTheWorld().getEntityMap().get(((InventoryTransactionPacket)object3).getRuntimeEntityId());
                if (object3 == null) {
                    return;
                }
                object2 = ((GameEvent)object).getSession().getNetSession();
                object = new LevelEventPacket();
                ((LevelEventPacket)object).setType(LevelEventType.PARTICLE_DESTROY_BLOCK);
                ((LevelEventPacket)object).setPosition(Vector3f.from(((Entity)object3).getVec3Position().getX(), ((Entity)object3).getVec3Position().getY() - 1.62f, ((Entity)object3).getVec3Position().getZ()));
                ((LevelEventPacket)object).setData(5169);
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
                return;
            }
            case "Lightning": {
                object3 = this.getSession().getTheWorld().getEntityMap().get(((InventoryTransactionPacket)object3).getRuntimeEntityId());
                if (object3 == null) {
                    return;
                }
                long l = Random.Default.nextLong();
                object2 = ((GameEvent)object).getSession().getNetSession();
                object = new AddEntityPacket();
                ((AddEntityPacket)object).setUniqueEntityId(l);
                ((AddEntityPacket)object).setRuntimeEntityId(l);
                ((AddEntityPacket)object).setIdentifier("minecraft:lightning_bolt");
                ((AddEntityPacket)object).setEntityType(0);
                ((AddEntityPacket)object).setPosition(Vector3f.from(((Entity)object3).getVec3Position().getX(), ((Entity)object3).getVec3Position().getY() - 1.62f, ((Entity)object3).getVec3Position().getZ()));
                ((AddEntityPacket)object).setMotion(Vector3f.ZERO);
                ((AddEntityPacket)object).setRotation(Vector3f.ZERO);
                ((AddEntityPacket)object).setBodyRotation(0.0f);
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
                return;
            }
            case "Criticals": 
        }
        object2 = ((GameEvent)object).getSession().getNetSession();
        object = new AnimatePacket();
        ((AnimatePacket)object).setRuntimeEntityId(((InventoryTransactionPacket)object3).getRuntimeEntityId());
        ((AnimatePacket)object).setAction(AnimatePacket.Action.CRITICAL_HIT);
        ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
    }
}

