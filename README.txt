# evaluation_automation_test
Automation test for Evaluation

System Requirements
===================

1. Internet Connectivity and ability to connect maven central repository to download dependencies

2. Apache maven 3.5.0 or higher

3. Java SE Development Kit 1.8 or higher

4. Git version control support


Installation and Running
========================

1. Clone the repository https://github.com/dharshanaw/evaluation_automation_test
git clone https://github.com/dharshanaw/

2. Go to project directory evaluation_automation_test
   cd <git_Checkout_Directory>/evaluation_automation_test

3. Run execute test suite using maven
   <project_home>$ mvn clean install

4. If you are running the test directly by the IDE please set following system variable
for API URL
   apiBackendUrl = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false

Please Note: If you are running maven clean local repository it will take some time to get all maen plugins required. (Only for the first time)


Evaluation of test results
===================
This test module is configured with the Maven Surefire plugin therefire you can find
all the reports under <Build_Home>/target/surefire-reports/ directory.


