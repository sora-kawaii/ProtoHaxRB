/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$LongRef
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay.gui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import dev.sora.protohax.relay.gui.SelectionMenu;
import dev.sora.protohax.relay.gui.SessionSates;
import dev.sora.relay.cheat.module.CheatModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import np.dcc.protect.EntryPoint;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u001c\u0010 \u001a\u00020\u0014*\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Ldev/sora/protohax/relay/gui/PopupWindow;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "menu", "Ldev/sora/protohax/relay/gui/SelectionMenu;", "menuLayout", "Landroid/view/View;", "sates", "Ldev/sora/protohax/relay/gui/SessionSates;", "satesLayout", "screenSize", "Landroid/graphics/Point;", "getScreenSize", "()Landroid/graphics/Point;", "shortcuts", "", "Ldev/sora/relay/cheat/module/CheatModule;", "SatesDestroy", "", "wm", "Landroid/view/WindowManager;", "SatesDisplay", "SatesToggle", "destroy", "display", "hasShortcut", "", "module", "shortcutFor", "toggle", "draggable", "params", "Landroid/view/WindowManager$LayoutParams;", "windowManager", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class PopupWindow {
    private final Context ctx;
    private final SelectionMenu menu;
    private View menuLayout;
    private final SessionSates sates;
    private View satesLayout;
    private final Point screenSize;
    private final Map<CheatModule, View> shortcuts;

    public static /* synthetic */ boolean $r8$lambda$AxgJ24QNGrZLHUiKuck6pP2d8dc(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, WindowManager.LayoutParams layoutParams, WindowManager windowManager, View view, View view2, MotionEvent motionEvent) {
        String string2 = "\u06eb\u06d9\u06ec\u06e1\u06e0\u06d6\u06da\u06d8\u06e6\u06d8\u06e0\u06e6\u06e2\u06dc\u06e4\u06db\u06e1\u06d7\u06ec";
        block11: while (true) {
            switch (string2.hashCode() ^ 0x309 ^ 0x762492AF) {
                default: {
                    continue block11;
                }
                case -425568496: {
                    string2 = "\u06df\u06d9\u06e6\u06d8\u06d9\u06d8\u06ec\u06da\u06d9\u06e2\u06df\u06e6\u06e7\u06e5\u06d9\u06e1\u06d8\u06ec\u06d6\u06d6\u06d8\u06e7\u06d7\u06db";
                    continue block11;
                }
                case -950190448: {
                    string2 = "\u06ec\u06e8\u06d8\u06e8\u06d7\u06e4\u06d8\u06e2\u06ec\u06e8\u06e7\u06d8\u06e1\u06e8\u06d9\u06d8\u06ec\u06d6\u06df\u06e6\u06e5\u06e1\u06d7\u06d9\u06e6\u06d8\u06e6";
                    continue block11;
                }
                case -1607552439: {
                    string2 = "\u06db\u06dc\u06e4\u06e2\u06e1\u06e8\u06d8\u06df\u06df\u06d6\u06d8\u06d7\u06e0\u06e0\u06d7\u06d8\u06dc\u06d8\u06e2\u06e1\u06e7\u06e8\u06dc\u06dc\u06d8\u06e5\u06ec\u06e5\u06d8\u06df\u06df";
                    continue block11;
                }
                case 404059508: {
                    string2 = "\u06e1\u06e1\u06eb\u06db\u06e2\u06e5\u06d8\u06eb\u06e1\u06e8\u06d6\u06da\u06e6\u06d8\u06eb\u06e1\u06e6\u06d8\u06e2\u06df\u06e4\u06d6\u06d8\u06e7\u06d6\u06d6\u06e6\u06e0\u06d9\u06e5";
                    continue block11;
                }
                case -912765399: {
                    string2 = "\u06d9\u06eb\u06e1\u06e2\u06e0\u06e8\u06d8\u06da\u06d9\u06e0\u06eb\u06e2\u06db\u06d7\u06e1\u06e6";
                    continue block11;
                }
                case -978774982: {
                    string2 = "\u06e5\u06e1\u06df\u06dc\u06d6\u06e7\u06d8\u06db\u06e6\u06d6\u06d8\u06e6\u06e6\u06e4\u06df\u06e5\u06e7\u06d8";
                    continue block11;
                }
                case -1401482970: {
                    string2 = "\u06e6\u06d6\u06e5\u06d8\u06d9\u06d7\u06e7\u06e4\u06e1\u06d9\u06d6\u06ec\u06d9\u06dc\u06e1\u06e8";
                    continue block11;
                }
                case -594201840: {
                    string2 = "\u06e8\u06da\u06ec\u06e5\u06d6\u06e6\u06e6\u06e5\u06ec\u06d7\u06ec\u06dc\u06d8\u06e6\u06e4\u06e5\u06d7\u06d8";
                    continue block11;
                }
                case 1465018147: 
            }
            break;
        }
        return PopupWindow.draggable$lambda-5(floatRef, floatRef2, longRef, layoutParams, windowManager, view, view2, motionEvent);
    }

    public static /* synthetic */ void $r8$lambda$tVyk3VSptJC03pGUKhIvqnONWkE(CheatModule cheatModule, TextView textView, View view) {
        String string2 = "\u06db\u06d7\u06e1\u06d6\u06ec\u06da\u06e8\u06dc\u06db\u06e5\u06db\u06db\u06da\u06e8\u06e4\u06e7\u06eb\u06dc";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x69 ^ 0xE9F26501) {
                default: {
                    continue block7;
                }
                case -246674345: {
                    string2 = "\u06e1\u06d8\u06d8\u06e6\u06e5\u06e5\u06d8\u06e2\u06d9\u06d6\u06d8\u06e2\u06df\u06eb\u06e5\u06db\u06d8\u06d8\u06d6\u06e5";
                    continue block7;
                }
                case -1874557137: {
                    string2 = "\u06e6\u06e2\u06ec\u06d9\u06e0\u06e8\u06e0\u06dc\u06dc\u06d6\u06d8\u06eb\u06e8\u06df\u06ec";
                    continue block7;
                }
                case 1337611571: {
                    string2 = "\u06d9\u06eb\u06da\u06e8\u06db\u06d8\u06e8\u06e7\u06e2\u06da\u06db\u06e1\u06e0\u06d8";
                    continue block7;
                }
                case 749133146: {
                    PopupWindow.shortcutFor$lambda-10(cheatModule, textView, view);
                    string2 = "\u06e0\u06e4\u06d8\u06ec\u06d7\u06d7\u06d6\u06e1\u06d6\u06eb\u06e2\u06e4\u06df\u06e1\u06d8\u06e5\u06db\u06e8\u06d8";
                    continue block7;
                }
                case -2147252342: 
            }
            break;
        }
    }

    static {
        String string2 = "\u06d7\u06db\u06df\u06ec\u06dc\u06e5\u06e5\u06da\u06d7\u06e7\u06eb\u06e2\u06e7\u06dc\u06e5\u06d8\u06df\u06e7\u06d6\u06d8\u06df\u06d7\u06e0\u06e8\u06d9\u06e7";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x306 ^ 0x73D0ED5E) {
                default: {
                    continue block4;
                }
                case 1579283342: {
                    EntryPoint.stub((int)54);
                    string2 = "\u06d8\u06da\u06ec\u06d6\u06d7\u06e5\u06d8\u06e7\u06eb\u06e5\u06d8\u06e6\u06e2\u06e7\u06e5\u06e6\u06e2\u06da\u06e0\u06d6\u06d9\u06e1\u06d6\u06ec\u06e1\u06eb\u06e4\u06eb\u06d9";
                    continue block4;
                }
                case 1657600477: 
            }
            break;
        }
    }

    public PopupWindow(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"ctx");
        this.ctx = context;
        this.menu = new SelectionMenu(this);
        this.sates = new SessionSates(this);
        this.shortcuts = new LinkedHashMap();
        this.screenSize = new Point();
    }

    private final native void draggable(View var1, WindowManager.LayoutParams var2, WindowManager var3);

    /*
     * Exception decompiling
     */
    private static final boolean draggable$lambda-5(Ref.FloatRef var0, Ref.FloatRef var1_1, Ref.LongRef var2_2, WindowManager.LayoutParams var3_3, WindowManager var4_4, View var5_5, View var6_6, MotionEvent var7_7) {
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

    private final native Point getScreenSize(WindowManager var1);

    private static final native void shortcutFor$lambda-10(CheatModule var0, TextView var1, View var2);

    private static final native void shortcutFor$updateTextColor(TextView var0, CheatModule var1);

    public final native void SatesDestroy(WindowManager var1);

    public final native void SatesDisplay(WindowManager var1, Context var2);

    public final native void SatesToggle(WindowManager var1, Context var2);

    public final native void destroy(WindowManager var1);

    public final native void display(WindowManager var1, Context var2);

    public final native Point getScreenSize();

    public final native boolean hasShortcut(CheatModule var1);

    public final native boolean shortcutFor(CheatModule var1);

    public final native void toggle(WindowManager var1, Context var2);
}

