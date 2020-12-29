package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Supplier;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.SupplierService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class SupplierServiceFacade extends DotykackaApiServiceFacade<SupplierService> {
    protected BatchLoader batchLoader;
    public SupplierServiceFacade(Long cloudId, SupplierService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createSupplier(Supplier supplier) {
        execute(service.createSupplier(cloudId, asList(supplier)));
    }

    public void createSuppliers(Collection<Supplier> suppliers) {
        execute(service.createSupplier(cloudId, suppliers));
    }
    
    public void replaceSupplier(Supplier supplier) {
        execute(service.replaceSupplier(cloudId, supplier.id, supplier));
    }

    public void replaceSuppliers(Collection<Supplier> suppliers) {
        execute(service.replaceSuppliers(cloudId, suppliers));
    }

    public void updateSupplier(Supplier supplier) {
        execute(service.updateSupplier(cloudId, supplier.id, supplier));
    }

    public void deleteSupplier(Long supplierId) {
        execute(service.deleteSupplier(cloudId, supplierId));
    }

    public Supplier findSupplierById(Long id) {
        var out = execute(service.findSupplierById(cloudId, id));
        return out;
    }

    public Collection<Supplier> findSuppliers(int limit, int offset, String filter, String sort) {
        var out = execute(service.findSuppliers(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Supplier> findSuppliers(int limit, int offset) {
        var out = findSuppliers(limit, offset, null, null);
        return out;
    }

    public Collection<Supplier> findAllSuppliers(String sort) {
        var out = batchLoader.load(page -> findSuppliers(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Supplier> findAllSuppliers() {
        var out = findAllSuppliers(null);
        return out;
    }
}
