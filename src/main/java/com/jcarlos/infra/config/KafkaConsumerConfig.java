package com.jcarlos.infra.config;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;

import com.jcarlos.infra.dto.EmailMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {

    private final KafkaProperties kafkaProperties;
    private final String kafkaBootstrapServers;

    public KafkaConsumerConfig(KafkaProperties kafkaProperties, @Value("${kafka.bootstrap-servers}") String kafkaBootstrapServers) {

        checkNotNull(kafkaBootstrapServers, "kafkaBootstrapServers must not be null");

        this.kafkaProperties = kafkaProperties;
        this.kafkaBootstrapServers = kafkaBootstrapServers;
    }


    @Bean
    public ConsumerFactory<String, EmailMessage> consumerFactory() {

        final var keyDeserializer = new StringDeserializer();
        final var valueDeserializer = new JsonDeserializer<>(EmailMessage.class);
        final var errorHandlingValueDeserializer = new ErrorHandlingDeserializer<>(valueDeserializer);


        final var properties = kafkaProperties.buildConsumerProperties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);

        return new DefaultKafkaConsumerFactory<>(properties, keyDeserializer, errorHandlingValueDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EmailMessage> kafkaListenerContainerFactory() {

        final var containerFactory = new ConcurrentKafkaListenerContainerFactory<String, EmailMessage>();
        containerFactory.setConsumerFactory(consumerFactory());

        return containerFactory;
    }
}