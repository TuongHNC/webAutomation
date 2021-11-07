Feature: Searching weather on weather map

  @SmokeTest @Route @KP-TC-5981
  @testcasekey=KP-TC-5981
  Scenario: Direct search on Open Weather Map
    Given user navigates to the URL 'https://openweathermap.org/'
    Then user wait for 10 seconds
