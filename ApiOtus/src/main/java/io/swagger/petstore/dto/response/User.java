
package io.swagger.petstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String email;

  private String firstName;

  private Long id;

  private String lastName;

  private String password;

  private String phone;

  private Long userStatus;

  private String username;

}

