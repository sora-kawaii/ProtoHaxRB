/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 */
package dev.sora.relay.game.utils.mapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dev.sora.relay.game.utils.mapping.EmptyRuntimeMapping;
import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0004\"\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005H&J)\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0004\"\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u0019R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0094\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2={"Ldev/sora/relay/game/utils/mapping/AbstractMappingUtils;", "", "()V", "availableVersions", "", "", "getAvailableVersions", "()[Ljava/lang/Short;", "[Ljava/lang/Short;", "emptyMapping", "Ldev/sora/relay/game/utils/mapping/EmptyRuntimeMapping;", "getEmptyMapping", "()Ldev/sora/relay/game/utils/mapping/EmptyRuntimeMapping;", "resourcePath", "", "getResourcePath", "()Ljava/lang/String;", "craftMapping", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "protocolVersion", "", "options", "(I[Ljava/lang/String;)Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "readMapping", "version", "(S[Ljava/lang/String;)Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class AbstractMappingUtils {
    private final Short[] availableVersions;
    private final EmptyRuntimeMapping emptyMapping = new EmptyRuntimeMapping(null, 0, 3, null);

    public AbstractMappingUtils() {
        Object object = AbstractMappingUtils.class.getResourceAsStream(this.getResourcePath() + "/index.json");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"AbstractMappingUtils::cl\u2026resourcePath/index.json\")");
        object = JsonParser.parseReader(new InputStreamReader((InputStream)object, Charsets.UTF_8)).getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"parseReader(AbstractMapp\u2026_8))\n        .asJsonArray");
        Object object2 = (Iterable)object;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(((JsonElement)object2.next()).getAsShort());
        }
        object = (List)object;
        object = CollectionsKt.sortedWith((Iterable)((Iterable)object), (Comparator)new Comparator(){

            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Comparable)Short.valueOf(((Number)t).shortValue()), (Comparable)Short.valueOf(((Number)t2).shortValue()));
            }
        });
        this.availableVersions = object.toArray(new Short[0]);
    }

    public RuntimeMapping craftMapping(int n, String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"options");
        short s = -1;
        Short[] shortArray = this.getAvailableVersions();
        int n2 = shortArray.length;
        short s2 = s;
        for (int i = 0; i < n2; ++i) {
            short s3 = shortArray[i];
            s = s2;
            if (s2 < s3) {
                s = s2;
                if (n <= s3) {
                    s = s3;
                }
            }
            s2 = s;
        }
        return this.readMapping(s2, Arrays.copyOf(stringArray, stringArray.length));
    }

    protected Short[] getAvailableVersions() {
        return this.availableVersions;
    }

    protected EmptyRuntimeMapping getEmptyMapping() {
        return this.emptyMapping;
    }

    protected abstract String getResourcePath();

    public abstract RuntimeMapping readMapping(short var1);

    public RuntimeMapping readMapping(short s, String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"options");
        return this.readMapping(s);
    }
}

