package br.com.test.consumer.domain.carros;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarroDto {

    private Long codigo;
    private String nome;

}
