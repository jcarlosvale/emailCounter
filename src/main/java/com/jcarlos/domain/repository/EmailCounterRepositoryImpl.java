package com.jcarlos.domain.repository;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class EmailCounterRepositoryImpl implements EmailCounterRepository{

    private final ConcurrentHashMap<String, Integer> emailCounterMap;

    public EmailCounterRepositoryImpl() {
        this.emailCounterMap = new ConcurrentHashMap<>();
    }

    @Override
    public int getEmailCounter() {
        return emailCounterMap.getOrDefault("emailCounter", 0);
    }

    @Override
    public int getDomainCounter() {
        return emailCounterMap.getOrDefault("domainCounter", 0);
    }
}
