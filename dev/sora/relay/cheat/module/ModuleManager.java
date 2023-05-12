/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module;

import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.impl.action.AutoFish;
import dev.sora.relay.cheat.module.impl.action.AutoGG;
import dev.sora.relay.cheat.module.impl.action.AutoL;
import dev.sora.relay.cheat.module.impl.action.BGM;
import dev.sora.relay.cheat.module.impl.action.Breaker;
import dev.sora.relay.cheat.module.impl.action.Derp;
import dev.sora.relay.cheat.module.impl.action.InstaBreak;
import dev.sora.relay.cheat.module.impl.action.RemoteShop;
import dev.sora.relay.cheat.module.impl.action.Spammer;
import dev.sora.relay.cheat.module.impl.fight.AntiBot;
import dev.sora.relay.cheat.module.impl.fight.ComboOneHitExploit;
import dev.sora.relay.cheat.module.impl.fight.Criticals;
import dev.sora.relay.cheat.module.impl.fight.Friend;
import dev.sora.relay.cheat.module.impl.fight.InfiniteAura;
import dev.sora.relay.cheat.module.impl.fight.KillAura;
import dev.sora.relay.cheat.module.impl.fight.OPFightBot;
import dev.sora.relay.cheat.module.impl.fight.Teams;
import dev.sora.relay.cheat.module.impl.fight.Velocity;
import dev.sora.relay.cheat.module.impl.move.AirJump;
import dev.sora.relay.cheat.module.impl.move.AntiVoid;
import dev.sora.relay.cheat.module.impl.move.Fly;
import dev.sora.relay.cheat.module.impl.move.FreeCam;
import dev.sora.relay.cheat.module.impl.move.HighJump;
import dev.sora.relay.cheat.module.impl.move.NoFall;
import dev.sora.relay.cheat.module.impl.move.NoLagBack;
import dev.sora.relay.cheat.module.impl.move.Scaffold;
import dev.sora.relay.cheat.module.impl.move.Sneak;
import dev.sora.relay.cheat.module.impl.move.Speed;
import dev.sora.relay.cheat.module.impl.move.Teleport;
import dev.sora.relay.cheat.module.impl.other.AntiExploit;
import dev.sora.relay.cheat.module.impl.other.AntiKick;
import dev.sora.relay.cheat.module.impl.other.AntiSpammer;
import dev.sora.relay.cheat.module.impl.other.Blink;
import dev.sora.relay.cheat.module.impl.other.Crasher;
import dev.sora.relay.cheat.module.impl.other.DeviceSpoof;
import dev.sora.relay.cheat.module.impl.other.Disabler;
import dev.sora.relay.cheat.module.impl.other.GodMode;
import dev.sora.relay.cheat.module.impl.other.LoginIDSpoof;
import dev.sora.relay.cheat.module.impl.other.NoSoundEventPacket;
import dev.sora.relay.cheat.module.impl.other.PacketLoss;
import dev.sora.relay.cheat.module.impl.other.ResourcePackSpoof;
import dev.sora.relay.cheat.module.impl.visual.AntiBlind;
import dev.sora.relay.cheat.module.impl.visual.HUD;
import dev.sora.relay.cheat.module.impl.visual.HitEffect;
import dev.sora.relay.cheat.module.impl.visual.NameProtect;
import dev.sora.relay.cheat.module.impl.visual.NoChat;
import dev.sora.relay.cheat.module.impl.visual.NoFireCam;
import dev.sora.relay.cheat.module.impl.visual.NoHurtCam;
import dev.sora.relay.cheat.module.impl.visual.NoSkin;
import dev.sora.relay.cheat.module.impl.visual.ScoreBoard;
import dev.sora.relay.cheat.module.impl.visual.TimeChanger;
import dev.sora.relay.cheat.module.impl.visual.TrueSight;
import dev.sora.relay.game.GameSession;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Ldev/sora/relay/cheat/module/ModuleManager;", "", "session", "Ldev/sora/relay/game/GameSession;", "(Ldev/sora/relay/game/GameSession;)V", "modules", "", "Ldev/sora/relay/cheat/module/CheatModule;", "getModules", "()Ljava/util/List;", "getModuleByName", "name", "", "init", "", "registerModule", "module", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ModuleManager {
    private final List<CheatModule> modules;
    private final GameSession session;

    public ModuleManager(GameSession gameSession) {
        Intrinsics.checkNotNullParameter((Object)gameSession, (String)"session");
        this.session = gameSession;
        this.modules = new ArrayList();
    }

    private final void registerModule(CheatModule cheatModule) {
        cheatModule.setSession(this.session);
        this.modules.add(cheatModule);
        this.session.getEventManager().registerListener(cheatModule);
    }

    public final CheatModule getModuleByName(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        for (CheatModule cheatModule : this.modules) {
            if (!StringsKt.equals((String)cheatModule.getName(), (String)string2, (boolean)true)) continue;
            return cheatModule;
        }
        return null;
    }

    public final List<CheatModule> getModules() {
        return this.modules;
    }

    public final void init() {
        this.registerModule(new Fly());
        this.registerModule(new Velocity());
        this.registerModule(new KillAura());
        this.registerModule(new Spammer());
        this.registerModule(new BGM());
        this.registerModule(new Disabler());
        this.registerModule(new OPFightBot());
        this.registerModule(new NoSkin());
        this.registerModule(new LoginIDSpoof());
        this.registerModule(ResourcePackSpoof.INSTANCE);
        this.registerModule(AntiBot.INSTANCE);
        this.registerModule(new NoFall());
        this.registerModule(new AntiKick());
        this.registerModule(new AntiBlind());
        this.registerModule(new InstaBreak());
        this.registerModule(new InfiniteAura());
        this.registerModule(new Criticals());
        this.registerModule(new Crasher());
        this.registerModule(new Blink());
        this.registerModule(new DeviceSpoof());
        this.registerModule(new RemoteShop());
        this.registerModule(new Derp());
        this.registerModule(new Speed());
        this.registerModule(new HighJump());
        this.registerModule(Teams.INSTANCE);
        this.registerModule(new Teleport());
        this.registerModule(new FreeCam());
        this.registerModule(new AntiVoid());
        this.registerModule(new AntiExploit());
        this.registerModule(new ScoreBoard());
        this.registerModule(new NoSoundEventPacket());
        this.registerModule(new ComboOneHitExploit());
        this.registerModule(new GodMode());
        this.registerModule(new Scaffold());
        this.registerModule(new AntiSpammer());
        this.registerModule(new NoHurtCam());
        this.registerModule(new AirJump());
        this.registerModule(new NoFireCam());
        this.registerModule(new NoChat());
        this.registerModule(new NoLagBack());
        this.registerModule(new HitEffect());
        this.registerModule(new HUD());
        this.registerModule(new NameProtect());
        this.registerModule(new AutoL());
        this.registerModule(new TrueSight());
        this.registerModule(new Sneak());
        this.registerModule(new AutoFish());
        this.registerModule(new AutoGG());
        this.registerModule(new Breaker());
        this.registerModule(new PacketLoss());
        this.registerModule(new TimeChanger());
        this.registerModule(Friend.INSTANCE);
    }
}

