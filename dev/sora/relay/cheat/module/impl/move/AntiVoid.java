/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/cheat/module/impl/move/AntiVoid;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "groundPos", "Lcom/nukkitx/math/vector/Vector3f;", "kotlin.jvm.PlatformType", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "pullbackTimeTimer", "Ldev/sora/relay/utils/TimerUtil;", "pullbackTimeValue", "Ldev/sora/relay/cheat/value/FloatValue;", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AntiVoid
extends CheatModule {
    private Vector3f groundPos;
    private final ListValue modeValue;
    private final TimerUtil pullbackTimeTimer;
    private final FloatValue pullbackTimeValue;

    public AntiVoid() {
        super("AntiVoid", false, false, 6, null);
        String string = "Teleport";
        String string2 = "LerpTP";
        String string3 = "MotionFlag";
        String string4 = "PacketFlag";
        this.modeValue = new ListValue("Mode", new String[]{string, string2, string3, string4}, string);
        this.pullbackTimeValue = new FloatValue("Pullback Time", 1000.0f, 50.0f, 3000.0f);
        this.pullbackTimeTimer = new TimerUtil();
        this.groundPos = Vector3f.ZERO;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        EntityPlayerSP entityPlayerSP = ((GameEvent)object).getSession().getThePlayer();
        if (entityPlayerSP.getOnGround()) {
            this.groundPos = entityPlayerSP.getVec3Position();
            this.pullbackTimeTimer.reset();
            return;
        }
        if (!(entityPlayerSP.getMotionY() < -0.1)) {
            this.pullbackTimeTimer.reset();
            return;
        }
        if (!this.pullbackTimeTimer.isDelayComplete(((Number)this.pullbackTimeValue.get()).floatValue())) return;
        Object object2 = (String)this.modeValue.get();
        int n = ((String)object2).hashCode();
        Object object3 = "groundPos";
        switch (n) {
            case 1272136802: {
                if (!((String)object2).equals("MotionFlag")) break;
                entityPlayerSP.setMotion(100.0, 0.0, 100.0);
                break;
            }
            case -1295557813: {
                if (((String)object2).equals("Teleport")) {
                    if (Intrinsics.areEqual((Object)this.groundPos, (Object)Vector3f.ZERO)) break;
                    object = this.groundPos;
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)object3);
                    EntityPlayerSP.teleportTo$default(entityPlayerSP, (Vector3f)object, false, 2, null);
                    break;
                }
            }
            default: {
                break;
            }
            case -2022369709: {
                if (!((String)object2).equals("LerpTP") || Intrinsics.areEqual((Object)this.groundPos, (Object)Vector3f.ZERO)) break;
                object = this.groundPos;
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)object3);
                entityPlayerSP.teleportTo((Vector3f)object, true);
                break;
            }
            case -2146559948: {
                if (!((String)object2).equals("PacketFlag")) break;
                object3 = ((GameEvent)object).getSession().getNetSession();
                object2 = new MovePlayerPacket();
                ((MovePlayerPacket)object2).setRuntimeEntityId(entityPlayerSP.getRuntimeId());
                ((MovePlayerPacket)object2).setPosition(entityPlayerSP.getVec3Position().add(0.0, 0.3, 0.0));
                ((MovePlayerPacket)object2).setRotation(entityPlayerSP.getVec3Rotation());
                ((MovePlayerPacket)object2).setMode(MovePlayerPacket.Mode.NORMAL);
                ((MovePlayerPacket)object2).setOnGround(false);
                ((MovePlayerPacket)object2).setRidingRuntimeEntityId(0L);
                ((MovePlayerPacket)object2).setEntityType(0);
                ((MovePlayerPacket)object2).setTick(((GameEvent)object).getSession().getTickExists());
                ((RakNetRelaySession)object3).outboundPacket((BedrockPacket)object2);
                object2 = ((GameEvent)object).getSession().getNetSession();
                object3 = new MovePlayerPacket();
                ((MovePlayerPacket)object3).setRuntimeEntityId(entityPlayerSP.getRuntimeId());
                ((MovePlayerPacket)object3).setPosition(entityPlayerSP.getVec3Position().add(0.0, 1.0, 0.0));
                ((MovePlayerPacket)object3).setRotation(entityPlayerSP.getVec3Rotation());
                ((MovePlayerPacket)object3).setMode(MovePlayerPacket.Mode.NORMAL);
                ((MovePlayerPacket)object3).setOnGround(false);
                ((MovePlayerPacket)object3).setRidingRuntimeEntityId(0L);
                ((MovePlayerPacket)object3).setEntityType(0);
                ((MovePlayerPacket)object3).setTick(((GameEvent)object).getSession().getTickExists());
                ((RakNetRelaySession)object2).outboundPacket((BedrockPacket)object3);
            }
        }
        this.pullbackTimeTimer.reset();
    }
}

