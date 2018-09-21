package br.com.SGPWEB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.SGPWEB.beans.Cliente;

//No DAO ficam as opera��es de com o banco de dados
public class ClienteDAO implements ICliente<Cliente, String> {

	/**
	 * M�todo para cadastrar um produto
	 */
	@Override
	public void adicionar(Cliente cliente, Connection con) throws Exception {
		//tinha um erro no sql
		String sql = "INSERT INTO produto values (nextval('produto_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				//+ " VALUES(nextval('produto_seq'), ?, ?)";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setInt(1, cliente.getId_cliente());
                pStmt.setInt(2, cliente.getId_representante());
                pStmt.setInt(3, cliente.getCnpj());
                pStmt.setString(4, cliente.getNomefantasia());
                pStmt.setString(5, cliente.getClassificacaoabc());
                pStmt.setString(6, cliente.getCategoria());
                pStmt.setString(7, cliente.getAmbientevendas());
		pStmt.setString(8, cliente.getCanalvendas());
                pStmt.setString(9, cliente.getLogo());
                pStmt.setString(10, cliente.getRazaosocial());
                pStmt.setInt(11, cliente.getQuantidadedelojas());
                pStmt.setString(12, cliente.getLogradouro());
                pStmt.setInt(13, cliente.getNumero());
                pStmt.setString(14, cliente.getComplemento());
		pStmt.setString(15, cliente.getCidade());
                pStmt.setString(16, cliente.getBairro());
                pStmt.setString(17, cliente.getEstado());
                pStmt.setInt(18, cliente.getCEP());
                pStmt.setString(19, cliente.getOutrasinformacoes());
                pStmt.setString(20, cliente.getStatus());
                pStmt.execute();
		pStmt.close();		
	}
	
	/**
	 * M�todo para consultar todos os produto cadastrados.
	 */
	@Override
	public List<Cliente> listar(Connection con) throws Exception {
		//Lista com todos os produtos retornados do banco
		List<Cliente> lista = new ArrayList<>();
		
		//SQL
		String sql = "SELECT * FROM cliente ";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		//ResultSet para pegar o resultado da consulta
		ResultSet rS = pStmt.executeQuery();
		
		//Adicionar os resultado na lista
		
		while(rS.next()){
			lista.add(new Cliente(
					rS.getInt("id_cliente"),
					rS.getInt("idrepresentante"),
                                        rS.getInt("cnpj"),
					rS.getString("nomefantasia"),                                        
                                        rS.getString("classificacaoabc"),
                                        rS.getString("categoria"),
                                        rS.getString("ambientevendas"),
                                        rS.getString("canalvendas"),
                                        rS.getString("logo"),
                                        rS.getString("razaosocial"),                                        
                                        rS.getInt("quantidadedelojas"),                                        
                                        rS.getString("logradouro"),                                        
                                        rS.getInt("numero"),                                        
                                        rS.getString("complemento"),                                        
                                        rS.getString("bairro"),
                                        rS.getString("cidade"),
                                        rS.getString("estado"),
                                        rS.getInt("cep"),
                                        rS.getString("outrasinformacoes"),
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
	public List<Cliente> procurar(String nome, Connection con) throws Exception {
		List<Cliente> lista = new ArrayList<>();
		
		String sql = "SELECT id_cliente, idrepresentante, cnpj, nomefantasia, classificacaoabc, categoria, canalvendas, razaosocial, quantidadedelojas, logradouro, numero, complemento, bairro, cidade, estado, cep, outrasinformacoes, status FROM Cliente WHERE UPPER(idcliente) LIKE ?";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, "%" + nome.toUpperCase() + "%");
		ResultSet rS = pStmt.executeQuery();
		
		while(rS.next()){
			lista.add(new Cliente(
					rS.getInt("id_cliente"),
					rS.getInt("idrepresentante"),
                                        rS.getInt("cnpj"),
					rS.getString("nomefantasia"),                                        
                                        rS.getString("classificacaoabc"),
                                        rS.getString("categoria"),
                                        rS.getString("ambientevendas"),
                                        rS.getString("canalvendas"),
                                        rS.getString("logo"),
                                        rS.getString("razaosocial"),                                        
                                        rS.getInt("quantidadedelojas"),                                        
                                        rS.getString("logradouro"),                                        
                                        rS.getInt("numero"),                                        
                                        rS.getString("complemento"),                                        
                                        rS.getString("bairro"),
                                        rS.getString("cidade"),
                                        rS.getString("estado"),
                                        rS.getInt("cep"),
                                        rS.getString("outrasinformacoes"),
                                        rS.getString("status")
                                        ));
		}	
		
		rS.close();
		pStmt.close();
		
		return lista;
	}

}
