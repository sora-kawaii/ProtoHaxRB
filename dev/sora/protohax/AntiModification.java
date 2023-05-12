/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Pair;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\u00020\u0004*\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2={"Ldev/sora/protohax/AntiModification;", "", "()V", "SIGN_HASH", "", "<set-?>", "", "call", "getCall", "()I", "hash", "sig", "", "validateAppSignature", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "toHex", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class AntiModification {
    public static final AntiModification INSTANCE;
    private static final String SIGN_HASH;
    private static int call;

    static {
        String string2 = "\u06e6\u06e5\u06ec\u06ec\u06e8\u06e6\u06d8\u06d9\u06e6\u06d8\u06e6\u06d7\u06e7\u06db\u06d8\u06e1\u06d8\u06da\u06ec\u06da";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x21E ^ 0x1D387173) {
                default: {
                    continue block6;
                }
                case -1347206205: {
                    EntryPoint.stub((int)21);
                    string2 = "\u06eb\u06e8\u06e4\u06e2\u06e7\u06d6\u06d8\u06e1\u06e7\u06e6\u06db\u06e2\u06d9\u06e7\u06d6\u06e7\u06d9\u06d6\u06d8\u06da\u06df\u06dc\u06d8";
                    continue block6;
                }
                case 2006083913: {
                    INSTANCE = new AntiModification();
                    string2 = "\u06e8\u06e6\u06e1\u06e4\u06dc\u06da\u06db\u06e6\u06d6\u06e1\u06d9\u06e8\u06e4\u06e7\u06e7\u06e7\u06d8\u06d6\u06da\u06ec\u06e8\u06db\u06e4\u06dc";
                    continue block6;
                }
                case 1371573903: {
                    SIGN_HASH = "7804ec4ecb06606c042a896fc75eb10a";
                    string2 = "\u06da\u06e6\u06e4\u06df\u06e8\u06e6\u06df\u06d8\u06e8\u06d8\u06ec\u06e7\u06e5\u06e0\u06e2\u06e5\u06d8";
                    continue block6;
                }
                case 1366315900: 
            }
            break;
        }
    }

    private AntiModification() {
    }

    private final native String hash(byte[] var1);

    private final native String toHex(byte[] var1);

    public final native int getCall();

    public final native Pair validateAppSignature(Context var1);
}

