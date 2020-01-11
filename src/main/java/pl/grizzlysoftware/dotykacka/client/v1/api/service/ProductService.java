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

package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Ingredient;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.ProductIngredient;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.Product;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.ProductWithStockStatus;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface ProductService {

    @GET("{cloudId}/{warehouseId}/list")
    Call<Collection<ProductWithStockStatus>> getProductsWithStockStatus(@Path("cloudId") Integer cloudId, @Path("warehouseId") long warehouseId, @Query("limit") int limit, @Query("offset") int offset, @Query("sort") String sortBy);

    @GET("{cloudId}/{productId}")
    Call<Product> getProduct(@Path("cloudId") Integer cloudId, @Path("productId") Long productId);

    @GET("withstockstatus/{cloudId}/{warehouseId}/{productId}")
    Call<ProductWithStockStatus> getProductWithStockStatus(@Path("cloudId") Integer cloudId, @Path("warehouseId") Long warehouseId, @Path("productId") Long productId);

    @GET("stockstatus/{cloudId}/{warehouseId}/{productId}")
    Call<ProductWithStockStatus> getProductStockStatus(@Path("cloudId") Integer cloudId, @Path("warehouseId") Long warehouseId, @Path("productId") Long productId);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    @POST("{cloudId}/create")
    Call<Product> createProduct(@Path("cloudId") Integer cloudId, @Body Product product);

    @GET("{cloudId}/{id}/delete")
    Call<Product> deleteProduct(@Path("cloudId") Integer cloudId, @Path("id") Long id);

    @POST("{cloudId}/{id}/update")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    Call<Product> updateProduct(@Path("cloudId") Integer cloudId, @Path("id") Long id, @Body Product consumer);

    @GET("{cloudId}")
    Call<Collection<Product>> getProducts(@Path("cloudId") Integer cloudId, @Query("limit") int limit, @Query("offset") int offset, @Query("sort") String sortBy);

    @GET("{cloudId}/{productId}/ingredients")
    Call<Collection<ProductWithStockStatus>> getProductsIngredients(@Path("cloudId") Integer cloudId, @Path("productId") Long productId, @Query("limit") int limit, @Query("offset") int offset, @Query("sort") String sortBy);

    @POST("{cloudId}/{productId}/ingredients/edit")
    Call<Ingredient> createProductIngredient(@Path("cloudId") Integer cloudId, @Body ProductIngredient productIngredient);

    @POST("{cloudId}/{productId}/ingredients/{ingredientId}/delete")
    Call<Ingredient> deleteProductIngredient(@Path("cloudId") Integer cloudId, @Path("ingredientId") Long ingredientId, @Body ProductIngredient productIngredient);

    @GET("{cloudId}/ingredients")
    Call<Collection<Ingredient>> getIngredients(@Path("cloudId") Integer cloudId, @Query("limit") int limit, @Query("offset") int offset, @Query("sort") String sortBy);
}
