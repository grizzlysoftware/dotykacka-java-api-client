package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Reservation;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.ReservationService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ReservationServiceFacade extends DotykackaApiServiceFacade<ReservationService> {
    protected BatchLoader batchLoader;
    public ReservationServiceFacade(Long cloudId, ReservationService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createReservation(Reservation reservation) {
        execute(service.createReservation(cloudId, asList(reservation)));
    }

    public void createReservations(Collection<Reservation> reservations) {
        execute(service.createReservation(cloudId, reservations));
    }
    
    public void replaceReservation(Reservation reservation) {
        execute(service.replaceReservation(cloudId, reservation.id, reservation));
    }

    public void replaceReservations(Collection<Reservation> reservations) {
        execute(service.replaceReservations(cloudId, reservations));
    }

    public void updateReservation(Reservation reservation) {
        execute(service.updateReservation(cloudId, reservation.id, reservation));
    }

    public void deleteReservation(Long reservationId) {
        execute(service.deleteReservation(cloudId, reservationId));
    }

    public Reservation findReservationById(Long id) {
        var out = execute(service.findReservationById(cloudId, id));
        return out;
    }

    public Collection<Reservation> findReservations(int limit, int offset, String filter, String sort) {
        var out = execute(service.findReservations(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Reservation> findReservations(int limit, int offset) {
        var out = findReservations(limit, offset, null, null);
        return out;
    }

    public Collection<Reservation> findAllReservations(String sort) {
        var out = batchLoader.load(page -> findReservations(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Reservation> findAllReservations() {
        var out = findAllReservations(null);
        return out;
    }
}
