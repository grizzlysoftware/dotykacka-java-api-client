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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.ProductCustomization;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product-customization
 */
public interface ProductCustomizationService {

    /**
     * Gets productCustomizations for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#get-product-customizations
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return product customizations
     */
    @GET("v2/clouds/{cloudId}/product-customizations")
    Call<Collection<ProductCustomization>> findProductCustomizations(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                                                     @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets productCustomization by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#get-product-customization
     *
     * @param cloudId                - cloud id
     * @param productCustomizationId - productCustomizationId id
     * @return product customization
     */
    @GET("v2/clouds/{cloudId}/product-customizations/{productCustomizationId}")
    Call<ProductCustomization> findProductCustomizationById(@Path("cloudId") Long cloudId, @Path("productCustomizationId") Long productCustomizationId);


    /**
     * Creates productCustomizations for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#create-new-product-customizations
     *
     * @param cloudId               - cloud id
     * @param productCustomizations - productCustomizations to be created, max 100 productCustomizations
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/product-customizations")
    Call<Void> createProductCustomization(@Path("cloudId") Long cloudId, @Body Collection<ProductCustomization> productCustomizations);

    /**
     * Replaces or creates product-customizations in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#replace-or-create-product-customizations
     *
     * @param cloudId               - cloud id
     * @param productCustomizations - productCustomizations to be replaced, max 100 productCustomizations
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/product-customizations")
    Call<Void> replaceProductCustomizations(@Path("cloudId") Long cloudId, @Body Collection<ProductCustomization> productCustomizations);

    /**
     * Replaces or creates productCustomization for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#replace-or-create-product-customizations
     *
     * @param cloudId                - cloud id
     * @param productCustomizationId - id of the productCustomization to be replaced
     * @param productCustomization   - productCustomization to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/product-customizations/{productCustomizationId}")
    Call<Void> replaceProductCustomization(@Path("cloudId") Long cloudId, @Path("productCustomizationId") Long productCustomizationId, @Body ProductCustomization productCustomization);

    /**
     * Updates productCustomization by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/product-customization#partial-update-of-product-customization
     *
     * @param cloudId                - cloud id
     * @param productCustomizationId - id of the productCustomization to be updated
     * @param productCustomization   - productCustomization to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/product-customizations/{productCustomizationId}")
    Call<Void> updateProductCustomization(@Path("cloudId") Long cloudId, @Path("productCustomizationId") Long productCustomizationId, @Body ProductCustomization productCustomization);

    /**
     * @param cloudId                - cloud id
     * @param productCustomizationId - productCustomization id
     * @return void Call
     */
    @GET("v2/clouds/{cloudId}/product-customizations/{productCustomizationId}")
    Call<Void> deleteProductCustomization(@Path("cloudId") Long cloudId, @Path("productCustomizationId") Long productCustomizationId);
}
