/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.module.impl.action;

import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEvent2Packet;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEventPacket;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.game.event.Listen;
import dev.sora.relay.game.event.impl.EventTick;
import dev.sora.relay.game.utils.NoteBlockUtils;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/cheat/module/impl/action/BGM;", "Ldev/sora/relay/cheat/module/CheatModule;", "()V", "modeValue", "Ldev/sora/relay/cheat/value/ListValue;", "song", "Ldev/sora/relay/game/utils/NoteBlockUtils$Song;", "ticks", "", "onEnable", "", "onTick", "event", "Ldev/sora/relay/game/event/impl/EventTick;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class BGM
extends CheatModule {
    private final ListValue modeValue;
    private final NoteBlockUtils.Song song;
    private int ticks;

    public BGM() {
        super("BGM", false, false, 6, null);
        String string = "Server";
        Object object = "Client";
        this.modeValue = new ListValue("Mode", new String[]{string, object}, string);
        object = new NoteBlockUtils.Song();
        ((NoteBlockUtils.Song)object).readNbs(new ByteArrayInputStream(Base64.getDecoder().decode("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ZAAAAQAAEmRkAAAAAAIAAQAALmRkAAABAAAZZGQAAAAAAgABAAA2ZGQAAAEAACJkZAAAAAACAAEAAC5kZAAAAQAAGWRkAAAAAAIAAQAAOGRkAAABAAANZGQAAAAAAgABAAA2ZGQAAAEAACBkZAAAAAACAAEAADNkZAAAAQAAKWRkAAAAAAIAAQAANmRkAAABAAAgZGQAAAAAAgABAAA4ZGQAAAEAABlkZAAAAAACAAEAADFkZAAAAQAAIGRkAAAAAAIAAQAANmRkAAABAAApZGQAAAAAAgABAAAxZGQAAAEAACBkZAAAAAACAAEAADpkZAAAAQAAG2RkAAAAAAIAAQAALmRkAAABAAAiZGQAAAAAAgABAAA2ZGQAAAEAACpkZAAAAAACAAEAAC5kZAAAAQAAImRkAAAAAAIAAQAAOGRkAAABAAAbZGQAAAAAAgABAAAuZGQAAAEAACJkZAAAAAACAAEAADpkZAAAAQAAKmRkAAAAAAIAAQAALmRkAAABAAAiZGQAAAAAAgABAAAvZGQAAAEAABdkZAAAAAACAAEAACpkZAAAAQAAHmRkAAAAAAIAAQAANmRkAAABAAAnZGQAAAAAAgABAAAvZGQAAAEAAB5kZAAAAAACAAEAADNkZAAAAQAAF2RkAAAAAAIAAQAAL2RkAAABAAAeZGQAAAAAAgABAAA2ZGQAAAEAACdkZAAAAAACAAEAADhkZAAAAQAAHmRkAAAAAAIAAQAAOmRkAAABAAASZGQAAAAAAgABAAAxZGQAAAEAABlkZAAAAAACAAEAADZkZAAAAQAAImRkAAAAAAIAAQAAMWRkAAABAAAZZGQAAAAAAgABAAA9ZGQAAAEAABJkZAAAAAACAAEAADFkZAAAAQAAGWRkAAAAAAIAAQAAOmRkAAABAAAiZGQAAAAAAgABAAAxZGQAAAEAABlkZAAAAAACAAEAADhkZAAAAQAADWRkAAAAAAIAAQAANmRkAAABAAAgZGQAAAAAAgABAAA4ZGQAAAEAAClkZAAAAAACAAEAADFkZAAAAQAAIGRkAAAAAAIAAQAAOmRkAAABAAAZZGQAAAAAAgABAAAxZGQAAAEAACBkZAAAAAACAAEAADZkZAAAAQAAKWRkAAAAAAIAAQAAMWRkAAABAAAgZGQAAAAAAgABAAA4ZGQAAAEAABtkZAAAAAACAAEAADZk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ZAAAAAAEAAEAAEZkZAAAAQAAQWRkAAABAAA6ZGQAAAEAACpkZAAAAQAAJ2RkAAABAAAjZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAnZGQAAAEAACpkZAAAAQAAI2RkAAAAAAIAAQAAOGRkAAABAABEZGQAAAEAAD9kZAAAAQAAHmRkAAABAAAjZGQAAAAAAgABAAA6ZGQAAAEAAEZkZAAAAQAAQWRkAAAAAAIAAQAAQmRkAAABAAA9ZGQAAAEAAElkZAAAAQAAKmRkAAABAAAnZGQAAAEAACNkZAAAAAACAAEAADpkZAAAAQAARmRkAAABAAA/ZGQAAAAAAgABAABCZGQAAAEAAD1kZAAAAQAANmRkAAABAAAGZGQAAAEAABJkZAAAAAACAAEAADNkZAAAAQAAP2RkAAABAAA6ZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAqZGQAAAEAACJkZAAAAQAAJWRkAAAAAAIAAQAAOGRkAAABAABEZGQAAAEAAD9kZAAAAQAAImRkAAABAAAqZGQAAAEAACVkZAAAAAACAAEAADZkZAAAAQAAQmRkAAABAAA9ZGQAAAEAACJkZAAAAQAAHmRkAAAAAAIAAQAAM2RkAAABAAA/ZGQAAAEAADpkZAAAAAACAAEAADZkZAAAAQAAQmRkAAABAAA9ZGQAAAEAACpkZAAAAQAAImRkAAABAAAlZGQAAAAAAgABAAAxZGQAAAEAAD1kZAAAAQAAOGRkAAAAAAIAAQAAOGRkAAABAABEZGQAAAEAAD9kZAAAAQAAAWRkAAABAAANZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAAAAAIAAQAAP2RkAAABAAAzZGQAAAEAADhkZAAAAQAAKWRkAAABAAAlZGQAAAEAACBkZAAAAAACAAEAADZkZAAAAQAAQmRkAAABAAA9ZGQAAAEAACBkZAAAAQAAJWRkAAABAAApZGQAAAAAAgABAAA4ZGQAAAEAAERkZAAAAQAAP2RkAAABAAAgZGQAAAEAABlkZAAAAAAEAAEAADZkZAAAAQAAQmRkAAABAAA9ZGQAAAEAACBkZAAAAQAAJWRkAAABAAApZGQAAAAABAABAABGZGQAAAEAADpkZAAAAQAAP2RkAAABAAAPZGQAAAEAAANkZAAAAAAEAAEAADZkZAAAAQAAQmRkAAABAAA6ZGQAAAEAAD9kZAAAAQAAKmRkAAABAAAiZGQAAAEAACdkZAAAAAACAAEAACJkZAAAAQAAJ2RkAAABAAAqZGQAAAAAAgABAAA4ZGQAAAEAAERkZAAAAQAAP2RkAAABAAAiZGQAAAEAABtkZAAAAAAEAAEAADpkZAAAAQAAP2RkAAABAABGZGQAAAEAAEJkZAAAAQAAKmRkAAABAAAnZGQAAAEAACJkZAAAAAAEAAEAAAtkZAAAAQAAF2RkAAAAAAIAAQAAQmRkAAABAAA7ZGQAAAEAADZkZAAAAAACAAEAACpkZAAAAQAAJ2RkAAABAAAjZGQAAAAAAgABAAAnZGQAAAEAACpkZAAAAQAAI2RkAAAAAAIAAQAAM2RkAAABAAA/ZGQAAAEAADZkZAAAAQAAO2RkAAABAAAjZGQAAAEAAB5kZAAAAAAEAAEAADZkZAAAAQAAQmRkAAABAAA7ZGQAAAEAACpkZAAAAQAAJ2RkAAABAAAjZGQAAAAAAgABAAA4ZGQAAAEAAERkZAAAAQAAO2RkAAAAAAIAAQAAOmRkAAABAABGZGQAAAEAAD1kZAAAAQAAQmRkAAABAAAGZGQAAAEAABJkZAAAAAAEAAEAACpkZAAAAQAAImRkAAABAAAlZGQAAAAAAgABAAAiZGQAAAEAACpkZAAAAQAAJWRkAAAAAAIAAQAAQmRkAAABAAA9ZGQAAAEAAElkZAAAAQAARmRkAAABAAAiZGQAAAEAAB5kZAAAAAAEAAEAADpkZAAAAQAAPWRkAAABAABCZGQAAAEAAEZkZAAAAQAAKmRkAAABAAAiZGQAAAEAACVkZAAAAAAEAAEAAERkZAAAAQAAOGRkAAABAAA9ZGQAAAEAAAFkZAAAAQAADWRkAAAAAAIAAQAAQmRkAAABAAA2ZGQAAAEAAD1kZAAAAAACAAEAAERkZAAAAQAAOGRkAAABAAA9ZGQAAAEAAClkZAAAAQAAJWRkAAABAAAgZGQAAAAAAgABAAAgZGQAAAEAACVkZAAAAQAAKWRkAAAAAAIAAQAARmRkAAABAAA6ZGQAAAEAAD1kZAAAAQAAIGRkAAABAAAZZGQAAAAABAABAAAgZGQAAAEAACVkZAAAAQAAKWRkAAAAAAIAAQAAQmRkAAABAAA2ZGQAAAEAAD1kZAAAAAACAAEAAERkZAAAAQAAOGRkAAABAAA/ZGQAAAEAAA9kZAAAAQAAA2RkAAAAAAIAAQAANmRkAAABAAA/ZGQAAAEAAEJkZAAAAAACAAEAADNkZAAAAQAAP2RkAAABAAA6ZGQAAAEAACpkZAAAAQAAImRkAAABAAAnZGQAAAAAAgABAAA2ZGQAAAEAADpkZAAAAQAAP2RkAAABAABCZGQAAAEAACJkZAAAAQAAJ2RkAAABAAAqZGQAAAAAAgABAABEZGQAAAEAADhkZAAAAQAAP2RkAAABAAA6ZGQAAAEAACJkZAAAAQAAG2RkAAAAAAQAAQAANmRkAAABAAA6ZGQAAAEAAD9kZAAAAQAAQmRkAAABAAAqZGQAAAEAACdkZAAAAQAAImRkAAAAAAQAAQAARGRkAAABAAA4ZGQAAAEAAD9kZAAAAQAAC2RkAAABAAAXZGQAAAAABAABAABGZGQAAAEAAEFkZAAAAQAAOmRkAAABAAAqZGQAAAEAACdkZAAAAQAAI2RkAAAAAAIAAQAANmRkAAABAABCZGQAAAEAAD1kZAAAAQAAJ2RkAAABAAAqZGQAAAEAACNkZAAAAAACAAEAADhkZAAAAQAARGRkAAABAAA/ZGQAAAEAAB5kZAAAAQAAI2RkAAAAAAIAAQAAOmRkAAABAABGZGQAAAEAAEFkZAAAAAACAAEAAEJkZAAAAQAAPWRkAAABAABJZGQAAAEAACpkZAAAAQAAJ2RkAAABAAAjZGQAAAAAAgABAAA6ZGQAAAEAAEZkZAAAAQAAP2RkAAAAAAIAAQAAQmRkAAABAAA9ZGQAAAEAADZkZAAAAQAABmRkAAABAAASZGQAAAAAAgABAAAzZGQAAAEAAD9kZAAAAQAAOmRkAAAAAAIAAQAANmRkAAABAABCZGQAAAEAAD1kZAAAAQAAKmRkAAABAAAiZGQAAAEAACVkZAAAAAACAAEAADhkZAAAAQAARGRkAAABAAA/ZGQAAAEAACJkZAAAAQAAKmRkAAABAAAlZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAiZGQAAAEAAB5kZAAAAAACAAEAADNkZAAAAQAAP2RkAAABAAA6ZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAqZGQAAAEAACJkZAAAAQAAJWRkAAAAAAIAAQAAMWRkAAABAAA9ZGQAAAEAADhkZAAAAAACAAEAADhkZAAAAQAARGRkAAABAAA/ZGQAAAEAAAFkZAAAAQAADWRkAAAAAAIAAQAANmRkAAABAABCZGQAAAEAAD1kZAAAAAACAAEAAD9kZAAAAQAAM2RkAAABAAA4ZGQAAAEAAClkZAAAAQAAJWRkAAABAAAgZGQAAAAAAgABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAgZGQAAAEAACVkZAAAAQAAKWRkAAAAAAIAAQAAOGRkAAABAABEZGQAAAEAAD9kZAAAAQAAIGRkAAABAAAZZGQAAAAABAABAAA2ZGQAAAEAAEJkZAAAAQAAPWRkAAABAAAgZGQAAAEAACVkZAAAAQAAKWRkAAAAAAQAAQAAOmRkAAABAAAbZGQAAAAABAABAAA2ZGQAAAEAACJkZAAAAAAEAAEAADhkZAAAAQAAKmRkAAAAAAQAAQAAOmRkAAAAAAQAAQAAI2RkAAAAAAIAAQAANmRkAAAAAAIAAQAAKmRkAAAAAAQAAQAAM2RkAAABAAAvZGQAAAAABAABAAA2ZGQAAAAAAgABAAA4ZGQAAAAAAgABAAA6ZGQAAAEAAB5kZAAAAAAEAAEAACVkZAAAAAAEAAEAAD1kZAAAAQAALmRkAAAAAAQAAQAAOmRkAAAAAAQAAQAAOGRkAAABAAAlZGQAAAAAAgABAAA2ZGQAAAAAAgABAAA4ZGQAAAEAABlkZAAAAAAEAAEAADpkZAAAAQAAIGRkAAAAAAQAAQAAKWRkAAAAAAIAAQAANmRkAAAAAAIAAQAAOGRkAAABAAAbZGQAAAAAAwABAAA2ZGQAAAAAAQABAAAzZGQAAAEAACJkZAAAAAADAAEAADZkZAAAAAABAAEAADhkZAAAAQAAKmRkAAAAAAQAAQAANmRkAAABAAAiZGQAAAAABAABAAA4ZGQAAAEAACNkZAAAAAAEAAEAADpkZAAAAQAAKmRkAAAAAAIAAQAANmRkAAAAAAIAAQAAOGRkAAABAAAvZGQAAAAAAgABAAA6ZGQAAAAAAgABAAA9ZGQAAAEAACpkZAAAAAACAAEAADpkZAAAAAACAAEAADZkZAAAAQAAKmRkAAAAAAIAAQAAM2RkAAAAAAIAAQAANmRkAAABAAAeZGQAAAAAAgABAAA4ZGQAAAAAAgABAAA2ZGQAAAEAACJkZAAAAAACAAEAADNkZAAAAAACAAEAADZkZAAAAQAAJWRkAAAAAAQAAQAAOGRkAAABAAAlZGQAAAAAAgABAAA2ZGQAAAAAAgABAAAzZGQAAAEAABlkZAAAAAACAAEAADZkZAAAAAACAAEAADhkZAAAAQAAIGRkAAAAAAQAAQAANmRkAAABAAAlZGQAAAAABAABAAA6ZGQAAAEAABtkZAAAAAAEAAEAADZkZAAAAQAAImRkAAAAAAQAAQAAOGRkAAABAAAqZGQAAAAABAABAAA6ZGQAAAAABAABAAAjZGQAAAAAAgABAAA2ZGQAAAAAAgABAAAqZGQAAAAABAABAAAzZGQAAAEAAC9kZAAAAAAEAAEAADZkZAAAAAACAAEAADhkZAAAAAACAAEAADpkZAAAAQAAHmRkAAAAAAQAAQAAJWRkAAAAAAQAAQAAPWRkAAABAAAuZGQAAAAABAABAAA6ZGQAAAAABAABAAA4ZGQAAAEAACVkZAAAAAACAAEAADZkZAAAAAACAAEAADhkZAAAAQAAGWRkAAAAAAQAAQAAOmRkAAABAAAgZGQAAAAABAABAAApZGQAAAAAAgABAAA2ZGQAAAAAAgABAAA4ZGQAAAEAABtkZAAAAAADAAEAADZkZAAAAAABAAEAADNkZAAAAQAAImRkAAAAAAMAAQAANmRkAAAAAAEAAQAAOGRkAAABAAAqZGQAAAAABAABAAA2ZGQAAAEAACJkZAAAAAAEAAEAADhkZAAAAQAAI2RkAAAAAAQAAQAAOmRkAAABAAAqZGQAAAAAAgABAAA2ZGQAAAAAAgABAAA4ZGQAAAEAAC9kZAAAAAACAAEAADpkZAAAAAACAAEAAD1kZAAAAQAAKmRkAAAAAAIAAQAAOmRkAAAAAAIAAQAANmRkAAABAAAqZGQAAAAAAgABAAAzZGQAAAAAAgABAAA2ZGQAAAEAAB5kZAAAAAACAAEAADhkZAAAAAACAAEAADZkZAAAAQAAImRkAAAAAAIAAQAAM2RkAAAAAAIAAQAANmRkAAABAAAlZGQAAAAABAABAAA4ZGQAAAEAACVkZAAAAAACAAEAADZkZAAAAAACAAEAADNkZAAAAQAAGWRkAAAAAAIAAQAANmRkAAAAAAIAAQAAOGRkAAABAAAgZGQAAAAABAABAAA2ZGQAAAEAACVkZAAAAAAEAAEAADNkZAAAAQAALmRkAAABAAAPZGQAAAAAAgABAAAuZGQAAAEAADNkZAAAAQAAImRkAAAAAAIAAQAALmRkAAABAAAzZGQAAAEAACpkZAAAAAACAAEAAC5kZAAAAQAAM2RkAAAAAAIAAQAALGRkAAABAAAxZGQAAAEAAA1kZAAAAAACAAEAACBkZAAAAAACAAEAADFkZAAAAQAALGRkAAABAAApZGQAAAAABAABAAApZGQAAAEAAC5kZAAAAQAACmRkAAAAAAIAAQAAHWRkAAAAAAIAAQAALmRkAAABAAApZGQAAAEAACVkZAAAAAAEAAEAACxkZAAAAQAAMWRkAAABAAANZGQAAAAAAgABAAAgZGQAAAAAAgABAAApZGQAAAAAAAALAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQLAAAAR3JhbmQgUGlhbm8AZGQAAAAAAGRkAAAAAABkZAAAAAAAZGQAAAAAAGRkAA")));
        ((NoteBlockUtils.Song)object).computeMaxTicks();
        this.song = object;
    }

    @Override
    public void onEnable() {
        this.ticks = -1;
        this.chat(this.song.getMaxTicks() / 20 + " seconds");
    }

    @Listen
    public final void onTick(EventTick eventTick) {
        Intrinsics.checkNotNullParameter((Object)eventTick, (String)"event");
        if (this.ticks + 20 > this.song.getMaxTicks()) {
            this.ticks = 0;
        }
        Object object2 = this.song.getTicks();
        int n = this.ticks;
        this.ticks = n + 1;
        if ((object2 = object2.get(n)) == null) {
            return;
        }
        for (Object object2 : (Iterable)object2) {
            LevelSoundEvent2Packet levelSoundEvent2Packet;
            boolean bl = Intrinsics.areEqual(this.modeValue.get(), (Object)"Server");
            String string = ":";
            if (bl) {
                levelSoundEvent2Packet = new LevelSoundEventPacket();
                levelSoundEvent2Packet.setSound(SoundEvent.NOTE);
                levelSoundEvent2Packet.setPosition(eventTick.getSession().getThePlayer().getVec3Position());
                levelSoundEvent2Packet.setExtraData(((NoteBlockUtils.Note)object2).getInst().ordinal() << 8 | ((NoteBlockUtils.Note)object2).getKey());
                levelSoundEvent2Packet.setIdentifier(string);
                levelSoundEvent2Packet.setBabySound(false);
                levelSoundEvent2Packet.setRelativeVolumeDisabled(false);
                eventTick.getSession().sendPacket(levelSoundEvent2Packet);
                continue;
            }
            levelSoundEvent2Packet = new LevelSoundEvent2Packet();
            levelSoundEvent2Packet.setSound(SoundEvent.NOTE);
            levelSoundEvent2Packet.setPosition(eventTick.getSession().getThePlayer().getVec3Position());
            levelSoundEvent2Packet.setExtraData(((NoteBlockUtils.Note)object2).getInst().ordinal() << 8 | ((NoteBlockUtils.Note)object2).getKey());
            levelSoundEvent2Packet.setIdentifier(string);
            levelSoundEvent2Packet.setBabySound(false);
            levelSoundEvent2Packet.setRelativeVolumeDisabled(false);
            eventTick.getSession().sendPacketToClient(levelSoundEvent2Packet);
        }
    }
}
