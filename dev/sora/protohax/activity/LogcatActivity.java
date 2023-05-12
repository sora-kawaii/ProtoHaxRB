/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.MenuItem
 *  com.stub.StubApp
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import com.stub.StubApp;
import kotlin.Metadata;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014\u00a8\u0006\u000e"}, d2={"Ldev/sora/protohax/activity/LogcatActivity;", "Landroid/app/Activity;", "()V", "clearLogs", "", "item", "Landroid/view/MenuItem;", "copyLogs", "logcat", "shouldFlushLog", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class LogcatActivity
extends Activity {
    static {
        StubApp.interface11((int)16946);
        String string2 = "\u06da\u06dc\u06e7\u06ec\u06e0\u06e1\u06d7\u06d6\u06e1\u06d6\u06da\u06e4\u06df\u06e2\u06dc\u06e1\u06eb\u06e4";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x2BB ^ 0x19149DF7) {
                default: {
                    continue block4;
                }
                case 1207721387: {
                    EntryPoint.stub((int)13);
                    string2 = "\u06e7\u06dc\u06e8\u06e7\u06d6\u06eb\u06eb\u06ec\u06db\u06eb\u06e0\u06d6\u06e6\u06dc\u06ec\u06d8\u06e6\u06d8\u06d8\u06e7\u06d8\u06d7\u06d8\u06e8\u06e0";
                    continue block4;
                }
                case -1252300750: 
            }
            break;
        }
    }

    private final native void logcat(boolean var1);

    public final native void clearLogs(MenuItem var1);

    public final native void copyLogs(MenuItem var1);

    protected native void onCreate(Bundle var1);
}

