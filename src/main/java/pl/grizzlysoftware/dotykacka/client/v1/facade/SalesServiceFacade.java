package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.*;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report.SalesReport;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.sales.*;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class SalesServiceFacade extends BasicDotykackaApiServiceFacade {
    private static final DateTimeFormatter RECEIPTS_RANGE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final String RECEIPTS_RANGE_PATTERN = "%s-%s";

    protected ReceiptService receiptService;
    protected OrderService orderService;
    protected OrderOpenService orderOpenService;
    protected MoneylogService moneylogService;
    protected SalesService salesService;
    protected BatchLoader batchLoader;

    public SalesServiceFacade(Long cloudId, ReceiptService receiptService, OrderService orderService, OrderOpenService orderOpenService, MoneylogService moneylogService, SalesService salesService) {
        super(cloudId);
        this.receiptService = requireNonNull(receiptService);
        this.orderService = requireNonNull(orderService);
        this.orderOpenService = requireNonNull(orderOpenService);
        this.moneylogService = requireNonNull(moneylogService);
        this.salesService = requireNonNull(salesService);
        this.batchLoader = new BatchLoader(100);
    }

    public Moneylog getMoneylog(Long branchId, Long moneylogId) {
        var out = execute(moneylogService.getMoneylogById(cloudId, branchId, moneylogId));
        return out;
    }

    public Collection<Moneylog> getMoneylogs(LocalDateTime startDate, LocalDateTime endDate, String dateField, Integer limit, Integer offset, String sort) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(moneylogService.getMoneylogs(cloudId, dateRange, dateField, limit, offset, sort));
        return out;
    }

    public Collection<Moneylog> getMoneylogs(LocalDateTime startDate, LocalDateTime endDate, String dateField, String sort) {
        var out = batchLoader.load(page -> getMoneylogs(startDate, endDate, dateField, page.limit, page.offset, sort));
        return out;
    }

    public Collection<Moneylog> getMoneylogs(LocalDateTime startDate, LocalDateTime endDate, String dateField) {
        var out = getMoneylogs(startDate, endDate, dateField, null);
        return out;
    }

    public Collection<Moneylog> getMoneylogs(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, Integer limit, Integer offset, String sort) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(moneylogService.getMoneylogs(cloudId, branchId, dateRange, dateField, limit, offset, sort));
        return out;
    }

    public Collection<Moneylog> getMoneylogs(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, String sort) {
        var out = batchLoader.load(page -> getMoneylogs(branchId, startDate, endDate, dateField, page.limit, page.offset, sort));
        return out;
    }

    public Collection<Moneylog> getMoneylogs(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField) {
        var out = getMoneylogs(branchId, startDate, endDate, dateField, null);
        return out;
    }

    public Collection<Shift> getShiftRanges(Long branchId, Integer limit, Integer offset) {
        var out = execute(moneylogService.getShiftRanges(cloudId, branchId, limit, offset));
        return out;
    }

    public Collection<Shift> getShiftRanges(Long branchId) {
        var out = batchLoader.load(page -> getShiftRanges(branchId, page.limit, page.offset));
        return out;
    }

    public Order getOrder(Long orderId) {
        var out = execute(orderService.getOrderById(cloudId, orderId));
        return out;
    }

    public Order getOrder(Long branchId, Long orderId) {
        var out = execute(orderService.getOrderById(cloudId, branchId, orderId));
        return out;
    }

    public Collection<Order> getOrders(LocalDateTime startDate, LocalDateTime endDate, String dateField, Integer limit, Integer offset, String sort) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(orderService.getOrders(cloudId, dateRange, dateField, limit, offset, sort));
        return out;
    }

    public Collection<Order> getOrders(LocalDateTime startDate, LocalDateTime endDate, String dateField, String sort) {
        var out = batchLoader.load(page -> getOrders(startDate, endDate, dateField, page.limit, page.offset, sort));
        return out;
    }

    public Collection<Order> getOrders(LocalDateTime startDate, LocalDateTime endDate, String dateField) {
        var out = getOrders(startDate, endDate, dateField, null);
        return out;
    }

    public Collection<Order> getOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, Integer limit, Integer offset, String sort) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(orderService.getOrders(cloudId, branchId, dateRange, dateField, limit, offset, sort));
        return out;
    }

    public Collection<Order> getOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, String sort) {
        var out = batchLoader.load(page -> getOrders(branchId, startDate, endDate, dateField, page.limit, page.offset, sort));
        return out;
    }

    public Collection<Order> getOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField) {
        var out = getOrders(branchId, startDate, endDate, dateField, null);
        return out;
    }

    public Collection<Order> getOpenOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, Integer limit, Integer offset, String sort) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(orderOpenService.getOpenOrders(cloudId, branchId, dateRange, dateField, limit, offset, sort));
        return out;
    }

    public Collection<Order> getOpenOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField, String sort) {
        var out = batchLoader.load(page -> getOpenOrders(branchId, startDate, endDate, dateField, page.limit, page.offset, sort));
        return out;
    }

    public Collection<Order> getOpenOrders(Long branchId, LocalDateTime startDate, LocalDateTime endDate, String dateField) {
        var out = getOpenOrders(branchId, startDate, endDate, dateField, null);
        return out;
    }

    public SalesReport getSalesReport(Long branchId, LocalDateTime startDate, LocalDateTime endDate, Boolean isVatPayer) {
        var dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        var out = execute(salesService.getSalesReport(cloudId, branchId, dateRange, isVatPayer));
        return out;
    }

    public ReceiptItem getReceiptItem(Long receiptId) {
        var out = execute(receiptService.getReceiptItem(cloudId, receiptId));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(Integer limit, Integer offset, String sort) {
        var out = execute(receiptService.getReceiptItems(cloudId, null, ReceiptItemDateFields.COMPLETED.name, limit, offset, sort));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(LocalDateTime startDate, LocalDateTime endDate, Integer limit, Integer offset, String sort) {
        String dateRange;
        if (startDate == null || endDate == null) {
            dateRange = null;
        } else {
            dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        }
        var out = execute(receiptService.getReceiptItems(cloudId, dateRange, ReceiptItemDateFields.COMPLETED.name, limit, offset, sort));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(Long branchId, Integer limit, Integer offset, String sort) {
        var out = execute(receiptService.getReceiptItems(cloudId, branchId, null, ReceiptItemDateFields.COMPLETED.name, limit, offset, sort));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(Long branchId, LocalDateTime startDate, LocalDateTime endDate, Integer limit, Integer offset, String sort) {
        String dateRange;
        if (startDate == null || endDate == null) {
            dateRange = null;
        } else {
            dateRange = format(RECEIPTS_RANGE_PATTERN, RECEIPTS_RANGE_DATE_FORMATTER.format(startDate), RECEIPTS_RANGE_DATE_FORMATTER.format(endDate));
        }
        var out = execute(receiptService.getReceiptItems(cloudId, branchId, dateRange, ReceiptItemDateFields.COMPLETED.name, limit, offset, sort));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(LocalDateTime startDate, LocalDateTime endDate, String sort) {
        var out = batchLoader.load(page -> getReceiptItems(startDate, endDate, page.limit, page.offset, sort));
        return out;
    }

    public Collection<ReceiptItem> getReceiptItems(LocalDateTime startDate, LocalDateTime endDate) {
        var out = getReceiptItems(startDate, endDate, null);
        return out;
    }
}
