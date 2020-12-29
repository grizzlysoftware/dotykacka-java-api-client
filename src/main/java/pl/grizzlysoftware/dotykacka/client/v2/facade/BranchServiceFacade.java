package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Branch;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.BranchService;
import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class BranchServiceFacade extends DotykackaApiServiceFacade<BranchService> {
    protected BatchLoader batchLoader;
    public BranchServiceFacade(Long cloudId, BranchService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Branch findBranchById(Long id) {
        var out = execute(service.findBranchById(cloudId, id));
        return out;
    }

    public Collection<Branch> findBranches(int limit, int offset, String filter, String sort) {
        var out = execute(service.findBranches(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Branch> findBranches(int limit, int offset) {
        var out = findBranches(limit, offset, null, null);
        return out;
    }

    public Collection<Branch> findAllBranches(String sort) {
        var out = batchLoader.load(page -> findBranches(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Branch> findAllBranches() {
        var out = findAllBranches(null);
        return out;
    }
}
