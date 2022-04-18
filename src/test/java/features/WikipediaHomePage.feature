Feature: UI testing of Wikipedia homepage

  Scenario Outline: Test presence of elements in the page
    Given I navigate to <page>
    When I search element by <elementXpath>
    Then It should be present on the page containing following <textValue>
    Examples:
      | page                                      | elementXpath                        | textValue        |
      | "https://en.wikipedia.org/wiki/Main_Page" | "//span[text()='Log in']"           | "Should Fail"    |
      | "https://en.wikipedia.org/wiki/Main_Page" | "//li[@id='footer-places-privacy']" | "Privacy policy" |


  Scenario Outline: Test language switching
    Given I navigate to <page>
    When I switch language to <language>
    Then I observe that static text denoting block with languages is displayed as <translatedTitle>
    Examples:
      | page                                      | language   | translatedTitle     |
      | "https://en.wikipedia.org/wiki/Main_Page" | "Italiano" | "In altre lingue"   |
      | "https://en.wikipedia.org/wiki/Main_Page" | "Hrvatski" | "Drugi jezici"      |
      | "https://en.wikipedia.org/wiki/Main_Page" | "Polski"   | "W innych językach" |















