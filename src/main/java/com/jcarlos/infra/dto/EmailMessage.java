package com.jcarlos.infra.dto;

import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailMessage {

    @NotNull
    private final String email;

    @JsonCreator
    public EmailMessage(@JsonProperty("email") String email) {
        checkNotNull(email, "email must not be null");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
