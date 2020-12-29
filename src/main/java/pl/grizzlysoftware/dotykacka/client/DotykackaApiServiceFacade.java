package pl.grizzlysoftware.dotykacka.client;

import pl.grizzlysoftware.util.RetrofitCallExecutor;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class DotykackaApiServiceFacade<T> extends BasicDotykackaApiServiceFacade {
    protected T service;

    public DotykackaApiServiceFacade(RetrofitCallExecutor executor, Long cloudId, T service) {
        super(executor, cloudId);
        this.service = requireNonNull(service);
    }

    public DotykackaApiServiceFacade(Long cloudId, T service) {
        super(cloudId);
        this.service = requireNonNull(service);
    }
}
