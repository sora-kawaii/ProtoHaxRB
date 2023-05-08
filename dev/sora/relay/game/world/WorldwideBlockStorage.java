/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.world;

import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.SubChunkData;
import com.nukkitx.protocol.bedrock.data.SubChunkRequestResult;
import com.nukkitx.protocol.bedrock.packet.ChangeDimensionPacket;
import com.nukkitx.protocol.bedrock.packet.ChunkRadiusUpdatedPacket;
import com.nukkitx.protocol.bedrock.packet.LevelChunkPacket;
import com.nukkitx.protocol.bedrock.packet.SubChunkPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateBlockPacket;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.world.chunk.Chunk;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fJ\u0018\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fJ\u0018\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fJ\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001bJ&\u0010+\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010,\u001a\u00020\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006-"}, d2={"Ldev/sora/relay/game/world/WorldwideBlockStorage;", "", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "chunks", "", "", "Ldev/sora/relay/game/world/chunk/Chunk;", "getChunks", "()Ljava/util/Map;", "<set-?>", "", "dimension", "getDimension", "()I", "setDimension", "(I)V", "getSession", "()Ldev/sora/relay/game/GameSession;", "viewDistance", "getViewDistance", "setViewDistance", "chunkOutOfRangeCheck", "", "clearChunk", "getBlockAt", "", "vec", "Lcom/nukkitx/math/vector/Vector3i;", "x", "y", "z", "getBlockIdAt", "getChunk", "chunkX", "chunkZ", "getChunkAt", "onServerPacket", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "setBlockAt", "name", "setBlockIdAt", "id", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class WorldwideBlockStorage {
    private final Map<Long, Chunk> chunks;
    private int dimension;
    private final GameSession session;
    private int viewDistance;

    public WorldwideBlockStorage(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.session = gameSession;
        this.chunks = new LinkedHashMap();
        this.viewDistance = -1;
    }

    private final void chunkOutOfRangeCheck() {
    }

    public final void clearChunk() {
        this.chunks.clear();
    }

    public final String getBlockAt(int n, int n2, int n3) {
        return this.session.getBlockMapping().game(this.getBlockIdAt(n, n2, n3));
    }

    public final String getBlockAt(Vector3i vector3i) {
        Intrinsics.checkNotNullParameter((Object)vector3i, (String)"vec");
        return this.getBlockAt(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    public final int getBlockIdAt(int n, int n2, int n3) {
        Chunk chunk = this.getChunkAt(n, n3);
        if (chunk == null) {
            return this.session.getBlockMapping().runtime("minecraft:air");
        }
        return chunk.getBlockAt(n & 0xF, n2, n3 & 0xF);
    }

    public final int getBlockIdAt(Vector3i vector3i) {
        Intrinsics.checkNotNullParameter((Object)vector3i, (String)"vec");
        return this.getBlockIdAt(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    public final Chunk getChunk(int n, int n2) {
        return this.chunks.get(Chunk.Companion.hash(n, n2));
    }

    public final Chunk getChunkAt(int n, int n2) {
        return this.getChunk(n >> 4, n2 >> 4);
    }

    protected final Map<Long, Chunk> getChunks() {
        return this.chunks;
    }

    public final int getDimension() {
        return this.dimension;
    }

    protected final GameSession getSession() {
        return this.session;
    }

    public final int getViewDistance() {
        return this.viewDistance;
    }

    public void onServerPacket(BedrockPacket iterator) {
        Intrinsics.checkNotNullParameter((Object)iterator, (String)"packet");
        if (iterator instanceof LevelChunkPacket) {
            this.chunkOutOfRangeCheck();
            int n = ((LevelChunkPacket)((Object)iterator)).getChunkX();
            int n2 = ((LevelChunkPacket)((Object)iterator)).getChunkZ();
            boolean bl = this.dimension == 0 && (!this.session.getNetSessionInitialized() || this.session.getNetSession().getPacketCodec().getProtocolVersion() >= 440);
            Chunk chunk = new Chunk(n, n2, bl, this.session.getBlockMapping(), this.session.getLegacyBlockMapping());
            ByteBuf byteBuf = Unpooled.wrappedBuffer(((LevelChunkPacket)((Object)iterator)).getData());
            Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"wrappedBuffer(packet.data)");
            chunk.read(byteBuf, ((LevelChunkPacket)((Object)iterator)).getSubChunksLength());
            this.chunks.put(chunk.getHash(), chunk);
        } else if (iterator instanceof ChunkRadiusUpdatedPacket) {
            this.viewDistance = ((ChunkRadiusUpdatedPacket)((Object)iterator)).getRadius();
            this.chunkOutOfRangeCheck();
        } else if (iterator instanceof ChangeDimensionPacket) {
            this.dimension = ((ChangeDimensionPacket)((Object)iterator)).getDimension();
            this.chunks.clear();
        } else if (iterator instanceof UpdateBlockPacket && ((UpdateBlockPacket)((Object)iterator)).getDataLayer() == 0) {
            this.setBlockIdAt(((UpdateBlockPacket)((Object)iterator)).getBlockPosition().getX(), ((UpdateBlockPacket)((Object)iterator)).getBlockPosition().getY(), ((UpdateBlockPacket)((Object)iterator)).getBlockPosition().getZ(), ((UpdateBlockPacket)((Object)iterator)).getRuntimeId());
        } else if (iterator instanceof SubChunkPacket && ((SubChunkPacket)((Object)iterator)).getDimension() == this.dimension) {
            Vector3i vector3i = ((SubChunkPacket)((Object)iterator)).getCenterPosition();
            iterator = ((SubChunkPacket)((Object)iterator)).getSubChunks();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"packet.subChunks");
            for (SubChunkData subChunkData : (Iterable)((Object)iterator)) {
                if (subChunkData.getResult() != SubChunkRequestResult.SUCCESS) continue;
                Object object = subChunkData.getPosition().add(vector3i).add(0, 4, 0);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"it.position.add(centerPos).add(0, 4, 0)");
                Chunk chunk = this.getChunk(((Vector3i)object).getX(), ((Vector3i)object).getZ());
                if (chunk == null) continue;
                byte[] byArray = subChunkData.getData();
                String string = "it.data";
                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)string);
                int n = byArray.length == 0 ? 1 : 0;
                if (n != 0) {
                    this.session.getCacheManager().registerCacheCallback(subChunkData.getBlobId(), (Function1<? super byte[], Unit>)((Function1)new Function1<byte[], Unit>(chunk, (Vector3i)object){
                        final /* synthetic */ Chunk $chunk;
                        final /* synthetic */ Vector3i $position;
                        {
                            this.$chunk = chunk;
                            this.$position = vector3i;
                            super(1);
                        }

                        public final void invoke(byte[] byArray) {
                            Intrinsics.checkNotNullParameter((Object)byArray, (String)"it");
                            this.$chunk.readSubChunk(this.$position.getY(), byArray);
                        }
                    }));
                    continue;
                }
                n = ((Vector3i)object).getY();
                object = subChunkData.getData();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)string);
                chunk.readSubChunk(n, (byte[])object);
            }
        }
    }

    public final void setBlockAt(int n, int n2, int n3, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        this.setBlockIdAt(n, n2, n3, this.session.getBlockMapping().runtime(string));
    }

    public final void setBlockIdAt(int n, int n2, int n3, int n4) {
        Chunk chunk = this.getChunkAt(n, n3);
        if (chunk == null) {
            return;
        }
        chunk.setBlockAt(n & 0xF, n2, n3 & 0xF, n4);
    }

    protected final void setDimension(int n) {
        this.dimension = n;
    }

    protected final void setViewDistance(int n) {
        this.viewDistance = n;
    }
}

