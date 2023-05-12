/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.game.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\u000e"}, d2={"Ldev/sora/relay/game/utils/NoteBlockUtils;", "", "()V", "readInt", "", "dataInputStream", "Ljava/io/DataInputStream;", "readShort", "", "readString", "", "Instrument", "Note", "Song", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class NoteBlockUtils {
    public static final NoteBlockUtils INSTANCE = new NoteBlockUtils();

    private NoteBlockUtils() {
    }

    private final int readInt(DataInputStream dataInputStream) {
        int n = dataInputStream.readUnsignedByte();
        return (dataInputStream.readUnsignedByte() << 8) + n + (dataInputStream.readUnsignedByte() << 16) + (dataInputStream.readUnsignedByte() << 24);
    }

    private final short readShort(DataInputStream dataInputStream) {
        int n = dataInputStream.readUnsignedByte();
        return (short)((dataInputStream.readUnsignedByte() << 8) + n);
    }

    private final String readString(DataInputStream object) {
        int n;
        StringBuilder stringBuilder = new StringBuilder(n);
        for (n = this.readInt((DataInputStream)object); n > 0; --n) {
            int n2;
            int n3 = n2 = (int)(UShort.constructor-impl(((DataInputStream)object).readByte()) & 0xFFFF);
            if (n2 == 13) {
                n3 = n2 = 32;
            }
            stringBuilder.append((char)n3);
        }
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"builder.toString()");
        return object;
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/game/utils/NoteBlockUtils$Instrument;", "", "(Ljava/lang/String;I)V", "PIANO", "BASS_DRUM", "DRUM", "STICKS", "BASS", "GLOCKENSPIEL", "FLUTE", "CHIME", "GUITAR", "XYLOPHONE", "VIBRAPHONE", "COW_BELL", "DIDGERIDOO", "SQUARE_WAVE", "BANJO", "ELECTRIC_PIANO", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static enum Instrument {
        PIANO,
        BASS_DRUM,
        DRUM,
        STICKS,
        BASS,
        GLOCKENSPIEL,
        FLUTE,
        CHIME,
        GUITAR,
        XYLOPHONE,
        VIBRAPHONE,
        COW_BELL,
        DIDGERIDOO,
        SQUARE_WAVE,
        BANJO,
        ELECTRIC_PIANO;

    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2={"Ldev/sora/relay/game/utils/NoteBlockUtils$Note;", "", "inst", "Ldev/sora/relay/game/utils/NoteBlockUtils$Instrument;", "key", "", "(Ldev/sora/relay/game/utils/NoteBlockUtils$Instrument;B)V", "getInst", "()Ldev/sora/relay/game/utils/NoteBlockUtils$Instrument;", "getKey", "()B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Note {
        private final Instrument inst;
        private final byte key;

        public Note(Instrument instrument, byte by) {
            Intrinsics.checkNotNullParameter((Object)((Object)instrument), (String)"inst");
            this.inst = instrument;
            this.key = by;
        }

        public static /* synthetic */ Note copy$default(Note note, Instrument instrument, byte by, int n, Object object) {
            if ((n & 1) != 0) {
                instrument = note.inst;
            }
            byte by2 = by;
            if ((n & 2) != 0) {
                by2 = by = note.key;
            }
            return note.copy(instrument, by2);
        }

        public final Instrument component1() {
            return this.inst;
        }

        public final byte component2() {
            return this.key;
        }

        public final Note copy(Instrument instrument, byte by) {
            Intrinsics.checkNotNullParameter((Object)((Object)instrument), (String)"inst");
            return new Note(instrument, by);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Note)) {
                return false;
            }
            object = (Note)object;
            if (this.inst != ((Note)object).inst) {
                return false;
            }
            return this.key == ((Note)object).key;
        }

        public final Instrument getInst() {
            return this.inst;
        }

        public final byte getKey() {
            return this.key;
        }

        public int hashCode() {
            return this.inst.hashCode() * 31 + Byte.hashCode(this.key);
        }

        public String toString() {
            return "Note(inst=" + (Object)((Object)this.inst) + ", key=" + this.key + ')';
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2={"Ldev/sora/relay/game/utils/NoteBlockUtils$Song;", "", "()V", "<set-?>", "", "maxTicks", "getMaxTicks", "()I", "ticks", "", "", "Ldev/sora/relay/game/utils/NoteBlockUtils$Note;", "getTicks", "()Ljava/util/Map;", "computeMaxTicks", "", "readNbs", "inputIn", "Ljava/io/InputStream;", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Song {
        private int maxTicks;
        private final Map<Integer, List<Note>> ticks = new LinkedHashMap();

        public final void computeMaxTicks() {
            int n = 0;
            Iterator iterator = ((Iterable)this.ticks.keySet()).iterator();
            while (iterator.hasNext()) {
                int n2 = ((Number)iterator.next()).intValue();
                int n3 = n;
                if (n2 > n) {
                    n3 = n2;
                }
                n = n3;
            }
            this.maxTicks = n;
        }

        public final int getMaxTicks() {
            return this.maxTicks;
        }

        public final Map<Integer, List<Note>> getTicks() {
            return this.ticks;
        }

        public final void readNbs(InputStream object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"inputIn");
            DataInputStream dataInputStream = new DataInputStream((InputStream)object);
            int n = INSTANCE.readShort(dataInputStream);
            int n2 = 0;
            if (n == 0) {
                n = dataInputStream.readByte();
                dataInputStream.readByte();
                n2 = n;
                if (n >= 3) {
                    INSTANCE.readShort(dataInputStream);
                    n2 = n;
                }
            }
            INSTANCE.readShort(dataInputStream);
            INSTANCE.readString(dataInputStream);
            INSTANCE.readString(dataInputStream);
            INSTANCE.readString(dataInputStream);
            INSTANCE.readString(dataInputStream);
            float f = (float)INSTANCE.readShort(dataInputStream) / 100.0f;
            dataInputStream.readBoolean();
            dataInputStream.readByte();
            dataInputStream.readByte();
            INSTANCE.readInt(dataInputStream);
            INSTANCE.readInt(dataInputStream);
            INSTANCE.readInt(dataInputStream);
            INSTANCE.readInt(dataInputStream);
            INSTANCE.readInt(dataInputStream);
            INSTANCE.readString(dataInputStream);
            n = 4;
            if (n2 >= 4) {
                dataInputStream.readByte();
                dataInputStream.readByte();
                INSTANCE.readShort(dataInputStream);
            }
            int n3 = -1;
            short s;
            block0: while ((s = INSTANCE.readShort(dataInputStream)) != 0) {
                n3 = (short)(n3 + s);
                while (true) {
                    if (INSTANCE.readShort(dataInputStream) == 0) continue block0;
                    s = dataInputStream.readByte();
                    byte by = (byte)(dataInputStream.readByte() - 33);
                    if (n2 >= n) {
                        dataInputStream.readByte();
                        dataInputStream.readByte();
                        INSTANCE.readShort(dataInputStream);
                    }
                    n = (int)Math.floor((float)n3 * 20.0f / f);
                    List<Note> list = this.ticks.get(n);
                    object = list;
                    if (list == null) {
                        object = new ArrayList();
                        this.ticks.put(n, (List<Note>)object);
                    }
                    object.add(new Note(Instrument.values()[s], by));
                    n = 4;
                }
                break;
            }
            return;
        }
    }
}

