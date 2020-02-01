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
    private String configAppVersionCode;
    @JsonProperty("CONFIG_APP_VERSION_NAME")
    private String configAppVersionName;
    @JsonProperty("CONFIG_CURRENCY")
    private String configCurrency;
    @JsonProperty("CONFIG_DECIMALS_DISPLAYED")
    private String configDecimalsDisplayed;
    @JsonProperty("CONFIG_DECIMALS_ROUND_ITEM")
    private String configDecimalsRoundItem;
    @JsonProperty("CONFIG_DECIMALS_ROUND_TOTAL")
    private String configDecimalsRoundTotal;
    @JsonProperty("CONFIG_DEFAULT_WAREHOUSE_ID")
    private String configDefaultWarehouseId;
    @JsonProperty("CONFIG_DEVICE_CODE")
    private String configDeviceCode;
    @JsonProperty("CONFIG_INVOICE_SEPARATE_NUMBERS")
    private String configInvoiceSeparateNumbers;
    @JsonProperty("CONFIG_INVOICE_SERIES_FORMAT")
    private String configInvoiceSeriesFormat;
    @JsonProperty("CONFIG_PRICES_NEGATIVE_ALLOWED")
    private String configPricesNegativeAllowed;
    @JsonProperty("CONFIG_RECEIPT_SERIES_FORMAT")
    private String configReceiptSeriesFormat;
    @JsonProperty("CONFIG_VAT_PAYER")
    private String configVatPayer;
    @JsonProperty("CONFIG_VAT_RATES")
    private String configVatRates;
    @JsonProperty("FEATURES_ADD")
    private String featuresAdd;
    @JsonProperty("FEATURES_SET_FREE")
    private String featuresSetFree;
    @JsonProperty("FEATURES_SET_NAPLNO")
    private String featuresSetNaplno;
    @JsonProperty("FEATURES_SET_NEOMEZENE")
    private String featuresSetNeomezene;
    @JsonProperty("FEATURES_SET_SNADNO")
    private String featuresSetSnadno;
    @JsonProperty("branchid")
    private Long id;
    @JsonProperty("canonicalname")
    private String canonicalName;
    @JsonProperty("cbhash")
    private String cbHash;
    @JsonProperty("cloudid")
    private Long cloudId;
    @JsonProperty("config")
    private String config;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("deleted")
    private Integer deleted;
    @JsonProperty("display")
    private Integer display;
    @JsonProperty("features")
    private Integer features;
    @JsonProperty("flags")
    private Integer flags;
    @JsonProperty("gcmid")
    private String gcmId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("numcanonicalname")
    private String numCanonicalName;
    @JsonProperty("pgKey")
    private Long pgKey;
    @JsonProperty("serialVersionUID")
    private Long serialVersionUID;
    @JsonProperty("versiondate")
    private Long versionDate;
}
