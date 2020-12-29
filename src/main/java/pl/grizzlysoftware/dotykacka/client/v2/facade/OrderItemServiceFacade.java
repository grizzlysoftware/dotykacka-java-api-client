package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.OrderItem;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.OrderItemService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class OrderItemServiceFacade extends DotykackaApiServiceFacade<OrderItemService> {
    protected BatchLoader batchLoader;
    public OrderItemServiceFacade(Long OrderItemId, OrderItemService service) {
        super(OrderItemId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public OrderItem findOrderItemById(Long id) {
        var out = execute(service.findOrderItemById(cloudId, id));
        return out;
    }

    public Collection<OrderItem> findOrderItems(int limit, int offset, String filter, String sort) {
        var out = execute(service.findOrderItems(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<OrderItem> findOrderItems(int limit, int offset) {
        var out = findOrderItems(limit, offset, null, null);
        return out;
    }

    public Collection<OrderItem> findAllOrderItems(String sort) {
        var out = batchLoader.load(page -> findOrderItems(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<OrderItem> findAllOrderItems() {
        var out = findAllOrderItems(null);
        return out;
    }
}
