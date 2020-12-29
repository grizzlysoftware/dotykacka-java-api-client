/*
 * Copyright 2019 Grizzly Software, https://grizzlysoftware.pl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Ingredient;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.ProductIngredient;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.Product;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.ProductWithStockStatus;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.ProductService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductServiceFacade extends DotykackaApiServiceFacade<ProductService> {
    protected BatchLoader batchLoader;

    public ProductServiceFacade(Long cloudId, ProductService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Product getProduct(Long id) {
        var out = execute(service.getProduct(cloudId, id));
        return out;
    }

    public Collection<Product> getProducts(int limit, int offset, String sortBy) {
        var out = execute(service.getProducts(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Product> getProducts(String sortBy) {
        var out = batchLoader.load(page -> getProducts(page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<Product> getProducts() {
        var out = getProducts(null);
        return out;
    }

    public ProductWithStockStatus getProductWithStockStatus(Long warehouseId, Long productId) {
        var out = execute(service.getProductWithStockStatus(cloudId, warehouseId, productId));
        return out;
    }

    public ProductWithStockStatus getProductStockStatus(Long warehouseId, Long productId) {
        var out = execute(service.getProductStockStatus(cloudId, warehouseId, productId));
        return out;
    }

    public Collection<ProductWithStockStatus> getProductsWithStockStatus(long warehouseId, int limit, int offset, String sortBy) {
        return execute(service.getProductsWithStockStatus(cloudId, warehouseId, limit, offset, sortBy));
    }

    public Collection<ProductWithStockStatus> getProductsWithStockStatus(long warehouseId, String sortBy) {
        var out = batchLoader.load(page -> getProductsWithStockStatus(warehouseId, page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<ProductWithStockStatus> getProductsWithStockStatus(long warehouseId) {
        var out = getProductsWithStockStatus(warehouseId, null);
        return out;
    }

    public Product updateProduct(Product product) {
        return execute(service.updateProduct(cloudId, product.id, product));
    }

    public Product createProduct(Product product) {
        return execute(service.createProduct(cloudId, product));
    }

    public Product deleteProduct(Long id) {
        return execute(service.deleteProduct(cloudId, id));
    }

    public Collection<ProductWithStockStatus> getProductIngredients(Long productId, int limit, int offset, String sortBy) {
        var out = execute(service.getProductsIngredients(cloudId, productId, limit, offset, sortBy));
        return out;
    }

    public Collection<ProductWithStockStatus> getProductIngredients(Long productId, String sortBy) {
        var out = batchLoader.load(page -> getProductIngredients(productId, page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<ProductWithStockStatus> getProductIngredients(Long productId) {
        var out = getProductIngredients(productId, null);
        return out;
    }

    public Collection<Ingredient> getIngredients(int limit, int offset, String sortBy) {
        var out = execute(service.getIngredients(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Ingredient> getIngredients(String sortBy) {
        var out = batchLoader.load(page -> getIngredients(page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<Ingredient> getIngredients() {
        var out = getIngredients(null);
        return out;
    }

    /**
     * TODO: to be tested - it's not possible to create a product ingredient. I think this method is actually a binding between product and ingredient
     *
     * UPDATE 01.02.2020 - ingredient is actually a product
     * @param productIngredient
     * @return
     */
    public Ingredient createProductIngredient(ProductIngredient productIngredient) {
        var out = execute(service.createProductIngredient(cloudId, productIngredient));
        return out;
    }

    /**
     * TODO: to be tested - it's not possible to create a product ingredient. I think this method is actually a binding between product and ingredient
     *
     * UPDATE 01.02.2020 - ingredient is actually a product
     * @param productIngredientId
     * @return
     */
    public Ingredient deleteProductIngredient(Long productIngredientId) {
        var out = execute(service.deleteProductIngredient(cloudId, productIngredientId));
        return out;
    }
}
