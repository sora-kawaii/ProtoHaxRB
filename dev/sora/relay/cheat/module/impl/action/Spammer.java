/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.command.CommandOriginData;
import com.nukkitx.protocol.bedrock.data.command.CommandOriginType;
import com.nukkitx.protocol.bedrock.packet.CommandRequestPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerListPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.cheat.value.StringValue;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.StringUtilsKt;
import dev.sora.relay.utils.TimerUtil;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ldev/sora/relay/cheat/module/impl/action/Spammer;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "chatValue", "Ldev/sora/relay/cheat/value/ListValue;", "delayValue", "Ldev/sora/relay/cheat/value/IntValue;", "messageValue", "Ldev/sora/relay/cheat/value/StringValue;", "spamTimer", "Ldev/sora/relay/utils/TimerUtil;", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Spammer
extends CheatModule {
    private final ListValue chatValue;
    private final IntValue delayValue;
    private final StringValue messageValue;
    private final TimerUtil spamTimer;

    public Spammer() {
        super("Spammer", false, false, 6, null);
        String string = "Public";
        String string2 = "Private";
        String string3 = "Me";
        this.chatValue = new ListValue("Chat", new String[]{string, string2, string3}, string);
        this.delayValue = new IntValue("Delay", 5000, 0, 10000);
        this.messageValue = new StringValue("Message", "I'm useing ProtoHaxRB,bilibili search for SRYuYing369!");
        this.spamTimer = new TimerUtil();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (this.spamTimer.isDelayComplete(((Number)this.delayValue.get()).intValue())) {
            Object object2 = (String)this.chatValue.get();
            switch (((String)object2).hashCode()) {
                case 1350155619: {
                    if (!((String)object2).equals("Private")) break;
                    for (PlayerListPacket.Entry entry : this.getSession().getTheWorld().getPlayerList().values()) {
                        object2 = ((GameEvent)object).getSession().getNetSession();
                        CommandRequestPacket commandRequestPacket = new CommandRequestPacket();
                        commandRequestPacket.setCommand("/w " + entry.getName() + ' ' + (String)this.messageValue.get());
                        commandRequestPacket.setCommandOriginData(new CommandOriginData(CommandOriginType.PLAYER, UUID.randomUUID(), "", -1L));
                        commandRequestPacket.setInternal(false);
                        ((RakNetRelaySession)object2).outboundPacket(commandRequestPacket);
                    }
                    break;
                }
                case 2488: {
                    if (!((String)object2).equals("Me")) break;
                    object2 = ((GameEvent)object).getSession().getNetSession();
                    object = new CommandRequestPacket();
                    ((CommandRequestPacket)object).setCommand("/\\me " + (String)this.messageValue.get());
                    ((CommandRequestPacket)object).setCommandOriginData(new CommandOriginData(CommandOriginType.PLAYER, UUID.randomUUID(), "", -1L));
                    ((CommandRequestPacket)object).setInternal(false);
                    ((RakNetRelaySession)object2).outboundPacket((BedrockPacket)object);
                    break;
                }
                case -1893556599: {
                    if (((String)object2).equals("Public")) {
                        ((GameEvent)object).getSession().getThePlayer().say('@' + (String)this.messageValue.get() + " >" + StringUtilsKt.getRandomString(Random.Default.nextInt(5) + 10) + '<');
                        break;
                    } else {
                        break;
                    }
                }
            }
            this.spamTimer.reset();
        }
    }
}

