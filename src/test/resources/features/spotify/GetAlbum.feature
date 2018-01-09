Feature: Album

# Use https://any-api.com/spotify_com/spotify_com/console/_albums_id_/GET to create an auth token and then update
# the token in the relevant properties file

  Scenario: Get album
    Given I have valid auth
    When I get the album 0sNOF9WDwhWunNAHPD3Baj from Spotify
    Then the response status 200 will be returned
    And the album 0sNOF9WDwhWunNAHPD3Baj will be returned

  Scenario: Get album using invalid auth
    Given I have invalid auth
    When I get the album 0sNOF9WDwhWunNAHPD3Baj from Spotify
    Then the response status 401 will be returned
