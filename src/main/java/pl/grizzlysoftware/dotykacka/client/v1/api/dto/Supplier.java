package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier {
    @JsonProperty("address1")
    public String address1;
    @JsonProperty("address2")
    public String address2;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("city")
    public String city;
    @JsonProperty("cloudid")
    public Integer cloudId;
    @JsonProperty("companyid")
    public Long companyId;
    @JsonProperty("countrycode")
    public String countryCode;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("display")
    public Integer display;
    @JsonProperty("dnids")
    public String dnIds;
    @JsonProperty("email")
    public String email;
    @JsonProperty("externalid")
    public String externalId;   /** wtf is that, it seems to be some sort of name, not id */
    @JsonProperty("ico")
    public String ico;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("supplierid")
    public Long id;
    @JsonProperty("vatid")
    public String vatId;
    @JsonProperty("vatno")
    public String vatNo;
    @JsonProperty("versiondate")
    public Long versionDate;
    @JsonProperty("zip")
    public String zip;
}
