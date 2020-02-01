package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.TableSeat;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.TableSeatService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class TableSeatServiceFacade extends DotykackaApiServiceFacade<TableSeatService> {
    protected BatchLoader batchLoader;
    public TableSeatServiceFacade(Long cloudId, TableSeatService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public TableSeat getTableSeat(Long branchId, Long id) {
        var out = execute(service.getTableSeat(cloudId, branchId, id));
        return out;
    }

    public Collection<TableSeat> getTableSeats(Long branchId, int limit, int offset, String sort) {
        var out = execute(service.getTableSeats(cloudId, branchId, limit, offset, sort));
        return out;
    }

    public Collection<TableSeat> getTableSeats(Long branchId, int limit, int offset) {
        var out = getTableSeats(branchId, limit, offset, null);
        return out;
    }

    public Collection<TableSeat> getTableSeats(Long branchId, String sort) {
        var out = batchLoader.load(page -> getTableSeats(branchId, page.limit, page.offset, sort));
        return out;
    }

    public Collection<TableSeat> getTableSeats(Long branchId) {
        var out = getTableSeats(branchId,null);
        return out;
    }
}
