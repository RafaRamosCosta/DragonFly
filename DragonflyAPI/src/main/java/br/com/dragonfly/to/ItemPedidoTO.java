package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemPedidoTO {
	private int idItemPedido;
	private PedidoTO pedido;
	private ProdutoTO produto;
	private int qtItemPedido;
	
	public ItemPedidoTO() {}

	public ItemPedidoTO(int idItemPedido, PedidoTO pedido, ProdutoTO produto, int qtItemPedido) {
		this.idItemPedido = idItemPedido;
		this.pedido = pedido;
		this.produto = produto;
		this.qtItemPedido = qtItemPedido;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public PedidoTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoTO pedido) {
		this.pedido = pedido;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}

	public int getQtItemPedido() {
		return qtItemPedido;
	}

	public void setQtItemPedido(int qtItemPedido) {
		this.qtItemPedido = qtItemPedido;
	}
	
	
}
