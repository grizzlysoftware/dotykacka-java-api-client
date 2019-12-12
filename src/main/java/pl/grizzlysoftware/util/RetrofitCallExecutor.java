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

package pl.grizzlysoftware.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class RetrofitCallExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetrofitCallExecutor.class);

    protected Class target;

    public RetrofitCallExecutor(Class target) {
        this.target = requireNonNull(target);
    }

    public <T> T execOrThrow(Call<T> call) {
        return executeOrThrow(call)
                .body();
    }

    public <T> Response<T> executeOrThrow(Call<T> call) {
        try {
            var response = requireNonNull(call).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(response.code(),
                        String.format("Unable to invoke external service: %s, response status %s, response message: %s, response headers: %s",
                                target.getSimpleName(),
                                response.code(),
                                response.message(),
                                ofNullable(response.headers()).map(e -> e.toString()).orElse("[]")));
            }
            return response;
        } catch (IOException e) {
            LOGGER.error("Exception occured while sending request: {}", e.getMessage());
            throw new ResponseStatusException(HttpURLConnection.HTTP_UNAVAILABLE);
        }
    }
}
