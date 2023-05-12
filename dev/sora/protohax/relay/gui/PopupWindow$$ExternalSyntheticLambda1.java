/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  kotlin.jvm.internal.Ref$LongRef
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay.gui;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import kotlin.jvm.internal.Ref;
import np.dcc.protect.EntryPoint;

public final class PopupWindow$$ExternalSyntheticLambda1
implements View.OnTouchListener {
    public final Ref.FloatRef f$0;
    public final Ref.FloatRef f$1;
    public final Ref.LongRef f$2;
    public final WindowManager.LayoutParams f$3;
    public final WindowManager f$4;
    public final View f$5;

    static {
        String string2 = "\u06e2\u06d9\u06df\u06e6\u06dc\u06e0\u06db\u06e7\u06d7\u06e2\u06d9\u06e6\u06d6\u06e7\u06da\u06df\u06e0\u06e7\u06d8\u06e7\u06e2\u06e2\u06d6\u06db\u06e8";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x49 ^ 0x33A41BDC) {
                default: {
                    continue block4;
                }
                case 1836065892: {
                    EntryPoint.stub((int)53);
                    string2 = "\u06e2\u06db\u06e6\u06d8\u06db\u06da\u06e8\u06d8\u06e7\u06df\u06e6\u06d8\u06ec\u06e2\u06dc\u06d8\u06eb\u06db\u06e5";
                    continue block4;
                }
                case 893907338: 
            }
            break;
        }
    }

    public /* synthetic */ PopupWindow$$ExternalSyntheticLambda1(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, WindowManager.LayoutParams layoutParams, WindowManager windowManager, View view) {
        this.f$0 = floatRef;
        this.f$1 = floatRef2;
        this.f$2 = longRef;
        this.f$3 = layoutParams;
        this.f$4 = windowManager;
        this.f$5 = view;
    }

    public final native boolean onTouch(View var1, MotionEvent var2);
}

