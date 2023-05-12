/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.protocol.bedrock.data.skin.SerializedSkin;
import com.nukkitx.protocol.bedrock.packet.PlayerListPacket;
import com.nukkitx.protocol.bedrock.packet.PlayerSkinPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.skin.GenerateSkin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/NoSkin;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "onPacketInbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NoSkin
extends CheatModule {
    public NoSkin() {
        super("NoSkin", false, false, 6, null);
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = ((EventPacketInbound)object).getPacket();
        if (object2 instanceof PlayerListPacket) {
            object = ((PlayerListPacket)object2).getEntries();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.entries");
            for (PlayerListPacket.Entry entry : (Iterable)object) {
                if (entry.getSkin() == null) continue;
                object = new GenerateSkin();
                SerializedSkin serializedSkin = entry.getSkin();
                Intrinsics.checkNotNullExpressionValue((Object)serializedSkin, (String)"it.skin");
                entry.setSkin(((GenerateSkin)object).generateSkin(serializedSkin));
            }
        } else if (object2 instanceof PlayerSkinPacket && ((PlayerSkinPacket)object2).getSkin() != null) {
            PlayerSkinPacket playerSkinPacket = (PlayerSkinPacket)object2;
            object = new GenerateSkin();
            object2 = ((PlayerSkinPacket)object2).getSkin();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"packet.skin");
            playerSkinPacket.setSkin(((GenerateSkin)object).generateSkin((SerializedSkin)object2));
        }
    }
}

