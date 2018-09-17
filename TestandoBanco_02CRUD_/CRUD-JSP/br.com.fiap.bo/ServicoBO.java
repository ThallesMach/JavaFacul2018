package br.com.fiap.bo;

import java.util.List;
import br.com.fiap.bean.Servico;
import br.com.fiap.dao.ServicoDAO;

public class ServicoBO {
private ServicoDAO convenioDao = new ServicoDAO();

	public List<Servico> buscaTodos(){
		return convenioDao.buscarTodos();
	}
}
