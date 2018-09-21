package br.com.SGPWEB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.SGPWEB.beans.Evento;
import java.sql.Date;

//No DAO ficam as opera��es de com o banco de dados
public class EventoDAO implements IEvento<Evento, String> {

	/**
	 * M�todo para cadastrar um produto
	 */
	@Override
	public void adicionar(Evento evento, Connection con) throws Exception {
		//tinha um erro no sql
		String sql = "INSERT INTO evento values (nextval('produto_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				//+ " VALUES(nextval('produto_seq'), ?, ?)";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setInt(1, evento.getId_evento());
                pStmt.setInt(2, evento.getId_cliente());
                pStmt.setString(3, evento.getNomeevento());
                pStmt.setString(4, evento.getTipo());
                pStmt.setDate(5, (Date) evento.getDatainicio());
                pStmt.setDate(6, (Date) evento.getDatafim());
                pStmt.setDate(7, (Date) evento.getHorainicio());
                pStmt.setDate(8, (Date) evento.getHorafim());
                pStmt.setString(9, evento.getDescricao());
                pStmt.setDouble(10, evento.getInvestimento());
                pStmt.setInt(11, evento.getVendarealizada());
                pStmt.setString(12, evento.getStatus());
                pStmt.execute();
		pStmt.close();		
	}
	
	/**
	 * M�todo para consultar todos os produto cadastrados.
	 */
	@Override
	public List<Evento> listar(Connection con) throws Exception {
		//Lista com todos os produtos retornados do banco
		List<Evento> lista = new ArrayList<>();
		
		//SQL
		String sql = "SELECT * FROM cliente ";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		//ResultSet para pegar o resultado da consulta
		ResultSet rS = pStmt.executeQuery();
		
		//Adicionar os resultado na lista
		
		while(rS.next()){
			lista.add(new Evento(
					rS.getInt("id_evento"),
					rS.getInt("id_cliente"),
                                        rS.getString("nomeevento"),
					rS.getString("tipo"),                                        
                                        rS.getDate("datainicio"),
                                        rS.getDate("datafim"),
                                        rS.getDate("horainicio"),
                                        rS.getDate("horafim"),
                                        rS.getString("descricao"),
                                        rS.getDouble("investimento"),
                                        rS.getInt("vendarealizada"),                                        
                                        rS.getString("status")
                        ));
		}	
		
		rS.close();
		pStmt.close();
		
		return lista;
	}
	/**
	 * M�todo para procurar produtos com determinado nome
	 */
	@Override
	public List<Evento> procurar(String nome, Connection con) throws Exception {
		List<Evento> lista = new ArrayList<>();
		
		String sql = "SELECT id_evento, id_cliente, nomeevento, tipo, datainicio, datafim, horainicio, horafim, descricao, investimento, vendarealizada, status FROM Evento WHERE UPPER(id_evento) LIKE ?";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, "%" + nome.toUpperCase() + "%");
		ResultSet rS = pStmt.executeQuery();
		
		while(rS.next()){
			lista.add(new Evento(
					rS.getInt("id_evento"),
					rS.getInt("id_cliente"),
                                        rS.getString("nomeevento"),
					rS.getString("tipo"),                                        
                                        rS.getDate("datainicio"),
                                        rS.getDate("datafim"),
                                        rS.getDate("horainicio"),
                                        rS.getDate("horafim"),
                                        rS.getString("descricao"),
                                        rS.getDouble("investimento"),
                                        rS.getInt("vendarealizada"),                                        
                                        rS.getString("status")
                                        ));
		}	
		
		rS.close();
		pStmt.close();
		
		return lista;
	}

}
