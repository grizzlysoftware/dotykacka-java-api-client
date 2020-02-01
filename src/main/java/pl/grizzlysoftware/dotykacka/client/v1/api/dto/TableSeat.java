package pl.grizzlysoftware.dotykacka.client.v1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableSeat {
    @JsonProperty("tableseatid")
    public Long id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("cloudid")
    public Long cloudId;
    @JsonProperty("branchid")
    public Long branchId;
    @JsonProperty("closeddate")
    public Long closedDate;
    @JsonProperty("display")
    public Boolean isDisplayed;
    @JsonProperty("employeeId")
    public Long employeeId;
    @JsonProperty("enabled")
    public Boolean isEnabled;
    @JsonProperty("isalarmcalled")
    public Boolean isAlarmCalled;
    @JsonProperty("issplittable")
    public Boolean isSplitTable;
    @JsonProperty("locationname")
    public String locationName;
    @JsonProperty("notified")
    public Integer notified;
    @JsonProperty("occupied")
    public Boolean isOccupied;
    @JsonProperty("occupiedseats")
    public Integer occupiedSeats;
    @JsonProperty("openeddate")
    public Long openedDate;
    @JsonProperty("orderId")
    public Long orderId;
    @JsonProperty("paid")
    public Boolean isPaid;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("posleft")
    public Integer posLeft;
    @JsonProperty("posrotate")
    public Integer posRotate;
    @JsonProperty("postop")
    public Integer posTop;
    @JsonProperty("seats")
    public Integer seats;
    @JsonProperty("serialVersionUID")
    public Long serialVersionUID;
    @JsonProperty("tabledesign")
    public String tableDesign;
    @JsonProperty("tablegroupid")
    public Long tableGroupId;
    @JsonProperty("updateddate")
    public Long updatedDate;
    @JsonProperty("versiondate")
    public Long versionDate;
}
