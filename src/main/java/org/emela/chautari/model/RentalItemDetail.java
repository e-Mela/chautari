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
import org.emela.chautari.model.Feature;
import org.emela.chautari.model.RentalItemPreference;
import org.emela.chautari.model.RentalItemPrice;
import org.emela.chautari.model.UserDetail;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RentalItemDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-04T06:50:43.911-04:00[America/New_York]")

public class RentalItemDetail   {
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

  @JsonProperty("viewedBy")
  private Integer viewedBy = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    NEW("New"),
    
    PENDING("Pending"),
    
    BOOKED("Booked");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("availability")
  @Valid
  private List<Availability> availability = new ArrayList<>();

  @JsonProperty("location")
  private Address location = null;

  @JsonProperty("price")
  private RentalItemPrice price = null;

  @JsonProperty("preferences")
  @Valid
  private List<RentalItemPreference> preferences = null;

  @JsonProperty("features")
  @Valid
  private List<Feature> features = null;

  @JsonProperty("postedBy")
  private UserDetail postedBy = null;

  @JsonProperty("postedOn")
  private String postedOn = null;

  @JsonProperty("image-ids")
  @Valid
  private List<String> imageIds = null;

  public RentalItemDetail title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RentalItemDetail rentOf(RentOfEnum rentOf) {
    this.rentOf = rentOf;
    return this;
  }

  /**
   * Get rentOf
   * @return rentOf
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public RentOfEnum getRentOf() {
    return rentOf;
  }

  public void setRentOf(RentOfEnum rentOf) {
    this.rentOf = rentOf;
  }

  public RentalItemDetail viewedBy(Integer viewedBy) {
    this.viewedBy = viewedBy;
    return this;
  }

  /**
   * Get viewedBy
   * @return viewedBy
  **/
  @ApiModelProperty(value = "")


  public Integer getViewedBy() {
    return viewedBy;
  }

  public void setViewedBy(Integer viewedBy) {
    this.viewedBy = viewedBy;
  }

  public RentalItemDetail status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public RentalItemDetail availability(List<Availability> availability) {
    this.availability = availability;
    return this;
  }

  public RentalItemDetail addAvailabilityItem(Availability availabilityItem) {
    this.availability.add(availabilityItem);
    return this;
  }

  /**
   * Get availability
   * @return availability
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<Availability> getAvailability() {
    return availability;
  }

  public void setAvailability(List<Availability> availability) {
    this.availability = availability;
  }

  public RentalItemDetail location(Address location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Address getLocation() {
    return location;
  }

  public void setLocation(Address location) {
    this.location = location;
  }

  public RentalItemDetail price(RentalItemPrice price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public RentalItemPrice getPrice() {
    return price;
  }

  public void setPrice(RentalItemPrice price) {
    this.price = price;
  }

  public RentalItemDetail preferences(List<RentalItemPreference> preferences) {
    this.preferences = preferences;
    return this;
  }

  public RentalItemDetail addPreferencesItem(RentalItemPreference preferencesItem) {
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

  public RentalItemDetail features(List<Feature> features) {
    this.features = features;
    return this;
  }

  public RentalItemDetail addFeaturesItem(Feature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Get features
   * @return features
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Feature> getFeatures() {
    return features;
  }

  public void setFeatures(List<Feature> features) {
    this.features = features;
  }

  public RentalItemDetail postedBy(UserDetail postedBy) {
    this.postedBy = postedBy;
    return this;
  }

  /**
   * Get postedBy
   * @return postedBy
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserDetail getPostedBy() {
    return postedBy;
  }

  public void setPostedBy(UserDetail postedBy) {
    this.postedBy = postedBy;
  }

  public RentalItemDetail postedOn(String postedOn) {
    this.postedOn = postedOn;
    return this;
  }

  /**
   * Get postedOn
   * @return postedOn
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(String postedOn) {
    this.postedOn = postedOn;
  }

  public RentalItemDetail imageIds(List<String> imageIds) {
    this.imageIds = imageIds;
    return this;
  }

  public RentalItemDetail addImageIdsItem(String imageIdsItem) {
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
    RentalItemDetail rentalItemDetail = (RentalItemDetail) o;
    return Objects.equals(this.title, rentalItemDetail.title) &&
        Objects.equals(this.rentOf, rentalItemDetail.rentOf) &&
        Objects.equals(this.viewedBy, rentalItemDetail.viewedBy) &&
        Objects.equals(this.status, rentalItemDetail.status) &&
        Objects.equals(this.availability, rentalItemDetail.availability) &&
        Objects.equals(this.location, rentalItemDetail.location) &&
        Objects.equals(this.price, rentalItemDetail.price) &&
        Objects.equals(this.preferences, rentalItemDetail.preferences) &&
        Objects.equals(this.features, rentalItemDetail.features) &&
        Objects.equals(this.postedBy, rentalItemDetail.postedBy) &&
        Objects.equals(this.postedOn, rentalItemDetail.postedOn) &&
        Objects.equals(this.imageIds, rentalItemDetail.imageIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, rentOf, viewedBy, status, availability, location, price, preferences, features, postedBy, postedOn, imageIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentalItemDetail {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    rentOf: ").append(toIndentedString(rentOf)).append("\n");
    sb.append("    viewedBy: ").append(toIndentedString(viewedBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    preferences: ").append(toIndentedString(preferences)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    postedBy: ").append(toIndentedString(postedBy)).append("\n");
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

