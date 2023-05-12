/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.math;

import dev.sora.relay.game.utils.math.MathHelper;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0019H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0007J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Ldev/sora/relay/game/utils/math/MathUtils;", "", "()V", "ASIN_TABLE", "", "PI", "", "PI2", "PId2", "RANDOM", "Ljava/util/Random;", "acos", "value", "asin", "equalsDelta", "", "f1", "f2", "delta", "getAverage", "", "vals", "", "getSum", "rand", "", "min", "max", "roundDownToPowerOfTwo", "val", "roundToFloat", "d", "toDeg", "angle", "toRad", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class MathUtils {
    private static final float[] ASIN_TABLE;
    public static final MathUtils INSTANCE;
    public static final float PI = (float)Math.PI;
    public static final float PI2 = (float)Math.PI * 2;
    public static final float PId2 = 1.5707964f;
    private static final Random RANDOM;

    static {
        int n;
        INSTANCE = new MathUtils();
        RANDOM = new Random();
        ASIN_TABLE = new float[65536];
        for (n = 0; n < 65536; ++n) {
            MathUtils.ASIN_TABLE[n] = (float)Math.asin((double)n / 32767.5 - 1.0);
        }
        for (n = -1; n < 2; ++n) {
            MathUtils.ASIN_TABLE[(int)(((double)n + 1.0) * 32767.5) & 0xFFFF] = (float)Math.asin(n);
        }
    }

    private MathUtils() {
    }

    @JvmStatic
    public static final float acos(float f) {
        return 1.5707964f - ASIN_TABLE[(int)((double)(1.0f + f) * 32767.5) & 0xFFFF];
    }

    @JvmStatic
    public static final float asin(float f) {
        return ASIN_TABLE[(int)((double)(1.0f + f) * 32767.5) & 0xFFFF];
    }

    @JvmStatic
    public static final boolean equalsDelta(float f, float f2, float f3) {
        boolean bl = Math.abs(f - f2) <= f3;
        return bl;
    }

    @JvmStatic
    public static final int getAverage(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"vals");
        int n = nArray.length <= 0 ? 0 : MathUtils.getSum(nArray) / nArray.length;
        return n;
    }

    @JvmStatic
    public static final int getSum(int[] nArray) {
        int n;
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"vals");
        if (nArray.length <= 0) {
            n = 0;
        } else {
            n = 0;
            int n2 = nArray.length;
            for (int i = 0; i < n2; ++i) {
                n += nArray[i];
            }
        }
        return n;
    }

    @JvmStatic
    public static final double rand(double d, double d2) {
        return RANDOM.nextDouble() * (d2 - d) + d;
    }

    @JvmStatic
    public static final double rand(float f, float f2) {
        return RANDOM.nextDouble() * (double)(f2 - f) + (double)f;
    }

    @JvmStatic
    public static final int roundDownToPowerOfTwo(int n) {
        int n2 = MathHelper.roundUpToPowerOfTwo(n);
        n = n == n2 ? n2 : n2 / 2;
        return n;
    }

    @JvmStatic
    public static final float roundToFloat(double d) {
        return (float)((double)Math.round(d * 1.0E8) / 1.0E8);
    }

    @JvmStatic
    public static final float toDeg(float f) {
        return 180.0f * f / MathHelper.PI;
    }

    @JvmStatic
    public static final float toRad(float f) {
        return f / 180.0f * MathHelper.PI;
    }
}

