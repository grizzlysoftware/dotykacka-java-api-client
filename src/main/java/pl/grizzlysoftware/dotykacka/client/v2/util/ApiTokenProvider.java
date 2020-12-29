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

package pl.grizzlysoftware.dotykacka.client.v2.util;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.oauth.OAuthApiToken;
import pl.grizzlysoftware.dotykacka.client.v2.facade.OAuthServiceFacade;
import pl.grizzlysoftware.dotykacka.model.Credentials;
import pl.grizzlysoftware.util.TokenProvider;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ApiTokenProvider implements TokenProvider<OAuthApiToken> {
    protected final OAuthServiceFacade oauthService;
    protected Credentials credentials;
    protected OAuthApiToken apiToken;

    public ApiTokenProvider(OAuthServiceFacade oauthService, Credentials credentials) {
        this.oauthService = requireNonNull(oauthService);
        this.credentials = requireNonNull(credentials);
    }

    public ApiTokenProvider(OAuthServiceFacade oauthService, OAuthApiToken apiToken) {
        this.oauthService = requireNonNull(oauthService);
        this.apiToken = requireNonNull(apiToken);
    }

    void setApiToken(String token) {
        if (token == null) {
            this.apiToken = null;
        } else {
            this.apiToken = new OAuthApiToken(token);
        }
    }

    @Override
    public OAuthApiToken acquireToken() {
        if (apiToken == null || apiToken.token == null) {
            apiToken = oauthService.apiToken(credentials.username,
                    credentials.password);
        }

        return apiToken;
    }
}
