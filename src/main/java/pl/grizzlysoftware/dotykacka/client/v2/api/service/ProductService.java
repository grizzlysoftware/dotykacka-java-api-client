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

package pl.grizzlysoftware.dotykacka.client.v2.api.service;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product
 */
public interface ProductService {

    /**
     * Gets products for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#get-products
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return
     */
    @GET("v2/clouds/{cloudId}/products")
    Call<Collection<Product>> findProducts(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                             @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets product by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#get-product
     *
     * @param cloudId    - cloud id
     * @param productId - productId id
     * @return
     */
    @GET("v2/clouds/{cloudId}/products/{productId}")
    Call<Product> findProductById(@Path("cloudId") Long cloudId, @Path("productId") Long productId);


    /**
     * Creates products for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#create-product
     *
     * @param cloudId   - cloud id
     * @param products - products to be created, max 100 products
     * @return
     */
    @POST("v2/clouds/{cloudId}/products")
    Call<Void> createProduct(@Path("cloudId") Long cloudId, @Body Collection<Product> products);

    /**
     * Replaces or creates products in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#replace-or-create-products
     *
     * @param cloudId   - cloud id
     * @param products - products to be replaced, max 100 products
     * @return
     */
    @PUT("v2/clouds/{cloudId}/products")
    Call<Void> replaceProducts(@Path("cloudId") Long cloudId, @Body Collection<Product> products);

    /**
     * Replaces or creates product for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#replace-or-create-product
     *
     * @param cloudId    - cloud id
     * @param productId - id of the product to be replaced
     * @param product   - product to be replaced
     * @return
     */
    @PUT("v2/clouds/{cloudId}/products/{productId}")
    Call<Void> replaceProduct(@Path("cloudId") Long cloudId, @Path("productId") Long productId, @Body Product product);

    /**
     * Updates product by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product#partial-update-of-product
     *
     * @param cloudId    - cloud id
     * @param productId - id of the product to be updated
     * @param product   - product to be updated
     * @return
     */
    @PATCH("v2/clouds/{cloudId}/products/{productId}")
    Call<Void> updateProduct(@Path("cloudId") Long cloudId, @Path("productId") Long productId, @Body Product product);

    /**
     * @param cloudId    - cloud id
     * @param productId - product id
     * @return
     */
    @GET("v2/clouds/{cloudId}/products/{productId}")
    Call<Void> deleteProduct(@Path("cloudId") Long cloudId, @Path("productId") Long productId);
}
