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
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.utils.StringUtilsKt;
import io.netty.util.AsciiString;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/other/LoginIDSpoof;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class LoginIDSpoof
extends CheatModule {
    public LoginIDSpoof() {
        super("LoginIDSpoof", false, false, 6, null);
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = ((EventPacketOutbound)object).getPacket();
        if (object2 instanceof LoginPacket) {
            Object object3 = Base64.getDecoder();
            object = ((LoginPacket)object2).getSkinData().toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.skinData.toString()");
            object = ((Base64.Decoder)object3).decode((String)StringsKt.split$default((CharSequence)((CharSequence)object), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(1));
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getDecoder().decode(pack\u2026toString().split(\".\")[1])");
            object = JsonParser.parseString(new String((byte[])object, Charsets.UTF_8)).getAsJsonObject();
            object3 = Random.Default.nextLong();
            ((JsonObject)object).addProperty("ClientRandomId", (Number)object3);
            object3 = StringUtilsKt.toHexString$default(Random.Default.nextBytes(new byte[16]), null, 1, null);
            ((JsonObject)object).addProperty("DeviceId", (String)object3);
            LoginPacket loginPacket = (LoginPacket)object2;
            object2 = new StringBuilder().append('.');
            object3 = Base64.getEncoder();
            object = new Gson().toJson((JsonElement)object);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Gson().toJson(body)");
            object = ((String)object).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).getBytes(charset)");
            loginPacket.setSkinData(new AsciiString(((StringBuilder)object2).append(((Base64.Encoder)object3).encodeToString((byte[])object)).append('.').toString()));
        }
    }
}

