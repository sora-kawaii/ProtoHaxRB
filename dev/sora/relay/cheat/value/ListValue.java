/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.sora.relay.cheat.value.ListValue$$ExternalSyntheticLambda0;
import dev.sora.relay.cheat.value.Value;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0086\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2={"Ldev/sora/relay/cheat/value/ListValue;", "Ldev/sora/relay/cheat/value/Value;", "", "name", "values", "", "value", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "openList", "", "getOpenList", "()Z", "setOpenList", "(Z)V", "getValues", "()[Ljava/lang/String;", "[Ljava/lang/String;", "changeValue", "", "contains", "string", "fromJson", "element", "Lcom/google/gson/JsonElement;", "toJson", "Lcom/google/gson/JsonPrimitive;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class ListValue
extends Value<String> {
    private boolean openList;
    private final String[] values;

    public static /* synthetic */ boolean $r8$lambda$ila0KAHe4va-gRC8X11HMGaX4_A(Function1 function1, Object object) {
        return ListValue.contains$lambda$0(function1, object);
    }

    public ListValue(String string2, String[] stringArray, String string3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"values");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"value");
        super(string2, string3);
        this.values = stringArray;
        this.setValue(string3);
    }

    private static final boolean contains$lambda$0(Function1 function1, Object object) {
        Intrinsics.checkNotNullParameter((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    @Override
    public void changeValue(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        for (String string3 : this.values) {
            if (!StringsKt.equals((String)string3, (String)string2, (boolean)true)) continue;
            this.setValue(string3);
            break;
        }
    }

    public final boolean contains(String string2) {
        return Arrays.stream(this.values).anyMatch(new ListValue$$ExternalSyntheticLambda0((Function1)new Function1<String, Boolean>(string2){
            final /* synthetic */ String $string;
            {
                this.$string = string2;
                super(1);
            }

            public final Boolean invoke(String string2) {
                Intrinsics.checkNotNullParameter((Object)string2, (String)"s");
                return StringsKt.equals((String)string2, (String)this.$string, (boolean)true);
            }
        }));
    }

    @Override
    public void fromJson(JsonElement object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"element");
        if (((JsonElement)object).isJsonPrimitive()) {
            object = ((JsonElement)object).getAsString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"element.asString");
            this.changeValue((String)object);
        }
    }

    public final boolean getOpenList() {
        return this.openList;
    }

    public final String[] getValues() {
        return this.values;
    }

    public final void setOpenList(boolean bl) {
        this.openList = bl;
    }

    @Override
    public JsonPrimitive toJson() {
        return new JsonPrimitive((String)this.getValue());
    }
}

