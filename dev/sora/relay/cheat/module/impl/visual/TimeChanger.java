/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.visual;

import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.data.LevelEventType;
import com.nukkitx.protocol.bedrock.packet.LevelEventPacket;
import com.nukkitx.protocol.bedrock.packet.SetTimePacket;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventPacketInbound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/cheat/module/impl/visual/TimeChanger;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "serverSideTime", "", "timeValue", "Ldev/sora/relay/cheat/value/IntValue;", "weatherValue", "Ldev/sora/relay/cheat/value/ListValue;", "changeAmbience", "", "onDisable", "onEnable", "onPacketInbound", "event", "Ldev/sora/relay/game/event/impl/EventPacketInbound;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class TimeChanger
extends CheatModule {
    private int serverSideTime;
    private final IntValue timeValue;
    private final ListValue weatherValue;

    public TimeChanger() {
        super("TimeChanger", false, false, 6, null);
        String string2 = "Clear";
        String string3 = "Rain";
        String string4 = "Thunderstorm";
        this.weatherValue = new ListValue("Weather", new String[]{string2, string3, string4}, string2);
        this.timeValue = new IntValue("Time", 6000, 0, 23992);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void changeAmbience() {
        Object object;
        Object object2 = (String)this.weatherValue.get();
        switch (((String)object2).hashCode()) {
            case 65193517: {
                if (((String)object2).equals("Clear")) {
                    object = this.getSession().getNetSession();
                    object2 = new LevelEventPacket();
                    ((LevelEventPacket)object2).setType(LevelEventType.STOP_RAINING);
                    ((LevelEventPacket)object2).setPosition(Vector3f.ZERO);
                    ((LevelEventPacket)object2).setData(65535);
                    ((RakNetRelaySession)object).inboundPacket((BedrockPacket)object2);
                    object = this.getSession().getNetSession();
                    object2 = new LevelEventPacket();
                    ((LevelEventPacket)object2).setType(LevelEventType.STOP_THUNDERSTORM);
                    ((LevelEventPacket)object2).setPosition(Vector3f.ZERO);
                    ((LevelEventPacket)object2).setData(65535);
                    ((RakNetRelaySession)object).inboundPacket((BedrockPacket)object2);
                    break;
                }
            }
            default: {
                break;
            }
            case 2539444: {
                if (!((String)object2).equals("Rain")) break;
                object2 = this.getSession().getNetSession();
                object = new LevelEventPacket();
                ((LevelEventPacket)object).setType(LevelEventType.START_RAINING);
                ((LevelEventPacket)object).setPosition(Vector3f.ZERO);
                ((LevelEventPacket)object).setData(65535);
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
                object = this.getSession().getNetSession();
                object2 = new LevelEventPacket();
                ((LevelEventPacket)object2).setType(LevelEventType.STOP_THUNDERSTORM);
                ((LevelEventPacket)object2).setPosition(Vector3f.ZERO);
                ((LevelEventPacket)object2).setData(65535);
                ((RakNetRelaySession)object).inboundPacket((BedrockPacket)object2);
                break;
            }
            case -1710645595: {
                if (!((String)object2).equals("Thunderstorm")) break;
                object2 = this.getSession().getNetSession();
                object = new LevelEventPacket();
                ((LevelEventPacket)object).setType(LevelEventType.START_RAINING);
                ((LevelEventPacket)object).setPosition(Vector3f.ZERO);
                ((LevelEventPacket)object).setData(65535);
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
                object2 = this.getSession().getNetSession();
                object = new LevelEventPacket();
                ((LevelEventPacket)object).setType(LevelEventType.START_THUNDERSTORM);
                ((LevelEventPacket)object).setPosition(Vector3f.ZERO);
                ((LevelEventPacket)object).setData(65535);
                ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
            }
        }
        object2 = this.getSession().getNetSession();
        object = new SetTimePacket();
        ((SetTimePacket)object).setTime(((Number)this.timeValue.get()).intValue());
        ((RakNetRelaySession)object2).inboundPacket((BedrockPacket)object);
    }

    @Override
    public void onDisable() {
        RakNetRelaySession rakNetRelaySession = this.getSession().getNetSession();
        SetTimePacket setTimePacket = new SetTimePacket();
        setTimePacket.setTime(this.serverSideTime);
        rakNetRelaySession.inboundPacket(setTimePacket);
    }

    @Override
    public void onEnable() {
        this.changeAmbience();
    }

    @Listen
    public final void onPacketInbound(EventPacketInbound eventPacketInbound) {
        Intrinsics.checkNotNullParameter((Object)eventPacketInbound, (String)"event");
        BedrockPacket bedrockPacket = eventPacketInbound.getPacket();
        if (bedrockPacket instanceof SetTimePacket) {
            this.serverSideTime = ((SetTimePacket)bedrockPacket).getTime();
            ((SetTimePacket)bedrockPacket).setTime(((Number)this.timeValue.get()).intValue());
        } else if (bedrockPacket instanceof LevelEventPacket) {
            if (((LevelEventPacket)bedrockPacket).getType() == LevelEventType.START_RAINING || ((LevelEventPacket)bedrockPacket).getType() == LevelEventType.STOP_RAINING || ((LevelEventPacket)bedrockPacket).getType() == LevelEventType.START_THUNDERSTORM || ((LevelEventPacket)bedrockPacket).getType() == LevelEventType.STOP_THUNDERSTORM) {
                eventPacketInbound.cancel();
            }
        } else if (bedrockPacket instanceof StartGamePacket) {
            this.changeAmbience();
        }
    }
}

