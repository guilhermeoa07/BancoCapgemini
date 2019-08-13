package com.BancoCapgemini.BancoCapgemini.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.BancoCapgemini.BancoCapgemini.models.Conta;
import com.BancoCapgemini.BancoCapgemini.repositories.ContaRepository;
@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Optional<Conta> findByID(Long id){
		return contaRepository.findById(id);
	}
	
	public List <Conta> findAll(){
		return contaRepository.findAll();
	}
	
	public Conta save(Conta conta) {
		return contaRepository.save(conta);
	}
	
	public void deleteByID(long id) {
		contaRepository.deleteById(id);
	}
	public void deleteAll() {
		contaRepository.deleteAll();
	}
	public Optional<Object> findSaldo(String conta, String agencia, String digito){
		return contaRepository.findByContaAndAgenciaAndDigito(conta, agencia, digito)
		           .map(record -> {
		               return record.getSaldo();
		           });
	}
	
	public Optional<Object> deposito(String contaBancaria, String agencia, String digito, BigDecimal valorDeposito) {
		return contaRepository.findByContaAndAgenciaAndDigito(contaBancaria, agencia, digito)
			           .map(record -> {
			               record.setSaldo(record.getSaldo().add(valorDeposito));
			               Conta updated = save(record);
			               return ResponseEntity.accepted().body(updated);
			           });
	}
}
