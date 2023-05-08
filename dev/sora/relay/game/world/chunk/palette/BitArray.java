/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.game.world.chunk.palette;

import dev.sora.relay.game.world.chunk.palette.BitArrayVersion;

public interface BitArray {
    public static int ceil(float f) {
        int n;
        block0: {
            n = (int)f;
            if (!(f > (float)n)) break block0;
            ++n;
        }
        return n;
    }

    public BitArray copy();

    public int get(int var1);

    public BitArrayVersion getVersion();

    public int[] getWords();

    public void set(int var1, int var2);

    public int size();
}

