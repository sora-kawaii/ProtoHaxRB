/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay;

import com.nukkitx.natives.sha256.Sha256;
import com.nukkitx.natives.util.Natives;
import com.nukkitx.network.raknet.EncapsulatedPacket;
import com.nukkitx.network.raknet.RakNetClientSession;
import com.nukkitx.network.raknet.RakNetServerSession;
import com.nukkitx.network.raknet.RakNetSessionListener;
import com.nukkitx.network.raknet.RakNetState;
import com.nukkitx.network.util.DisconnectReason;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.DummyBedrockSession;
import com.nukkitx.protocol.bedrock.annotation.Incompressible;
import com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializer;
import com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializerV11;
import com.nukkitx.protocol.bedrock.wrapper.compression.CompressionSerializer;
import com.nukkitx.protocol.bedrock.wrapper.compression.NoCompression;
import dev.sora.relay.RakNetRelaySession$$ExternalSyntheticLambda0;
import dev.sora.relay.RakNetRelaySessionListener;
import dev.sora.relay.utils.CipherPair;
import dev.sora.relay.utils.LoggerKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.EventLoop;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0003BCDB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0010H\u0002J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u0002032\u0006\u00104\u001a\u00020&J\u000e\u00106\u001a\u0002032\u0006\u00104\u001a\u00020/J\u000e\u00107\u001a\u0002032\u0006\u00104\u001a\u00020&J\u000e\u00107\u001a\u0002032\u0006\u00104\u001a\u00020/J\u001e\u00108\u001a\b\u0012\u0004\u0012\u000205092\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010=\u001a\u0002032\u0006\u00104\u001a\u000205J\u0018\u0010>\u001a\u0002032\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<H\u0002J\u0018\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020&2\u0006\u0010;\u001a\u00020<H\u0002J\u0018\u0010A\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010;\u001a\u00020<H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u0011\u0010*\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u00a8\u0006E"}, d2={"Ldev/sora/relay/RakNetRelaySession;", "", "clientsideSession", "Lcom/nukkitx/network/raknet/RakNetServerSession;", "serversideSession", "Lcom/nukkitx/network/raknet/RakNetClientSession;", "eventLoop", "Lio/netty/channel/EventLoop;", "packetCodec", "Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;", "listener", "Ldev/sora/relay/RakNetRelaySessionListener;", "(Lcom/nukkitx/network/raknet/RakNetServerSession;Lcom/nukkitx/network/raknet/RakNetClientSession;Lio/netty/channel/EventLoop;Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;Ldev/sora/relay/RakNetRelaySessionListener;)V", "bedrockSession", "Lcom/nukkitx/protocol/bedrock/DummyBedrockSession;", "clientCipher", "Ldev/sora/relay/utils/CipherPair;", "getClientCipher", "()Ldev/sora/relay/utils/CipherPair;", "setClientCipher", "(Ldev/sora/relay/utils/CipherPair;)V", "clientSerializer", "Lcom/nukkitx/protocol/bedrock/wrapper/BedrockWrapperSerializer;", "getClientSerializer", "()Lcom/nukkitx/protocol/bedrock/wrapper/BedrockWrapperSerializer;", "getClientsideSession", "()Lcom/nukkitx/network/raknet/RakNetServerSession;", "getListener", "()Ldev/sora/relay/RakNetRelaySessionListener;", "log", "Lio/netty/util/internal/logging/InternalLogger;", "kotlin.jvm.PlatformType", "getPacketCodec", "()Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;", "setPacketCodec", "(Lcom/nukkitx/protocol/bedrock/BedrockPacketCodec;)V", "pendingPackets", "", "Lio/netty/buffer/ByteBuf;", "serverCipher", "getServerCipher", "setServerCipher", "serverSerializer", "getServerSerializer", "getServersideSession", "()Lcom/nukkitx/network/raknet/RakNetClientSession;", "generateTrailer", "", "buf", "cipherPair", "inboundPacket", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "injectInbound", "injectOutbound", "onWrappedPacket", "", "buffer", "isClientside", "", "outboundPacket", "readPacketFromBuffer", "sendSerialized", "compressed", "sendWrapped", "Companion", "RakNetRelayClientListener", "RakNetRelayServerListener", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RakNetRelaySession {
    public static final Companion Companion = new Companion(null);
    private final DummyBedrockSession bedrockSession;
    private CipherPair clientCipher;
    private final BedrockWrapperSerializer clientSerializer;
    private final RakNetServerSession clientsideSession;
    private final EventLoop eventLoop;
    private final RakNetRelaySessionListener listener;
    private final InternalLogger log;
    private BedrockPacketCodec packetCodec;
    private final List<ByteBuf> pendingPackets;
    private CipherPair serverCipher;
    private final BedrockWrapperSerializer serverSerializer;
    private final RakNetClientSession serversideSession;

    public static /* synthetic */ void $r8$lambda$iurh4obAlKZNWXHn3oVy37vYztc(RakNetRelaySession rakNetRelaySession, ByteBuf byteBuf, boolean bl) {
        RakNetRelaySession.readPacketFromBuffer$lambda$1(rakNetRelaySession, byteBuf, bl);
    }

    public RakNetRelaySession(RakNetServerSession rakNetServerSession, RakNetClientSession rakNetClientSession, EventLoop eventLoop, BedrockPacketCodec bedrockPacketCodec, RakNetRelaySessionListener rakNetRelaySessionListener) {
        Intrinsics.checkNotNullParameter((Object)rakNetServerSession, (String)"clientsideSession");
        Intrinsics.checkNotNullParameter((Object)rakNetClientSession, (String)"serversideSession");
        Intrinsics.checkNotNullParameter((Object)eventLoop, (String)"eventLoop");
        Intrinsics.checkNotNullParameter((Object)bedrockPacketCodec, (String)"packetCodec");
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySessionListener, (String)"listener");
        this.clientsideSession = rakNetServerSession;
        this.serversideSession = rakNetClientSession;
        this.eventLoop = eventLoop;
        this.packetCodec = bedrockPacketCodec;
        this.listener = rakNetRelaySessionListener;
        this.clientSerializer = rakNetRelaySessionListener.provideSerializer(rakNetServerSession);
        this.serverSerializer = rakNetRelaySessionListener.provideSerializer(rakNetClientSession);
        this.bedrockSession = new DummyBedrockSession(eventLoop);
        this.pendingPackets = new ArrayList();
        this.log = InternalLoggerFactory.getInstance(RakNetRelaySession.class);
        rakNetRelaySessionListener.setSession(this);
        rakNetClientSession.setListener(new RakNetRelayServerListener());
        rakNetServerSession.setListener(new RakNetRelayClientListener());
    }

    private final byte[] generateTrailer(ByteBuf object, CipherPair object2) {
        Sha256 sha256 = Natives.SHA_256.get();
        Intrinsics.checkNotNullExpressionValue((Object)sha256, (String)"SHA_256.get()");
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(8);
        try {
            byteBuf.writeLongLE(((CipherPair)object2).getSentEncryptedPacketCount().getAndIncrement());
            object2 = ByteBuffer.wrap(((CipherPair)object2).getSecretKey().getEncoded());
            sha256.update(byteBuf.internalNioBuffer(0, 8));
            sha256.update(((ByteBuf)object).internalNioBuffer(((ByteBuf)object).readerIndex(), ((ByteBuf)object).readableBytes()));
            sha256.update((ByteBuffer)object2);
            object = Arrays.copyOf(sha256.digest(), 8);
            return object;
        }
        finally {
            byteBuf.release();
            sha256.reset();
        }
    }

    private final List<BedrockPacket> onWrappedPacket(ByteBuf byteBuf, boolean bl) {
        Object object;
        Object object2 = bl ? this.clientCipher : this.serverCipher;
        if (object2 != null) {
            object = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"buffer.internalNioBuffer\u2026, buffer.readableBytes())");
            ByteBuffer byteBuffer = ((ByteBuffer)object).duplicate();
            ((CipherPair)object2).getDecryptionCipher().update((ByteBuffer)object, byteBuffer);
            byteBuf.writerIndex(byteBuf.writerIndex() - 8);
        }
        byteBuf.markReaderIndex();
        if (byteBuf.isReadable()) {
            object = new ArrayList();
            object2 = bl ? this.clientSerializer : this.serverSerializer;
            this.packetCodec.hasDecodeFailure = false;
            ((BedrockWrapperSerializer)object2).deserialize(byteBuf.duplicate(), this.packetCodec, (Collection)object, this.bedrockSession);
            if (this.packetCodec.hasDecodeFailure) {
                this.sendSerialized(byteBuf, bl ^ true);
                this.log.warn("skipping packets because of failure whilst decode");
                return CollectionsKt.emptyList();
            }
            return object;
        }
        return CollectionsKt.emptyList();
    }

    private final void readPacketFromBuffer(ByteBuf byteBuf, boolean bl) {
        if (byteBuf.readUnsignedByte() == 254 && byteBuf.isReadable()) {
            if (this.eventLoop.inEventLoop()) {
                this.onWrappedPacket(byteBuf, bl);
            } else {
                byteBuf.retain();
                this.eventLoop.execute(new RakNetRelaySession$$ExternalSyntheticLambda0(this, byteBuf, bl));
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static final void readPacketFromBuffer$lambda$1(RakNetRelaySession var0, ByteBuf var1_2, boolean var2_4) {
        Intrinsics.checkNotNullParameter((Object)var0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)var1_2, (String)"$buffer");
        var3_5 = var0.onWrappedPacket(var1_2, var2_4);
        for (Object var3_5 : (Iterable)var3_5) {
            block7: {
                if (!var2_4) ** GOTO lbl10
                try {
                    var5_7 = var0.listener.onPacketOutbound((BedrockPacket)var3_5);
                    break block7;
lbl10:
                    // 1 sources

                    var5_7 = var0.listener.onPacketInbound((BedrockPacket)var3_5);
                }
                catch (Throwable var1_3) {
                    LoggerKt.logError("handling packets", var1_3);
                    var5_7 = true;
                }
            }
            if (!var5_7) continue;
            if (var2_4) {
                var0.outboundPacket((BedrockPacket)var3_5);
                continue;
            }
            var0.inboundPacket((BedrockPacket)var3_5);
        }
        return;
        finally {
            var1_2.release();
        }
    }

    private final void sendSerialized(ByteBuf object, boolean bl) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer(((ByteBuf)object).readableBytes() + 1 + 8);
        byteBuf.writeByte(254);
        CipherPair cipherPair = bl ? this.clientCipher : this.serverCipher;
        if (cipherPair != null) {
            ByteBuffer byteBuffer = ByteBuffer.wrap(this.generateTrailer((ByteBuf)object, cipherPair));
            ByteBuffer byteBuffer2 = byteBuf.internalNioBuffer(1, ((ByteBuf)object).readableBytes() + 8);
            ByteBuffer byteBuffer3 = ((ByteBuf)object).internalNioBuffer(((ByteBuf)object).readerIndex(), ((ByteBuf)object).readableBytes());
            cipherPair.getEncryptionCipher().update(byteBuffer3, byteBuffer2);
            cipherPair.getEncryptionCipher().update(byteBuffer, byteBuffer2);
            byteBuf.writerIndex(byteBuf.writerIndex() + ((ByteBuf)object).readableBytes() + 8);
        } else {
            byteBuf.writeBytes((ByteBuf)object);
        }
        if (bl) {
            this.clientsideSession.send(byteBuf);
        } else if (this.serversideSession.getState() != RakNetState.CONNECTED && this.serversideSession.getState() != RakNetState.UNCONNECTED) {
            object = this.pendingPackets;
            Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"finalPayload");
            object.add(byteBuf);
        } else {
            this.serversideSession.send(byteBuf);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void sendWrapped(BedrockPacket bedrockPacket, boolean bl) {
        Throwable throwable2222222;
        CompressionSerializer compressionSerializer;
        ByteBuf byteBuf;
        BedrockWrapperSerializer bedrockWrapperSerializer;
        String string;
        block11: {
            block13: {
                block14: {
                    string = "null cannot be cast to non-null type com.nukkitx.protocol.bedrock.wrapper.BedrockWrapperSerializerV11";
                    bedrockWrapperSerializer = bl ? this.clientSerializer : this.serverSerializer;
                    byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
                    if (bedrockPacket.getClass().isAnnotationPresent(Incompressible.class) && bedrockWrapperSerializer instanceof BedrockWrapperSerializerV11) {
                        compressionSerializer = ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).getCompressionSerializer();
                        ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).setCompressionSerializer(NoCompression.INSTANCE);
                    } else {
                        compressionSerializer = null;
                    }
                    bedrockWrapperSerializer.serialize(byteBuf, this.packetCodec, CollectionsKt.listOf((Object)bedrockPacket), -1, this.bedrockSession);
                    Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"compressed");
                    this.sendSerialized(byteBuf, bl);
                    {
                        block12: {
                            catch (Throwable throwable2222222) {
                                break block11;
                            }
                            catch (Exception exception) {}
                            {
                                LoggerKt.logError("serialize packet", exception);
                                if (byteBuf == null) break block12;
                            }
                            byteBuf.release();
                        }
                        if (compressionSerializer == null) break block13;
                        break block14;
                    }
                    byteBuf.release();
                    if (compressionSerializer == null) break block13;
                }
                Intrinsics.checkNotNull((Object)bedrockWrapperSerializer, (String)string);
                ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).setCompressionSerializer(compressionSerializer);
            }
            return;
        }
        if (byteBuf != null) {
            byteBuf.release();
        }
        if (compressionSerializer != null) {
            Intrinsics.checkNotNull((Object)bedrockWrapperSerializer, (String)string);
            ((BedrockWrapperSerializerV11)bedrockWrapperSerializer).setCompressionSerializer(compressionSerializer);
        }
        throw throwable2222222;
    }

    public final CipherPair getClientCipher() {
        return this.clientCipher;
    }

    public final BedrockWrapperSerializer getClientSerializer() {
        return this.clientSerializer;
    }

    public final RakNetServerSession getClientsideSession() {
        return this.clientsideSession;
    }

    public final RakNetRelaySessionListener getListener() {
        return this.listener;
    }

    public final BedrockPacketCodec getPacketCodec() {
        return this.packetCodec;
    }

    public final CipherPair getServerCipher() {
        return this.serverCipher;
    }

    public final BedrockWrapperSerializer getServerSerializer() {
        return this.serverSerializer;
    }

    public final RakNetClientSession getServersideSession() {
        return this.serversideSession;
    }

    public final void inboundPacket(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        this.sendWrapped(bedrockPacket, true);
    }

    public final void injectInbound(ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"packet");
        this.clientsideSession.send(byteBuf);
    }

    public final void injectInbound(byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        object = Unpooled.copiedBuffer(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"copiedBuffer(packet)");
        this.injectInbound((ByteBuf)object);
    }

    public final void injectOutbound(ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"packet");
        this.serversideSession.send(byteBuf);
    }

    public final void injectOutbound(byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        object = Unpooled.copiedBuffer(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"copiedBuffer(packet)");
        this.injectOutbound((ByteBuf)object);
    }

    public final void outboundPacket(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        this.sendWrapped(bedrockPacket, false);
    }

    public final void setClientCipher(CipherPair cipherPair) {
        this.clientCipher = cipherPair;
    }

    public final void setPacketCodec(BedrockPacketCodec bedrockPacketCodec) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacketCodec, (String)"<set-?>");
        this.packetCodec = bedrockPacketCodec;
    }

    public final void setServerCipher(CipherPair cipherPair) {
        this.serverCipher = cipherPair;
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/RakNetRelaySession$Companion;", "", "()V", "readBuf", "", "buf", "Lio/netty/buffer/ByteBuf;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final byte[] readBuf(ByteBuf byteBuf) {
            byte[] byArray = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(byteBuf.readerIndex(), byArray);
            return byArray;
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/RakNetRelaySession$RakNetRelayClientListener;", "Lcom/nukkitx/network/raknet/RakNetSessionListener;", "(Ldev/sora/relay/RakNetRelaySession;)V", "onDirect", "", "buf", "Lio/netty/buffer/ByteBuf;", "onDisconnect", "reason", "Lcom/nukkitx/network/util/DisconnectReason;", "onEncapsulated", "packet", "Lcom/nukkitx/network/raknet/EncapsulatedPacket;", "onSessionChangeState", "state", "Lcom/nukkitx/network/raknet/RakNetState;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public final class RakNetRelayClientListener
    implements RakNetSessionListener {
        @Override
        public void onDirect(ByteBuf byteBuf) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"buf");
        }

        @Override
        public void onDisconnect(DisconnectReason disconnectReason) {
            Intrinsics.checkNotNullParameter((Object)((Object)disconnectReason), (String)"reason");
            RakNetRelaySession.this.getServersideSession().closeNoPacket();
            LoggerKt.logInfo("client disconnect: " + (Object)((Object)disconnectReason));
        }

        @Override
        public void onEncapsulated(EncapsulatedPacket referenceCounted) {
            Intrinsics.checkNotNullParameter((Object)referenceCounted, (String)"packet");
            RakNetRelaySession rakNetRelaySession = RakNetRelaySession.this;
            referenceCounted = referenceCounted.getBuffer();
            Intrinsics.checkNotNullExpressionValue((Object)referenceCounted, (String)"packet.buffer");
            rakNetRelaySession.readPacketFromBuffer((ByteBuf)referenceCounted, true);
        }

        @Override
        public void onSessionChangeState(RakNetState rakNetState) {
            Intrinsics.checkNotNullParameter((Object)((Object)rakNetState), (String)"state");
            LoggerKt.logInfo("client connection state: " + (Object)((Object)rakNetState));
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/RakNetRelaySession$RakNetRelayServerListener;", "Lcom/nukkitx/network/raknet/RakNetSessionListener;", "(Ldev/sora/relay/RakNetRelaySession;)V", "onDirect", "", "buf", "Lio/netty/buffer/ByteBuf;", "onDisconnect", "reason", "Lcom/nukkitx/network/util/DisconnectReason;", "onEncapsulated", "packet", "Lcom/nukkitx/network/raknet/EncapsulatedPacket;", "onSessionChangeState", "state", "Lcom/nukkitx/network/raknet/RakNetState;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public final class RakNetRelayServerListener
    implements RakNetSessionListener {
        @Override
        public void onDirect(ByteBuf byteBuf) {
            Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"buf");
        }

        @Override
        public void onDisconnect(DisconnectReason disconnectReason) {
            Intrinsics.checkNotNullParameter((Object)((Object)disconnectReason), (String)"reason");
            RakNetRelaySession.this.getClientsideSession().closeNoPacket();
            LoggerKt.logInfo("server disconnect: " + (Object)((Object)disconnectReason));
        }

        @Override
        public void onEncapsulated(EncapsulatedPacket referenceCounted) {
            Intrinsics.checkNotNullParameter((Object)referenceCounted, (String)"packet");
            RakNetRelaySession rakNetRelaySession = RakNetRelaySession.this;
            referenceCounted = referenceCounted.getBuffer();
            Intrinsics.checkNotNullExpressionValue((Object)referenceCounted, (String)"packet.buffer");
            rakNetRelaySession.readPacketFromBuffer((ByteBuf)referenceCounted, false);
        }

        @Override
        public void onSessionChangeState(RakNetState object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"state");
            LoggerKt.logInfo("server connection state: " + object);
            if (object == RakNetState.CONNECTED && ((Collection)RakNetRelaySession.this.pendingPackets).isEmpty() ^ true) {
                LoggerKt.logInfo("pending packets: " + RakNetRelaySession.this.pendingPackets.size());
                Object object2 = RakNetRelaySession.this.pendingPackets;
                object = RakNetRelaySession.this;
                Iterator iterator = object2.iterator();
                while (iterator.hasNext()) {
                    object2 = (ByteBuf)iterator.next();
                    ((RakNetRelaySession)object).getServersideSession().send((ByteBuf)object2);
                }
                RakNetRelaySession.this.pendingPackets.clear();
            }
        }
    }
}

