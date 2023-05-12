/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import dev.sora.relay.cheat.BasicThing;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.event.GameEvent;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.utils.TimerUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/HUD;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "bps", "", "bpsText", "", "getBpsText", "()Ljava/lang/String;", "setBpsText", "(Ljava/lang/String;)V", "displayTimer", "Ldev/sora/relay/utils/TimerUtil;", "onEnable", "", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "onTick", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HUD
extends CheatModule {
    private double bps;
    private String bpsText = "";
    private final TimerUtil displayTimer = new TimerUtil();

    public HUD() {
        super("HUD", true, false, 4, null);
    }

    public final String getBpsText() {
        return this.bpsText;
    }

    @Override
    public void onEnable() {
        this.bps = 0.0;
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        if (this.displayTimer.delay(500.0, true)) {
            object = new StringBuilder().append("\u00a7bProtoHax \u00a7f| \u00a7eSpeed: \u00a7f");
            Object object2 = StringCompanionObject.INSTANCE;
            object2 = Arrays.copyOf(new Object[]{this.bps}, 1);
            object2 = String.format("%.2f", object2);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"format(format, *args)");
            object = ((StringBuilder)object).append((String)object2);
            this.bpsText = ((StringBuilder)object).append(" bps | \u00a7eOnGround: \u00a7f").append(this.getSession().getThePlayer().getOnGround()).toString();
            BasicThing.Companion.tipChat(this.getSession(), this.bpsText);
        }
    }

    @Listen
    public final void onTick(EventTick object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"event");
        object = ((GameEvent)object).getSession().getThePlayer();
        this.bps = Math.sqrt(((Entity)object).getMotionX() * ((Entity)object).getMotionX() + ((Entity)object).getMotionZ() * ((Entity)object).getMotionZ()) * (double)20;
    }

    public final void setBpsText(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<set-?>");
        this.bpsText = string2;
    }
}

