/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.entity.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/cheat/module/impl/action/RemoteShop;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "onEnable", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RemoteShop
extends CheatModule {
    private final ListValue modeValue;

    public RemoteShop() {
        super("RemoteShop", false, false, 6, null);
        String string2 = "HYT";
        String string3 = "EaseCation";
        String string4 = "Custom";
        this.modeValue = new ListValue("Mode", new String[]{string2, string3, string4}, string4);
    }

    @Override
    public void onEnable() {
        Iterator iterator = (String)this.modeValue.get();
        int n = ((String)((Object)iterator)).hashCode();
        Iterator iterator2 = null;
        Iterator iterator3 = null;
        switch (n) {
            default: {
                break;
            }
            case 2029746065: {
                if (!((String)((Object)iterator)).equals("Custom")) break;
                this.getSession().getNetSession().inboundPacket(this.getSession().getThePlayer().getLastModalForm());
                break;
            }
            case 110625312: {
                Object object;
                if (!((String)((Object)iterator)).equals("EaseCation")) break;
                iterator = this.getSession().getTheWorld().getEntityMap().values();
                iterator2 = new ArrayList();
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    if (!Intrinsics.areEqual((Object)((Entity)object).getIdentifier(), (Object)"minecraft:villager_v2")) continue;
                    iterator2.add(object);
                }
                if (!((iterator2 = (List)((Object)iterator2)).isEmpty() ^ true)) break;
                object = ((Iterable)((Object)iterator2)).iterator();
                if (object.hasNext()) {
                    iterator3 = object.next();
                    if (object.hasNext()) {
                        double d = ((Entity)((Object)iterator3)).distanceSq(this.getSession().getThePlayer());
                        iterator2 = iterator3;
                        do {
                            iterator = object.next();
                            double d2 = ((Entity)((Object)iterator)).distanceSq(this.getSession().getThePlayer());
                            iterator3 = iterator2;
                            double d3 = d;
                            if (Double.compare(d, d2) > 0) {
                                iterator3 = iterator;
                                d3 = d2;
                            }
                            iterator2 = iterator3;
                            d = d3;
                        } while (object.hasNext());
                    }
                }
                iterator3 = (Entity)((Object)iterator3);
                if (iterator3 == null) {
                    return;
                }
                this.getSession().getThePlayer().interact((Entity)((Object)iterator3), ((Entity)((Object)iterator3)).getVec3Position());
                break;
            }
            case 72035: {
                Object object;
                if (!((String)((Object)iterator)).equals("HYT")) break;
                iterator = this.getSession().getTheWorld().getEntityMap().values();
                iterator3 = new ArrayList();
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    if (!Intrinsics.areEqual((Object)((Entity)object).getIdentifier(), (Object)"minecraft:villager")) continue;
                    iterator3.add(object);
                }
                if (!((iterator3 = (List)((Object)iterator3)).isEmpty() ^ true)) break;
                object = ((Iterable)((Object)iterator3)).iterator();
                if (!object.hasNext()) {
                    iterator3 = iterator2;
                } else {
                    iterator3 = object.next();
                    if (object.hasNext()) {
                        double d = ((Entity)((Object)iterator3)).distanceSq(this.getSession().getThePlayer());
                        iterator2 = iterator3;
                        do {
                            iterator = object.next();
                            double d4 = ((Entity)((Object)iterator)).distanceSq(this.getSession().getThePlayer());
                            iterator3 = iterator2;
                            double d5 = d;
                            if (Double.compare(d, d4) > 0) {
                                iterator3 = iterator;
                                d5 = d4;
                            }
                            iterator2 = iterator3;
                            d = d5;
                        } while (object.hasNext());
                    }
                }
                iterator3 = (Entity)((Object)iterator3);
                if (iterator3 == null) {
                    return;
                }
                this.getSession().getThePlayer().swing(true);
                this.getSession().getThePlayer().attack((Entity)((Object)iterator3), ((Entity)((Object)iterator3)).getVec3Position());
            }
        }
        this.toggle();
    }
}

