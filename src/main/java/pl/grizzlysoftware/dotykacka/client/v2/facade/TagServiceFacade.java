package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Tag;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.TagService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class TagServiceFacade extends DotykackaApiServiceFacade<TagService> {
    protected BatchLoader batchLoader;
    public TagServiceFacade(Long cloudId, TagService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Tag findTagById(Long id) {
        var out = execute(service.findTagById(cloudId, id));
        return out;
    }

    public Collection<Tag> findTags(int limit, int offset, String filter, String sort) {
        var out = execute(service.findTags(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Tag> findTags(int limit, int offset) {
        var out = findTags(limit, offset, null, null);
        return out;
    }

    public Collection<Tag> findAllTags(String sort) {
        var out = batchLoader.load(page -> findTags(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Tag> findAllTags() {
        var out = findAllTags(null);
        return out;
    }

    public void createTag(Tag tag) {
        execute(service.createTags(cloudId, asList(tag)));
    }

    public void createTags(Collection<Tag> tags) {
        execute(service.createTags(cloudId, tags));
    }
}
