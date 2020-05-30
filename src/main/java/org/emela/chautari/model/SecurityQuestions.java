package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * SecurityQuestions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-30T14:35:06.739204-04:00[America/New_York]")

public class SecurityQuestions   {
  @JsonProperty("question")
  private String question = null;

  @JsonProperty("answer")
  private String answer = null;

  public SecurityQuestions question(String question) {
    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public SecurityQuestions answer(String answer) {
    this.answer = answer;
    return this;
  }

  /**
   * Get answer
   * @return answer
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityQuestions securityQuestions = (SecurityQuestions) o;
    return Objects.equals(this.question, securityQuestions.question) &&
        Objects.equals(this.answer, securityQuestions.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question, answer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityQuestions {\n");
    
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
    sb.append("    answer: ").append(toIndentedString(answer)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

