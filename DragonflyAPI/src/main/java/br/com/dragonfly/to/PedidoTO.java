package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PedidoTO {
	private int idPedido;
	private ProdutoTO produto;
	private EmpresaTO empresa;
	private String dtPedido;
	private int qtProduto;

	public PedidoTO() {
	}

	public PedidoTO(int idPedido, ProdutoTO produto, EmpresaTO empresa, String dtPedido, int qtProduto) {
		this.idPedido = idPedido;
		this.produto = produto;
		this.empresa = empresa;
		this.dtPedido = dtPedido;
		this.qtProduto = qtProduto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
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

	public int getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(int qtProduto) {
		this.qtProduto = qtProduto;
	}

}
