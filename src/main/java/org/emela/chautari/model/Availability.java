package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Availability
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class Availability {
    @JsonProperty("available")
    private Duration available = null;

    @JsonProperty("not-available")
    @Valid
    private List<Duration> notAvailable = null;

    public Availability available(Duration available) {
        this.available = available;
        return this;
    }

    /**
     * Get available
     *
     * @return available
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Duration getAvailable() {
        return available;
    }

    public void setAvailable(Duration available) {
        this.available = available;
    }

    public Availability notAvailable(List<Duration> notAvailable) {
        this.notAvailable = notAvailable;
        return this;
    }

    public Availability addNotAvailableItem(Duration notAvailableItem) {
        if (this.notAvailable == null) {
            this.notAvailable = new ArrayList<>();
        }
        this.notAvailable.add(notAvailableItem);
        return this;
    }

    /**
     * Get notAvailable
     *
     * @return notAvailable
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Duration> getNotAvailable() {
        return notAvailable;
    }

    public void setNotAvailable(List<Duration> notAvailable) {
        this.notAvailable = notAvailable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Availability availability = (Availability) o;
        return Objects.equals(this.available, availability.available) &&
                Objects.equals(this.notAvailable, availability.notAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(available, notAvailable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Availability {\n");

        sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    notAvailable: ").append(toIndentedString(notAvailable)).append("\n");
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

