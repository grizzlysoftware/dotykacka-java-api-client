package pl.grizzlysoftware.dotykacka.client.v1.facade

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Tag
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.TagType
import pl.grizzlysoftware.dotykacka.client.v1.api.service.TagService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.TAG
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.DotykackaApiInfo.TAG_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class TagServiceFacadeTest extends DotykackaSecureServiceSpecification {
    TagServiceFacade facade

    @Override
    void setup() {
        facade = new TagServiceFacade(CLOUD_ID,
                service(httpClient(), API_URL + TAG, TagService.class)
        )
    }

    def "creates tag"() {
        given:
            def tag = new Tag()
            tag.type = TagType.PRODUCT
            tag.name = "test_tag"
        when:
            def out = facade.createTag(tag)
        then:
            out != null
//        cleanup:
//            facade.deleteTag(out.id)
    }

//    def "updates tag"() {
//        given:
//            def tag = new Tag()
//            tag.type = TagType.PRODUCT
//            tag.name = "test_tag"
//        when:
//            def out = facade.createTag(tag)
//            out.name = "updated_" + out.name
//            def out2 = facade.updateTag(out.id, out)
//        then:
//            out != null
//            out.name == out2.name
//        cleanup:
//            facade.deleteTag(out.id)
//    }
//
//    def "deletes tag"() {
//        given:
//            def tag = new Tag()
//            tag.type = TagType.PRODUCT
//            tag.name = "test_tag"
//        when:
//            def out = facade.createTag(tag)
//            def out2 = facade.deleteTag(out.id)
//            def seek = facade.getTag(out2.id)
//        then:
//            seek != null
//            seek.isDeleted == true
//        cleanup:
//            facade.deleteTag(out.id)
//    }

    def "gets tag"() {
        when:
            def seek = facade.getTag(TAG_ID)
        then:
            seek != null
//        cleanup:
//            facade.deleteTag(out.id)
    }

    def "gets tags with sort"() {
        when:
            def out = facade.getTags(100, 0, null)
        then:
            out != null
    }

    def "gets tags"() {
        when:
            def out = facade.getTags(100, 0)
        then:
            out != null
    }

    def "gets all tags"() {
        when:
            def out = facade.getTags()
        then:
            out != null
    }
}
