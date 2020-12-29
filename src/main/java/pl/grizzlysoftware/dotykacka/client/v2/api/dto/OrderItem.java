package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/order-item#order-item-schema
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem {
    @JsonProperty("id")
    public String id;

    @JsonProperty("_branchId")
    public String branchId;

    @JsonProperty("_cloudId")
    public String cloudId;

    @JsonProperty("_courseId")
    public String courseId;

    @JsonProperty("_customerId")
    public String customerId;

    @JsonProperty("_eetSubjectId")
    public String eetSubjectId;

    @JsonProperty("_employeeId")
    public String employeeId;

    @JsonProperty("_productId")
    public String productId;

    @JsonProperty("_categoryId")
    public String categoryId;

    @JsonProperty("_relatedOrderItemId")
    public String relatedOrderItemId; //TODO ???

    @JsonProperty("_orderId")
    public String orderId; //TODO relatedOrderItemId == orderId ??

    @JsonProperty("_sellerId")
    public String sellerId;
    
    @JsonProperty("flags")
    public String flags;

    @JsonProperty("billedUnitPriceWithVat")
    public String billedUnitGrossPrice;

    @JsonProperty("billedUnitPriceWithoutVat")
    public String billedUnitNetPrice;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("discountPercent")
    public Double discountPercent;

    @JsonProperty("discountPermitted")
    public Boolean isDiscountPermitted;

    @JsonProperty("ean")
    public Collection<String> eans;

    @JsonProperty("name")
    public String name;

    @JsonProperty("note")
    public String note;

    @JsonProperty("onSale")
    public Boolean isOnSale;

    @JsonProperty("packaging")
    public Double packaging;

    @JsonProperty("parked")
    public Boolean isParked;

    @JsonProperty("points")
    public Double points;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("stockDeduct")
    public Boolean isDeductedFromStockDeduct;

    @JsonProperty("subtitle")
    public String subtitle;

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("totalPriceWithVat")
    public String totalGrossPrice;

    @JsonProperty("totalPriceWithoutVat")
    public String totalNetPrice;

    @JsonProperty("unit")
    public String unit;

    @JsonProperty("unitPriceWithVat")
    public String unitGrossPrice;

    @JsonProperty("unitPriceWithoutVat")
    public String unitNetPrice;

    @JsonProperty("unitPurchasePrice")
    public String unitPurchasePrice;

    @JsonProperty("vat")
    public Double vat;

    @JsonProperty("canceledDate")
    public Long cancelledAt;

    @JsonProperty("completed")
    public Long completedAt;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("updated")
    public Long updatedAt;

    @JsonProperty("versionDate")
    public Long versionDate;
}
