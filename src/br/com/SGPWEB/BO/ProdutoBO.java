package br.com.SGPWEB.BO;

import java.sql.Connection;
import java.util.List;

import br.com.SGPWEB.DAO.ProdutoDAO;
import br.com.SGPWEB.beans.Produto;

//Na classe BO ficam as regras de neg�cio
//Os m�todos devem seguir as regras (parametros) do DAO 
public abstract class ProdutoBO {

	public static void cadastrar(Produto produto, Connection con) throws Exception{
		//regra de neg�cio
		if(produto.getNome().length() < 2){
			throw new Exception("Nome inv�lido");
		}
		if(produto.getValor() <= 0){
			throw new Exception("Valor inv�lido");
		}
		//Chamar o DAO correspondente para efetuar a opera��o no banco
		new ProdutoDAO().adicionar(produto, con);
	}
	
	public static List<Produto> listar(Connection con) throws Exception{
		return new ProdutoDAO().listar(con);
	}
	
	public static List<Produto> procurarProduto(String nome, Connection con) throws Exception{
		if(nome.length() < 2){
			throw new Exception("Nome de busca inv�lido");
		}
		
		return new ProdutoDAO().procurar(nome, con);
	}
	
}
