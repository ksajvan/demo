Database will execute script (src/main/resources/schema.sql) to create table and will populate data using data.sql script (src/main/resources/data.sql).

In order to have h2 console working, create directories where database will be saved
For Windows, use absolute path - check application.properties file:
example of the path and database: C:/opt/demo_h2_db/testdb
In order to be able to open console in browser, type: http://localhost:8081/h2 (if application uses different port use it instead 8081)
