/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay.utils;

import java.lang.reflect.Method;
import java.security.SignatureException;

public class JoseStuff {
    public static byte[] DERToJOSE(byte[] byArray) throws SignatureException {
        int n = byArray[0] == 48 && byArray.length != 96 ? 1 : 0;
        String string2 = "Invalid DER signature format.";
        if (n != 0) {
            int n2;
            byte[] byArray2 = new byte[96];
            n = 1;
            if (byArray[1] == -127) {
                n = 1 + 1;
            }
            if ((byArray[n] & 0xFF) == byArray.length - (n2 = n + 1)) {
                n = ++n2 + 1;
                int n3 = byArray[n2];
                if (n3 <= 49) {
                    n2 = 48 - n3;
                    System.arraycopy(byArray, Math.max(-n2, 0) + n, byArray2, Math.max(n2, 0), Math.min(n2, 0) + n3);
                    n2 = n + (n3 + 1);
                    n = byArray[n2];
                    if (n <= 49) {
                        n3 = 48 - n;
                        System.arraycopy(byArray, Math.max(-n3, 0) + (n2 + 1), byArray2, Math.max(n3, 0) + 48, Math.min(n3, 0) + n);
                        return byArray2;
                    }
                    throw new SignatureException(string2);
                }
                throw new SignatureException(string2);
            }
            throw new SignatureException(string2);
        }
        throw new SignatureException(string2);
    }

    public static Object cloneObj(Object object) throws Exception {
        Method method = object.getClass().getMethod("clone", new Class[0]);
        method.setAccessible(true);
        return method.invoke(object, new Object[0]);
    }
}

