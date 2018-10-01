package br.com.SGPWEB.beans;
import java.util.Date;
import br.com.SGPWEB.entity.StatusEnum;

//beans
public class Evento {

	private int id_evento;
	private int id_cliente;
        private String nomeevento;
        private String tipo;
        private Date datainicio;
        private Date datafim;
        private Date horainicio;
        private Date horafim;
        private double investimento;
        private String descricao;
        private int vendarealizada;
        private StatusEnum status;
        
       
	public Evento() {
	}
	
	
	//O c�digo � a sequencia (SQ_PRODUTO) que criamos no SQL Developer
	public Evento(int id_evento) {
		this.id_evento = id_evento;
	}

    public Evento(int id_evento, int id_cliente, String nomeevento, String tipo, Date datainicio, Date datafim, Date horainicio, Date horafim, String descricao, double investimento, int vendarealizada, StatusEnum status) {
        this.id_evento = id_evento;
        this.id_cliente = id_cliente;
        this.nomeevento = nomeevento;
        this.tipo = tipo;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.investimento = investimento;
        this.descricao = descricao;
        this.vendarealizada = vendarealizada;
        this.status = status;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNomeevento() {
        return nomeevento;
    }

    public void setNomeevento(String nomeevento) {
        this.nomeevento = nomeevento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafim() {
        return horafim;
    }

    public void setHorafim(Date horafim) {
        this.horafim = horafim;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVendarealizada() {
        return vendarealizada;
    }

    public void setVendarealizada(int vendarealizada) {
        this.vendarealizada = vendarealizada;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
        
        
        
}