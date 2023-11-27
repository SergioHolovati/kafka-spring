package br.com.test.api.client;


import br.com.test.api.domain.marcas.dto.MarcaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(contextId = "MarcasApplication", name = "fipe-client", url = "${svc.fipe.url}",primary = false)
public interface FipeService {

    @GetMapping
    List<MarcaDto> getMarcas();

}
