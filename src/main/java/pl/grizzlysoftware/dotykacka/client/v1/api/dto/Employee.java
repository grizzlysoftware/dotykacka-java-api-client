package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {;
    @JsonProperty("id")
    public Long id;
    @JsonProperty("accesslevel")
    public Integer accessLevel;
    @JsonProperty("accesslevels")
    public List<String> accessLevels;
    @JsonProperty("accesspinshahash")
    public String accessPinShaHash;
    @JsonProperty("barcode")
    public String barcode;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("email")
    public String email;
    @JsonProperty("enabled")
    public Boolean isEnabled;
    @JsonProperty("flags")
    public Integer flags;
    @JsonProperty("hexcolor")
    public String hexColor;
    @JsonProperty("modifiedby")
    public String modifiedBy;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("requirepinalways")
    public Boolean requiresPinAlways;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("stockaccesslevel")
    public Integer stockaccesslevel;
    @JsonProperty("stockAccessLevels")
    public List<Object> stockAccessLevels;
    @JsonProperty("versiondate")
    public Long versionDate;
}
