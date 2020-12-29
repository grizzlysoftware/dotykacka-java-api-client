package pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse;

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
 *
 * https://docs.api.dotypos.com/entity/warehouse#stockup-schema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockup {

    @JsonProperty("invoiceNumber")
    public String invoiceNumber;

    @JsonProperty("_supplierid")
    public Long supplierId;

    @JsonProperty("note")
    public String note;

    @JsonProperty("updatePurchasePrice")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    public boolean updatePurchasePrice;

    @JsonProperty("items")
    public Collection<ProductStockupItem> stockupItems;
}
