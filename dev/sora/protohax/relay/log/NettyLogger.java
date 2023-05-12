/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay.log;

import io.netty.util.internal.logging.AbstractInternalLogger;
import np.dcc.protect.EntryPoint;

public class NettyLogger
extends AbstractInternalLogger {
    private static final String TAG = "ProtoHax";

    static {
        String string2 = "\u06e8\u06eb\u06eb\u06e1\u06d8\u06e5\u06e4\u06dc\u06d6\u06d8\u06d8\u06d9\u06e8\u06d6\u06e2\u06df\u06e2\u06e4\u06d6\u06e6\u06e8\u06e8\u06d8\u06e2\u06e2\u06e8";
        block4: while (true) {
            switch (string2.hashCode() ^ 0xE1 ^ 0x8DD0B447) {
                default: {
                    continue block4;
                }
                case 840334344: {
                    EntryPoint.stub((int)46);
                    string2 = "\u06eb\u06e6\u06e2\u06e6\u06dc\u06e8\u06d8\u06e8\u06e1\u06d8\u06d8\u06e8\u06d6\u06d6\u06d9\u06eb\u06e7\u06d8\u06d7";
                    continue block4;
                }
                case 689975156: 
            }
            break;
        }
    }

    protected NettyLogger(String string2) {
        super(string2);
    }

    @Override
    public native void debug(String var1);

    @Override
    public native void debug(String var1, Object var2);

    @Override
    public native void debug(String var1, Object var2, Object var3);

    @Override
    public native void debug(String var1, Throwable var2);

    @Override
    public native void debug(String var1, Object ... var2);

    @Override
    public native void error(String var1);

    @Override
    public native void error(String var1, Object var2);

    @Override
    public native void error(String var1, Object var2, Object var3);

    @Override
    public native void error(String var1, Throwable var2);

    @Override
    public native void error(String var1, Object ... var2);

    @Override
    public native void info(String var1);

    @Override
    public native void info(String var1, Object var2);

    @Override
    public native void info(String var1, Object var2, Object var3);

    @Override
    public native void info(String var1, Throwable var2);

    @Override
    public native void info(String var1, Object ... var2);

    @Override
    public native boolean isDebugEnabled();

    @Override
    public native boolean isErrorEnabled();

    @Override
    public native boolean isInfoEnabled();

    @Override
    public native boolean isTraceEnabled();

    @Override
    public native boolean isWarnEnabled();

    @Override
    public native void trace(String var1);

    @Override
    public native void trace(String var1, Object var2);

    @Override
    public native void trace(String var1, Object var2, Object var3);

    @Override
    public native void trace(String var1, Throwable var2);

    @Override
    public native void trace(String var1, Object ... var2);

    @Override
    public native void warn(String var1);

    @Override
    public native void warn(String var1, Object var2);

    @Override
    public native void warn(String var1, Object var2, Object var3);

    @Override
    public native void warn(String var1, Throwable var2);

    @Override
    public native void warn(String var1, Object ... var2);
}

