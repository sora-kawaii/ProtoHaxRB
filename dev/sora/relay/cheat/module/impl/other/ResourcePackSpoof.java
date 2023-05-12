/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.MapsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package dev.sora.relay.cheat.module.impl.other;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.ResourcePackType;
import com.nukkitx.protocol.bedrock.packet.ResourcePackChunkDataPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackChunkRequestPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackClientResponsePacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackDataInfoPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackStackPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePacksInfoPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import java.io.File;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2={"Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "RESOURCE_PACK_CHUNK_SIZE", "", "acceptServerPacks", "Ldev/sora/relay/cheat/value/BoolValue;", "resourcePackProvider", "Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;", "getResourcePackProvider", "()Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;", "setResourcePackProvider", "(Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;)V", "getPackChunk", "", "data", "off", "len", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onPacketOutbound", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "EmptyResourcePackProvider", "FileSystemResourcePackProvider", "IResourcePackProvider", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ResourcePackSpoof
extends CheatModule {
    public static final ResourcePackSpoof INSTANCE = new ResourcePackSpoof();
    private static final int RESOURCE_PACK_CHUNK_SIZE = 8192;
    private static final BoolValue acceptServerPacks = new BoolValue("AcceptServerPacks", false);
    private static IResourcePackProvider resourcePackProvider = new EmptyResourcePackProvider();

    private ResourcePackSpoof() {
        super("ResourcePackSpoof", false, false, 6, null);
    }

    private final byte[] getPackChunk(byte[] byArray, int n, int n2) {
        byte[] byArray2 = byArray.length - n > n2 ? new byte[n2] : new byte[byArray.length - n];
        int n3 = byArray2.length;
        for (n2 = 0; n2 < n3; ++n2) {
            byArray2[n2] = byArray[n + n2];
        }
        return byArray2;
    }

    public final IResourcePackProvider getResourcePackProvider() {
        return resourcePackProvider;
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((EventPacketInbound)object).getPacket();
        if (object instanceof ResourcePacksInfoPacket) {
            if (!((Boolean)acceptServerPacks.get()).booleanValue()) {
                ((ResourcePacksInfoPacket)object).getResourcePackInfos().clear();
                ((ResourcePacksInfoPacket)object).getBehaviorPackInfos().clear();
            }
            ((ResourcePacksInfoPacket)object).getResourcePackInfos().addAll(resourcePackProvider.getEntry());
        } else if (object instanceof ResourcePackStackPacket && !((Boolean)acceptServerPacks.get()).booleanValue()) {
            ((ResourcePackStackPacket)object).getResourcePacks().clear();
            ((ResourcePackStackPacket)object).getBehaviorPacks().clear();
        }
    }

    @Listen
    public final void onPacketOutbound(EventPacketOutbound eventPacketOutbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketOutbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketOutbound.getPacket();
        if (bedrockPacket instanceof ResourcePackClientResponsePacket) {
            if (((ResourcePackClientResponsePacket)bedrockPacket).getStatus() == ResourcePackClientResponsePacket.Status.SEND_PACKS) {
                Iterable<String> iterable = ((ResourcePackClientResponsePacket)bedrockPacket).getPackIds();
                Intrinsics.checkNotNullExpressionValue(iterable, (String)"packet.packIds");
                Iterator<String> iterator = iterable;
                iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)((Object)iterator), (int)10));
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    iterable.add((String)string2);
                }
                iterable = iterable;
                for (String string2 : iterable) {
                    Object object = resourcePackProvider;
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"it");
                    Pair<ResourcePacksInfoPacket.Entry, byte[]> pair = object.getPackById(string2);
                    if (pair == null) continue;
                    RakNetRelaySession rakNetRelaySession = eventPacketOutbound.getSession().getNetSession();
                    object = new ResourcePackDataInfoPacket();
                    ((ResourcePackDataInfoPacket)object).setPackId(UUID.fromString(pair.getFirst().getPackId()));
                    ((ResourcePackDataInfoPacket)object).setPackVersion(pair.getFirst().getPackVersion());
                    ((ResourcePackDataInfoPacket)object).setMaxChunkSize(8192L);
                    ((ResourcePackDataInfoPacket)object).setChunkCount(pair.getFirst().getPackSize() / (long)8192);
                    ((ResourcePackDataInfoPacket)object).setCompressedPackSize(pair.getFirst().getPackSize());
                    ((ResourcePackDataInfoPacket)object).setHash(MessageDigest.getInstance("SHA-256").digest(pair.getSecond()));
                    ((ResourcePackDataInfoPacket)object).setType(ResourcePackType.RESOURCE);
                    rakNetRelaySession.inboundPacket((BedrockPacket)object);
                    ((ResourcePackClientResponsePacket)bedrockPacket).getPackIds().remove(string2);
                }
                if (((ResourcePackClientResponsePacket)bedrockPacket).getPackIds().isEmpty()) {
                    eventPacketOutbound.cancel();
                }
            }
        } else if (bedrockPacket instanceof ResourcePackChunkRequestPacket) {
            Object object = resourcePackProvider;
            Object object2 = ((ResourcePackChunkRequestPacket)bedrockPacket).getPackId().toString();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.packId.toString()");
            object = object.getPackById((String)object2);
            if (object == null) {
                return;
            }
            object2 = eventPacketOutbound.getSession().getNetSession();
            ResourcePackChunkDataPacket resourcePackChunkDataPacket = new ResourcePackChunkDataPacket();
            resourcePackChunkDataPacket.setPackId(((ResourcePackChunkRequestPacket)bedrockPacket).getPackId());
            resourcePackChunkDataPacket.setPackVersion(((ResourcePackChunkRequestPacket)bedrockPacket).getPackVersion());
            resourcePackChunkDataPacket.setChunkIndex(((ResourcePackChunkRequestPacket)bedrockPacket).getChunkIndex());
            resourcePackChunkDataPacket.setProgress(resourcePackChunkDataPacket.getChunkIndex() * 8192);
            resourcePackChunkDataPacket.setData(INSTANCE.getPackChunk((byte[])((Pair)object).getSecond(), (int)resourcePackChunkDataPacket.getProgress(), 8192));
            ((RakNetRelaySession)object2).inboundPacket(resourcePackChunkDataPacket);
            eventPacketOutbound.cancel();
        }
    }

    public final void setResourcePackProvider(IResourcePackProvider iResourcePackProvider) {
        Intrinsics.checkNotNullParameter((Object)iResourcePackProvider, (String)"<set-?>");
        resourcePackProvider = iResourcePackProvider;
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$EmptyResourcePackProvider;", "Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;", "()V", "getEntry", "", "Lcom/nukkitx/protocol/bedrock/packet/ResourcePacksInfoPacket$Entry;", "getPackById", "Lkotlin/Pair;", "", "id", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class EmptyResourcePackProvider
    implements IResourcePackProvider {
        @Override
        public Collection<ResourcePacksInfoPacket.Entry> getEntry() {
            return CollectionsKt.emptyList();
        }

        @Override
        public Pair<ResourcePacksInfoPacket.Entry, byte[]> getPackById(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"id");
            return null;
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$FileSystemResourcePackProvider;", "Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;", "dir", "Ljava/io/File;", "(Ljava/io/File;)V", "files", "", "Lcom/nukkitx/protocol/bedrock/packet/ResourcePacksInfoPacket$Entry;", "", "getEntry", "", "getPackById", "Lkotlin/Pair;", "idRaw", "", "readManifest", "file", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class FileSystemResourcePackProvider
    implements IResourcePackProvider {
        private final Map<ResourcePacksInfoPacket.Entry, byte[]> files;

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public FileSystemResourcePackProvider(File var1_1) {
            block6: {
                block5: {
                    Intrinsics.checkNotNullParameter((Object)var1_1, (String)"dir");
                    super();
                    var2_2 = var1_1.listFiles();
                    if (var2_2 == null) break block5;
                    var3_3 = new ArrayList<E>();
                    var4_4 = ((File[])var2_2).length;
                    var5_5 = 0;
                    var1_1 = var2_2;
                    while (true) {
                        var6_6 = "it";
                        if (var5_5 >= var4_4) break;
                        var7_7 /* !! */  = var2_2[var5_5];
                        if (!var7_7 /* !! */ .isFile()) ** GOTO lbl-1000
                        var8_8 = var7_7 /* !! */ .getCanonicalPath();
                        Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)var6_6);
                        var9_9 = StringsKt.endsWith$default((String)var8_8, (String)".zip", (boolean)false, (int)2, null) || StringsKt.endsWith$default((String)var8_8, (String)".mcpack", (boolean)false, (int)2, null);
                        if (var9_9) {
                            var9_9 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var9_9 = false;
                        }
                        if (var9_9) {
                            var3_3.add(var7_7 /* !! */ );
                        }
                        ++var5_5;
                    }
                    var1_1 = (List)var3_3;
                    var1_1 = (Iterable)var1_1;
                    var2_2 = new LinkedHashMap<K, V>(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)var1_1, (int)10)), (int)16));
                    var3_3 = var1_1.iterator();
                    while (var3_3.hasNext()) {
                        var8_8 = (File)var3_3.next();
                        Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)var6_6);
                        var7_7 /* !! */  = (Pair<ResourcePacksInfoPacket.Entry, Object>)FilesKt.readBytes((File)var8_8);
                        var8_8 = this.readManifest((File)var8_8);
                        var7_7 /* !! */  = TuplesKt.to(new ResourcePacksInfoPacket.Entry(var8_8.getFirst(), var8_8.getSecond(), ((Object)var7_7 /* !! */ ).length, "", "", "", false, false), var7_7 /* !! */ );
                        var2_2.put(var7_7 /* !! */ .getFirst(), var7_7 /* !! */ .getSecond());
                    }
                    var1_1 = var2_2;
                    break block6;
                }
                var1_1 = MapsKt.emptyMap();
            }
            this.files = var1_1;
        }

        private final Pair<String, String> readManifest(File object) {
            Object object2 = new ZipFile((File)object);
            ZipEntry zipEntry = ((ZipFile)object2).getEntry("manifest.json");
            if (zipEntry != null) {
                object2 = JsonParser.parseReader(new InputStreamReader(((ZipFile)object2).getInputStream(zipEntry))).getAsJsonObject().getAsJsonObject("header");
                object = ((JsonObject)object2).get("uuid").getAsString();
                object2 = ((JsonObject)object2).getAsJsonArray("version");
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"manifest.getAsJsonArray(\"version\")");
                return TuplesKt.to(object, CollectionsKt.joinToString$default((Iterable)((Iterable)object2), (CharSequence)".", null, null, (int)0, null, null, (int)62, null));
            }
            throw new IllegalStateException(("no manifest found in resource pack file: " + ((File)object).getCanonicalPath()).toString());
        }

        @Override
        public Collection<ResourcePacksInfoPacket.Entry> getEntry() {
            return this.files.keySet();
        }

        @Override
        public Pair<ResourcePacksInfoPacket.Entry, byte[]> getPackById(String object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"idRaw");
            String string2 = (String)StringsKt.split$default((CharSequence)((CharSequence)((Object)object)), (String[])new String[]{"_"}, (boolean)false, (int)0, (int)6, null).get(0);
            for (Map.Entry<ResourcePacksInfoPacket.Entry, byte[]> entry : this.files.entrySet()) {
                if (!Intrinsics.areEqual((Object)entry.getKey().getPackId(), (Object)string2)) continue;
                return TuplesKt.to(entry.getKey(), entry.getValue());
            }
            return null;
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2={"Ldev/sora/relay/cheat/module/impl/other/ResourcePackSpoof$IResourcePackProvider;", "", "getEntry", "", "Lcom/nukkitx/protocol/bedrock/packet/ResourcePacksInfoPacket$Entry;", "getPackById", "Lkotlin/Pair;", "", "id", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static interface IResourcePackProvider {
        public Collection<ResourcePacksInfoPacket.Entry> getEntry();

        public Pair<ResourcePacksInfoPacket.Entry, byte[]> getPackById(String var1);
    }
}

