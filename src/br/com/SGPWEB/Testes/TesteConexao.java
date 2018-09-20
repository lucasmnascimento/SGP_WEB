package br.com.SGPWEB.Testes;

import java.sql.Connection;

import br.com.SGPWEB.Conexao.ConexaoFactory;

//Conexao testada e funcionando.
public class TesteConexao {

	public static void main(String[] args) throws Exception{
		
		Connection con = null;
		
		try {
			con = ConexaoFactory.getInst().getConnection("Rodrigo", "12345");
			System.out.println("Conex�o aberta");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null){
					con.close();
					System.out.println("Conex�o fechada");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
