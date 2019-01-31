# Exercise 02

Expand this REST application.

Implement service `/hr/countries`. GET method must return JSON encoded array of countries.
Each element of this array must contain the following fields:

 - countryCode: two letter country code, HR.COUNTRIES(COUNTRY_ID)
 - countryName: name of country, HR.COUNTRIES(COUNTRY_NAME)
 - regionName: name of region, HR.REGIONS(REGION_NAME) 

This project builds with maven: `mvn clean install tomee:run`
