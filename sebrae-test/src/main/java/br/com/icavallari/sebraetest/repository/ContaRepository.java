package br.com.icavallari.sebraetest.repository;

import br.com.icavallari.sebraetest.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
