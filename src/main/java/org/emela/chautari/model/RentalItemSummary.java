package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RentalItemSummary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class RentalItemSummary   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("price")
  private RentalItemPrice price = null;

  @JsonProperty("rentOf")
  private String rentOf = null;

  @JsonProperty("location")
  private Address location = null;

  @JsonProperty("image-id")
  private String imageId = null;

  public RentalItemSummary title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RentalItemSummary price(RentalItemPrice price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public RentalItemPrice getPrice() {
    return price;
  }

  public void setPrice(RentalItemPrice price) {
    this.price = price;
  }

  public RentalItemSummary rentOf(String rentOf) {
    this.rentOf = rentOf;
    return this;
  }

  /**
   * Get rentOf
   * @return rentOf
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRentOf() {
    return rentOf;
  }

  public void setRentOf(String rentOf) {
    this.rentOf = rentOf;
  }

  public RentalItemSummary location(Address location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Address getLocation() {
    return location;
  }

  public void setLocation(Address location) {
    this.location = location;
  }

  public RentalItemSummary imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

  /**
   * Get imageId
   * @return imageId
  **/
  @ApiModelProperty(value = "")


  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentalItemSummary rentalItemSummary = (RentalItemSummary) o;
    return Objects.equals(this.title, rentalItemSummary.title) &&
        Objects.equals(this.price, rentalItemSummary.price) &&
        Objects.equals(this.rentOf, rentalItemSummary.rentOf) &&
        Objects.equals(this.location, rentalItemSummary.location) &&
        Objects.equals(this.imageId, rentalItemSummary.imageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, price, rentOf, location, imageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemSummary {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    rentOf: ").append(toIndentedString(rentOf)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
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

