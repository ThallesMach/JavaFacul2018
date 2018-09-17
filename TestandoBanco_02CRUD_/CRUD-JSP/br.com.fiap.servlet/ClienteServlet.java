package br.com.fiap.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Servico;
import br.com.fiap.bo.ClienteBO;
import br.com.fiap.bo.ServicoBO;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/clienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String retorno = "";

		switch (acao){
		case "carregar":
			carregaCombo(request);
			retorno = "cadastroCliente.jsp";
			break;
		case "remover":
			remover(request);
			listar(request);
			retorno = "listaCliente.jsp";
			break;
		case "buscar":
			buscar(request);
			retorno = "listaCliente.jsp";
			break;
		case "cadastrar":
			try{
				cadastrar(request);
				listar(request);
				retorno = "listaCliente.jsp";
			} catch (ParseException e){
				request.setAttribute("erro", "Data inválida");
				carregaCombo(request);
				retorno = "cadastroCliente.jsp";
			}catch (Exception e){
				carregaCombo(request);
				request.setAttribute("erro", e.getMessage());
				retorno = "cadastroCliente.jsp";
			}
			break;
		case "exibir":
			carregaCombo(request);
			editar(request);
			retorno = "cadastroCliente.jsp";
			break;
		case "listar":
			listar(request);
			retorno = "listaCliente.jsp";
			break;
		}
		request.getRequestDispatcher(retorno).forward(request, response);
	}

	private void carregaCombo(HttpServletRequest request){
		ServicoBO bo = new ServicoBO();
		request.setAttribute("servico", bo.buscaTodos());
	}

	private void editar(HttpServletRequest request){
		ServicoBO servicoBO = new ServicoBO();
		if(request.getParameter("codigo") !=null){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			ClienteBO bo = new ClienteBO();

			Cliente cliente = bo.buscarPorCodigo(codigo);
			request.setAttribute("cliente", cliente);
		}
		List<Servico> servicos = servicoBO.buscaTodos();
		request.setAttribute("servicos", servicos);
	}

	private void buscar(HttpServletRequest request){
		int codigo = Integer.parseInt(request.getParameter("servico"));
		 ClienteBO bo = new ClienteBO();
		 ArrayList<Cliente> lista = bo.buscarPorServico(codigo);
		 request.setAttribute("lista", lista);
		 ServicoBO servicoBO = new ServicoBO();
		 List<Servico> servicos = servicoBO.buscaTodos();
		 request.setAttribute("servicos", servicos);
		 request.setAttribute("lista", lista);
	}

	private void cadastrar(HttpServletRequest request) throws Exception{
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		int servico = Integer.parseInt(request.getParameter("ser"));
		String data = request.getParameter("data");
		Calendar dataNasc = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataNasc.setTime(sdf.parse(data));
		String end = request.getParameter("end");


		ClienteBO bo = new ClienteBO();

		if(codigo.equals("")){
		Cliente cliente = new Cliente(nome,end,cpf,dataNasc,servico);
		bo.cadastrar(cliente);
		request.setAttribute("msg", "Cliente Cadastrado");
		}else{
			int cod = Integer.parseInt(codigo);
			Cliente cli = new Cliente(cod,nome,end,cpf,dataNasc,servico);

			bo.alterar(cli);
			request.setAttribute("msg", "Cliente Alterado com sucesso!");
		}
	}


	private void remover(HttpServletRequest request){
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ClienteBO bo = new ClienteBO();
		try {
			bo.remover(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", "Cliente Removido com Sucesso!");
	}

	private void listar(HttpServletRequest request){
		ClienteBO bo = new ClienteBO();
		ServicoBO servicoBO = new ServicoBO();
		List<Servico> servicos = servicoBO.buscaTodos();
		request.setAttribute("servicos", servicos);
		request.setAttribute("lista", bo.buscarTodos());
	}
}
