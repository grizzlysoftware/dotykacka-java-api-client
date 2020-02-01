package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.category.Category;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.CategoryService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CategoryServiceFacade extends DotykackaApiServiceFacade<CategoryService> {
    protected BatchLoader batchLoader;
    public CategoryServiceFacade(Long cloudId, CategoryService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Category createCategory(Category category) {
        var out = execute(service.createCategory(cloudId, category));
        return out;
    }

    public Category updateCategory(Long categoryId, Category category) {
        var out = execute(service.updateCategory(cloudId, categoryId, category));
        return out;
    }

    public Category deleteCategory(Long categoryId) {
        var out = execute(service.deleteCategory(cloudId, categoryId));
        return out;
    }

    public Category getCategory(Long id) {
        var out = execute(service.getCategory(cloudId, id));
        return out;
    }

    public Collection<Category> getCategories(int limit, int offset, String sort) {
        var out = execute(service.getCategories(cloudId, limit, offset, sort));
        return out;
    }

    public Collection<Category> getCategories(int limit, int offset) {
        var out = getCategories(limit, offset, null);
        return out;
    }

    public Collection<Category> getCategories(String sort) {
        var out = batchLoader.load(page -> getCategories(page.limit, page.offset, sort));
        return out;
    }

    public Collection<Category> getCategories() {
        var out = getCategories(null);
        return out;
    }
}
