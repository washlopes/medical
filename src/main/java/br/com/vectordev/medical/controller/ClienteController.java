package br.com.vectordev.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vectordev.medical.entity.ClienteEntity;
import br.com.vectordev.medical.repository.IClienteRepository;
import br.com.vectordev.medical.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List <ClienteEntity>> obtemClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> obtemCliente(@PathVariable Long id) {
		
		if (clienteRepository.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClienteEntity());
		}
		
	}
	
	@PostMapping
	public ResponseEntity <String> cadastrarCliente(@RequestBody ClienteEntity cliente) {
		
		if (clienteService.salvar(cliente)) {
			return ResponseEntity.status(HttpStatus.OK).body("Cadastro atualizado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro em efetuar o cadastro!");
		}
	}
	
	@PutMapping
	public ResponseEntity <String> atualizaCliente(@RequestBody ClienteEntity cliente) {
		
		if (clienteService.atualizar(cliente)) {
			return ResponseEntity.status(HttpStatus.OK).body("Cadastro atualizado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro em efetuar o cadastro!");
		}
	}
	
	@DeleteMapping("{id")
	public ResponseEntity <String> excluirCliente(@PathVariable Long id) {		
		
		if (clienteService.deletar(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Registo excluído com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao efetuar a exclusão do registro");
		}		
		
	}
	
}
