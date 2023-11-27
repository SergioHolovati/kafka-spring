package br.com.test.api.domain.carros;

import br.com.test.api.infrastructure.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class CarroService{

    @Autowired
    private  CarroRepository carroRepository;
    @Autowired
    private  GenericMapper mapper;

    public List<CarroDto> buscarCarrosPorMarcaId(Long marca) {
       List<Carro> carros = carroRepository.findAllByMarcaId(marca);
       if(carros.isEmpty()){
           throw new NotFoundException("Não foi encontrado nenhum carro para essa marca");
       }
       return mapper.converterCollection(carros,CarroDto.class);
    }


    public CarroDto buscarCarrosPorCodigoDoCarro(Long marcaId) {
        Carro carro = carroRepository.findByCodigo(marcaId).orElseThrow();
        return mapper.converter(carro,CarroDto.class);
    }
}
