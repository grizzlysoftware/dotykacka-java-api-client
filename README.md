#Dotykacka Java API Client
Compatible with Dotykacka api version 2.x?

## Recommended pre-requisities
* Java 11
* Gradle 6.0.2

## Artifact

### Maven
```
<dependency>
    <groupId>pl.grizzlysoftware</groupId>
    <artifactId>dotykacka-java-api-client</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Gradle

```
compile group: 'pl.grizzlysoftware', name: 'dotykacka-java-api-client', version: '2.0.0'
```

## Dotykacka API coverage progress
Scratched elements means - DONE

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
* Order Item Service
    * ~~Get order items~~
    * ~~Get order item~~
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
* Reservation Service
    * ~~Get reservations~~
    * ~~Get reservation~~
    * ~~Create reservation~~
    * ~~Replace or create reservations~~
    * ~~Replace or create reservation~~
    * ~~Partial update of reservation~~
    * ~~Delete reservation~~ 
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
Currently there are no integration tests, these will be developed sooner or later... or never ;)
