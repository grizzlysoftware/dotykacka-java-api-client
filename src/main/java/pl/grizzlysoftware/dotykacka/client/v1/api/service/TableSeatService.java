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

package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.TableSeat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface TableSeatService {
    /**
     * @param cloudId     - cloud id
     * @param branchId    - branch id
     * @param tableSeatId - tableSeat id
     * @return
     */
    @GET("{cloudId}/{branchId}/{tableSeatId}")
    Call<TableSeat> getTableSeat(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Path("tableSeatId") Long tableSeatId);

    /**
     * @param cloudId  - cloud id
     * @param branchId - branch id
     * @param offset   - pagination parameter, default = 0
     * @param limit    - pagination parameter, default = 100, max = 100
     * @param sort     - Description: Sort parameters in format: column_name1,column_name2 //means asc -column_name1,-column_name2 //means desc
     * @return
     */
    @GET("{cloudId}/{branchId}")
    Call<Collection<TableSeat>> getTableSeats(@Path("cloudId") Integer cloudId, @Path("branchId") Integer branchId, @Query("limit") int limit, @Query("offset") int offset, @Query("sort") String sort);
}
