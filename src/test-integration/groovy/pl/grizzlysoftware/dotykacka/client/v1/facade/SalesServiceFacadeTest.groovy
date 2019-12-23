package pl.grizzlysoftware.dotykacka.client.v1.facade


import pl.grizzlysoftware.dotykacka.client.v1.api.service.sales.*
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification

import java.time.LocalDateTime

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.SALES
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class SalesServiceFacadeTest extends DotykackaSecureServiceSpecification {
    SalesServiceFacade facade

    @Override
    void setup() {
        facade = new SalesServiceFacade(CLOUD_ID,
                service(httpClient(), API_URL + SALES.RECEIPT, ReceiptService.class),
                service(httpClient(), API_URL + SALES.ORDER, OrderService.class),
                service(httpClient(), API_URL + SALES.ORDER_OPEN, OrderOpenService.class),
                service(httpClient(), API_URL + SALES.MONEYLOG, MoneylogService.class),
                service(httpClient(), API_URL + SALES.SALES, SalesService.class),
        )
    }

    def "gets moneylog by id for branch"() {
        when:
            def moneylog = facade.getMoneylog(BRANCH_ID, MONEYLOG_ID)
        then:
            moneylog != null
    }

    def "gets moneylogs for cloud"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def moneylogs = facade.getMoneylogs(day, day, "created")
        then:
            moneylogs != null
    }

    def "gets moneylogs for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def moneylogs = facade.getMoneylogs(BRANCH_ID, day, day, "created")
        then:
            moneylogs != null
    }

    def "gets shift ranges"() {
        when:
            def shifts = facade.getShiftRanges(BRANCH_ID)
        then:
            shifts != null
    }

    def "gets order"() {
        when:
            def order = facade.getOrder(ORDER_ID)
        then:
            order != null
            order.orderDetails.id == ORDER_ID
    }

    def "gets order for branch"() {
        when:
            def order = facade.getOrder(BRANCH_ID, ORDER_ID)
        then:
            order != null
            order.orderDetails.id == ORDER_ID
    }

    def "gets orders for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def orders = facade.getOrders(BRANCH_ID, day, day, "inserted", 100, 0, null)
        then:
            orders != null
    }

    def "gets all orders for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def orders = facade.getOrders(BRANCH_ID, day, day, "inserted")
        then:
            orders != null
    }

    def "gets all orders"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def orders = facade.getOrders(day, day, "inserted")
        then:
            orders != null
    }

    def "gets open orders for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def openOrders = facade.getOpenOrders(BRANCH_ID, day, day, "inserted", 100, 0, null)
        then:
            openOrders != null
    }

    def "gets all open orders for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def openOrders = facade.getOpenOrders(BRANCH_ID, day, day, "inserted")
        then:
            openOrders != null
    }

    def "gets sales report for branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def salesReport = facade.getSalesReport(BRANCH_ID, day, day, true)
        then:
            salesReport != null
    }

    def "gets receipt item"() {
        when:
            def receiptItem = facade.getReceiptItem(RECEIPT_ITEM_ID)
        then:
            receiptItem != null
    }

    def "gets receipt items"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def receiptItems = facade.getReceiptItems(day, day, 100, 0, "")
        then:
            receiptItems != null
    }

    def "gets receipt items for certain branch"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def receiptItems = facade.getReceiptItems(BRANCH_ID, day, day, 100, 0, "")
        then:
            receiptItems != null
    }

    def "gets all receipt items"() {
        given:
            def day = LocalDateTime.of(2019, 12, 22, 00, 00, 00, 00)
        when:
            def receiptItems = facade.getReceiptItems(day, day)
        then:
            receiptItems != null
    }
}
