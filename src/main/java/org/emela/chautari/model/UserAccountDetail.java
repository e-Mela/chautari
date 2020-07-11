package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.emela.chautari.model.Contact;
import org.emela.chautari.model.Credential;
import org.emela.chautari.model.UserDetail;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserAccountDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-31T10:46:01.641-04:00[America/New_York]")

public class UserAccountDetail   {
  @JsonProperty("user")
  private UserDetail user = null;

  @JsonProperty("credential")
  private Credential credential = null;

  @JsonProperty("contact")
  private Contact contact = null;

  @JsonProperty("createdOn")
  private String createdOn = null;

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

  public UserAccountDetail contact(Contact contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountDetail userAccountDetail = (UserAccountDetail) o;
    return Objects.equals(this.user, userAccountDetail.user) &&
        Objects.equals(this.credential, userAccountDetail.credential) &&
        Objects.equals(this.contact, userAccountDetail.contact) &&
        Objects.equals(this.createdOn, userAccountDetail.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, credential, contact, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccountDetail {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
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

