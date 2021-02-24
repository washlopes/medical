package br.com.vectordev.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vectordev.medical.entity.ClienteEntity;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
