/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGPWEB.beans;

/**
 *
 * @author Renato Nascimento
 */
public class EventoCliente {
    
    private int ideventocliente;
    private int idcliente;
    private int idevento;
    
    public EventoCliente(){
    }
    
    public EventoCliente(int ideventocliente) {
		this.ideventocliente = ideventocliente;
	}

    public EventoCliente(int ideventocliente, int idcliente, int idevento) {
        this.ideventocliente = ideventocliente;
        this.idcliente = idcliente;
        this.idevento = idevento;
    }

    public int getIdeventocliente() {
        return ideventocliente;
    }

    public void setIdeventocliente(int ideventocliente) {
        this.ideventocliente = ideventocliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdevento() {
        return idevento;
    }

    public void setIdevento(int idevento) {
        this.idevento = idevento;
    }
    
    
}
