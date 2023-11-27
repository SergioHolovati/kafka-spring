package br.com.test.consumer.domain.carros;


import br.com.test.consumer.ConsumerApplication;
import br.com.test.consumer.client.FipeService;
import br.com.test.consumer.domain.fipe.FipeModelosDto;
import br.com.test.consumer.domain.marcas.Marca;
import br.com.test.consumer.infrastructure.mapper.GenericMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarroService  {


    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private FipeService fipeService;

    @Autowired
    private  GenericMapper mapper;


    @Transactional
    public void buscaCarrosPorMarca(Marca marca){

        FipeModelosDto fipeModelosDto = fipeService.getCarrosPorMarcaId(marca.getCodigo());
        gerarCarro(fipeModelosDto,marca);
    }


    public void gerarCarro(FipeModelosDto modelosDto, Marca marca){
        modelosDto.getModelos().forEach(e->{
            Carro carro = mapper.converter(e, Carro.class);
            carro.setMarca(marca);
            if(!this.jaExisteEsseCarroNaBase(e.codigo.longValue())){
                this.salvar(carro);
                logger.info("Salvando carro " + carro.getNome());
            }
        });
    }

    @Transactional
    public void salvar(Carro carro){
       carroRepository.save(carro);
    }


    private Boolean jaExisteEsseCarroNaBase(Long modeloId){
        if(carroRepository.findByCodigo(modeloId).isPresent()){
            logger.info("ja existe carro com o codigo " + modeloId);
            return true;
        };
        return false;
    }

}
