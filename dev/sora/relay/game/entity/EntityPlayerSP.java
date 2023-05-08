/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.entity;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.data.PlayerActionType;
import com.nukkitx.protocol.bedrock.data.PlayerAuthInputData;
import com.nukkitx.protocol.bedrock.data.PlayerBlockActionData;
import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.data.inventory.TransactionType;
import com.nukkitx.protocol.bedrock.packet.AnimatePacket;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEvent2Packet;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEventPacket;
import com.nukkitx.protocol.bedrock.packet.MobEquipmentPacket;
import com.nukkitx.protocol.bedrock.packet.ModalFormRequestPacket;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerActionPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerHotbarPacket;
import com.nukkitx.protocol.bedrock.packet.RespawnPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityMotionPacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateAttributesPacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u0016\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u0002072\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0016\u0010B\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u0006\u0010C\u001a\u00020!J\u0010\u0010D\u001a\u0002072\b\b\u0002\u0010E\u001a\u00020\u0006J\u000e\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u0002072\u0006\u0010G\u001a\u00020HJ\u000e\u0010J\u001a\u0002072\u0006\u0010K\u001a\u000201J\u001e\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006J\u0010\u0010P\u001a\u0002072\b\b\u0002\u0010Q\u001a\u00020!J\u0018\u0010R\u001a\u0002072\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010S\u001a\u00020!J(\u0010R\u001a\u0002072\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\b\b\u0002\u0010S\u001a\u00020!R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR>\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006T"}, d2={"Ldev/sora/relay/game/entity/EntityPlayerSP;", "Ldev/sora/relay/game/entity/EntityPlayer;", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "direction", "", "getDirection", "()D", "inputData", "Ljava/util/EnumSet;", "Lcom/nukkitx/protocol/bedrock/data/PlayerAuthInputData;", "kotlin.jvm.PlatformType", "getInputData", "()Ljava/util/EnumSet;", "setInputData", "(Ljava/util/EnumSet;)V", "lastModalForm", "Lcom/nukkitx/protocol/bedrock/packet/ModalFormRequestPacket;", "getLastModalForm", "()Lcom/nukkitx/protocol/bedrock/packet/ModalFormRequestPacket;", "setLastModalForm", "(Lcom/nukkitx/protocol/bedrock/packet/ModalFormRequestPacket;)V", "moveForward", "", "getMoveForward", "()F", "setMoveForward", "(F)V", "moveStrafing", "getMoveStrafing", "setMoveStrafing", "onGround", "", "getOnGround", "()Z", "setOnGround", "(Z)V", "pendingInputData", "", "getPendingInputData", "()Ljava/util/Set;", "runtimeId", "", "getRuntimeId", "()J", "setRuntimeId", "(J)V", "xuid", "", "getXuid", "()Ljava/lang/String;", "setXuid", "(Ljava/lang/String;)V", "attack", "", "entity", "Ldev/sora/relay/game/entity/Entity;", "pos", "Lcom/nukkitx/math/vector/Vector3f;", "click", "position", "Lcom/nukkitx/math/vector/Vector3i;", "face", "", "destroy", "interact", "isHorizontallyMove", "jump", "height", "onClientPacketSP", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onServerPacketSP", "say", "text", "setMotion", "x", "y", "z", "swing", "serverSide", "teleportTo", "lerp", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class EntityPlayerSP
extends EntityPlayer {
    private EnumSet<PlayerAuthInputData> inputData;
    private ModalFormRequestPacket lastModalForm;
    private float moveForward;
    private float moveStrafing;
    private boolean onGround;
    private final Set<PlayerAuthInputData> pendingInputData;
    private long runtimeId;
    private final GameSession session;
    private String xuid;

    public EntityPlayerSP(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        UUID uUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"randomUUID()");
        String string = "";
        super(0L, uUID, string);
        this.session = gameSession;
        this.xuid = string;
        this.onGround = true;
        this.inputData = EnumSet.noneOf(PlayerAuthInputData.class);
        this.pendingInputData = new LinkedHashSet();
        this.lastModalForm = new ModalFormRequestPacket();
    }

    public static /* synthetic */ void jump$default(EntityPlayerSP entityPlayerSP, double d, int n, Object object) {
        if ((n & 1) != 0) {
            d = 0.3332;
        }
        entityPlayerSP.jump(d);
    }

    public static /* synthetic */ void swing$default(EntityPlayerSP entityPlayerSP, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        entityPlayerSP.swing(bl);
    }

    public static /* synthetic */ void teleportTo$default(EntityPlayerSP entityPlayerSP, double d, double d2, double d3, boolean bl, int n, Object object) {
        if ((n & 8) != 0) {
            bl = false;
        }
        entityPlayerSP.teleportTo(d, d2, d3, bl);
    }

    public static /* synthetic */ void teleportTo$default(EntityPlayerSP entityPlayerSP, Vector3f vector3f, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        entityPlayerSP.teleportTo(vector3f, bl);
    }

    public final void attack(Entity entity, Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"pos");
        Object object = this.session;
        Object object2 = new LevelSoundEventPacket();
        ((LevelSoundEvent2Packet)object2).setSound(SoundEvent.ATTACK_STRONG);
        ((LevelSoundEvent2Packet)object2).setPosition(this.getVec3Position());
        ((LevelSoundEvent2Packet)object2).setExtraData(-1);
        ((LevelSoundEvent2Packet)object2).setIdentifier("minecraft:player");
        ((LevelSoundEvent2Packet)object2).setBabySound(false);
        ((LevelSoundEvent2Packet)object2).setRelativeVolumeDisabled(false);
        ((GameSession)object).sendPacket((BedrockPacket)object2);
        object2 = this.session;
        object = new InventoryTransactionPacket();
        ((InventoryTransactionPacket)object).setTransactionType(TransactionType.ITEM_USE_ON_ENTITY);
        ((InventoryTransactionPacket)object).setActionType(1);
        ((InventoryTransactionPacket)object).setRuntimeEntityId(entity.getRuntimeId());
        ((InventoryTransactionPacket)object).setHotbarSlot(this.getHeldItemSlot());
        ((InventoryTransactionPacket)object).setItemInHand(this.getHeldItemData());
        ((InventoryTransactionPacket)object).setPlayerPosition(vector3f);
        ((InventoryTransactionPacket)object).setClickPosition(Vector3f.ZERO);
        ((GameSession)object2).sendPacket((BedrockPacket)object);
    }

    public final void click(Vector3i vector3i, int n) {
        Intrinsics.checkNotNullParameter((Object)vector3i, (String)"position");
        GameSession gameSession = this.session;
        InventoryTransactionPacket inventoryTransactionPacket = new InventoryTransactionPacket();
        inventoryTransactionPacket.setTransactionType(TransactionType.ITEM_USE);
        inventoryTransactionPacket.setActionType(0);
        inventoryTransactionPacket.setRuntimeEntityId(0L);
        inventoryTransactionPacket.setBlockPosition(vector3i);
        inventoryTransactionPacket.setBlockFace(n);
        inventoryTransactionPacket.setHotbarSlot(this.getHeldItemSlot());
        inventoryTransactionPacket.setItemInHand(this.getHeldItemData());
        inventoryTransactionPacket.setPlayerPosition(this.getVec3Position());
        inventoryTransactionPacket.setClickPosition(Vector3f.from(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble()));
        gameSession.sendPacket(inventoryTransactionPacket);
    }

    public final void destroy(Vector3i vector3i, int n) {
        Intrinsics.checkNotNullParameter((Object)vector3i, (String)"position");
        GameSession gameSession = this.session;
        InventoryTransactionPacket inventoryTransactionPacket = new InventoryTransactionPacket();
        inventoryTransactionPacket.setTransactionType(TransactionType.ITEM_USE);
        inventoryTransactionPacket.setActionType(2);
        inventoryTransactionPacket.setRuntimeEntityId(0L);
        inventoryTransactionPacket.setBlockPosition(vector3i);
        inventoryTransactionPacket.setBlockFace(n);
        inventoryTransactionPacket.setHotbarSlot(this.getHeldItemSlot());
        inventoryTransactionPacket.setItemInHand(this.getHeldItemData());
        inventoryTransactionPacket.setPlayerPosition(this.getVec3Position());
        inventoryTransactionPacket.setClickPosition(Vector3f.ZERO);
        gameSession.sendPacket(inventoryTransactionPacket);
    }

    public final double getDirection() {
        float f = this.getRotationYaw();
        float f2 = this.moveForward;
        float f3 = f;
        if (f2 < 0.0f) {
            f3 = f + 180.0f;
        }
        f = 1.0f;
        if (f2 < 0.0f) {
            f = -0.5f;
        } else if (f2 > 0.0f) {
            f = 0.5f;
        }
        float f4 = this.moveStrafing;
        f2 = f3;
        if (f4 > 0.0f) {
            f2 = f3 - f * 90.0f;
        }
        f3 = f2;
        if (f4 < 0.0f) {
            f3 = f2 + 90.0f * f;
        }
        return Math.toRadians(f3);
    }

    public final EnumSet<PlayerAuthInputData> getInputData() {
        return this.inputData;
    }

    public final ModalFormRequestPacket getLastModalForm() {
        return this.lastModalForm;
    }

    public final float getMoveForward() {
        return this.moveForward;
    }

    public final float getMoveStrafing() {
        return this.moveStrafing;
    }

    public final boolean getOnGround() {
        return this.onGround;
    }

    public final Set<PlayerAuthInputData> getPendingInputData() {
        return this.pendingInputData;
    }

    @Override
    public long getRuntimeId() {
        return this.runtimeId;
    }

    public final String getXuid() {
        return this.xuid;
    }

    public final void interact(Entity entity, Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"pos");
        GameSession gameSession = this.session;
        InventoryTransactionPacket inventoryTransactionPacket = new InventoryTransactionPacket();
        inventoryTransactionPacket.setTransactionType(TransactionType.ITEM_USE_ON_ENTITY);
        inventoryTransactionPacket.setActionType(0);
        inventoryTransactionPacket.setRuntimeEntityId(entity.getRuntimeId());
        inventoryTransactionPacket.setHotbarSlot(this.getHeldItemSlot());
        inventoryTransactionPacket.setItemInHand(this.getHeldItemData());
        inventoryTransactionPacket.setPlayerPosition(vector3f);
        inventoryTransactionPacket.setClickPosition(entity.getVec3Position());
        gameSession.sendPacket(inventoryTransactionPacket);
    }

    public final boolean isHorizontallyMove() {
        float f = this.moveForward;
        boolean bl = true;
        boolean bl2 = f == 0.0f;
        boolean bl3 = bl;
        if (bl2) {
            bl2 = this.moveStrafing == 0.0f;
            bl3 = !bl2 ? bl : false;
        }
        return bl3;
    }

    public final void jump(double d) {
        if (this.session.getMovementMode() == AuthoritativeMovementMode.CLIENT) {
            RakNetRelaySession rakNetRelaySession = this.session.getNetSession();
            PlayerActionPacket playerActionPacket = new PlayerActionPacket();
            playerActionPacket.setRuntimeEntityId(this.getRuntimeId());
            playerActionPacket.setAction(PlayerActionType.JUMP);
            rakNetRelaySession.inboundPacket(playerActionPacket);
        }
        this.setMotion(this.getMotionX(), d, this.getMotionZ());
    }

    public final void onClientPacketSP(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof PlayerAuthInputPacket) {
            Object object2 = ((PlayerAuthInputPacket)object).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.position");
            this.move((Vector3f)object2);
            object2 = ((PlayerAuthInputPacket)object).getRotation();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.rotation");
            this.rotate((Vector3f)object2);
            boolean bl = this.getMotionY() == 0.0;
            this.onGround = bl;
            this.inputData = (EnumSet)((PlayerAuthInputPacket)object).getInputData();
            if (((Collection)this.pendingInputData).isEmpty() ^ true) {
                this.inputData.addAll((Collection<PlayerAuthInputData>)this.pendingInputData);
                this.pendingInputData.clear();
            }
            this.moveStrafing = ((PlayerAuthInputPacket)object).getMotion().getX();
            this.moveForward = ((PlayerAuthInputPacket)object).getMotion().getY();
            this.session.onTick();
            object2 = this.session;
            ((GameSession)object2).setTickExists(((GameSession)object2).getTickExists() + 1L);
            if (this.session.getMovementMode() == AuthoritativeMovementMode.CLIENT) {
                if (!Intrinsics.areEqual((Object)this.getVec3Position(), (Object)this.getVec3PrevPosition()) || !Intrinsics.areEqual((Object)this.getVec3Rotation(), (Object)this.getVec3PrevRotation())) {
                    object2 = this.session;
                    MovePlayerPacket object3 = new MovePlayerPacket();
                    object3.setRuntimeEntityId(this.getRuntimeId());
                    object3.setPosition(((PlayerAuthInputPacket)object).getPosition());
                    object3.setRotation(((PlayerAuthInputPacket)object).getRotation());
                    object3.setMode(MovePlayerPacket.Mode.NORMAL);
                    bl = this.getMotionY() == 0.0;
                    object3.setOnGround(bl);
                    object3.setRidingRuntimeEntityId(0L);
                    object3.setEntityType(0);
                    object3.setTick(((PlayerAuthInputPacket)object).getTick());
                    ((GameSession)object2).sendPacket(object3);
                }
                object2 = ((PlayerAuthInputPacket)object).getPlayerActions();
                Intrinsics.checkNotNullExpressionValue(object2, (String)"packet.playerActions");
                if (((Collection)object2).isEmpty() ^ true) {
                    for (PlayerBlockActionData playerBlockActionData : ((PlayerAuthInputPacket)object).getPlayerActions()) {
                        Object object3;
                        Object object4;
                        if (playerBlockActionData.getAction() == PlayerActionType.BLOCK_PREDICT_DESTROY || playerBlockActionData.getAction() == PlayerActionType.BLOCK_CONTINUE_DESTROY) continue;
                        if (playerBlockActionData.getAction() == PlayerActionType.ABORT_BREAK) {
                            if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.PERFORM_BLOCK_ACTIONS)) {
                                object4 = this.session;
                                object3 = new PlayerActionPacket();
                                ((PlayerActionPacket)object3).setRuntimeEntityId(this.getRuntimeId());
                                ((PlayerActionPacket)object3).setAction(PlayerActionType.STOP_BREAK);
                                ((PlayerActionPacket)object3).setBlockPosition(playerBlockActionData.getBlockPosition());
                                ((PlayerActionPacket)object3).setResultPosition(Vector3i.ZERO);
                                ((PlayerActionPacket)object3).setFace(playerBlockActionData.getFace());
                                ((GameSession)object4).sendPacket((BedrockPacket)object3);
                            }
                            object4 = playerBlockActionData.getBlockPosition();
                            Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"playerAction.blockPosition");
                            this.destroy((Vector3i)object4, playerBlockActionData.getFace());
                            continue;
                        }
                        object3 = this.session;
                        object4 = new PlayerActionPacket();
                        ((PlayerActionPacket)object4).setRuntimeEntityId(this.getRuntimeId());
                        ((PlayerActionPacket)object4).setAction(playerBlockActionData.getAction());
                        ((PlayerActionPacket)object4).setBlockPosition(playerBlockActionData.getBlockPosition());
                        ((PlayerActionPacket)object4).setResultPosition(Vector3i.ZERO);
                        ((PlayerActionPacket)object4).setFace(playerBlockActionData.getFace());
                        ((GameSession)object3).sendPacket((BedrockPacket)object4);
                    }
                }
                if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.START_SPRINTING)) {
                    object = this.session;
                    object2 = new PlayerActionPacket();
                    ((PlayerActionPacket)object2).setRuntimeEntityId(this.getRuntimeId());
                    ((PlayerActionPacket)object2).setAction(PlayerActionType.START_SPRINT);
                    ((PlayerActionPacket)object2).setBlockPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object2).setResultPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object2).setFace(0);
                    ((GameSession)object).sendPacket((BedrockPacket)object2);
                } else if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.STOP_SPRINTING)) {
                    object = this.session;
                    object2 = new PlayerActionPacket();
                    ((PlayerActionPacket)object2).setRuntimeEntityId(this.getRuntimeId());
                    ((PlayerActionPacket)object2).setAction(PlayerActionType.STOP_SPRINT);
                    ((PlayerActionPacket)object2).setBlockPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object2).setResultPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object2).setFace(0);
                    ((GameSession)object).sendPacket((BedrockPacket)object2);
                } else if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.START_SNEAKING)) {
                    object2 = this.session;
                    object = new PlayerActionPacket();
                    ((PlayerActionPacket)object).setRuntimeEntityId(this.getRuntimeId());
                    ((PlayerActionPacket)object).setAction(PlayerActionType.START_SNEAK);
                    ((PlayerActionPacket)object).setBlockPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setResultPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setFace(0);
                    ((GameSession)object2).sendPacket((BedrockPacket)object);
                } else if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.STOP_SNEAKING)) {
                    object2 = this.session;
                    object = new PlayerActionPacket();
                    ((PlayerActionPacket)object).setRuntimeEntityId(this.getRuntimeId());
                    ((PlayerActionPacket)object).setAction(PlayerActionType.STOP_SNEAK);
                    ((PlayerActionPacket)object).setBlockPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setResultPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setFace(0);
                    ((GameSession)object2).sendPacket((BedrockPacket)object);
                } else if (((PlayerAuthInputPacket)object).getInputData().contains((Object)PlayerAuthInputData.START_JUMPING)) {
                    object2 = this.session;
                    object = new PlayerActionPacket();
                    ((PlayerActionPacket)object).setRuntimeEntityId(this.getRuntimeId());
                    ((PlayerActionPacket)object).setAction(PlayerActionType.JUMP);
                    ((PlayerActionPacket)object).setBlockPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setResultPosition(Vector3i.ZERO);
                    ((PlayerActionPacket)object).setFace(0);
                    ((GameSession)object2).sendPacket((BedrockPacket)object);
                }
            }
        } else if (object instanceof PlayerHotbarPacket && ((PlayerHotbarPacket)object).getContainerId() == 0) {
            this.setHeldItemSlot(((PlayerHotbarPacket)object).getSelectedHotbarSlot());
        } else if (object instanceof MobEquipmentPacket) {
            this.setHeldItemSlot(((MobEquipmentPacket)object).getHotbarSlot());
            object = ((MobEquipmentPacket)object).getItem();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.item");
            this.setHeldItemData((ItemData)object);
        } else if (object instanceof RespawnPacket) {
            this.setRuntimeId(((RespawnPacket)object).getRuntimeEntityId());
        }
    }

    public final void onServerPacketSP(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof ModalFormRequestPacket) {
            this.lastModalForm = (ModalFormRequestPacket)object;
        } else if (object instanceof SetEntityDataPacket && ((SetEntityDataPacket)object).getRuntimeEntityId() == this.getRuntimeId()) {
            object = ((SetEntityDataPacket)object).getMetadata();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.metadata");
            for (Map.Entry entry : ((Map)object).entrySet()) {
                object = (EntityData)((Object)entry.getKey());
                entry = entry.getValue();
                ((Map)this.getMetadata()).put(object, entry);
            }
        } else if (object instanceof UpdateAttributesPacket && ((UpdateAttributesPacket)object).getRuntimeEntityId() == this.getRuntimeId()) {
            object = ((UpdateAttributesPacket)object).getAttributes();
            Intrinsics.checkNotNullExpressionValue(object, (String)"packet.attributes");
            for (AttributeData attributeData : (Iterable)object) {
                object = this.getAttributes();
                String string = attributeData.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"it.name");
                Intrinsics.checkNotNullExpressionValue((Object)attributeData, (String)"it");
                object.put(string, attributeData);
            }
        } else if (object instanceof EntityEventPacket && ((EntityEventPacket)object).getRuntimeEntityId() == this.getRuntimeId() && ((EntityEventPacket)object).getType() == EntityEventType.HURT) {
            this.setHurtTime(10);
        }
    }

    public final void say(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"text");
        GameSession gameSession = this.session;
        TextPacket textPacket = new TextPacket();
        textPacket.setType(TextPacket.Type.CHAT);
        textPacket.setNeedsTranslation(false);
        textPacket.setXuid(this.xuid);
        textPacket.setSourceName(this.getUsername());
        textPacket.setPlatformChatId("");
        textPacket.setMessage(string);
        gameSession.sendPacket(textPacket);
    }

    public final void setInputData(EnumSet<PlayerAuthInputData> enumSet) {
        this.inputData = enumSet;
    }

    public final void setLastModalForm(ModalFormRequestPacket modalFormRequestPacket) {
        Intrinsics.checkNotNullParameter((Object)modalFormRequestPacket, (String)"<set-?>");
        this.lastModalForm = modalFormRequestPacket;
    }

    public final void setMotion(double d, double d2, double d3) {
        RakNetRelaySession rakNetRelaySession = this.session.getNetSession();
        SetEntityMotionPacket setEntityMotionPacket = new SetEntityMotionPacket();
        setEntityMotionPacket.setRuntimeEntityId(this.getRuntimeId());
        setEntityMotionPacket.setMotion(Vector3f.from(d, d2, d3));
        rakNetRelaySession.inboundPacket(setEntityMotionPacket);
    }

    public final void setMoveForward(float f) {
        this.moveForward = f;
    }

    public final void setMoveStrafing(float f) {
        this.moveStrafing = f;
    }

    public final void setOnGround(boolean bl) {
        this.onGround = bl;
    }

    public void setRuntimeId(long l) {
        this.runtimeId = l;
    }

    public final void setXuid(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.xuid = string;
    }

    public final void swing(boolean bl) {
        AnimatePacket animatePacket = new AnimatePacket();
        animatePacket.setRuntimeEntityId(this.getRuntimeId());
        animatePacket.setAction(AnimatePacket.Action.SWING_ARM);
        if (bl) {
            this.session.sendPacket(animatePacket);
        } else {
            this.session.getNetSession().inboundPacket(animatePacket);
        }
    }

    public final void teleportTo(double d, double d2, double d3, boolean bl) {
        this.move(d, d2, d3);
        RakNetRelaySession rakNetRelaySession = this.session.getNetSession();
        MovePlayerPacket movePlayerPacket = new MovePlayerPacket();
        movePlayerPacket.setRuntimeEntityId(this.getRuntimeId());
        movePlayerPacket.setPosition(Vector3f.from(d, d2, d3));
        if (bl) {
            movePlayerPacket.setRotation(Vector3f.ZERO);
            movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
        } else {
            movePlayerPacket.setRotation(this.getVec3Rotation());
            movePlayerPacket.setMode(MovePlayerPacket.Mode.TELEPORT);
            movePlayerPacket.setTeleportationCause(MovePlayerPacket.TeleportationCause.UNKNOWN);
        }
        rakNetRelaySession.inboundPacket(movePlayerPacket);
    }

    public final void teleportTo(Vector3f vector3f, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"pos");
        this.move(vector3f.getX(), vector3f.getY(), vector3f.getZ());
        RakNetRelaySession rakNetRelaySession = this.session.getNetSession();
        MovePlayerPacket movePlayerPacket = new MovePlayerPacket();
        movePlayerPacket.setRuntimeEntityId(this.getRuntimeId());
        movePlayerPacket.setPosition(vector3f);
        movePlayerPacket.setRotation(this.getVec3Rotation());
        if (bl) {
            movePlayerPacket.setMode(MovePlayerPacket.Mode.NORMAL);
        } else {
            movePlayerPacket.setMode(MovePlayerPacket.Mode.TELEPORT);
            movePlayerPacket.setTeleportationCause(MovePlayerPacket.TeleportationCause.UNKNOWN);
        }
        rakNetRelaySession.inboundPacket(movePlayerPacket);
    }
}

