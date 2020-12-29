package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product-ingredient#product-ingredient-schema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductIngredient {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_productId")
    public Long ingredientId;

    @JsonProperty("_parentProductId")
    public Long productId;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("quantity")
    public Double  quantity;

    @JsonProperty("unit")
    public String unit;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
