/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.sora.relay.cheat.value.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2={"Ldev/sora/relay/cheat/value/StringValue;", "Ldev/sora/relay/cheat/value/Value;", "", "name", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "toJson", "Lcom/google/gson/JsonPrimitive;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class StringValue
extends Value<String> {
    public StringValue(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        super(string, string2);
    }

    @Override
    public void fromJson(JsonElement object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"element");
        if (((JsonElement)object).isJsonPrimitive()) {
            object = ((JsonElement)object).getAsString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"element.asString");
            this.setValue(object);
        }
    }

    @Override
    public JsonPrimitive toJson() {
        return new JsonPrimitive((String)this.getValue());
    }
}

