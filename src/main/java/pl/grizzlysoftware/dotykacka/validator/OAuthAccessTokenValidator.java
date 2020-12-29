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

package pl.grizzlysoftware.dotykacka.validator;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.oauth.OAuthAccessToken;

//TODO this should be refactored a bit
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OAuthAccessTokenValidator {

    protected long tolerance;

    public OAuthAccessTokenValidator(long tolerance) {
        this.tolerance = tolerance;
    }

    public OAuthAccessTokenValidator() {
        this(0L);
    }

    public boolean isValid(OAuthAccessToken token) {
        if (token == null) {
            return false;
        }

        if (isEmpty(token.token)) {
            return false;
        }

        return token.receivedAt + token.expiresInSeconds * 1000 > System.currentTimeMillis() + tolerance;
    }
}
