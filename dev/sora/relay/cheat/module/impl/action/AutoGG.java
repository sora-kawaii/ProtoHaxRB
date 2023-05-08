/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.protocol.bedrock.packet.SetTitlePacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.cheat.value.StringValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ldev/sora/relay/cheat/module/impl/action/AutoGG;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "messageCheckValue", "Ldev/sora/relay/cheat/value/StringValue;", "messageValue", "Ldev/sora/relay/cheat/value/ListValue;", "titleCheckValue", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AutoGG
extends CheatModule {
    private final StringValue messageCheckValue = new StringValue("MessageCheck", "win");
    private final ListValue messageValue;
    private final StringValue titleCheckValue = new StringValue("TitleCheck", "victory");

    public AutoGG() {
        super("AutoGG", false, false, 6, null);
        String string = "GG";
        String string2 = "ProtoHaxRB user won!";
        String string3 = "You are loser.";
        this.messageValue = new ListValue("Message", new String[]{string, string2, string3}, string);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        Object object = eventPacketInbound.getPacket();
        if (object instanceof TextPacket) {
            if (StringsKt.isBlank((CharSequence)((CharSequence)this.messageCheckValue.get())) ^ true) {
                object = ((TextPacket)object).getMessage();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.message");
                if (StringsKt.contains((CharSequence)((CharSequence)object), (CharSequence)((CharSequence)this.messageCheckValue.get()), (boolean)true)) {
                    eventPacketInbound.getSession().getThePlayer().say((String)this.messageValue.get());
                }
            }
        } else if (object instanceof SetTitlePacket && StringsKt.isBlank((CharSequence)((CharSequence)this.titleCheckValue.get())) ^ true) {
            object = ((SetTitlePacket)object).getText();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.text");
            if (StringsKt.contains((CharSequence)((CharSequence)object), (CharSequence)((CharSequence)this.titleCheckValue.get()), (boolean)true)) {
                eventPacketInbound.getSession().getThePlayer().say((String)this.messageValue.get());
            }
        }
    }
}

