package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RentalItemDetailFeatures
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-06-27T09:23:19.665-04:00[America/New_York]")

public class RentalItemDetailFeatures   {
  @JsonProperty("available")
  @Valid
  private List<String> available = null;

  @JsonProperty("not-available")
  @Valid
  private List<String> notAvailable = null;

  public RentalItemDetailFeatures available(List<String> available) {
    this.available = available;
    return this;
  }

  public RentalItemDetailFeatures addAvailableItem(String availableItem) {
    if (this.available == null) {
      this.available = new ArrayList<>();
    }
    this.available.add(availableItem);
    return this;
  }

  /**
   * Get available
   * @return available
  **/
  @ApiModelProperty(value = "")


  public List<String> getAvailable() {
    return available;
  }

  public void setAvailable(List<String> available) {
    this.available = available;
  }

  public RentalItemDetailFeatures notAvailable(List<String> notAvailable) {
    this.notAvailable = notAvailable;
    return this;
  }

  public RentalItemDetailFeatures addNotAvailableItem(String notAvailableItem) {
    if (this.notAvailable == null) {
      this.notAvailable = new ArrayList<>();
    }
    this.notAvailable.add(notAvailableItem);
    return this;
  }

  /**
   * Get notAvailable
   * @return notAvailable
  **/
  @ApiModelProperty(value = "")


  public List<String> getNotAvailable() {
    return notAvailable;
  }

  public void setNotAvailable(List<String> notAvailable) {
    this.notAvailable = notAvailable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentalItemDetailFeatures rentalItemDetailFeatures = (RentalItemDetailFeatures) o;
    return Objects.equals(this.available, rentalItemDetailFeatures.available) &&
        Objects.equals(this.notAvailable, rentalItemDetailFeatures.notAvailable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, notAvailable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemDetailFeatures {\n");
    
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    notAvailable: ").append(toIndentedString(notAvailable)).append("\n");
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

