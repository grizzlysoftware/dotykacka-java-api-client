package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://docs.api.dotypos.com/entity/reservation#reservation-schema
 *
 * status:
 * - NEW
 * - CONFIRMED
 * - CANCELLED
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("_cloudId")
    public Long cloudId;

    @JsonProperty("_customerId")
    public Long customerId;

    @JsonProperty("_employeeId")
    public Long employeeId;

    @JsonProperty("_tableId")
    public Long tableId;

    @JsonProperty("status")
    public String status;

    @JsonProperty("note")
    public String note;

    @JsonProperty("deleted")
    public Boolean isDeleted;

    @JsonProperty("flags")
    public Integer flags;

    @JsonProperty("seats")
    public Integer seatsCount;

    @JsonProperty("startDate")
    public Long startsAt;

    @JsonProperty("endDate")
    public Long endsAt;

    @JsonProperty("createdAt")
    public Long createdAt;

    @JsonProperty("versionDate")
    public Long updatedAt;
}
