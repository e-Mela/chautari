package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.core.io.Resource;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Body
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T13:13:33.782-04:00[America/New_York]")

public class Body {
    @JsonProperty("file")
    @Valid
    private List<Resource> file = null;

    public Body file(List<Resource> file) {
        this.file = file;
        return this;
    }

    public Body addFileItem(Resource fileItem) {
        if (this.file == null) {
            this.file = new ArrayList<>();
        }
        this.file.add(fileItem);
        return this;
    }

    /**
     * Get file
     *
     * @return file
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Resource> getFile() {
        return file;
    }

    public void setFile(List<Resource> file) {
        this.file = file;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Body body = (Body) o;
        return Objects.equals(this.file, body.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Body {\n");

        sb.append("    file: ").append(toIndentedString(file)).append("\n");
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

