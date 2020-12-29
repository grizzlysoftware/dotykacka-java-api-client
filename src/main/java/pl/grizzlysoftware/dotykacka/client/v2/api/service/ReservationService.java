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

import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Reservation;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/reservation
 */
public interface ReservationService {

    /**
     * Gets reservations for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#get-reservations
     *
     * @param cloudId - id of the cloud
     * @param limit   - limits to certain amount of records
     * @param page    - returns certain page of data
     * @param filter  - filters (??)
     * @param sort    - sorting (??)
     * @return
     */
    @GET("v2/clouds/{cloudId}/reservations")
    Call<Collection<Reservation>> findReservations(@Path("cloudId") Long cloudId, @Query("limit") Integer limit,
                                             @Query("page") Integer page, @Query("filter") String filter, @Query("sort") String sort);

    /**
     * Gets reservation by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#get-reservation
     *
     * @param cloudId    - cloud id
     * @param reservationId - reservationId id
     * @return
     */
    @GET("v2/clouds/{cloudId}/reservations/{reservationId}")
    Call<Reservation> findReservationById(@Path("cloudId") Long cloudId, @Path("reservationId") Long reservationId);


    /**
     * Creates reservations for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#create-reservation
     *
     * @param cloudId   - cloud id
     * @param reservations - reservations to be created, max 100 reservations
     * @return
     */
    @POST("v2/clouds/{cloudId}/reservations")
    Call<Void> createReservation(@Path("cloudId") Long cloudId, @Body Collection<Reservation> reservations);

    /**
     * Replaces or creates reservations in given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#replace-or-create-reservations
     *
     * @param cloudId   - cloud id
     * @param reservations - reservations to be replaced, max 100 reservations
     * @return
     */
    @PUT("v2/clouds/{cloudId}/reservations")
    Call<Void> replaceReservations(@Path("cloudId") Long cloudId, @Body Collection<Reservation> reservations);

    /**
     * Replaces or creates reservation for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#replace-or-create-reservation
     *
     * @param cloudId    - cloud id
     * @param reservationId - id of the reservation to be replaced
     * @param reservation   - reservation to be replaced
     * @return
     */
    @PUT("v2/clouds/{cloudId}/reservations/{reservationId}")
    Call<Void> replaceReservation(@Path("cloudId") Long cloudId, @Path("reservationId") Long reservationId, @Body Reservation reservation);

    /**
     * Updates reservation by id for given cloud
     * <p>
     * https://docs.api.dotypos.com/entity/reservation#partial-update-of-reservation
     *
     * @param cloudId    - cloud id
     * @param reservationId - id of the reservation to be updated
     * @param reservation   - reservation to be updated
     * @return
     */
    @PATCH("v2/clouds/{cloudId}/reservations/{reservationId}")
    Call<Void> updateReservation(@Path("cloudId") Long cloudId, @Path("reservationId") Long reservationId, @Body Reservation reservation);

    /**
     * @param cloudId    - cloud id
     * @param reservationId - reservation id
     * @return
     */
    @GET("v2/clouds/{cloudId}/reservations/{reservationId}")
    Call<Void> deleteReservation(@Path("cloudId") Long cloudId, @Path("reservationId") Long reservationId);
}
