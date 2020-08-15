package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Review
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-25T10:24:05.184-04:00[America/New_York]")

public class Review   {
  @JsonProperty("star")
  private Integer star = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("reviewer")
  private String reviewer = null;

  public Review star(Integer star) {
    this.star = star;
    return this;
  }

  /**
   * Get star
   * @return star
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getStar() {
    return star;
  }

  public void setStar(Integer star) {
    this.star = star;
  }

  public Review comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Review reviewer(String reviewer) {
    this.reviewer = reviewer;
    return this;
  }

  /**
   * Get reviewer
   * @return reviewer
  **/
  @ApiModelProperty(example = "10c0cca0-ce1b-11ea-87d0-0242ac130003", required = true, value = "")
  @NotNull


  public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Review review = (Review) o;
    return Objects.equals(this.star, review.star) &&
        Objects.equals(this.comment, review.comment) &&
        Objects.equals(this.reviewer, review.reviewer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(star, comment, reviewer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
    
    sb.append("    star: ").append(toIndentedString(star)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    reviewer: ").append(toIndentedString(reviewer)).append("\n");
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

