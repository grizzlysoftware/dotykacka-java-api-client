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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Employee;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/employee
 */
public interface EmployeeService {

    /**
     * Gets employees for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#get-employees
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return employees
     */
    @GET("v2/clouds/{cloudId}/employees")
    Call<Collection<Employee>> findEmployees(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                             @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets employee by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#get-employee
     *
     * @param cloudId    - cloud id
     * @param employeeId - employeeId id
     * @return employee
     */
    @GET("v2/clouds/{cloudId}/employees/{employeeId}")
    Call<Employee> findEmployeeById(@Path("cloudId") Long cloudId, @Path("employeeId") Long employeeId);


    /**
     * Creates employees for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#create-employee
     *
     * @param cloudId   - cloud id
     * @param employees - employees to be created, max 100 employees
     * @return void Call
     */
    @POST("v2/clouds/{cloudId}/employees")
    Call<Void> createEmployee(@Path("cloudId") Long cloudId, @Body Collection<Employee> employees);

    /**
     * Replaces or creates employees in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#replace-or-create-employees
     *
     * @param cloudId   - cloud id
     * @param employees - employees to be replaced, max 100 employees
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/employees")
    Call<Void> replaceEmployees(@Path("cloudId") Long cloudId, @Body Collection<Employee> employees);

    /**
     * Replaces or creates employee for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#replace-or-create-employee
     *
     * @param cloudId    - cloud id
     * @param employeeId - id of the employee to be replaced
     * @param employee   - employee to be replaced
     * @return void Call
     */
    @PUT("v2/clouds/{cloudId}/employees/{employeeId}")
    Call<Void> replaceEmployee(@Path("cloudId") Long cloudId, @Path("employeeId") Long employeeId, @Body Employee employee);

    /**
     * Updates employee by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/employee#partial-update-of-employee
     *
     * @param cloudId    - cloud id
     * @param employeeId - id of the employee to be updated
     * @param employee   - employee to be updated
     * @return void Call
     */
    @PATCH("v2/clouds/{cloudId}/employees/{employeeId}")
    Call<Void> updateEmployee(@Path("cloudId") Long cloudId, @Path("employeeId") Long employeeId, @Body Employee employee);

    /**
     * @param cloudId    - cloud id
     * @param employeeId - employee id
     * @return void Call
     */
    @GET("v2/clouds/{cloudId}/employees/{employeeId}")
    Call<Void> deleteEmployee(@Path("cloudId") Long cloudId, @Path("employeeId") Long employeeId);
}
