package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/product-customization#product-customization-schema
 * <p>
 * flags:
 * 0 - DEFAULT_SELECTION_GRATIS
 * 1 - ONE_CHEAPEST_ITEM_GRATIS
 * 2 - ALL_ITEMS_GRATIS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCustomization {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_productId")
    public Long productId;

    @JsonProperty("_defaultProductIds")
    public Collection<Long> defaultProductIds;

    @JsonProperty("name")
    public String name;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("flags")
    public Integer flags;

    @JsonProperty("minSelected")
    public Integer minSelected;

    @JsonProperty("maxSelected")
    public Integer maxSelected;

    @JsonProperty("sortOrder")
    public Long sortOrder;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
