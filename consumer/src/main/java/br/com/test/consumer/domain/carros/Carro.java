package br.com.test.consumer.domain.carros;

import br.com.test.consumer.domain.marcas.Marca;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name="carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String nome;

    @Column
    private Long codigo;

    @JoinColumn
    @ManyToOne
    private Marca marca;

}

