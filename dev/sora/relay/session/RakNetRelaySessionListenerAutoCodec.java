/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package dev.sora.relay.session;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.compat.BedrockCompat;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.RequestNetworkSettingsPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.RakNetRelaySessionListener;
import dev.sora.relay.utils.LoggerKt;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerAutoCodec;", "Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "session", "Ldev/sora/relay/RakNetRelaySession;", "(Ldev/sora/relay/RakNetRelaySession;)V", "onPacketInbound", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "Companion", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RakNetRelaySessionListenerAutoCodec
implements RakNetRelaySessionListener.PacketListener {
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, BedrockPacketCodec> protocols;
    private final RakNetRelaySession session;

    static {
        Object object = new Integer[27];
        object[0] = 291;
        object[1] = 313;
        object[2] = 332;
        object[3] = 340;
        object[4] = 354;
        object[5] = 361;
        object[6] = 388;
        object[7] = 389;
        object[8] = 390;
        object[9] = 407;
        object[10] = 408;
        object[11] = 419;
        object[12] = 422;
        object[13] = 428;
        object[14] = 431;
        object[15] = 440;
        object[16] = 448;
        object[17] = 465;
        object[18] = 471;
        object[19] = 475;
        object[20] = 486;
        object[21] = 503;
        object[22] = 527;
        object[23] = 534;
        object[24] = 544;
        object[25] = 557;
        object[26] = 560;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)((Integer[])object).length), (int)16));
        int n = ((Integer[])object).length;
        for (int i = 0; i < n; ++i) {
            Integer n2 = object[i];
            Map map = linkedHashMap;
            int n3 = ((Number)n2).intValue();
            map.put(n2, RakNetRelaySessionListenerAutoCodec.Companion.getProtocolCodec(n3));
        }
        protocols = object = (Map)linkedHashMap;
    }

    public RakNetRelaySessionListenerAutoCodec(RakNetRelaySession rakNetRelaySession) {
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"session");
        this.session = rakNetRelaySession;
    }

    @Override
    public boolean onPacketInbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        return true;
    }

    @Override
    public boolean onPacketOutbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        boolean bl = bedrockPacket instanceof RequestNetworkSettingsPacket;
        String string = ", mc=";
        String string2 = ", protocol=";
        String string3 = "selected codec (clientProtocol=";
        if (bl) {
            this.session.setPacketCodec(RakNetRelaySessionListenerAutoCodec.Companion.pickProtocolCodec(((RequestNetworkSettingsPacket)bedrockPacket).getProtocolVersion()));
            LoggerKt.logInfo(string3 + ((RequestNetworkSettingsPacket)bedrockPacket).getProtocolVersion() + string2 + this.session.getPacketCodec().getProtocolVersion() + string + this.session.getPacketCodec().getMinecraftVersion() + ')');
        } else if (bedrockPacket instanceof LoginPacket) {
            this.session.setPacketCodec(RakNetRelaySessionListenerAutoCodec.Companion.pickProtocolCodec(((LoginPacket)bedrockPacket).getProtocolVersion()));
            LoggerKt.logInfo(string3 + ((LoginPacket)bedrockPacket).getProtocolVersion() + string2 + this.session.getPacketCodec().getProtocolVersion() + string + this.session.getPacketCodec().getMinecraftVersion() + ')');
        }
        return true;
    }

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerAutoCodec$Companion;", "", "()V", "protocols", "", "", "Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;", "getProtocolCodec", "version", "pickProtocolCodec", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final BedrockPacketCodec getProtocolCodec(int n) {
            Object[] objectArray = Class.forName("com.nukkitx.protocol.bedrock.v" + n + ".Bedrock_v" + n).getFields();
            Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"klass.fields");
            objectArray = objectArray;
            int n2 = objectArray.length;
            for (n = 0; n < n2; ++n) {
                Object object = (Field)objectArray[n];
                if (!Modifier.isStatic(((Field)object).getModifiers()) || !Modifier.isPublic(((Field)object).getModifiers()) || !((object = ((Field)object).get(null)) instanceof BedrockPacketCodec)) continue;
                return (BedrockPacketCodec)object;
            }
            throw new IllegalStateException("no codec found");
        }

        private final BedrockPacketCodec pickProtocolCodec(int n) {
            BedrockPacketCodec object = BedrockCompat.COMPAT_CODEC;
            for (Map.Entry entry : protocols.entrySet()) {
                int n2 = ((Number)entry.getKey()).intValue();
                BedrockPacketCodec object2 = (BedrockPacketCodec)entry.getValue();
                if (n2 > n) break;
                object = object2;
            }
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"codecResult");
            return object;
        }
    }
}

