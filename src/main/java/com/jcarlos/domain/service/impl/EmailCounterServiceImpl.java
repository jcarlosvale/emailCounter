package com.jcarlos.domain.service.impl;

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
}
