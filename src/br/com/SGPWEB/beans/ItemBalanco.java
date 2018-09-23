package br.com.SGPWEB.beans;

//beans
public class ItemBalanco {

	private int iditembalanco;
	private int idbalanco;
        private int idproduto;
        private int quantidadedevenda;
        private int quantidadedeestoque;
        
       
	public ItemBalanco() {
	}
	
	
	public ItemBalanco(int iditembalanco) {
		this.iditembalanco = iditembalanco;
	}

    public ItemBalanco(int iditembalanco, int idbalanco, int idproduto, int quantidadedevenda, int quantidadedeestoque) {
        this.iditembalanco = iditembalanco;
        this.idbalanco = idbalanco;
        this.idproduto = idproduto;
        this.quantidadedevenda = quantidadedevenda;
        this.quantidadedeestoque = quantidadedeestoque;
    }

    public int getIditembalanco() {
        return iditembalanco;
    }

    public void setIditembalanco(int iditembalanco) {
        this.iditembalanco = iditembalanco;
    }

    public int getIdbalanco() {
        return idbalanco;
    }

    public void setIdbalanco(int idbalanco) {
        this.idbalanco = idbalanco;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getQuantidadedevenda() {
        return quantidadedevenda;
    }

    public void setQuantidadedevenda(int quantidadedevenda) {
        this.quantidadedevenda = quantidadedevenda;
    }

    public int getQuantidadedeestoque() {
        return quantidadedeestoque;
    }

    public void setQuantidadedeestoque(int quantidadedeestoque) {
        this.quantidadedeestoque = quantidadedeestoque;
    }
    
}