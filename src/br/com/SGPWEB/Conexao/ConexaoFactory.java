package br.com.SGPWEB.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexaoFactory {

	private static ConexaoFactory conexao = null;
	
	public ConexaoFactory(){}
	
	public static ConexaoFactory getInst(){
		if(conexao == null){
			conexao = new ConexaoFactory();
		}		
		return conexao;
	}
	
	public Connection getConnection(String usuario, String senha) throws Exception{
		//endere�o para o seu servidor
		String url = "jdbc:postgresql://localhost:5432/teste3";
		
		//configurar o driver para o seu banco de dados
		Class.forName("org.postgresql.Driver");
		
		return DriverManager.getConnection(url, usuario, senha);
	}
	
}
