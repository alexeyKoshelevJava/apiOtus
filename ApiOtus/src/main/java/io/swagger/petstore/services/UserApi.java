package io.swagger.petstore.services;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.swagger.petstore.dto.response.User;
import io.swagger.petstore.petprovider.DataProvider;
import io.swagger.petstore.specification.Specification;
import org.testng.Assert;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserApi {
  private final Specification specification = new Specification();
  private final DataProvider dataProvider = new DataProvider();

  @Step("Получить User по Id {id}")
  public User getUserByName(String name) {
    return given()
        .spec(specification.requestSpec())
        .when()
        .get(String.format(String.format("/user/%s", name)))
        .then()
        .log().body()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/user.json"))
        .spec(specification.responseSpec())
        .extract()
        .body().as(User.class);
  }

  @Step("Обновить значение User")
  public void setUser(User user, String userName) {
     given()
        .spec(specification.requestSpec())
        .body(user)
        .when()
        .put(String.format("/user/%s", userName))
        .then()
        .log().body()
        .spec(specification.responseSpec())
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("7"));
  }

  @Step("Создать UserList")
  public void createUsers(List<User> users) {
    given()
        .spec(specification.requestSpec())
        .body(users)
        .when()
        .post("/user/createWithList")
        .then()
        .log().body()
        .spec(specification.responseSpec())
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("ok"));
  }

  @Step("Проверить что имя firstName соответствует ожидаемому {expectedName}")
  public void checkName(String expectedName, String actualName) {
    Assert.assertEquals(expectedName, actualName,
        "Имя не соответствует ожидаемому : " + expectedName);
  }
}
