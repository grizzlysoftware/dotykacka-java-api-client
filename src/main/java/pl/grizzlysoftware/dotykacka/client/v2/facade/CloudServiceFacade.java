package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Cloud;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.CloudService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CloudServiceFacade extends DotykackaApiServiceFacade<CloudService> {
    protected BatchLoader batchLoader;
    public CloudServiceFacade(CloudService service) {
        super(-1L, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Cloud findCloudById(Long id) {
        var out = execute(service.findCloudById(cloudId, id));
        return out;
    }

    public Collection<Cloud> findClouds(int limit, int offset, String filter, String sort) {
        var out = execute(service.findClouds(limit, offset, filter, sort));
        return out;
    }

    public Collection<Cloud> findClouds(int limit, int offset) {
        var out = findClouds(limit, offset, null, null);
        return out;
    }

    public Collection<Cloud> findAllClouds(String sort) {
        var out = batchLoader.load(page -> findClouds(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Cloud> findAllClouds() {
        var out = findAllClouds(null);
        return out;
    }
}
