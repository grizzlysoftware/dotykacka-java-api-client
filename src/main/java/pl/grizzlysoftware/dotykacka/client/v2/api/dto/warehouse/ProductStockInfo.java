package pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * Product extension for warehousing purposes(stock tracking)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockInfo {
    //TODO to be extended from Product
    @JsonProperty("_warehouseId")
    public Long warehouseId;

    @JsonProperty("purchasePriceWithoutVat")
    public Double netPurchasePrice;

    @JsonProperty("stockQuantityStatus")
    public Double quantity;
}
