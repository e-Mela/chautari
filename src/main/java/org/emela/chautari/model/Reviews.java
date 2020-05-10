package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.emela.chautari.model.Review;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reviews
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class Reviews   {
  @JsonProperty("avarage-like")
  private BigDecimal avarageLike = null;

  @JsonProperty("reviews")
  @Valid
  private List<Review> reviews = null;

  public Reviews avarageLike(BigDecimal avarageLike) {
    this.avarageLike = avarageLike;
    return this;
  }

  /**
   * Get avarageLike
   * @return avarageLike
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getAvarageLike() {
    return avarageLike;
  }

  public void setAvarageLike(BigDecimal avarageLike) {
    this.avarageLike = avarageLike;
  }

  public Reviews reviews(List<Review> reviews) {
    this.reviews = reviews;
    return this;
  }

  public Reviews addReviewsItem(Review reviewsItem) {
    if (this.reviews == null) {
      this.reviews = new ArrayList<>();
    }
    this.reviews.add(reviewsItem);
    return this;
  }

  /**
   * Get reviews
   * @return reviews
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reviews reviews = (Reviews) o;
    return Objects.equals(this.avarageLike, reviews.avarageLike) &&
        Objects.equals(this.reviews, reviews.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avarageLike, reviews);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reviews {\n");
    
    sb.append("    avarageLike: ").append(toIndentedString(avarageLike)).append("\n");
    sb.append("    reviews: ").append(toIndentedString(reviews)).append("\n");
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

