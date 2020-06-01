package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * RentalItemResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class RentalItemResponse {
    @JsonProperty("rental-id")
    private String rentalId = null;

    public RentalItemResponse rentalId(String rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    /**
     * Get rentalId
     *
     * @return rentalId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RentalItemResponse rentalItemResponse = (RentalItemResponse) o;
        return Objects.equals(this.rentalId, rentalItemResponse.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RentalItemResponse {\n");

        sb.append("    rentalId: ").append(toIndentedString(rentalId)).append("\n");
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

