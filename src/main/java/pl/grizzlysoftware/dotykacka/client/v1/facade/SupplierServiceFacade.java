package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Supplier;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.SupplierService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class SupplierServiceFacade extends DotykackaApiServiceFacade<SupplierService> {

    protected BatchLoader batchLoader;
    public SupplierServiceFacade(Long cloudId, SupplierService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Supplier getSupplier(Long id) {
        var out = execute(service.getSupplier(cloudId, id));
        return out;
    }

    public Collection<Supplier> getSuppliers(int limit, int offset, String sortBy) {
        var out = execute(service.getSuppliers(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Supplier> getSuppliers(int limit, int offset) {
        var out = getSuppliers(limit, offset, null);
        return out;
    }

    public Collection<Supplier> getSuppliers(String sortBy) {
        var out = batchLoader.load(page -> getSuppliers(page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<Supplier> getAllSuppliers() {
        var out = getSuppliers(null);
        return out;
    }

    public Supplier updateSupplier(Long id, Supplier customer) {
        return execute(service.updateSupplier(cloudId, id, customer));
    }

    public Supplier createSupplier(Supplier customer) {
        return execute(service.createSupplier(cloudId, customer));
    }

    public Supplier deleteSupplier(Long id, boolean anonymize) {
        return execute(service.deleteSupplier(cloudId, id, anonymize));
    }

    public Supplier deleteSupplier(Long id) {
        return execute(service.deleteSupplier(cloudId, id, null));
    }
}
