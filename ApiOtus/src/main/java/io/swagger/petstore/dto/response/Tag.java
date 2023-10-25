
package io.swagger.petstore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
  @JsonProperty("id")
  private Long mId;

  @JsonProperty("name")
  private String mName;
}

