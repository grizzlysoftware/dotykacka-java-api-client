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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Supplier;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/supplier
 */
public interface SupplierService {

    /**
     * Gets suppliers for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#get-suppliers
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return suppliers
     */
    @GET("v2/clouds/{cloudId}/suppliers")
    Call<Collection<Supplier>> findSuppliers(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                             @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets supplier by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#get-supplier
     *
     * @param cloudId    - cloud id
     * @param supplierId - supplierId id
     * @return supplier
     */
    @GET("v2/clouds/{cloudId}/suppliers/{supplierId}")
    Call<Supplier> findSupplierById(@Path("cloudId") Long cloudId, @Path("supplierId") Long supplierId);


    /**
     * Creates suppliers for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#create-supplier
     *
     * @param cloudId   - cloud id
     * @param suppliers - suppliers to be created, max 100 suppliers
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/suppliers")
    Call<Void> createSupplier(@Path("cloudId") Long cloudId, @Body Collection<Supplier> suppliers);

    /**
     * Replaces or creates suppliers in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#replace-or-create-suppliers
     *
     * @param cloudId   - cloud id
     * @param suppliers - suppliers to be replaced, max 100 suppliers
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/suppliers")
    Call<Void> replaceSuppliers(@Path("cloudId") Long cloudId, @Body Collection<Supplier> suppliers);

    /**
     * Replaces or creates supplier for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#replace-or-create-supplier
     *
     * @param cloudId    - cloud id
     * @param supplierId - id of the supplier to be replaced
     * @param supplier   - supplier to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/suppliers/{supplierId}")
    Call<Void> replaceSupplier(@Path("cloudId") Long cloudId, @Path("supplierId") Long supplierId, @Body Supplier supplier);

    /**
     * Updates supplier by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/suppliers#partial-update-of-supplier
     *
     * @param cloudId    - cloud id
     * @param supplierId - id of the supplier to be updated
     * @param supplier   - supplier to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/suppliers/{supplierId}")
    Call<Void> updateSupplier(@Path("cloudId") Long cloudId, @Path("supplierId") Long supplierId, @Body Supplier supplier);

    /**
     * @param cloudId    - cloud id
     * @param supplierId - supplier id
     * @return void Call
     */
    @GET("v2/clouds/{cloudId}/suppliers/{supplierId}")
    Call<Void> deleteSupplier(@Path("cloudId") Long cloudId, @Path("supplierId") Long supplierId);
}
