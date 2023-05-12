/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager$LayoutParams
 *  android.widget.LinearLayout
 *  kotlin.jvm.internal.Ref$LongRef
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import dev.sora.protohax.AppService;
import kotlin.jvm.internal.Ref;
import np.dcc.protect.EntryPoint;

public final class AppService$$ExternalSyntheticLambda1
implements View.OnTouchListener {
    public final Ref.FloatRef f$0;
    public final Ref.FloatRef f$1;
    public final Ref.LongRef f$2;
    public final WindowManager.LayoutParams f$3;
    public final AppService f$4;
    public final LinearLayout f$5;

    static {
        String string2 = "\u06da\u06e4\u06e1\u06d6\u06dc\u06eb\u06e1\u06ec\u06e5\u06d8\u06dc\u06dc\u06e2\u06ec\u06dc\u06da\u06e1\u06e8\u06d7";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x4B ^ 0xE4A4A7A1) {
                default: {
                    continue block4;
                }
                case 1939518582: {
                    EntryPoint.stub((int)17);
                    string2 = "\u06e6\u06e6\u06ec\u06dc\u06e1\u06e8\u06d8\u06d8\u06db\u06e7\u06e7\u06db\u06d6\u06e8\u06ec\u06d8\u06e5\u06da\u06eb\u06df\u06e8\u06e7\u06e2\u06e2\u06d6\u06d8";
                    continue block4;
                }
                case -625471915: 
            }
            break;
        }
    }

    public /* synthetic */ AppService$$ExternalSyntheticLambda1(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, WindowManager.LayoutParams layoutParams, AppService appService, LinearLayout linearLayout) {
        this.f$0 = floatRef;
        this.f$1 = floatRef2;
        this.f$2 = longRef;
        this.f$3 = layoutParams;
        this.f$4 = appService;
        this.f$5 = linearLayout;
    }

    public final native boolean onTouch(View var1, MotionEvent var2);
}

