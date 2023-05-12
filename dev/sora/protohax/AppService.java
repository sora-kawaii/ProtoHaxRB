/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.LinearLayout
 *  com.stub.StubApp
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Ref$LongRef
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.app.Notification;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.github.megatronking.netbare.NetBareService;
import com.stub.StubApp;
import dev.sora.protohax.relay.gui.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import np.dcc.protect.EntryPoint;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0005\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ldev/sora/protohax/AppService;", "Lcom/github/megatronking/netbare/NetBareService;", "()V", "layoutView", "Landroid/view/View;", "popupWindow", "Ldev/sora/protohax/relay/gui/PopupWindow;", "windowManager", "Landroid/view/WindowManager;", "createNotification", "Landroid/app/Notification;", "notificationId", "", "onCreate", "", "onServiceStart", "onServiceStop", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class AppService
extends NetBareService {
    public static final String CHANNEL_ID = "dev.sora.protohax.NOTIFICATION_CHANNEL_ID";
    public static final Companion Companion;
    private View layoutView;
    private final PopupWindow popupWindow = new PopupWindow((Context)this);
    private WindowManager windowManager;

    public static /* synthetic */ boolean $r8$lambda$HHYe7w-s2_c562Yto-lX9LjYIdo(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, WindowManager.LayoutParams layoutParams, AppService appService, LinearLayout linearLayout, View view, MotionEvent motionEvent) {
        String string2 = "\u06e8\u06eb\u06ec\u06e0\u06dc\u06e8\u06d8\u06e0\u06e8\u06e8\u06ec\u06d8\u06ec\u06da\u06e7\u06e8\u06e1\u06e0\u06dc\u06dc\u06d9\u06d7\u06da\u06d6\u06d8";
        block11: while (true) {
            switch (string2.hashCode() ^ 0x3B5 ^ 0xB5005107) {
                default: {
                    continue block11;
                }
                case 1128047051: {
                    string2 = "\u06e5\u06d6\u06ec\u06e8\u06e0\u06db\u06da\u06e7\u06e0\u06e5\u06da\u06e0\u06dc\u06e0";
                    continue block11;
                }
                case -1818920874: {
                    string2 = "\u06df\u06e8\u06d6\u06d8\u06e2\u06d8\u06d8\u06d7\u06e5\u06dc\u06e7\u06d9\u06db\u06ec\u06eb\u06d6\u06d8\u06e4\u06e0\u06d7\u06da\u06d9\u06eb\u06e5\u06d9";
                    continue block11;
                }
                case -274978070: {
                    string2 = "\u06e7\u06dc\u06e1\u06e4\u06e6\u06e2\u06e6\u06d6\u06db\u06e5\u06d8\u06e1\u06d8\u06d7\u06d6\u06df\u06e1\u06df";
                    continue block11;
                }
                case -546433969: {
                    string2 = "\u06da\u06eb\u06e1\u06d8\u06d7\u06e4\u06e6\u06d8\u06e2\u06e8\u06d6\u06d8\u06df\u06eb\u06ec\u06d9\u06db\u06e6\u06d8\u06d6\u06d8\u06dc\u06d9\u06db\u06e4\u06eb\u06df\u06d7";
                    continue block11;
                }
                case 1990363492: {
                    string2 = "\u06eb\u06e7\u06d6\u06e2\u06d6\u06eb\u06e2\u06e1\u06e8\u06d9\u06dc\u06e5\u06d8\u06e8\u06eb\u06db\u06dc\u06e2\u06eb\u06d8\u06e7\u06e1\u06e6\u06d6\u06e5\u06d8\u06df\u06e4\u06d8";
                    continue block11;
                }
                case -1049493953: {
                    string2 = "\u06d8\u06eb\u06d6\u06e6\u06df\u06dc\u06d8\u06e0\u06e2\u06e1\u06e5\u06d8\u06e0\u06e0\u06e7\u06dc\u06d6\u06db\u06e6\u06d8\u06eb\u06da\u06e1";
                    continue block11;
                }
                case 1954807934: {
                    string2 = "\u06eb\u06e1\u06e1\u06d6\u06d6\u06eb\u06d6\u06eb\u06d9\u06e1\u06e0\u06e2\u06eb\u06df\u06e5\u06d8\u06e4\u06da\u06e7\u06e0\u06e8\u06e5\u06e8\u06eb\u06df\u06d7\u06da";
                    continue block11;
                }
                case 302202719: {
                    string2 = "\u06d7\u06da\u06d6\u06df\u06e1\u06d8\u06e5\u06df\u06e6\u06d8\u06ec\u06dc\u06d9\u06eb\u06dc\u06e0\u06d7\u06d7";
                    continue block11;
                }
                case 602697703: 
            }
            break;
        }
        return AppService.popupWindow$lambda-3(floatRef, floatRef2, longRef, layoutParams, appService, linearLayout, view, motionEvent);
    }

    public static /* synthetic */ void $r8$lambda$a6iNWGi4dmZSm0BaN3C0MuewkU8(AppService appService, View view) {
        String string2 = "\u06d8\u06e2\u06e4\u06e5\u06d9\u06e1\u06d8\u06ec\u06e6\u06dc\u06d8\u06e5\u06e7\u06e7\u06e8\u06e8\u06d8";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x2BB ^ 0xA8CF3D8F) {
                default: {
                    continue block6;
                }
                case 203803546: {
                    string2 = "\u06eb\u06d8\u06eb\u06e8\u06ec\u06e2\u06e2\u06e0\u06e8\u06d8\u06db\u06d9\u06e4\u06ec\u06dc\u06eb\u06ec\u06e1\u06ec";
                    continue block6;
                }
                case 262124032: {
                    string2 = "\u06d6\u06ec\u06e5\u06d8\u06e4\u06d8\u06dc\u06e2\u06e0\u06d6\u06e7\u06e0\u06e7\u06eb\u06e5\u06e8\u06e4\u06eb\u06db\u06e4\u06e8\u06e2";
                    continue block6;
                }
                case -1910247145: {
                    AppService.popupWindow$lambda-2(appService, view);
                    string2 = "\u06d9\u06eb\u06d6\u06ec\u06e0\u06dc\u06d8\u06d7\u06eb\u06d7\u06e1\u06ec\u06e5\u06e5\u06e0\u06df\u06da\u06e8\u06eb\u06d8\u06e7\u06d8\u06d8\u06d9\u06ec\u06d6\u06e4\u06da\u06e6";
                    continue block6;
                }
                case -286718924: 
            }
            break;
        }
    }

    static {
        StubApp.interface11((int)2979);
        String string2 = "\u06e1\u06da\u06d6\u06d8\u06d9\u06e5\u06e0\u06e5\u06eb\u06e5\u06e0\u06df\u06e5\u06e0\u06da\u06e1\u06d8\u06e4\u06e4\u06dc\u06da\u06df\u06d6\u06d9\u06da\u06e0";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x25F ^ 0xFF01BEF2) {
                default: {
                    continue block5;
                }
                case 1205388596: {
                    EntryPoint.stub((int)18);
                    string2 = "\u06d8\u06e7\u06da\u06e6\u06e7\u06e5\u06ec\u06db\u06d6\u06d8\u06eb\u06e7\u06e8\u06d8\u06ec\u06e5\u06e5\u06db\u06e4\u06e7\u06d9\u06d9\u06e2";
                    continue block5;
                }
                case 1553471255: {
                    Companion = new Companion(null);
                    string2 = "\u06e5\u06d7\u06d6\u06d8\u06d8\u06da\u06db\u06e1\u06d9\u06e0\u06db\u06dc\u06e1\u06da\u06e7\u06e1\u06d8\u06e6\u06e6\u06d8\u06e0\u06e1\u06e8";
                    continue block5;
                }
                case -625569763: 
            }
            break;
        }
    }

    private final native void popupWindow();

    private static final native void popupWindow$lambda-2(AppService var0, View var1);

    /*
     * Exception decompiling
     */
    private static final boolean popupWindow$lambda-3(Ref.FloatRef var0, Ref.FloatRef var1_1, Ref.LongRef var2_2, WindowManager.LayoutParams var3_3, AppService var4_4, LinearLayout var5_5, View var6_6, MotionEvent var7_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    protected native Notification createNotification();

    @Override
    protected native int notificationId();

    public native void onCreate();

    @Override
    protected native void onServiceStart();

    @Override
    protected native void onServiceStop();

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Ldev/sora/protohax/AppService$Companion;", "", "()V", "CHANNEL_ID", "", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

