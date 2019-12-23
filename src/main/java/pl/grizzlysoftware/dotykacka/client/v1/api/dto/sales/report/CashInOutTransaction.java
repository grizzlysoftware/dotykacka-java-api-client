package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashInOutTransaction {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("dir")
    public Boolean dir;
    @JsonProperty("created")
    public Long created;
    @JsonProperty("employee")
    public Employee employee;
    @JsonProperty("value")
    public Double value;
    @JsonProperty("note")
    public String note;
}
