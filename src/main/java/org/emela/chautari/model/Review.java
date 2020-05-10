package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Review
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class Review   {
  /**
   * Gets or Sets like
   */
  public enum LikeEnum {
    NUMBER_1(1),
    
    NUMBER_2(2),
    
    NUMBER_3(3),
    
    NUMBER_4(4),
    
    NUMBER_5(5);

    private Integer value;

    LikeEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LikeEnum fromValue(String text) {
      for (LikeEnum b : LikeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("like")
  private LikeEnum like = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("reviewer")
  private String reviewer = null;

  public Review like(LikeEnum like) {
    this.like = like;
    return this;
  }

  /**
   * Get like
   * @return like
  **/
  @ApiModelProperty(value = "")


  public LikeEnum getLike() {
    return like;
  }

  public void setLike(LikeEnum like) {
    this.like = like;
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
  @ApiModelProperty(value = "")


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
    return Objects.equals(this.like, review.like) &&
        Objects.equals(this.comment, review.comment) &&
        Objects.equals(this.reviewer, review.reviewer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(like, comment, reviewer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
    
    sb.append("    like: ").append(toIndentedString(like)).append("\n");
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

