package com.BancoCapgemini.BancoCapgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BancoCapgemini.BancoCapgemini.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	@Query("SELECT c FROM Conta c WHERE c.conta = :conta AND c.agencia = :agencia and c.digito=:digito ")
	Conta findSaldo(@Param("conta") String Conta, @Param("agencia") String Agencia, @Param("digito") String Digito);

}
