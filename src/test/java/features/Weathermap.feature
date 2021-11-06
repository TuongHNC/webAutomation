Feature: Searching weather on weather map

  @parallel
  Scenario: Direct search on Google Chrome
    Given user navigates to the URL 'https://openweathermap.org/'
    Then user wait for 10 seconds
