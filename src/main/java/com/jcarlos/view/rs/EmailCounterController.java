package com.jcarlos.view.rs;

import com.jcarlos.domain.model.EmailCounterDto;

public interface EmailCounterController {

    /**
     * GET endpoint to retrieve the uniques email and domains counter
     * @return the email counter containing email and domains counters values
     */
    EmailCounterDto getNumberOfOverallMailAddressesAndDomains();
}
