package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_categoryId")
    public Long categoryId;

    @JsonProperty("_defaultCourseId")
    public Long defaultCourseId;

    @JsonProperty("_eetSubjectId")
    public Long eetSubjectId;

    @JsonProperty("externalId")
    public String externalId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("description")
    public String description;

    @JsonProperty("subtitle")
    public String subtitle;

    @JsonProperty("vat")
    public Double vat;

    @JsonProperty("priceWithoutVat")
    public Double netPrice;

    @JsonProperty("priceWithVat")
    public Double grossPrice;

    @JsonProperty("purchasePriceWithoutVat")
    public Double purchaseNetPrice;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("margin")
    public String margin;

    @JsonProperty("marginMin")
    public Double marginMin;

    @JsonProperty("plu")
    public String plu;

    @JsonProperty("ean")
    public Collection<String> eans;

    @JsonProperty("points")
    public Double points;

    @JsonProperty("unit")
    public String unit;

    @JsonProperty("unitMeasurement")
    public String unitMeasurement;

    @JsonProperty("sortOrder")
    public Long sortOrder;

    @JsonProperty("supplierProductCode")
    public String supplierProductCode;

    @JsonProperty("stockOverdraft")
    public String stockOverdraft;

    @JsonProperty("packageItem")
    public Double packageItem;

    @JsonProperty("packaging")
    public Double packaging;

    @JsonProperty("packagingMeasurement")
    public Double packagingMeasurement;

    @JsonProperty("notes")
    public Collection<String> notes;

    @JsonProperty("discountPercent")
    public Double discountPercent;

    @JsonProperty("discountPermitted")
    public Boolean isDiscountPermitted;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("requiresPriceEntry")
    public Boolean isPriceEntryRequired;

    @JsonProperty("onSale")
    public Boolean isOnSale;

    @JsonProperty("display")
    public Boolean isDisplayed;

    @JsonProperty("onSale")
    public Boolean isDeductedFromStock;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("versionDate")
    public Long updatedAt;

    @JsonProperty("modifiedBy")
    public String updatedBy;
}
