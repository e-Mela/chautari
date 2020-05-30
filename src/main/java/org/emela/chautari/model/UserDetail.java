package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * UserDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-30T14:08:38.460906-04:00[America/New_York]")

public class UserDetail   {
  @JsonProperty("person")
  private Person person = null;

  @JsonProperty("address")
  private Address address = null;

  public UserDetail person(Person person) {
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

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
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
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

