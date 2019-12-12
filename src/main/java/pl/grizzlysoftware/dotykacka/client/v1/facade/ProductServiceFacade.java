/*
 * Copyright 2019 Grizzly Software, https://grizzlysoftware.pl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.service.ProductService;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.product.ProductWithStockStatus;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ProductServiceFacade extends DotykackaApiServiceFacade<ProductService> {
    public ProductServiceFacade(String cloudId, ProductService service) {
        super(cloudId, service);
    }

    public Collection<ProductWithStockStatus> getProductsWithStockStatus(long warehouseId) {
        int size = 0, lastSize = 0, limit = 100, offset = 0;
        var products = new ArrayList<ProductWithStockStatus>(3000);
        while (true) {
            var p = getProductsWithStockStatus(warehouseId, offset, limit);
            products.addAll(p);
            size += p.size();
            if (size == lastSize) {
                break;
            }

            lastSize = size;
            offset += limit;
        }
        return products;
    }

    public Collection<ProductWithStockStatus> getProductsWithStockStatus(long warehouseId, int offset, int limit) {
        return execute(service.getProductsWithStockStatus(cloudId, warehouseId, offset, limit));
    }
}
