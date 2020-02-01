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
    private Long id;
    @JsonProperty("accesslevel")
    private Integer accessLevel;
    @JsonProperty("accesslevels")
    private List<String> accessLevels;
    @JsonProperty("accesspinshahash")
    private String accesspinshahash;
    @JsonProperty("barcode")
    private String barcode;
    @JsonProperty("canonicalname")
    private String canonicalname;
    @JsonProperty("cloudid")
    private Long cloudId;
    @JsonProperty("deleted")
    private Boolean isDeleted;
    @JsonProperty("email")
    private String email;
    @JsonProperty("enabled")
    private Integer enabled;
    @JsonProperty("flags")
    private Integer flags;
    @JsonProperty("hexcolor")
    private String hexColor;
    @JsonProperty("modifiedby")
    private String modifiedBy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("numcanonicalname")
    private String numCanonicalName;
    @JsonProperty("pgKey")
    private Long pgKey;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("requirepinalways")
    private Integer requirePinAlways;
    @JsonProperty("serialVersionUID")
    private Long serialVersionUID;
    @JsonProperty("stockaccesslevel")
    private Integer stockaccesslevel;
    @JsonProperty("stockAccessLevels")
    private List<Object> stockAccessLevels;
    @JsonProperty("versiondate")
    private Long versionDate;
}
