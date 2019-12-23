
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Revenue {
    @JsonProperty("totalWithVat")
    public Double totalWithVat;
    @JsonProperty("totalVat")
    public Double totalVat;
    @JsonProperty("totalWithoutVat")
    public Double totalWithoutVat;
    @JsonProperty("vatInfo")
    public List<VatInfo> vatInfo;
    @JsonProperty("paymentTypeInfo")
    public List<PaymentTypeInfo> paymentTypeInfo;
}
