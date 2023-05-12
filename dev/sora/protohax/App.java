/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import bin.mt.signature.KillerApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2={"Ldev/sora/protohax/App;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class App
extends KillerApplication {
    public static final Companion Companion;
    public static App app;
    public static File configDir;

    static {
        String string2 = "\u06db\u06e8\u06d8\u06d6\u06e7\u06ec\u06e0\u06e1\u06e7\u06d8\u06dc\u06d6\u06e5\u06ec\u06e5\u06db\u06e0\u06dc\u06e8\u06d7\u06e6\u06dc";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x338 ^ 0x138F6AAD) {
                default: {
                    continue block5;
                }
                case -982805777: {
                    EntryPoint.stub((int)23);
                    string2 = "\u06e7\u06e2\u06e1\u06d8\u06d9\u06da\u06d6\u06d9\u06e4\u06e1\u06d8\u06e2\u06da\u06d8\u06d8\u06df\u06eb\u06d8";
                    continue block5;
                }
                case -21654342: {
                    Companion = new Companion(null);
                    string2 = "\u06e1\u06e6\u06df\u06d7\u06ec\u06db\u06e4\u06da\u06e8\u06d8\u06e1\u06d6\u06e5\u06d8\u06df\u06dc\u06e7\u06df\u06d9\u06d6\u06df\u06d7\u06e7";
                    continue block5;
                }
                case 1175362582: 
            }
            break;
        }
    }

    public native void onCreate();

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/sora/protohax/App$Companion;", "", "()V", "app", "Ldev/sora/protohax/App;", "getApp", "()Ldev/sora/protohax/App;", "setApp", "(Ldev/sora/protohax/App;)V", "configDir", "Ljava/io/File;", "getConfigDir", "()Ljava/io/File;", "setConfigDir", "(Ljava/io/File;)V", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        static {
            String string2 = "\u06d7\u06d7\u06ec\u06d6\u06dc\u06e2\u06da\u06d6\u06e8\u06db\u06db\u06e6\u06d8\u06e0\u06e1\u06d9";
            block4: while (true) {
                switch (string2.hashCode() ^ 0x2F5 ^ 0x69913767) {
                    default: {
                        continue block4;
                    }
                    case 909279192: {
                        EntryPoint.stub((int)22);
                        string2 = "\u06e4\u06d9\u06d8\u06d8\u06e0\u06d6\u06d6\u06d8\u06e2\u06ec\u06e1\u06da\u06e2\u06df\u06d6\u06dc\u06e5\u06d8\u06ec\u06e6\u06d7";
                        continue block4;
                    }
                    case 1337407333: 
                }
                break;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final native App getApp();

        public final native File getConfigDir();

        public final native void setApp(App var1);

        public final native void setConfigDir(File var1);
    }
}

