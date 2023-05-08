/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.move;

import com.nukkitx.math.vector.Vector3f;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.fight.AntiBot;
import dev.sora.relay.cheat.module.impl.fight.Friend;
import dev.sora.relay.cheat.module.impl.fight.Teams;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.event.impl.EventPacketOutbound;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/sora/relay/cheat/module/impl/move/LockBack;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "targetPos", "Lcom/nukkitx/math/vector/Vector3f;", "targetRot", "onPacketOutbound", "", "event", "Ldev/sora/relay/game/event/impl/EventPacketOutbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class LockBack
extends CheatModule {
    private Vector3f targetPos;
    private Vector3f targetRot;

    public LockBack() {
        super("TPAura", false, false, 6, null);
        Vector3f vector3f = Vector3f.from(0.0, 0.0, 0.0);
        String string = "from(0.0, 0.0, 0.0)";
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)string);
        this.targetPos = vector3f;
        vector3f = Vector3f.from(0.0, 0.0, 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)string);
        this.targetRot = vector3f;
    }

    public final void onPacketOutbound(EventPacketOutbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        Object object2 = this.getSession().getTheWorld().getEntityMap().values();
        object = new ArrayList();
        Iterator iterator = object2.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            Entity entity = (Entity)object2;
            boolean bl = entity instanceof EntityPlayer && entity.distanceSq(this.getSession().getThePlayer()) < 6.0 && !AntiBot.INSTANCE.isBot((EntityPlayer)entity, this.getSession()) && !Teams.INSTANCE.isTeammate((EntityPlayer)entity, this.getSession()) && !Friend.INSTANCE.isFriend((EntityPlayer)entity);
            if (!bl) continue;
            object.add(object2);
        }
        object = (List)object;
        object = (Entity)CollectionsKt.first((List)object);
        this.targetPos = ((Entity)object).getVec3Position();
        this.targetRot = object = ((Entity)object).getVec3Rotation();
        float f = ((Vector3f)object).getY() - (float)90;
        double d = this.targetPos.getX();
        double d2 = 2;
        double d3 = f;
        double d4 = 180;
        d3 = Math.cos(d3 * 3.1415926 / d4);
        double d5 = this.targetPos.getZ();
        d4 = Math.sin((double)f * 3.1415926 / d4);
        object = Vector3f.from(d + d3 * d2, (double)this.targetPos.getY(), d5 + d2 * d4);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(nePos_x, targetPos.y.toDouble(), nePos_z)");
        object = Vector3f.from(((double)((Vector3f)object).getX() - this.getSession().getThePlayer().getPosX()) * 0.496, ((double)((Vector3f)object).getY() - this.getSession().getThePlayer().getPosY() + 1.0) * 0.496, 0.496 * ((double)((Vector3f)object).getZ() - this.getSession().getThePlayer().getPosZ()));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(Pc_x, Pc_y, Pc_z)");
        object2 = Vector3f.from(1.0, 1.0, 1.0);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"from(1.0, 1.0, 1.0)");
        if ((double)((Vector3f)object).getX() > 3.0) {
            object = Vector3f.from(3.0, (double)((Vector3f)object2).getY(), (double)((Vector3f)object2).getZ());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(3.0, nPos.y.toDouble(), nPos.z.toDouble())");
        } else if ((double)((Vector3f)object).getY() > 3.0) {
            object = Vector3f.from((double)((Vector3f)object2).getX(), 3.0, (double)((Vector3f)object2).getZ());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(nPos.x.toDouble(), 3.0, nPos.z.toDouble())");
        } else if ((double)((Vector3f)object).getZ() > 3.0) {
            object = Vector3f.from((double)((Vector3f)object2).getX(), (double)((Vector3f)object2).getY(), 3.0);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(nPos.x.toDouble(), nPos.y.toDouble(), 3.0)");
        } else if ((double)((Vector3f)object).getX() < -3.0) {
            object = Vector3f.from(-3.0, (double)((Vector3f)object2).getY(), (double)((Vector3f)object2).getZ());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(-3.0, nPos.y.toDouble(), nPos.z.toDouble())");
        } else if ((double)((Vector3f)object).getY() < -3.0) {
            object = Vector3f.from((double)((Vector3f)object2).getX(), -3.0, (double)((Vector3f)object2).getZ());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(nPos.x.toDouble(), -3.0, nPos.z.toDouble())");
        } else if ((double)((Vector3f)object).getZ() < -3.0) {
            object = Vector3f.from((double)((Vector3f)object2).getX(), (double)((Vector3f)object2).getY(), -3.0);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"from(nPos.x.toDouble(), nPos.y.toDouble(), -3.0)");
        }
        this.getSession().getThePlayer().setMotion(((Vector3f)object).getX(), ((Vector3f)object).getY(), ((Vector3f)object).getZ());
    }
}

