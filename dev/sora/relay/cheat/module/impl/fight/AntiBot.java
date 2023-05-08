/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import com.nukkitx.protocol.bedrock.data.entity.EntityFlag;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityPlayerSP;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/AntiBot;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "isBot", "", "Ldev/sora/relay/game/entity/EntityPlayer;", "session", "Ldev/sora/relay/game/GameSession;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class AntiBot
extends CheatModule {
    public static final AntiBot INSTANCE = new AntiBot();

    private AntiBot() {
        super("AntiBot", false, false, 6, null);
    }

    public final boolean isBot(EntityPlayer object, GameSession object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"session");
        if (!(object instanceof EntityPlayerSP) && this.getState()) {
            if (StringsKt.isBlank((CharSequence)((EntityPlayer)object).getUsername())) {
                return true;
            }
            if (((Entity)object).getMetadata().getFlags().getFlag(EntityFlag.CAN_SHOW_NAME) != ((GameSession)object2).getThePlayer().getMetadata().getFlags().getFlag(EntityFlag.CAN_SHOW_NAME)) {
                return true;
            }
            String string = ((GameSession)object2).getThePlayer().getMetadata().getString(EntityData.NAMETAG);
            CharSequence charSequence = "session.thePlayer.metada\u2026tring(EntityData.NAMETAG)";
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)charSequence);
            boolean bl = StringsKt.isBlank((CharSequence)string);
            String string2 = ((Entity)object).getMetadata().getString(EntityData.NAMETAG);
            string = "this.metadata.getString(EntityData.NAMETAG)";
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)string);
            if (bl != StringsKt.isBlank((CharSequence)string2)) {
                return true;
            }
            object2 = ((GameSession)object2).getThePlayer().getMetadata().getString(EntityData.NAMETAG);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)charSequence);
            charSequence = (CharSequence)object2;
            object2 = "\n";
            bl = StringsKt.contains$default((CharSequence)charSequence, (CharSequence)((CharSequence)object2), (boolean)false, (int)2, null);
            object = ((Entity)object).getMetadata().getString(EntityData.NAMETAG);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)string);
            return bl != StringsKt.contains$default((CharSequence)((CharSequence)object), (CharSequence)((CharSequence)object2), (boolean)false, (int)2, null);
        }
        return false;
    }
}

