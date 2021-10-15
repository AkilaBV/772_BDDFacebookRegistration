#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: FaceBook Registartion
 

@group1
  Scenario: validate title
    Given browser details
    And url details
    When Load page
    Then I validate page title and print title
    
 Scenario: validate Signin Page is opened
     Given browser details
    And url details
    When Load page
    Given Sign in button
     When clicked on it 
 Then Sign In form is dispalyed
 Given First name 
 |Learn|IT|319-804-0682|Learn123|Nov|15|2002|Female|
 
 