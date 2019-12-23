package pl.grizzlysoftware.dotykacka.client.v1.api.service.sales;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report.SalesReport;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface SalesService {

    /**
     * @param cloudId   - cloud id
     * @param branchId  - branch id
     * @param dateRange - Date in format: [from]-[to] yyyy/MM/dd-yyyy/MM/dd | Timestamp in format: [start]-[end]: Long-Long
     * @param isVatPayer - Name of the field for given dateRange filter
     */
    @GET("report/{cloudId}/{branchId}")
    Call<SalesReport> getSalesReport(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Query("dateRange") String dateRange, @Query("vatPayer") Boolean isVatPayer);
}
