/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.event.GameEventCancelable;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.utils.TimerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/module/impl/other/AntiSpammer;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "prevMessage", "", "timer", "Ldev/sora/relay/utils/TimerUtil;", "times", "", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AntiSpammer
extends CheatModule {
    private String prevMessage = "";
    private final TimerUtil timer = new TimerUtil();
    private int times = 1;

    public AntiSpammer() {
        super("AntiSpammer", false, false, 6, null);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketInbound)object).getPacket();
        if (bedrockPacket instanceof TextPacket) {
            if (Intrinsics.areEqual((Object)this.prevMessage, (Object)((TextPacket)bedrockPacket).getMessage())) {
                int n;
                this.timer.reset();
                this.times = n = this.times + 1;
                if (n >= 5) {
                    if (n == 5 || n == 10 || n == 50) {
                        this.chat("This message has been repeated " + this.times + " times");
                    }
                    ((GameEventCancelable)object).cancel();
                    return;
                }
            } else if (this.timer.isDelayComplete(50000.0)) {
                this.times = 1;
            }
            object = ((TextPacket)bedrockPacket).getMessage();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.message");
            this.prevMessage = object;
        }
    }
}

