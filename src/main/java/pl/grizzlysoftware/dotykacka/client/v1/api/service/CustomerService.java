package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer.Customer;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface CustomerService {
    @GET("{cloudId}/{id}")
    Call<Customer> getCustomer(@Path("cloudId") String cloudId, @Path("id") Long id);

    @GET("{cloudId}")
    Call<Collection<Customer>> getCustomers(@Path("cloudId") String cloudId, @Query("limit") Integer limit, @Query("offset") Integer offset);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    @POST("{cloudId}/create")
    Call<Customer> createCustomer(@Path("cloudId") String cloudId, @Body Customer consumer);

    @GET("{cloudId}/{id}/delete")
    Call<Customer> deleteCustomer(@Path("cloudId") String cloudId, @Path("id") Long id, @Query("anonymize") Boolean anonymizeCustomer);

    @POST("{cloudId}/{id}/update")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"})
    Call<Customer> updateCustomer(@Path("cloudId") String cloudId, @Path("id") Long id, @Body Customer consumer);
}
