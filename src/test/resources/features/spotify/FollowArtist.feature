Feature: Follow Artist

  Scenario: Follow artist
    Given I have valid auth
    When I follow the artist with id 2DaxqgrOhkeH0fpeiQq2f4
    Then the response status 204 will be returned
    And the artist with id 2DaxqgrOhkeH0fpeiQq2f4 will be returned in my followed artists list
    When I unfollow the artist with id 2DaxqgrOhkeH0fpeiQq2f4
    Then the response status 204 will be returned
    And no artists will be returned in my followed artists list