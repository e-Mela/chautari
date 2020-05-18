package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse {
  @JsonProperty("user-id")
  private String userId;

  @JsonProperty("valid-user")
  private boolean validUser;

  @JsonProperty("message")
  private String message;
}

