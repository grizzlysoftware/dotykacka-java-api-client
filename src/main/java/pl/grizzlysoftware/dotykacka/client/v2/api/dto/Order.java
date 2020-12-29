package pl.grizzlysoftware.dotykacka.client.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://docs.api.dotypos.com/entity/order
 * <p>
 * Order flags:
 * <p>
 * 0 - CANCELED_PART
 * 1 - CANCELED_FULL
 * 2 - CANCELLATION
 * 3 - FISCALIZATION_REQUIRED
 * 4 - MERGED
 * 5 - FISCALIZATION_DISABLED
 * 6 - PAID_PART
 * 7 - FISCALIZATION_SIMPLIFIED
 * 8 - VAT_PAYER
 * 9 - NON_VAT_PAYER
 * 10 - PDF_INVOICE
 * 11 - WRITEOFF
 * 12 - GASTRO
 * 13 - FISCALIZATION_FAILED
 * 14 - VAT_PRINT_DISABLED
 * 15 - LUNCH_INVITATION
 * 16 - DELIVERY
 * 17 - MOVED_FROM
 * 18 - MOVED_TO
 * <p>
 * documentType:
 * <p>
 * - RECEIPT,
 * - INVOICE,
 * - INVOICE_FROM_RECEIPTS
 * - CORRECTIVE_INVOICE
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @JsonProperty("id")
    public String id;

    @JsonProperty("_branchId")
    public String branchId;

    @JsonProperty("_cloudId")
    public String cloudId;

    @JsonProperty("_courseId")
    public String courseId;

    @JsonProperty("_customerId")
    public String customerId;

    @JsonProperty("_eetSubjectId")
    public String eetSubjectId;

    @JsonProperty("_employeeId")
    public String employeeId;

    @JsonProperty("_relatedInvoiceId")
    public String relatedInvoiceId;

    @JsonProperty("_relatedOrderId")
    public String relatedOrderId;

    @JsonProperty("_sellerId")
    public String sellerId;

    @JsonProperty("_tableId")
    public String tableId;

    @JsonProperty("externalId")
    public String externalId;

    @JsonProperty("bkp")
    public String bkp;

    @JsonProperty("canceledDate")
    public Long cancelledAt;

    @JsonProperty("completed")
    public Long completedAt;

    @JsonProperty("created")
    public Long createdAt;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("documentNumber")
    public String documentNumber;

    @JsonProperty("documentType")
    public String documentType;

    @JsonProperty("fik")
    public String fik;

    @JsonProperty("flags")
    public String flags;

    @JsonProperty("itemCount")
    public Integer itemCount;

    @JsonProperty("locationAccuracy")
    public Double locationAccuracy;

    @JsonProperty("locationDate")
    public Long locatedAt;

    @JsonProperty("locationLatitude")
    public Double locationLatitude;

    @JsonProperty("locationLongitude")
    public Double locationLongitude;

    @JsonProperty("note")
    public String note;

    @JsonProperty("paid")
    public Boolean isPaid;

    @JsonProperty("parked")
    public Boolean isParked;

    @JsonProperty("pkp")
    public String pkp;

    @JsonProperty("points")
    public String points;

    @JsonProperty("printData")
    public String printData;

    @JsonProperty("status")
    public String status;

    @JsonProperty("totalValueRounded")
    public Double value;

    @JsonProperty("updated")
    public Long updatedAt;

    @JsonProperty("versionDate")
    public Long versionDate;

}
