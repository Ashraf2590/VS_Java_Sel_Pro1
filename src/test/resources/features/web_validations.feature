Feature: Web Element Validations
  As a QA engineer
  I want to validate different web elements
  So that I can ensure proper functionality

  Background:
    Given I initialize the browser "chrome"

  @alert @smoke
  Scenario: Validate Alert Handling
    Given I navigate to "https://the-internet.herokuapp.com/javascript_alerts"
    When I click on "JS Alert" button
    Then I should see alert with text "I am a JS Alert"
    When I accept the alert
    Then I should see result text "You successfully clicked an alert"
    Then I close the browser

  @alert
  Scenario: Validate Confirm Alert
    Given I navigate to "https://the-internet.herokuapp.com/javascript_alerts"
    When I click on "JS Confirm" button
    Then I should see alert with text "I am a JS Confirm"
    When I dismiss the alert
    Then I should see result text "You clicked: Cancel"

  @alert
  Scenario: Validate Prompt Alert
    Given I navigate to "https://the-internet.herokuapp.com/javascript_alerts"
    When I click on "JS Prompt" button
    Then I should see alert with text "I am a JS prompt"
    When I enter text "Hello World" in alert
    Then I should see result text "You entered: Hello World"

  @wait
  Scenario: Validate Wait Functionality
    Given I navigate to "https://the-internet.herokuapp.com/dynamic_loading/1"
    When I click on start button
    Then I should wait for loading to complete
    And I should see text "Hello World!"

  @frame
  Scenario: Validate Frame Handling
    Given I navigate to "https://the-internet.herokuapp.com/nested_frames"
    When I switch to frame "frame-top"
    And I switch to frame "frame-left"
    Then I should see text "LEFT"
    When I switch to parent frame
    And I switch to frame "frame-right"
    Then I should see text "RIGHT"

  @window
  Scenario: Validate Multiple Windows
    Given I navigate to "https://the-internet.herokuapp.com/windows"
    When I click on "Click Here" link
    Then I should have 2 windows open
    When I switch to new window
    Then I should see page title "New Window"
    When I close current window
    And I switch back to main window
    Then I should see page title "The Internet"

  @teardown
  Scenario: Cleanup
    Then I close the browser
