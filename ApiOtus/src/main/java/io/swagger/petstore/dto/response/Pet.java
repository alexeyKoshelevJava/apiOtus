
package io.swagger.petstore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

  @JsonProperty("category")
  private Category mCategory;

  @JsonProperty("id")
  private Long mId;

  @JsonProperty("name")
  private String mName;

  @JsonProperty("photoUrls")
  private List<String> mPhotoUrls;

  @JsonProperty("status")
  private String mStatus;

  @JsonProperty("tags")
  private List<Tag> mTags;
}


