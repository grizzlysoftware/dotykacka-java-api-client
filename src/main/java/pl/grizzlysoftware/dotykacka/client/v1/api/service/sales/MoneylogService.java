package pl.grizzlysoftware.dotykacka.client.v1.api.service.sales;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.Moneylog;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.Shift;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface MoneylogService {

    /**
     * @param cloudId  - cloud id
     * @param branchId - branch id
     * @param moneylogId  - id of the moneylog
     * @return
     */
    @GET("{cloudId}/{branchId}/{moneylogId}")
    Call<Moneylog> getMoneylogById(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Path("moneylogId") Long moneylogId);

    /**
     * @param cloudId   - cloud id
     * @param dateRange - Date in format: [from]-[to] yyyy/MM/dd-yyyy/MM/dd | Timestamp in format: [start]-[end]: Long-Long
     * @param dateField - Name of the field for given dateRange filter //created,versiondate
     * @param limit     - pagination parameter, default = 100, max = 100
     * @param offset    - pagination parameter, default = 0
     * @param sort      - Description: Sort parameters in format: column_name1,column_name2 //means asc -column_name1,-column_name2 //means desc
     * @return
     */
    @GET("list/{cloudId}")
    Call<Collection<Moneylog>> getMoneylogs(@Path("cloudId") Integer cloudId, @Query("dateRange") String dateRange, @Query("dateField") String dateField, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);

    /**
     * @param cloudId   - cloud id
     * @param branchId  - branch id
     * @param dateRange - Date in format: [from]-[to] yyyy/MM/dd-yyyy/MM/dd | Timestamp in format: [start]-[end]: Long-Long
     * @param dateField - Name of the field for given dateRange filter //created,versiondate
     * @param limit     - pagination parameter, default = 100, max = 100
     * @param offset    - pagination parameter, default = 0
     * @param sort      - Description: Sort parameters in format: column_name1,column_name2 //means asc -column_name1,-column_name2 //means desc
     * @return
     */
    @GET("list/{cloudId}/{branchId}")
    Call<Collection<Moneylog>> getMoneylogs(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Query("dateRange") String dateRange, @Query("dateField") String dateField, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);

    /**
     * @param cloudId   - cloud id
     * @param branchId  - branch id
     * @param limit     - pagination parameter, default = 100, max = 100
     * @param offset    - pagination parameter, default = 0
     * @return
     */
    @GET("shifts/{cloudId}/{branchId}")
    Call<Collection<Shift>> getShiftRanges(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Query("limit") Integer limit, @Query("offset") Integer offset);

}
