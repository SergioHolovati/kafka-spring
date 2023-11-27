package br.com.test.api.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;


@Configuration
public class KafkaConfig {

    public static final String TOPICO_CARREGA_MARCAS_CARROS = "carrega.marcas.carros";

    private final ProducerFactory<Object, Object> producerFactory;

    @Autowired
    public KafkaConfig(ProducerFactory<Object, Object> producerFactory) {
        this.producerFactory = producerFactory;
    }

    @Bean
    public KafkaTransactionManager<Object, Object> kafkaTransactionManager() {
        return new KafkaTransactionManager<>(this.producerFactory);
    }
}