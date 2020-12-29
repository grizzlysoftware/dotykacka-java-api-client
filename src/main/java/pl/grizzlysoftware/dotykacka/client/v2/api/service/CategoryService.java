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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Category;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/category
 */
public interface CategoryService {

    /**
     * Gets categories for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#get-categories
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return categories
     */
    @GET("v2/clouds/{cloudId}/categories")
    Call<Collection<Category>> findCategories(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                              @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets category by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#get-category
     *
     * @param cloudId    - cloud id
     * @param categoryId - categoryId id
     * @return category
     */
    @GET("v2/clouds/{cloudId}/categories/{categoryId}")
    Call<Category> findCategoryById(@Path("cloudId") Long cloudId, @Path("categoryId") Long categoryId);

    /**
     * Creates categories for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#create-category
     *
     * @param cloudId    - cloud id
     * @param categories - categories to be created, max 100 categories
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/categories")
    Call<Void> createCategory(@Path("cloudId") Long cloudId, @Body Collection<Category> categories);

    /**
     * Replaces or creates categories in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#replace-or-create-categories
     *
     * @param cloudId    - cloud id
     * @param categories - categories to be replaced, max 100 categories
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/categories")
    Call<Void> replaceCategories(@Path("cloudId") Long cloudId, @Body Collection<Category> categories);

    /**
     * Replaces or creates category for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#replace-or-create-category
     *
     * @param cloudId    - cloud id
     * @param categoryId - id of the category to be replaced
     * @param category   - category to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/categories/{categoryId}")
    Call<Void> replaceCategory(@Path("cloudId") Long cloudId, @Path("categoryId") Long categoryId, @Body Category category);

    /**
     * Updates category by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/category#partial-update-of-category
     *
     * @param cloudId    - cloud id
     * @param categoryId - id of the category to be updated
     * @param category   - category to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/categories/{categoryId}")
    Call<Void> updateCategory(@Path("cloudId") Long cloudId, @Path("categoryId") Long categoryId, @Body Category category);

    /**
     * @param cloudId    - cloud id
     * @param categoryId - category id
     * @return void Call
     */
    @GET("v2/clouds/{cloudId}/categories/{categoryId}")
    Call<Void> deleteCategory(@Path("cloudId") Long cloudId, @Path("categoryId") Long categoryId);
}
