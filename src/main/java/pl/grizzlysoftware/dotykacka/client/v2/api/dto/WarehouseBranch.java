package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/warehouse-branches#warehouse-branches-schema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseBranch {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_branchId")
    public Long branchId;

    @JsonProperty("_warehouseId")
    public Long warehouseId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("subscribed")
    public Boolean isSubscribed;

    @JsonProperty("visible")
    public Boolean isVisible;

    @JsonProperty("flags")
    public Integer flags;

    @JsonProperty("version")
    public Long version;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
