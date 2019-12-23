
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount {
    @JsonProperty("employee")
    public Employee employee;
    @JsonProperty("count")
    public Integer count;
    @JsonProperty("value")
    public Double value;
    @JsonProperty("valueWithoutVat")
    public Double valueWithoutVat;
}
