/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 */
package dev.sora.relay.game;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode;
import com.nukkitx.protocol.bedrock.packet.DisconnectPacket;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.ModalFormResponsePacket;
import com.nukkitx.protocol.bedrock.packet.PlayerAuthInputPacket;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.RakNetRelaySessionListener;
import dev.sora.relay.cheat.module.ModuleManager;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.EventManager;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.GameEventCancelable;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.game.management.BlobCacheManager;
import dev.sora.relay.game.utils.mapping.EmptyRuntimeMapping;
import dev.sora.relay.game.utils.mapping.RuntimeMapping;
import dev.sora.relay.game.world.WorldClient;
import dev.sora.relay.utils.StringUtilsKt;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020%2\u0006\u0010D\u001a\u00020EH\u0016J\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020H2\u0006\u0010D\u001a\u00020EJ\u000e\u0010J\u001a\u00020H2\u0006\u0010D\u001a\u00020ER\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010'\"\u0004\b.\u0010+R\u0011\u0010/\u001a\u000200\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006K"}, d2={"Ldev/sora/relay/game/GameSession;", "Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "()V", "<set-?>", "Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "blockMapping", "getBlockMapping", "()Ldev/sora/relay/game/utils/mapping/RuntimeMapping;", "cacheManager", "Ldev/sora/relay/game/management/BlobCacheManager;", "getCacheManager", "()Ldev/sora/relay/game/management/BlobCacheManager;", "eventManager", "Ldev/sora/relay/game/event/EventManager;", "getEventManager", "()Ldev/sora/relay/game/event/EventManager;", "legacyBlockMapping", "getLegacyBlockMapping", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "getModuleManager", "()Ldev/sora/relay/cheat/module/ModuleManager;", "setModuleManager", "(Ldev/sora/relay/cheat/module/ModuleManager;)V", "movementMode", "Lcom/nukkitx/protocol/bedrock/data/AuthoritativeMovementMode;", "getMovementMode", "()Lcom/nukkitx/protocol/bedrock/data/AuthoritativeMovementMode;", "setMovementMode", "(Lcom/nukkitx/protocol/bedrock/data/AuthoritativeMovementMode;)V", "netSession", "Ldev/sora/relay/RakNetRelaySession;", "getNetSession", "()Ldev/sora/relay/RakNetRelaySession;", "setNetSession", "(Ldev/sora/relay/RakNetRelaySession;)V", "netSessionInitialized", "", "getNetSessionInitialized", "()Z", "serverAuthBreak", "getServerAuthBreak", "setServerAuthBreak", "(Z)V", "serverAuthInventory", "getServerAuthInventory", "setServerAuthInventory", "thePlayer", "Ldev/sora/relay/game/entity/EntityPlayerSP;", "getThePlayer", "()Ldev/sora/relay/game/entity/EntityPlayerSP;", "theWorld", "Ldev/sora/relay/game/world/WorldClient;", "getTheWorld", "()Ldev/sora/relay/game/world/WorldClient;", "tickExists", "", "getTickExists", "()J", "setTickExists", "(J)V", "titleId", "", "getTitleId", "()Ljava/lang/String;", "setTitleId", "(Ljava/lang/String;)V", "onPacketInbound", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "onTick", "", "sendPacket", "sendPacketToClient", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class GameSession
implements RakNetRelaySessionListener.PacketListener {
    private RuntimeMapping blockMapping;
    private final BlobCacheManager cacheManager;
    private final EventManager eventManager;
    private RuntimeMapping legacyBlockMapping;
    public ModuleManager moduleManager;
    private AuthoritativeMovementMode movementMode;
    public RakNetRelaySession netSession;
    private boolean serverAuthBreak;
    private boolean serverAuthInventory;
    private final EntityPlayerSP thePlayer = new EntityPlayerSP(this);
    private final WorldClient theWorld = new WorldClient(this);
    private long tickExists;
    private String titleId = "";

    public GameSession() {
        this.blockMapping = new EmptyRuntimeMapping(null, 0, 3, null);
        this.legacyBlockMapping = new EmptyRuntimeMapping(null, 0, 3, null);
        this.cacheManager = new BlobCacheManager();
        this.eventManager = new EventManager();
    }

    public final RuntimeMapping getBlockMapping() {
        return this.blockMapping;
    }

    public final BlobCacheManager getCacheManager() {
        return this.cacheManager;
    }

    public final EventManager getEventManager() {
        return this.eventManager;
    }

    public final RuntimeMapping getLegacyBlockMapping() {
        return this.legacyBlockMapping;
    }

    public final ModuleManager getModuleManager() {
        ModuleManager moduleManager = this.moduleManager;
        if (moduleManager != null) {
            return moduleManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"moduleManager");
        return null;
    }

    public final AuthoritativeMovementMode getMovementMode() {
        return this.movementMode;
    }

    public final RakNetRelaySession getNetSession() {
        RakNetRelaySession rakNetRelaySession = this.netSession;
        if (rakNetRelaySession != null) {
            return rakNetRelaySession;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"netSession");
        return null;
    }

    public final boolean getNetSessionInitialized() {
        boolean bl = this.netSession != null;
        return bl;
    }

    public final boolean getServerAuthBreak() {
        return this.serverAuthBreak;
    }

    public final boolean getServerAuthInventory() {
        return this.serverAuthInventory;
    }

    public final EntityPlayerSP getThePlayer() {
        return this.thePlayer;
    }

    public final WorldClient getTheWorld() {
        return this.theWorld;
    }

    public final long getTickExists() {
        return this.tickExists;
    }

    public final String getTitleId() {
        return this.titleId;
    }

    @Override
    public boolean onPacketInbound(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof StartGamePacket) {
            this.theWorld.getPlayerList().clear();
            this.theWorld.getEntityMap().clear();
            this.thePlayer.setUniqueId(((StartGamePacket)object).getUniqueEntityId());
            this.thePlayer.setRuntimeId(((StartGamePacket)object).getRuntimeEntityId());
            this.movementMode = ((StartGamePacket)object).getPlayerMovementSettings().getMovementMode();
            this.serverAuthBreak = ((StartGamePacket)object).getPlayerMovementSettings().isServerAuthoritativeBlockBreaking();
            this.serverAuthInventory = ((StartGamePacket)object).isInventoriesServerAuthoritative();
            if (this.movementMode == AuthoritativeMovementMode.CLIENT) {
                ((StartGamePacket)object).getPlayerMovementSettings().setMovementMode(AuthoritativeMovementMode.SERVER);
            }
        } else if (object instanceof DisconnectPacket) {
            this.theWorld.getPlayerList().clear();
            this.theWorld.getEntityMap().clear();
            this.theWorld.clearChunk();
            this.cacheManager.clear();
            this.thePlayer.reset();
            this.tickExists = 0L;
        } else {
            this.theWorld.onServerPacket((BedrockPacket)object);
            this.thePlayer.onServerPacketSP((BedrockPacket)object);
            this.cacheManager.onServerPacket((BedrockPacket)object);
        }
        object = new EventPacketInbound(this, (BedrockPacket)object);
        this.eventManager.emit((GameEvent)object);
        return !((GameEventCancelable)object).isCanceled();
    }

    @Override
    public boolean onPacketOutbound(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof LoginPacket) {
            Iterator<JsonElement> iterator = JsonParser.parseString(((LoginPacket)object).getChainData().toString()).getAsJsonObject().getAsJsonArray("chain").iterator();
            while (iterator.hasNext()) {
                Object object2;
                Object object3 = iterator.next().getAsString();
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"chain.asString");
                if (!((JsonObject)(object3 = JsonParser.parseString(new String(StringUtilsKt.base64Decode((String)StringsKt.split$default((CharSequence)((CharSequence)object3), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(1)), Charsets.UTF_8)).getAsJsonObject())).has((String)(object2 = "extraData"))) continue;
                object3 = ((JsonObject)object3).getAsJsonObject((String)object2);
                object2 = this.thePlayer;
                Object object4 = UUID.fromString(((JsonObject)object3).get("identity").getAsString());
                Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"fromString(xData.get(\"identity\").asString)");
                ((EntityPlayer)object2).setUuid((UUID)object4);
                object2 = this.thePlayer;
                object4 = ((JsonObject)object3).get("XUID").getAsString();
                Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"xData.get(\"XUID\").asString");
                ((EntityPlayerSP)object2).setXuid((String)object4);
                object4 = this.thePlayer;
                object2 = ((JsonObject)object3).get("displayName").getAsString();
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"xData.get(\"displayName\").asString");
                ((EntityPlayer)object4).setUsername((String)object2);
                object3 = ((JsonObject)object3).get("titleId").getAsString();
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"xData.get(\"titleId\").asString");
                this.titleId = object3;
            }
        } else {
            this.thePlayer.onClientPacketSP((BedrockPacket)object);
            this.theWorld.onClientPacket((BedrockPacket)object);
            this.cacheManager.onClientPacket((BedrockPacket)object);
        }
        if (this.movementMode == AuthoritativeMovementMode.CLIENT && object instanceof PlayerAuthInputPacket) {
            return false;
        }
        if (object instanceof ModalFormResponsePacket && ((ModalFormResponsePacket)object).getFormData() == null) {
            return false;
        }
        object = new EventPacketOutbound(this, (BedrockPacket)object);
        this.eventManager.emit((GameEvent)object);
        return !((GameEventCancelable)object).isCanceled();
    }

    public final void onTick() {
        this.eventManager.emit(new EventTick(this));
    }

    public final void sendPacket(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        EventPacketOutbound eventPacketOutbound = new EventPacketOutbound(this, bedrockPacket);
        this.eventManager.emit(eventPacketOutbound);
        if (eventPacketOutbound.isCanceled()) {
            return;
        }
        this.getNetSession().outboundPacket(bedrockPacket);
    }

    public final void sendPacketToClient(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        EventPacketInbound eventPacketInbound = new EventPacketInbound(this, bedrockPacket);
        this.eventManager.emit(eventPacketInbound);
        if (eventPacketInbound.isCanceled()) {
            return;
        }
        this.getNetSession().inboundPacket(bedrockPacket);
    }

    public final void setModuleManager(ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter((Object)moduleManager, (String)"<set-?>");
        this.moduleManager = moduleManager;
    }

    public final void setMovementMode(AuthoritativeMovementMode authoritativeMovementMode) {
        this.movementMode = authoritativeMovementMode;
    }

    public final void setNetSession(RakNetRelaySession rakNetRelaySession) {
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"<set-?>");
        this.netSession = rakNetRelaySession;
    }

    public final void setServerAuthBreak(boolean bl) {
        this.serverAuthBreak = bl;
    }

    public final void setServerAuthInventory(boolean bl) {
        this.serverAuthInventory = bl;
    }

    public final void setTickExists(long l) {
        this.tickExists = l;
    }

    public final void setTitleId(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.titleId = string;
    }
}

