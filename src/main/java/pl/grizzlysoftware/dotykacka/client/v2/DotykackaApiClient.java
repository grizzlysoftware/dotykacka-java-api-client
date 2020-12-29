package pl.grizzlysoftware.dotykacka.client.v2;

import pl.grizzlysoftware.dotykacka.client.v2.api.service.*;
import pl.grizzlysoftware.dotykacka.client.v2.facade.*;
import pl.grizzlysoftware.dotykacka.model.Configuration;
import pl.grizzlysoftware.dotykacka.client.v2.util.AccessTokenProvider;
import pl.grizzlysoftware.dotykacka.client.v2.util.ApiTokenProvider;
import pl.grizzlysoftware.dotykacka.util.DotykackaOAuthAccessTokenExtractor;
import pl.grizzlysoftware.dotykacka.util.OkHttpAccessTokenAuthenticator;
import pl.grizzlysoftware.util.OkHttpLoggingInterceptor;

import java.time.Duration;

import static java.util.Objects.requireNonNull;
import static pl.grizzlysoftware.util.OkHttpClientUtils.builder;
import static pl.grizzlysoftware.util.RetrofitUtils.service;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class DotykackaApiClient {

    private final BranchServiceFacade branchService;
    private final CategoryServiceFacade categoryService;
    private final CloudServiceFacade cloudService;
    private final CustomerServiceFacade customerService;
    private final EmployeeServiceFacade employeeService;
    private final MoneyLogServiceFacade moneyLogService;
    private final OAuthServiceFacade oauthService;
    private final OrderItemServiceFacade orderItemService;
    private final OrderServiceFacade orderService;
    private final ProductCustomizationServiceFacade productCustomizationService;
    private final ProductIngredientServiceFacade productIngredientService;
    private final ProductServiceFacade productService;
    private final ReservationServiceFacade reservationService;
    private final SupplierServiceFacade supplierService;
    private final TableServiceFacade tableService;
    private final TagServiceFacade tagService;
    private final WarehouseBranchServiceFacade warehouseBranchService;
    private final WarehouseServiceFacade warehouseService;

    protected Configuration configuration;
    protected AccessTokenProvider accessTokenProvider;
    protected ApiTokenProvider apiTokenProvider;

    public DotykackaApiClient(Configuration configuration) {
        this.configuration = requireNonNull(configuration).clone();
        var oAuthHttpClient = builder()
                .callTimeout(configuration.requestTimeout != null ? configuration.requestTimeout : Duration.ofSeconds(60))
                .retryOnConnectionFailure(true)
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build();
//        oauthService = new OAuthServiceFacade(service(oAuthHttpClient, configuration.url, OAuthService.class));
        oauthService = new OAuthServiceFacade();

//        if (configuration.apiTokenAuthCredentials == null) {
//            apiTokenProvider = new ApiTokenProvider(oauthService, new OAuthApiToken(configuration.apiToken));
//        } else {
//            apiTokenProvider = new ApiTokenProvider(oauthService, configuration.apiTokenAuthCredentials);
//        }
//        accessTokenProvider = new AccessTokenProvider(oauthService, apiTokenProvider, configuration.accessTokenAuthCredentials, configuration.apiToken, configuration.oAuthTokenValidationTolerance);

        var authenticator = new OkHttpAccessTokenAuthenticator(accessTokenProvider, new DotykackaOAuthAccessTokenExtractor());
        var secureServiceHttpClient = builder()
                .addInterceptor(authenticator)
                .authenticator(authenticator)
                .addInterceptor(new OkHttpLoggingInterceptor())
                .build();

        branchService = new BranchServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, BranchService.class));
        cloudService = new CloudServiceFacade(service(secureServiceHttpClient, configuration.url, CloudService.class));
        categoryService = new CategoryServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, CategoryService.class));
        customerService = new CustomerServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, CustomerService.class));
        employeeService = new EmployeeServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, EmployeeService.class));
        orderItemService = new OrderItemServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, OrderItemService.class));
        orderService = new OrderServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, OrderService.class));
        moneyLogService = new MoneyLogServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, MoneyLogService.class));
        productService = new ProductServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, ProductService.class));
        productCustomizationService = new ProductCustomizationServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, ProductCustomizationService.class));
        productIngredientService = new ProductIngredientServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, ProductIngredientService.class));
        reservationService = new ReservationServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, ReservationService.class));
        supplierService = new SupplierServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, SupplierService.class));
        tableService = new TableServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, TableService.class));
        tagService = new TagServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, TagService.class));
        warehouseService = new WarehouseServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, WarehouseService.class));
        warehouseBranchService = new WarehouseBranchServiceFacade(configuration.cloudId, service(secureServiceHttpClient, configuration.url, WarehouseBranchService.class));
    }
}
