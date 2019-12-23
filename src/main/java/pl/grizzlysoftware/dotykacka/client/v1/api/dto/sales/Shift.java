package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shift {
    @JsonProperty("start")
    public Long startTime;
    @JsonProperty("end")
    public Long endTime;
    @JsonProperty("name")
    public String employeeName;
}
