package io.swagger.petstore.services;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.swagger.petstore.dto.response.Pet;
import io.swagger.petstore.petprovider.DataProvider;
import io.swagger.petstore.specification.Specification;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class PetApi {
  private final Specification specification = new Specification();
  private final DataProvider dataProvider = new DataProvider();

  @Step("Получить Pet по Id {id}")
  public Pet getPetById(String id) {
    return given()
        .spec(specification.requestSpec())
        .when()
        .get(String.format("/pet/%s", id))
        .then()
        .log().body()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/pet.json"))
        .spec(specification.responseSpec())
        .extract()
        .body().as(Pet.class);
  }

  @Step("Обновить значение Pet")
  public Pet setPet(Pet pet) {
    return given()
        .spec(specification.requestSpec())
        .body(dataProvider.createPet())
        .when()
        .put("/pet")
        .then()
        .log().body()
        .spec(specification.responseSpec())
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/pet.json"))
        .extract()
        .body().as(Pet.class);
  }

  @Step("Проверить что имя Pet соответствует ожидаемому")
  public void checkName(String expectedName, String actualName) {
    Assert.assertEquals(expectedName, actualName,
        "Имя не соответствует ожидаемому : " + expectedName);
  }
  @Step("Проверить что имя Category соответствует ожидаемому")
  public void checkCategoryName(String expectedName, String actualName) {
    Assert.assertEquals(expectedName, actualName,
        "Имя не соответствует ожидаемому : " + expectedName);
  }
}
