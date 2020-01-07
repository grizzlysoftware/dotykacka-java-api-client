package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    @JsonProperty("tagid")
    public Long id;
    @JsonProperty("tag")
    public String tag;
    @JsonProperty("canonicalname")
    public String canonicalName;
    @JsonProperty("cloudid")
    public Integer cloudId;
    @JsonProperty("customerforeignId")
    public Long customerId;
    @JsonProperty("deleted")
    public Boolean isDeleted;
    @JsonProperty("display")
    public Integer display;
    @JsonProperty("externalid")
    public String externalId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("numcanonicalname")
    public String numCanonicalName;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("versiondate")
    public Long versionDate;

    @JsonIgnore
    public TagType type;
}
