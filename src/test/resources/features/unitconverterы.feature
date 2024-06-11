@unitconverters

  Feature: Validate unit converters main functionality

    @unitconverters1
    Scenario: 
      Given user is on the Unit converters page
      When they select unit "Temperature"
      And they select from "Fahrenheit" to "Celsius"
      And set initial value to "5"
      Then they see the calculation result is "-15"

