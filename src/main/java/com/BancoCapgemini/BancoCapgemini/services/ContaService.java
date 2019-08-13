package com.BancoCapgemini.BancoCapgemini.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Conta findSaldo(String conta, String agencia, String digito){
		return contaRepository.findSaldo(conta, agencia, digito);
	}
}
