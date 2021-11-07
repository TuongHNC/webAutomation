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
  "name": "validate the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;",
  "rows": [
    {
      "cells": [
        "city Name"
      ],
      "line": 12,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;1"
    },
    {
      "cells": [
        "Ha Noi"
      ],
      "line": 13,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;2"
    },
    {
      "cells": [
        "Can Tho"
      ],
      "line": 14,
      "id": "searching-weather-on-weather-map;direct-search-\"\u003ccity-name\u003e\"-on-open-weather-map;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11057301431,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Direct search \"Ha Noi\" on Open Weather Map",
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
  "name": "input search \"Ha Noi\" into the search text field",
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
  "name": "validate the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
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
  "duration": 15039368171,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ha Noi",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 1209954663,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 329446577,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 591939942,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 14717791547,
  "status": "passed"
});
formatter.after({
  "duration": 1716023844,
  "status": "passed"
});
formatter.after({
  "duration": 374947763,
  "status": "passed"
});
formatter.before({
  "duration": 1000499975,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Direct search \"Can Tho\" on Open Weather Map",
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
  "name": "input search \"Can Tho\" into the search text field",
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
  "name": "validate the result is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "click on the city name in the result",
  "keyword": "When "
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
  "duration": 29289610130,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Can Tho",
      "offset": 14
    }
  ],
  "location": "WeatherMapSteps.inputSearchAbcIntoTheSearchTextField(String)"
});
formatter.result({
  "duration": 1089686290,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheSearchIcon()"
});
formatter.result({
  "duration": 244745374,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.validateTheResultIsDisplayed()"
});
formatter.result({
  "duration": 683380686,
  "status": "passed"
});
formatter.match({
  "location": "WeatherMapSteps.clickOnTheCityNameInTheResult()"
});
formatter.result({
  "duration": 12921600178,
  "status": "passed"
});
formatter.after({
  "duration": 74524568,
  "status": "passed"
});
formatter.after({
  "duration": 354307621,
  "status": "passed"
});
});