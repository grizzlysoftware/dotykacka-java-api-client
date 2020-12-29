package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/money-log#money-log-schema
 *
 * Transaction type is one of these:
 *
 * REFUND, REGISTER_CLOSE, REGISTER_OPEN,
 * SALE, CASH_IN_OUT, OUT, RECEIVED
 *
 * I did not make it as enum for purpose - i have no time to maintain this library so whenever new enum entry comes in,
 * deserialization fails. String is more flexible here
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyLog {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_branchId")
    public Long branchId;

    @JsonProperty("_orderId")
    public Long orderId;

    @JsonProperty("_sellerId")
    public Long sellerId;

    @JsonProperty("_employeeId")
    public Long employeeId;

    @JsonProperty("paymentTypeId")
    public Long paymentTypeId;

    @JsonProperty("transactionType")
    public String transactionType;

    @JsonProperty("amount")
    public Double amount;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("note")
    public String note;

    @JsonProperty("flags")
    public Long flags;

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
