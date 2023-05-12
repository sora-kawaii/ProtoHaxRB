/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.world.chunk;

import com.nukkitx.nbt.NBTInputStream;
import com.nukkitx.nbt.NbtMap;
import com.nukkitx.nbt.util.stream.NetworkDataInputStream;
import com.nukkitx.network.VarInts;
import dev.sora.relay.game.utils.mapping.BlockMappingUtils;
import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.world.chunk.palette.BitArray;
import dev.sora.relay.game.world.chunk.palette.BitArrayVersion;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.AbstractMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010%\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017J&\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006'"}, d2={"Ldev/sora/relay/game/world/chunk/BlockStorage;", "", "blockMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "version", "Ldev/sora/relay/game/world/chunk/palette/BitArrayVersion;", "(Ldev/sora/relay/game/utils/mapping/RuntimeMapping;Ldev/sora/relay/game/world/chunk/palette/BitArrayVersion;)V", "byteBuf", "Lio/netty/buffer/ByteBuf;", "(Lio/netty/buffer/ByteBuf;Ldev/sora/relay/game/utils/mapping/RuntimeMapping;)V", "bitArray", "Ldev/sora/relay/game/world/chunk/palette/BitArray;", "getBitArray", "()Ldev/sora/relay/game/world/chunk/palette/BitArray;", "setBitArray", "(Ldev/sora/relay/game/world/chunk/palette/BitArray;)V", "palette", "Lit/unimi/dsi/fastutil/ints/IntArrayList;", "getPalette", "()Lit/unimi/dsi/fastutil/ints/IntArrayList;", "setPalette", "(Lit/unimi/dsi/fastutil/ints/IntArrayList;)V", "getBlock", "", "x", "y", "z", "getByIndex", "index", "getIndex", "getPaletteHeader", "runtime", "", "idFor", "runtimeId", "onResize", "", "setBlock", "Companion", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class BlockStorage {
    public static final Companion Companion = new Companion(null);
    public static final int SIZE = 4096;
    private BitArray bitArray;
    private IntArrayList palette;

    public BlockStorage(RuntimeMapping runtimeMapping, BitArrayVersion object) {
        Intrinsics.checkNotNullParameter((Object)runtimeMapping, (String)"blockMapping");
        Intrinsics.checkNotNullParameter((Object)object, (String)"version");
        object = ((BitArrayVersion)((Object)object)).createPalette(4096);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"version.createPalette(SIZE)");
        this.bitArray = object;
        object = new IntArrayList(16);
        this.palette = object;
        ((IntArrayList)object).add(runtimeMapping.runtime("minecraft:air"));
    }

    public /* synthetic */ BlockStorage(RuntimeMapping runtimeMapping, BitArrayVersion bitArrayVersion, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bitArrayVersion = BitArrayVersion.V2;
        }
        this(runtimeMapping, bitArrayVersion);
    }

    public BlockStorage(ByteBuf byteBuf, RuntimeMapping runtimeMapping) {
        int n;
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"byteBuf");
        Intrinsics.checkNotNullParameter((Object)runtimeMapping, (String)"blockMapping");
        byte by = byteBuf.readByte();
        boolean bl = (by & 1) == 1;
        Object object = BitArrayVersion.get((by | 1) >> 1, true);
        Object object2 = object.createPalette(4096);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"bitArrayVersion.createPalette(maxBlocksInSection)");
        this.bitArray = object2;
        int n2 = object.getWordsForSize(4096);
        for (n = 0; n < n2; ++n) {
            int n3;
            this.bitArray.getWords()[n] = n3 = byteBuf.readIntLE();
        }
        n2 = VarInts.readInt(byteBuf);
        this.palette = new IntArrayList(n2);
        object = bl ? null : new NBTInputStream(new NetworkDataInputStream(new ByteBufInputStream(byteBuf)));
        for (n = 0; n < n2; ++n) {
            if (bl) {
                this.palette.add(VarInts.readInt(byteBuf));
                continue;
            }
            Intrinsics.checkNotNull((Object)object);
            object2 = ((NBTInputStream)object).readTag();
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type com.nukkitx.nbt.NbtMap");
            AbstractMap abstractMap = ((NbtMap)object2).toBuilder();
            Object object3 = "name";
            object2 = String.valueOf(abstractMap.get(object3));
            String string2 = "minecraft:";
            if (!StringsKt.startsWith$default((String)object2, (String)string2, (boolean)false, (int)2, null)) {
                object2 = string2 + (String)object2;
            }
            abstractMap.replace(object3, object2);
            object3 = this.palette;
            object2 = BlockMappingUtils.INSTANCE;
            abstractMap = abstractMap.build();
            Intrinsics.checkNotNullExpressionValue((Object)abstractMap, (String)"map.build()");
            ((IntArrayList)object3).add(runtimeMapping.runtime(((BlockMappingUtils)object2).getBlockNameFromNbt((NbtMap)abstractMap)));
        }
    }

    private final int getIndex(int n, int n2, int n3) {
        return n << 8 | n3 << 4 | n2;
    }

    private final int getPaletteHeader(BitArrayVersion bitArrayVersion, boolean bl) {
        return bitArrayVersion.getId() << 1 | bl;
    }

    private final int idFor(int n) {
        BitArrayVersion bitArrayVersion;
        int n2 = this.palette.indexOf(n);
        if (n2 != -1) {
            return n2;
        }
        n2 = this.palette.size();
        if (n2 > (bitArrayVersion = this.bitArray.getVersion()).getMaxEntryValue() && (bitArrayVersion = bitArrayVersion.next()) != null) {
            this.onResize(bitArrayVersion);
        }
        this.palette.add(n);
        return n2;
    }

    private final void onResize(BitArrayVersion object) {
        object = ((BitArrayVersion)((Object)object)).createPalette(4096);
        for (int i = 0; i < 4096; ++i) {
            object.set(i, this.bitArray.get(i));
        }
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newBitArray");
        this.bitArray = object;
    }

    public final BitArray getBitArray() {
        return this.bitArray;
    }

    public final int getBlock(int n, int n2, int n3) {
        return this.getByIndex(this.getIndex(n, n2, n3));
    }

    public final int getByIndex(int n) {
        return this.palette.getInt(this.bitArray.get(n));
    }

    public final IntArrayList getPalette() {
        return this.palette;
    }

    public final void setBitArray(BitArray bitArray) {
        Intrinsics.checkNotNullParameter((Object)bitArray, (String)"<set-?>");
        this.bitArray = bitArray;
    }

    public final void setBlock(int n, int n2) {
        try {
            int n3 = this.idFor(n2);
            this.bitArray.set(n, n3);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unable to set block runtime ID: " + n2 + ", palette: " + this.palette, illegalArgumentException);
        }
    }

    public final void setBlock(int n, int n2, int n3, int n4) {
        this.setBlock(this.getIndex(n, n2, n3), n4);
    }

    public final void setPalette(IntArrayList intArrayList) {
        Intrinsics.checkNotNullParameter((Object)intArrayList, (String)"<set-?>");
        this.palette = intArrayList;
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Ldev/sora/relay/game/world/chunk/BlockStorage$Companion;", "", "()V", "SIZE", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

