package br.com.test.api.domain.marcas;

import br.com.test.api.domain.carros.CarroDto;
import br.com.test.api.domain.carros.CarroFacade;
import br.com.test.api.domain.marcas.dto.MarcaDto;
import br.com.test.api.mensageria.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcaFacade {

    private final MarcaService marcaService;

    private final MessageService messageService;
    private final CarroFacade carroFacade;

    @Autowired
    public MarcaFacade(MarcaService marcaService, MessageService messageService, CarroFacade carroFacade){
        this.marcaService = marcaService;
        this.messageService = messageService;
        this.carroFacade = carroFacade;
    }

    public void carregaMarcas(){
        List<MarcaDto> marcas = marcaService.carregaMarcas();
        marcas.forEach(e-> messageService.carregaMarcas(e));
    }

    public List<MarcaDto> getMarcas(){
        return marcaService.carregaMarcas();
    }

    public List<CarroDto> buscarCarrosPorCodigoDaMarca(Long codigoDaMarca){
        return carroFacade.buscarCarrosPorCodigoDaMarca(codigoDaMarca);
    }

    public List<CarroDto> buscarCarrosPorMarcaId(Long marcaId){
        return carroFacade.buscarCarrosPorCodigoDaMarca(marcaId);
    }
}
