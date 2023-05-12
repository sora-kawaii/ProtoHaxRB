/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 *  np.dcc.protect.EntryPoint
 */
package dev.sora.protohax.relay;

import dev.sora.protohax.App;
import dev.sora.relay.RakNetRelay;
import dev.sora.relay.cheat.command.CommandManager;
import dev.sora.relay.cheat.config.AbstractConfigManager;
import dev.sora.relay.cheat.config.ConfigManagerFileSystem;
import dev.sora.relay.cheat.module.ModuleManager;
import dev.sora.relay.game.GameSession;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import np.dcc.protect.EntryPoint;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0006\u0010!\u001a\u00020\u001cR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2={"Ldev/sora/protohax/relay/MinecraftRelay;", "", "()V", "commandManager", "Ldev/sora/relay/cheat/command/CommandManager;", "getCommandManager", "()Ldev/sora/relay/cheat/command/CommandManager;", "configManager", "Ldev/sora/relay/cheat/config/AbstractConfigManager;", "getConfigManager", "()Ldev/sora/relay/cheat/config/AbstractConfigManager;", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "getModuleManager", "()Ldev/sora/relay/cheat/module/ModuleManager;", "neteaseMode", "", "getNeteaseMode", "()Z", "setNeteaseMode", "(Z)V", "relay", "Ldev/sora/relay/RakNetRelay;", "session", "Ldev/sora/relay/game/GameSession;", "getSession", "()Ldev/sora/relay/game/GameSession;", "close", "", "getMSAccessToken", "Lkotlin/Pair;", "", "refreshToken", "listen", "app_debug"}, k=1, mv={1, 6, 0}, xi=48)
public final class MinecraftRelay {
    public static final MinecraftRelay INSTANCE;
    private static final CommandManager commandManager;
    private static final AbstractConfigManager configManager;
    private static final ModuleManager moduleManager;
    private static boolean neteaseMode;
    private static RakNetRelay relay;
    private static final GameSession session;

    static {
        String string2 = "\u06e0\u06df\u06df\u06e0\u06e5\u06d9\u06e8\u06e1\u06d6\u06d8\u06dc\u06dc\u06e6\u06d8\u06e7\u06d6\u06d8\u06e7\u06e2\u06db\u06e1\u06d6";
        File file = null;
        CommandManager commandManager = null;
        ModuleManager moduleManager = null;
        GameSession gameSession = null;
        block19: while (true) {
            switch (string2.hashCode() ^ 0x4D ^ 0x9F705D47) {
                default: {
                    continue block19;
                }
                case 515698183: {
                    EntryPoint.stub((int)11);
                    string2 = "\u06df\u06e5\u06da\u06eb\u06da\u06e6\u06e1\u06d8\u06e0\u06e8\u06d8\u06d6\u06d9\u06db\u06ec\u06e5\u06dc\u06e8\u06d6\u06d7";
                    continue block19;
                }
                case 353720706: {
                    INSTANCE = new MinecraftRelay();
                    string2 = "\u06db\u06eb\u06dc\u06d8\u06da\u06e2\u06e5\u06d9\u06e5\u06e8\u06d9\u06dc\u06ec\u06e4\u06ec\u06e5\u06db\u06e0\u06d7\u06db\u06e5\u06d8\u06d9\u06d8\u06e7\u06d8";
                    continue block19;
                }
                case 981520257: {
                    gameSession = new GameSession();
                    string2 = "\u06d8\u06e0\u06e7\u06d7\u06d6\u06e1\u06d8\u06d8\u06ec\u06d6\u06da\u06e7\u06e0\u06e8\u06e4\u06da\u06dc\u06e4\u06e8\u06d8\u06eb\u06da\u06e2\u06e1\u06dc\u06e8\u06d8";
                    continue block19;
                }
                case -264971868: {
                    session = gameSession;
                    string2 = "\u06e1\u06e5\u06e6\u06d8\u06dc\u06df\u06e8\u06dc\u06e2\u06e5\u06e6\u06eb\u06dc\u06d8\u06e4\u06e4\u06d6\u06e8\u06dc\u06d8\u06d8\u06e4\u06e6\u06d8\u06d8\u06dc\u06d6";
                    continue block19;
                }
                case -1113740577: {
                    string2 = "\u06ec\u06eb\u06eb\u06e5\u06e5\u06d6\u06d8\u06ec\u06d7\u06e2\u06d6\u06e2\u06d6\u06d8\u06d8\u06e2\u06d6\u06d8\u06ec\u06e6\u06e1\u06d8\u06e2\u06e1\u06e2\u06e5\u06d8\u06e6\u06e1\u06e1\u06d8";
                    continue block19;
                }
                case -905170402: {
                    moduleManager = new ModuleManager(gameSession);
                    string2 = "\u06e6\u06d9\u06e8\u06e5\u06eb\u06e1\u06d7\u06d8\u06e2\u06eb\u06e6\u06e5\u06e5\u06e0\u06e0\u06db\u06e2\u06da";
                    continue block19;
                }
                case -1252911817: {
                    MinecraftRelay.moduleManager = moduleManager;
                    string2 = "\u06ec\u06e6\u06e1\u06d8\u06eb\u06d6\u06e8\u06e5\u06e6\u06d8\u06e6\u06db\u06ec\u06e2\u06d9\u06db\u06dc\u06ec\u06d9\u06e2\u06e1\u06e8\u06d8\u06e4\u06e1\u06d9\u06db\u06df\u06eb";
                    continue block19;
                }
                case -1885353183: {
                    moduleManager.init();
                    string2 = "\u06e2\u06e5\u06df\u06e7\u06dc\u06eb\u06eb\u06ec\u06e8\u06d8\u06ec\u06e6\u06e8\u06d8\u06eb\u06dc\u06e8\u06d8";
                    continue block19;
                }
                case -927311300: {
                    commandManager = new CommandManager(gameSession);
                    string2 = "\u06e2\u06e6\u06d6\u06d8\u06dc\u06e6\u06dc\u06dc\u06d7\u06d9\u06d7\u06dc\u06d6\u06d8\u06d7\u06d6\u06da\u06d9\u06d8";
                    continue block19;
                }
                case 112936715: {
                    MinecraftRelay.commandManager = commandManager;
                    string2 = "\u06d9\u06ec\u06eb\u06d9\u06e2\u06dc\u06e2\u06e4\u06d7\u06eb\u06e0\u06e7\u06d8\u06e5";
                    continue block19;
                }
                case -1007440689: {
                    commandManager.init(moduleManager);
                    string2 = "\u06e1\u06eb\u06db\u06e7\u06e6\u06e6\u06d8\u06da\u06ec\u06e7\u06e8\u06eb\u06e4\u06d8\u06e2\u06ec\u06e5\u06da\u06e6\u06e8\u06e8\u06dc\u06df\u06d7\u06d7";
                    continue block19;
                }
                case -913592822: {
                    file = App.Companion.getApp().getExternalFilesDir("configs");
                    string2 = "\u06eb\u06e2\u06da\u06d6\u06da\u06df\u06e4\u06df\u06eb\u06d7\u06d9\u06d7\u06e2\u06d7\u06e2\u06e0\u06e0\u06dc";
                    continue block19;
                }
                case 944650598: {
                    Intrinsics.checkNotNull(file);
                    string2 = "\u06d8\u06db\u06dc\u06dc\u06eb\u06ec\u06e8\u06e1\u06e8\u06d8\u06ec\u06e2\u06eb\u06e1\u06e4\u06e8\u06d8";
                    continue block19;
                }
                case -701862831: {
                    Intrinsics.checkNotNullExpressionValue(file, (String)"App.app.getExternalFilesDir(\"configs\")!!");
                    string2 = "\u06da\u06e4\u06db\u06eb\u06db\u06d6\u06d8\u06d7\u06e0\u06e4\u06e7\u06e4\u06e8\u06da\u06d7\u06e6\u06d8\u06e2\u06d8\u06d9";
                    continue block19;
                }
                case -1428523221: {
                    configManager = new ConfigManagerFileSystem(file, ".json", moduleManager);
                    string2 = "\u06e5\u06ec\u06e8\u06d9\u06e5\u06e7\u06d8\u06df\u06df\u06d9\u06e7\u06df\u06e1\u06e8\u06d6\u06d6\u06e0\u06db\u06d8\u06d8\u06dc\u06db\u06d9\u06e6\u06d9\u06e8\u06e4\u06db\u06d9";
                    continue block19;
                }
                case 1910399320: {
                    gameSession.getEventManager().registerListener(commandManager);
                    string2 = "\u06da\u06e1\u06e1\u06d8\u06eb\u06e4\u06dc\u06d8\u06ec\u06d6\u06d6\u06d8\u06e8\u06e4\u06dc\u06d8\u06db\u06e4\u06db\u06d7\u06db\u06e5\u06df\u06e8\u06e0\u06db\u06d8\u06d7\u06dc\u06d6\u06d8";
                    continue block19;
                }
                case -590920929: 
            }
            break;
        }
    }

    private MinecraftRelay() {
    }

    public static final /* synthetic */ Pair access$getMSAccessToken(MinecraftRelay minecraftRelay, String string2) {
        String string3 = "\u06da\u06df\u06d8\u06d8\u06e4\u06e8\u06d6\u06d8\u06e2\u06e4\u06e2\u06db\u06d9\u06e6\u06d9\u06da\u06dc\u06e7\u06da\u06e7\u06e5\u06d6\u06e1\u06ec\u06e4\u06da\u06db\u06d6\u06e6";
        block5: while (true) {
            switch (string3.hashCode() ^ 0x305 ^ 0x23544F8) {
                default: {
                    continue block5;
                }
                case -609655760: {
                    string3 = "\u06e2\u06e7\u06e6\u06db\u06df\u06eb\u06e6\u06db\u06e0\u06e0\u06dc\u06df\u06e5\u06e7\u06d8\u06dc\u06d9\u06e1\u06d8";
                    continue block5;
                }
                case 168037457: {
                    string3 = "\u06eb\u06e5\u06d7\u06e6\u06e2\u06d6\u06d8\u06e6\u06e8\u06e0\u06db\u06d8\u06ec\u06ec\u06e1\u06df";
                    continue block5;
                }
                case -488982013: 
            }
            break;
        }
        return minecraftRelay.getMSAccessToken(string2);
    }

    private final native Pair getMSAccessToken(String var1);

    public final native void close();

    public final native CommandManager getCommandManager();

    public final native AbstractConfigManager getConfigManager();

    public final native ModuleManager getModuleManager();

    public final native boolean getNeteaseMode();

    public final native GameSession getSession();

    public final native void listen();

    public final native void setNeteaseMode(boolean var1);
}

