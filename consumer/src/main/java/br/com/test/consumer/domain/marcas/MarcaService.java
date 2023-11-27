package br.com.test.consumer.domain.marcas;

import br.com.test.consumer.ConsumerApplication;
import br.com.test.consumer.domain.marcas.dto.MarcaDto;
import br.com.test.consumer.infrastructure.mapper.GenericMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MarcaService {


    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private GenericMapper mapper;

    public void sincronizaMarcas(MarcaDto marcaDto){
        if(!marcaJaCadastrada(marcaDto.getCodigo())){
            logger.info("sincronizando marca na base de dados " + marcaDto.getNome() );
            this.salvar(mapper.converter(marcaDto, Marca.class));
        }
    }

    @Transactional
    public void salvar(Marca marca){

        logger.info("salvando marca na base de dados " + marca.getNome() );
        marcaRepository.save(marca);

    }

    public Optional<Marca> findByCodigo(Long codigoMarca){
      return  marcaRepository.findByCodigo(codigoMarca);
    }

    public Boolean marcaJaCadastrada(Long codigoMarca){
        if(marcaRepository.findByCodigo(codigoMarca).isPresent()){

            logger.info("marca ja existente na base. Id da marca :  " + codigoMarca );
            return true;
        }
        return false;
    }
}
