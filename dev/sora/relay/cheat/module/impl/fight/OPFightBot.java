/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package dev.sora.relay.cheat.module.impl.fight;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.fight.AntiBot;
import dev.sora.relay.cheat.module.impl.fight.Friend;
import dev.sora.relay.cheat.module.impl.fight.Teams;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.Entity;
import dev.sora.relay.game.entity.EntityPlayer;
import dev.sora.relay.game.entity.EntityPlayerSP;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ldev/sora/relay/cheat/module/impl/fight/OPFightBot;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "horizontalSpeedValue", "Ldev/sora/relay/cheat/value/FloatValue;", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "rangeValue", "strafeSpeedValue", "Ldev/sora/relay/cheat/value/IntValue;", "verticalSpeedValue", "onTick", "", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class OPFightBot
extends CheatModule {
    private final FloatValue horizontalSpeedValue;
    private final ListValue modeValue;
    private final FloatValue rangeValue;
    private final IntValue strafeSpeedValue;
    private final FloatValue verticalSpeedValue;

    public OPFightBot() {
        super("OPFightBot", false, false, 6, null);
        String string = "Random";
        String string2 = "Strafe";
        String string3 = "Back";
        this.modeValue = new ListValue("Mode", new String[]{string, string2, string3}, string);
        this.rangeValue = new FloatValue("Range", 1.5f, 1.5f, 4.0f);
        this.horizontalSpeedValue = new FloatValue("HorizontalSpeed", 5.0f, 1.0f, 7.0f);
        this.verticalSpeedValue = new FloatValue("VerticalSpeed", 4.0f, 1.0f, 7.0f);
        this.strafeSpeedValue = new IntValue("StrafeSpeed", 20, 10, 90);
    }

    /*
     * Unable to fully structure code
     */
    @Listen
    public final void onTick(EventTick var1_1) {
        block10: {
            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"event");
            var2_2 = var1_1.getSession();
            var3_3 = var2_2.getTheWorld().getEntityMap().values();
            var1_1 = new ArrayList<E>();
            var4_4 = var3_3.iterator();
            while (var4_4.hasNext()) {
                var3_3 = var4_4.next();
                var5_5 = (Entity)var3_3;
                var6_6 = var5_5 instanceof EntityPlayer != false && AntiBot.INSTANCE.isBot((EntityPlayer)var5_5, var2_2) == false && Teams.INSTANCE.isTeammate((EntityPlayer)var5_5, var2_2) == false && Friend.INSTANCE.isFriend((EntityPlayer)var5_5) == false;
                if (!var6_6) continue;
                var1_1.add(var3_3);
            }
            var5_5 = ((Iterable)(var1_1 = (List)var1_1)).iterator();
            if (var5_5.hasNext()) break block10;
            var1_1 = null;
            ** GOTO lbl30
        }
        var1_1 = var5_5.next();
        if (!var5_5.hasNext()) ** GOTO lbl30
        var7_7 = ((Entity)var1_1).distanceSq(var2_2.getThePlayer());
        while (true) {
            block11: {
                block14: {
                    block12: {
                        block13: {
                            var3_3 = var5_5.next();
                            var9_8 = ((Entity)var3_3).distanceSq(var2_2.getThePlayer());
                            var11_9 = var7_7;
                            if (Double.compare(var7_7, var9_8) > 0) {
                                var1_1 = var3_3;
                                var11_9 = var9_8;
                            }
                            if (var5_5.hasNext()) break block11;
lbl30:
                            // 3 sources

                            var1_1 = (Entity)var1_1;
                            if (var1_1 == null) {
                                return;
                            }
                            if (!(var1_1.distance(var2_2.getThePlayer()) < 5.0)) break block12;
                            var3_3 = (String)this.modeValue.get();
                            switch (var3_3.hashCode()) lbl-1000:
                            // 4 sources

                            {
                                default: {
                                    break block13;
                                }
                                case 2062599: {
                                    if (!var3_3.equals("Back")) ** GOTO lbl-1000
                                    var7_7 = (double)var1_1.getRotationYaw() + 180.0;
                                    break;
                                }
                                case -1808126673: {
                                    if (!var3_3.equals("Strafe")) ** GOTO lbl-1000
                                    var7_7 = var2_2.getTickExists() * ((Number)this.strafeSpeedValue.get()).longValue() % (long)360;
                                    break;
                                }
                                case -1854418717: {
                                    if (!var3_3.equals("Random")) ** GOTO lbl-1000
                                    var7_7 = Math.random() * (double)360;
                                }
                            }
                            var7_7 = Math.toRadians(var7_7);
                            EntityPlayerSP.teleportTo$default(var2_2.getThePlayer(), var1_1.getPosX() - Math.sin(var7_7) * ((Number)this.rangeValue.get()).doubleValue(), var1_1.getPosY() + 0.5, var1_1.getPosZ() + Math.cos(var7_7) * ((Number)this.rangeValue.get()).doubleValue(), false, 8, null);
                            break block14;
                        }
                        throw new IllegalStateException("no such mode available".toString());
                    }
                    var7_7 = Math.atan2(var1_1.getPosZ() - var2_2.getThePlayer().getPosZ(), var1_1.getPosX() - var2_2.getThePlayer().getPosX()) - Math.toRadians(90.0);
                    EntityPlayerSP.teleportTo$default(var2_2.getThePlayer(), var2_2.getThePlayer().getPosX() - Math.sin(var7_7) * ((Number)this.horizontalSpeedValue.get()).doubleValue(), RangesKt.coerceIn((double)var1_1.getPosY(), (double)(var2_2.getThePlayer().getPosY() - ((Number)this.verticalSpeedValue.get()).doubleValue()), (double)(var2_2.getThePlayer().getPosY() + ((Number)this.verticalSpeedValue.get()).doubleValue())), var2_2.getThePlayer().getPosZ() + Math.cos(var7_7) * ((Number)this.horizontalSpeedValue.get()).doubleValue(), false, 8, null);
                }
                return;
            }
            var7_7 = var11_9;
        }
    }
}

