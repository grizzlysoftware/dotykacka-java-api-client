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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Customer;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface CustomerService {

    /**
     * Gets customers for given cloud
     *
     * https://docs.api.dotypos.com/entity/customer#get-customers
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return
     */
    @GET("v2/clouds/{cloudId}/customers")
    Call<Collection<Customer>> findCustomers(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                              @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets customer by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/customer#get-customer
     *
     * @param cloudId    - cloud id
     * @param customerId - customerId id
     * @return
     */
    @GET("v2/clouds/{cloudId}/customers/{customerId}")
    Call<Customer> findCustomerById(@Path("cloudId") Long cloudId, @Path("customerId") Long customerId);


    /**
     * Creates customers for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/customer#create-customer
     *
     * @param cloudId    - cloud id
     * @param customers - customers to be created, max 100 customers
     * @return
     */
    @POST("v2/clouds/{cloudId}/customers")
    Call<Void> createCustomer(@Path("cloudId") Long cloudId, @Body Collection<Customer> customers);

    /**
     * Replaces or creates customers in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/customer#replace-or-create-customers
     *
     * @param cloudId    - cloud id
     * @param customers - customers to be replaced, max 100 customers
     * @return
     */
    @PUT("v2/clouds/{cloudId}/customers")
    Call<Void> replaceCustomers(@Path("cloudId") Long cloudId, @Body Collection<Customer> customers);

    /**
     * Replaces or creates customer for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/customer#replace-or-create-customer
     *
     * @param cloudId    - cloud id
     * @param customerId - id of the customer to be replaced
     * @param customer   - customer to be replaced
     * @return
     */
    @PUT("v2/clouds/{cloudId}/customers/{customerId}")
    Call<Void> replaceCustomer(@Path("cloudId") Long cloudId, @Path("customerId") Long customerId, @Body Customer customer);

    /**
     * Updates customer by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/customer#partial-update-of-customer
     *
     * @param cloudId    - cloud id
     * @param customerId - id of the customer to be updated
     * @param customer   - customer to be updated
     * @return
     */
    @PATCH("v2/clouds/{cloudId}/customers/{customerId}")
    Call<Void> updateCustomer(@Path("cloudId") Long cloudId, @Path("customerId") Long customerId, @Body Customer customer);

    /**
     * @param cloudId    - cloud id
     * @param customerId - customer id
     * @return
     */
    @GET("v2/clouds/{cloudId}/customers/{customerId}")
    Call<Void> deleteCustomer(@Path("cloudId") Long cloudId, @Path("customerId") Long customerId);
}
