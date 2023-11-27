package br.com.test.consumer.domain.marcas.dto;

import br.com.test.consumer.domain.carros.CarroDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaDto
{
     Long codigo;
     String nome;
 }
