package br.com.test.consumer.domain.carros;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    Optional<Carro> findByCodigo(Long id);
}
