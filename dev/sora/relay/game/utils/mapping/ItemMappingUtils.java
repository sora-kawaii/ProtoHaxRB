/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.mapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.sora.relay.game.utils.mapping.AbstractMappingUtils;
import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.utils.mapping.RuntimeMappingImpl;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/game/utils/mapping/ItemMappingUtils;", "Ldev/sora/relay/game/utils/mapping/AbstractMappingUtils;", "()V", "resourcePath", "", "getResourcePath", "()Ljava/lang/String;", "readMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "version", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ItemMappingUtils
extends AbstractMappingUtils {
    public static final ItemMappingUtils INSTANCE = new ItemMappingUtils();

    private ItemMappingUtils() {
    }

    @Override
    protected String getResourcePath() {
        return "/assets/mcpedata/items";
    }

    @Override
    public RuntimeMapping readMapping(short s) {
        if (!ArraysKt.contains((Object[])this.getAvailableVersions(), (Object)s)) {
            return this.getEmptyMapping();
        }
        Object object = AbstractMappingUtils.class.getResourceAsStream(this.getResourcePath() + "/runtime_item_states_" + s + ".json");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"AbstractMappingUtils::cl\u2026em_states_$version.json\")");
        object = JsonParser.parseReader(new InputStreamReader((InputStream)object, Charsets.UTF_8)).getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"parseReader(AbstractMapp\u2026\n            .asJsonArray");
        Object object2 = (Iterable)object;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        Iterator iterator = object2.iterator();
        while (iterator.hasNext()) {
            object2 = ((JsonElement)iterator.next()).getAsJsonObject();
            object.add(TuplesKt.to(((JsonObject)object2).get("name").getAsString(), ((JsonObject)object2).get("id").getAsInt()));
        }
        object = (List)object;
        return new RuntimeMappingImpl((List<Pair<String, Integer>>)object);
    }
}

