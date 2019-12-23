package pl.grizzlysoftware.dotykacka.client.v1.api.service.sales;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface OrderOpenService {
    @GET("{cloudId}/{branchId}")
    Call<Collection<Order>> getOpenOrders(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Query("dateRange") String dateRange, @Query("dateField") String dateField, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);
}
