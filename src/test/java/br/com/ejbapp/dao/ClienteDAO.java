package br.com.ejbapp.dao;

import javax.ejb.Stateless;

import br.com.ejbapp.entidades.Cliente;
import br.com.ejbapp.generics.GenericDAO;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente, Long> {

	public ClienteDAO() {
		super(Cliente.class);
	}

	
	

}
