/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.utils;

import java.lang.reflect.Method;
import java.security.SignatureException;

public class JoseStuff {
    public static byte[] DERToJOSE(byte[] byArray) throws SignatureException {
        int n = byArray[0] == 48 && byArray.length != 96 ? 1 : 0;
        String string = "Invalid DER signature format.";
        if (n != 0) {
            int n2;
            byte[] byArray2 = new byte[96];
            n = 1;
            if (byArray[1] == -127) {
                n = 1 + 1;
            }
            if ((byArray[n] & 0xFF) == byArray.length - (n2 = n + 1)) {
                n = ++n2 + 1;
                byte by = byArray[n2];
                if (by <= 49) {
                    n2 = 48 - by;
                    System.arraycopy(byArray, Math.max(-n2, 0) + n, byArray2, Math.max(n2, 0), Math.min(n2, 0) + by);
                    n2 = n + (by + 1);
                    by = byArray[n2];
                    if (by <= 49) {
                        n = 48 - by;
                        System.arraycopy(byArray, Math.max(-n, 0) + (n2 + 1), byArray2, Math.max(n, 0) + 48, Math.min(n, 0) + by);
                        return byArray2;
                    }
                    throw new SignatureException(string);
                }
                throw new SignatureException(string);
            }
            throw new SignatureException(string);
        }
        throw new SignatureException(string);
    }

    public static Object cloneObj(Object object) throws Exception {
        Method method = object.getClass().getMethod("clone", new Class[0]);
        method.setAccessible(true);
        return method.invoke(object, new Object[0]);
    }
}

