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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.WarehouseBranch;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/warehouse-branches
 */
public interface WarehouseBranchService {

    /**
     * Gets warehouseBranches for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#get-warehouse-branches
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return warehouse branches
     */
    @GET("v2/clouds/{cloudId}/warehouse-branches")
    Call<Collection<WarehouseBranch>> findWarehouseBranches(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                                            @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets warehouseBranch by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#get-warehouse-branch
     *
     * @param cloudId           - cloud id
     * @param warehouseBranchId - warehouseBranchId id
     * @return warehouse branch
     */
    @GET("v2/clouds/{cloudId}/warehouse-branches/{warehouseBranchId}")
    Call<WarehouseBranch> findWarehouseBranchById(@Path("cloudId") Long cloudId, @Path("warehouseBranchId") Long warehouseBranchId);


    /**
     * Creates warehouseBranches for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#replace-many-warehouse-branches
     *
     * @param cloudId           - cloud id
     * @param warehouseBranches - warehouseBranches to be created, max 100 warehouseBranches
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/warehouse-branches")
    Call<Void> createWarehouseBranch(@Path("cloudId") Long cloudId, @Body Collection<WarehouseBranch> warehouseBranches);

    /**
     * Replaces or creates warehouse-branches in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#replace-a-single-warehouse-branch
     *
     * @param cloudId           - cloud id
     * @param warehouseBranches - warehouseBranches to be replaced, max 100 warehouseBranches
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/warehouse-branches")
    Call<Void> replaceWarehouseBranches(@Path("cloudId") Long cloudId, @Body Collection<WarehouseBranch> warehouseBranches);

    /**
     * Replaces or creates warehouseBranch for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#replace-or-create-warehouse-branches
     *
     * @param cloudId           - cloud id
     * @param warehouseBranchId - id of the warehouseBranch to be replaced
     * @param warehouseBranch   - warehouseBranch to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/warehouse-branches/{warehouseBranchId}")
    Call<Void> replaceWarehouseBranch(@Path("cloudId") Long cloudId, @Path("warehouseBranchId") Long warehouseBranchId, @Body WarehouseBranch warehouseBranch);

    /**
     * Updates warehouseBranch by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse-branches#update-a-single-warehouse-branch
     *
     * @param cloudId           - cloud id
     * @param warehouseBranchId - id of the warehouseBranch to be updated
     * @param warehouseBranch   - warehouseBranch to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/warehouse-branches/{warehouseBranchId}")
    Call<Void> updateWarehouseBranch(@Path("cloudId") Long cloudId, @Path("warehouseBranchId") Long warehouseBranchId, @Body WarehouseBranch warehouseBranch);
}
