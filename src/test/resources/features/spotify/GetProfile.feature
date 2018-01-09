Feature: Profile

# Use https://any-api.com/spotify_com/spotify_com/console/_me/GET to create an auth token and then update
# the token in the relevant properties file

  Scenario: Get profile
    Given I have valid auth
    When I get profile
    Then the response status 200 will be returned
    And the profile will be returned

  Scenario: Get profile using invalid auth
    Given I have invalid auth
    When I get profile
    Then the response status 401 will be returned
