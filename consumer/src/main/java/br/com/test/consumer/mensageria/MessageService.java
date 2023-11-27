package br.com.test.consumer.mensageria;


import br.com.test.consumer.domain.marcas.dto.MarcaDto;

public interface MessageService {

    void carregaMarcas( MarcaDto marca);

}
