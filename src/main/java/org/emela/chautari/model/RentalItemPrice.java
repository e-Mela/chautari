package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RentalItemPrice
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-06-27T09:23:19.665-04:00[America/New_York]")

public class RentalItemPrice   {
  @JsonProperty("value")
  private BigDecimal value = null;

  @JsonProperty("negotiable")
  private Boolean negotiable = null;

  public RentalItemPrice value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public RentalItemPrice negotiable(Boolean negotiable) {
    this.negotiable = negotiable;
    return this;
  }

  /**
   * Get negotiable
   * @return negotiable
  **/
  @ApiModelProperty(value = "")


  public Boolean getNegotiable() {
    return negotiable;
  }

  public void setNegotiable(Boolean negotiable) {
    this.negotiable = negotiable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentalItemPrice rentalItemPrice = (RentalItemPrice) o;
    return Objects.equals(this.value, rentalItemPrice.value) &&
        Objects.equals(this.negotiable, rentalItemPrice.negotiable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, negotiable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemPrice {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    negotiable: ").append(toIndentedString(negotiable)).append("\n");
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

