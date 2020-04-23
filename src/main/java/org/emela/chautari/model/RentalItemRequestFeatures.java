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
 * RentalItemRequestFeatures
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

public class RentalItemRequestFeatures   {
  @JsonProperty("available")
  @Valid
  private List<String> available = null;

  @JsonProperty("not-available")
  @Valid
  private List<String> notAvailable = null;

  public RentalItemRequestFeatures available(List<String> available) {
    this.available = available;
    return this;
  }

  public RentalItemRequestFeatures addAvailableItem(String availableItem) {
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

  public RentalItemRequestFeatures notAvailable(List<String> notAvailable) {
    this.notAvailable = notAvailable;
    return this;
  }

  public RentalItemRequestFeatures addNotAvailableItem(String notAvailableItem) {
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
    RentalItemRequestFeatures rentalItemRequestFeatures = (RentalItemRequestFeatures) o;
    return Objects.equals(this.available, rentalItemRequestFeatures.available) &&
        Objects.equals(this.notAvailable, rentalItemRequestFeatures.notAvailable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, notAvailable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemRequestFeatures {\n");
    
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

