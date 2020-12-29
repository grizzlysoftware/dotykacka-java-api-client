#Dotykacka Java API Client
Compatible with Dotykacka api version 1.62

## Recommended pre-requisities
* Java 11
* Gradle 6.0.2

## Artifact

### Maven
```
<dependency>
    <groupId>pl.grizzlysoftware</groupId>
    <artifactId>dotykacka-java-api-client</artifactId>
    <version>0.4.11</version>
</dependency>
```

### Gradle

```
compile group: 'pl.grizzlysoftware', name: 'dotykacka-java-api-client', version: '0.4.11'
```

## Dotykacka API coverage progress
Scratched elements means - DONE

Dotykacka API service coverage:
* ~~Branches Service~~
  * ~~Get Branch~~
  * ~~Get All Branches for Cloud~~
* ~~Category Service~~
  * ~~Create Category~~
  * ~~Update Category Field~~
  * ~~Delete Category~~
  * ~~Get All Categories for Cloud~~
  * ~~Get Category~~
* ~~Customer Service~~
  * ~~Get Customer~~
  * ~~Delete Customer~~
  * ~~Update Customer Field~~
  * ~~Create Customer~~
  * ~~Get All Customers for Cloud~~
* ~~Employee Service~~
  * ~~Get Employee~~
  * ~~Get All Employees for Cloud~~
  * ~~Delete Employee~~
  * ~~Update Employee Field~~
  * ~~Create Employee~~
* OAuth2 Login Service
  * ~~API-token login~~
  * ~~Get API-token~~
  * Login for other Networks
* POS action service
  * Create order
  * Add order item
  * Update order
  * Issue order
  * Issue and pay order
* ~~Product Service~~
  * ~~Get All Products with stockstatus~~
  * ~~Get Product~~
  * ~~Get Product with stockstatus~~
  * ~~Get Product stockstatus~~
  * ~~Delete Product~~
  * ~~Get All Products for Cloud~~
  * ~~Get All Ingredients for Product~~
  * ~~Update Product Field~~
  * ~~Create Product~~
  * ~~Create/Update Ingredient for Product~~ //not tested yet
  * ~~Get All Ingredients for Cloud~~ 
  * ~~Delete Ingredient for Product~~ //not tested yet
* Reservation Service
  * Update Reservation Field
  * Delete Reservation
  * Create Reservation
  * Get All Reservations for Cloud
  * Get Reservation
* ~~Sales Service~~
  * ~~Base sales report~~
  * ~~Get Receipt by ID~~
  * ~~Get Order by ID for Branch~~
  * ~~Get Order by ID~~
  * ~~Get Moneylog by ID for Branch~~
  * ~~Get All Orders for Cloud~~
  * ~~Get All Orders for Branch~~
  * ~~Get all open Orders for Branch~~
  * ~~Get All Receipts for Cloud~~
  * ~~Get All Receipts for Branch~~
  * ~~Get All Moneylogs for Branch~~
  * ~~Get All Moneylogs for Cloud~~
  * ~~Get All Shift ranges for Branch~~
* Stock Service
  * Stockup/Correction
  * Get Warehouse list
  * Product sale
  * Upload delivery note
* ~~Suppliers Service~~
  * ~~Get Supplier~~
  * ~~Get All Suppliers for Cloud~~
  * ~~Delete Supplier~~
  * ~~Update Supplier Field~~
  * ~~Create Supplier~~
* ~~Tableseats Service~~
  * ~~Get Tableseat by ID for Branch~~
  * ~~Get All Tableseats for Branch~~
* ~~Tag Service~~
  * ~~Get Tag~~
  * ~~Get All Tags for Cloud~~
  * ~~Create Tag~~
* ~~Warehouse Service~~
  * ~~Get Warehouse~~
  * ~~Create Warehouse~~
  * ~~Get All Warehouses for Cloud~~
  * ~~Delete Warehouse~~
  * ~~Update Warehouse Field~~



Dotykacka API V2 service coverage:
* Branch Service
    * ~~Get branches~~
    * ~~Get branch~~
* Cloud Service
    * ~~Get clouds~~
    * ~~Get cloud~~
* Category Service
    * ~~Get categories~~
    * ~~Get category~~
    * ~~Create new category~~
    * ~~Replace a single category~~
    * ~~Replace many categories~~
    * ~~Update a single category~~
    * ~~Delete a single category~~
* Customers Service
    * ~~Get customers~~
    * ~~Get customer~~
    * ~~Create new customers~~
    * ~~Replace a single customer~~
    * ~~Replace many customers~~
    * ~~Update a single customer~~
    * ~~Delete a single customer~~
* Delivery Service - not going to be supported atm - feel free to make pull request
    * Upload delivery note 
* EET-subject Service - not going to be supported atm - feel free to make pull request
    * Get EET subjects
    * Get EET subject
    * Create EET subject
    * Replace or create EET subjects
    * Replace or create EET subject
    * Partial update EET subject
    * Delete EET subject
* Employee Service
    * ~~Get employees~~
    * ~~Get employee~~
    * ~~Create employee~~
    * ~~Replace or create employees~~
    * ~~Replace or create employee~~
    * ~~Partial update of employee~~
    * ~~Delete employee~~
    * Set employee access pin
* MoneyLog Service
    * ~~Get money logs~~
    * ~~Get money log~~
* Order Service
    * ~~Get orders~~
    * ~~Get order~~
* Order Item Service - not going to be supported atm - feel free to make pull request
    * Get order items
    * Get order item
* Products Service
    * ~~Get products~~
    * ~~Get product~~
    * ~~Create new products~~
    * ~~Replace a single product~~
    * ~~Replace many products~~
    * ~~Update a single product~~
    * ~~Delete a single product~~
* Product Customization Service
    * ~~Get product customizations~~
    * ~~Get product customization~~
    * ~~Create new product customization~~
    * ~~Replace a single product customization~~
    * ~~Replace many product customizations~~
    * ~~Update a single product customization~~
    * ~~Delete a single product customization~~
* Product Ingredient Service
    * ~~Get product ingredients~~
    * ~~Get product ingredient~~
    * ~~Create new product ingredient~~
    * ~~Replace a single product ingredient~~
    * ~~Replace many product ingredients~~
    * ~~Update a single product ingredient~~
    * ~~Delete a single product ingredient~~
* Reservation Service - not going to be supported atm - feel free to make pull request
    * Get reservations
    * Get reservation
    * Create reservation
    * Replace or create reservations
    * Replace or create reservation
    * Partial update of reservation
    * Delete reservation 
* Supplier Service
    * ~~Get suppliers~~
    * ~~Get supplier~~
    * ~~Create supplier~~
    * ~~Replace or create suppliers~~
    * ~~Replace or create supplier~~
    * ~~Partial update of supplier~~
    * ~~Delete supplier~~ 
* Table Service
    * ~~Get tables~~
    * ~~Get table~~
* Tag Service
    * ~~Get tags~~
    * ~~Get tag~~
    * ~~Create tags~~
* Warehouse Service
    * ~~Get warehouses~~
    * ~~Get warehouse~~
    * ~~Products on warehouse~~
    * ~~Product on warehouse~~
    * ~~Create new warehouse~~
    * ~~Replace a single warehouse~~
    * ~~Replace many warehouses~~
    * ~~Update a single warehouse~~
    * ~~Delete a single warehouse~~
    * ~~Stockup to warehouse~~
    * Transfer to warehouse
    * Sale product on warehohouse
* Warehouse Branch Service
    * ~~Get warehouse branches~~
    * ~~Get warehouse branche~~
    * ~~Create new warehouse branch~~
    * ~~Replace a single warehouse branch~~
    * ~~Replace many warehouses branches~~
    * ~~Update a single warehouse branch~~
    
## Running unit tests
```
gradlew clean test 
```
## Running integration tests
These tests are rather symbolic. Their purpose is to verify whether connectivity works fine,
 endpoints are satisfied with given parameters and unmarshalling response objects works fine.
```
DOTYKACKA_API_URL="https://api.dotykacka.cz" \
CLOUD_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
BRANCH_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
WAREHOUSE_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ORDER_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
RECEIPT_ITEM_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
MONEYLOG_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
TAG_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
TABLESEAT_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
PRODUCT_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
API_TOKEN_USERNAME=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
API_TOKEN_PASSWORD=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_API_TOKEN=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_USERNAME=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_PASSWORD=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
gradlew clean testIntegration i
```
XXXXXXXXXXX marks should be removed with proper env variables,
for test purposes you could use following, however it does not allow you to modify anything
```
API_TOKEN_USERNAME=demo@dotykacka.cz
API_TOKEN_PASSWORD=touchpo_84406
CLOUD_ID=342606595
BRANCH_ID=137478353
ORDER_ID=1558868434627849
RECEIPT_ITEM_ID=0
MONEYLOG_ID=0
TAG_ID=0
TABLESEAT_ID=0
PRODUCT_ID=0
WAREHOUSE_ID=1056670791789808
ACCESS_TOKEN_USERNAME=touchpo
ACCESS_TOKEN_PASSWORD=touchPo!2016api
```
