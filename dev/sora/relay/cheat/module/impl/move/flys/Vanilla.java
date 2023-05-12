/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move.flys;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.Ability;
import com.nukkitx.protocol.bedrock.data.AbilityLayer;
import com.nukkitx.protocol.bedrock.data.PlayerPermission;
import com.nukkitx.protocol.bedrock.data.command.CommandPermission;
import com.nukkitx.protocol.bedrock.packet.RequestAbilityPacket;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAbilitiesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ldev/sora/relay/cheat/module/impl/move/flys/Vanilla;", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "()V", "canFly", "", "mayflyAbilityPacket", "Lcom/nukkitx/protocol/bedrock/packet/UpdateAbilitiesPacket;", "onEnable", "", "session", "Ldev/sora/relay/game/GameSession;", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Vanilla
extends FlyMode {
    private boolean canFly;
    private final UpdateAbilitiesPacket mayflyAbilityPacket;

    public Vanilla() {
        super("Vanilla");
        UpdateAbilitiesPacket updateAbilitiesPacket = new UpdateAbilitiesPacket();
        updateAbilitiesPacket.setPlayerPermission(PlayerPermission.OPERATOR);
        updateAbilitiesPacket.setCommandPermission(CommandPermission.OPERATOR);
        List<AbilityLayer> list = updateAbilitiesPacket.getAbilityLayers();
        AbilityLayer abilityLayer = new AbilityLayer();
        abilityLayer.setLayerType(AbilityLayer.Type.BASE);
        Object object = abilityLayer.getAbilitiesSet();
        Intrinsics.checkNotNullExpressionValue(object, (String)"abilitiesSet");
        CollectionsKt.addAll((Collection)object, (Object[])Ability.values());
        object = abilityLayer.getAbilityValues();
        Intrinsics.checkNotNullExpressionValue(object, (String)"abilityValues");
        Collection collection = object;
        Ability ability = Ability.BUILD;
        object = Ability.MINE;
        Ability ability2 = Ability.DOORS_AND_SWITCHES;
        Ability ability3 = Ability.OPEN_CONTAINERS;
        Ability ability4 = Ability.ATTACK_PLAYERS;
        Ability ability5 = Ability.ATTACK_MOBS;
        Ability ability6 = Ability.OPERATOR_COMMANDS;
        Ability ability7 = Ability.FLY_SPEED;
        Ability ability8 = Ability.WALK_SPEED;
        CollectionsKt.addAll((Collection)collection, (Object[])new Ability[]{ability, object, ability2, ability3, ability4, ability5, ability6, ability7, ability8});
        abilityLayer.setWalkSpeed(0.1f);
        abilityLayer.setFlySpeed(0.15f);
        list.add(abilityLayer);
        this.mayflyAbilityPacket = updateAbilitiesPacket;
    }

    @Override
    public void onEnable(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.canFly = false;
    }

    @Override
    public void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        Object object = eventPacketInbound.getPacket();
        if (object instanceof UpdateAbilitiesPacket) {
            eventPacketInbound.cancel();
        } else if (object instanceof StartGamePacket) {
            object = eventPacketInbound.getSession().getNetSession();
            UpdateAbilitiesPacket updateAbilitiesPacket = this.mayflyAbilityPacket;
            updateAbilitiesPacket.setUniqueEntityId(eventPacketInbound.getSession().getThePlayer().getUniqueId());
            ((RakNetRelaySession)object).inboundPacket(updateAbilitiesPacket);
        }
    }

    @Override
    public void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (bedrockPacket instanceof RequestAbilityPacket && ((RequestAbilityPacket)bedrockPacket).getAbility() == Ability.FLYING) {
            eventPacketOutbound.cancel();
        }
    }

    @Override
    public void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (!this.canFly) {
            this.canFly = true;
            RakNetRelaySession rakNetRelaySession = eventTick.getSession().getNetSession();
            UpdateAbilitiesPacket updateAbilitiesPacket = this.mayflyAbilityPacket;
            updateAbilitiesPacket.setUniqueEntityId(eventTick.getSession().getThePlayer().getUniqueId());
            rakNetRelaySession.inboundPacket(updateAbilitiesPacket);
        }
    }
}

