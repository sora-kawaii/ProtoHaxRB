/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay;

import com.nukkitx.network.raknet.RakNetServerSession;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.RakNetRelaySessionListener;
import io.netty.bootstrap.Bootstrap;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/RakNetRelayListener;", "", "getBootstrap", "Lio/netty/bootstrap/Bootstrap;", "onPrepareClientConnection", "Ldev/sora/relay/RakNetRelaySessionListener;", "clientSocket", "Ljava/nio/channels/DatagramChannel;", "onQuery", "", "address", "Ljava/net/InetSocketAddress;", "onSession", "", "session", "Ldev/sora/relay/RakNetRelaySession;", "onSessionCreation", "serverSession", "Lcom/nukkitx/network/raknet/RakNetServerSession;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public interface RakNetRelayListener {
    public Bootstrap getBootstrap();

    public RakNetRelaySessionListener onPrepareClientConnection(DatagramChannel var1);

    public byte[] onQuery(InetSocketAddress var1);

    public void onSession(RakNetRelaySession var1);

    public InetSocketAddress onSessionCreation(RakNetServerSession var1);

    @Metadata(k=3, mv={1, 7, 1}, xi=48)
    public static final class DefaultImpls {
        public static Bootstrap getBootstrap(RakNetRelayListener rakNetRelayListener) {
            return null;
        }

        public static RakNetRelaySessionListener onPrepareClientConnection(RakNetRelayListener rakNetRelayListener, DatagramChannel datagramChannel) {
            Intrinsics.checkNotNullParameter((Object)datagramChannel, (String)"clientSocket");
            return new RakNetRelaySessionListener();
        }

        public static void onSession(RakNetRelayListener rakNetRelayListener, RakNetRelaySession rakNetRelaySession) {
            Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"session");
        }
    }
}

