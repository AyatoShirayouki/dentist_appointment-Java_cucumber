
Feature: Dentist Appointment

	Background:
	 Given User opens the reservation window

  Scenario: User makeas an appointment with valid date, time, role and user
    When Enters valid date
    And Enters valid hour
    And Enters valid role
    And Enters valid user credentials
    And Presses the send button
    Then Sees a success message
    
    Scenario: User makeas an appointment withot entering a date
    When Enters valid hour
    And Enters valid role
    And Enters valid user credentials
    And Presses the send button
    Then Sees a missing date message
    
    Scenario: User makeas an appointment withot entering a time
    When Enters valid date
    And Enters valid role
    And Enters valid user credentials
    And Presses the send button
    Then Sees a missing hour message
    
    Scenario: User makeas an appointment withot entering a role
    When Enters valid date
    And Enters valid hour
    And Enters valid user credentials
    And Presses the send button
    Then Sees a missing role message
    
    Scenario: User makeas an appointment withot entering user credentials
    When Enters valid date
    And Enters valid hour
    And Enters valid role
    And Presses the send button
    Then Sees a missing user credentials message
    
    Scenario: User makeas an appointment withot input data
    When Presses the send button
    Then Sees a missing input data message

