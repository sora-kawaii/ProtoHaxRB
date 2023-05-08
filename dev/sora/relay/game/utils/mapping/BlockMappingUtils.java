/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils.mapping;

import com.nukkitx.nbt.NBTInputStream;
import com.nukkitx.nbt.NbtList;
import com.nukkitx.nbt.NbtMap;
import dev.sora.relay.game.utils.mapping.AbstractMappingUtils;
import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.utils.mapping.RuntimeMappingImpl;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2={"Ldev/sora/relay/game/utils/mapping/BlockMappingUtils;", "Ldev/sora/relay/game/utils/mapping/AbstractMappingUtils;", "()V", "resourcePath", "", "getResourcePath", "()Ljava/lang/String;", "getBlockNameFromNbt", "nbt", "Lcom/nukkitx/nbt/NbtMap;", "readMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "version", "", "options", "", "(S[Ljava/lang/String;)Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class BlockMappingUtils
extends AbstractMappingUtils {
    public static final BlockMappingUtils INSTANCE = new BlockMappingUtils();

    private BlockMappingUtils() {
    }

    public final String getBlockNameFromNbt(NbtMap object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"nbt");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((NbtMap)object).getString("name"));
        Iterator iterator = ((NbtMap)object).getCompound("states");
        object = iterator;
        if (iterator == null) {
            object = NbtMap.builder().build();
        }
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"nbt.getCompound(\"states\"\u2026 NbtMap.builder().build()");
        iterator = (Map)object;
        object = new ArrayList(iterator.size());
        for (Map.Entry entry : iterator.entrySet()) {
            object.add(entry);
        }
        object = (List)object;
        if (((Collection)(object = CollectionsKt.sortedWith((Iterable)((Iterable)object), (Comparator)new Comparator(){

            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Comparable)((Comparable)((Object)((String)((Map.Entry)t).getKey()))), (Comparable)((Comparable)((Object)((String)((Map.Entry)t2).getKey()))));
            }
        }))).isEmpty() ^ true) {
            stringBuilder.append("[");
            for (Map.Entry entry : (Iterable)object) {
                object = (String)entry.getKey();
                Object v = entry.getValue();
                stringBuilder.append((String)object);
                stringBuilder.append("=");
                stringBuilder.append(v);
                stringBuilder.append(",");
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            stringBuilder.append("]");
        }
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"sb.toString()");
        return object;
    }

    @Override
    protected String getResourcePath() {
        return "/assets/mcpedata/blocks";
    }

    @Override
    public RuntimeMapping readMapping(short s) {
        return this.readMapping(s, Arrays.copyOf(new String[0], 0));
    }

    @Override
    public RuntimeMapping readMapping(short s, String ... object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"options");
        if (!ArraysKt.contains((Object[])this.getAvailableVersions(), (Object)s)) {
            return this.getEmptyMapping();
        }
        Object object2 = new NBTInputStream(new DataInputStream(new GZIPInputStream(AbstractMappingUtils.class.getResourceAsStream(this.getResourcePath() + "/runtime_block_states_" + s + ".dat")))).readTag();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type com.nukkitx.nbt.NbtList<com.nukkitx.nbt.NbtMap>");
        Object object32 = (NbtList)object2;
        Map map = new LinkedHashMap();
        object2 = new LinkedHashMap();
        boolean bl = ArraysKt.contains((Object[])object, (Object)"legacy");
        object = "subtag";
        if (bl) {
            for (Object object32 : (Iterable)object32) {
                Object object4 = INSTANCE;
                Intrinsics.checkNotNullExpressionValue((Object)object32, (String)object);
                object4 = ((BlockMappingUtils)object4).getBlockNameFromNbt((NbtMap)object32);
                map.put(((NbtMap)object32).getInt("id") << 6 | ((NbtMap)object32).getShort("data"), object4);
            }
        } else {
            for (Object object32 : (Iterable)object32) {
                Object object5 = INSTANCE;
                Intrinsics.checkNotNullExpressionValue((Object)object32, (String)object);
                object5 = ((BlockMappingUtils)object5).getBlockNameFromNbt((NbtMap)object32);
                int n = ((NbtMap)object32).getInt("runtimeId");
                map.put(n, object5);
                object2.put(object5, n);
            }
        }
        return new RuntimeMappingImpl(map, (Map<String, Integer>)object2);
    }
}

