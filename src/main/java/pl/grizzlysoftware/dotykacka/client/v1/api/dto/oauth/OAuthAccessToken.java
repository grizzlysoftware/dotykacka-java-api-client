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

package pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthAccessToken {

    @JsonProperty("access_token")
    public String token;

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public long expiresInSeconds;

    @JsonProperty("scope")
    public String scope;

    /**
     * information about time token was received - used to determine whether token is expired. Might be used as issuedAt but it's not precise
     *
     * IT IS NOT DOTYKACKA API SERVER TIME
     * */
    public long receivedAt;

    public OAuthAccessToken(String token, String tokenType, long expiresIn, String scope, long receivedAt) {
        this.token = token;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresIn;
        this.scope = scope;
        this.receivedAt = receivedAt;
    }

    public OAuthAccessToken(String token, long expiresIn, long receivedAt) {
        this.token = token;
        this.expiresInSeconds = expiresIn;
        this.receivedAt = receivedAt;
    }

    public OAuthAccessToken() {
    }
}