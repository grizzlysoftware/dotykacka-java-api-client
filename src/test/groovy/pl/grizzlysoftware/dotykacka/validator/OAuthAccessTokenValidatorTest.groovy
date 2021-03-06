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

package pl.grizzlysoftware.dotykacka.validator

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthAccessToken
import spock.lang.Specification
import spock.lang.Unroll

import static java.lang.System.currentTimeMillis

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class OAuthAccessTokenValidatorTest extends Specification {

    def "validation fails when given input is null"() {
        given:
            def v = new OAuthAccessTokenValidator()
        when:
            def result = v.isValid(null)
        then:
            result == false
    }

    @Unroll
    def "validates token"(token, expiresIn, receivedAt, expectedResult) {
        given:
            def v = new OAuthAccessTokenValidator()
            def tkn = new OAuthAccessToken(token, null, expiresIn, null, receivedAt)
        when:
            def result = v.isValid(tkn)
        then:
            result == expectedResult
        where:
            token        | expiresIn | receivedAt                    | expectedResult
            null         | 3500      | currentTimeMillis()           | false
            "fake token" | -50       | currentTimeMillis()           | false
            "fake token" | 300       | currentTimeMillis() - 900_000 | false
            "fake token" | 3000      | currentTimeMillis()           | true

    }
}
