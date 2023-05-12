/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.protocol.bedrock.packet.SetTitlePacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/NameProtect;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "nameValue", "Ldev/sora/relay/cheat/value/ListValue;", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NameProtect
extends CheatModule {
    private final ListValue nameValue;

    public NameProtect() {
        super("NameProtect", false, false, 6, null);
        String string2 = "ProtoHaxRB User";
        String string3 = "\u82b1\u96e8\u5ead";
        String string4 = "\u53f2\u8482\u592b";
        this.nameValue = new ListValue("Name", new String[]{string2, string3, string4}, string2);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = ((EventPacketInbound)object).getPacket();
        object = ((GameEvent)object).getSession().getThePlayer().getUsername();
        if (object2 instanceof TextPacket) {
            TextPacket textPacket = (TextPacket)object2;
            object2 = ((TextPacket)object2).getMessage();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.message");
            textPacket.setMessage(StringsKt.replace$default((String)object2, (String)object, (String)((String)this.nameValue.get()), (boolean)false, (int)4, null));
        } else if (object2 instanceof SetTitlePacket) {
            SetTitlePacket setTitlePacket = (SetTitlePacket)object2;
            object2 = ((SetTitlePacket)object2).getText();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.text");
            setTitlePacket.setText(StringsKt.replace$default((String)object2, (String)object, (String)((String)this.nameValue.get()), (boolean)false, (int)4, null));
        }
    }
}

