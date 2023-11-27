package br.com.test.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.Map;

@Profile("!test")
@Configuration
public class KafakListenerContainerFactoryConfig {

    @Bean(name = "commitManualKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> commitManualKafkaListenerContainerFactory(
                                                                                                             KafkaProperties properties,
                                                                                                             @Value("${spring.application.name}") String microservico,
                                                                                                             @Value("${spring.kafka.consumer.group-id:null}") String groupId,
                                                                                                             @Value("${spring.kafka.consumer.properties.max.poll.interval.ms:1800000}") String maxPollIntervalMs,
                                                                                                             @Value("${spring.kafka.consumer.max-poll-records:10}") String maxPollRecords) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setMessageConverter(new StringJsonMessageConverter());
        factory.setAutoStartup(false);

        Map<String, Object> consumerProperties = properties.buildConsumerProperties();
        consumerProperties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        consumerProperties.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
        consumerProperties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollIntervalMs);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId.equals("null") ? microservico : groupId);
        consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerProperties));

        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.getContainerProperties().setSyncCommits(Boolean.TRUE);

        return factory;
    }
}