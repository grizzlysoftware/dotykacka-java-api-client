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
public class Customer {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_discountGroupId")
    public Long discountGroupId;

    @JsonProperty("companyId")
    public Long companyId;

    @JsonProperty("externalId")
    public Long externalId;

    @JsonProperty("companyName")
    public String companyName;

    @JsonProperty("vatId")
    public String vatNumber;

    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("points")
    public Double points;

    @JsonProperty("firstname")
    public String firstName;

    @JsonProperty("lastname")
    public String lastName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("note")
    public String note;

    @JsonProperty("internalNote")
    public String internalNote;

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

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("display")
    public Boolean isDisplayed;

    @JsonProperty("expireDate")
    public Long expiresAt;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("versionDate")
    public Long updatedAt;

    @JsonProperty("modifiedBy")
    public String updatedBy;
}
