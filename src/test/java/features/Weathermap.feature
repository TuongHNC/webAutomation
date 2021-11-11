Feature: Searching weather on weather map

  @SmokeTest
  Scenario Outline: Direct search "<city Name>" on Open Weather Map
    Given user navigates to the URL 'https://openweathermap.org/find?q'
    When input search "<city Name>" into the search text field
    And click on the search icon
    Then verify the result is displayed
    When click on the city name in the result
    Then verify the current date time
    Then verify the city and country name
    Then validate the temperature display regardless its number

    Examples:
      | city Name       |
      | Hanoi, VN       |
      | Can Tho, VN     |
#      | Ho Chi Minh, VN |
#      | Da Nang, VN     |
      | Da Lat, VN      |
      | Thai Binh, VN   |
