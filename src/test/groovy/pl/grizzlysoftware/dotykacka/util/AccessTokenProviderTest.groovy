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

package pl.grizzlysoftware.dotykacka.util

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthAccessToken
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthApiToken
import pl.grizzlysoftware.dotykacka.client.v1.facade.OAuthServiceFacade
import pl.grizzlysoftware.dotykacka.model.Credentials
import spock.lang.Specification
import spock.lang.Unroll

import static java.lang.System.currentTimeMillis
import static java.util.UUID.randomUUID

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class AccessTokenProviderTest extends Specification {
    @Unroll
    def "throws NullPointerException when given args are null"(oauthService, apiTokenProvider, credentials, apiToken) {
        when:
            new AccessTokenProvider(oauthService, apiTokenProvider, credentials, apiToken)
        then:
            thrown(NullPointerException)
        where:
            oauthService             | apiTokenProvider       | credentials       | apiToken
            null                     | Mock(ApiTokenProvider) | Mock(Credentials) | ""
            Mock(OAuthServiceFacade) | null | Mock(Credentials) | ""
            Mock(OAuthServiceFacade) | Mock(ApiTokenProvider) | null              | ""
    }

    @Unroll
    def "initializes properly"(oauthService, apiTokenProvider, credentials, apiToken) {
        when:
            def provider = new AccessTokenProvider(oauthService, apiTokenProvider, credentials, apiToken)
        then:
            provider != null
        where:
            oauthService             | apiTokenProvider       | credentials       | apiToken
            Mock(OAuthServiceFacade) | Mock(ApiTokenProvider) | Mock(Credentials) | ""
            Mock(OAuthServiceFacade) | Mock(ApiTokenProvider) | Mock(Credentials) | null
    }
    def "initializes properly when apiToken is null"() {
        when:
            def provider = new AccessTokenProvider(Mock(OAuthServiceFacade), Mock(ApiTokenProvider), Mock(Credentials), null)
        then:
            provider != null
    }

    @Unroll
    def "returns access token"() {
        given:
            def oauthService = Mock(OAuthServiceFacade)
            def credentials = Mock(Credentials)
            def apiTokenProvider = Mock(ApiTokenProvider)
            apiTokenProvider.acquireToken() >> new OAuthApiToken(randomUUID().toString())
            oauthService.accessToken(_, _, _) >> new OAuthAccessToken(randomUUID().toString(), 3600, currentTimeMillis())
            def provider = new AccessTokenProvider(oauthService, apiTokenProvider, credentials, "test-api-token")
        when:
            provider.accessToken == null
            def accessToken = provider.acquireToken()
        then:
            accessToken != null
            accessToken.token != null
    }

    @Unroll
    def "returns same access token if it's still valid"() {
        given:
            def oauthService = Mock(OAuthServiceFacade)
            def credentials = Mock(Credentials)
            def apiTokenProvider = Mock(ApiTokenProvider)
            apiTokenProvider.acquireToken() >> new OAuthApiToken(randomUUID().toString())
            oauthService.accessToken(_, _, _) >> new OAuthAccessToken(randomUUID().toString(), 3600, currentTimeMillis())
            def provider = new AccessTokenProvider(oauthService, apiTokenProvider, credentials, "test-api-token")
        when:
            def accessToken0 = provider.acquireToken()
            def accessToken1 = provider.acquireToken()
        then:
            accessToken0 != null
            accessToken1 != null
            accessToken0 == accessToken1
    }

    @Unroll
    def "returns refreshed access token"() {
        given:
            def oauthService = Mock(OAuthServiceFacade)
            def credentials = Mock(Credentials)
            def apiTokenProvider = Mock(ApiTokenProvider)
            apiTokenProvider.acquireToken() >> new OAuthApiToken(randomUUID().toString())
            oauthService.accessToken(_, _, _) >>> [
                    new OAuthAccessToken(randomUUID().toString(), -10, currentTimeMillis()),   //expired token
                    new OAuthAccessToken(randomUUID().toString(), 3600, currentTimeMillis())]
            def provider = new AccessTokenProvider(oauthService, apiTokenProvider, credentials, "test-api-token")
        when:
            def accessToken0 = provider.acquireToken()
            def accessToken1 = provider.acquireToken()
        then:
            accessToken0 != null
            accessToken1 != null
            accessToken0 != accessToken1
    }
}
