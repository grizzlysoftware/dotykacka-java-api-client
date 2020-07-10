package pl.grizzlysoftware.dotykacka.client.v1.api.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductWithStockStatus {
    @JsonProperty("productid")
    public Long id;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("categoryid")
    public Long categoryId;
    @JsonProperty("categorymargin")
    public String categoryMargin;
    @JsonProperty("categoryname")
    public String categoryName;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("ctlgAmountId")
    public Long ctlgAmountId;
    @JsonProperty("ctlgBindType")
    public Integer ctlgBindType;
    @JsonProperty("ctlgItemId")
    public Long ctlgItemId;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("description")
    public String description;
    @JsonProperty("discountpercent")
    public Float discountPercent;
    @JsonProperty("discountpermitted")
    public Boolean isDiscountPermitted;
    @JsonProperty("display")
    public Boolean isDisplayed;
    @JsonProperty("dnids")
    public String dnIds;
    @JsonProperty("ean")
    public String ean;
    @JsonProperty("eetsubjectid")
    public Long eetSubjectId;
    @JsonProperty("externalid")
    public String externalId;
    @JsonProperty("fiscalizationdisabled")
    public Boolean isFiscalizationDisabled;
    @JsonProperty("hexcolor")
    public String hexColor;
    @JsonProperty("ingredients")
    public Integer ingredients;
    @JsonProperty("jointsale")
    public Boolean isJointSale;
    @JsonProperty("lastInventory")
    public Boolean lastInventory;
    @JsonProperty("lastInventoryValue")
    public Integer lastInventoryValue;
    @JsonProperty("lastpurchasepricewithoutvat")
    public double lastPurchaseNetPrice;
    @JsonProperty("margin")
    public String margin;
    @JsonProperty("marginmin")
    public Integer marginMin;
    @JsonProperty("modifiedby")
    public String modifiedBy;
    @JsonProperty("name")
    public String name;
    @JsonProperty("noteslist")
    public String notesList;
    @JsonProperty("onsale")
    public Integer isOnSale;
    @JsonProperty("packageitem")
    public Integer packageItem;
    @JsonProperty("packaging")
    public Integer packaging;
    @JsonProperty("packagingmeasurement")
    public Integer packagingMeasurement;
    @JsonProperty("permisions")
    public Integer permisions;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("plu")
    public String plu;
    @JsonProperty("points")
    public Double points;
    @JsonProperty("priceVatCsv")
    public double priceVatCsv;
    @JsonProperty("pricewithoutvat")
    public double netPrice;
    @JsonProperty("pricewithvat")
    public double grossPrice;
    @JsonProperty("profitwithoutvat")
    public double netProfit;
    @JsonProperty("purchasepricewithoutvat")
    public double purchaseNetPrice;
    @JsonProperty("purchasepricewithoutvat2")
    public double purchaseNetPrice2;
    @JsonProperty("requirespriceentry")
    public Integer requirePriceEntry;
    @JsonProperty("requiresquantityentry")
    public Integer requireQuantityEntry;
    @JsonProperty("sortorder")
    public Integer sortOrder;
    @JsonProperty("special")
    public Boolean isSpecial;
    @JsonProperty("specialProductKey")
    public String specialProductKey;
    @JsonProperty("stockdeduct")
    public Integer stockDeduct;
    @JsonProperty("stockoverdraft")
    public String stockOverDraft;
    @JsonProperty("stockquantity")
    public int stockQuantity;
    @JsonProperty("stockquantitystatus")
    public int stockQuantityStatus;
    @JsonProperty("stockupQuantitySum")
    public int stockupQuantitySum;
    @JsonProperty("subtitle")
    public String subtitle;
    @JsonProperty("supplierId")
    public Long supplierId;
    @JsonProperty("supplierproductcode")
    public String supplierProductCode;
    @JsonProperty("tagslist")
    public String tagsList;
    @JsonProperty("takeawayitem")
    public Boolean isTakeAwayItem;
    @JsonProperty("timeable")
    public Boolean isTimeable;
    @JsonProperty("units")
    public String units;
    @JsonProperty("unitsmeasurement")
    public String unitsMeasurement;
    @JsonProperty("vat")
    public double vat;
    @JsonProperty("warehouses")
    public List<Object> warehouses;
    @JsonProperty("writeoffQuatitySum")
    public Integer writeoffQuatitySum;
}
