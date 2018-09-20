package br.com.SGPWEB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.SGPWEB.beans.Produto;

//No DAO ficam as opera��es de com o banco de dados
public class ProdutoDAO implements IProduto<Produto, String> {

	/**
	 * M�todo para cadastrar um produto
	 */
	@Override
	public void adicionar(Produto produto, Connection con) throws Exception {
		//tinha um erro no sql
		String sql = "INSERT INTO produto values (nextval('produto_seq'), ?, ?, ?, ?, ?, ?, ?)";
				//+ " VALUES(nextval('produto_seq'), ?, ?)";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, produto.getNome());
                pStmt.setInt(2, produto.getCor());
                pStmt.setInt(3, produto.getClassificacao());
                pStmt.setInt(4, produto.getGenero());
                pStmt.setInt(5, produto.getStatus());
                pStmt.setInt(6, produto.getCategoria());
		pStmt.setDouble(7, produto.getValor());
		pStmt.execute();
		pStmt.close();		
	}
	
	/**
	 * M�todo para consultar todos os produto cadastrados.
	 */
	@Override
	public List<Produto> listar(Connection con) throws Exception {
		//Lista com todos os produtos retornados do banco
		List<Produto> lista = new ArrayList<>();
		
		//SQL
		String sql = "SELECT * FROM produto ";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		//ResultSet para pegar o resultado da consulta
		ResultSet rS = pStmt.executeQuery();
		
		//Adicionar os resultado na lista
		
		while(rS.next()){
			lista.add(new Produto(
					rS.getInt("CD_CODIGO"),
					rS.getString("NM_PRODUTO"),
					rS.getInt("cor"),                                        
                                        rS.getInt("fxclassificacao"),
                                        rS.getInt("genero"),
                                        rS.getInt("status"),
                                        rS.getInt("categoria"),
                                        rS.getDouble("preco")));
		}	
		
		rS.close();
		pStmt.close();
		
		return lista;
	}
	/**
	 * M�todo para procurar produtos com determinado nome
	 */
	@Override
	public List<Produto> procurar(String nome, Connection con) throws Exception {
		List<Produto> lista = new ArrayList<>();
		
		String sql = "SELECT CD_CODIGO, NM_PRODUTO, cor, fxclassificacao, genero, status, categoria, preco FROM PRODUTO WHERE UPPER(NM_PRODUTO) LIKE ?";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, "%" + nome.toUpperCase() + "%");
		ResultSet rS = pStmt.executeQuery();
		
		while(rS.next()){
			lista.add(new Produto(
					rS.getInt("CD_CODIGO"),
					rS.getString("NM_PRODUTO"),
					rS.getInt("cor"),                                        
                                        rS.getInt("fxclassificacao"),
                                        rS.getInt("genero"),
                                        rS.getInt("status"),
                                        rS.getInt("categoria"),
                                        rS.getDouble("preco")
                                        ));
		}	
		
		rS.close();
		pStmt.close();
		
		return lista;
	}

}
