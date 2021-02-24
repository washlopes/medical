package br.com.vectordev.medical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vectordev.medical.entity.ClienteEntity;
import br.com.vectordev.medical.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public Boolean salvar(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		try {
			clienteRepository.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean atualizar(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		
		try {
			ClienteEntity clienteAtual = clienteRepository.findById(cliente.getId()).get();
			
			clienteAtual.setNome(cliente.getNome());
			clienteAtual.setCpfCnpj(cliente.getCpfCnpj());
			clienteAtual.setIdade(cliente.getIdade());
			clienteAtual.setSexo(cliente.getSexo());
			
			clienteRepository.save(clienteAtual);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean deletar(Long id) {
		// TODO Auto-generated method stub
		Boolean excluido = false;
		
		if (clienteRepository.findById(id).isPresent()) {
			clienteRepository.deleteById(id);
			excluido = true;
		} 
		
		return excluido;
	}

}
