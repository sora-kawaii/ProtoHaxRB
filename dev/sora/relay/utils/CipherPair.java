/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.utils;

import java.security.Key;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Ldev/sora/relay/utils/CipherPair;", "", "secretKey", "Ljavax/crypto/SecretKey;", "(Ljavax/crypto/SecretKey;)V", "decryptionCipher", "Ljavax/crypto/Cipher;", "getDecryptionCipher", "()Ljavax/crypto/Cipher;", "encryptionCipher", "getEncryptionCipher", "getSecretKey", "()Ljavax/crypto/SecretKey;", "sentEncryptedPacketCount", "Ljava/util/concurrent/atomic/AtomicLong;", "getSentEncryptedPacketCount", "()Ljava/util/concurrent/atomic/AtomicLong;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class CipherPair {
    private final Cipher decryptionCipher;
    private final Cipher encryptionCipher;
    private final SecretKey secretKey;
    private final AtomicLong sentEncryptedPacketCount;

    public CipherPair(SecretKey secretKey) {
        Intrinsics.checkNotNullParameter((Object)secretKey, (String)"secretKey");
        this.secretKey = secretKey;
        this.sentEncryptedPacketCount = new AtomicLong();
        byte[] byArray = new byte[16];
        String string2 = "AES/CTR/NoPadding";
        System.arraycopy(secretKey.getEncoded(), 0, byArray, 0, 12);
        byArray[15] = (byte)2;
        Cipher cipher = Cipher.getInstance(string2);
        cipher.init(1, (Key)secretKey, new IvParameterSpec(byArray));
        String string3 = "getInstance(transformati\u2026ameterSpec(iv))\n        }";
        Intrinsics.checkNotNullExpressionValue((Object)cipher, (String)string3);
        this.encryptionCipher = cipher;
        cipher = Cipher.getInstance(string2);
        cipher.init(2, (Key)secretKey, new IvParameterSpec(byArray));
        Intrinsics.checkNotNullExpressionValue((Object)cipher, (String)string3);
        this.decryptionCipher = cipher;
    }

    public final Cipher getDecryptionCipher() {
        return this.decryptionCipher;
    }

    public final Cipher getEncryptionCipher() {
        return this.encryptionCipher;
    }

    public final SecretKey getSecretKey() {
        return this.secretKey;
    }

    public final AtomicLong getSentEncryptedPacketCount() {
        return this.sentEncryptedPacketCount;
    }
}

