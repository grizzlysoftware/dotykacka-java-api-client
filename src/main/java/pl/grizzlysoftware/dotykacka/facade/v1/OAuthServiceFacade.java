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

package pl.grizzlysoftware.dotykacka.facade.v1;

import pl.grizzlysoftware.dotykacka.api.client.v1.service.OAuthService;
import pl.grizzlysoftware.dotykacka.api.v1.dto.oauth.OAuthAccessToken;
import pl.grizzlysoftware.dotykacka.api.v1.dto.oauth.OAuthApiToken;
import pl.grizzlysoftware.util.RetrofitApiServiceFacade;

import static java.lang.System.currentTimeMillis;
import static java.util.Base64.getEncoder;
import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OAuthServiceFacade extends RetrofitApiServiceFacade {
    private OAuthService service;

    public OAuthServiceFacade(OAuthService service) {
        this.service = requireNonNull(service);
    }

    public OAuthAccessToken accessToken(String username, String password, String apiToken) {
        var token = execute(service.accessToken(apiToken, "", "password", basicEncoded(username, password)));
        token.receivedAt = currentTimeMillis();
        return token;
    }

    public OAuthApiToken apiToken(String username, String password) {
        return execute(service.apiToken(username, password, "touchpo"));
    }

    private String basicEncoded(String username, String password) {
        return "Basic "+ new String(getEncoder().encode(String.format("%s:%s", username, password).getBytes()));
    }
}
