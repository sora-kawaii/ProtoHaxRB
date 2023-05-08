/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move.flys;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.Ability;
import com.nukkitx.protocol.bedrock.data.AbilityLayer;
import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import com.nukkitx.protocol.bedrock.data.PlayerPermission;
import com.nukkitx.protocol.bedrock.data.command.CommandPermission;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAbilitiesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.module.impl.move.FlyMode;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventTick;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/module/impl/move/flys/Motion;", "Ldev/sora/relay/cheat/module/impl/move/FlyMode;", "()V", "flyingAbilityPacket", "Lcom/nukkitx/protocol/bedrock/packet/UpdateAbilitiesPacket;", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Motion
extends FlyMode {
    private final UpdateAbilitiesPacket flyingAbilityPacket;

    public Motion() {
        super("Motion");
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
        Ability ability2 = Ability.MINE;
        Ability ability3 = Ability.DOORS_AND_SWITCHES;
        Ability ability4 = Ability.OPEN_CONTAINERS;
        Ability ability5 = Ability.ATTACK_PLAYERS;
        object = Ability.ATTACK_MOBS;
        Ability ability6 = Ability.OPERATOR_COMMANDS;
        Ability ability7 = Ability.FLYING;
        Ability ability8 = Ability.FLY_SPEED;
        Ability ability9 = Ability.WALK_SPEED;
        CollectionsKt.addAll((Collection)collection, (Object[])new Ability[]{ability, ability2, ability3, ability4, ability5, object, ability6, ability7, ability8, ability9});
        abilityLayer.setWalkSpeed(0.1f);
        abilityLayer.setFlySpeed(0.15f);
        list.add(abilityLayer);
        this.flyingAbilityPacket = updateAbilitiesPacket;
    }

    @Override
    public void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        if (eventPacketInbound.getPacket() instanceof StartGamePacket) {
            RakNetRelaySession rakNetRelaySession = eventPacketInbound.getSession().getNetSession();
            UpdateAbilitiesPacket updateAbilitiesPacket = this.flyingAbilityPacket;
            updateAbilitiesPacket.setUniqueEntityId(eventPacketInbound.getSession().getThePlayer().getUniqueId());
            rakNetRelaySession.inboundPacket(updateAbilitiesPacket);
        }
    }

    @Override
    public void onTick(EventTick object) {
        double d;
        double d2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        EntityPlayerSP entityPlayerSP = ((GameEvent)object).getSession().getThePlayer();
        RakNetRelaySession rakNetRelaySession = ((GameEvent)object).getSession().getNetSession();
        object = this.flyingAbilityPacket;
        ((UpdateAbilitiesPacket)object).setUniqueEntityId(entityPlayerSP.getUniqueId());
        rakNetRelaySession.inboundPacket((BedrockPacket)object);
        double d3 = entityPlayerSP.getInputData().contains((Object)PlayerAuthInputData.WANT_UP) ? (double)((Number)new Fly().getVerticalSpeedValue().get()).floatValue() : (entityPlayerSP.getInputData().contains((Object)PlayerAuthInputData.WANT_DOWN) ? -((double)((Number)new Fly().getVerticalSpeedValue().get()).floatValue()) : 0.0391998291015625);
        if (entityPlayerSP.isHorizontallyMove()) {
            d2 = entityPlayerSP.getDirection();
            d = -Math.sin(d2);
            double d4 = ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue();
            d2 = Math.cos(d2);
            double d5 = ((Number)new Fly().getHorizontalSpeedValue().get()).doubleValue();
            d *= d4;
            d2 *= d5;
        } else {
            d = 0.0;
            d2 = 0.0;
        }
        entityPlayerSP.setMotion(d, d3, d2);
    }
}

