# jackson-baeldung-demo

Code from https://www.baeldung.com/jackson-object-mapper-tutorial

# To run

```
mvn clean compile exec:java
```

Note that due to the use of Lombok and `mvn exec:java` the `clean` and `compile`
steps seem to be necessary; otherwise sometimes the `Car` class is not
picked up.
