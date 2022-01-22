package com.jcarlos.domain.service;

import com.jcarlos.domain.model.EmailCounterDto;

public interface EmailCounterService {

    EmailCounterDto getEmailCounter();

    void postEmail(String email);
}
