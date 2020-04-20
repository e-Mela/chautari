package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

public class ErrorModel   {
  @JsonProperty("developerMessage")
  private String developerMessage = null;

  @JsonProperty("userMessage")
  private String userMessage = null;

  @JsonProperty("errorCode")
  private String errorCode = null;

  @JsonProperty("moreInfo")
  private String moreInfo = null;

  public ErrorModel developerMessage(String developerMessage) {
    this.developerMessage = developerMessage;
    return this;
  }

  /**
   * Verbose, plain language description of the problem for the app developer with hints about how to fix it.
   * @return developerMessage
  **/
  @ApiModelProperty(value = "Verbose, plain language description of the problem for the app developer with hints about how to fix it.")


  public String getDeveloperMessage() {
    return developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

  public ErrorModel userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

  /**
   * Pass this message on to the app user if needed
   * @return userMessage
  **/
  @ApiModelProperty(value = "Pass this message on to the app user if needed")


  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public ErrorModel errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Error code defined for the error
   * @return errorCode
  **/
  @ApiModelProperty(value = "Error code defined for the error")


  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorModel moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * Any additional information on the error (e.g. website links)
   * @return moreInfo
  **/
  @ApiModelProperty(value = "Any additional information on the error (e.g. website links)")


  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorModel errorModel = (ErrorModel) o;
    return Objects.equals(this.developerMessage, errorModel.developerMessage) &&
        Objects.equals(this.userMessage, errorModel.userMessage) &&
        Objects.equals(this.errorCode, errorModel.errorCode) &&
        Objects.equals(this.moreInfo, errorModel.moreInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(developerMessage, userMessage, errorCode, moreInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorModel {\n");
    
    sb.append("    developerMessage: ").append(toIndentedString(developerMessage)).append("\n");
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
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

