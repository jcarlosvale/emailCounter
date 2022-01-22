package com.jcarlos.infra.impl;

import static net.logstash.logback.argument.StructuredArguments.keyValue;
import static net.logstash.logback.argument.StructuredArguments.value;

import com.jcarlos.domain.service.EmailCounterService;
import com.jcarlos.infra.dto.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageListener.class);

    private final EmailCounterService emailCounterService;

    public KafkaMessageListener(EmailCounterService emailCounterService) {
        this.emailCounterService = emailCounterService;
    }

    @KafkaListener(topics = "${kafka.topic}", id = "someGroupId")
    public void listenEmailMessage(final EmailMessage message) {

        LOGGER.debug("{}; {}", value("action", "consumed message"), keyValue("email", message.getEmail()));
        emailCounterService.postEmail(message.getEmail());

    }
}
