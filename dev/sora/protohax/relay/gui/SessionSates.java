/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.view.View
 *  android.view.WindowManager
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay.gui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import dev.sora.protohax.relay.gui.PopupWindow;
import java.time.LocalDate;
import java.time.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np.dcc.protect.EntryPoint;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J*\u0010$\u001a\u00020%*\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020)H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u00130\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f\u00a8\u0006+"}, d2={"Ldev/sora/protohax/relay/gui/SessionSates;", "", "window", "Ldev/sora/protohax/relay/gui/PopupWindow;", "(Ldev/sora/protohax/relay/gui/PopupWindow;)V", "User", "", "getUser", "()Ljava/lang/String;", "day", "", "getDay", "()I", "month", "Ljava/time/Month;", "kotlin.jvm.PlatformType", "getMonth", "()Ljava/time/Month;", "now", "Ljava/time/LocalDate;", "getNow", "()Ljava/time/LocalDate;", "year", "getYear", "apply", "", "ctx", "Landroid/content/Context;", "layout", "Landroid/widget/LinearLayout;", "wm", "Landroid/view/WindowManager;", "getStateListDrawable", "Landroid/content/res/ColorStateList;", "normalColor", "pressedColor", "themedButton", "Landroid/widget/Button;", "backgroundColor", "textColor", "ripples", "", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class SessionSates {
    private static final int BACKGROUND_COLOR;
    private static final int BACKGROUND_COLOR_PRIMARY;
    public static final Companion Companion;
    private static final int RIPPLE_COLOR;
    private static final int TEXT_COLOR;
    private static final int THEME_COLOR;
    private final String User;
    private final int day;
    private final Month month;
    private final LocalDate now;
    private final PopupWindow window;
    private final int year;

    public static /* synthetic */ void $r8$lambda$QEX8XRNbY-Uj1pOLliUxzxOaqQs(SessionSates sessionSates, WindowManager windowManager, View view) {
        String string2 = "\u06e0\u06e4\u06e6\u06eb\u06db\u06d9\u06e6\u06dc\u06e5\u06d8\u06e2\u06e1\u06dc\u06d9\u06da\u06e1\u06d6\u06da\u06e4\u06e8\u06ec\u06e4\u06df\u06e5\u06d8";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x2BB ^ 0xF4131D62) {
                default: {
                    continue block7;
                }
                case 1498323462: {
                    string2 = "\u06d8\u06e4\u06e5\u06db\u06e2\u06ec\u06d9\u06db\u06d9\u06e1\u06eb\u06e1\u06e2\u06db\u06dc";
                    continue block7;
                }
                case -267804178: {
                    string2 = "\u06d9\u06dc\u06e5\u06d8\u06e1\u06da\u06d6\u06d8\u06e1\u06e5\u06e8\u06d8\u06e1\u06e2\u06d8\u06d8\u06e6\u06df\u06da\u06dc\u06dc\u06e6\u06e4\u06d8\u06d8\u06e6\u06db\u06e0";
                    continue block7;
                }
                case 202010731: {
                    string2 = "\u06ec\u06e1\u06d6\u06d9\u06e1\u06e7\u06d8\u06e0\u06e4\u06df\u06d9\u06e2\u06e1\u06d8\u06dc\u06e6\u06e2\u06e6\u06df\u06e1\u06db\u06e5\u06d7\u06dc\u06d6\u06e8";
                    continue block7;
                }
                case -433025813: {
                    SessionSates.apply$lambda-2$lambda-1(sessionSates, windowManager, view);
                    string2 = "\u06d8\u06e5\u06ec\u06d8\u06e5\u06e2\u06e8\u06dc\u06da\u06d8\u06e7\u06e1\u06d8\u06ec\u06d6\u06d8\u06e1\u06e7\u06d8\u06ec\u06e6\u06e8\u06eb\u06d7\u06e2\u06e6\u06e8\u06da";
                    continue block7;
                }
                case -1991295185: 
            }
            break;
        }
    }

    static {
        String string2 = "\u06dc\u06d7\u06e0\u06d6\u06db\u06e2\u06df\u06d8\u06ec\u06ec\u06e5\u06e5\u06e1\u06e1\u06d8\u06e1\u06df\u06d9\u06e4\u06db\u06e5\u06d8\u06ec\u06e6\u06dc\u06e6";
        block10: while (true) {
            switch (string2.hashCode() ^ 0x294 ^ 0x38D7BA50) {
                default: {
                    continue block10;
                }
                case -839592730: {
                    EntryPoint.stub((int)45);
                    string2 = "\u06d9\u06eb\u06e8\u06d8\u06e4\u06e8\u06db\u06d8\u06eb\u06e0\u06d7\u06e8\u06df\u06e2\u06da\u06eb\u06ec\u06dc\u06e8\u06d8";
                    continue block10;
                }
                case -340765671: {
                    Companion = new Companion(null);
                    string2 = "\u06d8\u06e8\u06d8\u06eb\u06eb\u06db\u06e8\u06e7\u06e7\u06e6\u06e5\u06e2\u06e4\u06d8\u06d8\u06d9\u06d6\u06df\u06d9\u06e5\u06dc\u06d8\u06e4\u06da\u06ec\u06eb\u06e4\u06d6";
                    continue block10;
                }
                case -234079297: {
                    TEXT_COLOR = Color.parseColor((String)"#FFFFFF");
                    string2 = "\u06d6\u06db\u06e5\u06d8\u06e8\u06d6\u06d8\u06da\u06d8\u06d6\u06e6\u06e5\u06eb\u06d8\u06e1\u06d6\u06e8\u06e8";
                    continue block10;
                }
                case -673659549: {
                    BACKGROUND_COLOR_PRIMARY = Color.parseColor((String)"#CC000000");
                    string2 = "\u06e4\u06d7\u06d8\u06eb\u06da\u06e0\u06ec\u06d6\u06e2\u06dc\u06ec\u06da\u06e2\u06e8\u06e5";
                    continue block10;
                }
                case -342752443: {
                    BACKGROUND_COLOR = Color.parseColor((String)"#CC000000");
                    string2 = "\u06e1\u06e5\u06e4\u06ec\u06e0\u06d6\u06d8\u06d8\u06e5\u06e6\u06e7\u06e0\u06dc\u06db\u06e5\u06d6\u06d8\u06da\u06eb\u06e1\u06d8\u06df\u06e7\u06eb";
                    continue block10;
                }
                case -1515112597: {
                    RIPPLE_COLOR = Color.parseColor((String)"#888888");
                    string2 = "\u06db\u06d7\u06ec\u06e6\u06e6\u06e8\u06e0\u06ec\u06ec\u06eb\u06e5\u06d6\u06d9\u06e6\u06d8\u06d8\u06da\u06df\u06e7\u06e0\u06e5\u06dc\u06d8\u06e0\u06e1\u06d8\u06d8";
                    continue block10;
                }
                case -506929401: {
                    THEME_COLOR = Color.parseColor((String)"#FFFFFF");
                    string2 = "\u06da\u06db\u06e5\u06d8\u06d9\u06d7\u06e8\u06eb\u06d6\u06e7\u06e7\u06d8\u06e8\u06e2\u06d9\u06eb\u06e5\u06db\u06df\u06e1\u06d8\u06d6\u06da\u06ec\u06eb\u06e7\u06d7";
                    continue block10;
                }
                case -1239734828: 
            }
            break;
        }
    }

    public SessionSates(PopupWindow object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"window");
        this.window = object;
        this.now = object = LocalDate.now();
        this.year = ((LocalDate)object).getYear();
        this.month = ((LocalDate)object).getMonth();
        this.day = ((LocalDate)object).getDayOfMonth();
        this.User = "Public V0.0.1";
    }

    public static final /* synthetic */ int access$getBACKGROUND_COLOR$cp() {
        String string2 = "\u06e8\u06e5\u06dc\u06e6\u06e1\u06d7\u06e5\u06ec\u06e6\u06e1\u06df\u06e5\u06d8\u06e8\u06ec\u06eb\u06e0\u06e1\u06d6\u06d8\u06eb\u06e8\u06ec";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x148 ^ 0xFFC6B7C0) {
                default: {
                    continue block3;
                }
                case -1045605168: 
            }
            break;
        }
        return BACKGROUND_COLOR;
    }

    public static final /* synthetic */ int access$getBACKGROUND_COLOR_PRIMARY$cp() {
        String string2 = "\u06e4\u06ec\u06e8\u06d8\u06d7\u06d9\u06d8\u06d8\u06d9\u06d7\u06d9\u06d8\u06df\u06e5\u06e0\u06e1\u06da\u06e8\u06d6\u06da";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x1A0 ^ 0x933001A3) {
                default: {
                    continue block3;
                }
                case 779651347: 
            }
            break;
        }
        return BACKGROUND_COLOR_PRIMARY;
    }

    public static final /* synthetic */ int access$getRIPPLE_COLOR$cp() {
        String string2 = "\u06e5\u06ec\u06e4\u06e7\u06d8\u06e6\u06d8\u06d9\u06e6\u06e5\u06d8\u06d7\u06d7\u06da\u06e1\u06d7\u06db";
        block3: while (true) {
            switch (string2.hashCode() ^ 0xB ^ 0xCC00EF17) {
                default: {
                    continue block3;
                }
                case 966421175: 
            }
            break;
        }
        return RIPPLE_COLOR;
    }

    public static final /* synthetic */ int access$getTEXT_COLOR$cp() {
        String string2 = "\u06dc\u06e1\u06e1\u06d9\u06ec\u06d8\u06d8\u06e5\u06eb\u06e5\u06e4\u06eb\u06d6\u06d8\u06e5\u06ec\u06e7\u06e2\u06da\u06d6";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x158 ^ 0x573AC1F8) {
                default: {
                    continue block3;
                }
                case -1759860009: 
            }
            break;
        }
        return TEXT_COLOR;
    }

    public static final /* synthetic */ int access$getTHEME_COLOR$cp() {
        String string2 = "\u06d6\u06e0\u06e2\u06e1\u06df\u06e8\u06d9\u06dc\u06d8\u06ec\u06e2\u06d7\u06da\u06e6\u06e1\u06d8\u06da\u06e0\u06dc\u06eb\u06dc\u06e6\u06e5\u06d9\u06e4";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x1A5 ^ 0x6A3B6DE7) {
                default: {
                    continue block3;
                }
                case 987962290: 
            }
            break;
        }
        return THEME_COLOR;
    }

    private static final native void apply$lambda-2$lambda-1(SessionSates var0, WindowManager var1, View var2);

    private final native ColorStateList getStateListDrawable(int var1, int var2);

    private final native Button themedButton(Context var1, int var2, int var3, boolean var4);

    /*
     * Exception decompiling
     */
    static /* synthetic */ Button themedButton$default(SessionSates var0, Context var1_1, int var2_2, int var3_3, boolean var4_4, int var5_5, Object var6_6) {
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
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final native void apply(Context var1, LinearLayout var2, WindowManager var3);

    public final native int getDay();

    public final native Month getMonth();

    public final native LocalDate getNow();

    public final native String getUser();

    public final native int getYear();

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2={"Ldev/sora/protohax/relay/gui/SessionSates$Companion;", "", "()V", "BACKGROUND_COLOR", "", "getBACKGROUND_COLOR", "()I", "BACKGROUND_COLOR_PRIMARY", "getBACKGROUND_COLOR_PRIMARY", "RIPPLE_COLOR", "getRIPPLE_COLOR", "TEXT_COLOR", "getTEXT_COLOR", "THEME_COLOR", "getTHEME_COLOR", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        static {
            String string2 = "\u06da\u06d7\u06eb\u06df\u06d9\u06ec\u06e1\u06dc\u06d6\u06d8\u06e0\u06e7\u06dc\u06d9\u06d8\u06e6\u06da\u06e6\u06e6\u06d8\u06da\u06e7\u06e6\u06d8";
            block4: while (true) {
                switch (string2.hashCode() ^ 0xE5 ^ 0xF1DC3009) {
                    default: {
                        continue block4;
                    }
                    case -1827164708: {
                        EntryPoint.stub((int)44);
                        string2 = "\u06e7\u06e2\u06df\u06e8\u06e2\u06dc\u06d7\u06d9\u06e6\u06e7\u06dc\u06ec\u06e0\u06e5\u06ec";
                        continue block4;
                    }
                    case 1018640858: 
                }
                break;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final native int getBACKGROUND_COLOR();

        public final native int getBACKGROUND_COLOR_PRIMARY();

        public final native int getRIPPLE_COLOR();

        public final native int getTEXT_COLOR();

        public final native int getTHEME_COLOR();
    }
}

