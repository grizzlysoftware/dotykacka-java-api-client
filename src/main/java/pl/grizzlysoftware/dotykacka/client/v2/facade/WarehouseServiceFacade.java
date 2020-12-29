package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.ProductStockInfo;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.ProductStockup;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.Warehouse;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.WarehouseService;
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

    public Warehouse findWarehouseById(Long id) {
        var out = execute(service.findWarehouseById(cloudId, id));
        return out;
    }

    public Collection<Warehouse> findWarehouses(int limit, int page, String filter, String sortBy) {
        var out = execute(service.findWarehouses(cloudId, limit, page, filter, sortBy));
        return out;
    }

    public Collection<Warehouse> findAllWarehouses(String sortBy) {
        var out = batchLoader.load(page -> findWarehouses(page.limit, page.offset, null, sortBy));
        return out;
    }

    public Collection<Warehouse> findAllWarehouses() {
        var out = findAllWarehouses(null);
        return out;
    }

    public Collection<Warehouse> findWarehouses(int limit, int page) {
        var out = execute(service.findWarehouses(cloudId, limit, page, null, null));
        return out;
    }

    public Warehouse updateWarehouse(Warehouse warehouse) {
        return execute(service.updateWarehouse(cloudId, warehouse.id, warehouse));
    }

    public Warehouse replaceWarehouse(Warehouse warehouse) {
        return execute(service.replaceWarehouse(cloudId, warehouse));
    }

    public Collection<Warehouse> replaceWarehouses(Collection<Warehouse> warehouses) {
        return execute(service.replaceWarehouses(cloudId, warehouses));
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return execute(service.createWarehouse(cloudId, warehouse));
    }

    public Warehouse deleteWarehouseById(Long id) {
        return execute(service.deleteWarehouse(cloudId, id));
    }

    public void stockupProducts(Long warehouseId, ProductStockup stockup) {
        execute(service.stockupProducts(cloudId, warehouseId, stockup));
    }

    public Collection<ProductStockInfo> findWarehouseProductStockInfos(Long warehouseId) {
        return execute(service.findWarehouseProductStockInfos(cloudId, warehouseId));
    }

    public Collection<ProductStockInfo> findWarehouseProductStockInfoByProductId(Long warehouseId, Long productId) {
        return execute(service.findWarehouseProductStockInfoByProductId(cloudId, warehouseId, productId));
    }
}
