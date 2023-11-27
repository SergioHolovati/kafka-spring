package br.com.test.consumer.domain.marcas;


import br.com.test.consumer.domain.marcas.MarcaService;
import br.com.test.consumer.domain.carros.CarroService;
import br.com.test.consumer.domain.marcas.dto.MarcaDto;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcasFacade {

    private final MarcaService marcasService;

    private final CarroService carroService;


    @Autowired
    public MarcasFacade(MarcaService marcasService,CarroService carroService){
        this.marcasService = marcasService;
        this.carroService = carroService;
    }

    public void sincronizar(JsonObject jsonObject){
        MarcaDto marcaDto = MarcaDto.builder()
                .nome(jsonObject.get("nome").getAsString())
                .codigo(jsonObject.get("codigo").getAsLong())
                .build();
        marcasService.sincronizaMarcas(marcaDto);
        Marca marca = marcasService.findByCodigo(marcaDto.getCodigo()).orElseThrow();
        carroService.buscaCarrosPorMarca(marca);
    }
}
