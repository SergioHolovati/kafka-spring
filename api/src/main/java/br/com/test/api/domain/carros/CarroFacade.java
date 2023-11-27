package br.com.test.api.domain.carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarroFacade {

    private final CarroService carroService;
    @Autowired
    CarroFacade(CarroService carroService){
        this.carroService = carroService;
    }

    public List<CarroDto> buscarCarrosMarcaId(Long marcaId){
        return carroService.buscarCarrosPorMarcaId(marcaId);
    }

    public CarroDto buscarCarrosCodigoDoCarro(Long codigo){
        return carroService.buscarCarrosPorCodigoDoCarro(codigo);
    }
}
