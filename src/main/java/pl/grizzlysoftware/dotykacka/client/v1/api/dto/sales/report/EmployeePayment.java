
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePayment {
    @JsonProperty("employeeId")
    public Long employeeId;
    @JsonProperty("employeeName")
    public String employeeName;
    @JsonProperty("paymentMethodId")
    public Integer paymentMethodId;
    @JsonProperty("count")
    public Integer count;
    @JsonProperty("total")
    public Integer total;
}
