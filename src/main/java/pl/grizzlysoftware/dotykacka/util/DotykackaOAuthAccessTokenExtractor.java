package pl.grizzlysoftware.dotykacka.util;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.oauth.OAuthAccessToken;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class DotykackaOAuthAccessTokenExtractor implements AccessTokenExtractor<OAuthAccessToken> {
    @Override
    public String apply(OAuthAccessToken oAuthAccessToken) {
        if (oAuthAccessToken == null) {
            return null;
        }
        return oAuthAccessToken.token;
    }
}
