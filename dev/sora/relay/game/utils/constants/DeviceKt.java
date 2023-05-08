/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.constants;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0003"}, d2={"titleIdToDevice", "", "titleId", "ProtoHax"}, k=2, mv={1, 7, 1}, xi=48)
public final class DeviceKt {
    /*
     * Enabled aggressive block sorting
     */
    public static final String titleIdToDevice(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"titleId");
        int n = -1;
        switch (string.hashCode()) {
            case 2048683431: {
                if (!string.equals("1739947436")) break;
                n = 1;
                break;
            }
            case 1412768191: {
                if (!string.equals("2047319603")) break;
                n = 2;
                break;
            }
            case 483058251: {
                if (!string.equals("896928775")) break;
                n = 3;
                break;
            }
        }
        switch (n) {
            default: {
                return "";
            }
            case 1: {
                return "Android";
            }
            case 2: {
                return "Nintendo";
            }
            case 3: 
        }
        return "Windows_10";
    }
}

