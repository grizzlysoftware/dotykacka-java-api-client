package pl.grizzlysoftware.dotykacka.client.v1.api.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductWithStockStatus {

    @JsonProperty("canonicalname")
    public String canonicalname;

    @JsonProperty("categoryid")
    public Long categoryId;

    @JsonProperty("categorymargin")
    public String categorymargin;

    @JsonProperty("categoryname")
    public String categoryname;

    @JsonProperty("cloudid")
    public Integer cloudid;

    @JsonProperty("ctlgAmountId")
    public Integer ctlgAmountId;

    @JsonProperty("ctlgBindType")
    public Integer ctlgBindType;

    @JsonProperty("ctlgItemId")
    public Integer ctlgItemId;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("deleted")
    public Integer deleted;

    @JsonProperty("description")
    public String description;

    @JsonProperty("discountpercent")
    public Integer discountpercent;

    @JsonProperty("discountpermitted")
    public Integer discountpermitted;

    @JsonProperty("display")
    public Integer display;

    @JsonProperty("dnids")
    public String dnids;

    @JsonProperty("ean")
    public String ean;

    @JsonProperty("eetsubjectid")
    public Integer eetSubjectId;

    @JsonProperty("externalid")
    public String externalid;

    @JsonProperty("fiscalizationdisabled")
    public Integer fiscalizationdisabled;

    @JsonProperty("hexcolor")
    public String hexcolor;

    @JsonProperty("ingredients")
    public Integer ingredients;

    @JsonProperty("jointsale")
    public Integer jointsale;

    @JsonProperty("lastInventory")
    public Boolean lastInventory;

    @JsonProperty("lastInventoryValue")
    public Integer lastInventoryValue;

    @JsonProperty("lastpurchasepricewithoutvat")
    public double lastPurchaseNetPrice;

    @JsonProperty("margin")
    public String margin;

    @JsonProperty("marginmin")
    public Integer marginmin;

    @JsonProperty("modifiedby")
    public String modifiedBy;

    @JsonProperty("name")
    public String name;

    @JsonProperty("noteslist")
    public String notesList;

    @JsonProperty("numcanonicalname")
    public String canonicalName;

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
    public Integer points;

    @JsonProperty("priceVatCsv")
    public double priceVatCsv;

    @JsonProperty("pricewithoutvat")
    public double netPrice;

    @JsonProperty("pricewithvat")
    public double grossPrice;

    @JsonProperty("productid")
    public Long productId;

    @JsonProperty("productidString")
    public String productidString;

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
    public Integer special;

    @JsonProperty("specialProductKey")
    public String specialProductKey;

    @JsonProperty("stockdeduct")
    public Integer stockDeduct;

    @JsonProperty("stockoverdraft")
    public String stockoverdraft;

    @JsonProperty("stockquantity")
    public int stockquantity;

    @JsonProperty("stockquantitystatus")
    public int stockquantitystatus;

    @JsonProperty("stockupQuantitySum")
    public int stockupQuantitySum;

    @JsonProperty("subtitle")
    public String subtitle;

    @JsonProperty("supplierId")
    public Integer supplierId;

    @JsonProperty("supplierproductcode")
    public String supplierProductCode;

    @JsonProperty("tagslist")
    public String tagsList;

    @JsonProperty("takeawayitem")
    public Integer isTakeAwayItem;

    @JsonProperty("timeable")
    public Integer isTimeable;

    @JsonProperty("units")
    public String units;

    @JsonProperty("unitsmeasurement")
    public String unitsMeasurement;

    @JsonProperty("vat")
    public double vat;

    @JsonProperty("warehouses")
    public List<Object> warehouses = null;

    @JsonProperty("writeoffQuatitySum")
    public Integer writeoffQuatitySum;
}
