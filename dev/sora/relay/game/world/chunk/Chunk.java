/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.world.chunk;

import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.world.chunk.ChunkSection;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!J\u0016\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&J&\u0010'\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016\u00a8\u0006*"}, d2={"Ldev/sora/relay/game/world/chunk/Chunk;", "", "x", "", "z", "is384World", "", "blockMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "legacyBlockMapping", "(IIZLdev/sora/relay/game/utils/mapping/RuntimeMapping;Ldev/sora/relay/game/utils/mapping/RuntimeMapping;)V", "hash", "", "getHash", "()J", "()Z", "maxiumHeight", "sectionStorage", "", "Ldev/sora/relay/game/world/chunk/ChunkSection;", "[Ldev/sora/relay/game/world/chunk/ChunkSection;", "getX", "()I", "getZ", "getBlockAt", "yIn", "isInRadius", "playerChunkX", "playerChunkZ", "radius", "read", "", "buf", "Lio/netty/buffer/ByteBuf;", "subChunks", "readSubChunk", "index", "data", "", "setBlockAt", "runtimeId", "Companion", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Chunk {
    public static final Companion Companion = new Companion(null);
    private final RuntimeMapping blockMapping;
    private final boolean is384World;
    private final RuntimeMapping legacyBlockMapping;
    private final int maxiumHeight;
    private final ChunkSection[] sectionStorage;
    private final int x;
    private final int z;

    public Chunk(int n, int n2, boolean bl, RuntimeMapping chunkSectionArray, RuntimeMapping runtimeMapping) {
        Intrinsics.checkNotNullParameter((Object)chunkSectionArray, (String)"blockMapping");
        Intrinsics.checkNotNullParameter((Object)runtimeMapping, (String)"legacyBlockMapping");
        this.x = n;
        this.z = n2;
        this.is384World = bl;
        this.blockMapping = chunkSectionArray;
        this.legacyBlockMapping = runtimeMapping;
        n = bl ? 24 : 16;
        chunkSectionArray = new ChunkSection[n];
        for (n2 = 0; n2 < n; ++n2) {
            chunkSectionArray[n2] = new ChunkSection(this.blockMapping, this.legacyBlockMapping);
        }
        this.sectionStorage = chunkSectionArray;
        this.maxiumHeight = chunkSectionArray.length * 16;
    }

    public final int getBlockAt(int n, int n2, int n3) {
        boolean bl;
        if (this.is384World) {
            n2 += 64;
        }
        boolean bl2 = bl = false;
        if (n2 >= 0) {
            bl2 = bl;
            if (n2 <= this.maxiumHeight) {
                bl2 = true;
            }
        }
        if (bl2) {
            return this.sectionStorage[n2 >> 4].getBlockAt(n, n2 & 0xF, n3);
        }
        throw new AssertionError((Object)"Assertion failed");
    }

    public final long getHash() {
        return Companion.hash(this.x, this.z);
    }

    public final int getX() {
        return this.x;
    }

    public final int getZ() {
        return this.z;
    }

    public final boolean is384World() {
        return this.is384World;
    }

    public final boolean isInRadius(int n, int n2, int n3) {
        boolean bl = Math.abs(this.x - n) <= n3 && Math.abs(this.z - n2) <= n3;
        return bl;
    }

    public final void read(ByteBuf byteBuf, int n) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"buf");
        for (int i = 0; i < n; ++i) {
            this.readSubChunk(i, byteBuf);
        }
    }

    public final void readSubChunk(int n, ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"buf");
        this.sectionStorage[n].read(byteBuf);
    }

    public final void readSubChunk(int n, byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"data");
        object = Unpooled.wrappedBuffer(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"wrappedBuffer(data)");
        this.readSubChunk(n, (ByteBuf)object);
    }

    public final void setBlockAt(int n, int n2, int n3, int n4) {
        boolean bl;
        if (this.is384World) {
            n2 += 64;
        }
        boolean bl2 = bl = false;
        if (n2 >= 0) {
            bl2 = bl;
            if (n2 <= this.maxiumHeight) {
                bl2 = true;
            }
        }
        if (bl2) {
            this.sectionStorage[n2 >> 4].setBlockAt(n, n2 & 0xF, n3, n4);
            return;
        }
        throw new AssertionError((Object)"Assertion failed");
    }

    @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\b"}, d2={"Ldev/sora/relay/game/world/chunk/Chunk$Companion;", "", "()V", "hash", "", "x", "", "z", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long hash(int n, int n2) {
            return (long)n << 32 | (long)n2 & 0xFFFFFFFFL;
        }
    }
}

