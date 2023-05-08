/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay;

import com.nukkitx.network.raknet.RakNet;
import com.nukkitx.network.raknet.RakNetClient;
import com.nukkitx.network.raknet.RakNetClientSession;
import com.nukkitx.network.raknet.RakNetServer;
import com.nukkitx.network.raknet.RakNetServerListener;
import com.nukkitx.network.raknet.RakNetServerSession;
import com.nukkitx.network.raknet.RakNetSession;
import com.nukkitx.network.util.EventLoops;
import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.compat.BedrockCompat;
import dev.sora.relay.RakNetRelay$$ExternalSyntheticLambda0;
import dev.sora.relay.RakNetRelayListener;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.RakNetRelaySessionListener;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2={"Ldev/sora/relay/RakNetRelay;", "", "listen", "Ljava/net/InetSocketAddress;", "eventLoopGroup", "Lio/netty/channel/EventLoopGroup;", "packetCodec", "Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;", "(Ljava/net/InetSocketAddress;Lio/netty/channel/EventLoopGroup;Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;)V", "getEventLoopGroup", "()Lio/netty/channel/EventLoopGroup;", "listener", "Ldev/sora/relay/RakNetRelayListener;", "getListener", "()Ldev/sora/relay/RakNetRelayListener;", "setListener", "(Ldev/sora/relay/RakNetRelayListener;)V", "getPacketCodec", "()Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;", "server", "Lcom/nukkitx/network/raknet/RakNetServer;", "getServer", "()Lcom/nukkitx/network/raknet/RakNetServer;", "bind", "", "onSession", "serverSession", "Lcom/nukkitx/network/raknet/RakNetServerSession;", "RakNetRelayServerListener", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RakNetRelay {
    private final EventLoopGroup eventLoopGroup;
    private RakNetRelayListener listener;
    private final BedrockPacketCodec packetCodec;
    private final RakNetServer server;

    public static /* synthetic */ Channel $r8$lambda$3gLRCtF7_GCur0Tg-CW3ESRPfD8(DatagramChannel datagramChannel) {
        return RakNetRelay.onSession$lambda$2$lambda$1(datagramChannel);
    }

    public RakNetRelay(InetSocketAddress object, EventLoopGroup eventLoopGroup, BedrockPacketCodec bedrockPacketCodec) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"listen");
        Intrinsics.checkNotNullParameter((Object)eventLoopGroup, (String)"eventLoopGroup");
        Intrinsics.checkNotNullParameter((Object)bedrockPacketCodec, (String)"packetCodec");
        this.eventLoopGroup = eventLoopGroup;
        this.packetCodec = bedrockPacketCodec;
        object = new RakNetServer((InetSocketAddress)object, eventLoopGroup);
        ((RakNetServer)object).setListener(new RakNetRelayServerListener());
        this.server = object;
    }

    public /* synthetic */ RakNetRelay(InetSocketAddress inetSocketAddress, EventLoopGroup eventLoopGroup, BedrockPacketCodec bedrockPacketCodec, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            eventLoopGroup = EventLoops.commonGroup();
            Intrinsics.checkNotNullExpressionValue((Object)eventLoopGroup, (String)"commonGroup()");
        }
        if ((n & 4) != 0) {
            bedrockPacketCodec = BedrockCompat.COMPAT_CODEC;
            Intrinsics.checkNotNullExpressionValue((Object)bedrockPacketCodec, (String)"COMPAT_CODEC");
        }
        this(inetSocketAddress, eventLoopGroup, bedrockPacketCodec);
    }

    private final void onSession(RakNetServerSession object) {
        Object object2;
        InetSocketAddress inetSocketAddress;
        Object object3;
        Object object4;
        block15: {
            DatagramChannel datagramChannel;
            block14: {
                block13: {
                    block12: {
                        block11: {
                            block10: {
                                object4 = this.listener;
                                if (object4 == null) break block10;
                                object4 = object3 = object4.onSessionCreation((RakNetServerSession)object);
                                if (object3 != null) break block11;
                            }
                            object4 = new InetSocketAddress("127.0.0.1", 19132);
                        }
                        datagramChannel = DatagramChannel.open();
                        int n = datagramChannel.socket().getLocalPort();
                        inetSocketAddress = new InetSocketAddress("0.0.0.0", n);
                        object3 = this.listener;
                        if (object3 == null) break block12;
                        Intrinsics.checkNotNullExpressionValue((Object)datagramChannel, (String)"clientSocket");
                        object3 = object2 = object3.onPrepareClientConnection(datagramChannel);
                        if (object2 != null) break block13;
                    }
                    object3 = new RakNetRelaySessionListener();
                }
                if ((object2 = this.listener) == null) break block14;
                Bootstrap bootstrap = object2.getBootstrap();
                object2 = bootstrap;
                if (bootstrap != null) break block15;
            }
            object2 = new Bootstrap();
            ((AbstractBootstrap)object2).group(this.eventLoopGroup);
            ((AbstractBootstrap)object2).channelFactory(new RakNetRelay$$ExternalSyntheticLambda0(datagramChannel));
        }
        object2 = new RakNetClient(inetSocketAddress, (Bootstrap)object2, null);
        ((RakNet)object2).setProtocolVersion(((RakNetSession)object).getProtocolVersion());
        ((RakNet)object2).bind().join();
        object4 = ((RakNetClient)object2).connect((InetSocketAddress)object4);
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"clientSession");
        object2 = this.eventLoopGroup.next();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"eventLoopGroup.next()");
        object4 = new RakNetRelaySession((RakNetServerSession)object, (RakNetClientSession)object4, (EventLoop)object2, this.packetCodec, (RakNetRelaySessionListener)object3);
        object = this.listener;
        if (object != null) {
            object.onSession((RakNetRelaySession)object4);
        }
    }

    private static final Channel onSession$lambda$2$lambda$1(DatagramChannel datagramChannel) {
        return new NioDatagramChannel(datagramChannel);
    }

    public final void bind() {
        this.server.bind().join();
    }

    public final EventLoopGroup getEventLoopGroup() {
        return this.eventLoopGroup;
    }

    public final RakNetRelayListener getListener() {
        return this.listener;
    }

    public final BedrockPacketCodec getPacketCodec() {
        return this.packetCodec;
    }

    public final RakNetServer getServer() {
        return this.server;
    }

    public final void setListener(RakNetRelayListener rakNetRelayListener) {
        this.listener = rakNetRelayListener;
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/RakNetRelay$RakNetRelayServerListener;", "Lcom/nukkitx/network/raknet/RakNetServerListener;", "(Ldev/sora/relay/RakNetRelay;)V", "onConnectionRequest", "", "address", "Ljava/net/InetSocketAddress;", "realAddress", "onQuery", "", "onSessionCreation", "", "session", "Lcom/nukkitx/network/raknet/RakNetServerSession;", "onUnhandledDatagram", "ctx", "Lio/netty/channel/ChannelHandlerContext;", "packet", "Lio/netty/channel/socket/DatagramPacket;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public final class RakNetRelayServerListener
    implements RakNetServerListener {
        @Override
        public boolean onConnectionRequest(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"address");
            Intrinsics.checkNotNullParameter((Object)inetSocketAddress2, (String)"realAddress");
            return true;
        }

        @Override
        public byte[] onQuery(InetSocketAddress object) {
            block3: {
                block2: {
                    Intrinsics.checkNotNullParameter((Object)object, (String)"address");
                    Object object2 = RakNetRelay.this.getListener();
                    if (object2 == null) break block2;
                    object = object2 = (Object)object2.onQuery((InetSocketAddress)object);
                    if (object2 != null) break block3;
                }
                object = new byte[0];
            }
            return object;
        }

        @Override
        public void onSessionCreation(RakNetServerSession rakNetServerSession) {
            Intrinsics.checkNotNullParameter((Object)rakNetServerSession, (String)"session");
            RakNetRelay.this.onSession(rakNetServerSession);
        }

        @Override
        public void onUnhandledDatagram(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {
            Intrinsics.checkNotNullParameter((Object)channelHandlerContext, (String)"ctx");
            Intrinsics.checkNotNullParameter((Object)datagramPacket, (String)"packet");
        }
    }
}

