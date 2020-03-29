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

package pl.grizzlysoftware.dotykacka.model;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class Configuration implements Cloneable {
    public String url;
    public Long cloudId;
    public Duration requestTimeout;
    public Credentials accessTokenAuthCredentials;
    public Credentials apiTokenAuthCredentials;
    public String apiToken;

    public boolean isValid() {
        if (isEmpty(url)) {
            return false;
        }
        if (cloudId == null) {
            return false;
        }
        if (accessTokenAuthCredentials == null) {
            return false;
        }
        if (apiTokenAuthCredentials == null && isEmpty(apiToken)) {
            return false;
        }
        return true;
    }

    @Override
    public Configuration clone() {
        if (!isValid()) {
            throw new IllegalArgumentException("Configuration is not valid");
        }
        var out = new Configuration();
        out.url = url;
        out.cloudId = cloudId;
        out.requestTimeout = requestTimeout;
        out.accessTokenAuthCredentials = accessTokenAuthCredentials.clone();
        out.apiTokenAuthCredentials = apiTokenAuthCredentials == null ? null : apiTokenAuthCredentials.clone();
        out.apiToken = apiToken;
        return out;
    }
}
