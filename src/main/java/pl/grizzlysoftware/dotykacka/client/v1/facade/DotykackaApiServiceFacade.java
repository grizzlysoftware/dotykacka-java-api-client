package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.util.RetrofitApiServiceFacade;
import pl.grizzlysoftware.util.RetrofitCallExecutor;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class DotykackaApiServiceFacade<T> extends RetrofitApiServiceFacade {
    protected String cloudId;
    protected T service;

    public DotykackaApiServiceFacade(RetrofitCallExecutor executor, String cloudId, T service) {
        super(executor);
        this.cloudId = requireNonNull(cloudId);
        this.service = requireNonNull(service);
    }

    public DotykackaApiServiceFacade(String cloudId, T service) {
        this.cloudId = requireNonNull(cloudId);
        this.service = requireNonNull(service);
    }
}
