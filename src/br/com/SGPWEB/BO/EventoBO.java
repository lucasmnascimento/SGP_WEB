/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGPWEB.BO;

import java.sql.Connection;
import java.util.List;

import br.com.SGPWEB.DAO.EventoDAO;
import br.com.SGPWEB.beans.Evento;

/**
 *
 * @author Renato Nascimento
 */
public class EventoBO {
    public static void cadastrar(Evento evento, Connection con) throws Exception{
		//regra de neg�cio
		if(evento.getNomeevento().length() < 2){
			throw new Exception("Nome inv�lido");
		}
		//Chamar o DAO correspondente para efetuar a opera��o no banco
		new EventoDAO().adicionar(evento, con);
	}
	
	public static List<Evento> listar(Connection con) throws Exception{
		return new EventoDAO().listar(con);
	}
	
	public static List<Evento> procurarClient(String nome, Connection con) throws Exception{
		if(nome.length() < 2){
			throw new Exception("Nome de busca inv�lido");
		}
		
		return new EventoDAO().procurar(nome, con);
	}
	
}
