#Dotykacka Java API Client
Compatible with Dotykacka api version 1.62

## Recommended pre-requisities
* Java 11
* Gradle 6.0.2

## Running unit tests
```
gradlew clean test 
```
## Running integration tests
```
DOTYKACKA_API_URL="https://api.dotykacka.cz" \
CLOUD_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
WAREHOUSE_ID=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
API_TOKEN_USERNAME=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
API_TOKEN_PASSWORD=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_API_TOKEN=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_USERNAME=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
ACCESS_TOKEN_PASSWORD=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \
gradlew clean testIntegration i
```
XXXXXXXXXXX marks should be removed with proper env variables,
for test purposes you could use following
```
API_TOKEN_USERNAME=demo@dotykacka.cz
API_TOKEN_PASSWORD=touchpo_84406
ACCESS_TOKEN_USERNAME=touchpo
ACCESS_TOKEN_PASSWORD=touchPo!2016api
```
