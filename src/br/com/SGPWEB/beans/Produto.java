package br.com.SGPWEB.beans;

import br.com.SGPWEB.entity.StatusEnum;
import br.com.SGPWEB.entity.GeneroEnum;
import br.com.SGPWEB.entity.CategoriaProdutoEnum;
import br.com.SGPWEB.entity.FxClassificacaoEnum;


//beans
public class Produto {

	
	private String nome;
        private int codigo;
        private int cor;
        private FxClassificacaoEnum fxclassificacao;
        private GeneroEnum genero;
        private StatusEnum status;
        private CategoriaProdutoEnum categoria;
        private double valor;
        

	public Produto() {
	}
	
	
	//O c�digo � a sequencia (SQ_PRODUTO) que criamos no SQL Developer
	public Produto(String nome, double valor) {
		this.nome = nome;
                this.valor = valor;
	}

	public Produto(int codigo, String nome, int cor, FxClassificacaoEnum fxclassificacao, GeneroEnum genero, StatusEnum status, CategoriaProdutoEnum categoria, double valor) {
		this.codigo = codigo;
		this.nome = nome;
                this.cor = cor;
                this.fxclassificacao = fxclassificacao;
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

        public FxClassificacaoEnum getClassificacao() {
            return fxclassificacao;
        }

        public void setClassificacao(FxClassificacaoEnum fxclassificacao) {
            this.fxclassificacao = fxclassificacao;
        }

        public GeneroEnum getGenero() {
            return genero;
        }

        public void setGenero(GeneroEnum genero) {
            this.genero = genero;
        }

        public StatusEnum getStatus() {
            return status;
        }

        public void setStatus(StatusEnum status) {
            this.status = status;
        }

        public CategoriaProdutoEnum getCategoria() {
            return categoria;
        }

        public void setCategoria(CategoriaProdutoEnum categoria) {
            this.categoria = categoria;
        }

}
