/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.config;

import dev.sora.relay.cheat.config.AbstractConfigManager;
import dev.sora.relay.cheat.module.ModuleManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0014J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/cheat/config/ConfigManagerFileSystem;", "Ldev/sora/relay/cheat/config/AbstractConfigManager;", "dir", "Ljava/io/File;", "suffix", "", "moduleManager", "Ldev/sora/relay/cheat/module/ModuleManager;", "(Ljava/io/File;Ljava/lang/String;Ldev/sora/relay/cheat/module/ModuleManager;)V", "deleteConfig", "", "name", "listConfig", "", "loadConfigData", "Ljava/io/Reader;", "saveConfigData", "data", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class ConfigManagerFileSystem
extends AbstractConfigManager {
    private final File dir;
    private final String suffix;

    public ConfigManagerFileSystem(File file, String string2, ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"suffix");
        Intrinsics.checkNotNullParameter((Object)moduleManager, (String)"moduleManager");
        super(moduleManager);
        this.dir = file;
        this.suffix = string2;
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Override
    public void deleteConfig(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"name");
        object = new File(this.dir, (String)object + ".json");
        if (((File)object).exists()) {
            ((File)object).delete();
        }
    }

    @Override
    public List<String> listConfig() {
        Object object4;
        Object object2 = this.dir.listFiles();
        if (object2 == null) {
            return CollectionsKt.emptyList();
        }
        Object object3 = new ArrayList();
        for (Object object4 : object2) {
            String string2 = ((File)object4).getName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"it.name");
            if (!StringsKt.endsWith$default((String)string2, (String)this.suffix, (boolean)false, (int)2, null)) continue;
            object3.add(object4);
        }
        object4 = (List)object3;
        object2 = (Iterable)object4;
        object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object3 = ((File)object2.next()).getName();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"it");
            object3 = ((String)object3).substring(0, ((String)object3).length() - this.suffix.length());
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
            object4.add(object3);
        }
        object4 = (List)object4;
        return object4;
    }

    @Override
    protected Reader loadConfigData(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"name");
        object = new File(this.dir, (String)object + ".json");
        if (!((File)object).exists()) {
            return null;
        }
        Charset charset = Charsets.UTF_8;
        return new InputStreamReader((InputStream)new FileInputStream((File)object), charset);
    }

    @Override
    protected void saveConfigData(String string2, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        FilesKt.writeBytes((File)new File(this.dir, string2 + ".json"), (byte[])byArray);
    }
}

