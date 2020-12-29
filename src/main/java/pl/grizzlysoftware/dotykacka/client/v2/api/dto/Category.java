package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/category#category-schema
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("externalId")
    public String externalId;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_eetSubjectId")
    public Long eetSubjectId;

    @JsonProperty("_defaultCourseId")
    public Long defaultCourseId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("display")
    public Boolean isDisplayed;

    @JsonProperty("flags")
    public Integer flags;

    @JsonProperty("hexColor")
    public String hexColor;

    @JsonProperty("margin")
    public String margin;

    @JsonProperty("sortOrder")
    public Long sortOrder;

    @JsonProperty("vat")
    public Double vat;

    @JsonProperty("maxDiscount")
    public Double maxDiscount;

    @JsonProperty("tags")
    public Collection<String> tags;

    @JsonProperty("modifiedBy")
    public String modifiedBy;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
