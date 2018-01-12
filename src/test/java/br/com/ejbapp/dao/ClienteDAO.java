package br.com.ejbapp.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.ejbapp.entidades.Cliente;
import br.com.ejbapp.generics.GenericDAO;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente, Long> {

@Override
public List<Cliente> findAll() {
	return super.findAll();
}
}
