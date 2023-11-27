package br.com.test.consumer.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class MessageServiceImpl implements MessageService {
    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Autowired
    public MessageServiceImpl(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    };


    @Override
    public void carregaMarcas(br.com.test.consumer.domain.marcas.dto.MarcaDto marca) {
    }
}
