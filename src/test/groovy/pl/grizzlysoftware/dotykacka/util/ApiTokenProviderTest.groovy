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

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthApiToken
import pl.grizzlysoftware.dotykacka.client.v1.facade.OAuthServiceFacade
import pl.grizzlysoftware.dotykacka.client.v2.util.ApiTokenProvider
import pl.grizzlysoftware.dotykacka.model.Credentials
import spock.lang.Specification
import spock.lang.Unroll

import static java.util.UUID.randomUUID

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class ApiTokenProviderTest extends Specification {

    @Unroll
    def "throws NullPointerException when given args are null #1"(oauthService, Credentials credentials) {
        when:
            new ApiTokenProvider(oauthService, (Credentials) credentials)
        then:
            thrown(NullPointerException)
        where:
            oauthService             | credentials
            null                     | null
            Mock(OAuthServiceFacade) | null
            null                     | Mock(Credentials)
    }

    @Unroll
    def "throws NullPointerException when given args are null #2"(oauthService, OAuthApiToken apiToken) {
        when:
            new ApiTokenProvider(oauthService, (OAuthApiToken) apiToken)
        then:
            thrown(NullPointerException)
        where:
            oauthService             | apiToken
            null                     | null
            Mock(OAuthServiceFacade) | null
            null                     | Mock(OAuthApiToken)
    }

    @Unroll
    def "returns api token"() {
        given:
            def oauthService = Mock(OAuthServiceFacade)
            oauthService.apiToken(_ as String, _ as String) >> new OAuthApiToken(randomUUID().toString())
            def provider = new ApiTokenProvider(oauthService, new Credentials("test", "test"))
        when:
            def accessToken = provider.acquireToken()
        then:
            accessToken != null
            accessToken.token != null
    }

    @Unroll
    def "returns same api token if its set"() {
        given:
            def oauthService = Mock(OAuthServiceFacade)
            oauthService.apiToken(_ as String, _ as String) >>> [new OAuthApiToken(randomUUID().toString()), new OAuthApiToken(randomUUID().toString())]
            def provider = new ApiTokenProvider(oauthService, new Credentials("test", "test"))
        when:
            def accessToken0 = provider.acquireToken()
            def accessToken1 = provider.acquireToken()
        then:
            accessToken0 != null
            accessToken1 != null
            accessToken0 == accessToken1
    }
}
