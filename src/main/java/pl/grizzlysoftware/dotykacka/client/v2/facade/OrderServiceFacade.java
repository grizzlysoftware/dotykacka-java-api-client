package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Order;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.OrderService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OrderServiceFacade extends DotykackaApiServiceFacade<OrderService> {
    protected BatchLoader batchLoader;
    public OrderServiceFacade(Long OrderId, OrderService service) {
        super(OrderId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Order findOrderById(Long id) {
        var out = execute(service.findOrderById(cloudId, id));
        return out;
    }

    public Collection<Order> findOrders(int limit, int offset, String filter, String sort) {
        var out = execute(service.findOrders(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Order> findOrders(int limit, int offset) {
        var out = findOrders(limit, offset, null, null);
        return out;
    }

    public Collection<Order> findAllOrders(String sort) {
        var out = batchLoader.load(page -> findOrders(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Order> findAllOrders() {
        var out = findAllOrders(null);
        return out;
    }
}
