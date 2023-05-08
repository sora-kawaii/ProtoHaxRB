/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.utils;

public class TimerUtil {
    private long lastMs = 0L;

    public boolean delay(double d, boolean bl) {
        if ((double)(System.currentTimeMillis() - this.lastMs) >= d) {
            if (bl) {
                this.reset();
            }
            return true;
        }
        return false;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.lastMs;
    }

    public long getLastMs() {
        return this.lastMs;
    }

    public boolean isDelayComplete(double d) {
        boolean bl = (double)(System.currentTimeMillis() - this.lastMs) >= d;
        return bl;
    }

    public void reset() {
        this.lastMs = System.currentTimeMillis();
    }
}

