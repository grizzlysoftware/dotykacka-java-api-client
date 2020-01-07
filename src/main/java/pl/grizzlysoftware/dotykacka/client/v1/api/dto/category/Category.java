package pl.grizzlysoftware.dotykacka.client.v1.api.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("categoryid")
    public Long id;
    @JsonProperty("cloudid")
    public Integer cloudId;
    @JsonProperty("deleted")
    public Integer deleted;
    @JsonProperty("display")
    public Integer display;
    @JsonProperty("eetsubjectid")
    public Long eetSubjectId;
    @JsonProperty("externalid")
    public Long externalId;
    @JsonProperty("fiscalizationdisabled")
    public Integer fiscalizationDisabled;
    @JsonProperty("flags")
    public Integer flags;
    @JsonProperty("hexcolor")
    public String hexColor;
    @JsonProperty("itemscount")
    public Long itemsCount;
    @JsonProperty("margin")
    public String margin;
    @JsonProperty("modifiedby")
    public String modifiedBy;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("parentcategoryid")
    public Integer parentcategoryId;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("serialVersionUID")
    public Integer serialVersionUID;
    @JsonProperty("sortorder")
    public Integer sortOrder;
    @JsonProperty("vat")
    public Integer vat;
    @JsonProperty("versiondate")
    public Long versionDate;
}