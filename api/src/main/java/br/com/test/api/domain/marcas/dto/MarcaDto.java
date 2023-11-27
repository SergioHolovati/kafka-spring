package br.com.test.api.domain.marcas.dto;

import lombok.*;

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
