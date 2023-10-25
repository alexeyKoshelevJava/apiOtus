package io.swagger.petstore.petprovider;

import io.swagger.petstore.dto.response.Category;
import io.swagger.petstore.dto.response.Pet;
import io.swagger.petstore.dto.response.Tag;
import io.swagger.petstore.dto.response.User;

import java.util.Arrays;
import java.util.List;

public class DataProvider {

  public Pet createPet() {
    Category category = Category.builder()
        .mId(0L)
        .mName("something")
        .build();
    Tag tag = Tag.builder()
        .mId(0L)
        .mName("something")
        .build();
    return Pet.builder()
       .mId(5L).mCategory(category)
       .mName("doggie")
       .mPhotoUrls(List.of("something"))
       .mTags(List.of(tag))
       .mStatus("available")
       .build();
  }
  public User createUser() {
    return User.builder()
        .id(7L)
        .username("worker")
        .firstName("Sergey")
        .lastName("Sergeev")
        .email("serg@mail.ru")
        .password("123")
        .phone("+79258597412")
        .userStatus(0L)
        .build();
  }
}

