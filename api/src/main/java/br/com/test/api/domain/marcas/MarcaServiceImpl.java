package br.com.test.api.domain.marcas;


import br.com.test.api.client.FipeService;
import br.com.test.api.domain.marcas.dto.MarcaDto;
import br.com.test.api.infrastructure.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {
    private final FipeService fipeService;
    private final GenericMapper genericMapper;

    @Autowired
    private MarcaRepository marcaRepository;


    @Autowired
    public MarcaServiceImpl(FipeService fipeService,GenericMapper genericMapper){
        this.fipeService = fipeService;
        this.genericMapper = genericMapper;
    }

    public List<MarcaDto> carregaMarcas(){
        return fipeService.getMarcas();
    }

    public List<MarcaDto> getMarcasCadastradas(){
        return genericMapper.converterCollection(marcaRepository.findAll(), MarcaDto.class);
    }

    @Override
    public Long getMarcaPorId(Long id) {
        return marcaRepository.findById(id).get().getId();
    }

}
