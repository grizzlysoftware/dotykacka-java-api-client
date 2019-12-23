
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyTransactionInfo {
    @JsonProperty("saleCount")
    public Integer saleCount;
    @JsonProperty("saleValue")
    public Double saleValue;
    @JsonProperty("cancelCount")
    public Integer cancelCount;
    @JsonProperty("cancelValue")
    public Object cancelValue;
    @JsonProperty("cashAdvanceCount")
    public Integer cashAdvanceCount;
    @JsonProperty("cashAdvanceValue")
    public Object cashAdvanceValue;
    @JsonProperty("cashInCount")
    public Integer cashInCount;
    @JsonProperty("cashInValue")
    public Object cashInValue;
    @JsonProperty("cashOutCount")
    public Integer cashOutCount;
    @JsonProperty("cashOutValue")
    public Double cashOutValue;
}
