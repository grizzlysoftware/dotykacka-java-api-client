package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("_cloudId")
    public Long cloudId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("display")
    public Boolean isDisplayed;
    @JsonProperty("flags")
    public Integer flags;
    @JsonProperty("features")
    public Long features;
    @JsonProperty("created")
    public Long createdAt;
    @JsonProperty("versionDate")
    public Long updatedAt;
}
