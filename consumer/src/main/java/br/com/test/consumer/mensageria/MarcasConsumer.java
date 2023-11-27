package br.com.test.consumer.mensageria;


import br.com.test.consumer.domain.marcas.MarcasFacade;
import br.com.test.consumer.config.KafkaConfig;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MarcasConsumer {

    @Autowired
    private MarcasFacade marcasFacade;

    @KafkaListener(topics = KafkaConfig.TOPICO_CARREGA_MARCAS_CARROS)
    public void carregaMarcas(String marcaDto){
        JsonObject jsonObject = JsonParser.parseString(marcaDto)
                .getAsJsonObject();
       marcasFacade.sincronizar(jsonObject);
    }
}
