/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.MapsKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dev.sora.relay.session;

import coelho.msftauth.api.xbox.XboxDevice;
import coelho.msftauth.api.xbox.XboxDeviceAuthRequest;
import coelho.msftauth.api.xbox.XboxDeviceKey;
import coelho.msftauth.api.xbox.XboxDeviceToken;
import coelho.msftauth.api.xbox.XboxSISUAuthenticate;
import coelho.msftauth.api.xbox.XboxSISUAuthenticateRequest;
import coelho.msftauth.api.xbox.XboxSISUAuthorize;
import coelho.msftauth.api.xbox.XboxSISUAuthorizeRequest;
import coelho.msftauth.api.xbox.XboxTitleAuthRequest;
import coelho.msftauth.api.xbox.XboxToken;
import coelho.msftauth.api.xbox.XboxUserAuthRequest;
import coelho.msftauth.api.xbox.XboxXSTSAuthRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.ClientToServerHandshakePacket;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.ServerToClientHandshakePacket;
import com.nukkitx.protocol.bedrock.util.EncryptionUtils;
import dev.sora.relay.RakNetRelaySession;
import dev.sora.relay.RakNetRelaySessionListener;
import dev.sora.relay.utils.CipherPair;
import dev.sora.relay.utils.HttpUtils;
import dev.sora.relay.utils.JoseStuff;
import dev.sora.relay.utils.LoggerKt;
import dev.sora.relay.utils.StringUtilsKt;
import io.netty.util.AsciiString;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0002+,B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft;", "Ldev/sora/relay/RakNetRelaySessionListener$PacketListener;", "accessToken", "", "deviceInfo", "Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;", "session", "Ldev/sora/relay/RakNetRelaySession;", "(Ljava/lang/String;Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;Ldev/sora/relay/RakNetRelaySession;)V", "(Ljava/lang/String;Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;)V", "getAccessToken", "()Ljava/lang/String;", "chain", "Lio/netty/util/AsciiString;", "getChain", "()Lio/netty/util/AsciiString;", "chainExpires", "", "getDeviceInfo", "()Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;", "identityToken", "keyPair", "Ljava/security/KeyPair;", "kotlin.jvm.PlatformType", "getSession", "()Ldev/sora/relay/RakNetRelaySession;", "setSession", "(Ldev/sora/relay/RakNetRelaySession;)V", "fetchChain", "Ljava/io/InputStreamReader;", "fetchIdentityToken", "forceFetchChain", "", "onPacketInbound", "", "packet", "Lcom/nukkitx/protocol/bedrock/BedrockPacket;", "onPacketOutbound", "signBytes", "dataToSign", "", "toJWTRaw", "payload", "Companion", "DeviceInfo", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class RakNetRelaySessionListenerMicrosoft
implements RakNetRelaySessionListener.PacketListener {
    public static final Companion Companion = new Companion(null);
    private static final DeviceInfo DEVICE_ANDROID = new DeviceInfo("0000000048183522", "Android", false);
    private static final DeviceInfo DEVICE_NINTENDO = new DeviceInfo("00000000441cc96b", "Nintendo", true);
    private final String accessToken;
    private AsciiString chain;
    private long chainExpires;
    private final DeviceInfo deviceInfo;
    private String identityToken;
    private final KeyPair keyPair;
    public RakNetRelaySession session;

    public RakNetRelaySessionListenerMicrosoft(String string2, DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"accessToken");
        Intrinsics.checkNotNullParameter((Object)deviceInfo, (String)"deviceInfo");
        this.accessToken = string2;
        this.deviceInfo = deviceInfo;
        this.keyPair = EncryptionUtils.createKeyPair();
    }

    public RakNetRelaySessionListenerMicrosoft(String string2, DeviceInfo deviceInfo, RakNetRelaySession rakNetRelaySession) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"accessToken");
        Intrinsics.checkNotNullParameter((Object)deviceInfo, (String)"deviceInfo");
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"session");
        this(string2, deviceInfo);
        this.setSession(rakNetRelaySession);
    }

    private final InputStreamReader fetchChain(String object) {
        Object object2 = this.fetchIdentityToken((String)object);
        Object object3 = new JSONObject();
        object = Base64.getEncoder().encodeToString(this.keyPair.getPublic().getEncoded());
        ((HashMap)object3).put("identityPublicKey", object);
        object = HttpUtils.INSTANCE;
        object3 = ((JSONObject)object3).toJSONString();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"data.toJSONString()");
        Pair<String, String> pair = TuplesKt.to("Content-Type", "application/json");
        Pair<String, String> pair2 = TuplesKt.to("Authorization", object2);
        object2 = TuplesKt.to("User-Agent", "MCPE/UWP");
        object2 = MapsKt.mapOf((Pair[])new Pair[]{pair, pair2, object2, TuplesKt.to("Client-Version", "1.19.50")});
        object = HttpUtils.make$default((HttpUtils)object, "https://multiplayer.minecraft.net/authentication", "POST", (String)object3, (Map)object2, null, 16, null).getInputStream();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"connection.inputStream");
        object = TextStreamsKt.readText((Reader)new InputStreamReader((InputStream)object, Charsets.UTF_8));
        System.out.println(object);
        object = ((String)object).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).getBytes(charset)");
        return new InputStreamReader((InputStream)new ByteArrayInputStream((byte[])object), Charsets.UTF_8);
    }

    private final String fetchIdentityToken(String object) {
        if (this.identityToken == null) {
            Object object2 = new XboxDeviceKey();
            Object object3 = new StringBuilder();
            String string2 = "t=";
            object3 = ((StringBuilder)object3).append(string2).append((String)object).toString();
            Object object4 = (XboxToken)new XboxUserAuthRequest("http://auth.xboxlive.com", "JWT", "RPS", "user.auth.xboxlive.com", (String)object3).request();
            object3 = this.deviceInfo.getDeviceType();
            object3 = (XboxDeviceToken)new XboxDeviceAuthRequest("http://auth.xboxlive.com", "JWT", (String)object3, "0.0.0.0", (XboxDeviceKey)object2).request();
            if (this.deviceInfo.getAllowDirectTitleTokenFetch()) {
                object = string2 + (String)object;
                string2 = ((XboxToken)object3).getToken();
                object = (XboxToken)new XboxTitleAuthRequest("http://auth.xboxlive.com", "JWT", "RPS", "user.auth.xboxlive.com", (String)object, string2, (XboxDeviceKey)object2).request();
            } else {
                XboxDevice xboxDevice = new XboxDevice((XboxDeviceKey)object2, (XboxDeviceToken)object3);
                String string3 = this.deviceInfo.getAppId();
                Object object5 = new XboxSISUAuthenticateRequest.Query("phone");
                String string4 = "ms-xal-" + this.deviceInfo.getAppId() + "://auth";
                object5 = (XboxSISUAuthenticate)new XboxSISUAuthenticateRequest(string3, xboxDevice, "service::user.auth.xboxlive.com::MBI_SSL", (XboxSISUAuthenticateRequest.Query)object5, string4, "RETAIL").request();
                string2 = string2 + (String)object;
                object = this.deviceInfo.getAppId();
                object5 = ((XboxSISUAuthenticate)object5).getSessionId();
                object = (XboxSISUAuthorize)new XboxSISUAuthorizeRequest(string2, (String)object, xboxDevice, "RETAIL", (String)object5, "user.auth.xboxlive.com", "http://xboxlive.com").request();
                object = ((XboxSISUAuthorize)object).getTitleToken();
            }
            object4 = CollectionsKt.listOf((Object)object4);
            object2 = new XboxDevice((XboxDeviceKey)object2, (XboxDeviceToken)object3);
            object = (XboxToken)new XboxXSTSAuthRequest("https://multiplayer.minecraft.net/", "JWT", "RETAIL", (List<XboxToken>)object4, (XboxToken)object, (XboxDevice)object2).request();
            this.identityToken = ((XboxToken)object).toIdentityToken();
        }
        object = this.identityToken;
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    private final AsciiString getChain() {
        if (this.chain == null || this.chainExpires < Instant.now().getEpochSecond()) {
            String string2 = this.getChain(this.accessToken);
            Object object = JsonParser.parseString(string2).getAsJsonObject().getAsJsonArray("chain").get(0).getAsString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"parseString(it).asJsonOb\u2026(\"chain\").get(0).asString");
            object = JsonParser.parseReader(new InputStreamReader((InputStream)new ByteArrayInputStream(StringUtilsKt.base64Decode((String)StringsKt.split$default((CharSequence)((CharSequence)object), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(1))), Charsets.UTF_8)).getAsJsonObject();
            this.chainExpires = ((JsonObject)object).get("exp").getAsLong();
            this.chain = new AsciiString(string2);
        }
        return this.chain;
    }

    private final String getChain(String object) {
        object = JsonParser.parseReader(this.fetchChain((String)object)).getAsJsonObject();
        String string2 = "chain";
        Object object2 = ((JsonObject)object).get(string2).getAsJsonArray();
        Object object3 = ((JsonArray)object2).get(0).getAsString();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"chains.get(0).asString");
        Object object4 = JsonParser.parseString(new String(StringUtilsKt.base64Decode((String)StringsKt.split$default((CharSequence)((CharSequence)object3), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(0)), Charsets.UTF_8)).getAsJsonObject();
        object3 = Base64.getEncoder();
        Object object5 = new JSONObject();
        ((HashMap)object5).put("certificateAuthority", true);
        int n = (int)(Instant.now().getEpochSecond() + TimeUnit.HOURS.toSeconds(6L));
        ((HashMap)object5).put("exp", n);
        n = (int)(Instant.now().getEpochSecond() - TimeUnit.HOURS.toSeconds(6L));
        ((HashMap)object5).put("nbf", n);
        object4 = ((JsonObject)object4).get("x5u").getAsString();
        ((HashMap)object5).put("identityPublicKey", object4);
        object4 = Unit.INSTANCE;
        object5 = ((JSONObject)object5).toJSONString();
        Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"JSONObject().apply {\n   \u2026\n        }.toJSONString()");
        object5 = ((String)object5).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"this as java.lang.String).getBytes(charset)");
        object5 = ((Base64.Encoder)object3).encodeToString((byte[])object5);
        Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"getEncoder().encodeToStr\u2026yteArray(Charsets.UTF_8))");
        object3 = this.keyPair;
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"keyPair");
        object5 = this.toJWTRaw((String)object5, (KeyPair)object3);
        object3 = new JsonArray();
        ((JsonArray)object3).add((String)object5);
        ((JsonArray)object3).addAll((JsonArray)object2);
        object2 = Unit.INSTANCE;
        ((JsonObject)object).add(string2, (JsonElement)object3);
        object = new Gson().toJson((JsonElement)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Gson().toJson(rawChain)");
        return object;
    }

    private final String signBytes(byte[] object, KeyPair keyPair) {
        Signature signature = Signature.getInstance("SHA384withECDSA");
        signature.initSign(keyPair.getPrivate());
        signature.update((byte[])object);
        object = JoseStuff.DERToJOSE(signature.sign());
        object = Base64.getUrlEncoder().withoutPadding().encodeToString((byte[])object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getUrlEncoder().withoutP\u2026eToString(signatureBytes)");
        return object;
    }

    private final String toJWTRaw(String string2, KeyPair object) {
        Object object2 = new JSONObject();
        ((HashMap)object2).put("alg", "ES384");
        Object object3 = Base64.getEncoder().encodeToString(((KeyPair)object).getPublic().getEncoded());
        ((HashMap)object2).put("x5u", object3);
        object3 = Base64.getUrlEncoder().withoutPadding();
        object2 = ((JSONObject)object2).toJSONString();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"headerJson.toJSONString()");
        byte[] byArray = ((String)object2).getBytes(Charsets.UTF_8);
        object2 = "this as java.lang.String).getBytes(charset)";
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)object2);
        object3 = ((Base64.Encoder)object3).encodeToString(byArray);
        byArray = ((String)object3 + '.' + string2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)object2);
        object = this.signBytes(byArray, (KeyPair)object);
        return (String)object3 + '.' + string2 + '.' + (String)object;
    }

    public final void forceFetchChain() {
        this.getChain();
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final RakNetRelaySession getSession() {
        RakNetRelaySession rakNetRelaySession = this.session;
        if (rakNetRelaySession != null) {
            return rakNetRelaySession;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"session");
        return null;
    }

    @Override
    public boolean onPacketInbound(BedrockPacket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"packet");
        if (object instanceof ServerToClientHandshakePacket) {
            object = ((ServerToClientHandshakePacket)object).getJwt();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"packet.jwt");
            Object object2 = StringsKt.split$default((CharSequence)((CharSequence)object), (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null);
            object = JsonParser.parseString(new String(StringUtilsKt.base64Decode((String)object2.get(0)), Charsets.UTF_8)).getAsJsonObject();
            object2 = JsonParser.parseString(new String(StringUtilsKt.base64Decode((String)object2.get(1)), Charsets.UTF_8)).getAsJsonObject();
            PublicKey publicKey = EncryptionUtils.generateKey(((JsonObject)object).get("x5u").getAsString());
            object = this.keyPair.getPrivate();
            publicKey = publicKey;
            object2 = ((JsonObject)object2).get("salt").getAsString();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"payloadObject.get(\"salt\").asString");
            object2 = EncryptionUtils.getSecretKey((PrivateKey)object, publicKey, StringUtilsKt.base64Decode((String)object2));
            object = this.getSession();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"key");
            ((RakNetRelaySession)object).setServerCipher(new CipherPair((SecretKey)object2));
            this.getSession().outboundPacket(new ClientToServerHandshakePacket());
            return false;
        }
        return true;
    }

    @Override
    public boolean onPacketOutbound(BedrockPacket bedrockPacket) {
        Intrinsics.checkNotNullParameter((Object)bedrockPacket, (String)"packet");
        if (bedrockPacket instanceof LoginPacket) {
            ((LoginPacket)bedrockPacket).setChainData(new AsciiString(this.getChain()));
            String string2 = ((LoginPacket)bedrockPacket).getSkinData().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"packet.skinData.toString()");
            string2 = (String)StringsKt.split$default((CharSequence)string2, (String[])new String[]{"."}, (boolean)false, (int)0, (int)6, null).get(1);
            bedrockPacket = (LoginPacket)bedrockPacket;
            KeyPair keyPair = this.keyPair;
            Intrinsics.checkNotNullExpressionValue((Object)keyPair, (String)"keyPair");
            ((LoginPacket)bedrockPacket).setSkinData(new AsciiString(this.toJWTRaw(string2, keyPair)));
            LoggerKt.logInfo("login success");
        }
        return true;
    }

    public final void setSession(RakNetRelaySession rakNetRelaySession) {
        Intrinsics.checkNotNullParameter((Object)rakNetRelaySession, (String)"<set-?>");
        this.session = rakNetRelaySession;
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$Companion;", "", "()V", "DEVICE_ANDROID", "Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;", "getDEVICE_ANDROID", "()Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;", "DEVICE_NINTENDO", "getDEVICE_NINTENDO", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceInfo getDEVICE_ANDROID() {
            return DEVICE_ANDROID;
        }

        public final DeviceInfo getDEVICE_NINTENDO() {
            return DEVICE_NINTENDO;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0016"}, d2={"Ldev/sora/relay/session/RakNetRelaySessionListenerMicrosoft$DeviceInfo;", "", "appId", "", "deviceType", "allowDirectTitleTokenFetch", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getAllowDirectTitleTokenFetch", "()Z", "getAppId", "()Ljava/lang/String;", "getDeviceType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class DeviceInfo {
        private final boolean allowDirectTitleTokenFetch;
        private final String appId;
        private final String deviceType;

        public DeviceInfo(String string2, String string3, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"appId");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"deviceType");
            this.appId = string2;
            this.deviceType = string3;
            this.allowDirectTitleTokenFetch = bl;
        }

        public /* synthetic */ DeviceInfo(String string2, String string3, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                bl = false;
            }
            this(string2, string3, bl);
        }

        public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String string2, String string3, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = deviceInfo.appId;
            }
            if ((n & 2) != 0) {
                string3 = deviceInfo.deviceType;
            }
            if ((n & 4) != 0) {
                bl = deviceInfo.allowDirectTitleTokenFetch;
            }
            return deviceInfo.copy(string2, string3, bl);
        }

        public final String component1() {
            return this.appId;
        }

        public final String component2() {
            return this.deviceType;
        }

        public final boolean component3() {
            return this.allowDirectTitleTokenFetch;
        }

        public final DeviceInfo copy(String string2, String string3, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"appId");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"deviceType");
            return new DeviceInfo(string2, string3, bl);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof DeviceInfo)) {
                return false;
            }
            object = (DeviceInfo)object;
            if (!Intrinsics.areEqual((Object)this.appId, (Object)((DeviceInfo)object).appId)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.deviceType, (Object)((DeviceInfo)object).deviceType)) {
                return false;
            }
            return this.allowDirectTitleTokenFetch == ((DeviceInfo)object).allowDirectTitleTokenFetch;
        }

        public final boolean getAllowDirectTitleTokenFetch() {
            return this.allowDirectTitleTokenFetch;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getDeviceType() {
            return this.deviceType;
        }

        public int hashCode() {
            int n;
            int n2 = this.appId.hashCode();
            int n3 = this.deviceType.hashCode();
            int n4 = n = this.allowDirectTitleTokenFetch;
            if (n != 0) {
                n4 = 1;
            }
            return (n2 * 31 + n3) * 31 + n4;
        }

        public String toString() {
            return "DeviceInfo(appId=" + this.appId + ", deviceType=" + this.deviceType + ", allowDirectTitleTokenFetch=" + this.allowDirectTitleTokenFetch + ')';
        }
    }
}

