Feature: Login

  Background:
    Given That user opens "https://www.igame.com/"
    And Clicks Login

  Scenario Outline: Positive login
    And User enters valid username <username>
    And User enters valid password <password>
    When User clicks submit
    Then User should be logged in
    Examples:
      | username                | password          |
      | hooloovoo1@yopmail.com  | 8!J]nXW;g~Rc((>%  |
      | hooloovoo2@yopmail.com  | Yh2DC#X/.*96jj+Y  |

  Scenario: Negative login
    And User enters invalid username aaaa@aaa.com
    And User enters invalid password Aw3r33er
    When User clicks submit
    Then User should still see login popup
