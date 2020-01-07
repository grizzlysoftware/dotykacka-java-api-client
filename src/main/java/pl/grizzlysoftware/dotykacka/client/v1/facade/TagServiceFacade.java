package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Tag;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.TagService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class TagServiceFacade extends DotykackaApiServiceFacade<TagService> {
    protected BatchLoader batchLoader;
    public TagServiceFacade(Integer cloudId, TagService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Tag createTag(Tag tag) {
        var out = execute(service.createTag(cloudId, tag.type, tag));
        return out;
    }

//    public Tag updateTag(Long tagId, Tag tag) {
//        var out = execute(service.updateTag(cloudId, tagId, tag));
//        return out;
//    }
//
//    public Tag deleteTag(Long tagId) {
//        var out = execute(service.deleteTag(cloudId, tagId));
//        return out;
//    }

    public Tag getTag(Long id) {
        var out = execute(service.getTag(cloudId, id));
        return out;
    }

    public Collection<Tag> getTags(int limit, int offset, String sort) {
        var out = execute(service.getTags(cloudId, limit, offset, sort));
        return out;
    }

    public Collection<Tag> getTags(int limit, int offset) {
        var out = getTags(limit, offset, null);
        return out;
    }

    public Collection<Tag> getTags(String sort) {
        var out = batchLoader.load(page -> getTags(page.limit, page.offset, sort));
        return out;
    }

    public Collection<Tag> getTags() {
        var out = getTags(null);
        return out;
    }
}
