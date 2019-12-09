package pl.grizzlysoftware.util

import okhttp3.OkHttpClient
import pl.grizzlysoftware.dotykacka.api.client.v1.service.OAuthService
import pl.grizzlysoftware.dotykacka.api.v1.dto.oauth.OAuthApiToken
import pl.grizzlysoftware.dotykacka.facade.v1.OAuthServiceFacade
import pl.grizzlysoftware.dotykacka.model.Credentials
import pl.grizzlysoftware.dotykacka.util.AccessTokenProvider
import pl.grizzlysoftware.dotykacka.util.ApiTokenProvider
import pl.grizzlysoftware.dotykacka.util.OAuthRequestInterceptor
import spock.lang.Specification

import static pl.grizzlysoftware.dotykacka.util.DotykackaServiceContextPath.OAUTH
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
        def httpClient = builder()
                .addInterceptor(new OkHttpLoggingInterceptor())
                .addInterceptor(new OAuthRequestInterceptor(accessTokenProvider))
                .build()
        return httpClient
    }
}
