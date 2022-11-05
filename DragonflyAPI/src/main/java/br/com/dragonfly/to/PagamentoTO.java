package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PagamentoTO {
	private int idPagamento;
	private PedidoTO pedido;
	private FormaPagtoTO formaPagto;
	private EmpresaTO empresa;
	private String dtPagto;
	private float vlTotal;

	public PagamentoTO() {
	}

	public PagamentoTO(int idPagamento, PedidoTO pedido, FormaPagtoTO formaPagto, EmpresaTO empresa, float vlTotal,
			String dtPagto) {
		this.idPagamento = idPagamento;
		this.pedido = pedido;
		this.formaPagto = formaPagto;
		this.empresa = empresa;
		this.vlTotal = vlTotal;
		this.dtPagto = dtPagto;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public PedidoTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoTO pedido) {
		this.pedido = pedido;
	}

	public FormaPagtoTO getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(FormaPagtoTO formaPagto) {
		this.formaPagto = formaPagto;
	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public float getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(float vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getDtPagto() {
		return dtPagto;
	}

	public void setDtPagto(String dtPagto) {
		this.dtPagto = dtPagto;
	}

}
