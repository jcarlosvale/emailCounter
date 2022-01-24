package com.jcarlos.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.jcarlos.domain.repository.EmailCounterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmailCounterServiceImplTest {

    @Test
    void getEmailCounterTest() {
        //GIVEN
        var repository = Mockito.mock(EmailCounterRepository.class);
        var service = new EmailCounterServiceImpl(repository);

        Integer expectedEmailCounter = 432;
        Integer expectedDomainCounter = 543;

        given(repository.getEmailCounter()).willReturn(expectedEmailCounter);
        given(repository.getDomainCounter()).willReturn(expectedDomainCounter);

        //WHEN
        var actualResponse = service.getEmailCounter();

        //THEN
        assertEquals(expectedEmailCounter, actualResponse.getEmailsCounter());
        assertEquals(expectedDomainCounter, actualResponse.getDomainsCounter());
    }
}