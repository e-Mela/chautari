package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.emela.chautari.model.Credential;
import org.emela.chautari.model.UserDetail;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserAccountDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-18T09:53:05.107-04:00[America/New_York]")

public class UserAccountDetail   {
  /**
   * Gets or Sets userType
   */
  public enum UserTypeEnum {
    RENTER("renter"),
    
    OWNER("owner"),
    
    BOTH("both");

    private String value;

    UserTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UserTypeEnum fromValue(String text) {
      for (UserTypeEnum b : UserTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("user-type")
  private UserTypeEnum userType = null;

  @JsonProperty("user")
  private UserDetail user = null;

  @JsonProperty("credential")
  private Credential credential = null;

  @JsonProperty("createdOn")
  private String createdOn = null;

  public UserAccountDetail userType(UserTypeEnum userType) {
    this.userType = userType;
    return this;
  }

  /**
   * Get userType
   * @return userType
  **/
  @ApiModelProperty(value = "")


  public UserTypeEnum getUserType() {
    return userType;
  }

  public void setUserType(UserTypeEnum userType) {
    this.userType = userType;
  }

  public UserAccountDetail user(UserDetail user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserDetail getUser() {
    return user;
  }

  public void setUser(UserDetail user) {
    this.user = user;
  }

  public UserAccountDetail credential(Credential credential) {
    this.credential = credential;
    return this;
  }

  /**
   * Get credential
   * @return credential
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Credential getCredential() {
    return credential;
  }

  public void setCredential(Credential credential) {
    this.credential = credential;
  }

  public UserAccountDetail createdOn(String createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  **/
  @ApiModelProperty(value = "")


  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountDetail userAccountDetail = (UserAccountDetail) o;
    return Objects.equals(this.userType, userAccountDetail.userType) &&
        Objects.equals(this.user, userAccountDetail.user) &&
        Objects.equals(this.credential, userAccountDetail.credential) &&
        Objects.equals(this.createdOn, userAccountDetail.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userType, user, credential, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccountDetail {\n");
    
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

