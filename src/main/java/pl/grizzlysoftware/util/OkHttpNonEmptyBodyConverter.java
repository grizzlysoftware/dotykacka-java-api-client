package pl.grizzlysoftware.util;

import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Converter;

import java.io.IOException;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OkHttpNonEmptyBodyConverter<T extends Object> implements Converter<ResponseBody, T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpNonEmptyBodyConverter.class);

    private Converter<ResponseBody, T> delegate;

    public OkHttpNonEmptyBodyConverter(Converter<ResponseBody, T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T convert(ResponseBody body) throws IOException {
        try {
            return delegate.convert(body);
        } catch (Exception e) {
            LOGGER.warn("cannot deserialize", e);
            return null;
        }
    }
}
