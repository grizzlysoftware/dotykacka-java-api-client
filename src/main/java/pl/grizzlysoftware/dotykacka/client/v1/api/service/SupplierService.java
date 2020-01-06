package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Supplier;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface SupplierService {
    @GET("{cloudId}/{id}")
    Call<Supplier> getSupplier(@Path("cloudId") Integer cloudId, @Path("id") Long id);

    @GET("{cloudId}")
    Call<Collection<Supplier>> getSuppliers(@Path("cloudId") Integer cloudId, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);

    @GET("{cloudId}/{id}/delete")
    Call<Supplier> deleteSupplier(@Path("cloudId") Integer cloudId, @Path("id") Long id, @Query("anonymize") Boolean anonymizeSupplier);

    @POST("{cloudId}/{id}/update")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    Call<Supplier> updateSupplier(@Path("cloudId") Integer cloudId, @Path("id") Long id, @Body Supplier supplier);
    
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    @POST("{cloudId}/create")
    Call<Supplier> createSupplier(@Path("cloudId") Integer cloudId, @Body Supplier supplier);

}
