/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.world.chunk;

import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.world.chunk.BlockStorage;
import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0002J&\u0010\u0017\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2={"Ldev/sora/relay/game/world/chunk/ChunkSection;", "", "blockMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "legacyBlockMapping", "(Ldev/sora/relay/game/utils/mapping/RuntimeMapping;Ldev/sora/relay/game/utils/mapping/RuntimeMapping;)V", "<set-?>", "Ldev/sora/relay/game/world/chunk/BlockStorage;", "storage", "getStorage", "()Ldev/sora/relay/game/world/chunk/BlockStorage;", "getBlockAt", "", "x", "y", "z", "read", "", "buf", "Lio/netty/buffer/ByteBuf;", "readLegacy", "readModern", "version", "setBlockAt", "runtimeId", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ChunkSection {
    private final RuntimeMapping blockMapping;
    private final RuntimeMapping legacyBlockMapping;
    private BlockStorage storage;

    public ChunkSection(RuntimeMapping runtimeMapping, RuntimeMapping runtimeMapping2) {
        Intrinsics.checkNotNullParameter((Object)runtimeMapping, (String)"blockMapping");
        Intrinsics.checkNotNullParameter((Object)runtimeMapping2, (String)"legacyBlockMapping");
        this.blockMapping = runtimeMapping;
        this.legacyBlockMapping = runtimeMapping2;
        this.storage = new BlockStorage(runtimeMapping, null, 2, null);
    }

    private final void readLegacy(ByteBuf object) {
        byte[] byArray = new byte[4096];
        ((ByteBuf)object).readBytes(byArray);
        byte[] byArray2 = new byte[2048];
        ((ByteBuf)object).readBytes(byArray2);
        int n = 0;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int n2 = (i << 8) + (j << 4) + k;
                    byte by = byArray[n2];
                    byte by2 = byArray2[n2 >> 1];
                    object = this.legacyBlockMapping.game(by << 6 | by2 >> (n2 & 1) * 4 & 0xF);
                    this.storage.setBlock(n, this.blockMapping.runtime((String)object));
                    ++n;
                }
            }
        }
    }

    private final void readModern(ByteBuf byteBuf, int n) {
        byte by = 1;
        if (n != 1) {
            by = byteBuf.readByte();
        }
        if (n >= 9) {
            byteBuf.readByte();
        }
        if (by == 0) {
            return;
        }
        this.storage = new BlockStorage(byteBuf, this.blockMapping);
        for (n = 0; n < by - 1; ++n) {
            new BlockStorage(byteBuf, this.blockMapping);
        }
    }

    public final int getBlockAt(int n, int n2, int n3) {
        boolean bl = true;
        boolean bl2 = n >= 0 && n < 16;
        bl2 = bl2 && (bl2 = n2 >= 0 && n2 < 16) && (bl2 = n3 >= 0 && n3 < 16) ? bl : false;
        if (bl2) {
            return this.storage.getBlock(n, n2, n3);
        }
        throw new AssertionError((Object)("query out of range (x=" + n + ", y=" + n2 + ", z=" + n3 + ')'));
    }

    public final BlockStorage getStorage() {
        return this.storage;
    }

    public final void read(ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"buf");
        byte by = byteBuf.readByte();
        if (by == 0) {
            this.readLegacy(byteBuf);
        } else {
            boolean bl = true;
            if (by != 1) {
                if (8 > by || by >= 11) {
                    bl = false;
                }
                if (!bl) {
                    throw new UnsupportedOperationException("chunk version not supported: " + by);
                }
            }
            this.readModern(byteBuf, by);
        }
    }

    public final void setBlockAt(int n, int n2, int n3, int n4) {
        boolean bl = true;
        boolean bl2 = n >= 0 && n < 16;
        bl2 = bl2 && (bl2 = n2 >= 0 && n2 < 16) && (bl2 = n3 >= 0 && n3 < 16) ? bl : false;
        if (bl2) {
            this.storage.setBlock(n, n2, n3, n4);
            return;
        }
        throw new AssertionError((Object)("query out of range (x=" + n + ", y=" + n2 + ", z=" + n3 + ')'));
    }
}

