package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.emela.chautari.model.Address;
import org.emela.chautari.model.PersonName;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-18T09:53:05.107-04:00[America/New_York]")

public class UserDetail   {
  @JsonProperty("person")
  private PersonName person = null;

  @JsonProperty("address")
  private Address address = null;

  public UserDetail person(PersonName person) {
    this.person = person;
    return this;
  }

  /**
   * Get person
   * @return person
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PersonName getPerson() {
    return person;
  }

  public void setPerson(PersonName person) {
    this.person = person;
  }

  public UserDetail address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetail userDetail = (UserDetail) o;
    return Objects.equals(this.person, userDetail.person) &&
        Objects.equals(this.address, userDetail.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(person, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetail {\n");
    
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

