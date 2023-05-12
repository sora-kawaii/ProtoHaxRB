/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0014\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0019"}, d2={"Ldev/sora/protohax/ContextUtils;", "", "()V", "SHARED_PREFERENCES_KEY", "", "hasInternetPermission", "", "Landroid/content/pm/PackageInfo;", "getHasInternetPermission", "(Landroid/content/pm/PackageInfo;)Z", "isAppExists", "Landroid/content/pm/PackageManager;", "packageName", "readString", "Landroid/content/Context;", "key", "readStringOrDefault", "default", "toast", "", "resId", "", "msg", "writeString", "property", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class ContextUtils {
    public static final ContextUtils INSTANCE;
    private static final String SHARED_PREFERENCES_KEY = "ProtoHax_Caches";

    static {
        String string2 = "\u06e1\u06d7\u06e6\u06e0\u06da\u06d6\u06d6\u06df\u06e1\u06e7\u06da\u06e1\u06d8\u06e6\u06d6\u06e1\u06d9\u06e2\u06e1\u06d8\u06e6\u06da\u06e8";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x1A4 ^ 0x4EC485EB) {
                default: {
                    continue block5;
                }
                case -1200316298: {
                    EntryPoint.stub((int)19);
                    string2 = "\u06d6\u06d9\u06eb\u06db\u06dc\u06e2\u06eb\u06d7\u06ec\u06e8\u06d9\u06e6\u06d8\u06db\u06e8\u06eb";
                    continue block5;
                }
                case 1605302491: {
                    INSTANCE = new ContextUtils();
                    string2 = "\u06dc\u06d7\u06d8\u06d6\u06db\u06e5\u06e1\u06e8\u06d6\u06e8\u06dc\u06e8\u06e5\u06d7\u06da\u06e2\u06ec\u06eb\u06eb\u06e1\u06dc\u06d8";
                    continue block5;
                }
                case -185123812: 
            }
            break;
        }
    }

    private ContextUtils() {
    }

    public final native boolean getHasInternetPermission(PackageInfo var1);

    public final native boolean isAppExists(PackageManager var1, String var2);

    public final native String readString(Context var1, String var2);

    public final native String readStringOrDefault(Context var1, String var2, String var3);

    public final native void toast(Context var1, int var2);

    public final native void toast(Context var1, String var2);

    public final native void writeString(Context var1, String var2, String var3);
}

