/*
 * Decompiled with CFR 0.152.
 */
package dev.sora.relay;

import dev.sora.relay.RakNetRelay;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import java.nio.channels.DatagramChannel;

public final class RakNetRelay$$ExternalSyntheticLambda0
implements ChannelFactory {
    public final /* synthetic */ DatagramChannel f$0;

    public /* synthetic */ RakNetRelay$$ExternalSyntheticLambda0(DatagramChannel datagramChannel) {
        this.f$0 = datagramChannel;
    }

    @Override
    public final Channel newChannel() {
        return RakNetRelay.$r8$lambda$3gLRCtF7_GCur0Tg-CW3ESRPfD8(this.f$0);
    }
}

