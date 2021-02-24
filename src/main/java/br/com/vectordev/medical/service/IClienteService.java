package br.com.vectordev.medical.service;

import br.com.vectordev.medical.entity.ClienteEntity;

public interface IClienteService {

	public Boolean salvar(final ClienteEntity cliente);
	
	public Boolean atualizar(final ClienteEntity cliente);
	
	public Boolean deletar(final Long id);
}
