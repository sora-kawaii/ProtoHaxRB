/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.entity;

import com.nukkitx.math.vector.Vector2f;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityDataMap;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.MobEquipmentPacket;
import com.nukkitx.protocol.bedrock.packet.MoveEntityAbsolutePacket;
import com.nukkitx.protocol.bedrock.packet.MoveEntityDeltaPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAttributesPacket;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020\u0000J\u001e\u0010e\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020$J\u000e\u0010j\u001a\u00020$2\u0006\u0010f\u001a\u00020\u0000J\u001e\u0010j\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020$J\u0010\u0010k\u001a\u00020l2\u0006\u0010k\u001a\u00020\\H\u0016J\u0010\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\\H\u0016J \u0010m\u001a\u00020l2\u0006\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020$H\u0016J\u0010\u0010o\u001a\u00020l2\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020lH\u0016J\u0010\u0010n\u001a\u00020l2\u0006\u0010n\u001a\u00020\\H\u0016J\u0006\u0010s\u001a\u00020lJ\u0010\u0010t\u001a\u00020l2\u0006\u0010u\u001a\u00020\\H\u0016J\u0018\u0010t\u001a\u00020l2\u0006\u0010v\u001a\u00020B2\u0006\u0010w\u001a\u00020BH\u0016J \u0010t\u001a\u00020l2\u0006\u0010v\u001a\u00020B2\u0006\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020BH\u0016J\u000e\u0010u\u001a\u00020y2\u0006\u0010z\u001a\u00020\\R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001a\u00102\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\u001a\u00108\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\u001a\u0010;\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u001a\u0010>\u001a\u00020$X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u001a\u0010A\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001a\u0010J\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR\u001a\u0010M\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR\u001a\u0010P\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010FR\u001a\u0010S\u001a\u00020BX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010D\"\u0004\bU\u0010FR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010W\"\u0004\bZ\u0010\u0004R\u0011\u0010[\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010^R\u0011\u0010_\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\b`\u0010^R\u0011\u0010a\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\bb\u0010^R\u0011\u0010c\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\bd\u0010^\u00a8\u0006{"}, d2={"Ldev/sora/relay/game/entity/Entity;", "", "runtimeId", "", "(J)V", "attributes", "", "", "Lcom/nukkitx/protocol/bedrock/data/AttributeData;", "getAttributes", "()Ljava/util/Map;", "heldItemData", "Lcom/nukkitx/protocol/bedrock/data/inventory/ItemData;", "getHeldItemData", "()Lcom/nukkitx/protocol/bedrock/data/inventory/ItemData;", "setHeldItemData", "(Lcom/nukkitx/protocol/bedrock/data/inventory/ItemData;)V", "heldItemSlot", "", "getHeldItemSlot", "()I", "setHeldItemSlot", "(I)V", "hurtTime", "getHurtTime", "setHurtTime", "identifier", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "metadata", "Lcom/nukkitx/protocol/bedrock/data/entity/EntityDataMap;", "getMetadata", "()Lcom/nukkitx/protocol/bedrock/data/entity/EntityDataMap;", "motionX", "", "getMotionX", "()D", "setMotionX", "(D)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "posX", "getPosX", "setPosX", "posY", "getPosY", "setPosY", "posZ", "getPosZ", "setPosZ", "prevPosX", "getPrevPosX", "setPrevPosX", "prevPosY", "getPrevPosY", "setPrevPosY", "prevPosZ", "getPrevPosZ", "setPrevPosZ", "prevRotationPitch", "", "getPrevRotationPitch", "()F", "setPrevRotationPitch", "(F)V", "prevRotationYaw", "getPrevRotationYaw", "setPrevRotationYaw", "prevRotationYawHead", "getPrevRotationYawHead", "setPrevRotationYawHead", "rotationPitch", "getRotationPitch", "setRotationPitch", "rotationYaw", "getRotationYaw", "setRotationYaw", "rotationYawHead", "getRotationYawHead", "setRotationYawHead", "getRuntimeId", "()J", "uniqueId", "getUniqueId", "setUniqueId", "vec3Position", "Lcom/nukkitx/math/vector/Vector3f;", "getVec3Position", "()Lcom/nukkitx/math/vector/Vector3f;", "vec3PrevPosition", "getVec3PrevPosition", "vec3PrevRotation", "getVec3PrevRotation", "vec3Rotation", "getVec3Rotation", "distance", "entity", "x", "y", "z", "distanceSq", "motion", "", "move", "position", "onServerPacket", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onTick", "reset", "rotate", "rotation", "yaw", "pitch", "headYaw", "Lcom/nukkitx/math/vector/Vector2f;", "to", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class Entity {
    private final Map<String, AttributeData> attributes;
    private ItemData heldItemData;
    private int heldItemSlot;
    private int hurtTime;
    private String identifier;
    private final EntityDataMap metadata;
    private double motionX;
    private double motionY;
    private double motionZ;
    private double posX;
    private double posY;
    private double posZ;
    private double prevPosX;
    private double prevPosY;
    private double prevPosZ;
    private float prevRotationPitch;
    private float prevRotationYaw;
    private float prevRotationYawHead;
    private float rotationPitch;
    private float rotationYaw;
    private float rotationYawHead;
    private final long runtimeId;
    private long uniqueId;

    public Entity(long l) {
        this.runtimeId = l;
        this.attributes = new LinkedHashMap();
        this.metadata = new EntityDataMap();
        this.identifier = "";
        ItemData itemData = ItemData.AIR;
        Intrinsics.checkNotNullExpressionValue((Object)itemData, (String)"AIR");
        this.heldItemData = itemData;
    }

    public final double distance(double d, double d2, double d3) {
        return Math.sqrt(this.distanceSq(d, d2, d3));
    }

    public final double distance(Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return this.distance(entity.getPosX(), entity.getPosY(), entity.getPosZ());
    }

    public final double distanceSq(double d, double d2, double d3) {
        d = this.getPosX() - d;
        d2 = this.getPosY() - d2;
        d3 = this.getPosZ() - d3;
        return d * d + d2 * d2 + d3 * d3;
    }

    public final double distanceSq(Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return this.distanceSq(entity.getPosX(), entity.getPosY(), entity.getPosZ());
    }

    public final Map<String, AttributeData> getAttributes() {
        return this.attributes;
    }

    public final ItemData getHeldItemData() {
        return this.heldItemData;
    }

    public final int getHeldItemSlot() {
        return this.heldItemSlot;
    }

    public final int getHurtTime() {
        return this.hurtTime;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final EntityDataMap getMetadata() {
        return this.metadata;
    }

    public double getMotionX() {
        return this.motionX;
    }

    public double getMotionY() {
        return this.motionY;
    }

    public double getMotionZ() {
        return this.motionZ;
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPosZ() {
        return this.posZ;
    }

    public double getPrevPosX() {
        return this.prevPosX;
    }

    public double getPrevPosY() {
        return this.prevPosY;
    }

    public double getPrevPosZ() {
        return this.prevPosZ;
    }

    public float getPrevRotationPitch() {
        return this.prevRotationPitch;
    }

    public float getPrevRotationYaw() {
        return this.prevRotationYaw;
    }

    public float getPrevRotationYawHead() {
        return this.prevRotationYawHead;
    }

    public float getRotationPitch() {
        return this.rotationPitch;
    }

    public float getRotationYaw() {
        return this.rotationYaw;
    }

    public float getRotationYawHead() {
        return this.rotationYawHead;
    }

    public long getRuntimeId() {
        return this.runtimeId;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public final Vector3f getVec3Position() {
        Vector3f vector3f = Vector3f.from(this.getPosX(), this.getPosY(), this.getPosZ());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from(posX, posY, posZ)");
        return vector3f;
    }

    public final Vector3f getVec3PrevPosition() {
        Vector3f vector3f = Vector3f.from(this.getPrevPosX(), this.getPrevPosX(), this.getPrevPosX());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from(prevPosX, prevPosX, prevPosX)");
        return vector3f;
    }

    public final Vector3f getVec3PrevRotation() {
        Vector3f vector3f = Vector3f.from(this.getPrevRotationYaw(), this.getPrevRotationPitch(), this.getPrevRotationYawHead());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from(prevRotationYaw, pr\u2026tch, prevRotationYawHead)");
        return vector3f;
    }

    public final Vector3f getVec3Rotation() {
        Vector3f vector3f = Vector3f.from(this.getRotationPitch(), this.getRotationYaw(), this.getRotationYawHead());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from(rotationPitch, rotationYaw, rotationYawHead)");
        return vector3f;
    }

    public void motion(Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"motion");
        this.setMotionX(vector3f.getX());
        this.setMotionY(vector3f.getY());
        this.setMotionZ(vector3f.getZ());
    }

    public void move(double d, double d2, double d3) {
        this.setPrevPosX(this.getPosX());
        this.setPrevPosY(this.getPosY());
        this.setPrevPosZ(this.getPosZ());
        this.setPosX(d);
        this.setPosY(d2);
        this.setPosZ(d3);
        this.setMotionX(d - this.getPrevPosX());
        this.setMotionY(d2 - this.getPrevPosY());
        this.setMotionZ(d3 - this.getPrevPosZ());
    }

    public void move(Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"position");
        this.move(vector3f.getX(), vector3f.getY(), vector3f.getZ());
    }

    public void onServerPacket(BedrockPacket object22) {
        Intrinsics.checkNotNullParameter((Object)object22, (String)"packet");
        if (object22 instanceof MoveEntityAbsolutePacket && ((MoveEntityAbsolutePacket)object22).getRuntimeEntityId() == this.getRuntimeId()) {
            Vector3f vector3f = ((MoveEntityAbsolutePacket)object22).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"packet.position");
            this.move(vector3f);
            object22 = ((MoveEntityAbsolutePacket)object22).getRotation();
            Intrinsics.checkNotNullExpressionValue(object22, (String)"packet.rotation");
            this.rotate((Vector3f)object22);
        } else if (object22 instanceof MoveEntityDeltaPacket && ((MoveEntityDeltaPacket)object22).getRuntimeEntityId() == this.getRuntimeId()) {
            double d = this.getPosX();
            boolean bl = ((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_X);
            float f = 0.0f;
            float f2 = bl ? ((MoveEntityDeltaPacket)object22).getX() : 0.0f;
            double d2 = f2;
            double d3 = this.getPosY();
            f2 = ((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_Y) ? ((MoveEntityDeltaPacket)object22).getY() : 0.0f;
            double d4 = f2;
            double d5 = this.getPosZ();
            f2 = ((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_Z) ? ((MoveEntityDeltaPacket)object22).getZ() : 0.0f;
            this.move(d + d2, d3 + d4, d5 + (double)f2);
            float f3 = this.getRotationYaw();
            f2 = ((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_YAW) ? ((MoveEntityDeltaPacket)object22).getYaw() : 0.0f;
            float f4 = this.getRotationPitch();
            float f5 = ((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_PITCH) ? ((MoveEntityDeltaPacket)object22).getPitch() : 0.0f;
            float f6 = this.getRotationYawHead();
            if (((MoveEntityDeltaPacket)object22).getFlags().contains((Object)MoveEntityDeltaPacket.Flag.HAS_HEAD_YAW)) {
                f = ((MoveEntityDeltaPacket)object22).getHeadYaw();
            }
            this.rotate(f3 + f2, f4 + f5, f6 + f);
        } else if (object22 instanceof SetEntityDataPacket && ((SetEntityDataPacket)object22).getRuntimeEntityId() == this.getRuntimeId()) {
            object22 = ((SetEntityDataPacket)object22).getMetadata();
            Intrinsics.checkNotNullExpressionValue((Object)object22, (String)"packet.metadata");
            for (Map.Entry string2 : ((Map)object22).entrySet()) {
                EntityData entityData = (EntityData)((Object)string2.getKey());
                Object entry = string2.getValue();
                ((Map)this.metadata).put(entityData, entry);
            }
        } else if (object22 instanceof MobEquipmentPacket && ((MobEquipmentPacket)object22).getRuntimeEntityId() == this.getRuntimeId()) {
            this.heldItemSlot = ((MobEquipmentPacket)object22).getHotbarSlot();
            object22 = ((MobEquipmentPacket)object22).getItem();
            Intrinsics.checkNotNullExpressionValue((Object)object22, (String)"packet.item");
            this.heldItemData = object22;
        } else if (object22 instanceof UpdateAttributesPacket && ((UpdateAttributesPacket)object22).getRuntimeEntityId() == this.getRuntimeId()) {
            object22 = ((UpdateAttributesPacket)object22).getAttributes();
            Intrinsics.checkNotNullExpressionValue(object22, (String)"packet.attributes");
            for (Object object22 : (Iterable)object22) {
                Map<String, AttributeData> map = this.attributes;
                String string2 = ((AttributeData)object22).getName();
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"it.name");
                Intrinsics.checkNotNullExpressionValue((Object)object22, (String)"it");
                map.put(string2, (AttributeData)object22);
            }
        } else if (object22 instanceof EntityEventPacket && ((EntityEventPacket)object22).getRuntimeEntityId() == this.getRuntimeId() && ((EntityEventPacket)object22).getType() == EntityEventType.HURT) {
            this.hurtTime = 10;
        }
    }

    public void onTick() {
        int n = this.hurtTime;
        if (n > 0) {
            this.hurtTime = n - 1;
        }
    }

    public void position(Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"position");
        this.move(vector3f.getX(), vector3f.getY(), vector3f.getZ());
    }

    public final void reset() {
        this.attributes.clear();
        this.metadata.clear();
    }

    public void rotate(float f, float f2) {
        this.setPrevRotationYaw(this.getRotationYaw());
        this.setPrevRotationPitch(this.getRotationPitch());
        this.setPrevRotationYawHead(this.getRotationYawHead());
        this.setRotationYaw(f);
        this.setRotationPitch(f2);
        this.setRotationYawHead(f);
    }

    public void rotate(float f, float f2, float f3) {
        this.rotate(f, f2);
        this.setRotationYawHead(f3);
    }

    public void rotate(Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"rotation");
        this.rotate(vector3f.getY(), vector3f.getX(), vector3f.getZ());
    }

    public final Vector2f rotation(Vector3f vectorf) {
        Intrinsics.checkNotNullParameter((Object)vectorf, (String)"to");
        double d = (double)vectorf.getX() - this.getPosX();
        double d2 = vectorf.getY();
        double d3 = this.getPosY();
        double d4 = (double)vectorf.getZ() - this.getPosZ();
        vectorf = Vector2f.from((float)(-Math.toDegrees(Math.atan2(d2 - d3, Math.sqrt(d * d + d4 * d4)))), (float)Math.toDegrees(Math.atan2(d4, d)) - 90.0f);
        Intrinsics.checkNotNullExpressionValue((Object)vectorf, (String)"from(\n            ((-Mat\u2026oFloat() - 90f)\n        )");
        return vectorf;
    }

    public final void setHeldItemData(ItemData itemData) {
        Intrinsics.checkNotNullParameter((Object)itemData, (String)"<set-?>");
        this.heldItemData = itemData;
    }

    public final void setHeldItemSlot(int n) {
        this.heldItemSlot = n;
    }

    public final void setHurtTime(int n) {
        this.hurtTime = n;
    }

    public final void setIdentifier(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<set-?>");
        this.identifier = string2;
    }

    public void setMotionX(double d) {
        this.motionX = d;
    }

    public void setMotionY(double d) {
        this.motionY = d;
    }

    public void setMotionZ(double d) {
        this.motionZ = d;
    }

    public void setPosX(double d) {
        this.posX = d;
    }

    public void setPosY(double d) {
        this.posY = d;
    }

    public void setPosZ(double d) {
        this.posZ = d;
    }

    public void setPrevPosX(double d) {
        this.prevPosX = d;
    }

    public void setPrevPosY(double d) {
        this.prevPosY = d;
    }

    public void setPrevPosZ(double d) {
        this.prevPosZ = d;
    }

    public void setPrevRotationPitch(float f) {
        this.prevRotationPitch = f;
    }

    public void setPrevRotationYaw(float f) {
        this.prevRotationYaw = f;
    }

    public void setPrevRotationYawHead(float f) {
        this.prevRotationYawHead = f;
    }

    public void setRotationPitch(float f) {
        this.rotationPitch = f;
    }

    public void setRotationYaw(float f) {
        this.rotationYaw = f;
    }

    public void setRotationYawHead(float f) {
        this.rotationYawHead = f;
    }

    public void setUniqueId(long l) {
        this.uniqueId = l;
    }
}

