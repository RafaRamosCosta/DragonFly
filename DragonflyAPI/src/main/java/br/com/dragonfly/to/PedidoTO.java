package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PedidoTO {
	private int idPedido;
	private EmpresaTO empresa;
	private String dtPedido;

	public PedidoTO() {
	}

	public PedidoTO(int idPedido,  EmpresaTO empresa, String dtPedido) {
		this.idPedido = idPedido;
		this.empresa = empresa;
		this.dtPedido = dtPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public String getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(String dtPedido) {
		this.dtPedido = dtPedido;
	}

}
