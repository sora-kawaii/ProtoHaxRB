/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.game.world.chunk.palette;

import dev.sora.relay.game.world.chunk.palette.BitArray;
import dev.sora.relay.game.world.chunk.palette.PaddedBitArray;
import dev.sora.relay.game.world.chunk.palette.Pow2BitArray;

public final class BitArrayVersion
extends Enum<BitArrayVersion> {
    private static final /* synthetic */ BitArrayVersion[] $VALUES;
    public static final /* enum */ BitArrayVersion V1;
    public static final /* enum */ BitArrayVersion V16;
    public static final /* enum */ BitArrayVersion V2;
    public static final /* enum */ BitArrayVersion V3;
    public static final /* enum */ BitArrayVersion V4;
    public static final /* enum */ BitArrayVersion V5;
    public static final /* enum */ BitArrayVersion V6;
    public static final /* enum */ BitArrayVersion V8;
    final byte bits;
    final byte entriesPerWord;
    final int maxEntryValue;
    final BitArrayVersion next;

    private static /* synthetic */ BitArrayVersion[] $values() {
        return new BitArrayVersion[]{V16, V8, V6, V5, V4, V3, V2, V1};
    }

    static {
        BitArrayVersion bitArrayVersion;
        V16 = bitArrayVersion = new BitArrayVersion(16, 2, null);
        V8 = bitArrayVersion = new BitArrayVersion(8, 4, bitArrayVersion);
        V6 = bitArrayVersion = new BitArrayVersion(6, 5, bitArrayVersion);
        V5 = bitArrayVersion = new BitArrayVersion(5, 6, bitArrayVersion);
        V4 = bitArrayVersion = new BitArrayVersion(4, 8, bitArrayVersion);
        V3 = bitArrayVersion = new BitArrayVersion(3, 10, bitArrayVersion);
        V2 = bitArrayVersion = new BitArrayVersion(2, 16, bitArrayVersion);
        V1 = new BitArrayVersion(1, 32, bitArrayVersion);
        $VALUES = BitArrayVersion.$values();
    }

    private BitArrayVersion(int n2, int n3, BitArrayVersion bitArrayVersion) {
        n = (byte)n2;
        this.bits = (byte)n;
        this.entriesPerWord = (byte)n3;
        this.maxEntryValue = (1 << n) - 1;
        this.next = bitArrayVersion;
    }

    public static BitArrayVersion get(int n, boolean bl) {
        for (BitArrayVersion bitArrayVersion : BitArrayVersion.values()) {
            if ((bl || bitArrayVersion.entriesPerWord > n) && (!bl || bitArrayVersion.bits != n)) continue;
            return bitArrayVersion;
        }
        throw new IllegalArgumentException("Invalid palette version: " + n);
    }

    public static BitArrayVersion valueOf(String string2) {
        return Enum.valueOf(BitArrayVersion.class, string2);
    }

    public static BitArrayVersion[] values() {
        return (BitArrayVersion[])$VALUES.clone();
    }

    public BitArray createPalette(int n) {
        return this.createPalette(n, new int[this.getWordsForSize(n)]);
    }

    public BitArray createPalette(int n, int[] nArray) {
        if (this != V3 && this != V5 && this != V6) {
            return new Pow2BitArray(this, n, nArray);
        }
        return new PaddedBitArray(this, n, nArray);
    }

    public byte getId() {
        return this.bits;
    }

    public int getMaxEntryValue() {
        return this.maxEntryValue;
    }

    public int getWordsForSize(int n) {
        byte by = this.entriesPerWord;
        int n2 = n / by;
        n = n % by == 0 ? 0 : 1;
        return n2 + n;
    }

    public BitArrayVersion next() {
        return this.next;
    }
}

