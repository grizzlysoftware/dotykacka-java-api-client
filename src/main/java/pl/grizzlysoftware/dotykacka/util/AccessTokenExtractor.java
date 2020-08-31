package pl.grizzlysoftware.dotykacka.util;

import java.util.function.Function;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface AccessTokenExtractor<T> extends Function<T, String> {
}
