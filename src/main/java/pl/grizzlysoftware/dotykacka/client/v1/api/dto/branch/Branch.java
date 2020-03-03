package pl.grizzlysoftware.dotykacka.client.v1.api.dto.branch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty("CONFIG_APP_VERSION_CODE")
    public String configAppVersionCode;
    @JsonProperty("CONFIG_APP_VERSION_NAME")
    public String configAppVersionName;
    @JsonProperty("CONFIG_CURRENCY")
    public String configCurrency;
    @JsonProperty("CONFIG_DECIMALS_DISPLAYED")
    public String configDecimalsDisplayed;
    @JsonProperty("CONFIG_DECIMALS_ROUND_ITEM")
    public String configDecimalsRoundItem;
    @JsonProperty("CONFIG_DECIMALS_ROUND_TOTAL")
    public String configDecimalsRoundTotal;
    @JsonProperty("CONFIG_DEFAULT_WAREHOUSE_ID")
    public String configDefaultWarehouseId;
    @JsonProperty("CONFIG_DEVICE_CODE")
    public String configDeviceCode;
    @JsonProperty("CONFIG_INVOICE_SEPARATE_NUMBERS")
    public String configInvoiceSeparateNumbers;
    @JsonProperty("CONFIG_INVOICE_SERIES_FORMAT")
    public String configInvoiceSeriesFormat;
    @JsonProperty("CONFIG_PRICES_NEGATIVE_ALLOWED")
    public String configPricesNegativeAllowed;
    @JsonProperty("CONFIG_RECEIPT_SERIES_FORMAT")
    public String configReceiptSeriesFormat;
    @JsonProperty("CONFIG_VAT_PAYER")
    public String configVatPayer;
    @JsonProperty("CONFIG_VAT_RATES")
    public String configVatRates;
    @JsonProperty("FEATURES_ADD")
    public String featuresAdd;
    @JsonProperty("FEATURES_SET_FREE")
    public String featuresSetFree;
    @JsonProperty("FEATURES_SET_NAPLNO")
    public String featuresSetNaplno;
    @JsonProperty("FEATURES_SET_NEOMEZENE")
    public String featuresSetNeomezene;
    @JsonProperty("FEATURES_SET_SNADNO")
    public String featuresSetSnadno;
    @JsonProperty("branchid")
    public Long id;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("cbhash")
    public String cbHash;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("config")
    public String config;
    @JsonProperty("created")
    public Long created;
    @JsonProperty("deleted")
    public Integer deleted;
    @JsonProperty("display")
    public Integer display;
    @JsonProperty("features")
    public Integer features;
    @JsonProperty("flags")
    public Integer flags;
    @JsonProperty("gcmid")
    public String gcmId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("versiondate")
    public Long versionDate;
}
