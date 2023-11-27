package br.com.test.api.controller;


import br.com.test.api.domain.carros.CarroDto;
import br.com.test.api.domain.marcas.MarcaFacade;
import br.com.test.api.domain.marcas.dto.MarcaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/marcas")
public class MarcaController {

    private final MarcaFacade marcaFacade;


    @Autowired
    public MarcaController(MarcaFacade marcaFacade){
        this.marcaFacade = marcaFacade;
    }


    @GetMapping("/sincronizar")
    void carregaMarcas(){
        marcaFacade.carregaMarcas();
    }

    @GetMapping
    public List<MarcaDto> getCarrosPorMarca(){
        return marcaFacade.getMarcas();
    }


    @GetMapping("/{codigoMarca}/carros")
    public List<CarroDto> buscarCarrosPorCodigoDaMarca(@PathVariable Long codigoMarca){
        return marcaFacade.buscarCarrosPorCodigoDaMarca(codigoMarca);
    }

    @GetMapping("/{marcaId}/carros")
    public List<CarroDto> buscarCarrosPorMarcaId(@PathVariable Long codigoMarca){
        return marcaFacade.buscarCarrosPorMarcaId(codigoMarca);
    }
}
