package br.com.test.api.mensageria;

import br.com.test.api.config.KafkaConfig;
import br.com.test.api.domain.marcas.dto.MarcaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class MessageServiceImpl implements MessageService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public MessageServiceImpl(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    };

    @Transactional
    @Override
    public void carregaMarcas( MarcaDto marca) {
        kafkaTemplate.send(KafkaConfig.TOPICO_CARREGA_MARCAS_CARROS, marca);
    }
}
