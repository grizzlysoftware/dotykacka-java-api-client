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

package pl.grizzlysoftware.dotykacka.client.v1.facade

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.ProductIngredient
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.Product
import pl.grizzlysoftware.dotykacka.client.v1.api.service.ProductService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.PRODUCT
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class ProductServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade;

    @Override
    void setup() {
        facade = new ProductServiceFacade(CLOUD_ID, service(httpClient(), API_URL + PRODUCT, ProductService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when product does not exist"(long id) {
        when:
            facade.getProduct(id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [1, 30, 490]
    }

    def "gets ingredients"() {
        when:
            def out = facade.getIngredients(10, 0, null)
        then:
            out != null
    }

    def "gets all ingredients"() {
        when:
            def out = facade.getIngredients()
        then:
            out != null
    }

    def "gets product ingredients"() {
        when:
            def out = facade.getProductIngredients(PRODUCT_ID, 10, 0, null)
        then:
            out != null
    }

    def "gets all product ingredients"() {
        when:
            def out = facade.getProductIngredients(PRODUCT_ID)
        then:
            out != null
    }

//    def "creates ingredient for product"() {
    //Theres no possibility to create an ingredient throught the API and thus we cannot test - it's actually binding Ingredient with Product
//        given:
//            def p = new Product()
//            p.name = "test"
//            def postCreatedProduct = facade.createProduct(p)
//        when:
//            def i = new ProductIngredient()
//            i.productId = postCreatedProduct.id
//            facade.createProductIngredient(i)
//        then:
//            facade
//        cleanup:
//            facade.deleteProduct(p.id)
//    }

    def "gets product stock status"() {
        when:
            def out = facade.getProductStockStatus(WAREHOUSE_ID, PRODUCT_ID)
        then:
            out != null
    }

    def "gets product with stock status"() {
        when:
            def out = facade.getProductWithStockStatus(WAREHOUSE_ID, PRODUCT_ID)
        then:
            out != null
    }

    def "gets products with stock status"() {
        when:
            def out = facade.getProductsWithStockStatus(WAREHOUSE_ID, 10, 0, null)
        then:
            out != null
    }

    def "gets all products with stock status"() {
        when:
            def out = facade.getProductsWithStockStatus(WAREHOUSE_ID)
        then:
            out != null
    }

    def "gets product"() {
        when:
            def out = facade.getProduct(PRODUCT_ID)
        then:
            out != null
    }

    def "gets products"() {
        when:
            def out = facade.getProducts(10, 0, null)
        then:
            out != null
    }

    def "gets all products"() {
        when:
            def out = facade.getProducts()
        then:
            out != null
    }

    def "creates product"() {
        given:
            def product = new Product()
            product.name = "test_product"
        when:
            def out = facade.createProduct(product)
        then:
            out != null
            out.id != null
        cleanup:
            facade.deleteProduct(out.id)
    }

    def "updates product"() {
        given:
            def preCreateProduct = new Product()
            preCreateProduct.name = "test_product"
        when:
            def preUpdateProduct = facade.createProduct(preCreateProduct)
            preUpdateProduct.name = "test_product 2"
        then:
            def postUpdateProduct = facade.updateProduct(preUpdateProduct)
            postUpdateProduct.id == preUpdateProduct.id
            postUpdateProduct.name != preCreateProduct.name
        cleanup:
            facade.deleteProduct(postUpdateProduct.id)
    }

    def "deletes product"() {
        given:
            def product = new Product()
            product.name = "John"
        when:
            def out = facade.createProduct(product)
            facade.deleteProduct(out.id)
            product = facade.getProduct(out.id)
        then:
            product.isDeleted == true
        cleanup:
            facade.deleteProduct(out.id)
    }
}
