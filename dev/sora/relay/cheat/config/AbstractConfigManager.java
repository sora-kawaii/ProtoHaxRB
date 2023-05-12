/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.module.ModuleManager;
import dev.sora.relay.cheat.value.Value;
import dev.sora.relay.utils.LoggerKt;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H&J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000fH$J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH$J\b\u0010\u001d\u001a\u00020\u0018H\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2={"Ldev/sora/relay/cheat/config/AbstractConfigManager;", "", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "(Ldev/sora/relay/cheat/module/ModuleManager;)V", "DEFAULT_GSON", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getDEFAULT_GSON", "()Lcom/google/gson/Gson;", "getModuleManager", "()Ldev/sora/relay/cheat/module/ModuleManager;", "deleteConfig", "", "name", "", "listConfig", "", "loadConfig", "", "loadConfigData", "Ljava/io/Reader;", "loadConfigSectionModule", "json", "Lcom/google/gson/JsonObject;", "saveConfig", "saveConfigData", "data", "", "saveConfigSectionModule", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class AbstractConfigManager {
    private final Gson DEFAULT_GSON;
    private final ModuleManager moduleManager;

    public AbstractConfigManager(ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter((Object)moduleManager, (String)"moduleManager");
        this.moduleManager = moduleManager;
        this.DEFAULT_GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    public abstract void deleteConfig(String var1);

    public final Gson getDEFAULT_GSON() {
        return this.DEFAULT_GSON;
    }

    public final ModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public abstract List<String> listConfig();

    public final boolean loadConfig(String object) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"name");
            try {
                object = this.loadConfigData((String)object);
                if (object != null) break block3;
                return false;
            }
            catch (Throwable throwable) {
                LoggerKt.logError("failed to load config", throwable);
                return false;
            }
        }
        object = JsonParser.parseReader((Reader)object).getAsJsonObject().getAsJsonObject("modules");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"json.getAsJsonObject(\"modules\")");
        this.loadConfigSectionModule((JsonObject)object);
        return true;
    }

    protected abstract Reader loadConfigData(String var1);

    /*
     * Unable to fully structure code
     */
    protected final void loadConfigSectionModule(JsonObject var1_1) {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"json");
        var2_2 = ((Iterable)this.moduleManager.getModules()).iterator();
        block2: while (true) {
            var3_3 = var1_1;
            if (!var2_2.hasNext()) break;
            var4_4 = (CheatModule)var2_2.next();
            if (!var3_3.has(var4_4.getName())) continue;
            var3_3 = var3_3.getAsJsonObject(var4_4.getName());
            try {
                var5_5 = var3_3.get("state").getAsBoolean();
            }
            catch (Throwable var6_7) {
                var5_5 = var4_4.getDefaultOn();
            }
            var4_4.setState(var5_5);
            var6_6 = "values";
            if (!var3_3.has((String)var6_6)) continue;
            var3_3 = var3_3.getAsJsonObject((String)var6_6);
            var4_4 = ((Iterable)var4_4.getValues()).iterator();
            while (true) {
                if (var4_4.hasNext()) ** break;
                continue block2;
                var7_8 = (Value)var4_4.next();
                if (!var3_3.has(var7_8.getName())) continue;
                var6_6 = var3_3.get(var7_8.getName());
                Intrinsics.checkNotNullExpressionValue((Object)var6_6, (String)"valuesJson.get(v.name)");
                var7_8.fromJson((JsonElement)var6_6);
            }
            break;
        }
    }

    public final void saveConfig(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        try {
            Object object = new JsonObject();
            ((JsonObject)object).add("modules", this.saveConfigSectionModule());
            object = this.DEFAULT_GSON.toJson((JsonElement)object);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"DEFAULT_GSON.toJson(json)");
            object = ((String)object).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).getBytes(charset)");
            this.saveConfigData(string2, (byte[])object);
        }
        catch (Throwable throwable) {
            LoggerKt.logError("failed to save config", throwable);
        }
    }

    protected abstract void saveConfigData(String var1, byte[] var2);

    protected final JsonObject saveConfigSectionModule() {
        JsonObject jsonObject = new JsonObject();
        Iterable iterable = this.moduleManager.getModules();
        for (CheatModule cheatModule : iterable) {
            JsonObject jsonObject2 = new JsonObject();
            boolean bl = cheatModule.getState();
            jsonObject2.addProperty("state", bl);
            List<Value<?>> list = cheatModule.getValues();
            if (((Collection)list).isEmpty() ^ true) {
                JsonElement jsonElement = new JsonObject();
                for (Value value : (Iterable)list) {
                    ((JsonObject)jsonElement).add(value.getName(), value.toJson());
                }
                jsonElement = jsonElement;
                jsonObject2.add("values", jsonElement);
            }
            jsonObject.add(cheatModule.getName(), jsonObject2);
        }
        return jsonObject;
    }
}

