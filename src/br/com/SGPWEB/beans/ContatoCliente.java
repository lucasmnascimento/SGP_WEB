package br.com.SGPWEB.beans;

//beans
public class ContatoCliente {

	private int idcontatocliente;
	private int idcliente;
        private String nome;
        private String cargo;
        private int telefone;
        private Boolean status;
       
	public ContatoCliente() {
	}
	
	
	public ContatoCliente(int idcontatocliente) {
		this.idcontatocliente = idcontatocliente;
	}

    public ContatoCliente(int idcontatocliente, int idcliente, String nome, String cargo, int telefone, Boolean status) {
        this.idcontatocliente = idcontatocliente;
        this.idcliente = idcliente;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.status = status;
    }

    public int getIdcontatocliente() {
        return idcontatocliente;
    }

    public void setIdcontatocliente(int idcontatocliente) {
        this.idcontatocliente = idcontatocliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}