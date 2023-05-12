/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 */
package dev.sora.relay.utils;

import dev.sora.relay.utils.StringUtilsKt;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a8\u0006\t"}, d2={"base64Decode", "", "b64", "", "getRandomString", "length", "", "toHexString", "separator", "ProtoHax"}, k=2, mv={1, 7, 1}, xi=48)
public final class StringUtilsKt {
    public static final byte[] base64Decode(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"b64");
        object = Base64.getDecoder().decode(StringsKt.replace$default((String)StringsKt.replace$default((String)object, (char)'-', (char)'+', (boolean)false, (int)4, null), (char)'_', (char)'/', (boolean)false, (int)4, null));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getDecoder().decode(b64.\u2026, '+').replace('_', '/'))");
        return object;
    }

    public static final String getRandomString(int n) {
        List list = CollectionsKt.plus((Collection)CollectionsKt.plus((Iterable)((Iterable)((Object)new CharRange('A', 'Z'))), (Iterable)((Iterable)((Object)new CharRange('a', 'z')))), (Iterable)((Iterable)((Object)new CharRange('0', '9'))));
        Object object = (Iterable)new IntRange(1, n);
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            ((IntIterator)object).nextInt();
            collection.add(Character.valueOf(((Character)CollectionsKt.random((Collection)list, (Random)Random.Default)).charValue()));
        }
        collection = (List)collection;
        return CollectionsKt.joinToString$default((Iterable)collection, (CharSequence)"", null, null, (int)0, null, null, (int)62, null);
    }

    public static final String toHexString(byte[] byArray, String string2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"separator");
        return ArraysKt.joinToString$default((byte[])byArray, (CharSequence)string2, null, null, (int)0, null, (Function1)toHexString.1.INSTANCE, (int)30, null);
    }

    public static /* synthetic */ String toHexString$default(byte[] byArray, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "";
        }
        return StringUtilsKt.toHexString(byArray, string2);
    }
}

