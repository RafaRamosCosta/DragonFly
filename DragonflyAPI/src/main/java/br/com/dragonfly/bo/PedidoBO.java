package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.PedidoDAO;
import br.com.dragonfly.to.PedidoTO;

public class PedidoBO {
	PedidoDAO pDAO = new PedidoDAO();
	
	public String cadastraPedido(PedidoTO pedido) {
		pDAO = new PedidoDAO();
		return pDAO.inserir(pedido);
	}
	
	public String alteraPedido(PedidoTO pedido) {
		pDAO = new PedidoDAO();
		return pDAO.alterar(pedido);
	}
	
	public String excluiPedido(PedidoTO pedido) {
		pDAO = new PedidoDAO();
		return pDAO.excluir(pedido);
	}
	
	public ArrayList<PedidoTO> listaPedidos() {
		ArrayList<PedidoTO> pedidos;
		pDAO = new PedidoDAO();
		pedidos = pDAO.listaPedidos();
		return pedidos;
	}
	
	public PedidoTO listaPedido(int id) {
		pDAO = new PedidoDAO();
		return pDAO.listaPedido(id);
	}
	
}
