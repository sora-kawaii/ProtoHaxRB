/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2={"Ldev/sora/protohax/MyApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class MyApplication
extends Application {
    public static final Companion Companion;
    private static MyApplication instance;

    static {
        String string2 = "\u06ec\u06df\u06e4\u06db\u06d9\u06ec\u06e2\u06d9\u06d7\u06d8\u06db\u06d9\u06e4\u06d6\u06e1\u06d6\u06dc\u06e7\u06d8\u06dc\u06d6\u06e6\u06d8\u06dc\u06d7\u06dc\u06d8";
        block5: while (true) {
            switch (string2.hashCode() ^ 0x358 ^ 0x8D9E78E) {
                default: {
                    continue block5;
                }
                case -2072012512: {
                    EntryPoint.stub((int)1);
                    string2 = "\u06dc\u06e2\u06e6\u06d8\u06d6\u06db\u06e0\u06d6\u06d6\u06e0\u06e5\u06e2\u06e5\u06d8\u06e5\u06d7\u06e8\u06d8";
                    continue block5;
                }
                case 708083961: {
                    Companion = new Companion(null);
                    string2 = "\u06e8\u06e7\u06e6\u06d8\u06e0\u06da\u06dc\u06eb\u06eb\u06d8\u06da\u06d9\u06e0\u06e1\u06e2\u06d7\u06db\u06dc\u06e4\u06e7\u06e7\u06eb\u06d7\u06d7\u06e2\u06e7\u06d6\u06df";
                    continue block5;
                }
                case -1300884700: 
            }
            break;
        }
    }

    public static final /* synthetic */ MyApplication access$getInstance$cp() {
        String string2 = "\u06db\u06e6\u06e6\u06d8\u06e4\u06e8\u06d6\u06db\u06e0\u06e8\u06d7\u06e7\u06e1\u06eb\u06e6\u06e2\u06d7\u06e6\u06e2\u06ec\u06db\u06e5\u06e2\u06db\u06ec";
        block3: while (true) {
            switch (string2.hashCode() ^ 0x347 ^ 0x784D8C9C) {
                default: {
                    continue block3;
                }
                case -419648617: 
            }
            break;
        }
        return instance;
    }

    public native void onCreate();

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/sora/protohax/MyApplication$Companion;", "", "()V", "<set-?>", "Ldev/sora/protohax/MyApplication;", "instance", "getInstance", "()Ldev/sora/protohax/MyApplication;", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Companion {
        static {
            String string2 = "\u06e1\u06d9\u06e4\u06db\u06e1\u06e2\u06db\u06e0\u06e5\u06d8\u06e4\u06dc\u06e0\u06d9\u06e6\u06e6\u06d8\u06d8\u06da\u06e4\u06d6";
            block4: while (true) {
                switch (string2.hashCode() ^ 0x207 ^ 0xA8AC446D) {
                    default: {
                        continue block4;
                    }
                    case -315184967: {
                        EntryPoint.stub((int)0);
                        string2 = "\u06e0\u06eb\u06d7\u06e1\u06e6\u06e8\u06d8\u06e8\u06d6\u06dc\u06d8\u06df\u06da\u06dc\u06d8\u06e2\u06e6\u06e8\u06d8";
                        continue block4;
                    }
                    case 1134766812: 
                }
                break;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final native MyApplication getInstance();
    }
}

