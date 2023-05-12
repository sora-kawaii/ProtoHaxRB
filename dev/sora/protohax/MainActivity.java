/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.TextView
 *  com.stub.StubApp
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.github.megatronking.netbare.NetBareConfig;
import com.github.megatronking.netbare.NetBareListener;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import np.dcc.protect.EntryPoint;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0015J\b\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001e"}, d2={"Ldev/sora/protohax/MainActivity;", "Landroid/app/Activity;", "Lcom/github/megatronking/netbare/NetBareListener;", "()V", "configBuilder", "Lcom/github/megatronking/netbare/NetBareConfig$Builder;", "getConfigBuilder", "()Lcom/github/megatronking/netbare/NetBareConfig$Builder;", "appChooser", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onServiceStarted", "onServiceStopped", "runMitMProxy", "targetPkgName", "", "updateConnStatus", "status", "", "updateMicrosoftButton", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class MainActivity
extends Activity
implements NetBareListener {
    public static final Companion Companion;
    public static final String KEY_MICROSOFT_REFRESH_TOKEN = "MICROSOFT_REFRESH_TOKEN";
    private static final String KEY_TARGET_PACKAGE_CACHE = "TARGET_PACKAGE";
    private static final int REQUEST_CODE_MICROSOFT_LOGIN_OK = 2;
    private static final int REQUEST_CODE_WITH_MITM_RECALL = 0;
    private static final int REQUEST_CODE_WITH_MITM_RECALL_ONLY_OK = 1;
    public static final int RESPONSE_CODE_MICROSOFT_LOGIN_OK = 1;

    public static /* synthetic */ boolean $r8$lambda$9orqRk4Txl3wjKqNqQhjaRbxS-A(MainActivity mainActivity, View view) {
        String string2 = "\u06e2\u06e5\u06e8\u06d8\u06e4\u06e5\u06e7\u06d6\u06e7\u06d7\u06da\u06e8\u06d6\u06e5\u06e1\u06e1\u06d8\u06d8\u06e8";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x3C4 ^ 0x2DD8CE9D) {
                default: {
                    continue block5;
                }
                case -1163094591: {
                    string2 = "\u06dc\u06e0\u06d7\u06e5\u06e7\u06e5\u06e5\u06d8\u06e0\u06e6\u06eb\u06db\u06e0\u06db\u06d9\u06e4\u06da\u06e6\u06eb\u06e7\u06dc\u06d8\u06eb\u06e6\u06d7\u06e0\u06e4";
                    continue block5;
                }
                case -786842012: {
                    string2 = "\u06d6\u06dc\u06e1\u06e4\u06da\u06eb\u06ec\u06d9\u06db\u06dc\u06df\u06e0\u06ec\u06d6\u06d8\u06d8\u06d9\u06df\u06df";
                    continue block5;
                }
                case -22729697: 
            }
            break;
        }
        return MainActivity.onCreate$lambda-1(mainActivity, view);
    }

    public static /* synthetic */ void $r8$lambda$IzIehLAK9sAjvb0p9USfU0EqdPk(MainActivity mainActivity) {
        String string2 = "\u06e6\u06e0\u06ec\u06db\u06e8\u06e4\u06e2\u06e5\u06d8\u06dc\u06e2\u06e5\u06ec\u06d6\u06eb\u06e0\u06d6\u06e5\u06d8";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x198 ^ 0x68743CE4) {
                default: {
                    continue block5;
                }
                case 1881425863: {
                    string2 = "\u06da\u06e7\u06d8\u06e8\u06eb\u06df\u06e4\u06ec\u06e1\u06e0\u06e1\u06e6\u06d8\u06da\u06df\u06eb\u06dc\u06e0\u06e6\u06d8\u06e1\u06e1\u06df\u06e5\u06dc\u06ec";
                    continue block5;
                }
                case -2095232757: {
                    MainActivity.onServiceStarted$lambda-11(mainActivity);
                    string2 = "\u06e0\u06d9\u06e8\u06e5\u06e8\u06db\u06e7\u06dc\u06db\u06e4\u06e5\u06e7\u06d8\u06da\u06e7\u06e0";
                    continue block5;
                }
                case 764714776: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$LhYvIg40uZxtytxWBa5pZHOmhOM(boolean bl, MainActivity mainActivity, View view) {
        String string2 = "\u06e2\u06e0\u06e7\u06ec\u06e1\u06e6\u06d7\u06d7\u06d6\u06d8\u06d7\u06da\u06d8\u06e5\u06e7\u06d6";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x333 ^ 0xBAD0BA0E) {
                default: {
                    continue block7;
                }
                case 908833812: {
                    string2 = "\u06d6\u06d9\u06e6\u06db\u06d8\u06dc\u06d7\u06e2\u06e6\u06d8\u06e6\u06e7\u06d8\u06d8\u06d7\u06d8\u06df\u06e4\u06e5\u06d8\u06d8\u06da\u06e0\u06e0\u06eb\u06dc\u06d8\u06e4\u06e8\u06e5";
                    continue block7;
                }
                case -1037948942: {
                    string2 = "\u06d8\u06d9\u06d6\u06d8\u06df\u06e7\u06db\u06db\u06e8\u06dc\u06d6\u06db\u06d6\u06e2\u06e1\u06df\u06ec\u06d7\u06d6\u06d8\u06e5\u06e0\u06e7";
                    continue block7;
                }
                case 2087990732: {
                    string2 = "\u06d9\u06e7\u06e7\u06e2\u06e4\u06d8\u06d8\u06db\u06eb\u06d8\u06d8\u06df\u06e8\u06e6\u06d8\u06d6\u06da\u06df\u06df\u06e5\u06d9\u06d7\u06e1\u06d8\u06e0\u06dc\u06e7\u06d7\u06e7\u06e0";
                    continue block7;
                }
                case 1844673768: {
                    MainActivity.updateConnStatus$lambda-10(bl, mainActivity, view);
                    string2 = "\u06da\u06dc\u06e5\u06e2\u06da\u06e1\u06d8\u06ec\u06e5\u06d8\u06d9\u06e7\u06e1\u06e2\u06e1\u06e1\u06e5\u06eb\u06d7\u06e8\u06ec\u06e1\u06d8\u06d9\u06d8\u06d8";
                    continue block7;
                }
                case -473824588: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$UzGHTzS4OYM1nKsg5JkyNWC96vU(CompoundButton compoundButton, boolean bl) {
        String string2 = "\u06e6\u06dc\u06d8\u06ec\u06db\u06dc\u06ec\u06e6\u06d9\u06e2\u06d6\u06e5\u06e4\u06db\u06dc\u06dc\u06eb\u06e5";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x1C8 ^ 0x5B290D7C) {
                default: {
                    continue block6;
                }
                case 1907667866: {
                    string2 = "\u06e2\u06da\u06e5\u06d8\u06e0\u06da\u06e0\u06d9\u06e7\u06dc\u06d8\u06da\u06ec\u06d8\u06d8\u06eb\u06d9\u06d7";
                    continue block6;
                }
                case 1531956166: {
                    string2 = "\u06dc\u06e1\u06e1\u06dc\u06e2\u06e6\u06e6\u06e8\u06e2\u06e0\u06d9\u06e8\u06d8\u06dc\u06e7\u06e4\u06ec\u06e6\u06d6\u06d8";
                    continue block6;
                }
                case 1978224836: {
                    MainActivity.onCreate$lambda-2(compoundButton, bl);
                    string2 = "\u06dc\u06da\u06e7\u06d8\u06e0\u06e5\u06d8\u06d8\u06d8\u06e5\u06db\u06ec\u06da\u06eb\u06d7\u06df\u06e6\u06e6\u06d7\u06d8\u06d8\u06dc\u06d8\u06e8\u06e5\u06db";
                    continue block6;
                }
                case -161130590: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$gZn5FHQNMYNeFe1NjyQ3BRD9MA0(String[] stringArray, MainActivity mainActivity, DialogInterface dialogInterface, int n) {
        String string2 = "\u06df\u06e7\u06db\u06d7\u06e8\u06e5\u06d7\u06dc\u06e7\u06d8\u06e8\u06d6\u06eb\u06e0\u06db\u06e1\u06d8\u06e8\u06d8\u06dc\u06d6\u06d8\u06e7\u06d8\u06db\u06e1\u06e8\u06db\u06dc\u06db";
        block8: while (true) {
            switch (string2.hashCode() ^ 0x321 ^ 0xCCCB60BA) {
                default: {
                    continue block8;
                }
                case 1324614340: {
                    string2 = "\u06df\u06e5\u06e8\u06db\u06e6\u06e7\u06d8\u06e4\u06e1\u06e6\u06d8\u06e7\u06d6\u06e1\u06d8\u06d8\u06db\u06e0";
                    continue block8;
                }
                case -885664239: {
                    string2 = "\u06e8\u06ec\u06eb\u06e1\u06ec\u06e8\u06e5\u06d6\u06d8\u06d8\u06e2\u06e1\u06da\u06d6\u06d7\u06e8\u06d8\u06eb\u06e2\u06df";
                    continue block8;
                }
                case -986982408: {
                    string2 = "\u06db\u06db\u06d8\u06dc\u06df\u06d6\u06d8\u06da\u06d8\u06d6\u06eb\u06d6\u06d8\u06d8\u06df\u06d6\u06d8\u06d8";
                    continue block8;
                }
                case 1498873030: {
                    string2 = "\u06e6\u06e7\u06e1\u06dc\u06e5\u06df\u06e8\u06e5\u06e1\u06da\u06eb\u06da\u06dc\u06dc\u06d6\u06d8\u06db\u06e7\u06e7\u06e8\u06db\u06dc\u06d8\u06db\u06df";
                    continue block8;
                }
                case -2075162870: {
                    MainActivity.appChooser$lambda-7(stringArray, mainActivity, dialogInterface, n);
                    string2 = "\u06d7\u06e6\u06dc\u06d8\u06dc\u06e5\u06db\u06dc\u06d9\u06e7\u06df\u06eb\u06e5\u06d8\u06eb\u06db\u06e4\u06ec\u06e1\u06e1\u06df\u06d7\u06e1\u06df\u06e0\u06df";
                    continue block8;
                }
                case -99998540: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$jYrtY7B7S3P0lErIIpANp0sChnQ(DialogInterface dialogInterface, int n) {
        String string2 = "\u06e2\u06d7\u06da\u06dc\u06e8\u06db\u06e1\u06df\u06e4\u06d7\u06e8\u06e2\u06e5\u06da\u06d7";
        block6: while (true) {
            switch (string2.hashCode() ^ 0xCB ^ 0xDB3D839) {
                default: {
                    continue block6;
                }
                case -1661209089: {
                    string2 = "\u06e5\u06d9\u06d8\u06e5\u06d7\u06eb\u06e7\u06e6\u06df\u06ec\u06d8\u06e0\u06e7\u06e0\u06d8\u06da\u06ec\u06dc\u06d8";
                    continue block6;
                }
                case -760379946: {
                    string2 = "\u06d6\u06e8\u06e5\u06d8\u06e1\u06df\u06d6\u06d8\u06e6\u06e6\u06dc\u06d8\u06e8\u06d9\u06d9\u06ec\u06e4";
                    continue block6;
                }
                case 766881389: {
                    MainActivity.appChooser$lambda-8(dialogInterface, n);
                    string2 = "\u06db\u06db\u06dc\u06d6\u06da\u06e4\u06e7\u06e8\u06da\u06d6\u06d6\u06eb\u06da\u06d7\u06e0\u06e2\u06dc";
                    continue block6;
                }
                case -2119428971: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$ouvlT2fcFpDVAMd8wvZqMKkZDEs(MainActivity mainActivity, View view) {
        String string2 = "\u06ec\u06eb\u06e8\u06e6\u06dc\u06df\u06d6\u06d7\u06dc\u06d8\u06df\u06dc\u06e1\u06d8\u06df\u06e1\u06db\u06d8\u06e2\u06e1\u06d7\u06d7\u06ec\u06d9\u06eb\u06d8";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x36A ^ 0x29F495C4) {
                default: {
                    continue block6;
                }
                case 988979815: {
                    string2 = "\u06df\u06e0\u06e1\u06d7\u06e1\u06dc\u06d8\u06e7\u06e1\u06d6\u06d8\u06e5\u06e4\u06e8\u06eb\u06e0\u06e7\u06db\u06ec\u06e1\u06d8\u06e7\u06d9\u06e6\u06d8\u06ec\u06e4\u06e2\u06e7\u06eb\u06e5\u06d8";
                    continue block6;
                }
                case -808412412: {
                    string2 = "\u06e4\u06dc\u06e1\u06ec\u06e4\u06e2\u06da\u06dc\u06e5\u06d8\u06d7\u06eb\u06e7\u06db\u06e7\u06e0\u06e2\u06da\u06da\u06eb\u06eb\u06d7\u06da\u06e1\u06e8\u06d8";
                    continue block6;
                }
                case -331913075: {
                    MainActivity.updateMicrosoftButton$lambda-9(mainActivity, view);
                    string2 = "\u06eb\u06db\u06e6\u06d7\u06e0\u06e5\u06d8\u06d7\u06e7\u06ec\u06dc\u06e6\u06e8\u06d8\u06e4\u06e6\u06ec\u06da\u06db\u06ec";
                    continue block6;
                }
                case 1981354859: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$pxtUYO3rPEHVxrcE3SUAZByWU74(MainActivity mainActivity) {
        String string2 = "\u06e8\u06e1\u06d6\u06ec\u06e2\u06db\u06e6\u06d8\u06d9\u06dc\u06d7\u06df\u06e8\u06dc\u06df\u06d8\u06d8\u06dc\u06e8\u06d6\u06e5\u06e6\u06d9\u06eb\u06e2\u06e1\u06d8";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x2F9 ^ 0xF59CD88E) {
                default: {
                    continue block5;
                }
                case 750997301: {
                    string2 = "\u06ec\u06d8\u06e6\u06e1\u06ec\u06d6\u06da\u06d6\u06e1\u06ec\u06df\u06e5\u06d8\u06e8\u06ec\u06e7\u06ec\u06d6\u06e4\u06e2\u06db\u06df\u06d7\u06df\u06d8\u06d8";
                    continue block5;
                }
                case 398423018: {
                    MainActivity.onServiceStopped$lambda-12(mainActivity);
                    string2 = "\u06ec\u06e0\u06d8\u06e2\u06e1\u06e2\u06ec\u06e2\u06d8\u06ec\u06d7\u06d9\u06ec\u06e1\u06dc\u06d8\u06d9\u06e0\u06d9";
                    continue block5;
                }
                case 398853857: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$qO02F09-vFf4gqGGJ24nLxF4xSI(MainActivity mainActivity, View view) {
        String string2 = "\u06e4\u06e8\u06e7\u06d8\u06e5\u06d9\u06d6\u06eb\u06d7\u06e8\u06d8\u06dc\u06db\u06ec\u06da\u06dc\u06e5\u06dc\u06e2\u06e6\u06d8\u06e2\u06eb\u06d6\u06eb\u06d9\u06eb\u06eb\u06d7";
        block6: while (true) {
            switch (string2.hashCode() ^ 0x2A7 ^ 0xAF957683) {
                default: {
                    continue block6;
                }
                case 1314638327: {
                    string2 = "\u06db\u06d7\u06e5\u06d8\u06d7\u06e2\u06d9\u06e6\u06da\u06d6\u06d8\u06dc\u06e4\u06d8\u06d8\u06ec\u06e2\u06eb\u06eb\u06df\u06d8\u06e5\u06d7\u06eb";
                    continue block6;
                }
                case -1345346551: {
                    string2 = "\u06ec\u06df\u06e5\u06d8\u06e8\u06d6\u06d6\u06d8\u06e7\u06d7\u06ec\u06e4\u06ec\u06df\u06d7\u06e8\u06d6";
                    continue block6;
                }
                case -308961136: {
                    MainActivity.onCreate$lambda-3(mainActivity, view);
                    string2 = "\u06e2\u06e0\u06e5\u06e0\u06e5\u06e5\u06d8\u06e7\u06eb\u06e4\u06e8\u06e8\u06d8\u06d7\u06da\u06d6\u06d8\u06e7\u06ec\u06d8\u06d8\u06e5\u06e0\u06db\u06e6\u06d9\u06d6";
                    continue block6;
                }
                case 732336800: 
            }
            break;
        }
    }

    public static /* synthetic */ void $r8$lambda$siobQrsOm_WU56NsugHBCvVw0mg(TextView textView, MainActivity mainActivity, View view) {
        String string2 = "\u06db\u06e1\u06d6\u06d8\u06e1\u06ec\u06df\u06e7\u06e6\u06e2\u06e0\u06e4\u06e8\u06db\u06e0\u06e8\u06d8\u06e6\u06dc\u06e5\u06ec\u06ec\u06e6\u06d8\u06e8\u06e5\u06d8\u06d8";
        block7: while (true) {
            switch (string2.hashCode() ^ 0x21A ^ 0x2D885382) {
                default: {
                    continue block7;
                }
                case 1348395108: {
                    string2 = "\u06e2\u06df\u06e1\u06d6\u06e1\u06d7\u06d8\u06df\u06e7\u06e4\u06e8\u06d6\u06d8\u06d7\u06e2\u06eb\u06eb\u06e2\u06db\u06d9\u06da\u06e2\u06dc\u06d8";
                    continue block7;
                }
                case -189764637: {
                    string2 = "\u06d8\u06da\u06d7\u06e1\u06d8\u06e6\u06d8\u06e8\u06e4\u06e8\u06e5\u06d8\u06e5\u06d8\u06df\u06e2\u06eb\u06df\u06e0\u06d6\u06e8\u06e8\u06d6\u06d8\u06e7\u06df\u06eb";
                    continue block7;
                }
                case -1383311288: {
                    string2 = "\u06e8\u06e4\u06e8\u06d8\u06dc\u06e6\u06e5\u06d8\u06d8\u06e7\u06e5\u06d8\u06e5\u06dc\u06e7\u06e2\u06ec\u06e1\u06d8\u06da\u06e4\u06df\u06df\u06e0\u06e7\u06e4\u06dc\u06d8\u06e4\u06ec\u06db";
                    continue block7;
                }
                case -118871886: {
                    MainActivity.onCreate$lambda-0(textView, mainActivity, view);
                    string2 = "\u06e7\u06e7\u06e1\u06d8\u06da\u06e8\u06d8\u06d7\u06d7\u06d8\u06e1\u06d9\u06d8\u06e8\u06e5\u06e1\u06d8\u06d8\u06d6\u06e0\u06e7\u06d6\u06e2\u06e8\u06d8\u06d9";
                    continue block7;
                }
                case 1149696465: 
            }
            break;
        }
    }

    static {
        StubApp.interface11((int)2989);
        String string2 = "\u06e7\u06d8\u06d6\u06d8\u06e2\u06d6\u06d7\u06e7\u06d8\u06e4\u06dc\u06e7\u06d8\u06ec\u06e1\u06dc\u06d8\u06db\u06da\u06e1\u06d8\u06d7\u06e4\u06d8\u06e7\u06d7\u06e7";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x63 ^ 0x4B588FB3) {
                default: {
                    continue block5;
                }
                case 1870734477: {
                    EntryPoint.stub((int)7);
                    string2 = "\u06e8\u06d8\u06dc\u06d8\u06df\u06db\u06d7\u06e8\u06e6\u06e4\u06e2\u06d8\u06d9\u06e6\u06e7\u06db\u06e6\u06e8\u06e5\u06d7\u06d7\u06e6\u06e4\u06db\u06e1\u06d8\u06da\u06d9\u06df";
                    continue block5;
                }
                case -2133206799: {
                    Companion = new Companion(null);
                    string2 = "\u06eb\u06dc\u06d9\u06dc\u06e4\u06e1\u06e6\u06e1\u06df\u06e1\u06e7\u06e5\u06d8\u06d8\u06ec\u06d6\u06d6\u06e4\u06e8\u06da\u06df\u06eb";
                    continue block5;
                }
                case 1133596498: 
            }
            break;
        }
    }

    private final native void appChooser();

    private static final native void appChooser$lambda-7(String[] var0, MainActivity var1, DialogInterface var2, int var3);

    private static final native void appChooser$lambda-8(DialogInterface var0, int var1);

    private final native NetBareConfig.Builder getConfigBuilder();

    private static final native void onCreate$lambda-0(TextView var0, MainActivity var1, View var2);

    private static final native boolean onCreate$lambda-1(MainActivity var0, View var1);

    private static final native void onCreate$lambda-2(CompoundButton var0, boolean var1);

    private static final native void onCreate$lambda-3(MainActivity var0, View var1);

    private static final native void onServiceStarted$lambda-11(MainActivity var0);

    private static final native void onServiceStopped$lambda-12(MainActivity var0);

    private final native void runMitMProxy(String var1);

    private final native void updateConnStatus(boolean var1);

    /*
     * Exception decompiling
     */
    static /* synthetic */ void updateConnStatus$default(MainActivity var0, boolean var1_1, int var2_2, Object var3_3) {
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

    private static final native void updateConnStatus$lambda-10(boolean var0, MainActivity var1, View var2);

    private final native void updateMicrosoftButton();

    private static final native void updateMicrosoftButton$lambda-9(MainActivity var0, View var1);

    protected native void onActivityResult(int var1, int var2, Intent var3);

    protected native void onCreate(Bundle var1);

    protected native void onDestroy();

    @Override
    public native void onServiceStarted();

    @Override
    public native void onServiceStopped();

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/sora/protohax/MainActivity$Companion;", "", "()V", "KEY_MICROSOFT_REFRESH_TOKEN", "", "KEY_TARGET_PACKAGE_CACHE", "REQUEST_CODE_MICROSOFT_LOGIN_OK", "", "REQUEST_CODE_WITH_MITM_RECALL", "REQUEST_CODE_WITH_MITM_RECALL_ONLY_OK", "RESPONSE_CODE_MICROSOFT_LOGIN_OK", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

