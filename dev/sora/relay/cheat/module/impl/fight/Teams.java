/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.fight;

import com.nukkitx.protocol.bedrock.data.entity.EntityData;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.GameSession;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityPlayerSP;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/Teams;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "isTeammate", "", "Ldev/sora/relay/game/entity/EntityPlayer;", "session", "Ldev/sora/relay/game/GameSession;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class Teams
extends CheatModule {
    public static final Teams INSTANCE = new Teams();

    private Teams() {
        super("Teams", false, false, 6, null);
    }

    public final boolean isTeammate(EntityPlayer object, GameSession object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"session");
        if (!(object instanceof EntityPlayerSP) && this.getState()) {
            object2 = ((GameSession)object2).getThePlayer().getMetadata().getString(EntityData.NAMETAG);
            object = ((Entity)object).getMetadata().getString(EntityData.NAMETAG);
            if (((String)object2).length() > 2 && ((String)object).length() > 2) {
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"thePlayerNameTag");
                CharSequence charSequence = (CharSequence)object2;
                String string2 = "\u00a7";
                if (StringsKt.contains$default((CharSequence)charSequence, (CharSequence)string2, (boolean)false, (int)2, null)) {
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"targetNameTag");
                    if (StringsKt.contains$default((CharSequence)((CharSequence)object), (CharSequence)string2, (boolean)false, (int)2, null)) {
                        return Intrinsics.areEqual((Object)((String)object2).subSequence(0, 2), (Object)((String)object).subSequence(0, 2));
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

