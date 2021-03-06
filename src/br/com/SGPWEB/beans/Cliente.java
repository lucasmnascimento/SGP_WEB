package br.com.SGPWEB.beans;

import br.com.SGPWEB.entity.StatusEnum;
import br.com.SGPWEB.entity.CategoriaClienteEnum;
import br.com.SGPWEB.entity.ClassificacaoClienteABCEnum;
import br.com.SGPWEB.entity.AmbienteVendasClienteEnum;
import br.com.SGPWEB.entity.CanalVendasClienteEnum;

//beans
public class Cliente {

	private int id_cliente;
	private int id_representante;
        private String cnpj;
        private String nomefantasia;
        private ClassificacaoClienteABCEnum classificacaoabc;
        private CategoriaClienteEnum categoria;
        private AmbienteVendasClienteEnum ambientevendas;
        private CanalVendasClienteEnum canalvendas;
        private String logo;
        private String razaosocial;
        private int quantidadedelojas;
        private String logradouro;
        private int numero;
        private String complemento;
	private String bairro;
        private String cidade;
        private String estado;
        private int CEP;
        private String outrasinformacoes;
        private StatusEnum status;
        
       
	public Cliente() {
	}
	
	
	//O c�digo � a sequencia (SQ_PRODUTO) que criamos no SQL Developer
	public Cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

    public Cliente(int id_cliente, int idrepresentante, String cnpj, String nomefantasia, ClassificacaoClienteABCEnum classificacaoabc, CategoriaClienteEnum categoria, AmbienteVendasClienteEnum ambientevendas, CanalVendasClienteEnum canalvendas, String logo, String razaosocial, int quantidadedelojas, String logradouro, int numero, String complemento, String bairro, String cidade, String estado, int CEP, String outrasinformacoes, StatusEnum status) {
        this.id_cliente = id_cliente;
        this.id_representante = idrepresentante;
        this.nomefantasia = nomefantasia;
        this.cnpj = cnpj;
        this.classificacaoabc = classificacaoabc;
        this.categoria = categoria;
        this.ambientevendas = ambientevendas;
        this.canalvendas = canalvendas;
        this.logo = logo;
        this.razaosocial = razaosocial;
        this.quantidadedelojas = quantidadedelojas;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
        this.outrasinformacoes = outrasinformacoes;
        this.status = status;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_representante() {
        return id_representante;
    }

    public void setId_representante(int id_representante) {
        this.id_representante = id_representante;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public ClassificacaoClienteABCEnum getClassificacaoabc() {
        return classificacaoabc;
    }

    public void setClassificacaoabc(ClassificacaoClienteABCEnum classificacaoabc) {
        this.classificacaoabc = classificacaoabc;
    }

    public CategoriaClienteEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaClienteEnum categoria) {
        this.categoria = categoria;
    }

    public AmbienteVendasClienteEnum getAmbientevendas() {
        return ambientevendas;
    }

    public void setAmbientevendas(AmbienteVendasClienteEnum ambientevendas) {
        this.ambientevendas = ambientevendas;
    }

    public CanalVendasClienteEnum getCanalvendas() {
        return canalvendas;
    }

    public void setCanalvendas(CanalVendasClienteEnum canalvendas) {
        this.canalvendas = canalvendas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public int getQuantidadedelojas() {
        return quantidadedelojas;
    }

    public void setQuantidadedelojas(int quantidadedelojas) {
        this.quantidadedelojas = quantidadedelojas;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getOutrasinformacoes() {
        return outrasinformacoes;
    }

    public void setOutrasinformacoes(String outrasinformacoes) {
        this.outrasinformacoes = outrasinformacoes;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
        
}