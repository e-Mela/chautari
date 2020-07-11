package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Feature
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-31T10:46:01.641-04:00[America/New_York]")

public class Feature   {
  @JsonProperty("feature")
  private String feature = null;

  @JsonProperty("available")
  private Boolean available = null;

  public Feature feature(String feature) {
    this.feature = feature;
    return this;
  }

  /**
   * Get feature
   * @return feature
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public Feature available(Boolean available) {
    this.available = available;
    return this;
  }

  /**
   * Get available
   * @return available
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feature feature = (Feature) o;
    return Objects.equals(this.feature, feature.feature) &&
        Objects.equals(this.available, feature.available);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feature, available);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
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

