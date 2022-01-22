package com.jcarlos.domain.repository;

public interface EmailCounterRepository {

    int getEmailCounter();

    int getDomainCounter();

    void saveEmail(String email);

    void saveDomain(String domain);
}
