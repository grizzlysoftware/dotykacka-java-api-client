package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductIngredient {
    @JsonProperty("ingredienceproductId")
    public Long productId;
    @JsonProperty("belongstoproductId")
    public Long parentProductId;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("ingrediencemapid")
    public Long ingredientId;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("units")
    public String unit;
}
