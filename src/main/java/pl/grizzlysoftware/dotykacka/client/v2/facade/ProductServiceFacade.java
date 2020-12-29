package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Product;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.ProductService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductServiceFacade extends DotykackaApiServiceFacade<ProductService> {
    protected BatchLoader batchLoader;
    public ProductServiceFacade(Long cloudId, ProductService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createProduct(Product product) {
        execute(service.createProduct(cloudId, asList(product)));
    }

    public void createProducts(Collection<Product> products) {
        execute(service.createProduct(cloudId, products));
    }
    
    public void replaceProduct(Product product) {
        execute(service.replaceProduct(cloudId, product.id, product));
    }

    public void replaceProducts(Collection<Product> products) {
        execute(service.replaceProducts(cloudId, products));
    }

    public void updateProduct(Product product) {
        execute(service.updateProduct(cloudId, product.id, product));
    }

    public void deleteProduct(Long productId) {
        execute(service.deleteProduct(cloudId, productId));
    }

    public Product findProductById(Long id) {
        var out = execute(service.findProductById(cloudId, id));
        return out;
    }

    public Collection<Product> findProducts(int limit, int offset, String filter, String sort) {
        var out = execute(service.findProducts(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Product> findProducts(int limit, int offset) {
        var out = findProducts(limit, offset, null, null);
        return out;
    }

    public Collection<Product> findAllProducts(String sort) {
        var out = batchLoader.load(page -> findProducts(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Product> findAllProducts() {
        var out = findAllProducts(null);
        return out;
    }
}
