package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.ProductStockup;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.*;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales.report.SalesReport;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.StockService;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.sales.*;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.time.LocalDateTime;
import java.util.Collection;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class StockServiceFacade extends BasicDotykackaApiServiceFacade {

    protected StockService stockService;

    public StockServiceFacade(Long cloudId, StockService stockService) {
        super(cloudId);
        this.stockService = requireNonNull(stockService);
    }

    public ProductStockup stockupProduct(Long warehouseId, ProductStockup productStockup) {
        return execute(stockService.stockupProducts(cloudId, warehouseId, productStockup));
    }
}
