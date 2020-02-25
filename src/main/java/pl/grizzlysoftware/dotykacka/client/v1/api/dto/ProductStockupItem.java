package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pl.grizzlysoftware.util.NumericBooleanDeserializer;
import pl.grizzlysoftware.util.NumericBooleanSerializer;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockupItem {

    @JsonProperty("ean")
    public String ean;
    @JsonProperty("externalid")
    public Long externalId;
    @JsonProperty("productid")
    public Long productId;
    @JsonProperty("quantity")
    public Double quantity;
    @JsonProperty("price")
    public Double netPurchasePrice;
    @JsonProperty("items")
    public Double grossSellPrice;
    @JsonProperty("updatenc")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    public boolean updateSellPrice;
}
