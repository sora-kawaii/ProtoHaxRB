/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.MapsKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.utils;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bJ@\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\r\u001a\u00020\u0004J,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bJ@\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/sora/relay/utils/HttpUtils;", "", "()V", "DEFAULT_AGENT", "", "get", "url", "header", "", "make", "Ljava/net/HttpURLConnection;", "method", "data", "agent", "post", "request", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class HttpUtils {
    private static final String DEFAULT_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    public static final HttpUtils INSTANCE = new HttpUtils();

    private HttpUtils() {
    }

    public static /* synthetic */ String get$default(HttpUtils httpUtils, String string2, Map map, int n, Object object) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return httpUtils.get(string2, map);
    }

    public static /* synthetic */ HttpURLConnection make$default(HttpUtils httpUtils, String string2, String string3, String string4, Map map, String string5, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = "";
        }
        if ((n & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n & 0x10) != 0) {
            string5 = DEFAULT_AGENT;
        }
        return httpUtils.make(string2, string3, string4, map, string5);
    }

    public static /* synthetic */ String post$default(HttpUtils httpUtils, String string2, String string3, Map map, int n, Object object) {
        if ((n & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return httpUtils.post(string2, string3, map);
    }

    public static /* synthetic */ String request$default(HttpUtils httpUtils, String string2, String string3, String string4, Map map, String string5, int n, Object object) {
        if ((n & 4) != 0) {
            string4 = "";
        }
        if ((n & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((n & 0x10) != 0) {
            string5 = DEFAULT_AGENT;
        }
        return httpUtils.request(string2, string3, string4, map, string5);
    }

    public final String get(String string2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"url");
        Intrinsics.checkNotNullParameter(map, (String)"header");
        return HttpUtils.request$default(this, string2, "GET", null, map, null, 20, null);
    }

    /*
     * WARNING - void declaration
     */
    public final HttpURLConnection make(String object, String object2, String string2, Map<String, String> object32, String string3) {
        void var5_7;
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"method");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)object32, (String)"header");
        Intrinsics.checkNotNullParameter((Object)var5_7, (String)"agent");
        object = new URL((String)object).openConnection();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.net.HttpURLConnection");
        object = (HttpURLConnection)object;
        ((HttpURLConnection)object).setRequestMethod((String)object2);
        ((URLConnection)object).setConnectTimeout(2000);
        ((URLConnection)object).setReadTimeout(10000);
        ((URLConnection)object).setRequestProperty("User-Agent", (String)var5_7);
        for (Map.Entry entry : object32.entrySet()) {
            ((URLConnection)object).setRequestProperty((String)entry.getKey(), (String)entry.getValue());
        }
        boolean bl = true;
        ((HttpURLConnection)object).setInstanceFollowRedirects(true);
        ((URLConnection)object).setDoOutput(true);
        if (((CharSequence)string2).length() <= 0) {
            bl = false;
        }
        if (bl) {
            object2 = new DataOutputStream(((URLConnection)object).getOutputStream());
            ((DataOutputStream)object2).writeBytes(string2);
            ((DataOutputStream)object2).flush();
        }
        ((URLConnection)object).connect();
        return object;
    }

    public final String post(String string2, String string3, Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"data");
        Intrinsics.checkNotNullParameter(map, (String)"header");
        return HttpUtils.request$default(this, string2, "POST", string3, map, null, 16, null);
    }

    public final String request(String object, String string2, String string3, Map<String, String> map, String string4) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"method");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"data");
        Intrinsics.checkNotNullParameter(map, (String)"header");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"agent");
        object = this.make((String)object, string2, string3, map, string4).getInputStream();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"connection.inputStream");
        return TextStreamsKt.readText((Reader)new InputStreamReader((InputStream)object, Charsets.UTF_8));
    }
}

