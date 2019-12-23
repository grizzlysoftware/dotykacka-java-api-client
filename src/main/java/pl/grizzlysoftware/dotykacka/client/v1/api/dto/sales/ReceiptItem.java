package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiptItem {
    @JsonProperty("billedunitprice")
    public Integer billedUnitPrice;

    @JsonProperty("branchid")
    public Long branchId;

    @JsonProperty("canceleddate")
    public LocalDateTime canceledDate;

    @JsonProperty("canonicalname")
    public String canonicalName;

    @JsonProperty("categoryid")
    public Long categoryId;

    @JsonProperty("cloudid")
    public Long cloudId;

    @JsonProperty("completed")
    public Long completed;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("customerlongid")
    public Long customerLongId;

    @JsonProperty("discountfixed")
    public BigDecimal discountFixed;

    @JsonProperty("discountpercent")
    public BigDecimal discountPercent;

    @JsonProperty("discountpermitted")
    public Integer discountPermitted;

    @JsonProperty("ean")
    public String ean;

    @JsonProperty("eetsubjectid")
    public Long eetSubjectid;

    @JsonProperty("employeeid")
    public Long employeeId;

    @JsonProperty("formattedPortion")
    public String formattedPortion;

    @JsonProperty("hexcolor")
    public String hexcolor;

    @JsonProperty("kitchenprinted")
    public Integer kitchenPrinted;

    @JsonProperty("name")
    public String name;

    @JsonProperty("note")
    public String note;

    @JsonProperty("onsale")
    public Integer onSale;

    @JsonProperty("orderid")
    public Long orderId;

    @JsonProperty("packaging")
    public Integer packaging;

    @JsonProperty("parked")
    public Integer parked;

    @JsonProperty("points")
    public Integer points;

    @JsonProperty("pricebilledwithoutvat")
    public BigDecimal priceBilledWithoutVat;

    @JsonProperty("pricepurchasewithoutvat")
    public BigDecimal pricePurchaseWithoutVat;

    @JsonProperty("pricewithoutvat")
    public BigDecimal pricewithoutvat;

    @JsonProperty("productid")
    public Long productId;

    @JsonProperty("profitwithoutvat")
    public BigDecimal profitWithoutVat;

    @JsonProperty("quantity")
    public Integer quantity;

    @JsonProperty("quantitydisplay")
    public Integer quantityDisplay;

    @JsonProperty("refundid")
    public Long refundId;

    @JsonProperty("stockdeduct")
    public Integer stockDeduct;

    @JsonProperty("stockunitpricewithoutvat")
    public BigDecimal stockUnitPriceWithoutVat;

    @JsonProperty("subtitle")
    public String subtitle;

    @JsonProperty("tagslist")
    public String tagsList;

    @JsonProperty("totalpricewithoutvat")
    public BigDecimal totalPriceWithoutVat;

    @JsonProperty("totalpricewithvat")
    public BigDecimal totalPriceWithVat;

    @JsonProperty("unitpricewithvat")
    public BigDecimal unitPriceWithVat;

    @JsonProperty("units")
    public String units;

    @JsonProperty("vat")
    public BigDecimal vat;
}
