package br.com.SGPWEB.DAO;

import java.sql.Connection;
import java.util.List;

//interface assim posso implementar em outros daos depois
//vamos alterar essa classe com generics
public interface ICliente<T, E> {
	public void adicionar(T objeto, Connection con) throws Exception;
	public List<T> listar(Connection con) throws Exception;
	public List<T> procurar(E nome, Connection con) throws Exception;
}
