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
    private Long totalRows;
    @JsonProperty("belongstoproductId")
    private Long belongstoproductId;
    @JsonProperty("childExtId")
    private String childExtId;
    @JsonProperty("cloudid")
    private Long cloudId;
    @JsonProperty("deleted")
    private Boolean isDeleted;
    @JsonProperty("ingUnit")
    private String ingUnit;
    @JsonProperty("ingrediencemapid")
    private Long id;
    @JsonProperty("ingredienceproductId")
    private Long productId;
    @JsonProperty("origproductname")
    private String origProductName;
    @JsonProperty("parentExtId")
    private String parentExtId;
    @JsonProperty("pgKey")
    private Long pgKey;
    @JsonProperty("productUnit")
    private String productUnit;
    @JsonProperty("purchasepricewithoutvat2")
    private Integer purchasePriceWithoutVat2;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("serialVersionUID")
    private Integer serialVersionUID;
    @JsonProperty("totalsum")
    private Integer totalSum;
    @JsonProperty("treeQuantity")
    private Integer treeQuantity;
    @JsonProperty("units")
    private String units;
    @JsonProperty("versiondate")
    private Long versionDate;
}
