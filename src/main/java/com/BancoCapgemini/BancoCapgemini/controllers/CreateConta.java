package com.BancoCapgemini.BancoCapgemini.controllers;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BancoCapgemini.BancoCapgemini.models.Conta;
import com.BancoCapgemini.BancoCapgemini.services.ContaService;


@RestController
@RequestMapping("/contas")
public class CreateConta {

	@Autowired
	private ContaService contaService;
	
	
	@GetMapping
	public List<Conta> findAll(){
		return contaService.findAll();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id){
		return contaService.findByID(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/saldo")
	public Optional<Object> findSaldo(@RequestParam("conta") String contaBancaria,@RequestParam("agencia") String agencia, 
			@RequestParam("digito") String digito){
		return contaService.findSaldo(contaBancaria, agencia, digito);
	}
	
	@PostMapping
	public ResponseEntity<Conta> create(@Valid @RequestBody Conta conta){
		Conta obj = contaService.save(conta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/deposito")
	public Optional<Object> putDeposito(@RequestParam("valor") BigDecimal valor, @RequestBody Conta conta){
		return contaService.deposito(conta.getConta(), conta.getAgencia(), conta.getDigito(), valor);
	}
	@PutMapping(value = "/saque")
	public Optional<Object> putSaque(@RequestParam("valor") BigDecimal valor, @RequestBody Conta conta){
		return contaService.saque(conta.getConta(), conta.getAgencia(), conta.getDigito(), conta.getSenha(), valor);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Conta> update(@PathVariable("id") long id,
	                                      @RequestBody Conta conta) {
	   return contaService.findByID(id)
	           .map(record -> {
	               record.setAgencia(conta.getAgencia());
	               record.setDigitoAgencia(conta.getDigitoAgencia());
	               record.setConta(conta.getConta());
	               record.setDigito(conta.getDigito());
	               record.setSaldo(conta.getSaldo());
	               record.setCpfBeneficiario(conta.getCpfBeneficiario());
	               Conta updated = contaService.save(record);
	               return ResponseEntity.accepted().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return contaService.findByID(id)
	           .map(record -> {
	               contaService.deleteByID(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
