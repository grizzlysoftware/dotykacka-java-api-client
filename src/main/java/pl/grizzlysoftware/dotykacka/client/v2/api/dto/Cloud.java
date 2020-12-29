package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cloud {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("_companyId")
    public Long companyId;

    @JsonProperty("1ClickId")
    public Integer oneClickId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("restricted")
    public Boolean isRestricted;

    @JsonProperty("expired")
    public Boolean isExpired;

    @JsonProperty("segment")
    public String segment;

    @JsonProperty("country")
    public String country;
}
