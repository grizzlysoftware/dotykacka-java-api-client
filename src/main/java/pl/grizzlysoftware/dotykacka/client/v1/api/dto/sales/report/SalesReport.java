
package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesReport {
    @JsonProperty("created")
    public Long created;
    @JsonProperty("from")
    public Long fromDate;
    @JsonProperty("to")
    public Long toDate;
    @JsonProperty("registerName")
    public String registerName;
    @JsonProperty("moneyTransactionInfo")
    public MoneyTransactionInfo moneyTransactionInfo;
    @JsonProperty("revenue")
    public Revenue revenue;
    @JsonProperty("discounts")
    public List<Discount> discounts;
    @JsonProperty("cashInOutTransactions")
    public List<CashInOutTransaction> cashInOutTransactions;
    @JsonProperty("categorySales")
    public List<CategorySale> categorySales;
    @JsonProperty("productSales")
    public List<ProductSale> productSales;
    @JsonProperty("tagSales")
    public List<TagSale> tagSales;
    @JsonProperty("employeeSales")
    public List<EmployeeSale> employeeSales;
    @JsonProperty("customerSales")
    public List<CustomerSale> customerSales;
    @JsonProperty("proxySales")
    public List<ProxySale> proxySales;
    @JsonProperty("takeawaySales")
    public List<TakeawaySale> takeawaySales;
    @JsonProperty("fiscalizationSales")
    public List<FiscalizationSale> fiscalizationSales;
    @JsonProperty("receiptInfo")
    public List<ReceiptInfo> receiptInfo;
    @JsonProperty("employeePayments")
    public List<EmployeePayment> employeePayments;
}
