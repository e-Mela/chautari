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
public class SecurityQuestion {
  @JsonProperty("question")
  private String question = null;

  @JsonProperty("answer")
  private String answer = null;
}

