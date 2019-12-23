package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.util.RetrofitApiServiceFacade;
import pl.grizzlysoftware.util.RetrofitCallExecutor;

import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class BasicDotykackaApiServiceFacade extends RetrofitApiServiceFacade {
    protected Integer cloudId;

    public BasicDotykackaApiServiceFacade(RetrofitCallExecutor executor, Integer cloudId) {
        super(executor);
        this.cloudId = requireNonNull(cloudId);
    }

    public BasicDotykackaApiServiceFacade(Integer cloudId) {
        this.cloudId = requireNonNull(cloudId);
    }
}
