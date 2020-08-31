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

package pl.grizzlysoftware.dotykacka.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthAccessToken;
import pl.grizzlysoftware.dotykacka.client.v1.facade.OAuthServiceFacade;
import pl.grizzlysoftware.dotykacka.model.Credentials;
import pl.grizzlysoftware.dotykacka.validator.OAuthAccessTokenValidator;
import pl.grizzlysoftware.util.TokenProvider;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class AccessTokenProvider implements TokenProvider<OAuthAccessToken> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenProvider.class);

    protected final OAuthServiceFacade oauthService;
    protected OAuthAccessToken accessToken;
    protected OAuthAccessTokenValidator validator;
    protected Credentials credentials;
    protected ApiTokenProvider apiTokenProvider;

    public AccessTokenProvider(OAuthServiceFacade oauthService, ApiTokenProvider apiTokenProvider, Credentials credentials, String apiToken) {
        this.oauthService = requireNonNull(oauthService);
        this.apiTokenProvider = requireNonNull(apiTokenProvider);
        this.apiTokenProvider.setApiToken(apiToken);
        this.credentials = requireNonNull(credentials);
        this.validator = new OAuthAccessTokenValidator();
    }

    public AccessTokenProvider(OAuthServiceFacade oauthService, ApiTokenProvider apiTokenProvider, Credentials credentials, String apiToken, Long oAuthAccessTokenValidationTolerance) {
        this.oauthService = requireNonNull(oauthService);
        this.apiTokenProvider = requireNonNull(apiTokenProvider);
        this.apiTokenProvider.setApiToken(apiToken);
        this.credentials = requireNonNull(credentials);
        this.validator = new OAuthAccessTokenValidator(oAuthAccessTokenValidationTolerance);
    }

    public AccessTokenProvider(OAuthServiceFacade oauthService, ApiTokenProvider apiTokenProvider, OAuthAccessTokenValidator validator, Credentials credentials, String apiToken) {
        this.oauthService = requireNonNull(oauthService);
        this.apiTokenProvider = requireNonNull(apiTokenProvider);
        this.apiTokenProvider.setApiToken(apiToken);
        this.credentials = requireNonNull(credentials);
        this.validator = requireNonNull(validator);
    }

    @Override
    public OAuthAccessToken acquireToken() {
        var apiToken = apiTokenProvider.acquireToken();

        if (accessToken == null || !validator.isValid(accessToken)) {
            LOGGER.info("Access token invalid or expired, requesting new one");
            accessToken = oauthService.accessToken(credentials.username,
                    credentials.password, apiToken.token);
        }
        return accessToken;
    }
}
