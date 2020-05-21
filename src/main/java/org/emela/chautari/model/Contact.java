package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Contact {
  @JsonProperty("phoneNumber")
  private String phoneNumber;

  @JsonProperty("email")
  private String email;
}


