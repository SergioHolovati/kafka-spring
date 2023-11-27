package br.com.test.consumer.client;


import br.com.test.consumer.domain.fipe.FipeModeloDto;
import br.com.test.consumer.domain.fipe.FipeModelosDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(contextId = "CarrosApplication", name = "fipe-client", url = "${svc.fipe.url}")
public interface FipeService {

    @GetMapping(value = "/{id}/modelos")
    FipeModelosDto getCarrosPorMarcaId(@PathVariable Long id);

}
