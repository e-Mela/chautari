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
public class UserDetail {

  @JsonProperty("person")
  private Person person;

  @JsonProperty("address")
  private Address address;

  @JsonProperty("contact")
  private Contact contact;

  @JsonProperty("credential")
  private Credential credential;

}

