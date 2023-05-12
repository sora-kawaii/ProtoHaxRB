/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.sora.relay.cheat.value.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u0015"}, d2={"Ldev/sora/relay/cheat/value/IntValue;", "Ldev/sora/relay/cheat/value/Value;", "", "name", "", "value", "minimum", "maximum", "(Ljava/lang/String;III)V", "getMaximum", "()I", "getMinimum", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "set", "newValue", "", "toJson", "Lcom/google/gson/JsonPrimitive;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class IntValue
extends Value<Integer> {
    private final int maximum;
    private final int minimum;

    private static int $(int n) {
        int[] nArray = new int[4];
        nArray[3] = n >> 24 & 0xFF;
        nArray[2] = n >> 16 & 0xFF;
        nArray[1] = n >> 8 & 0xFF;
        nArray[0] = n & 0xFF;
        for (n = 0; n < nArray.length; ++n) {
            nArray[n] = nArray[n] ^ 0x181984A4;
        }
        return nArray[0] & 0xFF | (nArray[1] & 0xFF) << 8 | (nArray[2] & 0xFF) << 16 | (nArray[3] & 0xFF) << 24;
    }

    public IntValue(String string2, int n, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        super(string2, n);
        this.minimum = n2;
        this.maximum = n3;
    }

    public /* synthetic */ IntValue(String string2, int n, int n2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            n2 = 0;
        }
        if ((n4 & 8) != 0) {
            n3 = IntValue.$(-614769829);
        }
        this(string2, n, n2, n3);
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter((Object)jsonElement, (String)"element");
        if (jsonElement.isJsonPrimitive()) {
            this.setValue(jsonElement.getAsInt());
        }
    }

    public final int getMaximum() {
        return this.maximum;
    }

    public final int getMinimum() {
        return this.minimum;
    }

    @Override
    public final void set(Number number) {
        Intrinsics.checkNotNullParameter((Object)number, (String)"newValue");
        this.set(number.intValue());
    }

    @Override
    public JsonPrimitive toJson() {
        return new JsonPrimitive((Number)this.getValue());
    }
}

