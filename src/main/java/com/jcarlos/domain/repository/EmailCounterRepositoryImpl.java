package com.jcarlos.domain.repository;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class EmailCounterRepositoryImpl implements EmailCounterRepository{

    private final Set<String> emailSet;
    private final Set<String> domainSet;


    public EmailCounterRepositoryImpl() {
        this.emailSet = new HashSet<>();
        this.domainSet = new HashSet<>();
    }

    @Override
    public int getEmailCounter() {
        return emailSet.size();
    }

    @Override
    public int getDomainCounter() {
        return domainSet.size();
    }

    @Override
    public void saveEmail(String email) {
        emailSet.add(email);
    }

    @Override
    public void saveDomain(String domain) {
        domainSet.add(domain);
    }
}
