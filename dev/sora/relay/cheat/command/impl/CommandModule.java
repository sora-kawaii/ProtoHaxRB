/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.cheat.command.impl;

import dev.sora.relay.cheat.command.Command;
import dev.sora.relay.cheat.command.impl.CommandModule;
import dev.sora.relay.cheat.module.CheatModule;
import dev.sora.relay.cheat.value.BoolValue;
import dev.sora.relay.cheat.value.FloatValue;
import dev.sora.relay.cheat.value.IntValue;
import dev.sora.relay.cheat.value.ListValue;
import dev.sora.relay.cheat.value.StringValue;
import dev.sora.relay.cheat.value.Value;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001b\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/cheat/command/impl/CommandModule;", "Ldev/sora/relay/cheat/command/Command;", "module", "Ldev/sora/relay/cheat/module/CheatModule;", "(Ldev/sora/relay/cheat/module/CheatModule;)V", "values", "", "Ldev/sora/relay/cheat/value/Value;", "chatSyntax", "", "syntax", "", "exec", "args", "", "([Ljava/lang/String;)V", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class CommandModule
extends Command {
    private final CheatModule module;
    private final List<Value<?>> values;

    public CommandModule(CheatModule cheatModule) {
        Intrinsics.checkNotNullParameter((Object)cheatModule, (String)"module");
        String string2 = cheatModule.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).toLowerCase(Locale.ROOT)");
        super(string2);
        this.module = cheatModule;
        this.values = cheatModule.getValues();
    }

    private final void chatSyntax(String string2) {
        this.chat("Syntax: -" + (String)ArraysKt.first((Object[])this.getAlias()) + ' ' + string2);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void exec(String[] var1_1) {
        block26: {
            block25: {
                block24: {
                    Intrinsics.checkNotNullParameter((Object)var1_1, (String)"args");
                    var2_2 = this.values;
                    var3_4 = "/";
                    var4_5 = CollectionsKt.joinToString$default((Iterable)var2_2, (CharSequence)var3_4, null, null, (int)0, null, (Function1)exec.valueNames.1.INSTANCE, (int)30, null);
                    var5_6 = ((String[])var1_1).length == 0 ? 1 : 0;
                    if (var5_6 != 0) {
                        var1_1 = this.values.size() == 1 ? new StringBuilder().append((String)var4_5).append(" <value>") : new StringBuilder().append('<').append((String)var4_5).append('>');
                        this.chatSyntax(var1_1.toString());
                        return;
                    }
                    var2_2 = this.module.getValue(var1_1[0]);
                    if (var2_2 == null) {
                        this.chatSyntax('<' + (String)var4_5 + '>');
                        return;
                    }
                    var5_6 = ((String[])var1_1).length;
                    var6_7 = " <";
                    var4_5 = "this as java.lang.String).toLowerCase(Locale.ROOT)";
                    if (var5_6 < 2) {
                        if (!(var2_2 instanceof IntValue || var2_2 instanceof FloatValue || var2_2 instanceof StringValue || var2_2 instanceof BoolValue)) {
                            if (var2_2 instanceof ListValue) {
                                var7_8 = new StringBuilder();
                                var1_1 = var1_1[0].toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue((Object)var1_1, (String)var4_5);
                                var1_1 = var7_8.append((String)var1_1).append((String)var6_7);
                                var3_4 = ArraysKt.joinToString$default((Object[])((ListValue)var2_2).getValues(), (CharSequence)var3_4, null, null, (int)0, null, null, (int)62, null).toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue((Object)var3_4, (String)var4_5);
                                this.chatSyntax(var1_1.append((String)var3_4).append("> (now=").append((String)((ListValue)var2_2).get()).append(')').toString());
                            }
                        } else {
                            var3_4 = new StringBuilder();
                            var1_1 = var1_1[0].toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue((Object)var1_1, (String)var4_5);
                            this.chatSyntax(var3_4.append((String)var1_1).append(" <value> (now=").append(var2_2.get()).append(')').toString());
                        }
                        return;
                    }
                    if (!(var2_2 instanceof IntValue)) break block24;
                    ((IntValue)var2_2).set(Integer.parseInt((String)var1_1[1]));
                    ** GOTO lbl95
                }
                if (!(var2_2 instanceof FloatValue)) break block25;
                ((FloatValue)var2_2).set(Float.valueOf(Float.parseFloat((String)var1_1[1])));
                ** GOTO lbl95
            }
            if (!(var2_2 instanceof BoolValue)) ** GOTO lbl81
            var3_4 = var1_1[1].toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)var3_4, (String)var4_5);
            switch (var3_4.hashCode()) lbl-1000:
            // 7 sources

            {
                default: {
                    ** GOTO lbl76
                }
                case 1099846370: {
                    if (var3_4.equals("reverse")) break block26;
                    ** GOTO lbl-1000
                }
                case 97196323: {
                    if (var3_4.equals("false")) ** GOTO lbl62
                    ** GOTO lbl-1000
                }
                case 3569038: {
                    if (var3_4.equals("true")) ** GOTO lbl66
                    ** GOTO lbl-1000
                }
                case 112803: {
                    if (var3_4.equals("rev")) break block26;
                    ** GOTO lbl-1000
                }
                case 109935: {
                    if (!var3_4.equals("off")) ** GOTO lbl-1000
lbl62:
                    // 2 sources

                    ((BoolValue)var2_2).set(false);
                    ** GOTO lbl95
                }
                case 3551: {
                    if (!var3_4.equals("on")) ** GOTO lbl-1000
lbl66:
                    // 2 sources

                    ((BoolValue)var2_2).set(true);
                    ** GOTO lbl95
                }
                case 33: 
            }
            if (!var3_4.equals("!")) ** GOTO lbl76
        }
        var4_5 = (BoolValue)var2_2;
        var8_10 = (Boolean)((BoolValue)var2_2).get() == false;
        var4_5.set(var8_10);
        ** GOTO lbl95
lbl76:
        // 2 sources

        var4_5 = (BoolValue)var2_2;
        var8_11 = (Boolean)((BoolValue)var2_2).get() == false;
        try {
            block27: {
                var4_5.set(var8_11);
                break block27;
lbl81:
                // 1 sources

                if (var2_2 instanceof ListValue) {
                    if (!((ListValue)var2_2).contains((String)var1_1[1])) {
                        var9_12 = new StringBuilder();
                        var7_9 = var1_1[0].toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)var7_9, (String)var4_5);
                        var6_7 = var9_12.append(var7_9).append((String)var6_7);
                        var2_2 = ArraysKt.joinToString$default((Object[])((ListValue)var2_2).getValues(), (CharSequence)var3_4, null, null, (int)0, null, null, (int)62, null).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)var2_2, (String)var4_5);
                        this.chatSyntax(var6_7.append((String)var2_2).append('>').toString());
                        return;
                    }
                    ((ListValue)var2_2).set(var1_1[1]);
                } else if (var2_2 instanceof StringValue) {
                    ((StringValue)var2_2).set(ArraysKt.joinToString$default((Object[])ArraysKt.copyOfRange((Object[])var1_1, (int)2, (int)(((Object)var1_1).length - 1)), (CharSequence)" ", null, null, (int)0, null, null, (int)62, null));
                }
            }
            var4_5 = new StringBuilder();
            this.chat(var4_5.append(this.module.getName()).append(' ').append((String)var1_1[0]).append(" was set to ").append(var2_2.get()).append('.').toString());
        }
        catch (NumberFormatException var2_3) {
            this.chat((String)var1_1[1] + " cannot be converted to number!");
        }
    }
}

