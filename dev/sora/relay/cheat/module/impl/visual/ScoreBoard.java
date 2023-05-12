/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.protocol.bedrock.data.ScoreInfo;
import com.nukkitx.protocol.bedrock.packet.SetScorePacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.StringValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/ScoreBoard;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "customServerAddressValue", "Ldev/sora/relay/cheat/value/StringValue;", "serverAddressList", "", "", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ScoreBoard
extends CheatModule {
    private final StringValue customServerAddressValue;
    private final List<String> serverAddressList;

    public ScoreBoard() {
        super("ScoreBoard", true, false, 4, null);
        String string2 = "cubecraft.net";
        String string3 = "nethergames.org";
        String string4 = "play.venitymc.com";
        String string5 = "play.hyperlandsmc.net";
        String string6 = "mc.fapixel.com";
        String string7 = "prokits.space";
        String string8 = "mc.mirekits.xyz";
        this.serverAddressList = CollectionsKt.listOf((Object[])new String[]{string2, string3, string4, string5, string6, string7, string8});
        this.customServerAddressValue = new StringValue("ServerAddress", "ProtoHaxRB");
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketInbound)object).getPacket();
        if (object instanceof SetScorePacket && ((SetScorePacket)object).getAction() == SetScorePacket.Action.SET) {
            int n = ((SetScorePacket)object).getInfos().size();
            for (int i = 0; i < n; ++i) {
                ScoreInfo scoreInfo = ((SetScorePacket)object).getInfos().get(i);
                for (String string2 : this.serverAddressList) {
                    String string3 = scoreInfo.getName();
                    String string4 = scoreInfo.getName();
                    String string5 = "scoreInfo.name";
                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)string5);
                    if (Intrinsics.areEqual((Object)string3, (Object)StringsKt.replace$default((String)string4, (String)string2, (String)((String)this.customServerAddressValue.get()), (boolean)false, (int)4, null))) continue;
                    string3 = scoreInfo.getName();
                    Intrinsics.checkNotNullExpressionValue((Object)string3, (String)string5);
                    string5 = StringsKt.replace$default((String)string3, (String)string2, (String)((String)this.customServerAddressValue.get()), (boolean)false, (int)4, null);
                    ((SetScorePacket)object).getInfos().set(i, new ScoreInfo(scoreInfo.getScoreboardId(), scoreInfo.getObjectiveId(), scoreInfo.getScore(), string5));
                    return;
                }
            }
        }
    }
}

