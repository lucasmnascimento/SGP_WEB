/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGPWEB.BO;

import java.sql.Connection;
import java.util.List;

import br.com.SGPWEB.DAO.ClienteDAO;
import br.com.SGPWEB.beans.Cliente;

/**
 *
 * @author Renato Nascimento
 */
public class ClienteBO {
    public static void cadastrar(Cliente cliente, Connection con) throws Exception{
		//regra de neg�cio
		if(cliente.getRazaosocial().length() < 2){
			throw new Exception("Nome inv�lido");
		}
		if(cliente.getCnpj() <= 0){
			throw new Exception("Valor inv�lido");
		}
		//Chamar o DAO correspondente para efetuar a opera��o no banco
		new ClienteDAO().adicionar(cliente, con);
	}
	
	public static List<Cliente> listar(Connection con) throws Exception{
		return new ClienteDAO().listar(con);
	}
	
	public static List<Cliente> procurarClient(String nome, Connection con) throws Exception{
		if(nome.length() < 2){
			throw new Exception("Nome de busca inv�lido");
		}
		
		return new ClienteDAO().procurar(nome, con);
	}
	
}
