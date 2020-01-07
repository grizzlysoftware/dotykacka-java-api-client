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
public class Warehouse {
    @JsonProperty("warehouseid")
    public Long id;
    @JsonProperty("barcode")
    public String barcode;
    @JsonProperty("branches")
    public List<Object> branches;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("cloudid")
    public Integer cloudiId;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("enabled")
    public Boolean isEnabled;
    @JsonProperty("hexcolor")
    public String hexColor;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("providername")
    public String providerName;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("type")
    public Integer type;
    @JsonProperty("versiondate")
    public Long versionDate;
}
