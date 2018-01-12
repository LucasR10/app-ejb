package br.com.ejbapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.com.ejbapp.dao.ClienteDAO;
import br.com.ejbapp.entidades.Cliente;
import br.com.ejbapp.utils.FacesUtil;

@ManagedBean
@Named
public class ClienteMB {

	@EJB
	private  ClienteDAO clienteDAO ; 
	
	private Cliente cliente = new Cliente();

	private List<Cliente> clientes;
	
    @PostConstruct
	void  init(){
		this.clientes = clienteDAO.findAll();
	}
    
	public ClienteMB() {}

	
	 public void save() {
	            clienteDAO.save(cliente);
	            FacesUtil.addMsg("Cliente gravado com sucesso");
//	            context.addMessage(null, new FacesMessage("Falha ao gravar cliente!"));
	        
	    }
	 
	    public void selecionar(ActionEvent evento) {
	       // Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
	       // cliente = clienteDAO.findById(codigo);
	    }
	 
	    public void remover() {
	        clienteDAO.delete(cliente);
	       FacesUtil.addMsg("Cliente removido com sucesso");
//	        context.addMessage(null, new FacesMessage("Falha ao remover cliente!"));
	    }
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> findAll() {
		return clientes;
	}

}

