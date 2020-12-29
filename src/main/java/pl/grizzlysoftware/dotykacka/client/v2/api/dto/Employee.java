package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Bartosz Pawłowski on 2019-07-01.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("maxDiscount")
    public Double maxDiscount;

    @JsonProperty("name")
    public String name;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("email")
    public String email;

    @JsonProperty("requirePinAlways")
    public Boolean isPinRequired;

    @JsonProperty("accessLevel")
    public Long accessLevel;

    @JsonProperty("stockAccessLevel")
    public Long stockAccessLevel;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("enabled")
    public Boolean isEnabled;

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("versionDate")
    public Long updatedAt;

    @JsonProperty("modifiedBy")
    public String updatedBy;
}
