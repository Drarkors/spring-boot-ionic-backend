package com.estudo.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.estudo.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVenc;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPag;
	
	public PagamentoComBoleto() {
		super();
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVenc, Date dataPag) {
		super(id, estado, pedido);
		this.dataVenc = dataVenc;
		this.dataPag = dataPag;
	}

	public Date getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(Date dataVenc) {
		this.dataVenc = dataVenc;
	}

	public Date getDataPag() {
		return dataPag;
	}

	public void setDataPag(Date dataPag) {
		this.dataPag = dataPag;
	}
	
	
}
