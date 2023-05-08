/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.utils;

import dev.sora.relay.game.GameSession;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"logger", "Lio/netty/util/internal/logging/InternalLogger;", "kotlin.jvm.PlatformType", "logError", "", "msg", "", "t", "", "logInfo", "logWarn", "ProtoHax"}, k=2, mv={1, 7, 1}, xi=48)
public final class LoggerKt {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GameSession.class);

    public static final void logError(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
        logger.error(string);
    }

    public static final void logError(String string, Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
        Intrinsics.checkNotNullParameter((Object)throwable, (String)"t");
        logger.error(string, throwable);
    }

    public static final void logInfo(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
        logger.info(string);
    }

    public static final void logWarn(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"msg");
        logger.warn(string);
    }
}

