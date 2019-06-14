Feature: Main

  @smoke
  @main
  Scenario: User notification
    Given I've launched "com.android.example.MainActivity"
    When I click "fab" widget
    Then I should see "Replace with your own action"
  