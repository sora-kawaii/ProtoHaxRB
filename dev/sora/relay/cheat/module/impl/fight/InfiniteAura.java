/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.fight.AntiBot;
import dev.sora.relay.cheat.module.impl.fight.Friend;
import dev.sora.relay.cheat.module.impl.fight.Teams;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/InfiniteAura;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "attackModeValue", "Ldev/sora/relay/cheat/value/ListValue;", "attackTimer", "Ldev/sora/relay/utils/TimerUtil;", "cpsValue", "Ldev/sora/relay/cheat/value/IntValue;", "rangeValue", "Ldev/sora/relay/cheat/value/FloatValue;", "tpDistanceValue", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "teleport", "entity", "Ldev/sora/relay/game/entity/Entity;", "isBack", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class InfiniteAura
extends CheatModule {
    private final ListValue attackModeValue;
    private final TimerUtil attackTimer;
    private final IntValue cpsValue;
    private final FloatValue rangeValue;
    private final FloatValue tpDistanceValue;

    public InfiniteAura() {
        super("InfiniteAura", false, false, 6, null);
        String string2 = "Single";
        String string3 = "Multi";
        this.attackModeValue = new ListValue("AttackMode", new String[]{string2, string3}, string2);
        this.cpsValue = new IntValue("CPS", 3, 1, 20);
        this.rangeValue = new FloatValue("Range", 10.0f, 10.0f, 128.0f);
        this.tpDistanceValue = new FloatValue("TPDistance", 6.0f, 2.0f, 20.0f);
        this.attackTimer = new TimerUtil();
    }

    private final void teleport(Entity object, boolean bl) {
        Vector3f vector3f = ((Entity)object).getVec3Position();
        object = this.getSession().getThePlayer().getVec3Position();
        float f = ((Vector3f)object).distance(vector3f) / ((Number)this.tpDistanceValue.get()).floatValue();
        int n = (int)f;
        for (int i = 1; i < n + 1; ++i) {
            MovePlayerPacket movePlayerPacket;
            Object object2;
            Object object3;
            if (bl) {
                object3 = ((Vector3f)object).add(vector3f.sub((Vector3f)object).div(f).mul(i));
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"playerPos.add(entityPos.\u2026(times).mul(i.toFloat()))");
                object2 = this.getSession().getNetSession();
                movePlayerPacket = new MovePlayerPacket();
                movePlayerPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
                movePlayerPacket.setPosition((Vector3f)object3);
                movePlayerPacket.setRotation(this.getSession().getThePlayer().getVec3Rotation());
                movePlayerPacket.setOnGround(false);
                movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
                ((RakNetRelaySession)object2).outboundPacket(movePlayerPacket);
                continue;
            }
            object2 = vector3f.add(((Vector3f)object).sub(vector3f).div(f).mul(i));
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"entityPos.add(playerPos.\u2026(times).mul(i.toFloat()))");
            object3 = this.getSession().getNetSession();
            movePlayerPacket = new MovePlayerPacket();
            movePlayerPacket.setRuntimeEntityId(this.getSession().getThePlayer().getRuntimeId());
            movePlayerPacket.setPosition((Vector3f)object2);
            movePlayerPacket.setRotation(this.getSession().getThePlayer().getVec3Rotation());
            movePlayerPacket.setOnGround(false);
            movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
            ((RakNetRelaySession)object3).outboundPacket(movePlayerPacket);
        }
    }

    @Listen
    public final void onTick(EventTick object) {
        Object t;
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((Number)this.cpsValue.get()).intValue() < 20 && !this.attackTimer.isDelayComplete(1000.0 / (double)((Number)this.cpsValue.get()).intValue())) {
            return;
        }
        GameSession gameSession = ((GameEvent)object).getSession();
        float f = (float)Math.pow(((Number)this.rangeValue.get()).floatValue(), 2);
        Object object22 = gameSession.getTheWorld().getEntityMap().values();
        Object object3 = new ArrayList();
        Iterator iterator = object22.iterator();
        while (iterator.hasNext()) {
            t = iterator.next();
            object22 = (Entity)t;
            boolean bl = object22 instanceof EntityPlayer && ((Entity)object22).distanceSq(gameSession.getThePlayer()) < (double)f && !AntiBot.INSTANCE.isBot((EntityPlayer)object22, gameSession) && !Teams.INSTANCE.isTeammate((EntityPlayer)object22, gameSession) && !Friend.INSTANCE.isFriend((EntityPlayer)object22);
            if (!bl) continue;
            object3.add(t);
        }
        if ((object3 = (List)object3).isEmpty()) {
            return;
        }
        if (Intrinsics.areEqual(this.attackModeValue.get(), (Object)"Single")) {
            iterator = ((Iterable)object3).iterator();
            if (!iterator.hasNext()) {
                object3 = null;
            } else {
                object3 = iterator.next();
                if (iterator.hasNext()) {
                    double d = ((Entity)object3).distanceSq(((GameEvent)object).getSession().getThePlayer());
                    object22 = object3;
                    do {
                        t = iterator.next();
                        double d2 = ((Entity)t).distanceSq(((GameEvent)object).getSession().getThePlayer());
                        object3 = object22;
                        double d3 = d;
                        if (Double.compare(d, d2) > 0) {
                            object3 = t;
                            d3 = d2;
                        }
                        object22 = object3;
                        d = d3;
                    } while (iterator.hasNext());
                }
            }
            object = (Entity)object3;
            if (object == null) {
                return;
            }
            this.teleport((Entity)object, false);
            EntityPlayerSP.swing$default(gameSession.getThePlayer(), false, 1, null);
            gameSession.getThePlayer().attack((Entity)object, ((Entity)object).getVec3Position());
            this.teleport((Entity)object, true);
        } else if (Intrinsics.areEqual(this.attackModeValue.get(), (Object)"Multi")) {
            for (Object object22 : (Iterable)object3) {
                this.teleport((Entity)object22, false);
                EntityPlayerSP.swing$default(gameSession.getThePlayer(), false, 1, null);
                gameSession.getThePlayer().attack((Entity)object22, ((Entity)object22).getVec3Position());
                this.teleport((Entity)object22, true);
            }
            CollectionsKt.first((List)object3);
        }
        this.attackTimer.reset();
    }
}

