package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.ProductCustomization;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.ProductCustomizationService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductCustomizationServiceFacade extends DotykackaApiServiceFacade<ProductCustomizationService> {
    protected BatchLoader batchLoader;
    public ProductCustomizationServiceFacade(Long cloudId, ProductCustomizationService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createProductCustomization(ProductCustomization productCustomization) {
        execute(service.createProductCustomization(cloudId, asList(productCustomization)));
    }

    public void createProductCustomizations(Collection<ProductCustomization> productCustomizations) {
        execute(service.createProductCustomization(cloudId, productCustomizations));
    }
    
    public void replaceProductCustomization(ProductCustomization productCustomization) {
        execute(service.replaceProductCustomization(cloudId, productCustomization.id, productCustomization));
    }

    public void replaceProductCustomizations(Collection<ProductCustomization> productCustomizations) {
        execute(service.replaceProductCustomizations(cloudId, productCustomizations));
    }

    public void updateProductCustomization(ProductCustomization productCustomization) {
        execute(service.updateProductCustomization(cloudId, productCustomization.id, productCustomization));
    }

    public void deleteProductCustomization(Long productCustomizationId) {
        execute(service.deleteProductCustomization(cloudId, productCustomizationId));
    }

    public ProductCustomization findProductCustomizationById(Long id) {
        var out = execute(service.findProductCustomizationById(cloudId, id));
        return out;
    }

    public Collection<ProductCustomization> findProductCustomizations(int limit, int offset, String filter, String sort) {
        var out = execute(service.findProductCustomizations(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<ProductCustomization> findProductCustomizations(int limit, int offset) {
        var out = findProductCustomizations(limit, offset, null, null);
        return out;
    }

    public Collection<ProductCustomization> findAllProductCustomizations(String sort) {
        var out = batchLoader.load(page -> findProductCustomizations(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<ProductCustomization> findAllProductCustomizations() {
        var out = findAllProductCustomizations(null);
        return out;
    }
}
