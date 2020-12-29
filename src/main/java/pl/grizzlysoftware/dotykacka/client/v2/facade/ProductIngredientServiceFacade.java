package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.ProductIngredient;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.ProductIngredientService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductIngredientServiceFacade extends DotykackaApiServiceFacade<ProductIngredientService> {
    protected BatchLoader batchLoader;
    public ProductIngredientServiceFacade(Long cloudId, ProductIngredientService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createProductIngredient(ProductIngredient productIngredient) {
        execute(service.createProductIngredient(cloudId, asList(productIngredient)));
    }

    public void createProductIngredients(Collection<ProductIngredient> productIngredients) {
        execute(service.createProductIngredient(cloudId, productIngredients));
    }
    
    public void replaceProductIngredient(ProductIngredient productIngredient) {
        execute(service.replaceProductIngredient(cloudId, productIngredient.id, productIngredient));
    }

    public void replaceProductIngredients(Collection<ProductIngredient> productIngredients) {
        execute(service.replaceProductIngredients(cloudId, productIngredients));
    }

    public void updateProductIngredient(ProductIngredient productIngredient) {
        execute(service.updateProductIngredient(cloudId, productIngredient.id, productIngredient));
    }

    public void deleteProductIngredient(Long productIngredientId) {
        execute(service.deleteProductIngredient(cloudId, productIngredientId));
    }

    public ProductIngredient findProductIngredientById(Long id) {
        var out = execute(service.findProductIngredientById(cloudId, id));
        return out;
    }

    public Collection<ProductIngredient> findProductIngredients(int limit, int offset, String filter, String sort) {
        var out = execute(service.findProductIngredients(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<ProductIngredient> findProductIngredients(int limit, int offset) {
        var out = findProductIngredients(limit, offset, null, null);
        return out;
    }

    public Collection<ProductIngredient> findAllProductIngredients(String sort) {
        var out = batchLoader.load(page -> findProductIngredients(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<ProductIngredient> findAllProductIngredients() {
        var out = findAllProductIngredients(null);
        return out;
    }
}
