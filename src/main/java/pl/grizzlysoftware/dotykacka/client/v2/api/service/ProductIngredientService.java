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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.ProductIngredient;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product-ingredient
 */
public interface ProductIngredientService {

    /**
     * Gets productIngredients for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#get-product-ingredients
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return product ingredients
     */
    @GET("v2/clouds/{cloudId}/product-ingredients")
    Call<Collection<ProductIngredient>> findProductIngredients(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                                               @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets productIngredient by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#get-product-ingredient
     *
     * @param cloudId             - cloud id
     * @param productIngredientId - productIngredientId id
     * @return product ingredient
     */
    @GET("v2/clouds/{cloudId}/product-ingredients/{productIngredientId}")
    Call<ProductIngredient> findProductIngredientById(@Path("cloudId") Long cloudId, @Path("productIngredientId") Long productIngredientId);


    /**
     * Creates productIngredients for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#create-new-product-ingredients
     *
     * @param cloudId            - cloud id
     * @param productIngredients - productIngredients to be created, max 100 productIngredients
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/product-ingredients")
    Call<Void> createProductIngredient(@Path("cloudId") Long cloudId, @Body Collection<ProductIngredient> productIngredients);

    /**
     * Replaces or creates product-ingredients in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#replace-or-create-product-ingredients
     *
     * @param cloudId            - cloud id
     * @param productIngredients - productIngredients to be replaced, max 100 productIngredients
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/product-ingredients")
    Call<Void> replaceProductIngredients(@Path("cloudId") Long cloudId, @Body Collection<ProductIngredient> productIngredients);

    /**
     * Replaces or creates productIngredient for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#replace-or-create-product-ingredients
     *
     * @param cloudId             - cloud id
     * @param productIngredientId - id of the productIngredient to be replaced
     * @param productIngredient   - productIngredient to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/product-ingredients/{productIngredientId}")
    Call<Void> replaceProductIngredient(@Path("cloudId") Long cloudId, @Path("productIngredientId") Long productIngredientId, @Body ProductIngredient productIngredient);

    /**
     * Updates productIngredient by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-ingredient#partial-update-of-product-ingredient
     *
     * @param cloudId             - cloud id
     * @param productIngredientId - id of the productIngredient to be updated
     * @param productIngredient   - productIngredient to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/product-ingredients/{productIngredientId}")
    Call<Void> updateProductIngredient(@Path("cloudId") Long cloudId, @Path("productIngredientId") Long productIngredientId, @Body ProductIngredient productIngredient);

    /**
     * @param cloudId             - cloud id
     * @param productIngredientId - productIngredient id
     * @return void Call
     */
    @GET("v2/clouds/{cloudId}/product-ingredients/{productIngredientId}")
    Call<Void> deleteProductIngredient(@Path("cloudId") Long cloudId, @Path("productIngredientId") Long productIngredientId);
}
