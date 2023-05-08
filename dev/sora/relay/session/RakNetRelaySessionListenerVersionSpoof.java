/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.session;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.RequestNetworkSettingsPacket;
import dev.sora.relay.RakNetRelaySessionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerVersionSpoof;", "Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "protocolVersion", "", "(I)V", "getProtocolVersion", "()I", "onPacketInbound", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RakNetRelaySessionListenerVersionSpoof
implements RakNetRelaySessionListener.PacketListener {
    private final int protocolVersion;

    public RakNetRelaySessionListenerVersionSpoof(int n) {
        this.protocolVersion = n;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public boolean onPacketInbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        return true;
    }

    @Override
    public boolean onPacketOutbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        if (bedrockPacket instanceof RequestNetworkSettingsPacket) {
            ((RequestNetworkSettingsPacket)bedrockPacket).setProtocolVersion(this.protocolVersion);
        } else if (bedrockPacket instanceof LoginPacket) {
            ((LoginPacket)bedrockPacket).setProtocolVersion(this.protocolVersion);
        }
        return true;
    }
}

