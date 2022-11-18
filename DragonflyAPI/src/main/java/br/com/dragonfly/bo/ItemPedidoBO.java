package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.ItemPedidoDAO;
import br.com.dragonfly.to.ItemPedidoTO;

public class ItemPedidoBO {
	private ItemPedidoDAO itemPDAO = new ItemPedidoDAO();
	
	public String cadastraItem(ItemPedidoTO item) {
		return itemPDAO.inserir(item);
	}
	
	public String alteraItem(ItemPedidoTO item) {
		return itemPDAO.alterar(item);
	}
	
	public String excluiItem(int id) {
		ItemPedidoTO item = new ItemPedidoTO();
		item.setIdItemPedido(id);
		return itemPDAO.excluir(item);
	}
	
	public ArrayList<ItemPedidoTO> listaItens() {
		return itemPDAO.listaItens();
	}
	
	public ItemPedidoTO listaItem(int id) {
		return itemPDAO.listaItem(id);
	}
}
