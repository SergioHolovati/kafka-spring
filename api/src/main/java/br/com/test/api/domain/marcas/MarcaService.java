package br.com.test.api.domain.marcas;

import br.com.test.api.domain.marcas.dto.MarcaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarcaService {

    List<MarcaDto> carregaMarcas();

    List<MarcaDto> getMarcasCadastradas();

    Long getMarcaPorId(Long id);
}
