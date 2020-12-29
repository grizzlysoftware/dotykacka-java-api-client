package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Bartosz Pawłowski on 2019-07-01.
 *
 * https://docs.api.dotypos.com/entity/suppliers#supplier-schema
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("companyId")
    public Long companyId;

    @JsonProperty("externalId")
    public Object externalId; //TODO null type in documentation?

    @JsonProperty("vatId")
    public String vatNumber;

    @JsonProperty("name")
    public String name;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("addressLine1")
    public String addressLine1;

    @JsonProperty("addressLine2")
    public String addressLine2;

    @JsonProperty("city")
    public String city;

    @JsonProperty("zip")
    public String zipCode;

    @JsonProperty("country")
    public String country;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("display")
    public Boolean isDisplayed;

    @JsonProperty("deliveryNoteIds")
    public String deliveryNoteIds;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
