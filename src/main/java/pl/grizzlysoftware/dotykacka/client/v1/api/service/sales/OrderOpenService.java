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
    /**
     * @param cloudId - cloud id
     * @param branchId - branch id
     * @param dateRange - Date in format: [from]-[to] yyyy/MM/dd-yyyy/MM/dd | Timestamp in format: [start]-[end]: Long-Long
     * @param dateField - Name of the field for given dateRange filter //inserted,completed,versiondate,canceleddate
     * @param limit     - pagination parameter, default = 100, max = 100
     * @param offset    - pagination parameter, default = 0
     * @param sort      - Description: Sort parameters in format: column_name1,column_name2 //means asc -column_name1,-column_name2 //means desc
     * @return
     */
    @GET("{cloudId}/{branchId}")
    Call<Collection<Order>> getOpenOrders(@Path("cloudId") Long cloudId, @Path("branchId") Long branchId, @Query("dateRange") String dateRange, @Query("dateField") String dateField, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);
}
