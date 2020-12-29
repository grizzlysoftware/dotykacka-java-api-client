package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Warehouse;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.WarehouseService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class WarehouseServiceFacade extends DotykackaApiServiceFacade<WarehouseService> {

    protected BatchLoader batchLoader;
    public WarehouseServiceFacade(Long cloudId, WarehouseService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Warehouse getWarehouse(Long id) {
        var out = execute(service.getWarehouse(cloudId, id));
        return out;
    }

    public Collection<Warehouse> getAllWarehouses(int limit, int offset, String sortBy) {
        var out = execute(service.getWarehouses(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Warehouse> getAllWarehouses(String sortBy) {
        var out = batchLoader.load(page -> getAllWarehouses(page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<Warehouse> getAllWarehouses() {
        var out = getAllWarehouses(null);
        return out;
    }

    public Collection<Warehouse> getWarehouses(int limit, int offset) {
        var out = execute(service.getWarehouses(cloudId, limit, offset, null));
        return out;
    }

    public Warehouse updateWarehouse(Long id, Warehouse customer) {
        return execute(service.updateWarehouse(cloudId, id, customer));
    }

    public Warehouse createWarehouse(Warehouse customer) {
        return execute(service.createWarehouse(cloudId, customer));
    }

    public Warehouse deleteWarehouse(Long id) {
        return execute(service.deleteWarehouse(cloudId, id));
    }
}
