package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/branch#branch-schema
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Table {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_sellerId")
    public Long sellerId;

    @JsonProperty("_tableGroupId")
    public Long tableGroupId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("locationName")
    public String locationName;

    @JsonProperty("type")
    public String type;

    @JsonProperty("display")
    public Boolean isDisplayed;

    @JsonProperty("enabled")
    public Boolean isEnabled;

    @JsonProperty("seats")
    public Integer seatsCount;

    @JsonProperty("positionX")
    public Integer positionX;

    @JsonProperty("positionY")
    public Integer positionY;

    @JsonProperty("rotation")
    public Integer rotation;

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
