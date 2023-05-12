/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.other;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.InputInteractionModel;
import com.nukkitx.protocol.bedrock.data.InputMode;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import io.netty.util.AsciiString;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/other/DeviceSpoof;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class DeviceSpoof
extends CheatModule {
    public DeviceSpoof() {
        super("DeviceSpoof", false, false, 6, null);
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        BedrockPacket bedrockPacket = ((EventPacketOutbound)object).getPacket();
        if (bedrockPacket instanceof LoginPacket) {
            int n;
            int n2;
            Object object2;
            Object object3;
            block7: {
                object3 = Base64.getDecoder();
                object = ((LoginPacket)bedrockPacket).getSkinData().toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.skinData.toString()");
                object = ((Base64.Decoder)object3).decode((String)StringsKt.split$default((CharSequence)((CharSequence)object), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(1));
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getDecoder().decode(pack\u2026toString().split(\".\")[1])");
                object3 = JsonParser.parseString(new String((byte[])object, Charsets.UTF_8)).getAsJsonObject();
                ((JsonObject)object3).addProperty("DeviceModel", "Nintendo Switch OLED");
                object = 12;
                ((JsonObject)object3).addProperty("DeviceOS", (Number)object);
                object2 = InputMode.values();
                int n3 = ((InputMode[])object2).length;
                n2 = 0;
                for (n = 0; n < n3; ++n) {
                    object = object2[n];
                    if (!Intrinsics.areEqual((Object)((Enum)object).name(), (Object)"TOUCH")) {
                        continue;
                    }
                    break block7;
                }
                object = null;
            }
            n = n2;
            if (object != null) {
                n = ((Enum)object).ordinal();
            }
            object = n;
            ((JsonObject)object3).addProperty("CurrentInputMode", (Number)object);
            bedrockPacket = (LoginPacket)bedrockPacket;
            object2 = new StringBuilder().append('.');
            object = Base64.getEncoder();
            object3 = new Gson().toJson((JsonElement)object3);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"Gson().toJson(body)");
            object3 = ((String)object3).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"this as java.lang.String).getBytes(charset)");
            ((LoginPacket)bedrockPacket).setSkinData(new AsciiString(((StringBuilder)object2).append(((Base64.Encoder)object).encodeToString((byte[])object3)).append('.').toString()));
        } else if (bedrockPacket instanceof PlayerAuthInputPacket) {
            ((PlayerAuthInputPacket)bedrockPacket).setInputMode(InputMode.TOUCH);
            if (((PlayerAuthInputPacket)bedrockPacket).getInputInteractionModel() == InputInteractionModel.CROSSHAIR) {
                ((PlayerAuthInputPacket)bedrockPacket).setInputInteractionModel(InputInteractionModel.TOUCH);
            }
        }
    }
}

