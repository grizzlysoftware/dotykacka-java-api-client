package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer.Customer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface CustomerService {
    @GET("{cloudId}/{id}")
    Call<Customer> getCustomer(@Path("cloudId") String cloudId, @Path("id") Long id);

    @GET("{cloudId}")
    Call<Collection<Customer>> getCustomers(@Path("cloudId") String cloudId);

    @POST("{cloudId}/create")
    Call<Void> createCustomer(@Path("cloudId") String cloudId, Customer consumer);

    @GET("{cloudId}/{id}")
    Call<Void> deleteCustomer(@Path("cloudId") String cloudId, @Path("id") Long id, @Query("anonymize") Boolean anonymizeCustomer);

    @POST("{cloudid}/{id}/update")
    Call<Void> updateCustomer(@Path("cloudId") String cloudId, @Path("id") Long id, Customer consumer);
}
