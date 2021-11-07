Feature: Searching weather on weather map

  @SmokeTest
  Scenario Outline: Direct search "<city Name>" on Open Weather Map
    Given user navigates to the URL 'https://openweathermap.org/find?q'
    When input search "<city Name>" into the search text field
    And click on the search icon
    Then validate the result is displayed
    When click on the city name in the result

    Examples:
      | city Name |
      | Ha Noi    |
      | Can Tho   |
