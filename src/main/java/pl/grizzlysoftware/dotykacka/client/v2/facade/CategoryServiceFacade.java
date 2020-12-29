package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Category;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.CategoryService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CategoryServiceFacade extends DotykackaApiServiceFacade<CategoryService> {
    protected BatchLoader batchLoader;
    public CategoryServiceFacade(Long cloudId, CategoryService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createCategory(Category category) {
        execute(service.createCategory(cloudId, asList(category)));
    }

    public void createCategories(Collection<Category> categories) {
        execute(service.createCategory(cloudId, categories));
    }
    
    public void replaceCategory(Category category) {
        execute(service.replaceCategory(cloudId, category.id, category));
    }

    public void replaceCategories(Collection<Category> categories) {
        execute(service.replaceCategories(cloudId, categories));
    }

    public void updateCategory(Category category) {
        execute(service.updateCategory(cloudId, category.id, category));
    }

    public void deleteCategory(Long categoryId) {
        execute(service.deleteCategory(cloudId, categoryId));
    }

    public Category findCategoryById(Long id) {
        var out = execute(service.findCategoryById(cloudId, id));
        return out;
    }

    public Collection<Category> findCategories(int limit, int offset, String filter, String sort) {
        var out = execute(service.findCategories(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Category> findCategories(int limit, int offset) {
        var out = findCategories(limit, offset, null, null);
        return out;
    }

    public Collection<Category> findAllCategories(String sort) {
        var out = batchLoader.load(page -> findCategories(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Category> findAllCategories() {
        var out = findAllCategories(null);
        return out;
    }
}
