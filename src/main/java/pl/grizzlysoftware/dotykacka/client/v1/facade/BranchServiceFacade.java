package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.branch.Branch;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.BranchService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class BranchServiceFacade extends DotykackaApiServiceFacade<BranchService> {
    protected BatchLoader batchLoader;
    public BranchServiceFacade(Integer cloudId, BranchService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Branch getBranch(Integer id) {
        var out = execute(service.getBranch(cloudId, id));
        return out;
    }

    public Collection<Branch> getBranches(int limit, int offset, String sort) {
        var out = execute(service.getBranches(cloudId, limit, offset, sort));
        return out;
    }

    public Collection<Branch> getBranches(int limit, int offset) {
        var out = getBranches(limit, offset, null);
        return out;
    }

    public Collection<Branch> getBranches(String sort) {
        var out = batchLoader.load(page -> getBranches(page.limit, page.offset, sort));
        return out;
    }

    public Collection<Branch> getBranches() {
        var out = getBranches(null);
        return out;
    }
}
