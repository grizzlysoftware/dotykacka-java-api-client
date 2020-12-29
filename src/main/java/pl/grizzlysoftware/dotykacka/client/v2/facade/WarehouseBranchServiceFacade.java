package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.WarehouseBranch;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.WarehouseBranchService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class WarehouseBranchServiceFacade extends DotykackaApiServiceFacade<WarehouseBranchService> {
    protected BatchLoader batchLoader;
    public WarehouseBranchServiceFacade(Long cloudId, WarehouseBranchService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createWarehouseBranch(WarehouseBranch warehouseBranch) {
        execute(service.createWarehouseBranch(cloudId, asList(warehouseBranch)));
    }

    public void createWarehouseBranchs(Collection<WarehouseBranch> warehouseBranchs) {
        execute(service.createWarehouseBranch(cloudId, warehouseBranchs));
    }
    
    public void replaceWarehouseBranch(WarehouseBranch warehouseBranch) {
        execute(service.replaceWarehouseBranch(cloudId, warehouseBranch.id, warehouseBranch));
    }

    public void replaceWarehouseBranchs(Collection<WarehouseBranch> warehouseBranchs) {
        execute(service.replaceWarehouseBranches(cloudId, warehouseBranchs));
    }

    public void updateWarehouseBranch(WarehouseBranch warehouseBranch) {
        execute(service.updateWarehouseBranch(cloudId, warehouseBranch.id, warehouseBranch));
    }

    public WarehouseBranch findWarehouseBranchById(Long id) {
        var out = execute(service.findWarehouseBranchById(cloudId, id));
        return out;
    }

    public Collection<WarehouseBranch> findWarehouseBranches(int limit, int offset, String filter, String sort) {
        var out = execute(service.findWarehouseBranches(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<WarehouseBranch> findWarehouseBranches(int limit, int offset) {
        var out = findWarehouseBranches(limit, offset, null, null);
        return out;
    }

    public Collection<WarehouseBranch> findAllWarehouseBranches(String sort) {
        var out = batchLoader.load(page -> findWarehouseBranches(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<WarehouseBranch> findAllWarehouseBranches() {
        var out = findAllWarehouseBranches(null);
        return out;
    }
}
