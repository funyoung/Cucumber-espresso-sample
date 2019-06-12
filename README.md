## RUN BDD UI TESTS

### To run all End-to-End tests written with Cucumber and BDD execute : 

./gradlew connectedCheck -Pcucumber -Ptags="@e2e" 

also run ./gradlew connectedCheck -Pcucumber -Ptags="@smoke" to run all smoke BDD tests

### To run individual feature test execute : 

./gradlew connectedCheck -Pcucumber -Pscenario="Successful login"


branch another-sample imports anthoer java (legancy project)[https://github.com/a11n/android-cucumber-espresso.git]
