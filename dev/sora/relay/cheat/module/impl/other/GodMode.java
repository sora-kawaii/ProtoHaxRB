/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/other/GodMode;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class GodMode
extends CheatModule {
    private final ListValue modeValue;

    public GodMode() {
        super("GodMode", false, false, 6, null);
        String string = "EaseCation";
        String string2 = "HYT";
        this.modeValue = new ListValue("Mode", new String[]{string, string2}, string2);
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        EntityPlayerSP entityPlayerSP = eventTick.getSession().getThePlayer();
        Object object = (String)this.modeValue.get();
        if (Intrinsics.areEqual((Object)object, (Object)"EaseCation")) {
            object = eventTick.getSession().getNetSession();
            MovePlayerPacket movePlayerPacket = new MovePlayerPacket();
            movePlayerPacket.setRuntimeEntityId(entityPlayerSP.getRuntimeId());
            movePlayerPacket.setPosition(entityPlayerSP.getVec3Position().add(1000.0, 1000.0, 1000.0));
            movePlayerPacket.setRotation(entityPlayerSP.getVec3Rotation());
            movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
            movePlayerPacket.setOnGround(false);
            movePlayerPacket.setTick(eventTick.getSession().getTickExists());
            ((RakNetRelaySession)object).outboundPacket(movePlayerPacket);
        } else if (Intrinsics.areEqual((Object)object, (Object)"HYT")) {
            entityPlayerSP.attack(entityPlayerSP, entityPlayerSP.getVec3Position());
        }
    }
}

