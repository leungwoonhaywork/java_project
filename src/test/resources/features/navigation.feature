Feature: Being able to navigate to pages on Hacker News

  Background: Starting from the homepage
    Given I am on the homepage

  @pastsTest
  Scenario: Going to the pasts page from the home page
    Given I am on the homepage
    When I click the pasts link
    Then I will go to the past page

  Scenario: Going to the comments page from the pasts page
    Given I am on the homepage
    When I click the comments link
    Then I will go to the comments page
