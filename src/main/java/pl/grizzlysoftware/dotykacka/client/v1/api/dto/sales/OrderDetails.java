package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetails {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("pgKey")
    public Long pgKey;
    @JsonProperty("branchid")
    public Integer branchId;
    @JsonProperty("canceleddate")
    public Long canceledDate;
    @JsonProperty("cashregistertype")
    public String cashRegisterType;
    @JsonProperty("cloudid")
    public Integer cloudId;
    @JsonProperty("completed")
    public Long completed;
    @JsonProperty("customerlongid")
    public Object customerId;
    @JsonProperty("employeeid")
    public Long employeeId;
    @JsonProperty("employeeservedId")
    public Long employeeServedId;
    @JsonProperty("inserted")
    public Long inserted;
    @JsonProperty("itemcount")
    public Integer itemCount;
    @JsonProperty("locacc")
    public Double locacc;
    @JsonProperty("locdate")
    public Long locdate;
    @JsonProperty("loclat")
    public Double loclat;
    @JsonProperty("loclng")
    public Double loclng;
    @JsonProperty("note")
    public String note;
    @JsonProperty("orderid")
    public Long orderId;
    @JsonProperty("orderseriesid")
    public Long orderSeriesId;
    @JsonProperty("ordersummaryid")
    public Long orderSummaryId;
    @JsonProperty("paid")
    public Integer paid;
    @JsonProperty("parked")
    public Integer parked;
    @JsonProperty("parklocation")
    public Object parkLocation;
    @JsonProperty("points")
    public Double points;
    @JsonProperty("printed")
    public Integer printed;
    @JsonProperty("refunded")
    public Integer refunded;
    @JsonProperty("tableId")
    public Long tableId;
    @JsonProperty("totalvaluerounded")
    public Double totalValueRounded;
    @JsonProperty("updated")
    public Long updated;
    @JsonProperty("versiondate")
    public Long versionDate;
    @JsonProperty("paymenttypeid")
    public Long paymentTypeId;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("fik")
    public Object fik;
    @JsonProperty("pkp")
    public Object pkp;
    @JsonProperty("bkp")
    public Object bkp;
    @JsonProperty("documenttype")
    public Integer documentType;
    @JsonProperty("flags")
    public Integer flags;
    @JsonProperty("relatedorderid")
    public Long relatedOrderId;
    @JsonProperty("tablename")
    public String tableName;
    @JsonProperty("tableName")
    public String weirdTableName;   //dunno what the hell is that
    @JsonProperty("branchname")
    public String branchName;
    @JsonProperty("relatedorderseriesid")
    public Long relatedOrderSeriesId;
    @JsonProperty("invoice")
    public Object invoice;
    @JsonProperty("printdata")
    public Long printData;
    @JsonProperty("fdata")
    public Object fdata;
    @JsonProperty("externalid")
    public Long externalId;
    @JsonProperty("variablesymbol")
    public String variableSymbol;
    @JsonProperty("amount")
    public Double amount;
    @JsonProperty("created")
    public Long created;
    @JsonProperty("eetsubjectid")
    public Long eetSubjectId;
    @JsonProperty("versionTime")
    public Long versionTime;
}
