
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VatInfo {
    @JsonProperty("rate")
    public Double rate;
    @JsonProperty("base")
    public Double base;
    @JsonProperty("value")
    public Double value;
}
