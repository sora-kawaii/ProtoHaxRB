/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay;

import com.nukkitx.network.raknet.RakNetSession;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.PacketCompressionAlgorithm;
import com.nukkitx.protocol.bedrock.packet.NetworkSettingsPacket;
import com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializer;
import com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializerV11;
import com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializers;
import com.nukkitx.protocol.bedrock.wrapper.compression.CompressionSerializer;
import com.nukkitx.protocol.bedrock.wrapper.compression.NoCompression;
import com.nukkitx.protocol.bedrock.wrapper.compression.SnappyCompression;
import com.nukkitx.protocol.bedrock.wrapper.compression.ZlibCompression;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.utils.LoggerKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0015H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2={"Ldev/sora/relay/RakNetRelaySessionListener;", "", "()V", "childListener", "", "Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "getChildListener", "()Ljava/util/List;", "session", "Ldev/sora/relay/RakNetRelaySession;", "getSession", "()Ldev/sora/relay/RakNetRelaySession;", "setSession", "(Ldev/sora/relay/RakNetRelaySession;)V", "onPacketInbound", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "provideSerializer", "Lcom/nukkitx/protocol/bedrock/wrapper/BedrockWrapperSerializer;", "Lcom/nukkitx/network/raknet/RakNetSession;", "PacketListener", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class RakNetRelaySessionListener {
    private final List<PacketListener> childListener = new ArrayList();
    public RakNetRelaySession session;

    public final List<PacketListener> getChildListener() {
        return this.childListener;
    }

    public final RakNetRelaySession getSession() {
        RakNetRelaySession rakNetRelaySession = this.session;
        if (rakNetRelaySession != null) {
            return rakNetRelaySession;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"session");
        return null;
    }

    public boolean onPacketInbound(BedrockPacket bedrockPacket) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        if (bedrockPacket instanceof NetworkSettingsPacket) {
            BedrockWrapperSerializer bedrockWrapperSerializer;
            Object object = ((NetworkSettingsPacket)bedrockPacket).getCompressionAlgorithm();
            int n = object == null ? -1 : WhenMappings.$EnumSwitchMapping$0[object.ordinal()];
            switch (n) {
                default: {
                    object = NoCompression.INSTANCE;
                    break;
                }
                case 2: {
                    object = SnappyCompression.INSTANCE;
                    break;
                }
                case 1: {
                    object = ZlibCompression.INSTANCE;
                }
            }
            bl = this.getSession().getClientSerializer() instanceof BedrockWrapperSerializerV11;
            Object object2 = "null cannot be cast to non-null type com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializerV11";
            if (bl) {
                bedrockWrapperSerializer = this.getSession().getClientSerializer();
                Intrinsics.checkNotNull((Object)bedrockWrapperSerializer, (String)object2);
                ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).setCompressionSerializer((CompressionSerializer)object);
            }
            if (this.getSession().getServerSerializer() instanceof BedrockWrapperSerializerV11) {
                bedrockWrapperSerializer = this.getSession().getServerSerializer();
                Intrinsics.checkNotNull((Object)bedrockWrapperSerializer, (String)object2);
                ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).setCompressionSerializer((CompressionSerializer)object);
            }
        }
        for (Object object2 : (Iterable)this.childListener) {
            try {
                bl = object2.onPacketInbound(bedrockPacket);
                if (bl) continue;
                return false;
            }
            catch (Throwable throwable) {
                LoggerKt.logError("packet inbound", throwable);
            }
        }
        return true;
    }

    public boolean onPacketOutbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        for (PacketListener packetListener : (Iterable)this.childListener) {
            try {
                boolean bl = packetListener.onPacketOutbound(bedrockPacket);
                if (bl) continue;
                return false;
            }
            catch (Throwable throwable) {
                LoggerKt.logError("packet outbound", throwable);
            }
        }
        return true;
    }

    public BedrockWrapperSerializer provideSerializer(RakNetSession object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"session");
        object = BedrockWrapperSerializers.getSerializer(((RakNetSession)object).getProtocolVersion());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSerializer(session.protocolVersion)");
        return object;
    }

    public final void setSession(RakNetRelaySession rakNetRelaySession) {
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"<set-?>");
        this.session = rakNetRelaySession;
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "", "onPacketInbound", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static interface PacketListener {
        public boolean onPacketInbound(BedrockPacket var1);

        public boolean onPacketOutbound(BedrockPacket var1);
    }

    @Metadata(k=3, mv={1, 7, 1}, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PacketCompressionAlgorithm.values().length];
            try {
                nArray[PacketCompressionAlgorithm.ZLIB.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PacketCompressionAlgorithm.SNAPPY.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

