/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay.log;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import np.dcc.protect.EntryPoint;

public class NettyLoggerFactory
extends InternalLoggerFactory {
    static {
        String string2 = "\u06d8\u06e6\u06d8\u06db\u06d6\u06ec\u06df\u06e8\u06d6\u06df\u06da\u06eb\u06e4\u06dc\u06df";
        block4: while (true) {
            switch (string2.hashCode() ^ 0x242 ^ 0x978C403B) {
                default: {
                    continue block4;
                }
                case 1526030212: {
                    EntryPoint.stub((int)47);
                    string2 = "\u06e7\u06d6\u06e2\u06d9\u06e1\u06d7\u06e7\u06d8\u06e5\u06d8\u06e0\u06dc\u06e1\u06d8\u06e4\u06d7\u06e8\u06d8\u06e1\u06e4\u06df";
                    continue block4;
                }
                case 364506719: 
            }
            break;
        }
    }

    @Override
    protected native InternalLogger newInstance(String var1);
}

