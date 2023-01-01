Appium Login Test
This is a sample test using Appium, TestNG, and Maven to test the login feature of a mobile app. The test checks that the login button exists, clicks the login button, checks that the login action button exists, and clicks the login action button. The test then checks that the app has returned to the home screen and that the login button text has been changed to a welcome message.

Prerequisites
Appium
TestNG
Maven
Running the Test
Start the Appium server.
Build the project with mvn clean install.
Run the test with mvn test.
Page Object Model
The test is implemented using the Page Object Model (POM) design pattern. The LoginPage class represents the login screen and contains methods for interacting with the login screen elements. The HomePage class represents the home screen and contains a method for getting the text of the login button.

Notes
The test is currently configured to run on an Android emulator. To run the test on an iOS simulator, change the desired capabilities in the setUp method.
The test is currently hardcoded to use a specific app package and activity. Update these values to match the package and activity of the app under test.



Here is an example of a TestNG test suite XML file:

<?xml version="1.0" encoding="UTF-8"?>
<suite name="Appium Test Suite">
    <test name="Appium Login Test">
        <classes>
            <class name="com.example.appium.LoginTest"/>
        </classes>
    </test>
</suite>


To run the tests with this test suite, you can use the following shell script:
#!/bin/bash

mvn test -Dtest=TestSuite -DfailIfNoTests=false


To run the tests with different devices in BrowserStack, you will need to pass the desired capabilities for the desired device as system properties. For example:

#!/bin/bash

mvn test -Dtest=TestSuite -DfailIfNoTests=false -DplatformName=iOS -DdeviceName="iPhone 11" -DappiumVersion=1.15.0

This will run the tests on an iPhone 11 with Appium 1.15.0 in BrowserStack. You can find a list of available desired capabilities and their values on the Appium documentation.

I hope this helps! Let me know if you have any questions.
