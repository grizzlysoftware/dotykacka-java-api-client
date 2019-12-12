/*
 * Copyright 2019 Grizzly Software, https://grizzlysoftware.pl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package pl.grizzlysoftware.dotykacka.client.v1.facade

import okhttp3.OkHttpClient
import pl.grizzlysoftware.dotykacka.client.v1.api.service.OAuthService
import pl.grizzlysoftware.util.OkHttpLoggingInterceptor
import spock.lang.Specification

import static java.lang.System.currentTimeMillis
import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.OAUTH
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.OkHttpClientUtils.builder
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class OAuthServiceFacadeTest extends Specification {
    OkHttpClient httpClient = builder().addInterceptor(new OkHttpLoggingInterceptor()).build()

    def "returns valid access token"() {
        given:
            def facade = new OAuthServiceFacade(service(httpClient, API_URL + OAUTH, OAuthService.class))
        when:
            def token = facade.accessToken(ACCESS_TOKEN_USERNAME, ACCESS_TOKEN_PASSWORD, ACCESS_TOKEN_API_TOKEN)
        then:
            token != null
            token.expiresInSeconds > 0
            token.tokenType == "bearer"
            token.receivedAt > 0
            token.receivedAt < currentTimeMillis()
    }

    def "returns valid api token"() {
        given:
            def facade = new OAuthServiceFacade(service(httpClient, API_URL + OAUTH, OAuthService.class))
        when:
            println API_TOKEN_USERNAME
            def token = facade.apiToken(API_TOKEN_USERNAME, API_TOKEN_PASSWORD)
        then:
            token != null
            token.token != null
            token.token.startsWith("\$") == true
    }
}
