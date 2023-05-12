/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.management;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.ClientCacheBlobStatusPacket;
import com.nukkitx.protocol.bedrock.packet.ClientCacheMissResponsePacket;
import dev.sora.relay.game.management.BlobCacheManager$$ExternalSyntheticLambda0;
import dev.sora.relay.game.management.BlobCacheManager$$ExternalSyntheticLambda1;
import dev.sora.relay.utils.LoggerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/game/management/BlobCacheManager;", "", "()V", "cacheCallbacks", "", "", "Lkotlin/Function1;", "", "", "clientAcknowledgements", "", "clear", "onClientPacket", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onServerPacket", "registerCacheCallback", "blobId", "callback", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class BlobCacheManager {
    private final Map<Long, Function1<byte[], Unit>> cacheCallbacks;
    private final List<Long> clientAcknowledgements = new ArrayList();

    public static /* synthetic */ boolean $r8$lambda$AF0yBancEasYE9rbQvdTeGJLaBw(Function1 function1, Object object) {
        return BlobCacheManager.onClientPacket$lambda$0(function1, object);
    }

    public static /* synthetic */ boolean $r8$lambda$cSpZDqIIlNoMjmMkVehcN8zubWU(Function1 function1, Object object) {
        return BlobCacheManager.onClientPacket$lambda$2(function1, object);
    }

    public BlobCacheManager() {
        this.cacheCallbacks = new LinkedHashMap();
    }

    private static final boolean onClientPacket$lambda$0(Function1 function1, Object object) {
        Intrinsics.checkNotNullParameter((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    private static final boolean onClientPacket$lambda$2(Function1 function1, Object object) {
        Intrinsics.checkNotNullParameter((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    public final void clear() {
        this.clientAcknowledgements.clear();
        this.cacheCallbacks.clear();
    }

    public final void onClientPacket(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        if (bedrockPacket instanceof ClientCacheBlobStatusPacket) {
            List<Long> list = this.clientAcknowledgements;
            Object object = ((ClientCacheBlobStatusPacket)bedrockPacket).getAcks();
            Object object2 = "packet.acks";
            Intrinsics.checkNotNullExpressionValue(object, (String)object2);
            list.addAll((Collection)object);
            this.clientAcknowledgements.removeIf(new BlobCacheManager$$ExternalSyntheticLambda0((Function1)new Function1<Long, Boolean>(bedrockPacket){
                final /* synthetic */ BedrockPacket $packet;
                {
                    this.$packet = bedrockPacket;
                    super(1);
                }

                public final Boolean invoke(Long l) {
                    Intrinsics.checkNotNullParameter((Object)l, (String)"it");
                    return ((ClientCacheBlobStatusPacket)this.$packet).getNaks().contains(l);
                }
            }));
            list = ((ClientCacheBlobStatusPacket)bedrockPacket).getNaks();
            object = ((ClientCacheBlobStatusPacket)bedrockPacket).getAcks();
            Intrinsics.checkNotNullExpressionValue(object, (String)object2);
            object = (Iterable)object;
            object2 = new ArrayList();
            Iterator<Long> iterator = object.iterator();
            while (iterator.hasNext()) {
                Long l = iterator.next();
                object = l;
                if (!this.cacheCallbacks.containsKey(object)) continue;
                object2.add(l);
            }
            object2 = (List)object2;
            ((ArrayList)list).addAll((Collection)object2);
            ((ClientCacheBlobStatusPacket)bedrockPacket).getAcks().removeIf(new BlobCacheManager$$ExternalSyntheticLambda1((Function1)new Function1<Long, Boolean>(bedrockPacket){
                final /* synthetic */ BedrockPacket $packet;
                {
                    this.$packet = bedrockPacket;
                    super(1);
                }

                public final Boolean invoke(Long l) {
                    return ((ClientCacheBlobStatusPacket)this.$packet).getNaks().contains(l);
                }
            }));
        }
    }

    public final void onServerPacket(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        if (bedrockPacket instanceof ClientCacheMissResponsePacket) {
            Object object22 = ((ClientCacheMissResponsePacket)bedrockPacket).getBlobs();
            Intrinsics.checkNotNullExpressionValue(object22, (String)"packet.blobs");
            for (Map.Entry throwable : object22.entrySet()) {
                Function1<byte[], Unit> function1 = (Long)throwable.getKey();
                byte[] byArray = (byte[])throwable.getValue();
                if ((function1 = this.cacheCallbacks.get(function1)) == null) continue;
                try {
                    Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"data");
                    function1.invoke((Object)byArray);
                }
                catch (Throwable throwable2) {
                    LoggerKt.logError("cache callback", throwable2);
                }
            }
            Iterable iterable = ((ClientCacheMissResponsePacket)bedrockPacket).getBlobs().keySet();
            object22 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            for (Long l : iterable) {
                object22.add(l);
            }
            object22 = (List)object22;
            for (Object object22 : (Iterable)object22) {
                if (!this.clientAcknowledgements.contains(object22)) continue;
                ((ClientCacheMissResponsePacket)bedrockPacket).getBlobs().remove(object22);
            }
        }
    }

    public final void registerCacheCallback(long l, Function1<? super byte[], Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"callback");
        this.cacheCallbacks.put(l, function1);
    }
}

