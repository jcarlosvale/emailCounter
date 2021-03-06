package com.jcarlos.domain.service.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.jcarlos.domain.model.EmailCounterDto;
import com.jcarlos.domain.repository.EmailCounterRepository;
import com.jcarlos.domain.service.EmailCounterService;
import org.springframework.stereotype.Service;

@Service
public class EmailCounterServiceImpl implements EmailCounterService {

    private final EmailCounterRepository emailCounterRepository;

    public EmailCounterServiceImpl(EmailCounterRepository emailCounterRepository) {
        this.emailCounterRepository = emailCounterRepository;
    }

    @Override
    public EmailCounterDto getEmailCounter() {
        int emailCounter = emailCounterRepository.getEmailCounter();
        int domainCounter = emailCounterRepository.getDomainCounter();
        return new EmailCounterDto(emailCounter, domainCounter);
    }

    @Override
    public void postEmail(String email) {

        checkNotNull(email, "email must not be null");
        String domain = email.substring(email.indexOf("@") + 1);

        emailCounterRepository.saveEmail(email);
        emailCounterRepository.saveDomain(domain);
    }
}
