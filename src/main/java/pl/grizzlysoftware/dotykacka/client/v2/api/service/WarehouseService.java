package pl.grizzlysoftware.dotykacka.client.v2.api.service;

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.ProductStockInfo;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.ProductStockup;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse.Warehouse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/warehouse
 */
public interface WarehouseService {

    /**
     * Gets warehouse by its id from given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#get-warehouse
     *
     * @param cloudId     - id of the cloud
     * @param warehouseId - id of the warehouse to be returned
     * @return
     */
    @GET("v2/clouds/{cloudId}/warehouses/{warehouseId}")
    Call<Warehouse> findWarehouseById(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId);

    /**
     * Gets warehouses from given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#get-warehouses
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return
     */
    @GET("v2/clouds/{cloudId}/warehouses")
    Call<Collection<Warehouse>> findWarehouses(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                               @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Creates a warehouse in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#create-new-warehouse
     *
     * @param cloudId   - cloud id
     * @param warehouse - warehouse to be created
     * @return
     */
    @POST("v2/clouds/{cloudId}/warehouses")
    Call<Warehouse> createWarehouse(@Path("cloudId") Long cloudId, @Body Warehouse warehouse);

    /**
     * Replaces a warehouse in given cloud
     *
     * https://docs.api.dotypos.com/entity/warehouse#replace-a-single-warehouse
     *
     * @param cloudId     - cloud id
     * @param warehouse   - warehouse to be replaced
     * @return
     */
    @PUT("v2/clouds/{cloudId}/warehouses")
    Call<Warehouse> replaceWarehouse(@Path("cloudId") Long cloudId, @Body Warehouse warehouse);

    /**
     * Replaces a warehouses in given cloud
     *
     * https://docs.api.dotypos.com/entity/warehouse#replace-many-warehouses
     *
     * @param cloudId     - cloud id
     * @param warehouses   - warehouses to be replaced
     * @return
     */
    @PUT("v2/clouds/{cloudId}/warehouses")
    Call<Collection<Warehouse>> replaceWarehouses(@Path("cloudId") Long cloudId, @Body Collection<Warehouse> warehouses);

    /**
     * Updates a warehouse by id in given cloud
     *
     * https://docs.api.dotypos.com/entity/warehouse#update-a-single-warehouse
     *
     * @param cloudId     - cloud id
     * @param warehouseId - warehouse id to be updated
     * @param warehouse   - warehouse to be updated
     * @return
     */
    @PATCH("v2/clouds/{cloudId}/warehouses/{warehouseId}")
    Call<Warehouse> updateWarehouse(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId, @Body Warehouse warehouse);

    /**
     * Deletes a warehouse by id in given cloud
     *
     * https://docs.api.dotypos.com/entity/warehouse#delete-a-single-warehouse
     *
     * @param cloudId     - cloud id
     * @param warehouseId - warehouse id to be deleted
     * @return
     */
    @DELETE("v2/clouds/{cloudId}/warehouses/{warehouseId}")
    Call<Warehouse> deleteWarehouse(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId);

    /**
     * Creates a stockup for in certain warehouse in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#stockup-to-warehouse
     *
     * @param cloudId     - id of the cloud
     * @param warehouseId - id of the warehouse to which products should be stocked up
     * @param stockup     - stockup information
     * @return
     */
    @POST("v2/clouds/{cloudId}/warehouses/{warehouseId}/stockups")
    Call<Void> stockupProducts(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId, @Body ProductStockup stockup);

    /**
     * Gets information about product stock statuses in certain warehouse for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#products-on-warehouse
     *
     * @param cloudId     - id of the cloud
     * @param warehouseId - id of the warehouse to be searched
     * @return
     */
    @GET("v2/clouds/{cloudId}/warehouses/{warehouseId}/products")
    Call<Collection<ProductStockInfo>> findWarehouseProductStockInfos(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId);

    /**
     * Gets information about product stock status in certain warehouse for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/warehouse#product-on-warehouse
     *
     * @param cloudId     - id of the cloud
     * @param warehouseId - id of the warehouse to be searched
     * @param productId   - id of the product
     * @return
     */
    @GET("v2/clouds/{cloudId}/warehouses/{warehouseId}/products/{productId}")
    Call<Collection<ProductStockInfo>> findWarehouseProductStockInfoByProductId(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId,
                                                                    @Path("productId") Long productId);
}
