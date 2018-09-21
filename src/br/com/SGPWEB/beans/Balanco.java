package br.com.SGPWEB.beans;
import java.util.Date;
//beans
public class Balanco {

	private int idbalanco;
	private int idcliente;
        private Date periodo;
        private String status;
        private Date datainicio; 
       
	public Balanco() {
	}
	
	
	//O c�digo � a sequencia (SQ_PRODUTO) que criamos no SQL Developer
	public Balanco(int idbalanco) {
		this.idbalanco = idbalanco;
	}

    public Balanco(int idbalanco, int idcliente, Date periodo, String status, Date datainicio) {
        this.idbalanco = idbalanco;
        this.idcliente = idcliente;
        this.periodo = periodo;
        this.status = status;
        this.datainicio = datainicio;
    }

    public int getIdbalanco() {
        return idbalanco;
    }

    public void setIdbalanco(int idbalanco) {
        this.idbalanco = idbalanco;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

        
}