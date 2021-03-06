package br.com.SGPWEB.beans;

import br.com.SGPWEB.entity.StatusEnum;
import br.com.SGPWEB.entity.NivelAcessoEnum;

public class RepresentanteComercial {

	private int idrepresentante;
        private String nome;
        private String foto;
        private String email;
        private String cargo;
        private NivelAcessoEnum nivelacesso;
        private String login;
        private String senha;
        private StatusEnum status;
       
	public RepresentanteComercial(){
	}
	
	
	public RepresentanteComercial(int idrepresentante) {
		this.idrepresentante = idrepresentante;
	}

    public RepresentanteComercial(int idrepresentante, String nome, String foto, String email, String cargo, NivelAcessoEnum nivelacesso, String login, String senha, StatusEnum status) {
        this.idrepresentante = idrepresentante;
        this.nome = nome;
        this.foto = foto;
        this.email = email;
        this.cargo = cargo;
        this.nivelacesso = nivelacesso;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }

    public int getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(int idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public NivelAcessoEnum getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(NivelAcessoEnum nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
        
        
}