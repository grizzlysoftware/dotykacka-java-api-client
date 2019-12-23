
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagSale {
    @JsonProperty("value")
    public Double value;
    @JsonProperty("valueWithoutNonPurchase")
    public Object valueWithoutNonPurchase;
    @JsonProperty("purchaseValue")
    public Double purchaseValue;
    @JsonProperty("valueWithoutVAT")
    public Double valueWithoutVAT;
    @JsonProperty("valueWithoutNonPurchaseWithoutVAT")
    public Object valueWithoutNonPurchaseWithoutVAT;
    @JsonProperty("purchaseValueWithoutVAT")
    public Double purchaseValueWithoutVAT;
    @JsonProperty("name")
    public String name;
}
