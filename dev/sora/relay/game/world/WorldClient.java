/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.world;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.packet.AddEntityPacket;
import com.nukkitx.protocol.bedrock.packet.AddItemEntityPacket;
import com.nukkitx.protocol.bedrock.packet.AddPlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerListPacket;
import com.nukkitx.protocol.bedrock.packet.RemoveEntityPacket;
import com.nukkitx.protocol.bedrock.packet.TakeItemEntityPacket;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityItem;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityUnknown;
import dev.sora.relay.game.world.WorldwideBlockStorage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0014"}, d2={"Ldev/sora/relay/game/world/WorldClient;", "Ldev/sora/relay/game/world/WorldwideBlockStorage;", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "entityMap", "", "", "Ldev/sora/relay/game/entity/Entity;", "getEntityMap", "()Ljava/util/Map;", "playerList", "Ljava/util/UUID;", "Lcom/nukkitx/protocol/bedrock/packet/PlayerListPacket$Entry;", "getPlayerList", "onClientPacket", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onServerPacket", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class WorldClient
extends WorldwideBlockStorage {
    private final Map<Long, Entity> entityMap;
    private final Map<UUID, PlayerListPacket.Entry> playerList;

    public WorldClient(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        super(gameSession);
        this.entityMap = new LinkedHashMap();
        this.playerList = new LinkedHashMap();
    }

    public final Map<Long, Entity> getEntityMap() {
        return this.entityMap;
    }

    public final Map<UUID, PlayerListPacket.Entry> getPlayerList() {
        return this.playerList;
    }

    public final void onClientPacket(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof PlayerAuthInputPacket) {
            object = ((Iterable)this.entityMap.values()).iterator();
            while (object.hasNext()) {
                ((Entity)object.next()).onTick();
            }
            this.getSession().getThePlayer().onTick();
        }
    }

    @Override
    public void onServerPacket(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        boolean bl = object instanceof AddEntityPacket;
        Object object2 = "it";
        String object32 = "packet.metadata";
        Object object3 = "packet.rotation";
        Object object4 = "packet.motion";
        String string = "packet.position";
        if (bl) {
            Map<Long, Entity> map = this.entityMap;
            long l = ((AddEntityPacket)object).getRuntimeEntityId();
            long l2 = ((AddEntityPacket)object).getRuntimeEntityId();
            Object object5 = ((AddEntityPacket)object).getIdentifier();
            String string2 = "packet.identifier";
            Intrinsics.checkNotNullExpressionValue((Object)object5, (String)string2);
            object5 = new EntityUnknown(l2, (String)object5);
            ((Entity)object5).setUniqueId(((AddEntityPacket)object).getUniqueEntityId());
            Vector3f vector3f = ((AddEntityPacket)object).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)string);
            ((Entity)object5).position(vector3f);
            Vector3f vector3f2 = ((AddEntityPacket)object).getRotation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)object3);
            ((Entity)object5).rotate(vector3f2);
            Vector3f vector3f3 = ((AddEntityPacket)object).getMotion();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)object4);
            ((Entity)object5).motion(vector3f3);
            object4 = ((AddEntityPacket)object).getIdentifier();
            Intrinsics.checkNotNullExpressionValue((Object)object4, (String)string2);
            ((Entity)object5).setIdentifier((String)object4);
            object4 = ((AddEntityPacket)object).getMetadata();
            Intrinsics.checkNotNullExpressionValue((Object)object4, (String)object32);
            for (Map.Entry entry : ((Map)object4).entrySet()) {
                EntityData entityData = (EntityData)((Object)entry.getKey());
                Object v = entry.getValue();
                ((Map)((Entity)object5).getMetadata()).put(entityData, v);
            }
            object = ((AddEntityPacket)object).getAttributes();
            Intrinsics.checkNotNullExpressionValue(object, (String)"packet.attributes");
            object = (Iterable)object;
            object4 = object.iterator();
            while (object4.hasNext()) {
                AttributeData attributeData = (AttributeData)object4.next();
                object3 = ((Entity)object5).getAttributes();
                String string3 = attributeData.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"it.name");
                Intrinsics.checkNotNullExpressionValue((Object)attributeData, (String)object2);
                object3.put(string3, attributeData);
            }
            map.put(l, (Entity)object5);
        } else if (object instanceof AddItemEntityPacket) {
            object2 = this.entityMap;
            long l = ((AddItemEntityPacket)object).getRuntimeEntityId();
            EntityItem entityItem = new EntityItem(((AddItemEntityPacket)object).getRuntimeEntityId());
            entityItem.setUniqueId(((AddItemEntityPacket)object).getUniqueEntityId());
            Vector3f vector3f = ((AddItemEntityPacket)object).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)string);
            entityItem.position(vector3f);
            object = ((AddItemEntityPacket)object).getMotion();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)object4);
            entityItem.motion((Vector3f)object);
            object2.put(l, entityItem);
        } else if (object instanceof AddPlayerPacket) {
            object2 = this.entityMap;
            long l = ((AddPlayerPacket)object).getRuntimeEntityId();
            long l3 = ((AddPlayerPacket)object).getRuntimeEntityId();
            Object object6 = ((AddPlayerPacket)object).getUuid();
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"packet.uuid");
            Iterator iterator = ((AddPlayerPacket)object).getUsername();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"packet.username");
            object6 = new EntityPlayer(l3, (UUID)object6, (String)((Object)iterator));
            ((Entity)object6).setUniqueId(((AddPlayerPacket)object).getUniqueEntityId());
            iterator = ((AddPlayerPacket)object).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)string);
            ((Entity)object6).position((Vector3f)((Object)iterator));
            iterator = ((AddPlayerPacket)object).getRotation();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)object3);
            ((Entity)object6).rotate((Vector3f)((Object)iterator));
            iterator = ((AddPlayerPacket)object).getMotion();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)object4);
            ((Entity)object6).motion((Vector3f)((Object)iterator));
            iterator = ((AddPlayerPacket)object).getMetadata();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)object32);
            for (Map.Entry entry : ((Map)((Object)iterator)).entrySet()) {
                object4 = (EntityData)((Object)entry.getKey());
                Object v = entry.getValue();
                ((Map)((Entity)object6).getMetadata()).put(object4, v);
            }
            object = ((AddPlayerPacket)object).getHand();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.hand");
            ((Entity)object6).setHeldItemData((ItemData)object);
            object2.put(l, object6);
        } else if (object instanceof RemoveEntityPacket) {
            this.entityMap.remove(((RemoveEntityPacket)object).getUniqueEntityId());
        } else if (object instanceof TakeItemEntityPacket) {
            this.entityMap.remove(((TakeItemEntityPacket)object).getItemRuntimeEntityId());
        } else if (object instanceof PlayerListPacket) {
            boolean bl2 = ((PlayerListPacket)object).getAction() == PlayerListPacket.Action.ADD;
            object = ((PlayerListPacket)object).getEntries();
            Intrinsics.checkNotNullExpressionValue(object, (String)"packet.entries");
            for (PlayerListPacket.Entry entry : (Iterable)object) {
                if (bl2) {
                    object4 = this.playerList;
                    UUID uUID = entry.getUuid();
                    Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"it.uuid");
                    Intrinsics.checkNotNullExpressionValue((Object)entry, (String)object2);
                    object4.put(uUID, entry);
                    continue;
                }
                this.playerList.remove(entry.getUuid());
            }
        } else {
            object2 = ((Iterable)this.entityMap.values()).iterator();
            while (object2.hasNext()) {
                ((Entity)object2.next()).onServerPacket((BedrockPacket)object);
            }
        }
    }
}

