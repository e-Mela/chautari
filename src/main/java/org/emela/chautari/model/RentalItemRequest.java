package org.emela.chautari.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.emela.chautari.model.Address;
import org.emela.chautari.model.Availability;
import org.emela.chautari.model.Contact;
import org.emela.chautari.model.RentalItemPreference;
import org.emela.chautari.model.RentalItemPrice;
import org.emela.chautari.model.RentalItemRequestFeatures;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RentalItemRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-18T09:53:05.107-04:00[America/New_York]")

public class RentalItemRequest   {
  @JsonProperty("owner-id")
  private String ownerId = null;

  @JsonProperty("title")
  private String title = null;

  /**
   * Gets or Sets rentOf
   */
  public enum RentOfEnum {
    ROOM("room");

    private String value;

    RentOfEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RentOfEnum fromValue(String text) {
      for (RentOfEnum b : RentOfEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("rentOf")
  private RentOfEnum rentOf = null;

  @JsonProperty("availability")
  private Availability availability = null;

  @JsonProperty("location")
  private Address location = null;

  @JsonProperty("price")
  private RentalItemPrice price = null;

  @JsonProperty("contact")
  private Contact contact = null;

  @JsonProperty("preferences")
  @Valid
  private List<RentalItemPreference> preferences = null;

  @JsonProperty("features")
  private RentalItemRequestFeatures features = null;

  @JsonProperty("postedOn")
  private String postedOn = null;

  @JsonProperty("image-ids")
  @Valid
  private List<String> imageIds = null;

  public RentalItemRequest ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(value = "")


  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public RentalItemRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RentalItemRequest rentOf(RentOfEnum rentOf) {
    this.rentOf = rentOf;
    return this;
  }

  /**
   * Get rentOf
   * @return rentOf
  **/
  @ApiModelProperty(value = "")


  public RentOfEnum getRentOf() {
    return rentOf;
  }

  public void setRentOf(RentOfEnum rentOf) {
    this.rentOf = rentOf;
  }

  public RentalItemRequest availability(Availability availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * @return availability
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Availability getAvailability() {
    return availability;
  }

  public void setAvailability(Availability availability) {
    this.availability = availability;
  }

  public RentalItemRequest location(Address location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getLocation() {
    return location;
  }

  public void setLocation(Address location) {
    this.location = location;
  }

  public RentalItemRequest price(RentalItemPrice price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RentalItemPrice getPrice() {
    return price;
  }

  public void setPrice(RentalItemPrice price) {
    this.price = price;
  }

  public RentalItemRequest contact(Contact contact) {
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

  public RentalItemRequest preferences(List<RentalItemPreference> preferences) {
    this.preferences = preferences;
    return this;
  }

  public RentalItemRequest addPreferencesItem(RentalItemPreference preferencesItem) {
    if (this.preferences == null) {
      this.preferences = new ArrayList<>();
    }
    this.preferences.add(preferencesItem);
    return this;
  }

  /**
   * Get preferences
   * @return preferences
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RentalItemPreference> getPreferences() {
    return preferences;
  }

  public void setPreferences(List<RentalItemPreference> preferences) {
    this.preferences = preferences;
  }

  public RentalItemRequest features(RentalItemRequestFeatures features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RentalItemRequestFeatures getFeatures() {
    return features;
  }

  public void setFeatures(RentalItemRequestFeatures features) {
    this.features = features;
  }

  public RentalItemRequest postedOn(String postedOn) {
    this.postedOn = postedOn;
    return this;
  }

  /**
   * Get postedOn
   * @return postedOn
  **/
  @ApiModelProperty(value = "")


  public String getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(String postedOn) {
    this.postedOn = postedOn;
  }

  public RentalItemRequest imageIds(List<String> imageIds) {
    this.imageIds = imageIds;
    return this;
  }

  public RentalItemRequest addImageIdsItem(String imageIdsItem) {
    if (this.imageIds == null) {
      this.imageIds = new ArrayList<>();
    }
    this.imageIds.add(imageIdsItem);
    return this;
  }

  /**
   * Get imageIds
   * @return imageIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getImageIds() {
    return imageIds;
  }

  public void setImageIds(List<String> imageIds) {
    this.imageIds = imageIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentalItemRequest rentalItemRequest = (RentalItemRequest) o;
    return Objects.equals(this.ownerId, rentalItemRequest.ownerId) &&
        Objects.equals(this.title, rentalItemRequest.title) &&
        Objects.equals(this.rentOf, rentalItemRequest.rentOf) &&
        Objects.equals(this.availability, rentalItemRequest.availability) &&
        Objects.equals(this.location, rentalItemRequest.location) &&
        Objects.equals(this.price, rentalItemRequest.price) &&
        Objects.equals(this.contact, rentalItemRequest.contact) &&
        Objects.equals(this.preferences, rentalItemRequest.preferences) &&
        Objects.equals(this.features, rentalItemRequest.features) &&
        Objects.equals(this.postedOn, rentalItemRequest.postedOn) &&
        Objects.equals(this.imageIds, rentalItemRequest.imageIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, title, rentOf, availability, location, price, contact, preferences, features, postedOn, imageIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemRequest {\n");
    
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    rentOf: ").append(toIndentedString(rentOf)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    preferences: ").append(toIndentedString(preferences)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    postedOn: ").append(toIndentedString(postedOn)).append("\n");
    sb.append("    imageIds: ").append(toIndentedString(imageIds)).append("\n");
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

