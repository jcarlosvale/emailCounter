package com.jcarlos.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EmailCounterDto {

    private final int emailsCounter;

    private final int domainsCounter;

    @JsonCreator
    public EmailCounterDto(@JsonProperty("emailCounter") int emailsCounter, @JsonProperty("domainsCounter") int domainsCounter) {
        this.emailsCounter = emailsCounter;
        this.domainsCounter = domainsCounter;
    }

    public int getEmailsCounter() {
        return emailsCounter;
    }

    public int getDomainsCounter() {
        return domainsCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmailCounterDto that = (EmailCounterDto) o;
        return emailsCounter == that.emailsCounter && domainsCounter == that.domainsCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailsCounter, domainsCounter);
    }

    @Override
    public String toString() {
        return "EmailCounterDto{" +
                "emailsCounter=" + emailsCounter +
                ", domainsCounter=" + domainsCounter +
                '}';
    }
}
