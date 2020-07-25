package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResourceResponseBean
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T19:31:39.445720-04:00[America/New_York]")

public class ResourceResponseBean   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("resourceResponse")
  @Valid
  private List<ResourceResponse> resourceResponse = null;

  public ResourceResponseBean status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ResourceResponseBean message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ResourceResponseBean resourceResponse(List<ResourceResponse> resourceResponse) {
    this.resourceResponse = resourceResponse;
    return this;
  }

  public ResourceResponseBean addResourceResponseItem(ResourceResponse resourceResponseItem) {
    if (this.resourceResponse == null) {
      this.resourceResponse = new ArrayList<ResourceResponse>();
    }
    this.resourceResponse.add(resourceResponseItem);
    return this;
  }

  /**
   * Get resourceResponse
   * @return resourceResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceResponse> getResourceResponse() {
    return resourceResponse;
  }

  public void setResourceResponse(List<ResourceResponse> resourceResponse) {
    this.resourceResponse = resourceResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceResponseBean resourceResponseBean = (ResourceResponseBean) o;
    return Objects.equals(this.status, resourceResponseBean.status) &&
        Objects.equals(this.message, resourceResponseBean.message) &&
        Objects.equals(this.resourceResponse, resourceResponseBean.resourceResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, resourceResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceResponseBean {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    resourceResponse: ").append(toIndentedString(resourceResponse)).append("\n");
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

