package pl.grizzlysoftware.dotykacka.client.v1.api.service;

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.ProductStockup;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public interface StockService {
    @POST("stockup/{cloudId}/{warehouseId}")
    Call<ProductStockup> stockupProducts(@Path("cloudId") Long cloudId, @Path("warehouseId") Long warehouseId, @Body ProductStockup stockup);
}
