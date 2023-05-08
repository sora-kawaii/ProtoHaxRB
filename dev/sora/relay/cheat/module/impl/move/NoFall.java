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
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/move/NoFall;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "delayTimer", "Ldev/sora/relay/utils/TimerUtil;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NoFall
extends CheatModule {
    private final TimerUtil delayTimer;
    private final ListValue modeValue;

    public NoFall() {
        super("NoFall", false, false, 6, null);
        String string = "OnGround";
        String string2 = "AwayNoGround";
        String string3 = "Nukkit";
        String string4 = "CubeCraft";
        this.modeValue = new ListValue("Mode", new String[]{string, string2, string3, string4}, string);
        this.delayTimer = new TimerUtil();
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (eventPacketOutbound.getSession().getThePlayer().getMotionY() < -0.1 && this.delayTimer.isDelayComplete(200.0) && Intrinsics.areEqual(this.modeValue.get(), (Object)"OnGround") && bedrockPacket instanceof MovePlayerPacket) {
            ((MovePlayerPacket)bedrockPacket).setOnGround(true);
            this.delayTimer.reset();
        }
        if (Intrinsics.areEqual(this.modeValue.get(), (Object)"AwayNoGround")) {
            if (bedrockPacket instanceof MovePlayerPacket) {
                ((MovePlayerPacket)bedrockPacket).setOnGround(false);
            }
        } else if (Intrinsics.areEqual(this.modeValue.get(), (Object)"CubeCraft") && bedrockPacket instanceof PlayerAuthInputPacket && ((PlayerAuthInputPacket)bedrockPacket).getDelta().getY() < -0.3f) {
            ((PlayerAuthInputPacket)bedrockPacket).setDelta(Vector3f.ZERO);
        }
    }

    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        GameSession gameSession = ((GameEvent)object).getSession();
        if (gameSession.getThePlayer().getMotionY() < -0.1 && this.delayTimer.isDelayComplete(200.0) && Intrinsics.areEqual(this.modeValue.get(), (Object)"Nukkit")) {
            object = new PlayerActionPacket();
            ((PlayerActionPacket)object).setRuntimeEntityId(gameSession.getThePlayer().getRuntimeId());
            ((PlayerActionPacket)object).setAction(PlayerActionType.START_GLIDE);
            gameSession.sendPacket((BedrockPacket)object);
            this.delayTimer.reset();
        }
    }
}

