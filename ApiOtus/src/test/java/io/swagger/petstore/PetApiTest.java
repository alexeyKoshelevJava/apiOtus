package io.swagger.petstore;

import io.swagger.petstore.dto.response.Pet;
import io.swagger.petstore.dto.response.User;
import io.swagger.petstore.petprovider.DataProvider;
import io.swagger.petstore.services.PetApi;
import io.swagger.petstore.services.UserApi;
import org.testng.annotations.Test;

import java.util.List;

public class PetApiTest {
  private final PetApi petApi = new PetApi();
  private final UserApi userApi = new UserApi();
  private final DataProvider dataProvider = new DataProvider();

  @Test(description = "Проверка установки значения Pet",priority = 1)
  void checkingSetPet() {
    Pet pet = petApi.setPet(dataProvider.createPet());
    petApi.checkCategoryName("something", pet.getMCategory().getMName());

  }

  @Test(description = "Проверка , что по данному  Id находится Pet c именем",priority = 2)
  void getPetByIdCheckName() {
    Pet pet = petApi.getPetById("5");
    petApi.checkName("doggie", pet.getMName());
  }

  @Test(description = "Проверка создания User",priority = 3)
  void checkingCreateUser() {
    User user = dataProvider.createUser();
    userApi.createUsers(List.of(user));

  }

  @Test(description = "Проверка получения User по имени",priority = 4 )
  void checkingGetUserByName() {
    User user = userApi.getUserByName("worker");
    userApi.checkName("Sergey", user.getFirstName());
  }

  @Test(description = "Проверка обновления User по имени",priority = 5)
  void checkingSetUserByName() {
    User user = dataProvider.createUser();
    final String ivan = "Ivan";
    user.setFirstName(ivan);
    userApi.setUser(user, "worker");
  }

  @Test(description = "Проверка получения User по имени",priority = 6)
  void checkingGeUpdateUserByName() {
    User user = userApi.getUserByName("worker");
    userApi.checkName("Ivan", user.getFirstName());
  }
}
