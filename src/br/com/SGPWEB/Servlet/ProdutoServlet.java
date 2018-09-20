package br.com.SGPWEB.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.SGPWEB.BO.ProdutoBO;
import br.com.SGPWEB.Conexao.ConexaoFactory;
import br.com.SGPWEB.beans.Produto;

//Servlet � o controller no caso
//Ele quem vai fazer a comunica��o entre o JSP e o Back-end
//Ele herda a HttpServlet

//Deve-ser configurar o caminho do servlet, pode-se fazer pelo web.xml ou pela anota��o

@WebServlet("/Produto")
@SuppressWarnings("serial")
public class ProdutoServlet extends HttpServlet {

	// doPost para cadastrar
	// p�gina de cadastro � cadastro.jsp
	// doPost vem do formul�rio
	// da forma como est� agora apenas conseguimos processar o cadastrar de um
	// produto
	// vamos alterar o formulario com um campo hidden (name/value) e adicionar
	// um switch
	// faremos tamb�m o "refactoring de m�todos"
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// a acao "cadastrar" vir� aqui
		String acao = req.getParameter("acao");

		// vamos aproveitar e refatorar para m�todos

		switch (acao) {
		case "cadastrar":
			// toda a l�gica para cadastrar
			// com a refatora��o o c�digo fica mais legivel e organizado
			cadastrarProduto(req, resp, pegarProduto(req));
			break;

		default:
			break;
		}

	}// j� adicionaremos mais coisas para passar ao JSP, como uma msg de sucesso

	// doGet para listar
	// p�gina para listar � listar.jsp
	// s� lembrar, doGet vem de/pela URL
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// faremos a mesma refatora��o para o doGet
		// lembrando que o parametro no doGet vem pela URL
		String acao = req.getParameter("acao");

		switch (acao) {
		case "listar":
			// l�gica para listar
			listarProdutos(req, resp);
			break;

		case "procurar":
			procurarProduto(req, resp);
		default:
			break;
		}

	}

	/**
	 * M�todo para listar todos os produtos
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listarProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lista
		List<Produto> lista = null;

		Connection con = null;

		try {
			con = ConexaoFactory.getInst().getConnection("Rodrigo", "12345");

			// recuperados a lista do banco
			lista = ProdutoBO.listar(con);

			// passamos a lista como atributo para o jsp
			req.setAttribute("lista", lista);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("listar.jsp").forward(req, resp);
		}
	}

	/**
	 * M�todo para cadastrar Produto
	 * 
	 * @param req
	 * @param resp
	 * @param produto
	 * @throws ServletException
	 * @throws IOException
	 */
	private void cadastrarProduto(HttpServletRequest req, HttpServletResponse resp, Produto produto)
			throws ServletException, IOException {
		// Objeto Connection
		Connection con = null;

		try {
			// Abrir a conex�o
			con = ConexaoFactory.getInst().getConnection("Rodrigo", "12345");
			// Chamar o BO para validar a regra de neg�cio e efetuar
			// opera��o no banco chamando DAO
			ProdutoBO.cadastrar(produto, con);

			// adicionar uma mensagem de sucesso
			// vou usar bootstrap no jsp
			req.setAttribute("tipoMensagem", "alert alert-success");
			req.setAttribute("mensagem", "Cadastro realizado com sucesso!");

		} catch (Exception e) {
			// modificar de local para retornar a mensagem
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Cadastro N�O realizado!");
			req.setAttribute("erro", e.getMessage());
			e.printStackTrace();
		} finally {
			// como abrimos uma conex�o a mesma deve ser fechada
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
			// efetuado o cadastro ou n�o mandamos para a tela cadastrar.jsp
			req.getRequestDispatcher("cadastrar.jsp").forward(req, resp);
		}
	}

	/**
	 * M�todo que retorna um Produto
	 * 
	 * @param req
	 * @return
	 */
	private Produto pegarProduto(HttpServletRequest req) {
		// Esses parametros s�o o names no formul�rio na p�gina JSP
		// J� faremos o formul�rio
		String nome = req.getParameter("nome");
                
		String valor = req.getParameter("valor");

		// vamos verificar o valor
		if (valor.isEmpty()) {
			valor = "0";
		}

		// Objeto Produto para cadastrar (deve ter um construtor adquado,
		// vamos modificar)
		Produto produto = new Produto(nome, Double.parseDouble(valor));
		return produto;
	}

	// m�tod para procurar produtos com determinada string no nome
	private void procurarProduto(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("procurar");

		List<Produto> lista = null;

		Connection con = null;

		try {
			con = ConexaoFactory.getInst().getConnection("Rodrigo", "12345");
			lista = ProdutoBO.procurarProduto(nome, con);
			req.setAttribute("lista", lista);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			req.getRequestDispatcher("listar.jsp").forward(req, resp);
		}
	}
}
