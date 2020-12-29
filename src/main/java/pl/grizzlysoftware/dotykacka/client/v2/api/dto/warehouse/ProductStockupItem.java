package pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/warehouse#stockup-schema
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockupItem {
    @JsonProperty("externalid")
    public Long externalId;

    @JsonProperty("_productId")
    public Long productId;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("purchasePrice")
    public Double netPurchasePrice; //TODO this is my assumption that this is net value

    @JsonProperty("sellPrice")
    public Double grossSellPrice;
}
