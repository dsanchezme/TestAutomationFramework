# Challenge - Test Automation Framework   

Test automation framework for [The Movie Database](https://www.themoviedb.org/) - [API Layer](https://developers.themoviedb.org/4/getting-started)
by _Diego Sanchez_

### Type 
**Modular**
- Test scripts are developed on the basis of modules or clusters by dividing the entire application into several small and self-sufficient blocks.
- The smaller modules in the framework communicate with each other in a hierarchical manner to form a large script which is capable of testing an entire scenario.

### Tools

- #### Library management 

  **[Maven](https://maven.apache.org/)**

  - The process of project building is simplified and well organized.
  - Used before
  - It is not necessary to have such a customized building for this project. 

- #### Test runner
  
  **[JUnit5]()**
  - JUnit tests can be organized into test suites containing test cases and even other test suites.
  - Provides annotations to identify test methods.
  - JUnit 5 is divided into several modules, you need at least JUnit Platform and JUnit Jupiter to write tests in JUnit 5.

  **[TestNG](https://testng.org/doc/)** 
  - Similar to [JUnit](https://junit.org/junit5/), TestNG provides initialization and cleanup at the method and class level
  - TestNG offers some annotations for configurations at suite and group levels.
  - JUnit does not support parallel execution of tests, but TestNG does.

- #### Reporting 

  **[Allure](https://qameta.io/allure-report/)**
    - Compared to [ExtentReports](https://www.extentreports.com/) it is much easier to work with and has more features in built, specially the nice dashboard it provides.
    - Allure Reporting framework works fine with any test framework like TestNG.

- #### Logging

  **[Log4J 2](https://logging.apache.org/log4j/2.x/)**
  - Active community.
  - So like [Logback](https://logback.qos.ch/), Log4j2 provides support for [SLF4J](https://www.slf4j.org/), automatically reloads the log settings, and supports advanced filtering options.

- #### Serialization
  
  **[Jackson](https://github.com/FasterXML/jackson)**
  - It’s a very fast and lightweight library.
  - It provides Data Binding functionality that can be used to convert Java objects into their JSON representation.
  - It can also be used to convert a JSON string to an equivalent Java object.
  - It can be difficult to reverse certain operations performed by the library, such as converting back from JSON to Java.
  
  **[Gson](https://github.com/google/gson)**
  - Simple tools for Java object JSON serialization and deserialization.
  - Extensive support of Java Generics.
  - Fast with a low memory footprint.
  - It allows a compact output and pretty printing.

### References

- [Explain modular automation framework](https://www.tutorialspoint.com/explain-modular-automation-framework)
- [Difference between Gradle and Maven](https://www.geeksforgeeks.org/difference-between-gradle-and-maven/)
- [JUnit Setup Maven - JUnit 4 and JUnit 5](https://www.digitalocean.com/community/tutorials/junit-setup-maven)
- [TestNG vs JUnit: Test case Management in TestNG and JUnit frameworks](https://www.lambdatest.com/blog/testng-vs-junit-which-testing-framework-should-you-choose/)
- [Gradle vs Maven: Definiciones y diferencias principales](https://www.chakray.com/es/gradle-vs-maven-definiciones-diferencias/)
- [A Quick JUnit vs TestNG Comparison](https://www.baeldung.com/junit-vs-testng)
- [Importance of Reporting in a Test Automation Framework](https://www.linkedin.com/pulse/importance-reporting-test-automation-framework-kushan-amarasiri)
- [Allure Reporting in Selenium using TestNG and Maven](https://medium.com/@sonaldwivedi/allure-reporting-in-selenium-using-testng-and-maven-8a3a5ff07856)
- [Java Logging Frameworks: log4j vs logback vs log4j2](https://stackify.com/compare-java-logging-frameworks/)
- [Jackson for Java. Is it more than JSON?](https://kodejava.org/jackson-for-java-is-it-more-than-json/)
- [Serialization of Java objects using Jackson Library](https://www.techiedelight.com/serialization-java-objects-jackson-library/)
- [Google GSON Tutorial](https://www.javaguides.net/p/google-gson-tutorial.html)
- [JUnit - Overview](https://www.tutorialspoint.com/junit/junit_overview.htm)
- [dotenv-java dependency](https://github.com/cdimascio/dotenv-java)