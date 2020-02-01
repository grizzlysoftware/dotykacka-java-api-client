package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Employee;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface EmployeeService {
    @GET("{cloudId}/{id}")
    Call<Employee> getEmployee(@Path("cloudId") Long cloudId, @Path("id") Long id);

    @GET("{cloudId}")
    Call<Collection<Employee>> getEmployees(@Path("cloudId") Long cloudId, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("sort") String sort);

    @POST("{cloudId}/{id}/update")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    Call<Employee> updateEmployee(@Path("cloudId") Long cloudId, @Path("id") Long id, @Body Employee employee);

    @GET("{cloudId}/{id}/delete")
    Call<Employee> deleteEmployee(@Path("cloudId") Long cloudId, @Path("id") Long id, @Query("anonymize") Boolean anonymizeEmployee);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    @POST("{cloudId}/create")
    Call<Employee> createEmployee(@Path("cloudId") Long cloudId, @Body Employee employee);
}
