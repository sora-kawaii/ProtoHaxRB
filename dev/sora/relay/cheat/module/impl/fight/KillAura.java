/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.math.vector.Vector2f;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
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
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/KillAura;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "attackModeValue", "Ldev/sora/relay/cheat/value/ListValue;", "attackTimer", "Ldev/sora/relay/utils/TimerUtil;", "cpsValue", "Ldev/sora/relay/cheat/value/IntValue;", "failRateValue", "Ldev/sora/relay/cheat/value/FloatValue;", "priorityValue", "rangeValue", "rotationAngle", "Lcom/nukkitx/math/vector/Vector2f;", "kotlin.jvm.PlatformType", "rotationModeValue", "swingValue", "switchDelayValue", "switchTarget", "", "switchTimer", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "swing", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class KillAura
extends CheatModule {
    private final ListValue attackModeValue;
    private final TimerUtil attackTimer;
    private final IntValue cpsValue;
    private final FloatValue failRateValue;
    private final ListValue priorityValue;
    private final FloatValue rangeValue;
    private Vector2f rotationAngle;
    private final ListValue rotationModeValue;
    private final ListValue swingValue;
    private final FloatValue switchDelayValue;
    private int switchTarget;
    private final TimerUtil switchTimer;

    public KillAura() {
        super("KillAura", false, false, 6, null);
        String string2 = "Single";
        String string3 = "Multi";
        String string4 = "Switch";
        this.attackModeValue = new ListValue("AttackMode", new String[]{string2, string3, string4}, string4);
        string2 = "Client";
        string3 = "Server";
        string4 = "None";
        this.rotationModeValue = new ListValue("RotationMode", new String[]{string2, string3, string4}, string3);
        string2 = "Range";
        String string5 = "Angle";
        String string6 = "HurtTime";
        this.priorityValue = new ListValue("Priority", new String[]{string2, string5, string6}, string2);
        string6 = "Normal";
        this.swingValue = new ListValue("SwingMode", new String[]{string6, string3, string4}, string6);
        this.cpsValue = new IntValue("CPS", 7, 1, 20);
        this.rangeValue = new FloatValue(string2, 4.5f, 2.0f, 7.0f);
        this.switchDelayValue = new FloatValue("SwitchDelay", 100.0f, 50.0f, 1000.0f);
        this.failRateValue = new FloatValue("FailRate", 0.0f, 0.0f, 1.0f);
        this.rotationAngle = Vector2f.ZERO;
        this.attackTimer = new TimerUtil();
        this.switchTimer = new TimerUtil();
    }

    private final void swing() {
        String string2 = (String)this.swingValue.get();
        if (Intrinsics.areEqual((Object)string2, (Object)"Normal")) {
            EntityPlayerSP.swing$default(this.getSession().getThePlayer(), false, 1, null);
        } else if (Intrinsics.areEqual((Object)string2, (Object)"Server")) {
            this.getSession().getThePlayer().swing(true);
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (Intrinsics.areEqual(this.rotationModeValue.get(), (Object)"Server")) {
            if (Intrinsics.areEqual((Object)this.rotationAngle, (Object)Vector2f.ZERO)) {
                return;
            }
            Vector2f vector2f = this.rotationAngle;
            if ((object = ((EventPacketOutbound)object).getPacket()) instanceof PlayerAuthInputPacket) {
                ((PlayerAuthInputPacket)object).setRotation(Vector3f.from(vector2f.getX(), vector2f.getY(), vector2f.getY()));
                this.rotationAngle = Vector2f.ZERO;
            } else if (object instanceof MovePlayerPacket) {
                ((MovePlayerPacket)object).setRotation(Vector3f.from(vector2f.getX(), vector2f.getY(), vector2f.getY()));
                this.rotationAngle = Vector2f.ZERO;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Listen
    public final void onTick(EventTick object) {
        Object object22;
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((Number)this.cpsValue.get()).intValue() < 20 && !this.attackTimer.isDelayComplete(1000.0 / (double)((Number)this.cpsValue.get()).intValue())) {
            return;
        }
        GameSession gameSession = ((GameEvent)object).getSession();
        float f = (float)Math.pow(((Number)this.rangeValue.get()).floatValue(), 2);
        Object object3 = gameSession.getTheWorld().getEntityMap().values();
        object = new ArrayList();
        Iterator iterator = object3.iterator();
        while (iterator.hasNext()) {
            object22 = iterator.next();
            object3 = (Entity)object22;
            boolean bl = object3 instanceof EntityPlayer && ((Entity)object3).distanceSq(gameSession.getThePlayer()) < (double)f && !AntiBot.INSTANCE.isBot((EntityPlayer)object3, gameSession) && !Teams.INSTANCE.isTeammate((EntityPlayer)object3, gameSession) && !Friend.INSTANCE.isFriend((EntityPlayer)object3);
            if (!bl) continue;
            object.add(object22);
        }
        if ((object = (List)object).isEmpty()) {
            return;
        }
        if (this.switchTarget >= object.size()) {
            this.switchTarget = 0;
        }
        if (!Intrinsics.areEqual(object22 = this.attackModeValue.get(), (Object)(object3 = "Multi"))) {
            switch ((String)this.priorityValue.get()) {
                default: {
                    break;
                }
                case "HurtTime": {
                    CollectionsKt.sortedWith((Iterable)((Iterable)object), (Comparator)new Comparator(){

                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues((Comparable)Integer.valueOf(((Entity)t).getHurtTime()), (Comparable)Integer.valueOf(((Entity)t2).getHurtTime()));
                        }
                    });
                    break;
                }
                case "Range": {
                    CollectionsKt.sortedWith((Iterable)((Iterable)object), (Comparator)new Comparator(gameSession){
                        final /* synthetic */ GameSession $session$inlined;
                        {
                            this.$session$inlined = gameSession;
                        }

                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues((Comparable)Double.valueOf(((Entity)t).distance(this.$session$inlined.getThePlayer())), (Comparable)Double.valueOf(((Entity)t2).distance(this.$session$inlined.getThePlayer())));
                        }
                    });
                    break;
                }
                case "Angle": {
                    CollectionsKt.sortedWith((Iterable)((Iterable)object), (Comparator)new Comparator(gameSession){
                        final /* synthetic */ GameSession $session$inlined;
                        {
                            this.$session$inlined = gameSession;
                        }

                        public final int compare(T object, T object2) {
                            object = (Entity)object;
                            object = Float.valueOf(Math.abs(this.$session$inlined.getThePlayer().rotation(((Entity)object).getVec3Position()).getY()));
                            object2 = (Entity)object2;
                            return ComparisonsKt.compareValues((Comparable)object, (Comparable)Float.valueOf(Math.abs(this.$session$inlined.getThePlayer().rotation(((Entity)object2).getVec3Position()).getY())));
                        }
                    });
                }
            }
        }
        if (Math.random() <= (double)((Number)this.failRateValue.get()).floatValue()) {
            this.swing();
            object = (Entity)CollectionsKt.first((List)object);
        } else {
            object22 = (String)this.attackModeValue.get();
            if (Intrinsics.areEqual((Object)object22, (Object)"Single")) {
                object3 = CollectionsKt.first((List)object);
                object = (Entity)object3;
                this.swing();
                gameSession.getThePlayer().attack((Entity)object, gameSession.getThePlayer().getVec3Position());
                object = (Entity)object3;
            } else if (Intrinsics.areEqual((Object)object22, (Object)object3)) {
                for (Object object22 : (Iterable)object) {
                    this.swing();
                    gameSession.getThePlayer().attack((Entity)object22, gameSession.getThePlayer().getVec3Position());
                }
                object = (Entity)CollectionsKt.first((List)object);
            } else {
                this.swing();
                gameSession.getThePlayer().attack((Entity)object.get(this.switchTarget), gameSession.getThePlayer().getVec3Position());
                if (this.switchTimer.isDelayComplete(((Number)this.switchDelayValue.get()).floatValue())) {
                    ++this.switchTarget;
                    this.switchTimer.reset();
                }
                object = (Entity)object.get(this.switchTarget);
            }
        }
        if (!Intrinsics.areEqual(this.rotationModeValue.get(), (Object)"None")) {
            this.rotationAngle = gameSession.getThePlayer().rotation(((Entity)object).getVec3Position());
        }
        if (Intrinsics.areEqual(this.rotationModeValue.get(), (Object)"Client")) {
            if (!Intrinsics.areEqual((Object)this.rotationAngle, (Object)Vector2f.ZERO)) {
                object = gameSession.getNetSession();
                object3 = new MovePlayerPacket();
                ((MovePlayerPacket)object3).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
                ((MovePlayerPacket)object3).setPosition(gameSession.getThePlayer().getVec3Position());
                ((MovePlayerPacket)object3).setRotation(Vector3f.from(((MovePlayerPacket)object3).getRotation().getX(), ((MovePlayerPacket)object3).getRotation().getY(), ((MovePlayerPacket)object3).getRotation().getY()));
                ((MovePlayerPacket)object3).setMode(MovePlayerPacket.Mode.HEAD_ROTATION);
                ((RakNetRelaySession)object).inboundPacket((BedrockPacket)object3);
            }
        } else if (Intrinsics.areEqual(this.rotationModeValue.get(), (Object)"Server") && Intrinsics.areEqual((Object)gameSession.getThePlayer().getVec3PrevPosition(), (Object)gameSession.getThePlayer().getVec3Position()) && Intrinsics.areEqual((Object)gameSession.getThePlayer().getVec3PrevRotation(), (Object)gameSession.getThePlayer().getVec3Rotation())) {
            object = new MovePlayerPacket();
            ((MovePlayerPacket)object).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
            ((MovePlayerPacket)object).setPosition(gameSession.getThePlayer().getVec3Position());
            ((MovePlayerPacket)object).setRotation(gameSession.getThePlayer().getVec3Rotation());
            ((MovePlayerPacket)object).setMode(MovePlayerPacket.Mode.NORMAL);
            ((MovePlayerPacket)object).setTeleportationCause(null);
            ((MovePlayerPacket)object).setOnGround(gameSession.getThePlayer().getOnGround());
            ((MovePlayerPacket)object).setRidingRuntimeEntityId(0L);
            ((MovePlayerPacket)object).setEntityType(0);
            ((MovePlayerPacket)object).setTick(gameSession.getTickExists());
            gameSession.sendPacket((BedrockPacket)object);
        }
        this.attackTimer.reset();
    }
}

