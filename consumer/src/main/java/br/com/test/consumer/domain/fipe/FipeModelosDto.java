package br.com.test.consumer.domain.fipe;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FipeModelosDto {
    public List<FipeModeloDto> modelos;
}
