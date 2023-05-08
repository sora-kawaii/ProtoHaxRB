/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.entity;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import dev.sora.relay.game.entity.Entity;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2={"Ldev/sora/relay/game/entity/EntityPlayer;", "Ldev/sora/relay/game/entity/Entity;", "runtimeId", "", "uuid", "Ljava/util/UUID;", "username", "", "(JLjava/util/UUID;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getUuid", "()Ljava/util/UUID;", "setUuid", "(Ljava/util/UUID;)V", "onServerPacket", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public class EntityPlayer
extends Entity {
    private String username;
    private UUID uuid;

    public EntityPlayer(long l, UUID uUID, String string) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"uuid");
        Intrinsics.checkNotNullParameter((Object)string, (String)"username");
        super(l);
        this.uuid = uUID;
        this.username = string;
    }

    public final String getUsername() {
        return this.username;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void onServerPacket(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        super.onServerPacket((BedrockPacket)object);
        if (object instanceof MovePlayerPacket && ((MovePlayerPacket)object).getRuntimeEntityId() == this.getRuntimeId()) {
            Vector3f vector3f = ((MovePlayerPacket)object).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"packet.position");
            this.move(vector3f);
            object = ((MovePlayerPacket)object).getRotation();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.rotation");
            this.rotate((Vector3f)object);
        }
    }

    public final void setUsername(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.username = string;
    }

    public final void setUuid(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.uuid = uUID;
    }
}

