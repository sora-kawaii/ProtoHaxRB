/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.game.world.chunk.palette;

import com.nukkitx.network.util.Preconditions;
import dev.sora.relay.game.world.chunk.palette.BitArray;
import dev.sora.relay.game.world.chunk.palette.BitArrayVersion;
import java.util.Arrays;

public class Pow2BitArray
implements BitArray {
    private final int size;
    private final BitArrayVersion version;
    private final int[] words;

    Pow2BitArray(BitArrayVersion bitArrayVersion, int n, int[] nArray) {
        this.size = n;
        this.version = bitArrayVersion;
        this.words = nArray;
        int n2 = BitArray.ceil((float)n / (float)bitArrayVersion.entriesPerWord);
        if (nArray.length == n2) {
            return;
        }
        n = nArray.length;
        throw new IllegalArgumentException("Invalid length given for storage, got: " + n + " but expected: " + n2);
    }

    @Override
    public BitArray copy() {
        BitArrayVersion bitArrayVersion = this.version;
        int n = this.size;
        int[] nArray = this.words;
        return new Pow2BitArray(bitArrayVersion, n, Arrays.copyOf(nArray, nArray.length));
    }

    @Override
    public int get(int n) {
        Preconditions.checkElementIndex(n, this.size);
        n = this.version.bits * n;
        return this.words[n >> 5] >>> (n & 0x1F) & this.version.maxEntryValue;
    }

    @Override
    public BitArrayVersion getVersion() {
        return this.version;
    }

    @Override
    public int[] getWords() {
        return this.words;
    }

    @Override
    public void set(int n, int n2) {
        Preconditions.checkElementIndex(n, this.size);
        boolean bl = n2 >= 0 && n2 <= this.version.maxEntryValue;
        int n3 = this.version.maxEntryValue;
        Preconditions.checkArgument(bl, "Max value: %s. Received value", n3, n2);
        n3 = this.version.bits * n;
        n = n3 >> 5;
        int[] nArray = this.words;
        nArray[n] = nArray[n] & ~(this.version.maxEntryValue << (n3 &= 0x1F)) | (this.version.maxEntryValue & n2) << n3;
    }

    @Override
    public int size() {
        return this.size;
    }
}

