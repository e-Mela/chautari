package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Credential
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-30T14:41:07.663793-04:00[America/New_York]")

public class Credential {
    @JsonProperty("userName")
    private String userName = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("security-questions")
    @Valid
    private List<SecurityQuestion> securityQuestions = null;

    public Credential userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get userName
     *
     * @return userName
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Credential password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Credential securityQuestions(List<SecurityQuestion> securityQuestions) {
        this.securityQuestions = securityQuestions;
        return this;
    }

    public Credential addSecurityQuestionsItem(SecurityQuestion securityQuestionsItem) {
        if (this.securityQuestions == null) {
            this.securityQuestions = new ArrayList<SecurityQuestion>();
        }
        this.securityQuestions.add(securityQuestionsItem);
        return this;
    }

    /**
     * Get securityQuestions
     *
     * @return securityQuestions
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<SecurityQuestion> getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(List<SecurityQuestion> securityQuestions) {
        this.securityQuestions = securityQuestions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Credential credential = (Credential) o;
        return Objects.equals(this.userName, credential.userName) &&
                Objects.equals(this.password, credential.password) &&
                Objects.equals(this.securityQuestions, credential.securityQuestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, securityQuestions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Credential {\n");

        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    securityQuestions: ").append(toIndentedString(securityQuestions)).append("\n");
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

