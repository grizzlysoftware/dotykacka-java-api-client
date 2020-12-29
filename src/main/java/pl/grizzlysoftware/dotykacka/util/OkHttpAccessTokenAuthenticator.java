package pl.grizzlysoftware.dotykacka.util;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import pl.grizzlysoftware.util.TokenProvider;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class OkHttpAccessTokenAuthenticator implements Authenticator, Interceptor {

    protected TokenProvider tokenProvider;
    protected AccessTokenExtractor accessTokenExtractor;

    public OkHttpAccessTokenAuthenticator(TokenProvider tokenProvider, AccessTokenExtractor accessTokenExtractor) {
        this.tokenProvider = requireNonNull(tokenProvider);
        this.accessTokenExtractor = requireNonNull(accessTokenExtractor);
    }

    @Override
    public Request authenticate(Route route, Response response) {
        var accessToken = accessTokenExtractor.apply(tokenProvider.acquireToken());
        return response
                .request()
                .newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        var accessToken = accessTokenExtractor.apply(tokenProvider.acquireToken());
        var request = chain
                .request()
                .newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
        return chain.proceed(request);
    }
}
