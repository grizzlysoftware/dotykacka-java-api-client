package pl.grizzlysoftware.dotykacka.client.v1.facade

import pl.grizzlysoftware.dotykacka.client.v1.api.service.CategoryService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.CATEGORY
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class CategoryServiceFacadeTest extends DotykackaSecureServiceSpecification {
    CategoryServiceFacade facade

    @Override
    void setup() {
        facade = new CategoryServiceFacade(CLOUD_ID,
                service(httpClient(), API_URL + CATEGORY, CategoryService.class)
        )
    }

    def "creates category"() {
        given:
            def category = new pl.grizzlysoftware.dotykacka.client.v1.api.dto.category.Category()
            category.name = "test_category"
        when:
            def out = facade.createCategory(category)
        then:
            out != null
        cleanup:
            facade.deleteCategory(out.id)
    }

    def "updates category"() {
        given:
            def category = new pl.grizzlysoftware.dotykacka.client.v1.api.dto.category.Category()
            category.name = "test_category"
        when:
            def out = facade.createCategory(category)
            out.name = "updated_" + out.name
            def out2 = facade.updateCategory(out.id, out)
        then:
            out != null
            out.name == out2.name
        cleanup:
            facade.deleteCategory(out.id)
    }

    def "deletes category"() {
        given:
            def category = new pl.grizzlysoftware.dotykacka.client.v1.api.dto.category.Category()
            category.name = "test_category"
        when:
            def out = facade.createCategory(category)
            def out2 = facade.deleteCategory(out.id)
            def seek = facade.getCategory(out2.id)
        then:
            seek != null
            seek.deleted == 1
        cleanup:
            facade.deleteCategory(out.id)
    }

    def "gets category"() {
        given:
            def category = new pl.grizzlysoftware.dotykacka.client.v1.api.dto.category.Category()
            category.name = "test_category"
        when:
            def out = facade.createCategory(category)
            def seek = facade.getCategory(out.id)
        then:
            seek != null
        cleanup:
            facade.deleteCategory(out.id)
    }

    def "gets categories with sort"() {
        when:
            def out = facade.getCategories(100, 0, null)
        then:
            out != null
    }

    def "gets categories"() {
        when:
            def out = facade.getCategories(100, 0)
        then:
            out != null
    }

    def "gets all categories"() {
        when:
            def out = facade.getCategories()
        then:
            out != null
    }
}
