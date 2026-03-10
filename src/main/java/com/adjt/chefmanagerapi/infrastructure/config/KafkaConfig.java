package com.adjt.chefmanagerapi.infrastructure.config;

import com.adjt.chefmanagerapi.infrastructure.messaging.consumer.EventoPagamentoAprovadoMessageInput;
import com.adjt.chefmanagerapi.infrastructure.messaging.consumer.EventoPagamentoPendenteMessageInput;
import com.adjt.chefmanagerapi.infrastructure.messaging.dto.EventoPedidoCriadoMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, EventoPedidoCriadoMessage> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, EventoPedidoCriadoMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private Map<String, Object> baseConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    private <T> ConcurrentKafkaListenerContainerFactory<String, T> buildListenerFactory(
            ConsumerFactory<String, T> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, EventoPagamentoAprovadoMessageInput> aprovadoConsumerFactory() {
        JsonDeserializer<EventoPagamentoAprovadoMessageInput> deserializer =
                new JsonDeserializer<>(EventoPagamentoAprovadoMessageInput.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeHeaders(false);
        return new DefaultKafkaConsumerFactory<>(baseConsumerConfigs(), new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoPagamentoAprovadoMessageInput> aprovadoKafkaListenerContainerFactory() {
        return buildListenerFactory(aprovadoConsumerFactory());
    }

    @Bean
    public ConsumerFactory<String, EventoPagamentoPendenteMessageInput> pendenteConsumerFactory() {
        JsonDeserializer<EventoPagamentoPendenteMessageInput> deserializer =
                new JsonDeserializer<>(EventoPagamentoPendenteMessageInput.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeHeaders(false);
        return new DefaultKafkaConsumerFactory<>(baseConsumerConfigs(), new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoPagamentoPendenteMessageInput> pendenteKafkaListenerContainerFactory() {
        return buildListenerFactory(pendenteConsumerFactory());
    }
}
