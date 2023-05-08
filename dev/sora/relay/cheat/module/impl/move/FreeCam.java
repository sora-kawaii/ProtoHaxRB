/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector2f;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.Ability;
import com.nukkitx.protocol.bedrock.data.AbilityLayer;
import com.nukkitx.protocol.bedrock.data.PlayerPermission;
import com.nukkitx.protocol.bedrock.data.command.CommandPermission;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAbilitiesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/cheat/module/impl/move/FreeCam;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "gotPacket", "", "movePlayerPacket", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "oldPos", "Lcom/nukkitx/math/vector/Vector3f;", "kotlin.jvm.PlatformType", "playerAuthInputPacket", "onDisable", "", "onEnable", "onPacketOutbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class FreeCam
extends CheatModule {
    private boolean gotPacket;
    private BedrockPacket movePlayerPacket = new MovePlayerPacket();
    private Vector3f oldPos;
    private BedrockPacket playerAuthInputPacket = new PlayerAuthInputPacket();

    public FreeCam() {
        super("FreeCam", false, false, 6, null);
        this.oldPos = Vector3f.ZERO;
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = this.getSession().getThePlayer();
        Vector3f vector3f = this.oldPos;
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"oldPos");
        EntityPlayerSP.teleportTo$default(entityPlayerSP, vector3f, false, 2, null);
        this.gotPacket = false;
    }

    @Override
    public void onEnable() {
        this.oldPos = this.getSession().getThePlayer().getVec3Position();
        UUID.randomUUID();
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (bedrockPacket instanceof MovePlayerPacket) {
            if (!this.gotPacket) {
                this.movePlayerPacket = bedrockPacket;
                this.gotPacket = true;
            } else {
                eventPacketOutbound.cancel();
                eventPacketOutbound.getSession().getNetSession().outboundPacket(this.movePlayerPacket);
            }
        } else if (bedrockPacket instanceof PlayerAuthInputPacket) {
            if (!this.gotPacket) {
                ((PlayerAuthInputPacket)bedrockPacket).setMotion(Vector2f.ZERO);
                ((PlayerAuthInputPacket)bedrockPacket).setDelta(Vector3f.from(0.0f, -0.0784f, 0.0f));
                ((PlayerAuthInputPacket)bedrockPacket).getInputData().clear();
                this.playerAuthInputPacket = bedrockPacket;
                this.gotPacket = true;
            } else {
                eventPacketOutbound.cancel();
                eventPacketOutbound.getSession().getNetSession().outboundPacket(this.playerAuthInputPacket);
            }
        }
    }

    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (this.getSession().getNetSession().getPacketCodec().getProtocolVersion() >= 534) {
            RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
            UpdateAbilitiesPacket updateAbilitiesPacket = new UpdateAbilitiesPacket();
            updateAbilitiesPacket.setUniqueEntityId(((GameEvent)object).getSession().getThePlayer().getUniqueId());
            updateAbilitiesPacket.setPlayerPermission(PlayerPermission.OPERATOR);
            updateAbilitiesPacket.setCommandPermission(CommandPermission.OPERATOR);
            object = updateAbilitiesPacket.getAbilityLayers();
            AbilityLayer abilityLayer = new AbilityLayer();
            abilityLayer.setLayerType(AbilityLayer.Type.BASE);
            Object object2 = abilityLayer.getAbilitiesSet();
            Intrinsics.checkNotNullExpressionValue(object2, (String)"abilitiesSet");
            CollectionsKt.addAll((Collection)object2, (Object[])Ability.values());
            object2 = abilityLayer.getAbilityValues();
            Intrinsics.checkNotNullExpressionValue(object2, (String)"abilityValues");
            Collection collection = object2;
            Ability ability = Ability.BUILD;
            Ability ability2 = Ability.MINE;
            Ability ability3 = Ability.DOORS_AND_SWITCHES;
            object2 = Ability.OPEN_CONTAINERS;
            Ability ability4 = Ability.ATTACK_PLAYERS;
            Ability ability5 = Ability.ATTACK_MOBS;
            Ability ability6 = Ability.OPERATOR_COMMANDS;
            Ability ability7 = Ability.FLYING;
            Ability ability8 = Ability.NO_CLIP;
            Ability ability9 = Ability.FLY_SPEED;
            Ability ability10 = Ability.WALK_SPEED;
            CollectionsKt.addAll((Collection)collection, (Object[])new Ability[]{ability, ability2, ability3, object2, ability4, ability5, ability6, ability7, ability8, ability9, ability10});
            abilityLayer.setWalkSpeed(0.1f);
            abilityLayer.setFlySpeed(0.15f);
            object.add(abilityLayer);
            rakNetRelaySession.inboundPacket(updateAbilitiesPacket);
        }
    }
}

