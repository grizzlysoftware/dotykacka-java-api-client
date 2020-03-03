package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ingredient {
    @JsonProperty("TOTAL_ROWS")
    public Long totalRows;
    @JsonProperty("belongstoproductId")
    public Long belongstoproductId;
    @JsonProperty("childExtId")
    public String childExtId;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("ingUnit")
    public String ingUnit;
    @JsonProperty("ingrediencemapid")
    public Long id;
    @JsonProperty("ingredienceproductId")
    public Long productId;
    @JsonProperty("origproductname")
    public String origProductName;
    @JsonProperty("parentExtId")
    public String parentExtId;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("productUnit")
    public String productUnit;
    @JsonProperty("purchasepricewithoutvat2")
    public Integer purchasePriceWithoutVat2;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("serialVersionUID")
    public Integer serialVersionUID;
    @JsonProperty("totalsum")
    public Integer totalSum;
    @JsonProperty("treeQuantity")
    public Integer treeQuantity;
    @JsonProperty("units")
    public String units;
    @JsonProperty("versiondate")
    public Long versionDate;
}
