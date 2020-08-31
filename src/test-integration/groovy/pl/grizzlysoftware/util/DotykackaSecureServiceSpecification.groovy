package pl.grizzlysoftware.util

import okhttp3.OkHttpClient
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthApiToken
import pl.grizzlysoftware.dotykacka.client.v1.api.service.OAuthService
import pl.grizzlysoftware.dotykacka.client.v1.facade.OAuthServiceFacade
import pl.grizzlysoftware.dotykacka.model.Credentials
import pl.grizzlysoftware.dotykacka.util.AccessTokenProvider
import pl.grizzlysoftware.dotykacka.util.ApiTokenProvider
import pl.grizzlysoftware.dotykacka.util.DotykackaOAuthAccessTokenExtractor
import pl.grizzlysoftware.dotykacka.util.OkHttpAccessTokenAuthenticator
import spock.lang.Specification

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.OAUTH
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.OkHttpClientUtils.builder
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
abstract class DotykackaSecureServiceSpecification extends Specification {
    def oauthService
    def apiTokenProvider
    def accessTokenProvider

    void setup() {
        def oAuthHttpClient = builder()
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build()
        oauthService = new OAuthServiceFacade(service(oAuthHttpClient, API_URL + OAUTH, OAuthService.class))
        apiTokenProvider = new ApiTokenProvider(oauthService, new OAuthApiToken(ACCESS_TOKEN_API_TOKEN))
        accessTokenProvider = new AccessTokenProvider(oauthService, apiTokenProvider, new Credentials(ACCESS_TOKEN_USERNAME, ACCESS_TOKEN_PASSWORD), ACCESS_TOKEN_API_TOKEN)
    }

    OkHttpClient httpClient() {
        def authenticator = new OkHttpAccessTokenAuthenticator(accessTokenProvider, new DotykackaOAuthAccessTokenExtractor());
        def httpClient = builder()
                .addInterceptor(authenticator)
                .authenticator(authenticator)
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build()
        return httpClient
    }
}
