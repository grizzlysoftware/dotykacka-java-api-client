package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Moneylog {
    @JsonProperty("id")
    public Long Id;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("branchid")
    public Long branchId;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("created")
    public Long created;
    @JsonProperty("dirtype")
    public String dirType;
    @JsonProperty("moneylogid")
    public Long moneylogId;
    @JsonProperty("note")
    public String note;
    @JsonProperty("orderId")
    public Long orderId;
    @JsonProperty("paymenttype")
    public String paymentType;
    @JsonProperty("paymenttypeid")
    public Long paymentTypeId;
    @JsonProperty("tags")
    public Object tags;
    @JsonProperty("transactiontype")
    public String transactionType;
    @JsonProperty("userId")
    public Long userId;
    @JsonProperty("versiondate")
    public Long versionDate;
    @JsonProperty("employeename")
    public String employeeName;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("totalrows")
    public Long totalRows;
    @JsonProperty("payidarray")
    public Object payIdArray;
    @JsonProperty("versionTime")
    public Long versionTime;
    @JsonProperty("tableName")
    public String tableName;
}
