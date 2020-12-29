package pl.grizzlysoftware.dotykacka.client;

import pl.grizzlysoftware.util.RetrofitApiServiceFacade;
import pl.grizzlysoftware.util.RetrofitCallExecutor;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class BasicDotykackaApiServiceFacade extends RetrofitApiServiceFacade {
    protected Long cloudId;

    public BasicDotykackaApiServiceFacade(RetrofitCallExecutor executor, Long cloudId) {
        super(executor);
        this.cloudId = requireNonNull(cloudId);
    }

    public BasicDotykackaApiServiceFacade(Long cloudId) {
        this.cloudId = requireNonNull(cloudId);
    }
}
