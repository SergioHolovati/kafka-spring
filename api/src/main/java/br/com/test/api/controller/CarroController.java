package br.com.test.api.controller;


import br.com.test.api.domain.carros.CarroDto;
import br.com.test.api.domain.carros.CarroFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/carros")
public class CarroController {


    private final CarroFacade carroFacade;


    @Autowired
    public CarroController(CarroFacade carroFacade){
        this.carroFacade = carroFacade;
    }

    @GetMapping("/{codigo}")
    public CarroDto buscarCarroPorCódigo(@PathVariable Long codigo){
       return carroFacade.buscarCarrosCodigoDoCarro(codigo);
    }

}
