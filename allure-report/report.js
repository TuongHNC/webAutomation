$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Weathermap.feature");
formatter.feature({
  "line": 1,
  "name": "Searching weather on weather map",
  "description": "",
  "id": "searching-weather-on-weather-map",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Direct search \"\u003ccity Name\u003e\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"\u003ccity Name\u003e\" into the search text field",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;",
  "rows": [
    {
      "cells": [
        "city Name"
      ],
      "line": 15,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;1"
    },
    {
      "cells": [
        "Ha Noi, VN"
      ],
      "line": 16,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;2"
    },
    {
      "cells": [
        "Can Tho, VN"
      ],
      "line": 17,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;3"
    },
    {
      "cells": [
        "Ho Chi Minh, VN"
      ],
      "line": 18,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;4"
    },
    {
      "cells": [
        "Da Nang, VN"
      ],
      "line": 19,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;5"
    },
    {
      "cells": [
        "Da Lat, VN"
      ],
      "line": 20,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 12496125840,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Direct search \"Ha Noi, VN\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"Ha Noi, VN\" into the search text field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://openweathermap.org/find?q",
      "offset": 27
    }
  ],
  "location": "WeatherMapSteps.user_navigates_to_the_URL(String)"
});
formatter.result({
  "duration": 7005154735,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ha Noi, VN",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 1375495984,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 443494599,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 883829823,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 5433023121,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCurrentDateTime()"
});
formatter.result({
  "duration": 2704300760,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCityAndCountryName()"
});
formatter.result({
  "duration": 192036846,
  "error_message": "java.lang.AssertionError: Verify the City and Country name expected [Ha Noi, VN] but found [Hanoi, VN]\n\tat org.testng.Assert.fail(Assert.java:94)\n\tat org.testng.Assert.failNotEquals(Assert.java:494)\n\tat org.testng.Assert.assertEquals(Assert.java:123)\n\tat org.testng.Assert.assertEquals(Assert.java:176)\n\tat steps.WeatherMapSteps.verifyTheCityAndCountryName(WeatherMapSteps.java:77)\n\tat ✽.Then verify the city and country name(src/test/java/features/Weathermap.feature:11)\n",
  "status": "failed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheTemperatureDisplayRegardlessItsNumber()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 6727071941,
  "status": "passed"
});
formatter.after({
  "duration": 370325082,
  "status": "passed"
});
formatter.before({
  "duration": 1005754649,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Direct search \"Can Tho, VN\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"Can Tho, VN\" into the search text field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://openweathermap.org/find?q",
      "offset": 27
    }
  ],
  "location": "WeatherMapSteps.user_navigates_to_the_URL(String)"
});
formatter.result({
  "duration": 27446488157,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Can Tho, VN",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 1351877853,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 479439184,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 810891883,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 5624486445,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCurrentDateTime()"
});
formatter.result({
  "duration": 2748163420,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCityAndCountryName()"
});
formatter.result({
  "duration": 59256702,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheTemperatureDisplayRegardlessItsNumber()"
});
formatter.result({
  "duration": 228214072,
  "status": "passed"
});
formatter.after({
  "duration": 336307635,
  "status": "passed"
});
formatter.after({
  "duration": 366242053,
  "status": "passed"
});
formatter.before({
  "duration": 1001733394,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Direct search \"Ho Chi Minh, VN\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"Ho Chi Minh, VN\" into the search text field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://openweathermap.org/find?q",
      "offset": 27
    }
  ],
  "location": "WeatherMapSteps.user_navigates_to_the_URL(String)"
});
formatter.result({
  "duration": 14108941216,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ho Chi Minh, VN",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 551180085,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 406833911,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 1288320094,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 4842385319,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCurrentDateTime()"
});
formatter.result({
  "duration": 2541206834,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCityAndCountryName()"
});
formatter.result({
  "duration": 84897692,
  "error_message": "java.lang.AssertionError: Verify the City and Country name expected [Ho Chi Minh, VN] but found [Ho Chi Minh City, VN]\n\tat org.testng.Assert.fail(Assert.java:94)\n\tat org.testng.Assert.failNotEquals(Assert.java:494)\n\tat org.testng.Assert.assertEquals(Assert.java:123)\n\tat org.testng.Assert.assertEquals(Assert.java:176)\n\tat steps.WeatherMapSteps.verifyTheCityAndCountryName(WeatherMapSteps.java:77)\n\tat ✽.Then verify the city and country name(src/test/java/features/Weathermap.feature:11)\n",
  "status": "failed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheTemperatureDisplayRegardlessItsNumber()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4351315119,
  "status": "passed"
});
formatter.after({
  "duration": 642084822,
  "status": "passed"
});
formatter.before({
  "duration": 1004938655,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Direct search \"Da Nang, VN\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"Da Nang, VN\" into the search text field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://openweathermap.org/find?q",
      "offset": 27
    }
  ],
  "location": "WeatherMapSteps.user_navigates_to_the_URL(String)"
});
formatter.result({
  "duration": 24711752958,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Da Nang, VN",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 1244288220,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 282934964,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 593778057,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 4870367368,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCurrentDateTime()"
});
formatter.result({
  "duration": 2628487589,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCityAndCountryName()"
});
formatter.result({
  "duration": 53689213,
  "error_message": "java.lang.AssertionError: Verify the City and Country name expected [Da Nang, VN] but found [Turan, VN]\n\tat org.testng.Assert.fail(Assert.java:94)\n\tat org.testng.Assert.failNotEquals(Assert.java:494)\n\tat org.testng.Assert.assertEquals(Assert.java:123)\n\tat org.testng.Assert.assertEquals(Assert.java:176)\n\tat steps.WeatherMapSteps.verifyTheCityAndCountryName(WeatherMapSteps.java:77)\n\tat ✽.Then verify the city and country name(src/test/java/features/Weathermap.feature:11)\n",
  "status": "failed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheTemperatureDisplayRegardlessItsNumber()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3688156089,
  "status": "passed"
});
formatter.after({
  "duration": 591081356,
  "status": "passed"
});
formatter.before({
  "duration": 1002057754,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Direct search \"Da Lat, VN\" on Open Weather Map",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to the URL \u0027https://openweathermap.org/find?q\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "input search \"Da Lat, VN\" into the search text field",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on the search icon",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the current date time",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "verify the city and country name",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "validate the temperature display regardless its number",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://openweathermap.org/find?q",
      "offset": 27
    }
  ],
  "location": "WeatherMapSteps.user_navigates_to_the_URL(String)"
});
formatter.result({
  "duration": 24551868260,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Da Lat, VN",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 710334208,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 296152169,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 594895527,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 4153453790,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCurrentDateTime()"
});
formatter.result({
  "duration": 2061595086,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.verifyTheCityAndCountryName()"
});
formatter.result({
  "duration": 95488073,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheTemperatureDisplayRegardlessItsNumber()"
});
formatter.result({
  "duration": 118661172,
  "status": "passed"
});
formatter.after({
  "duration": 147796291,
  "status": "passed"
});
formatter.after({
  "duration": 498657962,
  "status": "passed"
});
});