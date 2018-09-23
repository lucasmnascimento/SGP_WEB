/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGPWEB.DAO;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Renato Nascimento
 */
public interface IEvento<T, E> {
    public void adicionar(T objeto, Connection con) throws Exception;
    public List<T> listar(Connection con) throws Exception;
    public List<T> procurar(E nome, Connection con) throws Exception;
}

