/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.NetworkStackLatencyPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateBlockPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.utils.LoggerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ldev/sora/relay/cheat/module/impl/other/PacketLogger;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "clientPacketValue", "Ldev/sora/relay/cheat/value/BoolValue;", "noSpamPacketValue", "printValue", "Ldev/sora/relay/cheat/value/ListValue;", "serverPacketValue", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "printPacket", "message", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class PacketLogger
extends CheatModule {
    private final BoolValue clientPacketValue;
    private final BoolValue noSpamPacketValue;
    private final ListValue printValue;
    private final BoolValue serverPacketValue;

    public PacketLogger() {
        super("PacketLogger", false, false, 6, null);
        String string = "Chat";
        String string2 = "Console";
        String string3 = "Logcat";
        this.printValue = new ListValue("Print", new String[]{string, string2, string3}, string);
        this.clientPacketValue = new BoolValue("ClientPacket", true);
        this.serverPacketValue = new BoolValue("ServerPacket", false);
        this.noSpamPacketValue = new BoolValue("No SpamPacket", false);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void printPacket(String string) {
        switch ((String)this.printValue.get()) {
            default: {
                return;
            }
            case "Chat": {
                this.chat(string);
                return;
            }
            case "Console": {
                System.out.println((Object)string);
                return;
            }
            case "Logcat": 
        }
        LoggerKt.logInfo(string);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((Boolean)this.serverPacketValue.get()).booleanValue()) {
            object = ((EventPacketInbound)object).getPacket();
            if (((Boolean)this.noSpamPacketValue.get()).booleanValue() && (object instanceof UpdateBlockPacket || object instanceof SetEntityDataPacket || object instanceof NetworkStackLatencyPacket || object instanceof MovePlayerPacket)) {
                return;
            }
            this.printPacket("ServerPacket " + ((BedrockPacket)object).getPacketId() + ' ' + object);
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (((Boolean)this.clientPacketValue.get()).booleanValue()) {
            object = ((EventPacketOutbound)object).getPacket();
            if (((Boolean)this.noSpamPacketValue.get()).booleanValue() && (object instanceof PlayerAuthInputPacket || object instanceof MovePlayerPacket || object instanceof NetworkStackLatencyPacket)) {
                return;
            }
            this.printPacket("ClientPacket " + ((BedrockPacket)object).getPacketId() + ' ' + object);
        }
    }
}

