package io.swagger.petstore.specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
  public RequestSpecification requestSpec() {
    return new RequestSpecBuilder()
        .setBaseUri("https://petstore.swagger.io/v2")
        .setContentType("application/json")
        .log(LogDetail.ALL)
        .build();
  }

  public ResponseSpecification responseSpec() {

    return new ResponseSpecBuilder()
        .expectContentType(ContentType.JSON)
        .expectStatusCode(200)
        .build();

  }

  public void installSpec(RequestSpecification requestSpec) {
    RestAssured.requestSpecification = requestSpec;
  }

  public void installSpec(ResponseSpecification responseSpec) {
    RestAssured.responseSpecification = responseSpec;
  }

  public void installSpec(RequestSpecification requestSpec,
                          ResponseSpecification responseSpec) {
    RestAssured.requestSpecification = requestSpec;
    RestAssured.responseSpecification = responseSpec;
  }

  public void deleteSpec() {
    RestAssured.requestSpecification = null;
    RestAssured.responseSpecification = null;
  }

}
