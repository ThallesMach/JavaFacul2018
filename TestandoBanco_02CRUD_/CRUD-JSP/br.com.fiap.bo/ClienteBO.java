package br.com.fiap.bo;


import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.ClienteDAO;


public class ClienteBO {

	private ClienteDAO clienteDao = new ClienteDAO();

	public void cadastrar(Cliente cliente) throws Exception{
		validaCliente(cliente);
		clienteDao.cadastrar(cliente);
	}

	public ArrayList<Cliente> buscarPorServico(int codigo){
		return clienteDao.buscarPorServico(codigo);
	}

	public Cliente buscarPorCodigo(int codigo){
		return clienteDao.buscarPorCodigo(codigo);
		}

	public List<Cliente> buscarTodos(){
		return clienteDao.buscarTodos();
	}

	public void alterar(Cliente cliente){
		clienteDao.alterar(cliente);
	}
	public void remover(int codigo) throws Exception{
		clienteDao.remover(codigo);
	}

		private void validaCliente(Cliente cliente) throws Exception{
		if (cliente.getNome() == null || cliente.getNome().isEmpty()){
			throw new Exception("Nome é obrigatório");
		}
	}
}
