package pl.grizzlysoftware.util;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OkHttpNonEmptyBodyConverter<T extends Object> implements Converter<ResponseBody, T> {
    private Converter<ResponseBody, T> delegate;

    public void setDelegate(Converter<ResponseBody, T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T convert(ResponseBody body) throws IOException {
        try {
            return delegate.convert(body);
        } catch (Exception e) {
            return null;
        }
    }
}
