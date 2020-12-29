package pl.grizzlysoftware.dotykacka.client.v2.api.dto.warehouse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/warehouse#warehouse-schema
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Warehouse {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Integer cloudiId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("versiondate")
    public Long versionDate;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("enabled")
    public Boolean isEnabled;

    @JsonProperty("hexColor")
    public String hexColor;
}
