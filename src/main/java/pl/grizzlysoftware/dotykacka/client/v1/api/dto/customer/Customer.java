package pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Bartosz Pawłowski on 2019-07-01.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    public String address1;
    public String barcode;
    public Long birthday;
    public String canonicalname;
    public String city;
    public Integer cloudid;
    public String color;
    public String companyname;
    public String countrycode;
    public String created;
    public Long customerid;
    public String customeridString;
    public Integer deleted;
    public Long discountgroupId;
    public Integer display;
    public String email;
    public Date expiredate;
    public String externalid;
    public String firstname;
    public String headerprint;
    public String ico;
    public String lastname;
    public String note;
    public String phone;
    public Double points;
    public String serialVersionUID;
    public String tagslist;
    public String vatno;
    public String zip;

}
