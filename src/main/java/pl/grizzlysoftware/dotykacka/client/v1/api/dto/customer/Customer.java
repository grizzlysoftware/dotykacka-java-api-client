package pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bartosz Pawłowski on 2019-07-01.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("birthday")
    public Long birthday;

    @JsonProperty("customerid")
    public Long customerId;

    @JsonProperty("discountgroup_id")   //there's misspell in api documentation
    public Long discountGroupId;

    @JsonProperty("discountgroupId")   //there's misspell in api documentation
    public Long discountGroupIdToSave;

    @JsonProperty("email")
    public String email;

    @JsonProperty("firstname")
    public String firstName;

    @JsonProperty("lastname")
    public String lastName;

    @JsonProperty("companyname")
    public String companyName;

    @JsonProperty("note")
    public String note;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("points")
    public Double points;

    @JsonProperty("deleted")
    public Boolean isDeleted;
}
