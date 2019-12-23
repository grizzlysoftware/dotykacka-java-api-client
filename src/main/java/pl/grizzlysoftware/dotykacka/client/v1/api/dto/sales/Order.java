package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class Order {
    @JsonProperty("order")
    public OrderDetails orderDetails;

    @JsonProperty("receipts")
    public Collection<Long> receiptItemIds;
}
