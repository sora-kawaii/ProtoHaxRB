/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.sora.relay.cheat.value.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Ldev/sora/relay/cheat/value/BoolValue;", "Ldev/sora/relay/cheat/value/Value;", "", "name", "", "value", "(Ljava/lang/String;Z)V", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "toJson", "Lcom/google/gson/JsonPrimitive;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class BoolValue
extends Value<Boolean> {
    public BoolValue(String string2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        super(string2, bl);
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter((Object)jsonElement, (String)"element");
        if (jsonElement.isJsonPrimitive()) {
            boolean bl;
            boolean bl2 = jsonElement.getAsBoolean();
            boolean bl3 = bl = true;
            if (!bl2) {
                bl3 = StringsKt.equals((String)jsonElement.getAsString(), (String)"true", (boolean)true) ? bl : false;
            }
            this.setValue(bl3);
        }
    }

    @Override
    public JsonPrimitive toJson() {
        return new JsonPrimitive((Boolean)this.getValue());
    }
}

