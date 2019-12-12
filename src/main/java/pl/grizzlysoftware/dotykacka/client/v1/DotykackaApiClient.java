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

package pl.grizzlysoftware.dotykacka.client.v1;

import pl.grizzlysoftware.dotykacka.client.v1.api.service.OAuthService;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.ProductService;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.oauth.OAuthApiToken;
import pl.grizzlysoftware.dotykacka.client.v1.facade.OAuthServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v1.facade.ProductServiceFacade;
import pl.grizzlysoftware.dotykacka.model.Configuration;
import pl.grizzlysoftware.dotykacka.util.AccessTokenProvider;
import pl.grizzlysoftware.dotykacka.util.ApiTokenProvider;
import pl.grizzlysoftware.dotykacka.util.OAuthRequestInterceptor;
import pl.grizzlysoftware.util.OkHttpLoggingInterceptor;

import static java.util.Objects.requireNonNull;
import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.*;
import static pl.grizzlysoftware.util.OkHttpClientUtils.builder;
import static pl.grizzlysoftware.util.RetrofitUtils.service;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class DotykackaApiClient {
    public final OAuthServiceFacade oauthService;
    public final ProductServiceFacade productService;

    protected Configuration configuration;
    protected AccessTokenProvider accessTokenProvider;
    protected ApiTokenProvider apiTokenProvider;

    public DotykackaApiClient(Configuration configuration) {
        this.configuration = requireNonNull(configuration).clone();
        var oAuthHttpClient = builder()
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build();
        oauthService = new OAuthServiceFacade(service(oAuthHttpClient, configuration.url + OAUTH, OAuthService.class));

        if (configuration.apiTokenAuthCredentials == null) {
            apiTokenProvider = new ApiTokenProvider(oauthService, new OAuthApiToken(configuration.apiToken));
        } else {
            apiTokenProvider = new ApiTokenProvider(oauthService, configuration.apiTokenAuthCredentials);
        }
        accessTokenProvider = new AccessTokenProvider(oauthService, apiTokenProvider, configuration.accessTokenAuthCredentials, configuration.apiToken);

        var secureServiceHttpClient = builder()
                .addInterceptor(new OAuthRequestInterceptor(accessTokenProvider))
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build();

        productService = new ProductServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url + PRODUCT, ProductService.class));
    }
}
