package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Table;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.TableService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class TableServiceFacade extends DotykackaApiServiceFacade<TableService> {
    protected BatchLoader batchLoader;

    public TableServiceFacade(Long cloudId, TableService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Table findTableById(Long id) {
        var out = execute(service.findTableById(cloudId, id));
        return out;
    }

    public Collection<Table> findTables(int limit, int offset, String filter, String sort) {
        var out = execute(service.findTables(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Table> findTables(int limit, int offset) {
        var out = findTables(limit, offset, null, null);
        return out;
    }

    public Collection<Table> findAllTables(String sort) {
        var out = batchLoader.load(page -> findTables(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Table> findAllTables() {
        var out = findAllTables(null);
        return out;
    }
}
