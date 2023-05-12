/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.game.utils.math;

import dev.sora.relay.game.utils.math.MathUtils;
import java.util.Random;
import java.util.UUID;

public class MathHelper {
    public static final float PI;
    public static final float PI2;
    public static final float PId2;
    private static final int SIN_BITS = 12;
    private static final int SIN_COUNT = 4096;
    private static final int SIN_COUNT_D4 = 1024;
    private static final int SIN_MASK = 4095;
    private static final float[] SIN_TABLE;
    private static final float[] SIN_TABLE_FAST;
    public static final float SQRT_2;
    public static final float deg2Rad;
    public static boolean fastMath;
    private static final double field_181163_d;
    private static final double[] field_181164_e;
    private static final double[] field_181165_f;
    private static final int[] multiplyDeBruijnBitPosition;
    private static final float radToIndex;

    static {
        float[] fArray;
        int n;
        SQRT_2 = MathHelper.sqrt_float(2.0f);
        PI = MathUtils.roundToFloat(Math.PI);
        PI2 = MathUtils.roundToFloat(Math.PI * 2);
        PId2 = MathUtils.roundToFloat(1.5707963267948966);
        radToIndex = MathUtils.roundToFloat(651.8986469044033);
        deg2Rad = MathUtils.roundToFloat(Math.PI / 180);
        SIN_TABLE_FAST = new float[4096];
        fastMath = false;
        SIN_TABLE = new float[65536];
        for (n = 0; n < 65536; ++n) {
            MathHelper.SIN_TABLE[n] = (float)Math.sin((double)n * Math.PI * 2.0 / 65536.0);
        }
        for (n = 0; n < (fArray = SIN_TABLE_FAST).length; ++n) {
            fArray[n] = MathUtils.roundToFloat(Math.sin((double)n * Math.PI * 2.0 / 4096.0));
        }
        multiplyDeBruijnBitPosition = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
        field_181163_d = Double.longBitsToDouble(4805340802404319232L);
        field_181164_e = new double[257];
        field_181165_f = new double[257];
        for (n = 0; n < 257; ++n) {
            double d = Math.asin((double)n / 256.0);
            MathHelper.field_181165_f[n] = Math.cos(d);
            MathHelper.field_181164_e[n] = d;
        }
    }

    public static float abs(float f) {
        if (!(f >= 0.0f)) {
            f = -f;
        }
        return f;
    }

    public static int abs_int(int n) {
        if (n < 0) {
            n = -n;
        }
        return n;
    }

    public static double abs_max(double d, double d2) {
        block2: {
            double d3 = d;
            if (d < 0.0) {
                d3 = -d;
            }
            d = d2;
            if (d2 < 0.0) {
                d = -d2;
            }
            if (!(d3 > d)) break block2;
            d = d3;
        }
        return d;
    }

    public static double atan2(double d, double d2) {
        double d3 = d2;
        double d4 = d;
        double d5 = d3 * d3 + d4 * d4;
        if (Double.isNaN(d5)) {
            return Double.NaN;
        }
        boolean bl = true;
        boolean bl2 = d4 < 0.0;
        d = d4;
        if (bl2) {
            d = -d4;
        }
        boolean bl3 = d3 < 0.0;
        d2 = d3;
        if (bl3) {
            d2 = -d3;
        }
        if (!(d > d2)) {
            bl = false;
        }
        d4 = d;
        d3 = d2;
        if (bl) {
            d3 = d;
            d4 = d2;
        }
        d = MathHelper.func_181161_i(d5);
        d5 = field_181163_d;
        double d6 = d5 + (d4 *= d);
        int n = (int)Double.doubleToRawLongBits(d6);
        d2 = field_181164_e[n];
        d = d4 * field_181165_f[n] - d3 * d * (d6 - d5);
        d2 += (d * d + 6.0) * d * 0.16666666666666666;
        d = d2;
        if (bl) {
            d = 1.5707963267948966 - d2;
        }
        if (bl3) {
            d = Math.PI - d;
        }
        d2 = d;
        if (bl2) {
            d2 = -d;
        }
        return d2;
    }

    public static double average(long[] lArray) {
        long l = 0L;
        int n = lArray.length;
        for (int i = 0; i < n; ++i) {
            l += lArray[i];
        }
        return (double)l / (double)lArray.length;
    }

    public static int bucketInt(int n, int n2) {
        n = n < 0 ? -((-n - 1) / n2) - 1 : (n /= n2);
        return n;
    }

    public static int calculateLogBaseTwo(int n) {
        return MathHelper.calculateLogBaseTwoDeBruijn(n) - (MathHelper.isPowerOfTwo(n) ^ 1);
    }

    private static int calculateLogBaseTwoDeBruijn(int n) {
        if (!MathHelper.isPowerOfTwo(n)) {
            n = MathHelper.roundUpToPowerOfTwo(n);
        }
        return multiplyDeBruijnBitPosition[(int)((long)n * 125613361L >> 27) & 0x1F];
    }

    public static int ceiling_double_int(double d) {
        int n;
        block0: {
            n = (int)d;
            if (!(d > (double)n)) break block0;
            ++n;
        }
        return n;
    }

    public static int ceiling_float_int(float f) {
        int n;
        block0: {
            n = (int)f;
            if (!(f > (float)n)) break block0;
            ++n;
        }
        return n;
    }

    public static double clamp_double(double d, double d2, double d3) {
        block1: {
            block0: {
                if (!(d < d2)) break block0;
                d = d2;
                break block1;
            }
            if (!(d > d3)) break block1;
            d = d3;
        }
        return d;
    }

    public static float clamp_float(float f, float f2, float f3) {
        block1: {
            block0: {
                if (!(f < f2)) break block0;
                f = f2;
                break block1;
            }
            if (!(f > f3)) break block1;
            f = f3;
        }
        return f;
    }

    public static int clamp_int(int n, int n2, int n3) {
        block1: {
            block0: {
                if (n >= n2) break block0;
                n = n2;
                break block1;
            }
            if (n <= n3) break block1;
            n = n3;
        }
        return n;
    }

    public static float cos(float f) {
        f = fastMath ? SIN_TABLE_FAST[(int)(radToIndex * f + 1024.0f) & 0xFFF] : SIN_TABLE[(int)(10430.378f * f + 16384.0f) & 0xFFFF];
        return f;
    }

    public static double denormalizeClamp(double d, double d2, double d3) {
        if (!(d3 < 0.0)) {
            d = d3 > 1.0 ? d2 : (d2 - d) * d3 + d;
        }
        return d;
    }

    public static boolean epsilonEquals(float f, float f2) {
        boolean bl = MathHelper.abs(f2 - f) < 1.0E-5f;
        return bl;
    }

    public static int floor_double(double d) {
        int n;
        block0: {
            n = (int)d;
            if (!(d < (double)n)) break block0;
            --n;
        }
        return n;
    }

    public static long floor_double_long(double d) {
        long l;
        block0: {
            l = (long)d;
            if (!(d < (double)l)) break block0;
            --l;
        }
        return l;
    }

    public static int floor_float(float f) {
        int n;
        block0: {
            n = (int)f;
            if (!(f < (float)n)) break block0;
            --n;
        }
        return n;
    }

    public static int func_154353_e(double d) {
        if (!(d >= 0.0)) {
            d = -d + 1.0;
        }
        return (int)d;
    }

    public static int func_180181_b(int n, int n2, int n3) {
        return ((n << 8) + n2 << 8) + n3;
    }

    public static int func_180183_b(float f, float f2, float f3) {
        return MathHelper.func_180181_b(MathHelper.floor_float(f * 255.0f), MathHelper.floor_float(f2 * 255.0f), MathHelper.floor_float(255.0f * f3));
    }

    public static int func_180188_d(int n, int n2) {
        return 0xFF000000 & n | (int)((float)((n & 0xFF0000) >> 16) * (float)((0xFF0000 & n2) >> 16) / 255.0f) << 16 | (int)((float)((n & 0xFF00) >> 8) * (float)((0xFF00 & n2) >> 8) / 255.0f) << 8 | (int)((float)((n & 0xFF) >> 0) * (float)((n2 & 0xFF) >> 0) / 255.0f);
    }

    public static double func_181160_c(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    public static double func_181161_i(double d) {
        double d2 = Double.longBitsToDouble(6910469410427058090L - (Double.doubleToRawLongBits(d) >> 1));
        return d2 * (1.5 - 0.5 * d * d2 * d2);
    }

    public static double func_181162_h(double d) {
        return d - Math.floor(d);
    }

    public static long getCoordinateRandom(int n, int n2, int n3) {
        long l = (long)(3129871 * n) ^ (long)n3 * 116129781L ^ (long)n2;
        return l * l * 42317861L + 11L * l;
    }

    public static double getRandomDoubleInRange(Random random, double d, double d2) {
        if (!(d >= d2)) {
            d = random.nextDouble() * (d2 - d) + d;
        }
        return d;
    }

    public static int getRandomIntegerInRange(Random random, int n, int n2) {
        if (n < n2) {
            n = random.nextInt(n2 - n + 1) + n;
        }
        return n;
    }

    public static UUID getRandomUuid(Random random) {
        return new UUID(random.nextLong() & 0xFFFFFFFFFFFF0FFFL | 0x4000L, random.nextLong() & 0x3FFFFFFFFFFFFFFFL | Long.MIN_VALUE);
    }

    public static int hsvToRGB(float f, float f2, float f3) {
        int n = (int)(f * 6.0f) % 6;
        float f4 = 6.0f * f - (float)n;
        float f5 = (1.0f - f2) * f3;
        float f6 = (1.0f - f4 * f2) * f3;
        f4 = (1.0f - (1.0f - f4) * f2) * f3;
        switch (n) {
            default: {
                StringBuilder stringBuilder = new StringBuilder().append("Something went wrong when converting from HSV to RGB. Input was ").append(f);
                String string2 = ", ";
                throw new RuntimeException(stringBuilder.append(string2).append(f2).append(string2).append(f3).toString());
            }
            case 5: {
                f = f3;
                f2 = f5;
                f3 = f6;
                break;
            }
            case 4: {
                f = f4;
                f2 = f5;
                break;
            }
            case 3: {
                f = f5;
                f2 = f6;
                break;
            }
            case 2: {
                f = f5;
                f2 = f3;
                f3 = f4;
                break;
            }
            case 1: {
                f = f6;
                f2 = f3;
                f3 = f5;
                break;
            }
            case 0: {
                f = f3;
                f2 = f4;
                f3 = f5;
            }
        }
        return MathHelper.clamp_int((int)(f * 255.0f), 0, 255) << 16 | MathHelper.clamp_int((int)(f2 * 255.0f), 0, 255) << 8 | MathHelper.clamp_int((int)(255.0f * f3), 0, 255);
    }

    private static boolean isPowerOfTwo(int n) {
        boolean bl = n != 0 && (n - 1 & n) == 0;
        return bl;
    }

    public static int normalizeAngle(int n, int n2) {
        return (n % n2 + n2) % n2;
    }

    public static double parseDoubleWithDefault(String string2, double d) {
        try {
            double d2 = Double.parseDouble(string2);
            return d2;
        }
        catch (Throwable throwable) {
            return d;
        }
    }

    public static double parseDoubleWithDefaultAndMax(String string2, double d, double d2) {
        return Math.max(d2, MathHelper.parseDoubleWithDefault(string2, d));
    }

    public static int parseIntWithDefault(String string2, int n) {
        try {
            int n2 = Integer.parseInt(string2);
            return n2;
        }
        catch (Throwable throwable) {
            return n;
        }
    }

    public static int parseIntWithDefaultAndMax(String string2, int n, int n2) {
        return Math.max(n2, MathHelper.parseIntWithDefault(string2, n));
    }

    public static float randomFloatClamp(Random random, float f, float f2) {
        if (!(f >= f2)) {
            f = random.nextFloat() * (f2 - f) + f;
        }
        return f;
    }

    public static int roundUp(int n, int n2) {
        if (n2 == 0) {
            return 0;
        }
        if (n == 0) {
            return n2;
        }
        int n3 = n2;
        if (n < 0) {
            n3 = n2 * -1;
        }
        if ((n2 = n % n3) != 0) {
            n = n + n3 - n2;
        }
        return n;
    }

    public static int roundUpToPowerOfTwo(int n) {
        --n;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        return (n | n >> 16) + 1;
    }

    public static float sin(float f) {
        f = fastMath ? SIN_TABLE_FAST[(int)(radToIndex * f) & 0xFFF] : SIN_TABLE[(int)(10430.378f * f) & 0xFFFF];
        return f;
    }

    public static float sqrt_double(double d) {
        return (float)Math.sqrt(d);
    }

    public static float sqrt_float(float f) {
        return (float)Math.sqrt(f);
    }

    public static int truncateDoubleToInt(double d) {
        return (int)(1024.0 + d) - 1024;
    }

    public static double wrapAngleTo180_double(double d) {
        double d2;
        d = d2 = d % 360.0;
        if (d2 >= 180.0) {
            d = d2 - 360.0;
        }
        d2 = d;
        if (d < -180.0) {
            d2 = d + 360.0;
        }
        return d2;
    }

    public static float wrapAngleTo180_float(float f) {
        float f2;
        f = f2 = f % 360.0f;
        if (f2 >= 180.0f) {
            f = f2 - 360.0f;
        }
        f2 = f;
        if (f < -180.0f) {
            f2 = f + 360.0f;
        }
        return f2;
    }

    public static double wrapDegrees(double d) {
        return MathHelper.wrapAngleTo180_double(d);
    }

    public static double wrapDegrees(int n) {
        return MathHelper.wrapAngleTo180_float(n);
    }

    public static float wrapDegrees(float f) {
        return MathHelper.wrapAngleTo180_float(f);
    }
}

