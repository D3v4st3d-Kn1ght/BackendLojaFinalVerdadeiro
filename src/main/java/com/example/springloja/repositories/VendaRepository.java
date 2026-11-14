package com.example.springloja.repositories;

import com.example.springloja.entities.Produto;
import com.example.springloja.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByValorLessThanEqual(Double valor);
}

