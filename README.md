Internal booking application
-
Overview

This is an application for user to create trade and generate trade report via API request.

1. - Start the application on your desired IDE (Developed on Intellij) after Maven Reload Project
    - Or Run mvn install and mvn spring-boot:run
    - App starts at http://localhost:8080

2. Go to http://localhost:8080/h2-console for h2 db.

3. Some mocking data should be added to h2 db runnding flyway script.
4. Trade can be created by calling POST create trade API http://localhost:8080/v1/trade/create, as long as brokerId and productId are valid, for detail please see postman collection / swagger.
5. Report can be generated by calling POST trade report http://localhost:8080/v1/trade/report, productType, productSubType and brokerId are required, tradeDate is optional, for detail please see postman collection / swagger.
6. If testing with other productType is needed, please modify the flyway script inserting data, as creating product / broker are not required / out of scope at this stage.


Assumption 
-

- There would be a dropdown / selection for user to select productType, broker and tradeDate.
- Products, brokers, and their relationship are pre-defined. User cannot modify at this stage, but can be modified by admin.
- Domain Driven Design is not require, otherwise productEntityRepository and brokerEntityRepository should not be in TradeBizSvcImpl.
- Assume the user cannot select the time of the trade, so all time stored and query will be the same.
- Assume storing the product's properties in productName in each trade, and no specific format on them, as long as consistent for each productType. 

Thoughts
- 
Request Body
- Could enhance to Array of Object with Key, Value and operator for dynamic filter, done by criteria API and Specification. But no required for current requirement.
- For productType and productSubType, there could be another table to store the productType, and filter by productTypeId. But split into two String query at this stage, in case there is feature to generate report at a higher level, e.g. Swap, Bond
-
Report
- Extended report format could be some child class inherits TradeDTO.  

Testing
1. To run test, run "mvn clean test"
- Due to lack of knowledge in mockito, I put repository query in Service Test, which should be done via Mockito to mock.