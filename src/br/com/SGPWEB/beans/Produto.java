package br.com.SGPWEB.beans;

//beans
public class Produto {

	
	private String nome;
        private int codigo;
        private int cor;
        private int classificacao;
        private int genero;
        private int status;
        private int categoria;
        private double valor;
        

	public Produto() {
	}
	
	
	//O c�digo � a sequencia (SQ_PRODUTO) que criamos no SQL Developer
	public Produto(String nome, double valor) {
		this.nome = nome;
                this.valor = valor;
	}

	public Produto(int codigo, String nome, int cor, int classificacao, int genero, int status, int categoria, double valor) {
		this.codigo = codigo;
		this.nome = nome;
                this.cor = cor;
                this.classificacao = classificacao;
                this.genero = genero;
                this.status = status;
                this.categoria = categoria;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
        
        public int getCor() {
        return cor;
    }

        public void setCor(int cor) {
            this.cor = cor;
        }

        public int getClassificacao() {
            return classificacao;
        }

        public void setClassificacao(int classificacao) {
            this.classificacao = classificacao;
        }

        public int getGenero() {
            return genero;
        }

        public void setGenero(int genero) {
            this.genero = genero;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCategoria() {
            return categoria;
        }

        public void setCategoria(int categoria) {
            this.categoria = categoria;
        }

}
