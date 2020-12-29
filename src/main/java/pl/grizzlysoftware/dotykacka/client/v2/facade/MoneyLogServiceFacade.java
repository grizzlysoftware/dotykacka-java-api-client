package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.v1.facade.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.MoneyLog;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.MoneyLogService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class MoneyLogServiceFacade extends DotykackaApiServiceFacade<MoneyLogService> {
    protected BatchLoader batchLoader;
    public MoneyLogServiceFacade(Long cloudId, MoneyLogService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public MoneyLog findMoneyLogById(Long id) {
        var out = execute(service.findMoneyLogById(cloudId, id));
        return out;
    }

    public Collection<MoneyLog> findMoneyLogs(int limit, int offset, String filter, String sort) {
        var out = execute(service.findMoneyLogs(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<MoneyLog> findMoneyLogs(int limit, int offset) {
        var out = findMoneyLogs(limit, offset, null, null);
        return out;
    }

    public Collection<MoneyLog> findAllMoneyLogs(String sort) {
        var out = batchLoader.load(page -> findMoneyLogs(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<MoneyLog> findAllMoneyLogs() {
        var out = findAllMoneyLogs(null);
        return out;
    }
}
