package com.jcarlos.view.rs.impl;

import com.jcarlos.domain.model.EmailCounterDto;
import com.jcarlos.domain.service.EmailCounterService;
import com.jcarlos.view.rs.EmailCounterController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/emailcounter/")
public class EmailCounterControllerImpl implements EmailCounterController {

    private final EmailCounterService emailCounterService;

    public EmailCounterControllerImpl(EmailCounterService emailCounterService) {
        this.emailCounterService = emailCounterService;
    }

    @Override
    @GetMapping
    public EmailCounterDto getNumberOfOverallMailAddressesAndDomains() {
        return emailCounterService.getEmailCounter();
    }
}
