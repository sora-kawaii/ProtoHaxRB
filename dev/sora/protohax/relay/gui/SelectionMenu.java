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
 *  android.widget.SeekBar
 *  kotlin.jvm.functions.Function1
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
import android.widget.SeekBar;
import dev.sora.protohax.relay.gui.PopupWindow;
import dev.sora.protohax.util.Gpw;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.Value;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np.dcc.protect.EntryPoint;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J*\u0010\u001e\u001a\u00020\n*\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u00192\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0!H\u0002JY\u0010\"\u001a\u00020\n*\u00020#2K\u0010 \u001aG\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\n0$H\u0002J*\u0010*\u001a\u00020\u001d*\u00020\f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Ldev/sora/protohax/relay/gui/SelectionMenu;", "", "window", "Ldev/sora/protohax/relay/gui/PopupWindow;", "(Ldev/sora/protohax/relay/gui/PopupWindow;)V", "buttonList", "Landroid/widget/LinearLayout;", "currentConfig", "", "addTabsMenu", "", "ctx", "Landroid/content/Context;", "menuTabs", "advisedWidth", "", "apply", "layout", "wm", "Landroid/view/WindowManager;", "getStateListDrawable", "Landroid/content/res/ColorStateList;", "normalColor", "pressedColor", "moduleValues", "", "module", "Ldev/sora/relay/cheat/module/CheatModule;", "backButton", "Landroid/widget/Button;", "normalOnClickListener", "trigger", "callback", "Lkotlin/Function1;", "onProgressChanged", "Landroid/widget/SeekBar;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "seekbar", "progress", "fromUser", "themedButton", "backgroundColor", "textColor", "ripples", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class SelectionMenu {
    private static final int BACKGROUND_COLOR;
    private static final int BACKGROUND_COLOR_PRIMARY;
    public static final Companion Companion;
    private static final int RIPPLE_COLOR;
    private static final int TEXT_COLOR;
    private static final int THEME_COLOR;
    private static final String TOGGLE_OFF_COLOR = "#ADADAD";
    private static final int TOGGLE_OFF_COLOR_RGB;
    private static final String TOGGLE_ON_COLOR = "#FFFFFF";
    private static final int TOGGLE_ON_COLOR_RGB;
    private LinearLayout buttonList;
    private String currentConfig;
    private final PopupWindow window;

    public static /* synthetic */ void $r8$lambda$99YkqjY106M4U3vF1pXal5tFoQY(SelectionMenu selectionMenu, WindowManager windowManager, View view) {
        String string2 = "\u06d6\u06db\u06e8\u06d8\u06da\u06ec\u06e2\u06e1\u06df\u06e5\u06e5\u06e8\u06e5\u06d6\u06d7\u06d6\u06d8\u06db\u06eb\u06d7\u06da\u06e5\u06e5\u06d8";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x165 ^ 0x4016D9FC) {
                default: {
                    continue block7;
                }
                case 1180138613: {
                    string2 = "\u06e4\u06d7\u06d6\u06d8\u06e5\u06e4\u06d6\u06e1\u06e7\u06d6\u06d8\u06df\u06e6\u06dc\u06eb\u06dc\u06ec\u06ec\u06db\u06eb";
                    continue block7;
                }
                case -1689911883: {
                    string2 = "\u06d9\u06ec\u06e8\u06d8\u06e7\u06e5\u06e5\u06e2\u06d9\u06e8\u06d8\u06e7\u06e5\u06e8\u06da\u06d7\u06da";
                    continue block7;
                }
                case 2106941767: {
                    string2 = "\u06da\u06eb\u06e2\u06db\u06e4\u06e8\u06e8\u06e5\u06e8\u06d8\u06d9\u06d6\u06ec\u06e0\u06e2\u06e8\u06d8\u06e8\u06e6";
                    continue block7;
                }
                case -131851747: {
                    SelectionMenu.apply$lambda-2$lambda-1(selectionMenu, windowManager, view);
                    string2 = "\u06e2\u06d7\u06db\u06d7\u06e0\u06e2\u06e0\u06d9\u06e5\u06d8\u06eb\u06db\u06d9\u06db\u06e6\u06da\u06e1\u06ec\u06e4";
                    continue block7;
                }
                case 206865709: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$AglW_ogLr-7ObGjfd08LCzO_wtA(Value value, Button button, View view) {
        String string2 = "\u06d8\u06dc\u06d6\u06d8\u06d8\u06db\u06e1\u06e6\u06eb\u06e1\u06e5\u06e1\u06e6\u06d8\u06e2\u06e2\u06da";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x2F ^ 0x62102AB) {
                default: {
                    continue block7;
                }
                case -230221428: {
                    string2 = "\u06d8\u06d9\u06e8\u06e1\u06df\u06e8\u06d8\u06e5\u06d9\u06d6\u06da\u06e1\u06e6\u06dc\u06e2\u06df\u06d8\u06dc\u06d8";
                    continue block7;
                }
                case -177920919: {
                    string2 = "\u06d7\u06d9\u06dc\u06d8\u06e0\u06df\u06d6\u06d8\u06d7\u06ec\u06e6\u06eb\u06d8\u06e6\u06d8\u06e7\u06e0\u06eb\u06e4\u06e5\u06d8";
                    continue block7;
                }
                case 395531218: {
                    string2 = "\u06ec\u06d8\u06d8\u06d8\u06e7\u06eb\u06e7\u06d6\u06eb\u06ec\u06da\u06eb\u06d7\u06df\u06db\u06dc\u06d7\u06df\u06da\u06e1\u06d9";
                    continue block7;
                }
                case -1192987276: {
                    SelectionMenu.moduleValues$lambda-15$lambda-12(value, button, view);
                    string2 = "\u06e0\u06e1\u06da\u06e7\u06dc\u06d9\u06dc\u06e7\u06d6\u06d8\u06e1\u06eb\u06e5\u06d8\u06db\u06e8";
                    continue block7;
                }
                case 1856500486: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$YnIRa-WPM9zZ7tD8v9-PiXqsBnw(Button button, View view) {
        String string2 = "\u06ec\u06e6\u06e6\u06d8\u06ec\u06d9\u06dc\u06d8\u06dc\u06e7\u06e5\u06e2\u06e6\u06e6\u06d8\u06e1\u06e1\u06e7\u06d8";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x3DB ^ 0x8D17B2DF) {
                default: {
                    continue block6;
                }
                case 1687067432: {
                    string2 = "\u06e2\u06db\u06dc\u06e4\u06d6\u06e5\u06d8\u06da\u06d8\u06dc\u06d8\u06da\u06df\u06d7\u06eb\u06e1\u06e6\u06e8\u06e8\u06d8\u06e1\u06d8\u06e7\u06d8\u06e1\u06e2\u06eb\u06db\u06e5\u06d6";
                    continue block6;
                }
                case 1413888038: {
                    string2 = "\u06d6\u06e6\u06da\u06e2\u06dc\u06e1\u06d8\u06df\u06d7\u06e1\u06d8\u06e0\u06e7\u06e1\u06d8\u06d6\u06d7\u06d9\u06e5\u06e8\u06e5\u06d8\u06d8\u06e0\u06e5\u06d8";
                    continue block6;
                }
                case 32427173: {
                    SelectionMenu.moduleValues$lambda-17$lambda-16(button, view);
                    string2 = "\u06d7\u06dc\u06df\u06d9\u06e5\u06e2\u06d9\u06db\u06d6\u06e7\u06d9\u06e5\u06eb\u06ec\u06dc";
                    continue block6;
                }
                case 506348420: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$d1VTyuz7nfDgWOLzMSKS7Fn-ayY(SelectionMenu selectionMenu, Function1 function1, View view) {
        String string2 = "\u06da\u06e0\u06d6\u06e7\u06db\u06e5\u06d8\u06dc\u06d6\u06e5\u06d8\u06d7\u06d9\u06db\u06d7\u06ec\u06ec";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x17D ^ 0x9549BA69) {
                default: {
                    continue block7;
                }
                case -884429674: {
                    string2 = "\u06d7\u06df\u06e8\u06d9\u06eb\u06df\u06e4\u06dc\u06df\u06e7\u06e5\u06d8\u06db\u06e0\u06e4\u06da\u06e7\u06e7\u06d9\u06e1\u06e8\u06d8";
                    continue block7;
                }
                case -1377067929: {
                    string2 = "\u06ec\u06e7\u06e5\u06e4\u06d7\u06e8\u06d8\u06e2\u06e0\u06d8\u06e7\u06e7\u06dc\u06d8\u06e8\u06df\u06d9\u06d6\u06e1\u06e8\u06d8";
                    continue block7;
                }
                case -800483104: {
                    string2 = "\u06d9\u06e4\u06df\u06d9\u06df\u06d8\u06d8\u06db\u06e0\u06e6\u06d9\u06e8\u06e7\u06d8\u06e1\u06d6\u06e1";
                    continue block7;
                }
                case -597532111: {
                    SelectionMenu.normalOnClickListener$lambda-18(selectionMenu, function1, view);
                    string2 = "\u06e4\u06d6\u06db\u06e6\u06e7\u06dc\u06e7\u06d8\u06d8\u06e6\u06e4\u06e5\u06db\u06e5\u06e4\u06df\u06e1\u06e8\u06d8\u06e4\u06da\u06d9\u06d6\u06e2\u06e5\u06dc\u06ec";
                    continue block7;
                }
                case 1147449012: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$zTxyhQSx4XfLQ3nQ6E9_w3shhZ4(Value value, Button button, View view) {
        String string2 = "\u06e7\u06eb\u06e2\u06d9\u06e0\u06dc\u06d8\u06dc\u06ec\u06e8\u06e5\u06e4\u06db\u06e0\u06da\u06e1\u06eb\u06d7\u06e6\u06e1\u06e8\u06d7\u06e0\u06e0";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x177 ^ 0x9BB2DC87) {
                default: {
                    continue block7;
                }
                case 1700629672: {
                    string2 = "\u06d6\u06e5\u06d6\u06e5\u06db\u06d9\u06e0\u06df\u06e5\u06d9\u06e8\u06e4\u06dc\u06e6\u06e8\u06d8\u06d9\u06e5\u06d8\u06e2\u06e7\u06dc\u06d8";
                    continue block7;
                }
                case -175023560: {
                    string2 = "\u06e8\u06e5\u06dc\u06ec\u06d6\u06d6\u06e8\u06e0\u06d9\u06d7\u06e0\u06d6\u06d8\u06e8\u06e7\u06e8\u06e6\u06da\u06ec\u06e0\u06e8\u06e2";
                    continue block7;
                }
                case -1244275108: {
                    string2 = "\u06e8\u06d6\u06d7\u06e2\u06d8\u06da\u06dc\u06e7\u06df\u06d9\u06db\u06df\u06e4\u06e8\u06e4";
                    continue block7;
                }
                case -1523410612: {
                    SelectionMenu.moduleValues$lambda-15$lambda-8$lambda-7(value, button, view);
                    string2 = "\u06e2\u06d7\u06e4\u06e6\u06e8\u06dc\u06d8\u06e8\u06d8\u06e8\u06df\u06e1\u06e1\u06d8\u06d6\u06e5\u06e5\u06e7\u06e4\u06d8\u06d8\u06dc\u06d7\u06df\u06e5\u06db\u06e4";
                    continue block7;
                }
                case -912766039: 
            }
            break;
        }
    }

    static {
        String string2 = "\u06ec\u06e7\u06d6\u06e1\u06db\u06e0\u06d9\u06e0\u06e7\u06eb\u06dc\u06d8\u06e4\u06e4\u06dc";
        block12: while (true) {
            switch (string2.hashCode() ^ 0x331 ^ 0x8661A5E) {
                default: {
                    continue block12;
                }
                case 1371456389: {
                    EntryPoint.stub((int)34);
                    string2 = "\u06e4\u06e4\u06e0\u06e5\u06e0\u06df\u06e8\u06eb\u06e6\u06e7\u06da\u06e7\u06e6\u06e7\u06d8\u06d8\u06db\u06e0\u06e5\u06d9\u06e5\u06e6\u06e7\u06e5";
                    continue block12;
                }
                case 421806945: {
                    Companion = new Companion(null);
                    string2 = "\u06e0\u06e2\u06d7\u06ec\u06e6\u06e4\u06d7\u06e2\u06d6\u06d9\u06da\u06e6\u06d8\u06ec\u06dc\u06dc\u06d8\u06e0\u06d6\u06d9";
                    continue block12;
                }
                case -2016730719: {
                    TEXT_COLOR = Color.parseColor((String)TOGGLE_ON_COLOR);
                    string2 = "\u06e1\u06eb\u06d7\u06e1\u06e7\u06d6\u06d8\u06e4\u06e2\u06e5\u06e4\u06e4\u06e5\u06e5\u06e1\u06e0\u06d9\u06e7\u06dc\u06d8\u06e2\u06dc\u06d6\u06e7\u06eb\u06e0";
                    continue block12;
                }
                case -147592940: {
                    BACKGROUND_COLOR_PRIMARY = Color.parseColor((String)"#CC000000");
                    string2 = "\u06e1\u06d7\u06e4\u06e7\u06e5\u06e5\u06dc\u06e7\u06da\u06e8\u06e6\u06d8\u06e1\u06e1\u06e1\u06e8\u06eb\u06db\u06e1\u06e4\u06ec\u06e7\u06e0\u06da\u06ec\u06d9";
                    continue block12;
                }
                case 1919292047: {
                    BACKGROUND_COLOR = Color.parseColor((String)"#CC272727");
                    string2 = "\u06e4\u06e7\u06e5\u06d8\u06db\u06d7\u06e1\u06d8\u06e5\u06e0\u06d6\u06d8\u06e4\u06e4\u06e2\u06eb\u06e7\u06dc\u06d8\u06d8\u06d6\u06d6\u06e1\u06ec\u06ec";
                    continue block12;
                }
                case 2133919858: {
                    RIPPLE_COLOR = Color.parseColor((String)"#888888");
                    string2 = "\u06df\u06db\u06e1\u06df\u06df\u06df\u06ec\u06d6\u06d8\u06e5\u06df\u06e5\u06d8\u06e4\u06db\u06e5\u06d8\u06e8\u06e6\u06e7\u06d8\u06d9\u06e1\u06e8";
                    continue block12;
                }
                case 2010490185: {
                    THEME_COLOR = Color.parseColor((String)TOGGLE_ON_COLOR);
                    string2 = "\u06e1\u06d7\u06e5\u06d9\u06e0\u06d8\u06d8\u06e2\u06ec\u06e4\u06ec\u06dc\u06db\u06e7\u06d8\u06df\u06db\u06df\u06e6";
                    continue block12;
                }
                case 1850766964: {
                    TOGGLE_ON_COLOR_RGB = Color.parseColor((String)TOGGLE_ON_COLOR);
                    string2 = "\u06e5\u06e8\u06e6\u06d8\u06d8\u06db\u06e5\u06d8\u06db\u06d9\u06e6\u06d8\u06e6\u06e4\u06d9\u06d8\u06d9\u06df\u06df\u06d8\u06d7";
                    continue block12;
                }
                case 178547727: {
                    TOGGLE_OFF_COLOR_RGB = Color.parseColor((String)TOGGLE_OFF_COLOR);
                    string2 = "\u06e7\u06d8\u06e5\u06d8\u06dc\u06da\u06da\u06eb\u06e1\u06dc\u06d8\u06e2\u06eb\u06dc\u06d8\u06e6\u06d9\u06e6\u06d8\u06d7\u06df\u06d8\u06e2\u06db\u06dc\u06df\u06e2\u06d8";
                    continue block12;
                }
                case -429159231: 
            }
            break;
        }
    }

    public SelectionMenu(PopupWindow object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"window");
        this.window = object;
        object = Gpw.generate(7);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"generate(7)");
        this.currentConfig = object;
    }

    public static final /* synthetic */ int access$getBACKGROUND_COLOR$cp() {
        String string2 = "\u06d9\u06df\u06db\u06d7\u06d8\u06df\u06e5\u06e5\u06e1\u06d8\u06ec\u06e2\u06e8\u06d8\u06e4\u06e4\u06df";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x2DB ^ 0x407726E9) {
                default: {
                    continue block3;
                }
                case 162638795: 
            }
            break;
        }
        return BACKGROUND_COLOR;
    }

    public static final /* synthetic */ int access$getBACKGROUND_COLOR_PRIMARY$cp() {
        String string2 = "\u06df\u06e2\u06d8\u06d8\u06e7\u06db\u06eb\u06eb\u06e1\u06e6\u06d9\u06e0\u06e1\u06d8\u06e2\u06d7\u06d6\u06d8";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x39E ^ 0x2B7E6398) {
                default: {
                    continue block3;
                }
                case 1680168055: 
            }
            break;
        }
        return BACKGROUND_COLOR_PRIMARY;
    }

    public static final /* synthetic */ String access$getCurrentConfig$p(SelectionMenu selectionMenu) {
        String string2 = "\u06d7\u06e6\u06e5\u06d8\u06e0\u06e2\u06d9\u06db\u06d6\u06d8\u06d8\u06e1\u06e2\u06e6\u06db\u06d6\u06da\u06df\u06df\u06e0\u06e6\u06df\u06d8\u06d8\u06d8\u06e8\u06d7";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x17 ^ 0xCE3B725D) {
                default: {
                    continue block4;
                }
                case 333456242: {
                    string2 = "\u06ec\u06d7\u06e5\u06d8\u06d8\u06e8\u06e1\u06d6\u06eb\u06dc\u06d8\u06e0\u06eb\u06d9\u06e5\u06d6\u06ec\u06d6\u06df\u06d9";
                    continue block4;
                }
                case 1566129621: 
            }
            break;
        }
        return selectionMenu.currentConfig;
    }

    public static final /* synthetic */ int access$getRIPPLE_COLOR$cp() {
        String string2 = "\u06df\u06d9\u06e8\u06d8\u06d6\u06df\u06e6\u06d8\u06e0\u06e0\u06e6\u06e6\u06d7\u06db\u06e8\u06eb\u06e6";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x32F ^ 0x4ABE4F99) {
                default: {
                    continue block3;
                }
                case 1400846220: 
            }
            break;
        }
        return RIPPLE_COLOR;
    }

    public static final /* synthetic */ int access$getTEXT_COLOR$cp() {
        String string2 = "\u06e8\u06da\u06eb\u06eb\u06e6\u06d8\u06e4\u06db\u06e0\u06e2\u06dc\u06d6\u06d8\u06e5\u06e4\u06e6\u06e0\u06e1\u06df";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x10 ^ 0xF4910ACF) {
                default: {
                    continue block3;
                }
                case 442795943: 
            }
            break;
        }
        return TEXT_COLOR;
    }

    public static final /* synthetic */ int access$getTHEME_COLOR$cp() {
        String string2 = "\u06db\u06d8\u06da\u06d7\u06e4\u06e5\u06e0\u06d8\u06eb\u06ec\u06df\u06e2\u06dc\u06d7\u06dc\u06d8\u06e8\u06e6\u06e7\u06d8\u06da\u06d6\u06e1\u06d8\u06da\u06db\u06e6\u06d8";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x179 ^ 0x4B0B6805) {
                default: {
                    continue block3;
                }
                case 1208823519: 
            }
            break;
        }
        return THEME_COLOR;
    }

    public static final /* synthetic */ int access$getTOGGLE_OFF_COLOR_RGB$cp() {
        String string2 = "\u06e2\u06e6\u06df\u06d6\u06df\u06d7\u06dc\u06da\u06e6\u06d8\u06d8\u06d6\u06d8\u06e0\u06e1\u06eb";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x10C ^ 0xA7670B5E) {
                default: {
                    continue block3;
                }
                case -174610431: 
            }
            break;
        }
        return TOGGLE_OFF_COLOR_RGB;
    }

    public static final /* synthetic */ int access$getTOGGLE_ON_COLOR_RGB$cp() {
        String string2 = "\u06db\u06d9\u06e1\u06da\u06da\u06d8\u06d8\u06d7\u06e8\u06d8\u06e8\u06e8\u06d6\u06d8\u06d7\u06db\u06ec\u06e0\u06e2\u06e6";
        block3: while (true) {
            switch (string2.hashCode() ^ 0xF9 ^ 0xEED2089) {
                default: {
                    continue block3;
                }
                case 668179058: 
            }
            break;
        }
        return TOGGLE_ON_COLOR_RGB;
    }

    public static final /* synthetic */ PopupWindow access$getWindow$p(SelectionMenu selectionMenu) {
        String string2 = "\u06d7\u06df\u06d8\u06dc\u06e1\u06e1\u06d8\u06df\u06e5\u06d8\u06d8\u06db\u06e8\u06e1\u06eb\u06d8\u06dc\u06d8\u06e5\u06d8\u06da\u06e8\u06e2\u06e8\u06db\u06eb\u06e4";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x9E ^ 0x4C391C7A) {
                default: {
                    continue block4;
                }
                case 1421797190: {
                    string2 = "\u06d7\u06e8\u06e5\u06e0\u06e0\u06d6\u06e6\u06d8\u06e6\u06df\u06db\u06e5\u06e6\u06d8\u06e2\u06da\u06d6\u06da\u06df\u06ec\u06e7\u06e4\u06d6\u06d9\u06e7\u06e1";
                    continue block4;
                }
                case 1393542856: 
            }
            break;
        }
        return selectionMenu.window;
    }

    public static final /* synthetic */ boolean access$moduleValues(SelectionMenu selectionMenu, Context context, int n, CheatModule cheatModule, Button button) {
        String string2 = "\u06e7\u06da\u06d7\u06da\u06ec\u06e0\u06e2\u06db\u06d8\u06e2\u06d6\u06da\u06d9\u06dc\u06e5\u06e1\u06eb\u06ec\u06d7\u06e2\u06da";
        block8: while (true) {
            switch (string2.hashCode() ^ 0x321 ^ 0xA348E79) {
                default: {
                    continue block8;
                }
                case 423112710: {
                    string2 = "\u06e5\u06e1\u06dc\u06d8\u06d6\u06d9\u06d6\u06d8\u06ec\u06d8\u06d6\u06e4\u06da\u06d7\u06eb\u06db\u06ec\u06d6\u06da\u06d6\u06d8\u06e4\u06db\u06df\u06d9";
                    continue block8;
                }
                case 86458439: {
                    string2 = "\u06e6\u06e7\u06d6\u06e6\u06e5\u06e7\u06e2\u06e6\u06d7\u06e5\u06e2\u06e8\u06ec\u06e6\u06dc\u06e8\u06d8\u06e6\u06d8";
                    continue block8;
                }
                case 615976481: {
                    string2 = "\u06e2\u06e7\u06d8\u06d8\u06dc\u06da\u06df\u06db\u06df\u06e4\u06ec\u06da\u06d9\u06d6\u06d8\u06db\u06dc\u06e2\u06e1\u06da\u06db\u06e4";
                    continue block8;
                }
                case 1842328386: {
                    string2 = "\u06e1\u06e8\u06e1\u06e7\u06da\u06e1\u06d8\u06e7\u06e4\u06d9\u06e0\u06e6\u06e5\u06d8\u06eb\u06dc\u06e7\u06d8\u06e7\u06ec\u06d8\u06e4\u06e6\u06d8\u06d9\u06db";
                    continue block8;
                }
                case 740263424: {
                    string2 = "\u06d7\u06d6\u06df\u06eb\u06e7\u06eb\u06e7\u06df\u06e8\u06d8\u06e2\u06eb\u06e1\u06d8\u06e8\u06d6\u06e7\u06e2\u06e7\u06eb\u06e5\u06e8\u06d7\u06d9\u06db\u06dc";
                    continue block8;
                }
                case 1299551474: 
            }
            break;
        }
        return selectionMenu.moduleValues(context, n, cheatModule, button);
    }

    public static final /* synthetic */ void access$moduleValues$lambda-15$setText-10(Button button, Value value) {
        String string2 = "\u06e2\u06d6\u06d8\u06d8\u06db\u06e5\u06e5\u06d7\u06e2\u06da\u06e5\u06eb\u06e6\u06ec\u06d8\u06e5\u06d6\u06d8";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x17F ^ 0xA71D6816) {
                default: {
                    continue block6;
                }
                case 1240297226: {
                    string2 = "\u06dc\u06e7\u06e1\u06d8\u06d6\u06d7\u06db\u06ec\u06d8\u06db\u06e4\u06d7\u06d6\u06db\u06d6\u06e2\u06ec\u06e5\u06d8\u06e1\u06e8\u06e4";
                    continue block6;
                }
                case 619077936: {
                    string2 = "\u06df\u06d6\u06e8\u06d8\u06df\u06e5\u06da\u06df\u06e1\u06e0\u06da\u06df\u06e1\u06d8\u06e1\u06e4\u06e1\u06d6\u06eb\u06d8\u06d8\u06d9\u06d7\u06e6";
                    continue block6;
                }
                case 1842973003: {
                    SelectionMenu.moduleValues$lambda-15$setText-10(button, value);
                    string2 = "\u06e7\u06ec\u06e7\u06e7\u06df\u06eb\u06d6\u06e1\u06dc\u06d8\u06d9\u06da\u06e1\u06d8\u06db\u06e8\u06da\u06d9\u06e6\u06d8";
                    continue block6;
                }
                case -171495641: 
            }
            break;
        }
    }

    public static final /* synthetic */ void access$setCurrentConfig$p(SelectionMenu selectionMenu, String string2) {
        String string3 = "\u06e8\u06e7\u06dc\u06d8\u06e4\u06d9\u06e7\u06e6\u06dc\u06e1\u06d8\u06e7\u06d8\u06e1\u06d7\u06dc\u06d6\u06d6\u06e0\u06ec\u06e1\u06d9\u06d7\u06d7\u06e5\u06e0\u06e5\u06e5\u06d8";
        block6: while (true) {
            switch (string3.hashCode() ^ 0x2A2 ^ 0x7524FD10) {
                default: {
                    continue block6;
                }
                case 521722746: {
                    string3 = "\u06e6\u06e8\u06e4\u06e6\u06e5\u06e7\u06d8\u06d7\u06d9\u06e6\u06d8\u06d7\u06db\u06ec\u06df\u06e5\u06d6\u06d8\u06e1\u06e2\u06d6\u06d8\u06d7\u06df\u06e0\u06eb\u06dc\u06eb\u06d8\u06d8";
                    continue block6;
                }
                case 1299856189: {
                    string3 = "\u06e0\u06e2\u06dc\u06d8\u06e4\u06e0\u06e7\u06d6\u06d9\u06eb\u06e2\u06da\u06e4\u06e4\u06e6\u06d9\u06e6\u06da\u06d8\u06e1\u06d7\u06e6\u06d8\u06da\u06ec\u06dc\u06d8";
                    continue block6;
                }
                case 1263793574: {
                    selectionMenu.currentConfig = string2;
                    string3 = "\u06e2\u06eb\u06ec\u06e0\u06e0\u06db\u06ec\u06e6\u06dc\u06e7\u06e5\u06e7\u06d8\u06d6\u06d8\u06e0";
                    continue block6;
                }
                case -413600617: 
            }
            break;
        }
    }

    private final native void addTabsMenu(Context var1, LinearLayout var2, int var3);

    private static final native void apply$lambda-2$lambda-1(SelectionMenu var0, WindowManager var1, View var2);

    private final native ColorStateList getStateListDrawable(int var1, int var2);

    private final native boolean moduleValues(Context var1, int var2, CheatModule var3, Button var4);

    private static final native void moduleValues$lambda-15$lambda-12(Value var0, Button var1, View var2);

    private static final native void moduleValues$lambda-15$lambda-8$lambda-7(Value var0, Button var1, View var2);

    private static final native void moduleValues$lambda-15$lambda-8$setText(Button var0, Value var1);

    private static final native void moduleValues$lambda-15$setText-10(Button var0, Value var1);

    private static final native void moduleValues$lambda-17$lambda-16(Button var0, View var1);

    private final native void normalOnClickListener(Button var1, boolean var2, Function1 var3);

    /*
     * Exception decompiling
     */
    static /* synthetic */ void normalOnClickListener$default(SelectionMenu var0, Button var1_1, boolean var2_2, Function1 var3_3, int var4_4, Object var5_5) {
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

    private static final native void normalOnClickListener$lambda-18(SelectionMenu var0, Function1 var1, View var2);

    private final native void onProgressChanged(SeekBar var1, Function3 var2);

    private final native Button themedButton(Context var1, int var2, int var3, boolean var4);

    /*
     * Exception decompiling
     */
    static /* synthetic */ Button themedButton$default(SelectionMenu var0, Context var1_1, int var2_2, int var3_3, boolean var4_4, int var5_5, Object var6_6) {
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

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006\u00a8\u0006\u0016"}, d2={"Ldev/sora/protohax/relay/gui/SelectionMenu$Companion;", "", "()V", "BACKGROUND_COLOR", "", "getBACKGROUND_COLOR", "()I", "BACKGROUND_COLOR_PRIMARY", "getBACKGROUND_COLOR_PRIMARY", "RIPPLE_COLOR", "getRIPPLE_COLOR", "TEXT_COLOR", "getTEXT_COLOR", "THEME_COLOR", "getTHEME_COLOR", "TOGGLE_OFF_COLOR", "", "TOGGLE_OFF_COLOR_RGB", "getTOGGLE_OFF_COLOR_RGB", "TOGGLE_ON_COLOR", "TOGGLE_ON_COLOR_RGB", "getTOGGLE_ON_COLOR_RGB", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        static {
            String string2 = "\u06e7\u06e7\u06e5\u06e0\u06e5\u06ec\u06d7\u06e5\u06dc\u06d8\u06d6\u06eb\u06d9\u06d8\u06df\u06e8\u06db\u06eb\u06e6\u06da\u06eb\u06dc\u06d8";
            block4: while (true) {
                switch (string2.hashCode() ^ 0x42 ^ 0xD3B81378) {
                    default: {
                        continue block4;
                    }
                    case 1773262784: {
                        EntryPoint.stub((int)60);
                        string2 = "\u06e5\u06da\u06e6\u06dc\u06e6\u06e0\u06e6\u06eb\u06eb\u06e7\u06d6\u06e5\u06d8\u06e5\u06e1\u06d6\u06e6\u06d9\u06dc\u06e1\u06d8\u06d6\u06eb\u06da\u06e6";
                        continue block4;
                    }
                    case 1687502128: 
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

        public final native int getTOGGLE_OFF_COLOR_RGB();

        public final native int getTOGGLE_ON_COLOR_RGB();
    }
}

