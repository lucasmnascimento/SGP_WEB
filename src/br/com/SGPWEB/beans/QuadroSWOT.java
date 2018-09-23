package br.com.SGPWEB.beans;

//beans
public class QuadroSWOT {

	private int idquadro;
	private int idcliente;
        private String pontosfortes;
        private String pontosfracos;
        private String ameacas;
        private String oportunidades;
        
       
	public QuadroSWOT() {
	}
	
	
	public QuadroSWOT(int idquadro) {
		this.idquadro = idquadro;
	}

    public QuadroSWOT(int idquadro, int idcliente, String pontosfortes, String pontosfracos, String ameacas, String oportunidades) {
        this.idquadro = idquadro;
        this.idcliente = idcliente;
        this.pontosfortes = pontosfortes;
        this.pontosfracos = pontosfracos;
        this.ameacas = ameacas;
        this.oportunidades = oportunidades;
    }

    public int getIdquadro() {
        return idquadro;
    }

    public void setIdquadro(int idquadro) {
        this.idquadro = idquadro;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getPontosfortes() {
        return pontosfortes;
    }

    public void setPontosfortes(String pontosfortes) {
        this.pontosfortes = pontosfortes;
    }

    public String getPontosfracos() {
        return pontosfracos;
    }

    public void setPontosfracos(String pontosfracos) {
        this.pontosfracos = pontosfracos;
    }

    public String getAmeacas() {
        return ameacas;
    }

    public void setAmeacas(String ameacas) {
        this.ameacas = ameacas;
    }

    public String getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(String oportunidades) {
        this.oportunidades = oportunidades;
    }
        
        

        
}