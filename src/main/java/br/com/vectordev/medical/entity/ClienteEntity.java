package br.com.vectordev.medical.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@Data
@NoArgsConstructor
public class ClienteEntity implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 2097884529044881076L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	@JsonInclude(Include.NON_EMPTY)
	private String nome;
	
	@Column(name="cpf_cnpj")
	@JsonInclude(Include.NON_EMPTY)
	private String cpfCnpj;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="idade")
	private int idade;
	
}
