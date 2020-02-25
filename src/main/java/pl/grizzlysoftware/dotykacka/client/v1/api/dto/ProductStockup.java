package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.grizzlysoftware.util.NumericBooleanDeserializer;
import pl.grizzlysoftware.util.NumericBooleanSerializer;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockup {

    @JsonProperty("invoiceno")
    public String invoiceNumber;
    @JsonProperty("note")
    public String note;
    @JsonProperty("supplierid")
    public Long supplierId;
    @JsonProperty("updatenc")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    public boolean updateSellPrice;
    @JsonProperty("items")
    public Collection<ProductStockupItem> stockupItems;
}
